class Array {
	int[] arr = new int[] {1,2,3};
	
	static void aaa() {
		System.out.println("aaa");
	}
}

class Parent {
	String pname;
	Parent() {
		System.out.println("아버지");
	}
	
	Parent(String pname) {
		this.pname = pname;
		System.out.println("Parent name: " + pname);
	}
	
	void print() {
		System.out.println("아버지입니다.");
		System.out.println(pname);
	}
	
}

class Son extends Parent {
	String sname;

	Son() {
		System.out.println("아들");
	}
	
	Son(String sname) {
		super(sname);
		this.sname = sname;
		System.out.println("Son name: " + sname);
	}
	
	@Override
	void print() {
		super.print();
		System.out.println("아들입니다.");
		System.out.println(sname);
	}
}

public class Test {

	public static void main(String[] args) {
		/*Array a = new Array();
		System.out.println(a.arr[1]);*/
		
		Son s = new Son("홍길동");
		s.print();
		
		//aaa();
	}

}
