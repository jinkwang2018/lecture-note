class Parent3 {
	int x = 100;
	void pmethod() {
		System.out.println("parent method");
	}
}

class Child3 extends Parent3 {
	int x = 200; // C# ������: ���� �����ϱ� >> java �ǹ̾��� �ڵ�
	void parent_x() {
		System.out.println(super.x);
	}
	
	//�θ� ������ pmethod() ������(override)
	@Override
	void pmethod() {
		System.out.println("�θ� �Լ� ������");
	}
	
	void parent3_method() {
		super.pmethod(); //�θ� �ּҷ� ���� �θ� ������ pmethod()
	}
}

public class Ex14_Inherit_Poly_Override {
	public static void main(String[] args) {
		Child3 ch = new Child3();
		System.out.println(ch.x);
		ch.parent_x();
		ch.pmethod();
		
		//������
		Parent3 pa = ch;
		System.out.println(pa.x);
		pa.pmethod(); //**������(override)�� �Լ� ȣ��
		ch.parent3_method();
	}
}