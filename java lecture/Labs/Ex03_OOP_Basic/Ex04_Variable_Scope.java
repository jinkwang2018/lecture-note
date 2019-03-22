//1. 하나의 자바파일은 여러개의 클래스를 가질 수 있다 (단 public 접근자는 한개의 클래스만)

//연습용 (접근자: 폴더내에서 공유 가능한 default 접근자)
class Variable {
	int iv;
	/*
	1. member field, instance variable
	2. 목적: 정보를 담으려고 한다(고유데이터, 상태데이터, 참조데이터) >> 생성되는 객체마다 다른 값을 갖기 위해서
	3. 특징: 초기값 가지고 있다 (각각의 타입이 정의하는: int - 0, float - 0.0, bloolean - false
	                                      String 또는 참조타입의 기본값 - null)
	4. 생성시점(memory를 갖는 시점): new라는 연산자를 통해서 heap 객체가 만들어지고 나서
	 */
	
	static int cv;
	/*
	1. class variable, static variable(공유자원)
	2. 목적: 정보를 담으려고 한다 (생성되는 모든 객체가 공유하는 자원으로서): 객체간 공유자원
	3. 특징: 접근방법: 클래스이름.static자원 (객체가 만들어지지 않은 상황에서도 접근 가능): Math.random()
					또는 참조변수.static 자원(variable v = new variable() ... v.cv)
	4. 생성시점: 프로그램 실행 (class loader에 의해클래스 정보를 읽어서 class area, static area에 올리고 나서
		이 때 클래스 static 자원을 가지고 있다면 static 자원도 같이 memory 올림
		>> static 객체생성 이전에 메모리에  memory에 올라가는 방법
	**static area에는 Garbage collector가 존재하지 않음.	
	
	 */	
	void method() {
		int lv = 0;
		//local variable (지역변수)
		//특징: 지역변수는 사용하기 전 반드시 초기화
		//생성시점: 함수가 호출되면 만들어지고 함수가 끝나면 소멸(stack)영역에 올라가는 자원
	}
}

class Card {
	int num;
	String shape;
	static int width;
	static int height;
	
}


public class Ex04_Variable_Scope {
	public static void main(String[] args) {
		Variable.cv = 100;
		Variable v = new Variable();
		v.cv = 500;
		System.out.println(Variable.cv);
		
		Variable v2 = new Variable();
		System.out.println(v2.cv);
		
		Variable v3 = new Variable();
		v3.cv = 500; //공유(객체간)
		System.out.println(v3.cv);
		Variable v4 = new Variable();
		System.out.println(v4.cv);
	}
}
