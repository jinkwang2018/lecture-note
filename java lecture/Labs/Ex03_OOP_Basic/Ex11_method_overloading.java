/*
객체 지향 언어 특징
상속, 캡슐화, 다형성

캡슐화 (은닉화) -> private

[method overloading]
하나의 이름으로 여러가지 기능을 하는 함수
사용: println() 대표적인 함수
특징: 오버로딩은 성능 향상에 도움을 준다 (x) -> 상관없다
     why) 개발자가 편하게 사용하려고
	  설계시 어떤 점을 생각하면: 함수의 활용이 많은 경우 (parameter 변경)
	 ex)System.out.println() : static이면서 overloading
     
문법: 함수의 이름은 같고 parameter의 개수와 타입을 달리하는 방법
1. 함수의 이름은 같아야 한다
2. [parameter] 개수 또는 [type]은 달라야 한다
3. return type은 overloading 판단 기준 (x)
4. parameter 순서가 다름을 인정한다
 */

class Human {
	String name;
	int age;
	
}

class OverTest{
	//오버로딩
	void add(Human h) {
		h.name = "홍길동";
		h.age = 100;
		
	}
	
	
	int add(int i) {
		return 100 + i;
	}
	String add(String s) {
		return "hello" + s;
	}
	/* 충돌(오버로딩 인정 안함)
	void add(int k) {
		return k;
	}
	*/
	int add(int i, int k) {
		return i+k;
	}
	void add(int i, String s) {
		System.out.println("오버로딩");
	}
	void add(String s, int i) { //순서가 다름을 인정
		System.out.println("parameter 순서가 다름을 인정");
	}
	
	//배열(Array)을 배웠으니..
	//최종급 코드
	//int[] source = {1,2,3,4,5}
	int[] add(int[] param) { // int 정수배열의 주소값을 받겠다
		int[] target = new int[param.length];
		for(int i = 0; i < param.length; i++) {
			target[i] = param[i] + 1;
		}
		return target;
		//int 정수배열의 주소값을 리턴하겠다.
	}
	/////////////////오버로딩//////////////////////
	int[] add(int[] so, int[] so2) {
		int[] result = new int[so.length];
		for(int i = 0; i < so.length; i++) {
			result[i] = so[i] + so2[i];
		}
		return result;
	}
	
	
}

public class Ex11_method_overloading {
	public static void main(String[] args) {
		OverTest t = new OverTest();
		t.add(100, "AAA");
		t.add("BBB", 2000);
		//t.add("A", "B"); (x) 오버로딩 되어있지 않음
		
		//void add(Human h) {} 에 관해서
		//1. ok 
		Human m = new Human();
		t.add(m);
		
		//2. ok
		t.add(new Human()); 
		// heap메모리에 객체만 생성되고, 주소값을 변수로 받지 않았기 때문에 스택에서 주소값을 갖고 있지 않다.
		
		//////////////////////////////////////
		int[] source = {10, 20, 30, 40, 50};
		int[] target = t.add(source); //source 배열의 주소값
		
		//1. source 변수와 target 배열변수는 주소값이: 다르다
		System.out.println(source + " / " + target);
		for(int v : target) {
			System.out.println(v);
		}
		//////////////////////////////////////
		int[] test1 = {10, 20, 30};
		int[] test2 = {2, 4, 5};
		
		int[] addition = t.add(test1, test2);
		for(int v: addition) {
			System.out.println(v);
		}
		
	}
	
	
}
