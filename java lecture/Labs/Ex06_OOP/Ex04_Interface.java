/*
�������̽�(Interface)
������ �ǹ�
1. ���, ǥ��, �԰� ���� ����� ����
ex) ����, �Ź�(������) ...
ex) ISO ǥ���� ��Ű�� ȸ����...
---------------------------
����Ʈ���� ����
>> �������̽��� �ֻ��� �ܰ�
>> ���� ǥ��, ����� �����ϴ� ����

Interface
1. ���� �����ΰ� ����: ������� ����: �̵��� ���õ� ��� >> void move(int x, int y); >> �߻� �޼���
2. ǥ��ȭ�� ���踦 ���� (�Ϻ��� ������)
3. ���뼳��

JAVA API (�����ڰ� �ʿ��� �������̽��� ������ �ִ�: �������̽� ������� Ŭ������ ����)
> Collection Ŭ������ (�����迭)
> ���� �������̽����� ������ ��Ƽ� ��� (���뼺)

1.���� ���
���(final): public static final int NUM = 10; >> [public static final]���� >> int NUM = 10;
�Լ�(method): public abstract void run(); >> [public abstract] ���� >> void run();
�Լ�(method): String move(int x, int y);
�������̽��� ������ ���� �߻�޼��常 ������.

1.�������̽��� ��ü ���� �Ұ� (��� ������ �������� �߻��Լ�)
2.������ ���ؼ��� ��밡�� (class Test implements Ia)
3.�������̽� ���� ��� ���� (class Test Implements Ia, Ib, Ic, Id)
4.�������̽����� ��� ����(Ia extends Ib: ����� Ȯ�尡��)
5.�������̽��� �ϳ��� Ÿ��(������) ���� (**POINT)

 */
interface Ia {
	//��� (�ý��� �ڿ� ��)
	public static final int AGE = 100;
	//int AGE = 100; // [public static final] ���� ���� -> �⺻������ (default)
	String GENDER = "��";
	//��Ģ: public static final String GENDER = "��";
	
	public abstract String print();
	String message(String str);
	//��Ģ: public abstract String message (String str);
}

interface Ib { // interface Ib extends Ia {} ����
	int AGE = 10;
	void info();
	String val(String s);
}

class Test2 extends Object implements Ia, Ib {

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String val(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String message(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Test implements Ia {
	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String message(String str) {
		// TODO Auto-generated method stub
		return null;
	}
}

public class Ex04_Interface {
	public static void main(String[] args) {
		Test2 t = new Test2();
	}
}
