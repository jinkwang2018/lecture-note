package kr.or.bit;
//사원은 사번, 이름, 직종(job)을 가지고 있다 => 원칙(캡슐화) => read, write 지원 setter, getter
//사원 생성시 default로 사번=9999, 이름=아무개, 직종=인턴
//Employee e = new Employee()
//별도의 사번, 이름, 직종을 통해서 사원 생성도 가능하다
//사원이 가지는 사번, 이름, 직종 생성 후 각각 수정할 수 있다
//사원정보는 사번, 이름, 직종을 한번에 확인할 수 있고 (각각의 정보를 확인 불가 하다)
public class Employee {
	private int empno;
	private String ename;
	private String job;
	
	//default constructor
	public Employee() {
		empno = 9999;
		ename = "아무개";
		job = "인턴";
	}
	//overloading constructor
	public Employee(int no, String name, String jobdata) {
		empno = no;
		ename = name;
		job = jobdata;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	//일반 함수
	public void employeeInfo() {
		System.out.printf("사번: [%d], 이름: [%s], 직종: [%s]\n", empno, ename, job);
	}
	
}
