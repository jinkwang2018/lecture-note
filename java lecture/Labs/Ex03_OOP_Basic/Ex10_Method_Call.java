class Data {
	int i;
}

public class Ex10_Method_Call {
	public static void main(String[] args) {
		Data d = new Data();
		d.i = 100;
		System.out.println("d.i :" + d.i);
		
		scall(d); //주소값을 parameter 넘기기 (Call by reference 주소값 전달)
		System.out.println("scall 이후: " + d.i);
		
		vcall(d.i); // d.i 가지고 있는 것 (값을 가지고 있다 100) (Call by value 값 전달)
		System.out.println("d.i: " + d.i);
	}
	
	static void scall(Data data) { //Data타입을 갖는 객체의 [주소값]을 받겠다 
		System.out.println("함수: " + data.i);
		data.i = 1111;
	}
	
	static void vcall(int x) {
		System.out.println("before: " + x);
		x = 8888;
		System.out.println("after: " + x);
	}
}
