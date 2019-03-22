package kr.or.bmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bmark.dto.myBoard;
import kr.or.bmark.dto.team;

/**
 * 
 * @author : 김태웅
 * @date   : 2018. 4. 18.
 * @desc   : 그룹에 관련해서 TEAM 데이터베이스에 접근 하는 모든 CRUD 처리를 담당하는 DAO.
 * @param group
 * @return
 */
public class groupDao {
	// DB연결 ...
	// method 공통 사용 ....
	// 초기자 { } static 초기자 : static { }
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
	
	// 파비콘 주소를 만드는 함수
	public String makingFavicon(String addr) { //주소를 파비콘으로 전환하는 함수
		String[] addrarray = addr.split("/");
		String icon =addrarray[0]+ "//"+addrarray[2]+"/favicon.ico";
		return icon;
	}

	/*
	 * 만약 사용자가 특정 그룹에 가입 신청을 했다면,
	 * 데이터베이스에서 사용자가 누른 그룹의 GID와 입력한 비밀번호를 가져온다.
	 * 데이터베이스에 접근하여 해당 데이터가 존재한다면 'True'를 없다면, 'False'를 return한다.
	 * */
	public boolean isGroupJoinOk(int gid, int pw) throws Exception {
		String sql ="select * from team where gid=? and pw=?";
		boolean isOk = false;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			pstmt.setInt(2, pw);
			
			rs = pstmt.executeQuery();

			// 만약 사용자가 선택한 그룹 ID와 그 비밀번호가 일치한다면? 1개가 출력된다.
			while (rs.next()) {
				isOk = true;
				//System.out.println("isOk 함수 통과");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return isOk;
	}
	
	// 마이 페이지에서 새롭게 그룹을 추가(INSERT)하는 함수
	public int createGroup(team newteam) throws Exception{
		String sql = "INSERT INTO team(gid, name, pw, content, register, regday) VALUES(GNUM.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
		int result = 0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newteam.getName());
			pstmt.setString(2, newteam.getPw());
			pstmt.setString(3, newteam.getContent());
			pstmt.setString(4, newteam.getRegister());

			result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("insert 성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
		return result;
	}
	
	/*
	 * 만약 사용자가 비밀번호를 제대로 입력했다면,
	 * 그 사용자 데이터베이스에 그룹 ID(GID)를 Insert해 준다.
	 * */
	public void addGrouptoUser(int gid, String userid) throws Exception{
		String sql = "update MEMBER set GID=? where USERID=?";
		int result=0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, gid);
			pstmt.setString(2, userid);

			result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("update 성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	/*
	 * 만약 사용자가 자신이 가입한 그룹을 만들었다면,
	 * 그 사용자는 그 그룹에 즉시 가입된 것으로처리 된다.
	 * */
	public int createJoinGroup(String userid) throws Exception{
		String sql1 = "update MEMBER set GID=GNUM.CURRVAL where USERID=?";
		String sql2 = "select gid from MEMBER where USERID=?";
		
		int currGID = 0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql1);
			
			pstmt.setString(1, userid);

			int result = pstmt.executeUpdate();
			if(result != 0){
				//System.out.println("Group Join 성공");
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				currGID = rs.getInt("gid");
				//System.out.println(currGID);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
		return currGID;
	}
	
	public void delGroup(int gid) throws Exception{
		String sql = "delete from TEAM where GID=?";
		int result=0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);

			result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("delGroup 성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	// 현재 이용중인 회원이 가입한 그룹에서 그룹장인지 판단해주는 SQL쿼리 함수
	public boolean isGroupMaster(String userid) throws Exception{
		String sql = "select * from team where register=?";
		boolean check = false;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				check = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		//System.out.println("isGroupMaster 성공 check: " + check);
		return check;
	}
	
	/*
	 * 만약 사용자가 자신이 가입한 그룹 탈퇴를 신청했다면,
	 * 그 사용자의 데이터베이스에서 그룹 ID(GID)를 'NULL'로 UPDATE 한다.
	 * */
	public void outGroup(String userid) throws Exception{
		String sql = "update MEMBER set GID=null where USERID=?";
		int result=0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);

			result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("Group Out 성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	// '그룹장'이 그룹 탈퇴시 해당 그룹에 'TEAMBOARD' 데이터베이스에 등록되어있었던 '모든 북마크 사이트 삭제'하는 함수
	public void delGroupAllSite(int gid) throws Exception{
		String sql = "delete from TEAMBOARD where GID=?";
		int result=0;
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);

			result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("delGroupAllSite 성공");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			pstmt.close();
			conn.close();
		}
	}
	
	// '그룹장'이 그룹 탈퇴시 해당 그룹(GID)에 'MEMBER' 데이터베이스에 GID로 참조되어있었던 것들 'NULL'로 업데이트하는 함수
		public void delGroupAllMember(int gid) throws Exception{
			String sql = "update MEMBER set GID=null where GID=?";
			int result=0;
			try{
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gid);

				result = pstmt.executeUpdate();
				
				if(result != 0){
					//System.out.println("delGroupAllMember 성공");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());	
			}finally{
				pstmt.close();
				conn.close();
			}
		}
	
	/*
	 * 만약 사용자가 자신이 가입한 그룹 탈퇴를 신청했다면,
	 * 그 사용자의 데이터베이스에서 그룹 ID(GID)를 'NULL'로 UPDATE 한다.
	 * */
	public boolean isGroupBookMark(int mnbid, String userid) throws Exception{
		String sql = "select mnbid, gid from teamboard where mnbid=? and gid=(select GID from MEMBER where userid=?)";
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
	
	/*
	 * 사용자가 가입한 그룹에 방금 즐겨찾기한 북마크를 넣어주는 함수.
	 * */
	public void addGroupBookMark(int mnbid, String userid) throws Exception{
		
		try {
			conn = ds.getConnection();
			String sql ="insert into teamboard(MNBID, GID) values(?, (select GID from MEMBER where userid=?))";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mnbid);
			pstmt.setString(2, userid);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				//System.out.println("그룹 들어감");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
	}
	
	public int addGroupModalMark(String userid) throws Exception{
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql ="insert into teamboard(MNBID, GID) values(SNUM.CURRVAL, (select GID from MEMBER where userid=?))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			row = pstmt.executeUpdate();
			
			if(row != 0){
				//System.out.println("그룹 들어감");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			pstmt.close();
			conn.close();
		}
		return row;
	}
	
	/*
	 * 사용자가 가입한 그룹에 즐겨찾기된 북마크 리스트를 가져오는 함수.
	 * */
	public List<myBoard> getGroupMark(int param_mnbid) throws Exception {
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
}







