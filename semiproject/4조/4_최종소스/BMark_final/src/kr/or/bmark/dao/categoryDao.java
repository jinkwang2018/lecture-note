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

import kr.or.bmark.dto.category;
import kr.or.bmark.dto.team;

public class categoryDao {
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
	public categoryDao() {
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
	 * @date   : 2018. 4. 18.
	 * @desc   : 카테고리 정보 가져오기.
	 * @param 
	 * @return category
	 */
	public List<category> getCategoryList(){
		String sql="SELECT * FROM SCATEGORY order by ccode";
		List<category> categorylist = new ArrayList<category>();
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				category cate= new category();
				
				cate.setCcode(rs.getInt("ccode"));
				cate.setCname(rs.getString("cname"));
				
			
				categorylist.add(cate);
			}
			
			
		}catch(Exception ex){
			System.out.println("getCategoryList 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return categorylist;
	}
	
	//카테고리코드 최대값 +1 반환 (중복코드방지)
	public int getMaxCcode() {
		String sql="SELECT max(ccode)+1 as maxcode FROM SCATEGORY";
		int maxcode=0;
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				maxcode = rs.getInt("maxcode");
			}
			
			
		}catch(Exception ex){
			System.out.println("getMaxCcode 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return maxcode;
	}
	
	//신규 카테고리 값 INSERT
	public int writeok(category category) {
		String sql="INSERT INTO SCATEGORY VALUES (?,?)";
		int row = 0;
		
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,category.getCcode());
			pstmt.setString(2,category.getCname());
			
			row = pstmt.executeUpdate();
			
			
			
		}catch(Exception ex){
			System.out.println("writeok 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return row;
	}
	//기존 카테고리 삭제 DELETE
		public int deleteok(category category) {
			String sql="delete from SCATEGORY where ccode=? ";
			int row = 0;
			
			try{
				con=ds.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,category.getCcode());
				
				row = pstmt.executeUpdate();
				
				
				
			}catch(Exception ex){
				System.out.println(" deleteok에러: " + ex);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
			}
			return row;
		}
}	
	