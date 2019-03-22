package kr.or.bmark.dao;
/*
* @Class : mainBoardDao.java
* @Date : 2018.04.11
* @Author : 이 진 우
*/

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

import kr.or.bmark.dto.category;
import kr.or.bmark.dto.evalData;
import kr.or.bmark.dto.groupBoard;
import kr.or.bmark.dto.groupBoardDto;
import kr.or.bmark.dto.mainBoardDto;
import kr.or.bmark.dto.myBoard;
import kr.or.bmark.dto.myBoardData;
import kr.or.bmark.dto.team;

public class mainBoardDao {
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
			//System.out.println("DataSource 객체 생성 성공 !");
		} catch (NamingException e) {
			System.out.println("lookup Fail : " + e.getMessage());
		}
	}
	
	//주소를 파비콘으로 전환하는 함수
	public String makingFavicon(String addr) { 
		String[] addrarray = addr.split("/");
		String icon =addrarray[0]+ "//"+addrarray[2]+"/favicon.ico";
		return icon;
	}
	
	// 로그인한 사용자가 과거에 평가한 사이트 MNBID를 가져오는 리스트 생성
	public List<evalData> getUserEvalList(String userid) throws Exception {
		String sql ="SELECT MNBID, EVAL FROM SEVAL WHERE USERID=?";
		List<evalData> list = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<evalData>();
			while (rs.next()) {
				int mnbid = rs.getInt("mnbid");
				String eval = rs.getString("EVAL");
				evalData edata = new evalData(mnbid, userid, eval); //리스트 입력
				list.add(edata); //리스트 반환
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
	
	// mainboard 초기화에서 화면단에 데이터를 뿌려주기위한 리스트 생성
	public List<mainBoardDto> getMainBoardList() throws Exception { 
		List<mainBoardDto> list = null;
		try {
			conn = ds.getConnection();
			String sql ="select site.MNBID, site.CCODE, cate.CNAME,site.NAME, site.ADDR, site.CONTENT, site.TYPE, site.HIT, site.GOOD, site.BAD "+ 
					"from SITEINFOBOARD site join SCATEGORY cate on site.CCODE=cate.CCODE " +
					"where type='main'";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<mainBoardDto>();
			while (rs.next()) {
				int mnbid = rs.getInt("mnbid");
				int ccode = rs.getInt("ccode");
				String cname = rs.getString("cname");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String icon = "";
				String content = rs.getString("content");
				String type = rs.getString("type");
				int hit = rs.getInt("hit");
				int good = rs.getInt("good");
				int bad = rs.getInt("bad");
				
				//addr을 받아와 favicon을 만들어줄 주소를 만듬
				//규칙: 사이트 주소 도메인 + /favicon.ico 
				icon = makingFavicon(addr);

				mainBoardDto boarddto = new mainBoardDto(mnbid, ccode, cname,name, addr, icon, content, type, hit, good, bad); //리스트 입력
				list.add(boarddto); //리스트 반환
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
	
	// 사용자가 그룹에 가입한지 안한지의 여부를 보여주는 함수 ( 0: 그룹 미가입 / 0 < GID: 그룹 가입 )
	public int isGroupRegister(String userid) throws Exception{
		// 
		int resultdata = 0;
		String sql ="select GID from MEMBER where userid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();

			// 로그인한 사람이 그룹을 가지고 있다면?
			while (rs.next()) {
				resultdata = rs.getInt("");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return resultdata;
	}
	
	// 메인페이지에 뿌려지는 '그룹에 가입한 회원'의 그룹 북마크 리스트 함수 
	public List<groupBoardDto> getGroupBoardList(int gid) throws Exception{
		List<groupBoardDto> list = null;
		try {
			conn = ds.getConnection();
			String sql ="select mnbid, ccode, name, addr, content, hit, good, bad, type " +
					"from siteinfoboard " + 
					"where mnbid in (select mnbid from teamboard where GID =?)"; //(GID=?) 추후에입력예정 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<groupBoardDto>();
			while (rs.next()) {
				int mnbid = rs.getInt("mnbid");
				//System.out.println(mnbid);
				int ccode = rs.getInt("ccode");
				String name = rs.getString("name"); 
				String addr = rs.getString("addr");
				String content = rs.getString("content");
				String icon ="";
				int hit = rs.getInt("hit");
				int good = rs.getInt("good");
				int bad = rs.getInt("bad");
				String type = rs.getString("type");
				icon =makingFavicon(addr);
				
				groupBoardDto boarddto = new groupBoardDto(mnbid, ccode, name, addr, content, icon, hit, good, bad, type);
				list.add(boarddto); //리스트 반환
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return list;
	}
	
	// 사이트에 등록된 그룹 리스트를 가져오는 함수
	public List<team> getGroupList() throws Exception{
		List<team> list = null;
		String sql ="select * " + 
					"from team t "
						+ "LEFT OUTER JOIN (select GID, count(*) as gcount "
										 + "from MEMBER group by GID having GID is not null) c " 
						+ "ON t.GID = c.GID";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<team>();
			while (rs.next()) {
				int gid = rs.getInt("GID");
				String name = rs.getString("NAME"); 
				String register = rs.getString("REGISTER");
				String regday = rs.getString("REGDAY");
				int membercount = rs.getInt("GCOUNT");
				team group = new team(gid, name, register, regday, membercount);
				list.add(group); //리스트 반환
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return list;
	}
	
	// 사이트에 등록된 카테고리 리스트를 가져오는 함수
	public List<category> getCategoryList() throws Exception{
		List<category> list = null;
		try {
			conn = ds.getConnection();
			String sql ="select ccode, cname from SCATEGORY"; 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			list = new ArrayList<category>();
			while (rs.next()) {
				int ccode = rs.getInt("ccode");
				String cname = rs.getString("cname");
				
				category category = new category(ccode, cname);
				list.add(category); //리스트 반환
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return list;
	}
	
	public void deleteUserEval(evalData evaldata) throws Exception{
		String sql="DELETE FROM  SEVAL WHERE MNBID=? AND USERID=?";
		int result=0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, evaldata.getMnbid());
			pstmt.setString(2, evaldata.getUserid());
			
			result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("추천 삭제 성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
		//System.out.println("Eval delete END");
	}
	
	public boolean setUserEval(evalData evaldata) throws Exception{
		boolean resultdata = false;
		
		String sql="INSERT INTO  SEVAL(MNBID, USERID, EVAL, EVALDAY) VALUES (?,?,?,SYSDATE)";
		int result=0;
		//System.out.println("여기는 오니??????");
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, evaldata.getMnbid());
			pstmt.setString(2, evaldata.getUserid());
			
			if(evaldata.getEval().equals("T")) { 
				pstmt.setString(3, "T"); 
			}else { 
				pstmt.setString(3, "F"); 
			}
			
			result = pstmt.executeUpdate();
			
			if(result != 0){
				resultdata = true;
				//System.out.println("성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
		//System.out.println("Dao END");
		return resultdata;
	}
	
	public evalData isRecommend(int mnbid, String userid) throws Exception{
		evalData resultdata = null;
		String sql ="SELECT mnbid, userid, eval, evalday FROM SEVAL WHERE mnbid=? and userid=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			pstmt.setString(2, userid);
			
			rs = pstmt.executeQuery();

			// 객체 형태로 DB가지고 데이터
			while (rs.next()) {
				int mainboardid = rs.getInt("mnbid");
				String uid = rs.getString("userid");
				String eval = rs.getString("eval");
				String evalday = rs.getString("evalday");
				
				resultdata = new evalData(mainboardid, uid, eval, evalday);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return resultdata;
	}
	
	public boolean setLike(int mnbid) throws Exception{
		boolean re = false;
		try {
			conn = ds.getConnection();
			String sql ="update SITEINFOBOARD set good=good+1 where mnbid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				re = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		
		return re;
	}
	
	public boolean setunLike(int mnbid) throws Exception{
		boolean re = false;
		try {
			conn = ds.getConnection();
			String sql ="update SITEINFOBOARD set good=good-1 where mnbid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				re = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		
		return re;
	}
	
	public boolean setDislike(int mnbid) throws Exception{
		boolean re = false;
		
		try {
			conn = ds.getConnection();
			String sql ="update SITEINFOBOARD set bad=bad+1 where mnbid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				re = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		
		return re;
	}
	
	public boolean setunDisLike(int mnbid) throws Exception{
		boolean re = false;
		try {
			conn = ds.getConnection();
			String sql ="update SITEINFOBOARD set bad=bad-1 where mnbid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				re = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		
		return re;
	}
	
	public boolean setHit(int mnbid) throws Exception{
		boolean re = false;
		
		try {
			conn = ds.getConnection();
			String sql ="update SITEINFOBOARD set hit=hit+1 where mnbid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				re = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		
		return re;
	}
	
	public void addMyBookMark(int mnbid, String userid) throws Exception{
		
		try {
			conn = ds.getConnection();
			String sql ="insert into MYBOARD(MNBID, USERID) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mnbid);
			pstmt.setString(2, userid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				System.out.println("들어감");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
	}
	
	//my bookmark 데이터 가지고오기 
	public List<myBoard> getBookMark(int param_mnbid) throws Exception {
		List<myBoard> list = null;

		try {
			conn = ds.getConnection();
			String sql = "select mnbid, ccode, name, addr, content "
					+ "from siteinfoboard "
					+ "where mnbid = ?";
			
			////////////////
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, param_mnbid);
			
			rs = pstmt.executeQuery();

			// 객체 형태인 DB 데이터에 담기
			list = new ArrayList<myBoard>();
			
			while (rs.next()) {
				int mnbid = rs.getInt("mnbid");
				String ccode = rs.getString("ccode");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String icon = makingFavicon(addr);
				String content = rs.getString("content");
				
				myBoard dto = new myBoard(mnbid, ccode, name, addr, icon, content);
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
	
	public boolean isMyBookMark(int mnbid, String userid) throws Exception{
		String sql ="select mnbid, userid from myboard where mnbid=? and userid=?";
		boolean check=false;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mnbid);
			pstmt.setString(2, userid);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				check=true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return check;
	}

	// 로그인한 회원이 즐겨찾기한 마이북마크 리스트를 가져오는 함수.
	public List<myBoardData> getMyBookList(String param_userid) throws Exception{
		
		String sql ="select mnbid, userid from myboard where userid=?";
		List<myBoardData> list = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param_userid);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<myBoardData>();
			while(rs.next()) {
				int mnbid = rs.getInt("mnbid");
				String userid = rs.getString("userid");
				
				myBoardData dto = new myBoardData(mnbid, userid);
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return list;
	}
	
	// 로그인한 회원이 즐겨찾기한 그룹북마크 리스트를 가져오는 함수.
	public List<groupBoard> getGroupBookList(String param_userid) throws Exception{
		
		String sql ="select mnbid, gid from teamboard where gid=(select gid from MEMBER where userid=?)";
		List<groupBoard> list = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param_userid);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<groupBoard>();
			while(rs.next()) {
				int mnbid = rs.getInt("mnbid");
				int gid = rs.getInt("gid");
				
				groupBoard dto = new groupBoard(mnbid, gid);
				list.add(dto);
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return list;
	}
	
	//siteinfoboard에 사이트 추가하는 함수 (my book mark 추가용)
	public int addTypeMy(int mnbid, String userid) throws SQLException {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into siteinfoboard " + "(mnbid, ccode, name, addr, type, writer, writeday) "
					+ "values (?, (select ccode from siteinfoboard where mnbid=?), (select name from siteinfoboard where mnbid=?), (select addr from siteinfoboard where mnbid=?), 'my', ?, sysdate)";
			pstmt = conn.prepareStatement(sql);

			// parameter 설정하기
			pstmt.setInt(1, mnbid);
			pstmt.setInt(2, mnbid);
			pstmt.setInt(3, mnbid);
			pstmt.setInt(4, mnbid);
			pstmt.setString(5, userid);

			row = pstmt.executeUpdate();
			if(row > 0) {
				
			}
			
		} catch (Exception e) {
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
}

