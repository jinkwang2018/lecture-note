//�ϳ��� Ŭ����������
//this: ��ü �ڽ��� ����Ű�� this ( this.name, this.age )
//this: �����ڸ� ȣ���ϴ� this ( this("ȫ�浿", 100) )

//��Ӱ��迡��
//super(�θ��� �ּ�): ��Ӱ��迡�� [�θ�]�ڿ��� ����
//this�� ������ ����
//1. super: ��Ӱ��迡�� �θ� �ڿ��� ����
//2. super: ��Ӱ��迡�� �θ� �ڿ��� �����ڸ� ��������� ȣ��

//Tip: base (C#)

class Base{
	String basename;
	Base() {
		System.out.println("Base Ŭ������ �⺻ ������");
	}
	Base(String basename) {
		this.basename = basename;
		System.out.println("super�� ���ؼ� ȣ��� ������: " + this.basename);
	}
	void baseMethod() {
		System.out.println("baseMethod()");
	}
}

class Derived extends Base{
	String dname;
	Derived() {
		System.out.println("Derived Ŭ������ �⺻ ������");
	}
	Derived(String dname) {
		//super ���
		super(dname);
		this.dname = dname;
		System.out.println("dname: " + this.dname);
	}
	void derivedMethod() {
		System.out.println("derivedMethod()");
	}
	//�θ� ������ baseMethod() ������
	@Override
	void baseMethod() {
		System.out.println("�θ� �Լ� ������ �߽��ϴ�");
	}
	//�θ� �ڿ��� �׸����� (������ �� �ڿ�)
	void p_method() {
		//super: �θ� ��ü�� �ּ�
		super.baseMethod(); //�θ��Լ� ȣ��
	}
}

public class Ex06_Inherit_super {
	public static void main(String[] args) {
		/*
		Derived d = new Derived();
		d.baseMethod();
		d.derivedMethod();
		d.p_method();
		*/
		Derived d2 = new Derived("ȫ�浿");
		//parameter ó���ϸ� �θ��ʿ��� ���� ó���ϰ� �;��
		
	}
}
