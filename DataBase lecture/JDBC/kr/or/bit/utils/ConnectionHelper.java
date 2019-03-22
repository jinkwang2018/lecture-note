package kr.or.bit.utils;
/*
  전체 프로젝트에서 (회원 : 전체 조회페이지 , 조건 조회 페이지, 삭제 페이지, 수정 페이지)
  위의 각각의 페이지가 드라이버로딩,DB연결 있어야 DB작업이 된다. 
 refactoring
 1.반복적인 코드 줄인다.(드라이버 로딩 , 연결 객체 만들기, 자원 연결 해제 , 명령)
 2.Oracle , Mysql 둘을 연동했을 때 문제 없는 코드
 
 반복적인 코드 제거
 개선 >> 패턴 >> Singleton >> 하나의 객체 공유
 class 설계 > 많이 사용되는 기능 (method) > static >> overloading > 다형성확보
 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionHelper {
	

	public static Connection getConnection(String dsn) {// Oracle , mysql이라는 문자를 받아서 처리
		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bituser", "1004");
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb?useSSL=true", "kosta", "1004");
			}
		} catch (Exception e) {

		}
		return conn;
	}

	public static Connection getConnection(String dsn, String id, String pwd) {// Oracle , mysql이라는 문자를 받아서 처리
		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", id, pwd);
			} else if (dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb?useSSL=true", id, pwd);
			}
		} catch (Exception e) {

		}
		return conn;
	}

	// 연결 해제
	// if(stmt != null) try {stmt.close();}catch(Exception e) {}
	// if(conn != null) try {conn.close();}catch(Exception e) {}
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
