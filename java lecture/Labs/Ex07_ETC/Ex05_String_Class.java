//String 클래스
//이 수업을 듣고 String 클래스다 라는 사실을 지우세요
//String 사용방법이 8가지 기본타입과 동일
//String str = "홍길동";

//1. String 클래스: 데이터 저장 자료구조 >> char[]배열 사용
//2. String ename = "a길동" > [a][길][동]
//3. String s = new String("ABCD"); // 원칙

public class Ex05_String_Class {
	public static void main(String[] args) {
		String str = "ABCD";
		System.out.println(str.length()); //String 데이터 char[] 배열
		System.out.println(str); //str.toString() 결과
		
		String str1 = "AAA";
		String str2 = "AAA";
		System.out.println("str1: " + str1.toString());
		System.out.println("str2: " + str2.toString());
		System.out.println(str1 == str2);
		//String 비교 (주소안에 있는 값을 비교)
		//**Point (문자열의 비교는: equals)
		System.out.println(str1.equals(str2)); //AAA, AAA 같니
		
		String str3 = new String("BBB"); //new 무조건 다른 메모리에 생성
		String str4 = new String("BBB");
		System.out.println(str3 == str4); //주소값 비교
		System.out.println(str3 + " / " + str4);
		System.out.println("반드시(무조건): " + str3.equals(str4));
		//문자 비교는 반드시! 무조건! equals() 사용
	}
}
