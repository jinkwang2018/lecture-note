import kr.or.bit.Emp;

class Test2 {
	void print() {
		System.out.println("�θ��Լ�(Test2)");
	}
}

class Test3 extends Test2 {
	@Override
	void print() {
		System.out.println("�ڽ��Լ�(Test3) ������ �������");
	}
	
	//override (x)
	//�����ε� (parameter ������ Ÿ���� �޸��ؼ�): ��Ӱ���� �������
	void print(String s) {
		System.out.println("���� �����ε� �Լ� " + s);
	}
}




public class Ex05_Inherit_override {
	public static void main(String[] args) {
		Test3 t = new Test3();
		t.print(); //������ �� �Լ�
		t.print("�����ε�");
		String str = t.toString();
		System.out.println("������ ���� ���� toString(): " + str);
		System.out.println("toString() �Լ��� default�� ȣ��: " + t);
		//���������� t.toString() ���� ��� >> t ���� ����ϸ�
		
		Emp e = new Emp(1000, "ȫ�浿");
		String str2 = e.toString();
		System.out.println(str2);
		System.out.println(e);
	}
}
