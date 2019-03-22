import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.bit.utils.Singleton_Helper;

/*
   Transaction
 	하나의 논리적인 작업단위
 
 create table trans_A(
  num number,
  name varchar2(20)
);

create table trans_B(
  num number constraint pk_trans_B_num primary key,
  name varchar2(20)
);	

JDBC >> autocommit이다.
trans_A , trans_B 하나의 논리적 단위로 묶는다.(transaction처리)
JDBC >> autocommit을 false로 만들 것이다.

 */
public class Ex07_Oracle_Transaction {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		conn = Singleton_Helper.getConnection("oracle");
		String sql = "insert into trans_A(num,name) values(100,'A')";
		String sql2 = "insert into trans_B(num,name) values(100,'B')";
		try {
			conn.setAutoCommit(false); // 개발자가 commit,rollback을 해야한다.
			//begin transaction이다.
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			
			//두개의 query가 정상적으로 실행되었다면 (commit) 예외가 발생했다면 (rollback)
			conn.commit();
		}catch(Exception e) {
			System.out.println("문제 발생 : " + e.getMessage());
			conn.rollback();
		}finally {
			Singleton_Helper.close(pstmt2);
			Singleton_Helper.close(pstmt);
			Singleton_Helper.close(conn);
		}
	}

}
