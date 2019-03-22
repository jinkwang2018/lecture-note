/*
1. ���赵 �뵵 ����� Ŭ����: kr.or.bit.Emp
2. ������ ���� ����� Ŭ���� (������: main() �Լ�): Ex01_variable
3. �Լ� public static void main(String[] args) {}: ���α׷� ������, ������
TIP) C# > public static void Main()

class Ex01_variable


���� (Variable)
���� Scope (��ȿ����): ����Ǵ� ��ġ�� ����
1. instance variable: ��ü����(��������) class Test { ... }
2. local variable   : �������� (�Լ� �ȿ� �ִ� ����) class Test { void run() { ... } }
3. static variable  : ��������
*/

// ���赵 == class
class Test {
	int iv = 500; 
	// instance variable: Heap �޸𸮿� �ö� �ִ� �� ���α׷� ����� �� ���� ��� ����
	// �� ������ �ʱ�ȭ�� ���� �ʾƵ� �ȴ� (�⺻��: default�� ������ �ִ�.)
	// why �ʱ�ȭ�� ���� �ʾƵ� ��밡�� �ұ��?
	// ��)
	String sv; // instance variable
	
	void print() {
		int lv = 100; // local variable
		              // �Լ��� ȣ��Ǹ� �׶� �޸𸮿� �����ǰ� �Լ��� ����Ǹ� �޸𸮿��� �������.
	}
	void write() {
		System.out.println("iv: ��������: " + iv);
		
		// Error
		// lv ������ print() { ���ο� �ִ� ���� }
		// System.out.println("lv: ��������: " + lv);
	}
	
}

public class Ex01_variable {
	public static void main(String[] args) {
		int lv = 500; // local variable
		System.out.println("lv������: " + lv); // ����ϴ� �Լ�
		
		// int number; //����
		// System.out.println(number);
		// The local variable number may not have been initialized
		
		int number = 100;
		System.out.println("�ʱ�ȭ: " + number);
		// 1.���������� �ݵ�� [�ʱ�ȭ]�ϰ� ����Ͽ��� �Ѵ�. (ó�� ���� �Է��ϴ� ���� �ʱ�ȭ)
		// 2.���: �Լ� �ȿ� �ִ� ��������(local variable)�� �ݵ�� �ʱ�ȭ����
		
		int num; //���� �ϸ� ���� x
		System.out.println("�ȳ��ϼ���");
		System.out.println("����Ŀ�");
		num = 200;
		System.out.println(num);
		
		// Test t = new Test();
		// t.write();
	}

}