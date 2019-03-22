package kr.or.bit;

public class Program {
	public static void main(String[] args) {
		Emp e = new Emp();
		e.empno = 1000;
		e.ename = "홍길동";
		e.setJob("영업");
		
		String info = e.getEmpInfo(); // 함수 호출
		System.out.println(info);
		
		Emp e2 = new Emp();
		e2.empno = 1000;
		e2.ename = "김유신";
		e2.setJob("IT");
		
		info = e2.getEmpInfo();
		System.out.println(info);
	}
}
