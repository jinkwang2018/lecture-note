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

import kr.or.bmark.dto.groupBoardDto;
import kr.or.bmark.dto.member;
import kr.or.bmark.dto.myBoard;
/* 
* @FileName : myBoardDao.java 
* @Project : BMark
* @Date : 2018.04.10. 
* @Author : 김래영 
*/ 
public class myBoardDao {
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
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			ds = (DataSource)envCtx.lookup("/jdbc/oracle");
			// System.out.println("DataSource 객체 생성 성공 !");
		} catch (NamingException e) {
			System.out.println("lookup Fail : " + e.getMessage());
		}
	}
	public String makingFavicon(String addr) { //주소를 파비콘으로 전환하는 함수
		String[] addrarray = addr.split("/");
		String icon =addrarray[0]+ "//"+addrarray[2]+"/favicon.ico";
		return icon;
	}
	

	// 마이페이지에서 개인정보를 빈칸에 뿌려주기위해서 사용하는 함수
	public member getMemberInfo(String username) throws Exception {// 괄호안에 String username 집어 넣기
		member member = null;
		try {
			conn = ds.getConnection();
			String sql = "select USERID, PW, NAME, EMAIL, PHONE, ZONECODE, ADDR1, ADDR2, REGDAY " + "from member "
					+ "where USERID=?";
			pstmt = conn.prepareStatement(sql);

			// 객체 형태인 DB 데이터에 담기
			pstmt.setString(1, username); // session에서 받아온것
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userid = rs.getString("userid");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int zonecode = rs.getInt("zonecode");
				String addr1 = rs.getString("addr1");
				String addr2 = rs.getString("addr2");
				String regday = rs.getString("regday");

				member = new member(userid, pw, name, email, phone, zonecode, addr1, addr2, regday);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

		return member;
	}

	// 마이페이지에서 작성한 정보를 다시 디비로 전송하는 함수
	public int updateMemberInfo(member member) throws Exception {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "update member "
					+ "set pw= ? , NAME= ? , EMAIL= ? ,PHONE= ? , ZONECODE= ?, ADDR1= ?, ADDR2= ?, REGDAY= SYSDATE "
					+ "where USERID = ? ";// ('jinwoo')=> ?
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());
			pstmt.setInt(5, member.getZonecode());
			pstmt.setString(6, member.getAddr1());
			pstmt.setString(7, member.getAddr2());
			pstmt.setString(8, member.getUserid());

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}

		return row;
	}

	// 마이페이지에서 본인 정보를 삭제하는 함수
	public int deleteMemberInfo(String userid) throws Exception {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "delete from MEMBER where USERID= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		return row;
	}

	// my페이지에 팀 보드 리스트를 뿌려준다
	public List<groupBoardDto> mypageTeamBoardList(int gid, int cpage, int pagesize) throws Exception {
		List<groupBoardDto> list = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from " + "(select rownum rn,mnbid,ccode, name, addr, content,hit,good,bad,type "
					+ "from siteinfoboard " + "where mnbid in (select mnbid from teamboard where GID = ?)) "
					+ "where rn between ? and ?";

			int start = cpage * pagesize - (pagesize - 1); // 시작 페이지
			int end = cpage * pagesize; // 끝 페이지

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<groupBoardDto>();
			while (rs.next()) {
				int mnbid = rs.getInt("mnbid");
				int ccode = rs.getInt("ccode");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String content = rs.getString("content");
				String icon = makingFavicon(addr);
				int hit = rs.getInt("hit");
				int good = rs.getInt("good");
				int bad = rs.getInt("bad");
				String type = rs.getString("type");

				groupBoardDto boarddto = new groupBoardDto(mnbid, ccode, name, addr, content, icon, hit, good, bad,
						type);
				list.add(boarddto); // 리스트 반환
			}
		} catch (Exception e) {
			System.out.println("설마 여기 타는거야?");
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

		return list;
	}

	// mypage teambook mark 총 건수 구하기
	public int totalteamBoardCount(int gid) throws SQLException {
		int totalcount = 0;
		try {
			conn = ds.getConnection();
			String sql = "select count(*) cnt from teamboard where gid= ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return totalcount;
	}

	// mypage mybook mark 게시판 내 페이지 설정하기
	public List<myBoard> myPageGetList(String userid, int cpage, int pagesize) throws SQLException {
		List<myBoard> mypagelist = null;

		try {
			conn = ds.getConnection();
			String sql = "select * from " + "(select rownum rn, mnbid, cname, name, addr, content "
					+ "from SITEINFOBOARD site join SCATEGORY cate " + "on site.ccode = cate.ccode "
					+ "where mnbid in (select mnbid from myboard where userid=?)) " + "where rn between ? and ?";

			int start = cpage * pagesize - (pagesize - 1); // 시작 페이지
			int end = cpage * pagesize; // 끝 페이지

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			mypagelist = new ArrayList<myBoard>();
			// 객체 형태로 DB가지고 데이터
			while (rs.next()) {
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

	// mypage mybook mark 총 건수 구하기
	public int totalmyBoardCount(String userid) throws SQLException {
		int totalcount = 0;
		try {
			conn = ds.getConnection();
			String sql = "select count(*) cnt from myboard where userid=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return totalcount;
	}

	// my bookmark 데이터 가지고오기
	public List<myBoard> getList(String userid) throws Exception {
		List<myBoard> list = null;

		try {
			conn = ds.getConnection();
			String sql = "select mnbid, cname, name, addr, content " + "from siteinfoboard site join SCATEGORY cate "
					+ "on site.ccode = cate.ccode " + "where mnbid in (select mnbid from myboard where userid=?)";
			////////////////
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			// 객체 형태인 DB 데이터에 담기
			list = new ArrayList<myBoard>();

			while (rs.next()) {
				int mnbid = rs.getInt("mnbid");
				String cname = rs.getString("cname");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String icon = makingFavicon(addr);
				String content = rs.getString("content");

				myBoard dto = new myBoard(mnbid, cname, name, addr, icon, content);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return list;

	}
	
	//siteinfoboard에 'my' type 사이트 추가하는 함수 (my book mark 추가용)
	public int addsiteMy(myBoard boarddata) throws SQLException {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into siteinfoboard " + "(mnbid, ccode, name, addr, content, type, writer, writeday) "
					+ "values (SNUM.NEXTVAL, (select ccode from SCATEGORY where cname = ?), ?, ?, ?, 'my', ?, sysdate)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, boarddata.getCname());
			pstmt.setString(2, boarddata.getName());
			pstmt.setString(3, boarddata.getAddr());
			pstmt.setString(4, boarddata.getContent());
			pstmt.setString(5, boarddata.getWriter());

			row = pstmt.executeUpdate();
			
		}catch (Exception e) {
			 e.printStackTrace(); 
		}finally {
			// System.out.println("close");
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close(); // pool conn 객체반환
		}
		return row;
	}
	
	//siteinfoboard에 'group' type의 사이트 추가하는 함수 (Group book mark 추가용)
	public int addsiteGroup(myBoard boarddata) throws SQLException {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into siteinfoboard " + "(mnbid, ccode, name, addr, content, type, writer, writeday) "
					+ "values (SNUM.NEXTVAL, (select ccode from SCATEGORY where cname = ?), ?, ?, ?, 'group', ?, sysdate)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, boarddata.getCname());
			pstmt.setString(2, boarddata.getName());
			pstmt.setString(3, boarddata.getAddr());
			pstmt.setString(4, boarddata.getContent());
			pstmt.setString(5, boarddata.getWriter());

			row = pstmt.executeUpdate();
			return row;
		}catch (Exception e) {
			 e.printStackTrace(); 
		}finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return row;
	}

	// 정말 mybookmark에 사이트를 추가하는 함수
	public int mybookmarkadd(myBoard data) throws SQLException {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into myboard(mnbid, userid) values (snum.currval, ?)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setString(1, data.getUserid());

			row = pstmt.executeUpdate();
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
		return row;
	}
	
	//my board 디비 내에서 마이 북마크 삭제하기
		public int myboardsitedelete(int mnbid, String userid) throws SQLException {
			int row = 0;
			
			try {
				conn = ds.getConnection();
				String sql = "delete from myboard " + 
						"where mnbid = ? and userid = ?";
				pstmt = conn.prepareStatement(sql);
		
				pstmt.setInt(1, mnbid);
				//session 처리 필요
				pstmt.setString(2, userid);
				
				row = pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			
			} finally {
				pstmt.close();
				conn.close();	
			}
			return row;
		}
		
		//siteinfoboard 디비 내에서 my board 데이터 삭제하기 (type='my' writer=사용자)
		public int myboarddatadelete(int mnbid, String userid) throws SQLException {
			int row = 0;
			try {
				conn = ds.getConnection();
				String sql = "delete from SITEINFOBOARD " + 
						"where mnbid = ? and writer = ?";
				pstmt = conn.prepareStatement(sql);
		
				pstmt.setInt(1,mnbid);
				pstmt.setString(2, userid);
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
