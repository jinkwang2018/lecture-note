package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.dto.memo;
import kr.or.kosta.utils.Singleton_Helper;

//CRUD 작업
//DB 통신 하고 -> CURD 작업 method 제공
//memo table > select , insert , update, delete 함수제공
//Read > 단일행(where id=?) , 다중행(select * from memo)
//default 5개 함수 

//객체지향
//당신이 함수 생성 (parameter , return type) 고민

//public int insertmemo(String id, String email, String content){  }
//public int insertmemo(memo m){  } > (0)

//단일 select
//public memo selectByMemoId(String id){  where id=?   }

//다중 select 
//public  List selectMemo() {  List<memo> list = new ArrayList<mono>();    }
public class memodao {
	Connection conn = null;
	public memodao() {
		conn = Singleton_Helper.getConnection("oracle");
	}
	
	//Read : 한건 데이터 (반드시 테이블에 primary key 컬럼 대상)
	public memo getMemoListById(String id) throws SQLException {
		//select id,email,content from memo where id=?
		//memo m = new memo();
		//m.setId(rs.getInt(1));
		//return m;
		PreparedStatement pstmt = null;
		String sql = "select id,email,content from memo where id = " + id;
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		memo m = new memo();
		m.setId(rs.getString("id"));
		m.setEmail(rs.getString("email"));
		m.setContent(rs.getString("content"));
		
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
		
		return m;
		
	}
	
	//Read : 여러건 데이터(where 조건이 없어요)
	public ArrayList<memo> getMemoList() throws SQLException{
		//select id,email,content from memo
		
		//Class.forName("oracle.jdbc.OracleDriver");
		//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosta","1004");
		//위 코드 생략
		
		PreparedStatement pstmt = null;
		String sql = "select id,email,content from memo";
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<memo> memolist = new ArrayList<memo>();
		 
		while(rs.next()) {
			memo m = new memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			memolist.add(m);
		}
		
		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);
		
		return memolist;
	}
	
	//parameter (memo m)
	public int insertMemo(String id, String email, String content) {
		//insert into memo(id,email,content) values(?,?,?)
		int resultrow=0;
		PreparedStatement pstmt = null;
		try {
			   
			   String sql="insert into memo(id,email,content) values(?,?,?)";
			   
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, id);
			   pstmt.setString(2, email);
			   pstmt.setString(3, content);
			   
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			Singleton_Helper.close(pstmt);
		}
 
		return resultrow;
	}
	
	public int updateMemo(memo m) {
		//update memo set email=? , content=? where id=?
		PreparedStatement pstmt = null;
		String sql = "update koreamember set id=? , email=? , memo=? where id=?";
		pstmt = conn.prepareStatement(sql);
		
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, email);
		pstmt.setString(3, memo);
		
		pstmt.executeUpdate();
		return 0;
	}
	
	
	public int deleteMemo(String id) {
		int resultrow=0;
		PreparedStatement pstmt = null;
	     	
	    try{
	   	String sql = "delete from memo where id=?";
	   	pstmt = conn.prepareStatement(sql);		
	    resultrow = pstmt.executeUpdate();	
	    
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	    	Singleton_Helper.close(pstmt);
	    }
	    
		return resultrow;
	}
	
	
	//추가함수 (비동기 통해서 ID 유무)
	public String isIdCheckById(String id) {
		String ismemoid= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
				String sql = "select id from memo where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//do {
						//String id = rs.getString("id")
						ismemoid = "false";
						
					//}while(rs.next());
				}else {
						ismemoid = "true";
				}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		//System.out.println("ismemoid : " + ismemoid);
		return ismemoid;
	}
	
	//필요하다면 추가 구현
	//Like 검색 함수
	//id,pwd 검사 함수 ....
}






