package kr.or.kosta.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.kosta.DTO.AdminListDTO;
import kr.or.kosta.utils.Singleton_ConnectionHelper;

public class AdminListDAO {

	Connection conn= null;
	
	
	public AdminListDTO login(String id){
		//반복되는 선언부
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminListDTO admindto = new AdminListDTO();

		try{
			conn = Singleton_ConnectionHelper.getConnection("oracle");
			String sql="select userid, pwd from adminlist where userid=?";
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				admindto.setUserid(rs.getString(1));
				admindto.setPwd(rs.getString(2));
			}
			
			
		}catch(Exception e){
			//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
			
		}finally{
			if(pstmt != null) try{pstmt.close();}catch(Exception e){}

		}
			return admindto;
		}
}
