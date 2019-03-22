package kr.or.bmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bmark.dto.mainBoardDto;
import kr.or.bmark.dto.memberDto;
import kr.or.bmark.dto.member;
import kr.or.bmark.dto.myBoard;
import kr.or.bmark.dto.team;

public class adminDao {
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
			
			ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("lookup Fail : " + e.getMessage());
		}
	}
	
	public String makingFavicon(String addr) { //주소를 파비콘으로 전환하는 함수
		String[] addrarray = addr.split("/");
		String icon =addrarray[0]+ "//"+addrarray[2]+"/favicon.ico";
		return icon;
	}

	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 16.
	 * @desc   : 전체 회원정보를 불러온다.(관리자 회원관리) 
	 *
	 * @param cpage
	 * @param pagesize
	 * @return memberDto
	 * @throws Exception
	 */
	public List<memberDto> memberList(int cpage, int pagesize) throws Exception {
		
		List<memberDto> memberlist = null;
		try {
			//System.out.println("여기까지되는가2?");
			conn = ds.getConnection();
			
			
			String sql = " SELECT * FROM "
					+ "( SELECT ROWNUM rn , userid,pw,name,email,phone,regday,gid "
					+ " FROM (	SELECT * FROM member   ) "
					+ " ) WHERE rn BETWEEN ? AND ? ";
			//System.out.println(sql);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			memberlist = new ArrayList<memberDto>();
			while (rs.next()) {
				memberDto mb=new memberDto();
				
				mb.setUserid(rs.getString("USERID"));
				mb.setGid(rs.getInt("GID"));
				mb.setName(rs.getString("NAME"));
				mb.setEmail(rs.getString("EMAIL"));
				mb.setPhone(rs.getString("PHONE"));
				mb.setPw(rs.getString("PW"));
				mb.setRegday(rs.getString("REGDAY").substring(0, 10));
				
				memberlist.add(mb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			conn.close();
		}
		return memberlist;
	}

	//총 회원수 불러오기
	public int totalMemberCount() throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql = "select count(*) cnt from member";
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
	//member table에서 멤버 삭제하는 구역
		public int memberdelete(String userid) throws Exception {
			int row = 0;
			
			try {
				conn = ds.getConnection();
				String sql = "delete from MEMBER where USERID= ?";
				pstmt = conn.prepareStatement(sql);
		
				pstmt.setString(1, userid);
				
				row = pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			
			} finally {
				pstmt.close();
				conn.close();	
			}
			return row;
		}
		// Admin페이지에서 작성한 회원 수정 정보를 다시 디비로 전송하는 함수
		public int updateMemberInfo(member member) throws Exception {
			int row = 0;
			try {
				conn = ds.getConnection();
				String sql = "update member "
						+ "set pw= ? , NAME= ? , EMAIL= ? ,PHONE= ? "
						+ "where USERID = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getPwd());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getEmail());
				pstmt.setString(4, member.getPhone());
				System.out.println(member.getUserid());
				pstmt.setString(5, member.getUserid());

				row = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				pstmt.close();
				conn.close();
			}

			return row;
		}
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 16.
	 * @desc   : 전체 그룹정보를 불러온다.(관리자 그룹관리) 
	 *
	 * @param cpage
	 * @param pagesize
	 * @return dto/ team
	 * @throws Exception
	 */
	public List<team> groupList(int cpage, int pagesize) throws Exception {
		
		List<team> grouplist = null;
		try {
			//System.out.println("여기까지되는가2?");
			conn = ds.getConnection();
			
			
			String sql = " SELECT * FROM "
					+ "( SELECT ROWNUM rn , gid,pw,name,content,register,regday "
					+ " FROM (	SELECT * FROM team   ) "
					+ " ) WHERE rn BETWEEN ? AND ? ";
			//System.out.println(sql);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			grouplist = new ArrayList<team>();
			while (rs.next()) {
				team team=new team();
				
				team.setGid(rs.getInt("gid"));
				team.setName(rs.getString("name"));
				team.setPw(rs.getString("pw"));
				team.setContent(rs.getString("content"));
				team.setRegister(rs.getString("register"));
				team.setRegday(rs.getString("regday").substring(0, 10));
				
				grouplist.add(team);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			conn.close();
		}
		return grouplist;
	}

	//총 그룹수 구하기
	public int totalGroupCount() throws SQLException{
		
		try{
			conn = ds.getConnection();
			String sql = "select count(*) cnt from team";
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
	
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 17.
	 * @desc   : 메인 사이트 조회 
	 *
	 * @param userid
	 * @param cpage
	 * @param pagesize
	 * @return <SITEINFOBOARD>
	 * @throws SQLException
	 */
	public List<myBoard> myPageGetList(String userid, int cpage, int pagesize) throws SQLException {
		List<myBoard> mypagelist = null;
		
		try {
			conn = ds.getConnection();
			String sql = "select * from " + 
					"(select rownum rn, mnbid, cname, name, addr, content " + 
					"from SITEINFOBOARD site join SCATEGORY cate " + 
					"on site.ccode = cate.ccode " + 
					"where type= 'main' ) " + 
					"where rn between ? and ?";

			//System.out.println(sql);
			int start = cpage * pagesize - (pagesize - 1); // 시작 페이지
			int end = cpage * pagesize; // 끝 페이지
				
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, userid);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
				
			rs = pstmt.executeQuery();
			
			mypagelist = new ArrayList<myBoard>();
			// 객체 형태로 DB가지고 데이터
			while(rs.next()) {
				int mnbid = rs.getInt("mnbid");
				String cname = rs.getString("cname");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String icon = makingFavicon(addr);
				String content = rs.getString("content");


				myBoard dto = new myBoard(mnbid, cname, name, addr, icon, content);
				mypagelist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			rs.close();
			pstmt.close();
			conn.close();	
		}
		return mypagelist;

	}
	
	public List<myBoard> myPageGetList() throws SQLException {
		List<myBoard> mypagelist = null;
		
		try {
			conn = ds.getConnection();
			String sql = "select * from " + 
					"(select rownum rn, mnbid, cname, name, addr, content " + 
					"from SITEINFOBOARD site join SCATEGORY cate " + 
					"on site.ccode = cate.ccode " + 
					"where type= 'main' ) " + 
					"where rn between 1 and 10";

			//System.out.println(sql);
			
				
			pstmt = conn.prepareStatement(sql);
				
			rs = pstmt.executeQuery();
			
			mypagelist = new ArrayList<myBoard>();
			// 객체 형태로 DB가지고 데이터
			while(rs.next()) {
				int mnbid = rs.getInt("mnbid");
				String cname = rs.getString("cname");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String icon = makingFavicon(addr);
				String content = rs.getString("content");


				myBoard dto = new myBoard(mnbid, cname, name, addr, icon, content);
				mypagelist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			rs.close();
			pstmt.close();
			conn.close();	
		}
		return mypagelist;

	}
	
	//main 사이트 총 건수 구하기
	public int totalmyBoardCount() throws SQLException{
		int totalcount = 0;		
		try{
			conn = ds.getConnection();
			String sql = "select count(*) cnt from siteinfoboard where type='main'";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				totalcount = rs.getInt("cnt");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if(rs != null)try {rs.close();} catch (SQLException e) {}
			if(conn != null)try {conn.close();} catch (SQLException e) {}
		}		
		return totalcount;
	}
	
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 17.
	 * @desc   : 메인사이트 추가
	 * @param mainBoardDto
	 * @return boolean
	 */
	public boolean mainInsert(mainBoardDto main){
		String sql="INSERT INTO  SITEINFOBOARD (MNBID,CCODE,NAME,CONTENT,ADDR,TYPE,WRITER,WRITEDAY) VALUES";
		sql+="(SNUM.NEXTVAL,(select ccode from SCATEGORY where cname = ?),?,?,?,'main','admin',SYSDATE)";

		int result=0;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, main.getCname());
			pstmt.setString(2, main.getName());
			pstmt.setString(3, main.getContent());
			pstmt.setString(4, main.getAddr());
			
			result=pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
		}catch(Exception ex){
			System.out.println("mainInsert 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null) try{conn.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	//my board 디비 내에서 마이 북마크 삭제하기
			public int sevaldelete(int mnbid) throws SQLException {
				int row = 0;
				
				try {
					conn = ds.getConnection();
					String sql = "delete from seval " + 
							"where mnbid = ? ";
					pstmt = conn.prepareStatement(sql);
			
					pstmt.setInt(1, mnbid);
					//session 처리 필요
					
					
					row = pstmt.executeUpdate();
					
				}catch (Exception e) {
					e.printStackTrace();
				
				} finally {
					pstmt.close();
					conn.close();	
				}
				return row;
			}
	
	
	
}







