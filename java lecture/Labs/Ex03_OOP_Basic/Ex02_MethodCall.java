import kr.or.bit.Fclass;
import kr.or.bit.Tv;

public class Ex02_MethodCall {
	public static void main(String[] args) {
		Fclass fc = new Fclass();
		fc.m();
		fc.m2(10000);
		int result = fc.m3(); // m3�� ����Ŭ���ϰ� [f3]Ű�� ������ �ش� �Լ� ��ġ�� �̵�
		System.out.println("result: " + result);
		
		result = fc.m4(1000);
		System.out.println("result: " + result);
		
		result = fc.sum(500);
		result = fc.sum2(100);
		System.out.println("result: " + result);
		
		result = fc.sum3(10,  20);
		System.out.println("�� ���� ��: " + result);
		
		result = fc.max(555, 333);
		System.out.println("max ��: " + result);
		
		Tv t2 = fc.objMethod();
		// TvŸ���� ���� ���ؼ��� �ش� Ŭ������ import �ؾ� �Ѵ�. (import kr.or.bit.Tv;)
		System.out.println(t2.brandname);
		
		Tv t3 = fc.objMethod2();
		
		System.out.println("�ּҰ� ��: " + (t2 == t3));
		
		fc.objMethod3(t2);
	}
}
