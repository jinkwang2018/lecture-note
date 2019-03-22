package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import kr.or.kosta.dto.board;
import kr.or.kosta.dto.reply;

public class boarddao {
	// DB연결 ...
	// method 공통 사용 ....
	// 초기자 { } static 초기자 : static{ }
	static DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	static {
		InitialContext ctx;
		try {
			/*
			 * Context context = new InitialContext(); DataSource datasource =
			 * (DataSource)context.lookup("java:comp/env/jdbc/oracle"); conn =
			 * datasource.getConnection();
			 */
			ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("/jdbc/oracle");
			System.out.println("DataSource 객체 생성 성공 !");
		} catch (NamingException e) {
			System.out.println("lookup Fail : " + e.getMessage());
		}
	}

	// jspboard (CRUD) 구현 하는 함수
	// select > 객체(DTO) 담는다 > return board ,
	// insert , update , delete > return 반영된 row
	// 객체 받는 선택

	// jspboard insert 함수 (원본 글쓰기)
	public int writeok(board boardata) throws Exception {
		try {
			conn = ds.getConnection();
			String sql = "insert into jspboard(idx,writer,pwd,subject,content,email,homepage,writedate,readnum,filename,filesize,refer) values("
					+ " jspboard_idx.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, boardata.getWriter());
			pstmt.setString(2, boardata.getPwd());
			pstmt.setString(3, boardata.getSubject());
			pstmt.setString(4, boardata.getContent());
			pstmt.setString(5, boardata.getEmail());
			pstmt.setString(6, boardata.getHomepage());
			pstmt.setString(7, boardata.getFilename());

			// 계층형 게시판
			// refer , depth , step
			// 1.원본글 : refer , depth(0) , step(0)
			// 2.답변글 : refer , depth(값이) , step(값이)

			// refer 설정규칙 : idx 동일 ( +1)
			int refer_max = getMaxRefer(conn);
			int refer = refer_max + 1;
			// int depth = 0;
			// int step = 0;
			pstmt.setInt(8, refer);

			int row = pstmt.executeUpdate();
			return row;

		} /*
		 * catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */finally {
			// System.out.println("close");
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close(); // pool conn 객체반환
		}

	}

	// 글 참조 번호 함수
	public int getMaxRefer(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int refer_max = 0;
		try {
			String maxRefer_sql = "select nvl(max(refer),0) from jspboard";
			pstmt = conn.prepareStatement(maxRefer_sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("rs_next :" + rs.getInt(1));
				refer_max = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			// if(conn != null) conn.close(); //pool conn 객체반환
			return refer_max;
		}

	}

	// jspboard select 함수 (목록 list)
	// [1] [2] [3] [4] [5] [다음]
	// [이전] [6] [7] [8] [9] [10] [다음]
	// [이전] [11] [12]
	public List<board> list(int cpage, int pagesize) throws Exception {
		// 게시물 목록 가져오기
		// 1. 일반게시판
		// => select * from jspboard order by idx desc (나중글이 최신글)
		// 2. 계층형(답현) 게시판

		/*
		 * 아래 2개의 계층형 페이징처리 쿼리 테스트 하기 SELECT * FROM ( SELECT ROWNUM rn , idx ,
		 * writer , email, homepage, pwd , subject , content, writedate, readnum
		 * , filename, filesize , refer , depth , step FROM ( SELECT * FROM
		 * jspboard ORDER BY refer DESC , step ASC ) ) WHERE rn BETWEEN 4 AND 6;
		 * --
		 * --------------------------------------------------------------------
		 * ------------------------- select * from ( select rownum rn , idx ,
		 * writer , email, homepage, pwd , subject , content, writedate, readnum
		 * , filename, filesize , refer , depth , step from ( SELECT * FROM
		 * jspboard ORDER BY refer DESC , step ASC ) where rownum <= 6 --endrow
		 * ) where rn >= 4; --firstrow
		 */
		List<board> list = null;
		try {
			conn = ds.getConnection();
			String sql = " SELECT * FROM "
					+ "( SELECT ROWNUM rn , idx , writer , email, homepage, pwd , subject , content, writedate, "
					+ " readnum , filename, filesize , refer , depth , step "
					+ " FROM (	SELECT * FROM jspboard ORDER  BY refer DESC , step ASC  ) "
					+ " ) WHERE rn BETWEEN ? AND ? ";

			// int cpage , int pagesize
			// cpage = currentpage [1] [2] [3]
			// pagesize = 5건씩 , 10건씩

			// pageing 1. 전체 게시물 건수 : 100 (얻어오기)
			// 2. pagesize 설정 : 5 , 10 > 10설정 > totalpagecount 구해지는 값

			// 현재 데이터 100건 :
			// cpage : 1 , pagesize : 5 // start : 1 , end : 5
			// cpage : 2 , pagesize : 5 // start : 6 , end : 10

			// cpage : 11 , pagesize : 5 // start : 51 , end : 55

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<board>();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String homepage = rs.getString("homepage");
				String pwd = rs.getString("pwd");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				java.sql.Date writedate = rs.getDate("writedate");
				int readnum = rs.getInt("readnum");
				String filename = rs.getString("filename");
				int filesize = rs.getInt("filesize");

				int refer = rs.getInt("refer");
				int depth = rs.getInt("depth");
				int step = rs.getInt("step");

				board boarddto = new board(idx, writer, pwd, subject, content,
						email, homepage, writedate, readnum, filename,
						filesize, refer, depth, step);
				list.add(boarddto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			conn.close();
			return list;
			
		}
	}

	//게시물 총 건수 구하기
	public int totalboardCount() throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql = "select count(*) cnt from jspboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int totalcount = 0;
			if(rs.next()){
				totalcount = rs.getInt("cnt");
			}
			return totalcount;
		}/*catch(Exception e){
			
		}*/finally{
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if(rs != null)try {rs.close();} catch (SQLException e) {}
			if(conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
	}
	
	//게시물 상세 보기(글번호)
	public board getContent(int idx) throws SQLException{
			 try{
					conn = ds.getConnection();
					String sql ="select * from jspboard where idx=?";
				  	pstmt = conn.prepareStatement(sql);
				  	pstmt.setInt(1, idx);
				  			  	
					rs =pstmt.executeQuery();
				    
					if(rs.next()){
						String writer = rs.getString("writer");
						String email = rs.getString("email");
						String homepage = rs.getString("homepage");
						String pwd = rs.getString("pwd");
						String subject = rs.getString("subject");
						String content = rs.getString("content");
						
						
						java.sql.Date writedate = rs.getDate("writedate");
						int readnum = rs.getInt("readnum");
						String filename = rs.getString("filename");
						int filesize = rs.getInt("filesize");
						
						int refer = rs.getInt("refer");
						int depth = rs.getInt("depth");
						int step = rs.getInt("step");
					
						board boardDTO = new board(idx, writer, pwd, subject, content, email, homepage, writedate, readnum, filename, filesize, refer, depth, step);
						return boardDTO;
					}
				   return null;
			 	}
			    finally{
			    	if(pstmt !=null)pstmt.close();
			    	if(rs !=null) rs.close();
			    	if(conn !=null)conn.close();
			    }
		}	
	//답글 쓰기 처리
	public int reWriteOk(board boardata) throws SQLException{
			try{
				conn = ds.getConnection();
				//사용자 입력값 처리
				int idx = boardata.getIdx(); //추가
				String writer = boardata.getWriter();
				String email = boardata.getEmail();
				String homepage = boardata.getHomepage();
				String pwd = boardata.getPwd();
				String subject = boardata.getSubject();
				String content = boardata.getContent();
				String filename = boardata.getFilename();
				int filesize = 0;
				
				//답글  쿼리
				//1. 현재 원본글(답변처리) 글에 대한 refer , depth , step
				String refer_depth_step_sql = "select refer , depth , step from jspboard where idx=?";
				
				//2. 여러개의 답변글이 들어오는 경우 refer 정렬되는 순서를 정의 (step ) 처리
				//logic 는 정의하기 나름
				String step_update_sql = "update jspboard set step=step+1 where step > ? and refer=?";
				
				//3. 실 답변글 insert 처리하기
				String rewrite_sql = "insert into jspboard(idx,WRITER,EMAIL,HOMEPAGE, PWD,SUBJECT,CONTENT,READNUM,FILENAME ,FILESIZE ,REFER ,DEPTH ,STEP) values(" +
				           " jspboard_idx.nextval,?,?,?,?,?,?,?,?,0,?,?,?)";
				
				//refer , depth , step 값 가져오기
				pstmt = conn.prepareStatement(refer_depth_step_sql);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					int refer = rs.getInt("refer");
					int step = rs.getInt("step");
					int depth = rs.getInt("depth");
					
					//step () 값 업데이트
				
					pstmt = conn.prepareStatement(step_update_sql);
					pstmt.setInt(1, step);
					pstmt.setInt(2, refer);
					pstmt.executeUpdate();
					
				    //실 데이터 insert 
					//jspboard_idx.nextval,?,?,?,?,?,?,?,?,0,?,?,?
					      
					                  
					pstmt = conn.prepareStatement(rewrite_sql);
					pstmt.setString(1, writer);
					pstmt.setString(2, email);
					pstmt.setString(3, homepage);
					pstmt.setString(4, pwd);
					pstmt.setString(5, subject);
					pstmt.setString(6,content);
					pstmt.setInt(7, 0);
					//첨부파일
					pstmt.setString(8, filename);
					//답변형
					pstmt.setInt(9, refer);
					pstmt.setInt(10, depth+1);   //답글 처리
					pstmt.setInt(11, step+1); //답글처리 (현재 읽은 글보다 큰 순번은 + 1)
					
					int row = pstmt.executeUpdate();
					return row;
				}else{
					return -1;
				}
					
			}finally{
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				if(conn != null) conn.close();
			}
			
		}
	
		//답변형 게시판 글 삭제하기
		//1.원본글(답변이 있는 글)
		//2.원본글(답변이 없는 글)
		
		//1.case : 원본글 삭제시 답변글이 있으면 다 삭제
		//2.case : 답변글이 있는 원본글이 삭제시 삭제 하지 못하게
		//3.case : 원본글(답변이 없으면 삭제) 있으면 원본글만 삭제
		//4.case : 게시판 컬럼 (delok) : 1(기본값)  -> 삭제 =>0 
		//5.case : 네이버 원본글 삭제 -> 나머지 글들은 텍스트 형태(원본글삭제 표시)
		//6.case : 덧글이 있는 경우 같이 삭제
		public int deleteOk(String idx , String pwd) throws SQLException{
		
			try{
				conn = ds.getConnection();
				//비번 검증
				String sel_pwd_sql="select pwd from jspboard where idx=?";
				//덧글 삭제 (참조 제약 관계) 
				String del_reply_sql="delete from reply where idx_fk=?";
				//게시글 삭제
				String del_board_sql="delete from jspboard where idx=?";
							
				pstmt = conn.prepareStatement(sel_pwd_sql);
				pstmt.setString(1, idx);
				rs =pstmt.executeQuery();
				if(rs.next()){
					String dbpwd = rs.getString("pwd");
					if(pwd.equals(dbpwd)){
						//실제 삭제 처리
						//문제점 : 삭제처리에서 논리적으로 두개의 삭제는 (둘다 삭제 , 둘다 삭제(x)
						//하나의 논리적 단위로 처리 
						conn.setAutoCommit(false); // ... rollback , commit 처리 강제
						
							//덧글 삭제
							pstmt = conn.prepareStatement(del_reply_sql);
							pstmt.setString(1, idx);
							pstmt.executeUpdate();
							
							//게시글 삭제
							pstmt = conn.prepareStatement(del_board_sql);
							pstmt.setString(1, idx);
							int row =pstmt.executeUpdate();
							
							if(row > 0){
								conn.commit(); //정상처리
							}else{
								conn.rollback();
							}
							
						return row;
					}else{
						return 0;
					}
				}else{
					return -1;
				}
				
			}finally{
				if(pstmt !=null)pstmt.close();
		    	if(rs !=null) rs.close();
		    	if(conn !=null)conn.close();
			}
		}
		//게시물 편집하기 상세보기(글번호)
		public board getEditContent(String idx) throws SQLException{
		   return this.getContent(Integer.parseInt(idx));
		}
		//게시글 수정하기
		public int boardedit(HttpServletRequest boardata) throws SQLException{
			try{
				
				//사용자 수정값 받아오기
				String idx = boardata.getParameter("idx");
				String pwd = boardata.getParameter("pwd");
				String writer = boardata.getParameter("writer");
				String email = boardata.getParameter("email");
				String homepage = boardata.getParameter("homepage");
				String subject = boardata.getParameter("subject");
				String content = boardata.getParameter("content");
				String filename = boardata.getParameter("filename");
				
				System.out.println(idx + "/ " + pwd + "/ " + writer);
				
				
				conn = ds.getConnection();
				String select_idx_sql="select idx from jspboard where idx=? and pwd=?";
				String update_board_sql="update jspboard set writer=?,email=?,homepage=? ," +
						                " subject=?,content=?,filename=? where idx=?";
				pstmt = conn.prepareStatement(select_idx_sql); 
				pstmt.setString(1, idx);
				pstmt.setString(2, pwd);
				
				rs = pstmt.executeQuery();
				if(rs.next()){
					pstmt = conn.prepareStatement(update_board_sql);
					pstmt.setString(1, writer);
					pstmt.setString(2, email);
					pstmt.setString(3, homepage);
					pstmt.setString(4, subject);
					pstmt.setString(5, content);
					pstmt.setString(6, filename);
					pstmt.setString(7, idx);
					
					int row = pstmt.executeUpdate();
					return row;
					}	
				return -1;
				}
				finally{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			
		}
		
		//게시물 조회수 증가하기
		public boolean getReadnum(String idx) throws SQLException{
			 try{
					conn = ds.getConnection();
					String sql ="update jspboard set readnum=readnum+1 where idx=?";
				  	pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, idx);
					int row =pstmt.executeUpdate();
					
					if(row > 0){
						return true;
					}else{
						return false;
					}
				    
			 	}
			    finally{
			    	if(pstmt !=null)pstmt.close();
			    	if(rs !=null) rs.close();
			    	if(conn !=null)conn.close();
			    }
		}	
	//**reply 덧글 입력하기
	//어느 게시글의 덧글이냐 : 현재 보고있는 글의 글번호
	public int replywrite(int idx_fk , String writer, 
			           String userid, String content , String pwd ) throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql ="insert into reply(no, writer, userid, content ,pwd ,idx_fk ) values (" +
			            " reply_no.nextval,? ,? ,?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, userid);
			pstmt.setString(3, content);
			pstmt.setString(4, pwd);
			pstmt.setInt(5, idx_fk);
			
			int row = pstmt.executeUpdate();
			return row;
			
		}/*catch(Exception e){
			
		}*/finally{
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close(); // pool conn 객체반환
		}
	}
	
	
	//**reply 덧글 리스트
	public List<reply> replylist(String idx_fk) throws SQLException{

		  try{
				conn = ds.getConnection();
				String reply_sql ="select * from reply where idx_fk=? order by no desc";
				
				pstmt = conn.prepareStatement(reply_sql);
				pstmt.setString(1, idx_fk);
			
				 rs =pstmt.executeQuery();
			    
			    ArrayList<reply> list = new ArrayList<reply>();
				while(rs.next()){
					int no = Integer.parseInt(rs.getString("no"));
					String writer = rs.getString("writer");
					String userid = rs.getString("userid");
					String pwd = rs.getString("pwd");
					String content = rs.getString("content");
					java.sql.Date writedate = rs.getDate("writedate");
					int idx = Integer.parseInt(rs.getString("idx_fk"));
		            
					reply replyDTO = new reply(no, writer, userid, pwd, content, writedate, idx);
					
					list.add(replyDTO);
				}
				return list;	
		    }finally{
		    	if(pstmt !=null)pstmt.close();
		    	if(rs !=null) rs.close();
		    	if(conn !=null)conn.close();
		    }
	}

	//덧글 삭제하기 (덧글 번호(키) , 비번)
	public int replyDelete(String no , String pwd) throws SQLException{
			
			try{
				//String sql = "delete from reply where no=? and pwd =?"
				String replyselect ="select pwd from reply where no=?";
				//가지고 온 pwd 값 parameter 받은 pwd 일치하면 삭제 처리
				String replydelete = "delete from reply where no=?";
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(replyselect);
				pstmt.setString(1, no);
				rs =pstmt.executeQuery();
				if(rs.next()){
					String dbpwd = rs.getString("pwd");
					if(pwd.equals(dbpwd)){
						//실제 삭제 처리
						pstmt = conn.prepareStatement(replydelete);
						pstmt.setString(1, no);
						int row = pstmt.executeUpdate();
						return row;
					}else{
						return 0;
					}
				}else{
					return -1;
				}
				
			}finally{
				if(pstmt !=null)pstmt.close();
		    	if(rs !=null) rs.close();
		    	if(conn !=null)conn.close();
			}
		}

}







