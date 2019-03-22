package kr.or.bmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bmark.dto.member;
import kr.or.bmark.dto.team;

public class memberDao {
	/**
	 * @uml.property  name="con"
	 */
	Connection con;
	/**
	 * @uml.property  name="pstmt"
	 */
	PreparedStatement pstmt;
	/**
	 * @uml.property  name="rs"
	 */
	ResultSet rs;
	/**
	 * @uml.property  name="ds"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DataSource ds;
	public memberDao() {
		try{
			Context init = new InitialContext();
	  		ds = 
	  			(DataSource) init.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 10.
	 * @desc   : 로그인 로직 입력받은 패스워드와 회원정보의 패스워드비교
	 *           아이디미존재 / 패스워드 틀림 판단 
	 * @param member
	 * @return int
	 */
	public int isMember(member member){
		String sql="SELECT PW FROM MEMBER WHERE USERID=?";
		int result=-1;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("PW").equals(member.getPwd())){
					result=1;//일치.
				}else{
					result=0;//불일치.
				}
			}else{
				result=-1;//아이디 존재하지 않음.
			}
		}catch(Exception ex){
			System.out.println("isMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 10.
	 * @desc   : 회원가입 처리. 
	 *           추가 할것 남아있음. (주소추가예정)
	 * @param member
	 * @return boolean
	 */
	public int joinMember(member member){
		String sql="INSERT INTO  MEMBER (USERID, PW, NAME, EMAIL, PHONE, ZONECODE, ADDR1, ADDR2, REGDAY) " + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		int result = 0;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setInt(6, member.getZonecode());
			pstmt.setString(7, member.getAddr1());
			pstmt.setString(8, member.getAddr2());
			
			result = pstmt.executeUpdate();
			

		}catch(Exception e){
			System.out.println("joinMember 에러: " + e.getMessage());			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 12.
	 * @desc   : id로 회원정보 가져오기.
	 * @param member
	 * @return member
	 */
	public member getDetailMember(member member){
		String sql="SELECT * FROM MEMBER WHERE USERID=?";
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			rs=pstmt.executeQuery();
			rs.next();
			
			member mb =new member();
			
			mb.setGid(rs.getInt("GID"));
			mb.setName(rs.getString("NAME"));
			mb.setEmail(rs.getString("EMAIL"));
			mb.setPhone(rs.getString("PHONE"));
			mb.setPwd(rs.getString("PW"));
			mb.setRegidate(rs.getString("REGDAY"));
			mb.setZonecode(rs.getInt("ZONECODE"));
			mb.setAddr1(rs.getString("ADDR1"));
			mb.setAddr2(rs.getString("ADDR2"));
			
			//System.out.println("gid값 출력:"+rs.getInt("GID"));
			return mb;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 12.
	 * @desc   : 전체 회원정보 가져오기.
	 * @param 
	 * @return member
	 */
	public List<member> getMemberList(){
		String sql="SELECT * FROM MEMBER";
		List<member> memberlist=new ArrayList<member>();
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				member mb=new member();
				
				mb.setUserid(rs.getString("USERID"));
				mb.setGid(rs.getInt("GID"));
				mb.setName(rs.getString("NAME"));
				mb.setEmail(rs.getString("EMAIL"));
				mb.setPhone(rs.getString("PHONE"));
				mb.setPwd(rs.getString("PW"));
				mb.setRegidate(rs.getString("REGDAY").substring(0, 10));
				mb.setZonecode(rs.getInt("ZONECODE"));
				mb.setAddr1(rs.getString("ADDR1"));
				mb.setAddr2(rs.getString("ADDR2"));
				
				memberlist.add(mb);
			}
			
			return memberlist;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	/**
	 * 
	 * @author : joon
	 * @date   : 2018. 4. 12.
	 * @desc   : 전체 그룹 정보 가져오기.
	 * @param 
	 * @return member
	 */
	public List<team> getGroupList(){
		String sql="SELECT * FROM TEAM";
		List<team> teamlist = new ArrayList<team>();
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				team team= new team();
				
				team.setGid(rs.getInt("gid"));
				team.setName(rs.getString("name"));
				team.setPw(rs.getString("pw"));
				team.setContent(rs.getString("content"));
				team.setRegister(rs.getString("register"));
				team.setRegday(rs.getString("regday").substring(0, 10));
			
				teamlist.add(team);
			}
			
			return teamlist;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	/**
	 * 
	 * @author : 이 진 우
	 * @date   : 2018. 4. 17.
	 * @desc   : 아이디 체크.
	 * @param 
	 * @return : int
	 */
	public int idcheck(String userid) {
		int totalcount = 0;		
		try{
			con = ds.getConnection();
			String sql = "select count(*) cnt from member where userid= ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				totalcount = rs.getInt("cnt");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(pstmt != null)try {pstmt.close();} catch (SQLException e) {}
			if(rs != null)try {rs.close();} catch (SQLException e) {}
			if(con != null)try {con.close();} catch (SQLException e) {}
		}		
		return totalcount;
	}
	
}