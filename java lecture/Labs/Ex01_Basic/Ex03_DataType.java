/*
자바는 시스템에서 8가지 기본타입 제공 (자료형)
8가지 기본 타입 (값을 저장하는 타입)
[숫자]
정수 (음의정수, 0, 양의정수)
	-> byte(-128~127)
	-> char(한 문자를 표현하는 자료형: 한 문자(2Byte), unicode 형식), 내부적으로 저장하고 있는 값은 정수값
	-> short
	-> int(-21억 ~ 21억): **java 정수의 연산 기본 타입 (4Byte)**
	-> long(8Byte): int 보다 큰 값

실수 (부동소수점)
	-> float(4Byte)
	-> double(8Byte): **java 실수의 연산 기본 타입**, 정밀도가 높다(표현 범위가 크다)
	
논리
	-> boolean (true, false): 프로그램의 논리제어

궁금한점: 문자열 표현 어디갔지???
String 은 클래스 (설계도) > String s = new String("안녕하세요");
앞 예제: String s = "홍길동";
	
값타입 -> 숫자, 논리 (변수가 가지는 것이 "값")
참조타입 -> 클래스, 배열 (변수가 가지는 것이 "주소")

class == 설계도 == 타입
class는 작은 타입을 모아 놓은 큰 타입.
> class 반드시 메모리에 적재 (올려놓고) 사용
	-> new 연산자를 사용하면 적재된다.


 */

class Car { // Car라는 Type 생성 -> Type 변수명: Car c;
	String color;
	int data;
}


public class Ex03_DataType {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println("c라는 변수의 값: " + c); // 참조타입
		
		Car c2;
		c2 = new Car();
		System.out.println("c2라는 변수의 값: " + c2);
		
		Car c3 = c; // 참조 타입의 할당은: 주소값 할당 -> 같은 집에 산다고 생각하자.
		System.out.println(c + " : " + c3);
		System.out.println(c3 == c);
		c3.data = 3333;
		System.out.println(c.data);
		c.data = 4444;
		// c3.data, c.data (바라보는 주소 같다)
		
		
		
		int i = 200; // 선언과 할당
		System.out.println("i라는 변수의 값: " + i); // 값타입
		
		int j; // 선언
		j = 1000; // 할당(초기화)
		
		int a, b; // 단점: 각각 초기화
		a = 10;
		b = 11;
		
		System.out.println(a + " : " + b);
		
		int k = 1111;
		int k2 = k;
		k2 = 2222;
		// 이때 k값을 출력하면?? k = 1111;
		
		// int (-21억 ~ 21억) 크면
		long number = 1000000000; // 문제 없어요
		long number2 = 10000000000L; // 100억 리터럴 뒤에 L을 써서 long값임을 알려준다.
		// The literal 10000000000 of type [int] is out of range
		// 10000000000 정수값 100억 (int 값의 범위)
		// 정수의 리터럴값 (기본타입) : int (Today point)
		// int 범위를 벗어나는 정수리터럴 값은 별도의 접미사 통해서 값의 범위
		
		System.out.println(number + " / " + number2);
		
		Integer p = new Integer(100);
		System.out.println(p.MAX_VALUE);
		System.out.println(p.MIN_VALUE);
		
		Long q = new Long(100);
		System.out.println(q.MAX_VALUE);
		System.out.println(q.MIN_VALUE);
		
		// char : 정수값을 가지고 있다 (2Byte)
		// 문자를 표현하는 자료형
		// 1. [한문자] => 2Byte
		// 2. 한글 한 글자: 2Byte
		// 3. 영문자, 특수문자, 공백: 1Byte
		// 한글 한 글자, 영문 한 글자 모두 2Byte 로 표현 (unicode)
		
		// java 문자열: "가": String s= "가", String s2 = "가나다라마바"
		// java 문자: '가': char c = '가' -> 내부적으로 정수가 저장되므로 ASCII코드와 호환된다.
		
		char single = '가';
		System.out.println(single);
		System.out.println((int)single);
		char ch = 'A';
		System.out.println(ch);
		System.out.println((int)ch); // (int): 타입변환(casting) // 아스키 코드표 10진수값: 65
		
		char ch2 = 'a';
		System.out.println(ch2);
		System.out.println((int)ch2); // 아스키 코드표 10진수값: 97
		
		int ch3 = 65;
		char ch4 = (char)ch3; // 문자: 'A' // 명시적 형변환
		System.out.println(ch4);
		
		// ch4 타입: char
		// cint2: int
		int cint2 = ch4; // 암시적 형변환
		System.out.println(cint2);
		// Today Point
		// 변수가 가지고 있는 [값을 보지말고] [변수타입]을 보세요
		// 타입의 크기를 보자
		// 큰타입에는 작은타입 값을 넣을 수 있다.
		// 작은타입에는 큰타입값을 넣을 수 없다.
		// char <- int (X) 따라서, char <- (char)int (O)
		// int <- char (O) 내부적으로는 int <- (int)char 을 한 것이다.
		
		// 버려지는 값 문제 고민
		int intValue = 103029770;
		byte byteValue = (byte)intValue;
		System.out.println(byteValue); // 쓰레기값
		
		// String (문자열) 타입
		// String 값 타입 아니고 클래스 타입 (new 통해서 메모리 올리고 사용)
		// 원칙: String str = new String("홍길동");
		// POINT: String 일반 값타입 써도 문제없다. (int, double 타입 처럼 사용)
		
		String str = "Hello world";
		System.out.println(str);
		
		String str2 = str + "졸려요"; // DB (오라클  + 산술, 결합 ||)
		System.out.println(str2);
		
		// Tip: java 특수문자 사용하기
		// 문자를 인지시키기 위해서: \ 역슬래시
		char sing = '\'';
		System.out.println(sing);
		
		// 홍"길"동 이라는 문자열을 출력
		String name = "홍\"길\"동";
		System.out.println(name);
		
		String str3 = "1000";
		String str4 = "10";
		String result = str3 + str4;
		System.out.println(result);
		
		System.out.println("100" + 100); // 출력: 100100 *중요
		System.out.println(100 + "100"); // 출력: 100100
		System.out.println(100 + 100 + "100"); // 출력: 200100
		System.out.println(100 + (100 + "100")); // 출력: 100100100
		System.out.println(100 + "100" + 100); // 출력: 100100100
		
		// C:\temp 라는 문자열을 출력하세요 (특수문자)
		String path = "C:\\temp"; // 출력: C:\temp
		System.out.println(path);
		
		// 실수(부동소수점)
		// float(4Byte)
		// double(8Byte): **실수의 기본 리터널은 double (정밀도가 높다 (소수이하 자리 더 많이 표현))
		
		float f = 3.14f; // 접미사 (F, f) 리터널값의 정의
		float f2 = 1.123456789f; // **반올림 처리, 대략 소수점 이하 7자리 표현
		System.out.println("f2: " + f2); // f2: 1.1234568
		
		double d = 1.123456789123456789; // 대략 소수점 이하 16자리 표현
		System.out.println("d: " + d); // d: 1.1234567891234568
		
		// Test
		// double d2 = 100; // 묵시적 형변환: 100 int형의 리터럴 값을 형변환
		double d2 = (double)100;		
		System.out.println(d2);
		
		//Quiz
		double d3 = 100;
		int i5 = 100;
		
		// int result2 = d3 + i5; // error
		// 1. double result2 = d3 + i5; // 데이터 손실은 없다
		// 2. int result2 = (int)d3 + i5; // 지금은 맞을 수 있지만 추후에 값이 손실될 수 있다
		// 3. int result = (int)(d3 + i5); // 이도 위와 마찬가지다
		
		// Today Point
		// 작은타입 + 큰타입 => 큰타입
		// 타입간 형변환: 변수가 가지는 값을 보지 말고 변수의 타입으로 판단하자
		// 명시적 형변환(casting)
		
		int i6 = 100;
		byte b2 = (byte)i6;
		System.out.println(i6);
		
		byte b3 = 20;
		int i7 = b3; // 묵시적 형변환(promotion, 내부적으로 (int)b3)
		
		
		
		
		
	}
}