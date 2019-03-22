import kr.or.bit.Fclass;
import kr.or.bit.Tv;

public class Ex02_MethodCall {
	public static void main(String[] args) {
		Fclass fc = new Fclass();
		fc.m();
		fc.m2(10000);
		int result = fc.m3(); // m3를 더블클릭하고 [f3]키를 누르면 해당 함수 위치로 이동
		System.out.println("result: " + result);
		
		result = fc.m4(1000);
		System.out.println("result: " + result);
		
		result = fc.sum(500);
		result = fc.sum2(100);
		System.out.println("result: " + result);
		
		result = fc.sum3(10,  20);
		System.out.println("두 값의 합: " + result);
		
		result = fc.max(555, 333);
		System.out.println("max 값: " + result);
		
		Tv t2 = fc.objMethod();
		// Tv타입을 쓰기 위해서는 해당 클래스를 import 해야 한다. (import kr.or.bit.Tv;)
		System.out.println(t2.brandname);
		
		Tv t3 = fc.objMethod2();
		
		System.out.println("주소값 비교: " + (t2 == t3));
		
		fc.objMethod3(t2);
	}
}
