//this
//1. 객체 자신을 가리키는 this (앞으로 생성될 객체의 주소를 담을 곳이라고 가정하고)
//2. this 객체 자신 (생성자를 호출하는): 원칙: 객체 생성시 생성자 1개 호출
//							        예외적으로 this를 사용: 여러개의 생성자를 호출 가능 

class Test6 extends Object { //extends Object 명시하지 않아도 기본적으로 적용
	//컴파일러 ( Test6() {} )
	int i;
	int j;
	Test6() {
		
	}
	
	Test6(int i, int j) { //이와 같이 함수를 사용하면 가독성이 높아짐
		this.i = i;
		this.j = j;
	}
	
	public void t() {
		System.out.println(this); // this는 주소값을 갖는다.
	}
}

class SoCar{
	String color;
	String gearType;
	int door;
	
	SoCar() {
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	SoCar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + "/" + this.gearType + "/" + this.door);
	}
}


public class Ex15_this {
	public static void main(String[] args) {
		Test6 t = new Test6();
		
		Test6 t2 = new Test6(100, 500);
		System.out.println(t2);
		t2.t();
		
		SoCar so = new SoCar();
		so.print();
		
		SoCar so2 = new SoCar("blue", "Manual", 4);
		so2.print();
	}
}
