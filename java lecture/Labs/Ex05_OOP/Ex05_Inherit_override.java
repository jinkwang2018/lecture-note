import kr.or.bit.Emp;

class Test2 {
	void print() {
		System.out.println("부모함수(Test2)");
	}
}

class Test3 extends Test2 {
	@Override
	void print() {
		System.out.println("자식함수(Test3) 개발자 마음대로");
	}
	
	//override (x)
	//오버로딩 (parameter 개수와 타입을 달리해서): 상속관계와 상관없음
	void print(String s) {
		System.out.println("나는 오버로딩 함수 " + s);
	}
}




public class Ex05_Inherit_override {
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.print(); //재정의 된 함수
		t.print("오버로딩");
		String str = t.toString();
		System.out.println("재정의 하지 않은 toString(): " + str);
		System.out.println("toString() 함수가 default로 호출: " + t);
		//내부적으로 t.toString() 같은 결과 >> t 변수 출력하면
		
		Emp e = new Emp(1000, "홍길동");
		String str2 = e.toString();
		System.out.println(str2);
		System.out.println(e);
	}
}
