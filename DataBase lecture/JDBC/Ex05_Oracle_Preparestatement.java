import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.utils.Singleton_Helper;

/*
 <1> Statement stmt = con.createStatement(); //생성       
 				stmt.executequery("select * from emp");//실행
 	같은 statement로 재사용 가능하다.(쿼리문을 바꾸어서 실행 가능하다)
 	parameter가 없는 경우 >> 고정된 쿼리문 (컬럼명, 테이블명, 시스템정보)...
 <2> PreparedStatement pstmt = con.prepareStatement("select * from emp"); //생성  
     					query문을 DB로 보내서 컴파일 시키고 쿼리의 정보를 가지고 있는 객체를 리턴한다.
 						pstmt.execute(); //실행
 	같은 preparedstatement는 재사용 불가하다.검색이 빠르다.보안이 강하다.
 */
public class Ex05_Oracle_Preparestatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null; //권장 ( 성능, 보안)
		ResultSet rs = null;
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "select empno,ename from emp where deptno=?"; 
			//parameter > ?로 표시한다. >> 순서가 중요
			
			pstmt = conn.prepareStatement(sql); //쿼리문을 같이 보내서 컴파일 한 것을 객체로 return받는다.
			
			//컴파일 이후에는 parameter만 넘기면 된다.
			pstmt.setInt(1,30); // parameter 값을 30으로 설정
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1) +  "/" + rs.getString(2));
				}while(rs.next());
				
			}else {
				System.out.println("no Data");
			}
		}catch(Exception e) {
			
		}finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(conn); //다른 페이지가 사용을 하면 쓰면 안된다.
		}

	}

}
