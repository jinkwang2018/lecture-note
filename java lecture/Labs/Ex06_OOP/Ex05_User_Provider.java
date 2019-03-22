/*
User(�����) : Provider(������)

class A {}, class B {}
A�� B�� ����մϴ�

1. ���: A extends B
2. ����: member field ����: A Ŭ���� �ȿ� B��� Ŭ������ ������ �� (member field) class A { B b; } : ����
class B {}
class A {
	int i;
	B b; //��������
}

3. ����: �Լ�(method parameter): ��������
class B {}
class A {
	int i;
	
	void print(B b) { //method parameter
	
	}
	void print() {
		B b = new B();
	}
*/

interface Icall{
	void m();
}

class D implements Icall {
	@Override
	public void m() {
		System.out.println("D Icall �������̽��� m() ����");
	}
}

class F implements Icall{
	@Override
	public void m() {
		System.out.println("F Icall �������̽��� m() ����");
	}
}

//�������� ���α׷� ���: Interface
class C {
	void method(Icall ic) { //�������̽� Ÿ������  parameter : ���� (��������: ������ ��)
		ic.m();
	}
}

public class Ex05_User_Provider {
	public static void main(String[] args) {
		C c = new C();
		c.method(new D());
		c.method(new F());
	}
}
