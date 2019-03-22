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

//CRUD > connection pool > 함수 단위 연결  > 반드시 반환 > close()
public class boarddao {

	DataSource ds = null;
	
	public boarddao() throws NamingException {
		Context context = new InitialContext();
		//JNDI 
		//context : container(was) 안에서 이름기반으로 검색 제공
		ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		
	}
	
	//게시물 목록 구하기
	public List<board> list(int cpage , int pagesize){
		
		//[1][2][3][4][5][다음]
		//[이전][6][7][8][9][10][다음]
		//[이전][11]
		
		//totaldata > 54 건
		//pagesize = 5
		//totalpagecount = 11 (전체 페이지 개수 )
		
		//int cpage > currentpage  2번째 , 10번째 
		
		//현재 데이터 100건
		//cpage : 1  , pagesize : 5 // start :1번글 ~ end: 5
		//cpage : 2  , pagesize : 5 // start :6번글 ~ end: 10
		//cpage : 11  , pagesize : 5 // start :51 ~ end: 55
		
		//5개씩 묶어서  11번째 페이지를 데이터를 주세요 ^^
		
		/*
		    * 아래 2개의 계층형 페이징처리 쿼리 테스트 하기 
		    * SELECT * FROM ( SELECT ROWNUM rn , idx ,
		    * writer , email, homepage, pwd , subject , content, writedate, readnum
		    * , filename, filesize , refer , depth , step FROM ( SELECT * FROM
		    * jspboard ORDER BY refer DESC , step ASC ) ) WHERE rn BETWEEN ? AND ?;
		    * 
		    * --------------------------------------------------------------------
		    *  select * from ( select rownum rn , idx ,
		    *  writer , email, homepage, pwd , subject , content, writedate, readnum
		    * , filename, filesize , refer , depth , step from ( SELECT * FROM
		    * jspboard ORDER BY refer DESC , step ASC ) where rownum <= 6 --endrow
		    * ) where rn >= 4; --firstrow
		    */
		
		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<board> list = null;
		try {
			
			conn = ds.getConnection();
			String sql= 	"select * from " + 
						    "( select rownum rn , idx , writer , email, homepage, pwd , subject , content, writedate, readnum " +
							       " , filename, filesize , refer , depth , step " + 
					            " from ( "+
					                     " SELECT * FROM " +
							             " jspboard ORDER BY refer DESC , step ASC " + 
					                 " ) where rownum <= ? " +  //5
							") where rn >= ?";  //1
			pstmt = conn.prepareStatement(sql);
			
			int start = cpage * pagesize - (pagesize -1)  ; //공식  1 * 5 - (5-1)
			int end = cpage * pagesize;  //공식  1 * 5 
			
			pstmt.setInt(1, end);  //5  rownum <= ?
			pstmt.setInt(2, start);//1   rn >= ?
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rs.next()) {
				//순번	제목	  글쓴이	날짜	조회수
				board b = new board(); //dto 객체 생성
				b.setIdx(rs.getInt("idx"));
				b.setSubject(rs.getString("subject"));
				b.setWriter(rs.getString("writer"));
				b.setWritedate(rs.getDate("writedate"));
				b.setReadnum(rs.getInt("readnum"));
				
				//계층형 (의무)
				b.setRefer(rs.getInt("refer"));
				b.setStep(rs.getInt("step"));
				b.setDepth(rs.getInt("depth"));

				list.add(b); //ArrayList 에 add() pagesize=5  >> 5건 (board 객체) add  
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return list;
	}
	
	//게시물 총 건수 구하기
	public int totalboardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalcount = 0;
		try {
			conn = ds.getConnection(); //dbcp 연결객체 얻기
			String sql="select count(*) cnt from jspboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		}catch (Exception e) {
			
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환  connection pool 에 반환하기
			}catch (Exception e) {
				
			}
		}
		
		
		return totalcount;
	}
	
	//게시물 원본 글쓰기 * [참조값 만들기 refer 값 생성 ...]
	public int writeok(board boardata) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
				conn = ds.getConnection();
				String sql ="insert into jspboard(idx,writer,pwd,subject,content,email,homepage,writedate,readnum,filename,filesize,refer)" + 
						    " values(jspboard_idx.nextval,?,?,?,?,?,?,sysdate,0,?,0,?)";
			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,boardata.getWriter());
				pstmt.setString(2,boardata.getPwd());
				pstmt.setString(3,boardata.getSubject());
				pstmt.setString(4,boardata.getContent());
				pstmt.setString(5,boardata.getEmail());
				pstmt.setString(6,boardata.getHomepage());
				pstmt.setString(7,boardata.getFilename());
				
				//계층형 게시판
				//refer , step , depth
				//1. 원본글 : refer , step(0) default, depth(0) default
				//2. 답변글 : refer , step(규칙) , depth(규칙)
				
				int refermax = getMaxRefer();
				int refer = refermax + 1;
				pstmt.setInt(8, refer); 
				
				row = pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		
		return row;
	}
	
	//게시물 답글에 대한 참조값 얻기 *
	public int getMaxRefer() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int refer_max = 0;
		try {
			conn = ds.getConnection();
			String sql= "select nvl(max(refer),0) from jspboard";
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery();
			if(rs.next()) {
				refer_max = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
			
		}
		return refer_max;
	}
	
	//게시물 상세보기
	public board getContent(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		board boarddto = null;
		
		try {
			conn = ds.getConnection();
			String sql ="select * from jspboard where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
				
				//계층형
				int refer = rs.getInt("refer");
				int step = rs.getInt("step");
				int depth = rs.getInt("depth");
				
				boarddto = new board(idx, writer, pwd, subject, content, writedate, readnum, filename, filesize, homepage, email, refer, depth, step);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return boarddto;
	}
	
	//게시글 조회수 증가
	public boolean getReadNum(String idx) {
		//update jspboard set readnum = readnum + 1 where idx=?
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			String sql="update jspboard set readnum = readnum + 1 where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			
			int row = pstmt.executeUpdate();
			if(row > 0 ) {
				result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		return result;
	}
	
	//게시물 답글 쓰기
	public int reWriteOk(board boardata) {
		//content.jsp ->(답글)-> rewrite.jsp(입력) -> submit() -> rewriteok.jsp 
		//게시물 글쓰기(INSERT > 답글 ....) : refer , step , depth
		//내가 답글을 달려하는 하는 글의  글번호가 필요해요
		
		//refer , step , depth 설정을 하려면 기존 정보(read 글)
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ds.getConnection();
			
			int idx = boardata.getIdx(); //현재 읽은 글의 글번호
			
			String writer = boardata.getWriter();
			String email = boardata.getEmail();
			String homepage = boardata.getHomepage();
			String pwd = boardata.getPwd();
			String subject = boardata.getSubject();
			String content = boardata.getContent();
			String filename = boardata.getFilename();
			int filesize = 0;
			
			//1. 답글 
			//현재 내가 읽은 글의 refer , depth , step
			String refer_depth_step_sal ="select refer , depth , step from jspboard where idx=?";
			
			//2. 위치
			//step (순서) : 나중에 쓴 답글이 위로 올라오게 하겠다
			//내가 읽은 글의 step 보다 큰 값은 +1 해서 증가 시켜 놓는다
			//refer 값으로 판단
			//ex) 원본글     refer=1 , step=0 , depth=0 
		    //      답글    refer=1 , step=1+1 > 2 , depth=1
			//   원본들답글  refer=1 , step=1 , depth=1
			String step_update_sql = "update jspboard set step= step+1 where step  > ? and refer =? ";
			// "update jspboard set step= step+1 where step  > 0 and refer =1 ";
			
			//답글  insert 
			String rewrite_sql="insert into jspboard(idx,writer,pwd,subject,content,email,homepage,writedate,readnum,filename,filesize,refer,depth,step)" + 
				    		   " values(jspboard_idx.nextval,?,?,?,?,?,?,sysdate,0,?,0,?,?,?)";
			
			pstmt = conn.prepareStatement(refer_depth_step_sal);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int refer = rs.getInt("refer");
				int step = rs.getInt("step");
				int depth = rs.getInt("depth");
				
				pstmt = conn.prepareStatement(step_update_sql);
				pstmt.setInt(1, step);
				pstmt.setInt(2, refer);
				pstmt.executeUpdate();

				//filename,filesize,refer,depth,step
				pstmt = conn.prepareStatement(rewrite_sql);
				pstmt.setString(1, writer);
				pstmt.setString(2,pwd);
				pstmt.setString(3, subject);
				pstmt.setString(4, content);
				pstmt.setString(5, email);
				pstmt.setString(6, homepage);
				pstmt.setString(7, filename);
				
				//답변
				pstmt.setInt(8, refer);
				pstmt.setInt(9, depth+1); // 규칙 현재 읽은 글에 depth + 1
				pstmt.setInt(10, step+1); // 순서 update 통해서  자리 확보 + 1
				
				int row = pstmt.executeUpdate();
				if(row > 0) {
					result = row;
				}else {
					result = -1;
				}

			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return result;
	}
	
	//게시글 삭제 하기
	public int deleteok(String idx , String pwd) throws SQLException {
		//답변형 게시판 글 삭제하기
		//1.원본글(답변이 있는 글) 고민
				
		//2.원본글(답변이 없는 글) 그냥 삭제 
				
		//1.case : 원본글 삭제시 답변글이 있으면 다 삭제 (같은 refer delete)
		//2.case : 답변글이 있는 원본글이 삭제시 삭제 하지 못하게 (refer count > 1 )
		//3.case : 원본글(답변이 없으면 삭제) 있으면 원본글만 삭제  
		//4.case : 게시판 컬럼 (delok) : 1(기본값)  -> 삭제 => update > 0 
		//5.case : 네이버 원본글 삭제 -> 나머지 글들은 텍스트 형태(원본글삭제 표시)
		//6.case : 덧글이 있는 경우 같이 삭제
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
				conn = ds.getConnection();
				//비인증형 게시판 (비번 입력)
				//삭제 -> 화면[비번 입력]  -> 처리
				//인증형 게시판
				//삭제 -> 처리
				
				//아래 코드에서 답글 처리 제외 
				
				//비번 검증
				String sel_pwd_sql = "select pwd from jspboard where idx=?";
				
				//댓글 (reply 참조 관계) 삭제 (자식 모두 삭제)
				String del_reply_sql="delete from reply where idx_fk=?";
				
				//게시글 삭제
				String del_board_sql = "delete from jspboard where idx=?";
				
				pstmt = conn.prepareStatement(sel_pwd_sql);
				pstmt.setString(1, idx);
				rs = pstmt.executeQuery();
				if(rs.next()) { //비번 있는데
					//사용자가 입력한 비번과 일치 하는지
					String dbpwd = rs.getString("pwd");
					if(pwd.equals(dbpwd)) { //두개의 비번이 일치하면
						//실제 삭제 처리
						//reply
						//jspboard 글 삭제
						//트랜잭션 (둘다 처리 , 둘다 실패)
						//두개의 하나의 논리적인 단위 .....
						
						//jdbc 처리 transaction default : auto commit
						conn.setAutoCommit(false); //개발자가 rollback , commit 강제
						//댓글 삭제
						pstmt = conn.prepareStatement(del_reply_sql);
						pstmt.setString(1, idx);
						pstmt.executeUpdate();
						
						//게시글 삭제 (원본글 , 답글)
						pstmt = conn.prepareStatement(del_board_sql);
						pstmt.setString(1, idx);
						row = pstmt.executeUpdate();
						
						if(row > 0) {
							conn.commit();
						}/*else {
							conn.rollback();
						}*/
						
						
						
					}else { //비번이 일치하지 않는 경우
						row = -1;
					}
				}else { //글이 없는 경우
					row = 0;
				}
				
			
		}catch (Exception e) {
					//예외가 발생하면
					//row 는 0을 리턴
					conn.rollback();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		
		return row;
	}
		
	//덧글 입력하기 (Table reply : fk(jspboard idx) )
	public int replywrite(int idx_fk , String writer , String userid, String content,String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql="insert into reply(no,writer,userid,content,pwd,idx_fk) "+
			           " values(reply_no.nextval,?,?,?,?,?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, userid);
			pstmt.setString(3,content);
			pstmt.setString(4, pwd);
			pstmt.setInt(5, idx_fk);
			
			row = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return row;
	}
	
	//덧글 리스트
	public List<reply> replylist(String idx_fk){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<reply> list = null;
		
		try {
			conn = ds.getConnection();
			String reply_sql = "select * from reply where idx_fk=? order by no desc";
			
			pstmt = conn.prepareStatement(reply_sql);
			pstmt.setString(1, idx_fk);
			
			rs =pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rs.next()) {
				int no = Integer.parseInt(rs.getString("no"));
				String writer = rs.getString("writer");
				String userid = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String content  =rs.getString("content");
				java.sql.Date writedate = rs.getDate("writedate");
				int idx = Integer.parseInt(rs.getString("idx_fk"));
				
				reply replydto = new reply(no, writer, userid, pwd, content, writedate, idx);
				list.add(replydto);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return list;
	}
	
	//덧글 삭제하기
	public int replyDelete(String no , String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			
			String replyselect = "select pwd from reply where no=?";
			String replydelete = "delete from reply where no=?";
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(replyselect);
			pstmt.setString(1, no);
			rs =pstmt.executeQuery();
			if(rs.next()) {
				String dbpwd = rs.getString("pwd");
				if(pwd.equals(dbpwd)){
					pstmt.close();
					pstmt = conn.prepareStatement(replydelete);
					pstmt.setString(1, no);
					row = pstmt.executeUpdate();
				}else {
					row = 0;
				}
			}else {
				row =-1;
			}
		}catch(Exception e) {
			
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return row;
	}


	//덧글 수정하기화면 (내용)
	public board getEditContent(String idx) {
		return this.getContent(Integer.parseInt(idx));
	}
	
	//덧글 수정처리하기
	public int boardedit(HttpServletRequest boardata) {

		String idx = boardata.getParameter("idx");
		String pwd = boardata.getParameter("pwd");
		String writer = boardata.getParameter("writer");
		String email = boardata.getParameter("email");
		String homepage = boardata.getParameter("homepage");
		String subject = boardata.getParameter("subject");
		String content = boardata.getParameter("content");
		String filename = boardata.getParameter("filename");
		
		System.out.println(idx + "/ " + pwd + "/ " + writer);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = ds.getConnection();
			String select_idx_sql="select idx from jspboard where idx=? and pwd=?";
			String update_board_sql="update jspboard set writer=?,email=?,homepage=? ," +
					                " subject=?,content=?,filename=? where idx=?";
			pstmt = conn.prepareStatement(select_idx_sql); 
			pstmt.setString(1, idx);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
					pstmt.close(); //경고 ...
					pstmt = conn.prepareStatement(update_board_sql);
					pstmt.setString(1, writer);
					pstmt.setString(2, email);
					pstmt.setString(3, homepage);
					pstmt.setString(4, subject);
					pstmt.setString(5, content);
					pstmt.setString(6, filename);
					pstmt.setString(7, idx);
					
					row = pstmt.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();//반환
			}catch (Exception e) {
				
			}
		}
		
		return row;
		
			
	}
}	





