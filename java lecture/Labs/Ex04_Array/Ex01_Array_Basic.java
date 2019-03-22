import java.util.Arrays;

//**배열(Array)는 객체다
//= 사용하기위해서 new 연산자를 사용해야 한다 = heap 메모리에 올라간다

public class Ex01_Array_Basic {
	public static void main(String[] args) {
		int[] score = new int[3]; // score는 주소값을 할당받는다.
		System.out.println("score 변수 (참조): " + score); //주소 (배열의 시작값 주소)
		
		//Array 배열은 각각의 방을 가지고 있다 (각각의 방은 타입(int) 크기 결정)
		//각각의 방의 접근은: 첨자,index로 접근: 배열의 시작 index: 0
		//score[0], score[1], score[2]
		//배열의 개수(length)는 마지막 첨자(index)보다 1이 항상 크다
		//배열은 타입의 초기값을 가진다.
		System.out.println(score[0]);
		score[2] = 333;
		System.out.println(score[2]);
		
		//score[3] = 500;
		//예외가 발생했습니다 (Exception이 발생했습니다)
		//-> 프로그램이 강제적으로 종료
		//java.lang.ArrayIndexOutOfBoundsException: 3
		//at Ex01_Array_Basic.main(Ex01_Array_Basic.java:20)
		
		//Array와 궁합이 제일 좋은 제어문은?  (for)
		for(int i = 0; i < 3; i++) {
			System.out.printf("[%d]=%d\t", i, score[i]);
		}
		
		System.out.println();
		
		for(int i = 0; i < score.length; i++) { // 지금 length 자원 배열의 개수
			System.out.printf("[%d]=%d\t", i, score[i]);
			
		}
		System.out.println();
		//배열(Array) 사용시 도와주는 클래스(help 클래스)
		//void print(int[] a) {} 에서 파라미터 int[]는 정수배열의 주소값을 받겠다는 의미
		String result = Arrays.toString(score); // 배열값 확인하기
		System.out.println(result);
		score[0] = 6666;
		result = Arrays.toString(score);
		System.out.println(result);
		Arrays.sort(score); //낮은 순으로 자동 정렬 (나는 당분간 너를 쓰지 않을꺼야)
		System.out.println(Arrays.toString(score));
		
		//point (암기)
		//배열을 만드는 3가지 방법
		int[] arr = new int[5]; //기본 (방의 개수, 기본값)
		int[] arr2 = new int[]{100, 200, 300}; //3개의 값
		int[] arr3 = {11, 12, 13, 14, 15}; //컴파일러가 내부적으로 new 사용
		//JavaScript: var cars = ["Saab", "Volvo", "BMW"];
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		//배열은 선언과 할당을 분리할 수 있다
		//int[] arr4 = null;
		//System.out.println(arr4);
		
		int[] arr4; //배열선언
		arr4 = new int[] {21, 22, 23, 24, 25}; //할당(메모리의 주소를 갖는다)
		
		int[] arr5 = arr4; //주소값 할당
		System.out.println(arr5 == arr4);
		
		//배열은 8가지 기본 타입 + String + 클래스 등등
		
		char[] ch = new char[10]; //char의 기본값: 빈문자 ('\u0000')
		for(int j = 0; j < ch.length; j++) {
			System.out.println(">" + ch[j] + "<");
		}
	}
}
