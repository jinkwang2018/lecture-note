package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import kr.or.bit.dto.JoinDto;



public class JoinDao {
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public JoinDao(){
		Context context = null;
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<JoinDto> JoinList() throws SQLException{
		PreparedStatement pstmt = null;
		String sql = "select * from join";
		Connection conn= ds.getConnection();
		pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		ArrayList<JoinDto> joindlist = new ArrayList<JoinDto>();
 
		while(rs.next()) {
			JoinDto joindto = new JoinDto();
			joindto.setId(rs.getString("id"));
			joindto.setEmail(rs.getString("email"));
			joindto.setName(rs.getString("name"));
			joindto.setPno(rs.getInt("pno"));
			joindto.setPwd(rs.getString("pwd"));
			joindto.setPwdcheck(rs.getString("pwdcheck"));
			joindlist.add(joindto);
		}
		
		conn.close(); 
		return joindlist;
	}
	
	public int insertjoin(String id, String pwd, String pwdcheck, String name, int pno, String email) throws SQLException {
		int resultrow=0;
		PreparedStatement pstmt = null;
		String sql="insert into join(id, pwd, pwdcheck, name, pno, email) values(?,?,?,?,?,?)";
		try {	   
			   conn= ds.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, id);
			   pstmt.setString(4, name);
			   pstmt.setString(3, pwdcheck);
			   pstmt.setString(2, pwd);
			   pstmt.setInt(5, pno);
			   pstmt.setString(6, email);
			   
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
			e.printStackTrace();
		}finally {
	
		}
		return resultrow;
	}
	
	public String loginok(String id) throws SQLException {
		String p=null;
		conn= ds.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select id,pwd from join where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			p = rs.getString(2);
			System.out.println(p);
		}else {
			p=null;
			System.out.println("else");
		}
		return p;

	}
	public String isIdCheckById(String id) throws SQLException {
		String ismemoid= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				conn = ds.getConnection();
				String sql = "select id from join where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				System.out.println(id);
				
				rs = pstmt.executeQuery();
			
				if(rs.next()) {	
						ismemoid = "등록불가능한 아이디입니다.";
				}else {
						ismemoid = "등록가능한 아이디입니다..";	
				}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {

			conn.close(); 
		}

		return ismemoid;
	}
	
	public JoinDto getSelectJoin(String id) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select id, pwd, pwdcheck, name, pno, email from join where id=?";
		JoinDto dto = new JoinDto();
		try {
			conn = ds.getConnection();
			List<JoinDto> list = new ArrayList<>();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setPwdcheck(rs.getString("pwdcheck"));
			dto.setName(rs.getString("name"));
			dto.setPno(rs.getInt("pno"));
			dto.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int getUpdateJoin(JoinDto dto) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = ds.getConnection();
			String sql = "update join set id=?, pwd=?, pwdcheck=?, name=?,pno=?,email=? where id=?";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getPwdcheck());
			pstmt.setString(4, dto.getName());
			pstmt.setInt(5, dto.getPno());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getId());
			
			count = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	public int getDeleteJoin(String id) {
		
		int resultrow=0;
		PreparedStatement pstmt = null;
		String sql = "delete from join where id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			resultrow = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultrow;
	}
}
