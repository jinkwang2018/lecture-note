package kr.or.bit;

public class Emp {
	private int empno;
	private String ename;
	
	//생성자를 만드는 코드 (overloading constructor)
	//생성자 함수 (member filed 초기화: 객체생성과 동시에 처리)
	//함수의 이름은 클래스 이름과 동일
	public Emp() {
		//default constructor 기본 생성자
	}
	public Emp(int empno, String ename) {
		//overloading constructor
		this.empno = empno;
		this.ename = ename;
	}
	
	public void insertEmp(int data, String data2) {
		empno = data;
		ename = data2;
	}
	
	public void setEmpno(int data) {
		empno = data;
	}
	public int getEmpno() {
		return empno;
	}
	
	//자동 생성
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public void empInfo() {
		System.out.println(empno + " / " + ename);
	}
	
}
