import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
 DML(insert, update, delete)
 JDBC 작업 결과
 1.결과 집합이 없다
 2.반영결과 return한다
 ex)Java 에서 
 	update emp set sal=0 >> 14건의 데이터 update >> return 14값을
 	update emp set sal=100 where empno = 77777; >> return 0
 
 성공<>실패(반영안된 경우) 한 경우에 로직 처리 가능
 KEY POINT
 1. 오라클(Developer , Cmd) 에서 DML 작업을 하면 반드시 commit,rollback 강제
 2. JDBC API 를 사용하는 Java 코드에서 >> DML 작업을 하면 >> commit,rollback 안해도 된다. default로 commit,rollback이다.
 3. Java code : delete from emp >> 실행 >> 데이터 처리 자동 commit
 4. 필요에 따라서는 commit() , rollback() Java 코드 단에서 제어
 
 	시작
 		A계좌 인출 (update...
 		
 		B계좌 입금(update...
 	
 	끝
 	하나의 논리적 단위(트랜잭션으로 묶인다.)
 	auto commit이라는 속성값을 false로 바꾸어야 자동 commit이 안된다.
 	이러한 처리가 필요한 순간에만.
 	option 값을 false로 바꾸면 DML작업을 할 때 commit , rollback을 해야한다.
 	
 	create table dmlemp
 	as
 		select * from emp;
 	alter table dmlemp
 	add constraint pk_dmlemp_empno primary key(empno);
 */
public class Ex03_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
			stmt = conn.createStatement();
			/*
			INSERT
			
			int empno = 0;
			String ename = "";
			int deptno = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("사번 입력 하세요");
			empno = Integer.parseInt(sc.nextLine());
			System.out.println("이름 입력 하세요");
			ename = sc.nextLine();
			System.out.println("부서 번호 입력 하세요");
			deptno = Integer.parseInt(sc.nextLine());
			//insert into dmlemp(empno , ename , deptno) values (100,'홍길동',10)
				
			String sql = "insert into dmlemp(empno , ename , deptno) ";
			sql += "values ("+empno+",'"+ename+"',"+deptno+")";
			//실제는 values(?,?,?)로 사용한다.
				
			int resultrowcount = stmt.executeUpdate(sql); // insert , update , delete모두 이 것을 사용한다.
			if(resultrowcount > 0) {
				System.out.println("반영된 행의 수 : " + resultrowcount);
			}else {
				//예외가 아니고 반영된 행이 없는 것 뿐이다. 
				System.out.println("Insert Fail : " + resultrowcount);
			}
			*/
			
			//UPDATE
			//update dmlemp set sal=0 where deptno = 값
			/*
			int deptno = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호 입력 하세요");
			deptno = Integer.parseInt(sc.nextLine());
			String sql = "update dmlemp set sal=0 where deptno="+deptno;
			int resultrowcount = stmt.executeUpdate(sql);
			if(resultrowcount > 0) {
				System.out.println("반영된 행의 수 : " + resultrowcount);
			}else {
				System.out.println("Insert Fail : " + resultrowcount);
			}
			*/
			//delete
			//delete from dmlemp where deptno = 값
			int deptno = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호 입력 하세요");
			deptno = Integer.parseInt(sc.nextLine());
			String sql = "delete from dmlemp where deptno ="+deptno;
			int resultrowcount = stmt.executeUpdate(sql);
			if(resultrowcount > 0) {
				System.out.println("반영된 행의 수 : " + resultrowcount);
			}else {
				System.out.println("Delete 된 행이 없습니다. : " + resultrowcount);
			}
			
			
		} catch (Exception e) {
			System.out.println("SQL Exception : " + e.getMessage());
		} finally {
			if(stmt != null) try {stmt.close();}catch(Exception e) {}
			if(conn != null) try {conn.close();}catch(Exception e) {}
		}
		
	}

}
