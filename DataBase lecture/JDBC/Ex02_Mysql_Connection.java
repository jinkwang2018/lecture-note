import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 1.드라이버 참조 (프로젝트에 jar 파일 추가)
 2.드라이버 로딩 (JVM : class.forName(""))
 3.연결 객체 생성 -> DriverManager 클래스...
 4.명령 객체 생성 -> CRUD 작업 준비(Statement)
 5.명령 실행 -> DQL(select 데이터 1건 , select 모든 row) => 결과 집합 생성(ResultSet) ,
      	   DML(insert , delete , update) => 결과 집합 생성(x) => 성공 여부
 6.명령 처리(2가지) :DQL >  조회 , 출력  , 
 				DML > 결과에 따른 logic처리 (성공 or 실패에 대한 처리)
 7.자원 해제
 
 JDBC API (인터페이스 기반) >> Connection , Statement , 
 							PrepareStatement , ResultSet : 다형성이 적용된 코드(어떤 DB로 작업을 하던 표준화된 코드로 작업)
 */
public class Ex02_Mysql_Connection {

	public static void main(String[] args){
		/*
		Class.forName("com.mysql.jdbc.Driver"); //new memory 드라이버 로드
		System.out.println("오라클 드라이버 memory loading완료");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb?useSSL=true","kosta","1004");
		System.out.println("연결객체의 주소값을 return받음   "+conn.isClosed()); //isClosed가 false이면 연결된것이다.
		*/
		//1.드라이버 참조
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//2. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//3. 연결 객체 생성(주소값 할당 받기)
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb?useSSL=true","kosta","1004");
			
			//4. 명령 객체 생성
			stmt = conn.createStatement();
			
			//4.1 실행할 자원(query 문장)
			String job="";
			Scanner sc = new Scanner(System.in);
			System.out.println("직종 입력 : ");
			job = sc.nextLine();
			//where job = 'CLERK'
			//select empno, ename, job from emp where job = 'CLERK'
			String sql = "select empno, ename, job from emp where job = '" +job +"'";
			
			//5. 명령 실행
			//실행 하는 자원이 DQL : 결과 집합이 있다. >stmt.executeQuery(sql) > return ResultSet 객체의 주소를
			//	       DML : 결과 집합이 없다. >stmt.executeUpdate(sql) > 함수가 return하는 자원은 반영된 행의 갯수 
			//               >>delete query를 날렸을 때 return되는 값은 삭제된 행의 갯수
			//         인지 확인을 해야 한다.
			
			rs = stmt.executeQuery(sql);
			
			//6. 명령 처리
			//DQL : 1. 결과가 없는 경우 ( where empno = 55555)
			//		2. 결과가 한 건인 경우(PK,UK의 조건 조회) >> where empno = 7788;
			//	 	3. 결과가 여러개인 경우 >> select * from emp where deptno = 10;
			/*
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+","+rs.getString("ename")+","+rs.getString("job"));
			}
			1.간단하다.
			2.결과집합이 없는 경우에 대한 처리가 되지 않는다.
			*/
			/*
			if(rs.next()) {
				System.out.println(rs.getInt("empno")+","+rs.getString("ename")+","+rs.getString("job"));
			}else {
				System.out.println("조회된 데이터가 없습니다.");
			}
			1.결과 집합이 없을 경우에 대한 처리가 된다.
			2.한건 밖에 읽지 못한다. multi row read가 안된다.
			*/
			//두개의 장접을 합쳐놓은 logic
				if(rs.next()) {
					do {
						System.out.println(rs.getInt("empno")+","+
					rs.getString("ename")+","+rs.getString("job"));
					}
					while(rs.next());
					
				}else {
					System.out.println("조회된 데이터가 없습니다.");
				}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			//자원 해제
			/*
			 try {
			 
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			if(rs !=null)try {rs.close();}catch(Exception e2) {}
			if(stmt !=null)try {stmt.close();}catch(Exception e2) {}
			if(conn !=null)try {conn.close();}catch(Exception e2) {}
		}
	}

}
