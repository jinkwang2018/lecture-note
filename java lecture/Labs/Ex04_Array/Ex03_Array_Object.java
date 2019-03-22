import java.util.Arrays;

class Person{
	String name;
	int age;
}

public class Ex03_Array_Object {
	public static void main(String[] args) {
		int[] intarr = new int[10];
		boolean[] barr = new boolean[5];
		System.out.println(Arrays.toString(barr));
		//위 Array는 값타입 배열
		//클래스는 타입이다 (int, double 등 타입 올 수 있는 자리에 클래스 타입도 올 수 있다)
		Person[] arrobj = new Person[3];
		//참조(class) 타입은 방을 만들고 각각의 방에 객체를 만드는 별도의 작업 필요 (2번)
		//-> 풀어서 쓰면: 객체 배열은 방만들고 입주시켜야 돼!
		
		System.out.println("arrobj: " + arrobj);
		System.out.println("before: " + arrobj[0]); // null
		
		arrobj[0] = new Person();
		arrobj[0].name = "홍길동";
		arrobj[0].age = 100;
		
		System.out.println("after: " + arrobj[0].name + ", " + arrobj[0].age);
		
		arrobj[1] = new Person();
		arrobj[2] = new Person();
		//for문
		
		System.out.println("배열: " + arrobj);
		
		for(int i = 0; i < arrobj.length; i++) {
			System.out.println(arrobj[i]);
			System.out.println(arrobj[i].name + "/" + arrobj[i].age);
		}
		
		//3가지 배열 만들기
		//1. int[] arr = new int[5];
		Person[] parray = new Person[5];
		for(int i = 0; i < parray.length; i++) {
			parray[i] = new Person(); //각각의 방에 memory 생성
			System.out.println("주소값: " + parray[i]);
		}
		
		//2. int[] arr = new int[]{10, 20, 30};
		Person[] parray2 = new Person[] {new Person(), new Person()}; // {안에서 각방에 memory 생성}
		
		//3. int[] arr = {10, 20, 30}; //컴파일러에게 니가 알아서 new 생성...
		Person[] parray3 = {new Person(), new Person(), new Person()};
	}
}
