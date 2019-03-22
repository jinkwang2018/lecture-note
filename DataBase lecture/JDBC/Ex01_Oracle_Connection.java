import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 JDBC
 1.java 언어를 통해서 Oracle Database에 연결하고 CRUD 작업을 하는 것.
 
 2.어떠한 DB 소프트웨어 사용에 대한 결정이 필요하다.(oracle, my-sql, ms-sql)
 2.1 제품에 맞는 드라이버가 필요하므로 
 2.2 oracle은 드라이버(ojdbc6.jar)가 폴더내에 이미 존재한다.
 
 3.Cmd 기반의 Java Project에서는 드라이버 사용하기 위해서 참조
 3.1 java build path(jar 추가) 하는 작업이 필요하다. >> properties에서 경로 설정한다.
 3.2 드라이버 사용준비 완료 >> 드라이버 사용할 수 있도록 메모리(new)
 3.3 class.forName("class name") >>을 하면 메모리에 올라간다. new와 동일한 효과이지만 참조변수이다.
 
 4.JAVA(JDBC API)
 4.1 import java.sql.* 제공하는 자원의 대부분이 interface로 노출되어 있다.
 4.2 개발자는 interface만 사용 ( 궁금증 : 왜 인터페이스 일까? ) >> 다른 언어에서도 사용하기 편하도록 다형성을 사용한 것이다.
 
 5.DB연결 -> 명령  -> 실행 -> 처리 -> 자원해제 ****외우기
 5.1 명령(CRUD) :select , insert , update , delete
 5.2 처리 : 명령한 것을 화면 출력 or 확인만 하기 등등...
 5.3 자원해제 (성능에 대한 문제) >> 잘못하면 server가 죽는다.
 
 연결 문자열 (ConnectionString) 설정
 채팅(client -> server 연결하기 위해서)
 네트워크를 통해서 DB Server에 연결하려면 server ip , server port number , 
 							SID(전역 데이터베이스 이름) , 접속계정 , 비밀번호가 필요하다.
 */

public class Ex01_Oracle_Connection {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver"); //new memory 드라이버 로드
		System.out.println("오라클 드라이버 memory loading완료");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
		System.out.println("연결객체의 주소값을 return받음   "+conn.isClosed()); //isClosed가 false이면 연결된것이다.
		
		Statement stmt = conn.createStatement();
		System.out.println("명령 객체 획득 성공");
		
		//CRUD
		String sql = "select empno , ename , sal from emp"; //명령
		
		ResultSet rs = stmt.executeQuery(sql); // select한 결과에 대한 내용을 보는 ResultSet을 return
		
		//처리
		while(rs.next()) {
			System.out.println(rs.getInt("empno")+"/"+rs.getString("ename")+"/"+rs.getInt("sal"));//컬럼 명 , 컬럼의 index를 쓴다.
		}
		//연결해제
		rs.close();
		stmt.close();
		conn.close();
		System.out.println("DB 연결 : " + conn.isClosed());
	}

}
