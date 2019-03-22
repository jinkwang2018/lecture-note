import kr.or.bit.Emp;

//배열에서 가장 중요한 코드: 객체배열 -> 2번 작업하자. 1.방만들고 / 2.메모리올리고
//[실무에서 가장 많이 사용]
public class Ex04_Array_Object {
	public static void main(String[] args) {
		//사원 3명을 만드세요
		/*
		배열을 배우지 않았어요
		Emp e = new Emp();
		Emp e2 = new Emp();
		Emp e3 = new Emp();
		*/
		
		Emp[] emplist = new Emp[3];
		
		emplist[0] = new Emp();
		emplist[0].setEmpno(1000);
		emplist[0].setEname("홍길동");
		
		emplist[1] = new Emp(); //주소값 할당: emplist[1] 메모리 주소 할당
		emplist[1].insertEmp(2000, "김유신"); // 초기화
		
		emplist[2] = new Emp();
		emplist[2].insertEmp(3000, "유관순");
		
		//emplist 사원 번호와 사원이름을 출력하세요 (for)
		for(int i = 0; i < emplist.length; i++) {
			// System.out.println(emplist[i].getEmpno() + "/" + emplist[i].getEname()); // 내가 짠 코드
			emplist[i].empInfo();
		}
		
		//int[] arr = new int[]{10, 20, 30} 식으로 사원 3명 생성 정보 출력하세요
		Emp[] emplist2 = new Emp[] {new Emp(1,"이씨"), new Emp(2,"박씨"), new Emp(3,"김씨")};
		for(int i = 0; i < emplist2.length; i++) {
			emplist2[i].empInfo();
		}
		
		//int[] arr = {10, 20, 30} 식으로 사원 3명 생성 정보 출력하세요
		Emp[] emplist3 = {new Emp(111,"A"), new Emp(222,"B")};
		for(int i = 0; i < emplist3.length; i++) {
			emplist3[i].empInfo();
		}
	}
}
