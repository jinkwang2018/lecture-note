import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.Singleton_Helper;

public class Ex04_ConnectionHelper {

	public static void main(String[] args) throws Exception {
		/*
		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		ConnectionHelper.close(conn);
		System.out.println("연결여부 : " + conn.isClosed());
		
		//연결객체가 재활용 가능한 객체일까?
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		ConnectionHelper.close(conn);
		System.out.println("연결여부 : " + conn.isClosed());
		
		//1. return 받은 Connection 객체의 주소가 : 78e03bb5 >> 1번째
		//2. return 받은 Connection 객체의 주소가 : 22a67b4 >> 2번째
		//result : getConnection함수를 호출 할 때마다 새로운 객체를 생성
		//하나의 APP에서 연결 객체가 하나만 사용되면 되는데 >> 한번 만들고 재사용을 하는 것이 좋을 것 같다
		//하나의 객체를 공유해서 사용 >> Singleton 
		conn = ConnectionHelper.getConnection("oracle","hr","1004");
		System.out.println("연결여부 : " + conn.isClosed());
		ConnectionHelper.close(conn);
		//mysql연결
		Connection myconn = null;
		myconn = ConnectionHelper.getConnection("mysql");
		System.out.println(myconn.toString());
		System.out.println(myconn.getMetaData().getDatabaseProductName());
		System.out.println(myconn.getMetaData().getDatabaseProductVersion());
		ConnectionHelper.close(myconn);
		System.out.println("연결여부 : " + myconn.isClosed());
		*/
		//Singleton_Helper 사용하기
		//두 개의 DB접속
		//문제점) 공유자원 -> 참조하는 모든 자원도 영향
		//singleton은 close를 하면 안된다. -> 서버종료할 때 까지 연결 종료는 하면 안된다. 
		//
		Connection conn = null;
		conn = Singleton_Helper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		Singleton_Helper.close(conn);
		System.out.println("연결여부 : " + conn.isClosed());
		
		
	}

}
