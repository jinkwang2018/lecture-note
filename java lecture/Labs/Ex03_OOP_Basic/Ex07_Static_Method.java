//static method

class StaticClass {
	int iv;
	static int cv;
	
	//일반함수: 모든자원 가능
	void m() {
		//일반함수에서 iv 값을 처리(O)
		//일반함수에서 cv 값을 처리(O)
		//**point (생성시점을 생각) static자원은 일반자원보다 먼저 memory에 올라가기 때문
		iv = 500;
		// StaticClass.cv = 1000; // 클래스이름.static 자원 명		
		// 같은 클래스 내에서는 클래스이름 생략 가능
		cv = 1000;
		
		//StaticClass.sm(); 가능
		//**일반함수는 모든 static 자원 사용 가능
		
	}
	
	//static 함수: static자원만 가능
	static void sm() {
		//**일반자원인 iv 자원을 사용 (X)
		//생성시점에 대한 문제
		//StaticClass.sm(); 코드를 통해서 사용하려고 하면 문제가 생긴다 (iv는 메모리에 존재하지 않기 때문)
		
		//일반함수를 사용 void m() (X)
		
		//끼리끼리 놀아라 그러면 error는 없을 것이다
		System.out.println("static변수 cv: " + cv);
	}
	
}

public class Ex07_Static_Method {
	public static void main(String[] args) {
		System.out.println("main 함수");
		//StaticClass의 static자원은 메모리에 올라가지 않은 상태
		//(StaticClass를 쓰겠다고 명시하지 않았기 때문에: 메타데이터가 없는 상태)
		//StaticClass.cv = 5555; // StaticClass의 static자원이 메모리에 올라간 상태
		//StaticClass.sm();
		//여기까지 코드에서, 일반함수 void m() 사용할 수 없다.
		StaticClass sc = new StaticClass(); // 일반함수 void m()은 new연산자를 통한 객체생성 이후에 사용 가능
		//StaticClass 분석 클래스정보 + static 정보 >> class, method, static area
		//객체생성보다 static 항상 앞에 있다.
		
		sc.iv = 2222;
	}
}
