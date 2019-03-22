package kr.or.kosta.utils;
/* 2단계 개선 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// ConnectionHelper con2 = new ConnectionHelper(); ?????
// 객체를 직접 만들지 못하게 하자
// 2단계 개선 : 싱글톤
// -> 생성자를 private!

// 문제 ==>> 처음에 "oracle"이 들어가면 이미 static으로 만들어둔 oracle객체가 있어서
//			 mysql객체가 만들어지지 않는다.
//		==>> conn.close() > 연결해제. 자원해제가 아님 DB의 연결을 종료하는 것 뿐
public class Singleton_ConnectionHelper {
	private static Connection conn = null;
	/* 직접적인 객체 생성을 막기위해 생성자에 private제한 */
	private Singleton_ConnectionHelper() {
	}

	public static Connection getConnection(String dsn) {
		if (conn != null) {
			System.out.println("conn is not null");
			return conn;
		}
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
												   "bituser", 
												   "1004");
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kglimdb",
												   "hong", 
												   "1004");
			}
		} catch (Exception e) {

		} finally {
			System.out.println("conn");
			return conn;
		}
	}

	public static void DBclose() {
		if (conn != null) {
			try {
				conn.close(); // 연결종료
				conn = null; // conn의 주소값도 없애버리기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close(); 
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close(); 
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close(); 
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close(); 
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
