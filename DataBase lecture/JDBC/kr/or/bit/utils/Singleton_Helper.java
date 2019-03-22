package kr.or.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Singleton_Helper {
	
		private static Connection conn = null; // p라는 변수가 Singleton 객체의 주소를 가지고 있게 할 것이다.

		private Singleton_Helper(){}// 생성자 앞에는 일반적으로 public이 와야한다. 생성자를 private로 객체생성 못하게
		
		public static Connection getConnection(String dsn) {
			if (conn != null) {
				System.out.println("conn is not null");
				return conn;
			}
			try {
				if (dsn.equals("oracle")) {
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bituser", "1004");
				} else if (dsn.equals("mysql")) {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb?useSSL=true", "kosta", "1004");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("conn return");
			return conn;
		}
		public static void dbclose(Connection conn) {

			if (conn != null)
				try {
					conn.close();
					conn = null; //참조를 null을 만들어야한다.
				} catch (Exception e) {

				}
		}
		
		public static void close(ResultSet rs) {

			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {

				}
		}

		public static void close(Statement stmt) {

			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {

				}
		}

		public static void close(Connection conn) {

			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {

				}
		}

		public static void close(PreparedStatement pstmt) {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {

				}
		}
	

	
}
