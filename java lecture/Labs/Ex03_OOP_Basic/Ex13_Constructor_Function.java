/*
생성자 함수 (constructor)
1.함수 ("특수한 목적"을 가지는 함수)
2.특수한 목적 (member field 초기화)

3.일반함수와 다른점
3.1 함수의 이름이 고정 (class 이름과 동일)
3.2 return type(x), void(x) >> 사실은 모든 생성자 함수 (void)
3.3 why void (default): 실행시점: 객체생성과 동시에 호출되는 함수: 생성된 값을 받을 녀석이 없어요
3.4 일반함수 (이름을 호출: print();), 생성자 함수는 new를 통해서 class가 객체로 만들어 질 때

4.목적: 생성되는 객체마다 다른 초기값을 부여할 때

5.함수는 overloading이 가능하다 (생성자 함수도 overloading 사용)

new Car(); 메모리에 올릴 때 함수를 호출하면서 올리겠다 (default constructor)

class 생성시 default 생성자는 생략 가능 >> 컴파일러가 만들어요

 */

class Car {
	String name;
	// Car() { System.out.println("나 생성자 함수야"); }
}

class Car2 {
	String carname; // member field
	Car2() { //생성자 함수 >> member field 초기화
		carname = "pony";
	}
}

class Car3 {
	int number;
	//권장사항: 생략해서 사용
	Car3() {
		System.out.println("의도된 코드 (초기화)");
	}
}
/////////////////////////////////////////////
class Car4 {
	int door;
	int wheel;
	
	Car4() { //default
		System.out.println("default");
	}
	
	Car4(int num) { //overloading
		door = num;
		System.out.println("overloading door");
	}
	
	Car4(int num, int num2) { //overloading
		door = num;
		wheel = num2;
		System.out.println("overloading door, wheel");
	}
}

//***** 아주 중요한 개발자의 의도 *****
//예외적으로 overloading된 생성자 함수가 하나라도 존재한다면
//컴파일러는 자동으로 default 생성자 함수를 만들지 않는다.
//만약 default 생성자 함수를 사용하고 싶다면 강제 구현 하세요

//개발자 의도: [강제적인 초기화] 의도
class Car5 {
	int number;
	Car5(int num) {
		number = num;
	}
}




public class Ex13_Constructor_Function {
	public static void main(String[] args) {
		Car c = new Car();
		Car2 c2 = new Car2();
		System.out.println(c2.carname);
		
		Car4 c4 = new Car4(10, 4);
		
		// Car5 c5 = new Car5(); // Error
		Car5 c5 = new Car5(2);
		System.out.println(c5.number);
	}
}
