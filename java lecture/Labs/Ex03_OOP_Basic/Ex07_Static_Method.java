//static method

class StaticClass {
	int iv;
	static int cv;
	
	//�Ϲ��Լ�: ����ڿ� ����
	void m() {
		//�Ϲ��Լ����� iv ���� ó��(O)
		//�Ϲ��Լ����� cv ���� ó��(O)
		//**point (���������� ����) static�ڿ��� �Ϲ��ڿ����� ���� memory�� �ö󰡱� ����
		iv = 500;
		// StaticClass.cv = 1000; // Ŭ�����̸�.static �ڿ� ��		
		// ���� Ŭ���� �������� Ŭ�����̸� ���� ����
		cv = 1000;
		
		//StaticClass.sm(); ����
		//**�Ϲ��Լ��� ��� static �ڿ� ��� ����
		
	}
	
	//static �Լ�: static�ڿ��� ����
	static void sm() {
		//**�Ϲ��ڿ��� iv �ڿ��� ��� (X)
		//���������� ���� ����
		//StaticClass.sm(); �ڵ带 ���ؼ� ����Ϸ��� �ϸ� ������ ����� (iv�� �޸𸮿� �������� �ʱ� ����)
		
		//�Ϲ��Լ��� ��� void m() (X)
		
		//�������� ��ƶ� �׷��� error�� ���� ���̴�
		System.out.println("static���� cv: " + cv);
	}
	
}

public class Ex07_Static_Method {
	public static void main(String[] args) {
		System.out.println("main �Լ�");
		//StaticClass�� static�ڿ��� �޸𸮿� �ö��� ���� ����
		//(StaticClass�� ���ڴٰ� ������� �ʾұ� ������: ��Ÿ�����Ͱ� ���� ����)
		//StaticClass.cv = 5555; // StaticClass�� static�ڿ��� �޸𸮿� �ö� ����
		//StaticClass.sm();
		//������� �ڵ忡��, �Ϲ��Լ� void m() ����� �� ����.
		StaticClass sc = new StaticClass(); // �Ϲ��Լ� void m()�� new�����ڸ� ���� ��ü���� ���Ŀ� ��� ����
		//StaticClass �м� Ŭ�������� + static ���� >> class, method, static area
		//��ü�������� static �׻� �տ� �ִ�.
		
		sc.iv = 2222;
	}
}
