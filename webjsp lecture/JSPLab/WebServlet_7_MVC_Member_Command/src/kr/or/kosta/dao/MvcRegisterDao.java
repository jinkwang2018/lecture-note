package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.kosta.dto.MvcRegister;

public class MvcRegisterDao {
	static DataSource ds;
	//1. 생성자에서 ds 객체 초기화 가능 
	//2. static 자원 초기화  static { } 초기자 함수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	static {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			Context envctx = (Context)ctx.lookup("java:comp/env"); //기본 설정
			ds = (DataSource)envctx.lookup("/jdbc/oracle"); //context.xml (name="jdbc/oracle")
			
		}catch (Exception e) {
			System.out.println("look up fail : " + e.getMessage());
		}
	}
	//Context context = new InitialContext();
	//datasource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
	
	//CRUD 함수 생성
	public int writeOk(MvcRegister dto) {
		int row = 0;
		try {
				conn = ds.getConnection();
				String sql="insert into mvcregister(id,pwd,email) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getId());
				pstmt.setString(2, dto.getPwd());
				pstmt.setString(3, dto.getEmail());
				
				row = pstmt.executeUpdate();
				
		}catch(Exception e) {
			 System.out.println("writeOk Exception : " + e.getMessage());
		}finally {
			if(pstmt != null)try { pstmt.close(); }catch(Exception e) {}
			if(conn != null)try { conn.close(); }catch(Exception e) {}
		}
		return row;
	}
	
	//단일 select 함수
	
	//다중 select 함수
	
	//update 함수
	
	//delete 함수
}
