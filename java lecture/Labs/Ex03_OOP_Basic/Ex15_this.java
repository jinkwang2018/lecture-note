//this
//1. ��ü �ڽ��� ����Ű�� this (������ ������ ��ü�� �ּҸ� ���� ���̶�� �����ϰ�)
//2. this ��ü �ڽ� (�����ڸ� ȣ���ϴ�): ��Ģ: ��ü ������ ������ 1�� ȣ��
//							        ���������� this�� ���: �������� �����ڸ� ȣ�� ���� 

class Test6 extends Object { //extends Object ������� �ʾƵ� �⺻������ ����
	//�����Ϸ� ( Test6() {} )
	int i;
	int j;
	Test6() {
		
	}
	
	Test6(int i, int j) { //�̿� ���� �Լ��� ����ϸ� �������� ������
		this.i = i;
		this.j = j;
	}
	
	public void t() {
		System.out.println(this); // this�� �ּҰ��� ���´�.
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
