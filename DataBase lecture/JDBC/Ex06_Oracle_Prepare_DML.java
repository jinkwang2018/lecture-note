import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.or.bit.utils.Singleton_Helper;

public class Ex06_Oracle_Prepare_DML {

	public static void main(String[] args) {
		//insert into dmlemp(empno,ename,deptno) values(?,?,?)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try{
			conn = Singleton_Helper.getConnection("oracle");
			System.out.println("사번을 입력하세요");
			int Int = Integer.parseInt(sc.nextLine());
			System.out.println("이름을 입력하세요");
			String str = sc.nextLine();
			System.out.println("부서번호를 입력하세요");
			int Int2 = Integer.parseInt(sc.nextLine());
			String sql = "insert into dmlemp(empno,ename,deptno) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,Int); 
			pstmt.setString(2,str);
			pstmt.setInt(3,Int2); 
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("insert row count : " + row);
				System.out.println("입력되었습니다.");
			}else {
				System.out.println("row count :" + row);
			}
			
		}catch(Exception e) {
			
		}finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(conn);
		}
		

	}

}
