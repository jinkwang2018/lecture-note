package kr.or.bit;
/*
함수: 기능의 최소단위 (method)

함수의 종류
	*void 사용하면 (돌려주는 값이 없다): return value가 없다
	*return type: [8가지 기본 타입] / String / 참조(사용자정의) / 배열 / Collection / Interface
		-return type 있으면 반드시 구문안에서 return 키워드를 명시
	*parameter: [8가지 기본 타입] / String / 참조(사용자정의) / 배열 / Collection / Interface
	
	1. void, parameter가 있다: void print(String str) { 실행코드 }
	2. void, parameter가 없다: void print() { 실행코드 }
	3. return type, parameter가 있다: int print(int data) { return 100 + data; }
	4. return type, parameter가 없다: int print() { return 200; }

**함수는 반드시 호출(Call) 되어야만 실행된다: 누군가 그의 이름을 불러주어야...
 */

public class Fclass {
	public void m() { // 함수의 이름은 의미있는 단어의 조합 void getChannelNumber()
		System.out.println("일반함수: void, param(x)");
	}
	
	public void m2(int i) {
		System.out.println("param value: " + i);
		System.out.println("일반함수: void, param(o)");
	}
	
	public int m3() { // return type 있으면 반드시 return 키워드 사용
		return 123;
	}
	
	public int m4(int data) {
		return data + 1;
	}
	// 
	// 접근자(한정자) private: class 내부에서만 사용 (다른 함수를 도와주는 역할)
	// 다른 여러개의 함수가 가지는 공통적인 내용을 한 곳의 함수에 모아서 기능 제공하면 유지보수(수정 처리)가 편하다 (모듈화)
	private int operationMethod(int data) {
		return data * 100;
	}
	
	public int sum(int data) {
		return operationMethod(data);
	}
	
	public int sum2(int data) {
		return operationMethod(data);
	}
	
	// 확장함수 (parameter ...)
	public int sum3(int i, int j) {
		return i + j;
	}
	
	// Quiz
	// a와 b 둘 중에 큰 값을 return 하는 함수를 만드세요
	// ex) max(500, 200) 이면 return 되는 값은 500
	// public int max(int a, int b) {}
	
	// **return은 한 번만 사용하는 것이 좋다.
	
	public int max(int a, int b) {
		return (a > b) ? a : b; //연산자로 해결
		// 내가 쓴 코드: return ((a - b) >= 0) ? a : b;
		
		/* 
		1. 30점짜리	
		if(a >= b) {
			return a;
		}else {
			return b;
		}
		
		2. 60점짜리
		int result = 0;
		if(a >= b) {
			result = a;
		}else{
			result = b;
		}
		return result;
		
		3. 100점짜리
		return (a > b) ? a : b;
		*/
	}
	
	public String concat(String s, String s2, String s3) {
		//String result = s + "/" + s2 + "/" + s3;
		//return result;
		return s + "/" + s2 + "/" + s3;
	}
	//여기까지는 쉬운편이다
	//클래스는 타입이다
	//public int call() {return 100;}
	//public Tv call() { return Tv; } (x) 메모리에 올리지 않은 상태이므로
	
	//[Today Point]
	//public Tv call() { Tv t = new Tv(); return t; } (o)
	//public Tv call() { return new Tv(); } (o) 위와 같은 코드이다.
	
	public Tv objMethod() {
		Tv t = new Tv();
		t.brandname = "LG";
		return t;
	}
	
	public Tv objMethod2() {
		return new Tv(); //new 연산자 heap 메모리에 Tv 객체를 만들고 주소를 생성하는 연산자
		//주소값 리턴
	}
	
	//기능 하나당 함수 한 개
	public void objMethod3(Tv t) { //Tv 타입을 갖는 객체의 주소를 넘기면 그 안에 정보를 출력하는 함수
		System.out.println("정보 출력");
		System.out.println("채널정보: " + t.ch);
		System.out.println("브랜드 이름: " + t.brandname);
	}
	
/*	
	public String concat(String s, s2, s3) { // 파라미터를 이렇게 하면 안됨. 타입을 각각 적어줘야됨.
		return;
	}
*/
}
