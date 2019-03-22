/*
객체 지향언어 (OOP) 3대 특징
1. 상속, 다형성, 캡슐화(은닉화)

2. 상속
java : Child extends Base
C#   : Child : Base

3. 상속 특징
3.1 다중상속은 불가
3.2 단일상속 지원 (여러개의 클래스 상속 받고 싶다면: 계층적 상속)
3.3 다중상속 지원 (유일하게 Interface 만)

4. 의미
진정한 의미: [재사용성]
단점: 초기 설계비용

재사용성 >> 설계시 >> 비용(시간, 공통모듈처리(분모,추상화))

1) memory 자리를 잡는 시점
	Object >> GrandFather >> Father >> Child 순으로 heap memory에
	할아버지가 없으면 아버지가 없고, 아버지가 없으면 아들이 없다.
	
2) 유저가 만드는 모든 클래스는 기본적으로 default: Object 상속 받음
 */
 
class GrandFather extends Object {
	public int gmoney = 5000;
	private int pmoney = 10000; // private 접근자 상속관계 성향 유지
	public GrandFather() {
		System.out.println("할아버지 생성자");
	}
}

class Father extends GrandFather {
	public int fmoney = 1000;
	public Father() {
		System.out.println("아버지 생성자");
	}
}

class Child extends Father {
	public int cmoney = 100;
	public Child() {
		System.out.println("자식 생성자");
	}
}

public class Ex01_Inherit_ {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.gmoney); //할아버지 돈도 내돈
		System.out.println(c.fmoney); //아버지 돈도 내돈
		System.out.println(c.cmoney); //내돈도 내돈
		
		//System.out.println(c.pmoney); //private 자원 접근 불가
	}
}
