package kr.or.bit;

/*
만든이 : 홍길동
날짜    : 2018-01-23
파일    : Emp.java (사원정보)

class 설계도이다
설계도는 기본적인 구성요소 (상태정보 (속성): 변수 + 행위정보 (기능): 함수)

*/


public class Emp {
	public int empno; // 사원 (변수 > 상태정보 > member field > instance variable)
 // (접근자) (타입) (변수)
	public String ename; // 이름
	private String job; // 직종 
	
	// 행위정보 (기능) > 함수
	// 함수는 (호출) > 동작
	public String getEmpInfo() {
		return this.empno + "/" + this.ename + "/" + this.getJob();
	} // this는 현재 클래스를 뜻함.
	
	// private String job; 대해서 처리하는 코드
	// 함수 2개 생성
	// 캡슐화 (은닉화)
	// 직접할당을 막고 간접할당을 통해서 원하는 값만 입력 또는 리턴 가능
	// setter 함수, getter 함수
	
	// private 접근자를 가지는 변수에 대해서
	// 읽기 전용 (read) 함수
	public String getJob() {
		return job + "입니다.";
	}

	// 쓰기 전용 (write) 함수
	public void setJob(String job) {
		this.job = job;
	}
}


