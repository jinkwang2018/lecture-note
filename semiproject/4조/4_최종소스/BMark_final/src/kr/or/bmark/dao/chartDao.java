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

import kr.or.bmark.dto.chart;

/* 
* @FileName : chartDao.java 
* @Project : BMark
* @Date : 2018.04.11. 
* @Author : 김래영 
*/ 
public class chartDao {
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
	
	//특정 카테고리 선택시 해당 데이터 불러오기
	public List<chart> getChartTop5List(String category) throws SQLException {
		List<chart> chartlist = null;
		
		try {
			conn = ds.getConnection();
			String sql = "select * from (select cname, name, hit, writeday " 
				+ "from siteinfoboard site join scategory cate " 
				+ "on site.ccode = cate.ccode " 
				+ "where cname = ? "
				+ "order by hit desc)"
				+ "where rownum <= 5";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			// 객체 형태인 DB 데이터에 담기
			chartlist = new ArrayList<chart>();
			
			while (rs.next()) {
				String cname = rs.getString("cname");
				String name = rs.getString("name");
				int hit = rs.getInt("hit");
				String writeday = rs.getString("writeday");
				
				chart dto = new chart(cname, name, hit, writeday);
				chartlist.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			rs.close();
			pstmt.close();
			conn.close();			
		}
		return chartlist;
	}
	
	public List<chart> getChartcategoryList() throws SQLException {
		List<chart> categorylist = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "select cname from scategory";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			categorylist = new ArrayList<chart>();
			
			while (rs.next()) {
				String cname = rs.getString("cname");
				chart dto = new chart(cname);
				categorylist.add(dto);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			rs.close();
			pstmt.close();
			conn.close();			
		}
		
		return categorylist;
	}
}
