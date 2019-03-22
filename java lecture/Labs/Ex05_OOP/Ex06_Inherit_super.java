//하나의 클래스에서는
//this: 객체 자신을 가르키는 this ( this.name, this.age )
//this: 생성자를 호출하는 this ( this("홍길동", 100) )

//상속관계에서
//super(부모의 주소): 상속관계에서 [부모]자원에 접근
//this랑 역할이 동일
//1. super: 상속관계에서 부모 자원에 접근
//2. super: 상속관계에서 부모 자원의 생성자를 명시적으로 호출

//Tip: base (C#)

class Base{
	String basename;
	Base() {
		System.out.println("Base 클래스의 기본 생성자");
	}
	Base(String basename) {
		this.basename = basename;
		System.out.println("super를 통해서 호출된 생성자: " + this.basename);
	}
	void baseMethod() {
		System.out.println("baseMethod()");
	}
}

class Derived extends Base{
	String dname;
	Derived() {
		System.out.println("Derived 클래스의 기본 생성자");
	}
	Derived(String dname) {
		//super 용법
		super(dname);
		this.dname = dname;
		System.out.println("dname: " + this.dname);
	}
	void derivedMethod() {
		System.out.println("derivedMethod()");
	}
	//부모가 가지는 baseMethod() 재정의
	@Override
	void baseMethod() {
		System.out.println("부모 함수 재정의 했습니다");
	}
	//부모 자원이 그리워요 (재정의 한 자원)
	void p_method() {
		//super: 부모 객체의 주소
		super.baseMethod(); //부모함수 호출
	}
}

public class Ex06_Inherit_super {
	public static void main(String[] args) {
		/*
		Derived d = new Derived();
		d.baseMethod();
		d.derivedMethod();
		d.p_method();
		*/
		Derived d2 = new Derived("홍길동");
		//parameter 처리하면 부모쪽에도 같이 처리하고 싶어요
		
	}
}
