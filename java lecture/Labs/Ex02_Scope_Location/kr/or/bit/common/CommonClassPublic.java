package kr.or.bit.common;

public class CommonClassPublic {
	public int a;
	int b; // default 생략 되어 있다
	private int c; // 클래스 내부에서 사용 (다른 객체가 사용할 수 없다)
	               // 객체지향 언어 (데이터 보호)
	               // 직접 할당을 막고 간접 할당을 통해서 데이터 보호 (캡슐화)
	
	// 캡슐화의 예: (-)정수가 들어오면 안됨
	public void write(int value) {
		if(value < 0) {
			c = 0;
		}else {
			c = value;
		}
	}
	
	public int read() {
		return c;
	}
}
