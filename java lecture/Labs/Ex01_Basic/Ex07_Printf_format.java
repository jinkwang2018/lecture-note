import java.util.Scanner;

public class Ex07_Printf_format {
	public static void main(String[] args) {
		// java.lang 아래 있는 자원은 선언(import) 없이 사용 가능 (default open)
		System.out.println("Static 함수");
		// 오버로딩: 함수의 이름은 같은데 파라미터의 갯수와 타입을 다르게 할 수 있는 것 (저그의 오버로드를 생각)
		// 오버로딩은 성능에 무관하다, 편하게 쓰기 위해서 하는 기법
		
		//C#: Console.WriteLine()
		//C#: Console.ReadLine()
		//Java: System.out.println()

		System.out.print("B");
		System.out.print("C");
		System.out.print("D");
		System.out.println("S"); // 줄바꿈, ln: line new
		
		int num = 100;
		System.out.println(num);
		System.out.println("num 값은: " + num + " 입니다.");
		
		// 형식 (format)
		System.out.printf("num 값은: %d 입니다.\n", num); // 형식을 정의해서 출력
		// format 형식문자 (약속)
		// %d (10진수 형식의 정수): d라는 자리에
		// %f (실수)
		// %s (문자열)
		// %c (문자)
		// 특수문자: \t (탭키), \n (줄바꿈)
		
		System.out.printf("num의 값은 [%d] 입니다. 그리고 [%d]도 있어요\n", num, 1000);
		
		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f 변수 값 %f 입니다\n", f); // f 변수 값 3.140000 입니다
		
		//cmd (console) 에서 입력값 읽어오기
		
		Scanner sc = new Scanner(System.in); // ctrl + shift + o: import 자동완성
		// java.util.Scanner sc = new java.util.Scanner(System.in);
		// 이 방법도 가능하지만 사용할 때마다 계속 써줘야 하므로 import java.util.Scanner 하고 사용하는 것이 좋음
		
		System.out.println("값을 입력하세요");
		// String value = sc.nextLine(); // 입력할 때 까지 [대기] ... public String nextLine()
		// System.out.println("입력값: " + value);
		
		// int number = sc.nextInt(); // 대기
		// System.out.println("입력값: " + number); // 같은 타입만 처리
		
		// float number = sc.nextFloat();
		// System.out.println("입력값: " + number);
		
		// 권장사항 (문자로 받아서 변환해서 사용)
		// TODAY POINT
		// [[[ 문자를 -> 숫자로 ]]]
		// Integer.parseInt(s) 문자를 정수로
		// Float.parseFloat(s) 문자를 실수로
		// Double.parseDouble(s) 문자를 실수로
		
		System.out.println("숫자 입력하세요");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println("숫자: " + number);
		
		// 숫자 -> 문자 (아주 가끔...)
		// String data = String.valueOf(1000);
		// System.out.println(data); // [?] 타입정보를 출력할 수 있는 법 찾아보기
		
		
		
		Ex07_Printf_format ex = new Ex07_Printf_format();
		// main함수는 (class = method = static) 영역에 올라가 있는데
		// 위의 코드로 Heap 메모리에 객체를 생성하면 main함수는 Heap메모리에 생성되는 것이 아니라 main함수의 주소를 가지는 값이 생긴다.
		ex.print();
	}
	public void print() {
		// System.out.println("일반 함수");

	}
}

// public int a () {} 여기서 int에 들어갈 수 있는 타입들
// byte, char, short, int, long
// float, double
// boolean
// String
// class명 -> 주소값을 return