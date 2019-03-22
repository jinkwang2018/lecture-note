class Array {
	int[] arr = new int[] {1,2,3};
	
	static void aaa() {
		System.out.println("aaa");
	}
}

class Parent {
	String pname;
	Parent() {
		System.out.println("�ƹ���");
	}
	
	Parent(String pname) {
		this.pname = pname;
		System.out.println("Parent name: " + pname);
	}
	
	void print() {
		System.out.println("�ƹ����Դϴ�.");
		System.out.println(pname);
	}
	
}

class Son extends Parent {
	String sname;

	Son() {
		System.out.println("�Ƶ�");
	}
	
	Son(String sname) {
		super(sname);
		this.sname = sname;
		System.out.println("Son name: " + sname);
	}
	
	@Override
	void print() {
		super.print();
		System.out.println("�Ƶ��Դϴ�.");
		System.out.println(sname);
	}
}

public class Test {

	public static void main(String[] args) {
		/*Array a = new Array();
		System.out.println(a.arr[1]);*/
		
		Son s = new Son("ȫ�浿");
		s.print();
		
		//aaa();
	}

}
