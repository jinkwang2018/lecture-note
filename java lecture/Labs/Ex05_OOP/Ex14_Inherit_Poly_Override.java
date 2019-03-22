class Parent3 {
	int x = 100;
	void pmethod() {
		System.out.println("parent method");
	}
}

class Child3 extends Parent3 {
	int x = 200; // C# 재정의: 변수 무시하기 >> java 의미없는 코드
	void parent_x() {
		System.out.println(super.x);
	}
	
	//부모가 가지는 pmethod() 재정의(override)
	@Override
	void pmethod() {
		System.out.println("부모 함수 재정의");
	}
	
	void parent3_method() {
		super.pmethod(); //부모 주소로 가서 부모가 가지는 pmethod()
	}
}

public class Ex14_Inherit_Poly_Override {
	public static void main(String[] args) {
		Child3 ch = new Child3();
		System.out.println(ch.x);
		ch.parent_x();
		ch.pmethod();
		
		//다형성
		Parent3 pa = ch;
		System.out.println(pa.x);
		pa.pmethod(); //**재정의(override)된 함수 호출
		ch.parent3_method();
	}
}