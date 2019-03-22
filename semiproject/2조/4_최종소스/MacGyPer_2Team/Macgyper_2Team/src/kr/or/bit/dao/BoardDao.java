package kr.or.bit.dao;

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

import kr.or.bit.dto.BoardDto;
import kr.or.bit.dto.ReplyDto;

public class BoardDao {
	static DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	static {
		InitialContext ctx;
		try {
			
			ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("/jdbc/oracle");
			System.out.println("DataSource 객체 생성 성공 !");
		} catch (NamingException e) {
			System.out.println("lookup Fail : " + e.getMessage());
		}
	}
	
	public int writeok(BoardDto boardata) throws Exception {
		try {
			conn = ds.getConnection();
			String sql = "insert into shareboard(idx,id,board_title,board_content,board_date,board_count,board_filename,refer) values("
					+ " shareboard_idx.nextval,?,?,?,sysdate,0,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardata.getId());
			pstmt.setString(2, boardata.getBoard_title());
			pstmt.setString(3, boardata.getBoard_content());
			pstmt.setString(4, boardata.getBoard_filename());

			int refer_max = getMaxRefer(conn);
			int refer = refer_max + 1;
			
			pstmt.setInt(5, refer);

			int row = pstmt.executeUpdate();
			return row;

		} 
		 finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

	}
	
	// 글 참조 번호 함수
	public int getMaxRefer(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int refer_max = 0;
		try {
			String maxRefer_sql = "select nvl(max(refer),0) from shareboard";
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
		}
		return refer_max;

	}

	public List<BoardDto> list(int cpage, int pagesize) throws Exception {
	
		List<BoardDto> list = null;
		try {
			conn = ds.getConnection();
			String sql = " SELECT * FROM "
					+ "( SELECT ROWNUM rn , idx , id , board_title , board_content, board_date, "
					+ " board_count , board_filename, refer , depth , step "
					+ " FROM (	SELECT * FROM shareboard ORDER  BY refer DESC , step ASC  ) "
					+ " ) WHERE rn BETWEEN ? AND ? ";

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			list = new ArrayList<BoardDto>();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				java.sql.Date board_date = rs.getDate("board_date");
				int board_count = rs.getInt("board_count");
				String board_filename = rs.getString("board_filename");
				int refer = rs.getInt("refer");
				int depth = rs.getInt("depth");
				int step = rs.getInt("step");

				BoardDto boarddto = new BoardDto(idx,id,board_title, board_content,
						board_date, board_count, board_filename,
						refer, depth, step);
				list.add(boarddto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			conn.close();
		}
		return list;
	}

	//게시물 총 건수 구하기
	public int totalboardCount() throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql = "select count(*) cnt from shareboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int totalcount = 0;
			if(rs.next()){
				totalcount = rs.getInt("cnt");
			}
			return totalcount;
		}finally{
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if(rs != null)try {rs.close();} catch (SQLException e) {}
			if(conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
	}
	
	

	public List<BoardDto> listSearch(int cpage, int pagesize, String search) throws Exception {
		List<BoardDto> list = null;
		try {
			conn = ds.getConnection();
			String sql = " SELECT * FROM "
					+ "( SELECT ROWNUM rn , idx , id , board_title , board_content, board_date, "
					+ " board_count , board_filename, refer , depth , step "
					+ " FROM (	SELECT * FROM shareboard ORDER  BY refer DESC , step ASC  ) "
					+ " ) WHERE (rn BETWEEN ? AND ?) AND board_title like ? ";

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, "%"+search+"%");
			rs = pstmt.executeQuery();

			list = new ArrayList<BoardDto>();
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				java.sql.Date board_date = rs.getDate("board_date");
				int board_count = rs.getInt("board_count");
				String board_filename = rs.getString("board_filename");

				int refer = rs.getInt("refer");
				int depth = rs.getInt("depth");
				int step = rs.getInt("step");
				BoardDto boarddto = new BoardDto(idx,id,board_title, board_content,
						board_date, board_count, board_filename,
						refer, depth, step);
				list.add(boarddto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			conn.close();
			
			
		}
		return list;
	}
	
	//검색한 게시물 총 건수 구하기
	public int searchTotalBoardCount(String seStr) throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql = "select count(*) cnt from shareboard where board_title like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+seStr+"%");
			rs = pstmt.executeQuery();
			int totalcount = 0;
			if(rs.next()){
				totalcount = rs.getInt("cnt");
			}
			return totalcount;
		}finally{
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if(rs != null)try {rs.close();} catch (SQLException e) {}
			if(conn != null)try {conn.close();} catch (SQLException e) {}
		}
		
	}
	
	//게시물 상세 보기(글번호)
	public BoardDto getContent(int idx) throws SQLException{
			 try{
					conn = ds.getConnection();
					String sql ="select * from shareboard where idx=?";
				  	pstmt = conn.prepareStatement(sql);
				  	pstmt.setInt(1, idx);
				  			  	
					rs =pstmt.executeQuery();
				    
					if(rs.next()){
						String writer = rs.getString("id");
						String subject = rs.getString("board_title");
						String content = rs.getString("board_content");	
						java.sql.Date writedate = rs.getDate("board_date");
						int readnum = rs.getInt("board_count");
						String filename = rs.getString("board_filename");
						
						int refer = rs.getInt("refer");
						int depth = rs.getInt("depth");
						int step = rs.getInt("step");
					
						BoardDto BoardDto = new BoardDto(idx, writer, subject, content, writedate, readnum, filename, refer, depth, step);
						return BoardDto;
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
	public int reWriteOk(BoardDto boardata) throws SQLException{
			try{
				conn = ds.getConnection();
				int idx = boardata.getIdx(); //추가
				String writer = boardata.getId();
				String subject = boardata.getBoard_title();
				String content = boardata.getBoard_content();
				String filename = boardata.getBoard_filename();
			
				String refer_depth_step_sql = "select refer , depth , step from shareboard where idx=?";
				String step_update_sql = "update shareboard set step=step+1 where step > ? and refer=?";
				String rewrite_sql = "insert into shareboard(idx,id,board_title,board_content,board_count,board_filename,REFER ,DEPTH ,STEP) values(" +
				           " shareboard_idx.nextval,?,?,?,?,?,?,?,?)";
				
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
					
					pstmt = conn.prepareStatement(rewrite_sql);
					pstmt.setString(1, writer);
					pstmt.setString(2, subject);
					pstmt.setString(3, content);
					pstmt.setInt(4, 0);
					//첨부파일
					pstmt.setString(5, filename);
					//답변형
					pstmt.setInt(6, refer);
					pstmt.setInt(7, depth+1);   //답글 처리
					pstmt.setInt(8, step+1); //답글처리 (현재 읽은 글보다 큰 순번은 + 1)
					
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
	
		public int deleteOk(String idx, String id) throws SQLException{
		
			try{
				conn = ds.getConnection();
				//아이디(작성자) 검증
				String sel_pwd_sql="select id from shareboard where idx=?";
				//덧글 삭제 (참조 제약 관계) 
				String del_reply_sql="delete from reply where idx=?";
				//게시글 삭제
				String del_board_sql="delete from shareboard where idx=?";
							
				pstmt = conn.prepareStatement(sel_pwd_sql);
				pstmt.setString(1, idx);
				rs =pstmt.executeQuery();
				if(rs.next()){
					String dbpwd = rs.getString("id");
					if( ( (id.equals(dbpwd)) || (id.equals("admin")) ) ){
							conn.setAutoCommit(false); 
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
		public BoardDto getEditContent(String idx) throws SQLException{
		   return this.getContent(Integer.parseInt(idx));
		}
		
		//게시글 수정하기
		public int boardedit(HttpServletRequest boardata) throws SQLException{
			try{
				String idx = boardata.getParameter("idx");
				String writer = boardata.getParameter("id");
				String subject = boardata.getParameter("board_title");
				String content = boardata.getParameter("board_content");
				String filename = boardata.getParameter("board_filename");
				
				conn = ds.getConnection();
				String select_idx_sql="select idx from shareboard where idx=?  ";
				String update_board_sql="update shareboard set id=?," +
						                " board_title=?,board_content=?,board_filename=? where idx=?";
				pstmt = conn.prepareStatement(select_idx_sql); 
				pstmt.setString(1, idx);
				
				rs = pstmt.executeQuery();
				if(rs.next()){
					pstmt = conn.prepareStatement(update_board_sql);
					pstmt.setString(1, writer);
					pstmt.setString(2, subject);
					pstmt.setString(3, content);
					pstmt.setString(4, filename);
					pstmt.setString(5, idx);
					
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
					String sql ="update shareboard set board_count=board_count+1 where idx=?";
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

	public int replywrite(int idx, String writer, String content) throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql ="insert into reply(no, id, reply_content, idx ) values (" +
			            " reply_no.nextval,? ,? ,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);
			
			int row = pstmt.executeUpdate();
			return row;
			
		}finally{
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close(); 
		}
	}
	
	public List<ReplyDto> replylist(String idx_fk) throws SQLException{

		  try{
				conn = ds.getConnection();
				String reply_sql ="select * from reply where idx=? order by no desc";
				
				pstmt = conn.prepareStatement(reply_sql);
				pstmt.setString(1, idx_fk);
			
				rs =pstmt.executeQuery();
			    System.out.println("replylist 까지 들어옴요?");
			    ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
				while(rs.next()){
					int no = Integer.parseInt(rs.getString("no"));
					String writer = rs.getString("id");
					String content = rs.getString("reply_content");
					String writedate = rs.getString("reply_date");
					int idx = Integer.parseInt(rs.getString("idx"));
		            
					ReplyDto ReplyDto = new ReplyDto(no, writer, content, writedate, idx);
					
					list.add(ReplyDto);
					System.out.println("여기는욥??");
				}
				return list;	
		    }finally{
		    	if(pstmt !=null)pstmt.close();
		    	if(rs !=null) rs.close();
		    	if(conn !=null)conn.close();
		    }
	}
	
	//덧글 삭제하기 (덧글 번호(키) , 비번)
	public int replyDelete(String no, String id) throws SQLException{
			
			try{
				String replyselect ="select id from reply where no=?";
				String replydelete = "delete from reply where no=?";
				
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(replyselect);
				pstmt.setString(1, no);
				rs =pstmt.executeQuery();
				if(rs.next()){
					String dbpwd = rs.getString("id");
					if( ( (id.equals(dbpwd)) || (id.equals("admin")) ) ){
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