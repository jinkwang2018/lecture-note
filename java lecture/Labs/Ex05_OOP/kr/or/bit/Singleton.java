package kr.or.bit;
//디자인 패턴 (생성 패턴)
//singleton >> 객체를 하나만 만들어서 공유

//하나의 객체를 생성해서 [공유하고 싶다면] ...static

//1. 여러 개의 객체를 생성 (new 연산자) 막는다 (생성자 private)
//2. 하나의 객체를 같이 공유 사용
//3. 결국 하나의 객체만 만들어 사용하게 하자

//실생활
//회사: 공유 프린터, 네트워크 자원 ...
//JDBC 수업때 활용 하는 코드 만나요^^

public class Singleton {
	private static Singleton p; //p 라는 변수가 Singleton 객체에 주소를 가지고 있게
	private Singleton() {} //생성자 private 접근자 객체를 생성하지 못하게
	
	public static Singleton getInstance() {
		if(p == null) {
			p = new Singleton(); //생성자 호출해서 메모리
		}
		return p;
	}
	
}
