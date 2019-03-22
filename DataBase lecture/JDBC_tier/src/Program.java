import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import DAO.DeptDao;
import DTO.Dept;

//View , Controller역할을 하는 것
/*
 MVC
 
 model > DTO(VO,DOMAIN) , DAO
 	   > DTO(Data Transfer Object) == VO(Value Object)
 	   > DAO(Data Access Object)
 	   1.DTO 의 클래스 생성
 	   EMP Table>> DTO클래스 >> class Emp{컬럼의 타입}
 	   >> Emp e = new Emp();
 	   >> e.setEmpno(100);
 	   >> e.setEname("홍길동");
 	   >> List<Emp> list = new ArrayList<>();
 	   >> list.add(new Emp()); : 담을 때
 	   
 	   DEPT Table >> DTO 클래스 >> class Dept{컬럼의 타입}
 	   
 	   2.DAO 클래스 생성
 	   >>CRUD 작업을 할 수 있는 클래스 -> CRUD 처리 함수를 모아 놓은 클래스
 	   >>전체조회,조건조회,삽입,수정,삭제 
 	   >>DAO class는 최소 5개의 함수를 가지고 있다.
 VIEW
 CONTROLLER
 */
public class Program {

	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		int deptno = 0;
		String dname = null;
		String loc = null;
		Dept dept = null;
		List<Dept> list = null;
		Iterator it = null;
		Scanner sc = new Scanner(System.in);
		int menunum = 0;
			
		do {
			System.out.println("1.전체 조회, 2.조건 조회 , 3.삽입, 4.수정, 5.삭제, 6.알파벳으로 검색  7.종료");
			System.out.println("원하시는 메뉴를 입력하세요");
			int selectnum = Integer.parseInt(sc.nextLine());
			switch (selectnum) {
			case 1: // 1. 전체 조회
				list = dao.getDeptAllList();
				it = list.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;
			case 2:
				// 2. 조건 조회(요청) >>파악
				System.out.println("조회하실 부서 번호를 입력하세요");
				deptno = Integer.parseInt(sc.nextLine());
				dept = dao.getDeptListByDeptno(deptno);
				if (dept == null) {
					System.out.println("조회하신 부서 번호가 없습니다.");
				} else {
					System.out.println(dept.toString());
				}

				break;
			case 3:
				// 3. 삽입
				dept = new Dept();

				System.out.println("부서번호를 입력하세요");
				deptno = Integer.parseInt(sc.nextLine());
				System.out.println("부서이름을 입력하세요");
				dname = sc.nextLine();
				System.out.println("부서 위치를 입력하세요");
				loc = sc.nextLine();
				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLoc(loc);
				int insertdept = dao.insertDept(dept);
				System.out.println(insertdept);
				
				break;
			case 4:
				// 4.update
				dept = new Dept();

				System.out.println("부서번호를 입력하세요");
				deptno = Integer.parseInt(sc.nextLine());
				System.out.println("부서이름을 입력하세요");
				dname = sc.nextLine();
				System.out.println("부서 위치를 입력하세요");
				loc = sc.nextLine();
				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLoc(loc);
				dao.updateDept(dept);
				break;
			case 5:
				// 5.delete
				System.out.println("삭제 할 부서번호를 입력하세요");
				deptno = Integer.parseInt(sc.nextLine());
				dao.deleteDept(deptno);
				System.out.println(deptno + " 의 부서가 삭제되었습니다.");
				break;
			case 6:
				System.out.println("조회 할 부서명의 알파벳을 입력하세요");
				String alpha = sc.nextLine();
				list = dao.getDeptListByDname(alpha);
				it = list.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;

			case 7:
				System.out.println("종료되었습니다.");

			}

		} while (menunum != 7);
	}

}
