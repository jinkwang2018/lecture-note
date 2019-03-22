package kr.or.bit;

public class Bird {
	public void fly() {
		System.out.println("I am flying...");
	}
	
	//재정의를 해주었으면 좋겠어(의도)
	//재정의 해
	protected void movefast() {
		fly();
	}
}
