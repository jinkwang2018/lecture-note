package kr.or.bit;

public class ExClass {
	public ExClass() throws Exception {
		
	}
	
	public void call() throws ArithmeticException, IndexOutOfBoundsException {
		System.out.println("call �Լ� start");
		int i = 1/0;
		System.out.println("call �Լ� end");
	}
}
