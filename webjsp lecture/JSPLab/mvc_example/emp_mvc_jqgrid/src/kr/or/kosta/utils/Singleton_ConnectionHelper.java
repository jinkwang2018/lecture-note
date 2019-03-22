package kr.or.kosta.utils;
/* 2�ܰ� ���� */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// ConnectionHelper con2 = new ConnectionHelper(); ?????
// ��ü�� ���� ������ ���ϰ� ����
// 2�ܰ� ���� : �̱���
// -> �����ڸ� private!

// ���� ==>> ó���� "oracle"�� ���� �̹� static���� ������ oracle��ü�� �־
//			 mysql��ü�� ��������� �ʴ´�.
//		==>> conn.close() > ��������. �ڿ������� �ƴ� DB�� ������ �����ϴ� �� ��
public class Singleton_ConnectionHelper {
	private static Connection conn = null;
	/* �������� ��ü ������ �������� �����ڿ� private���� */
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
				conn.close(); // ��������
				conn = null; // conn�� �ּҰ��� ���ֹ�����
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
