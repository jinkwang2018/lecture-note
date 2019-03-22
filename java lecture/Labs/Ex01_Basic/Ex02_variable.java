class Vtest { // 아래의 이유로 public class 사용 불가
	// int iv = 1000; // 초기화
	int iv; // 초기값을 가지고 있다. why? 
	
	void print() {
		System.out.println("instance variable : " + iv);
	}
}

class Apt { // 아래의 이유로 public class 사용 불가
	String color;
	Apt(String color) { // 특수한 함수 (생성자 함수(constructor)): 일반함수와 다르다, class와 이름을 같게 해야한다.
		this.color = color;
	}
	void aptPrint() {
		System.out.println("색상: " + this.color);
	}
}

public class Ex02_variable { // public class는 java파일 당 하나만 존재해야되고, class명은 파일명과 일치해야 된다.
	public static void main(String[] args) {
		Vtest t = new Vtest();
		t.print();
		Vtest t2 = new Vtest();
		t2.iv = 3000;
		t2.print();
		Vtest t3 = new Vtest();
		t3.print();
		///////////////////////
		
		Apt a = new Apt("blue");
		a.aptPrint();
		
		Apt b = new Apt("red");
		b.aptPrint();
		
	}
}
