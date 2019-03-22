//����  <-> ���
//���: �� �� ���� �������� ���� �Ұ�
//���(�ڿ�): ������ (�ֹι�ȣ, �ý��� ���� ���̵�, PI=3.14159...)
//��� ���������� �빮��

//java: final int NUM = 100;
//c#: const int NUM = 200;

//final Ű����
//Ŭ���� �տ�: final class TT{} >> ��� �Ұ�
//�Լ� �տ�: public final void print() {} >> ��Ӱ��迡�� ������ ������ (override �Ұ�) (���󵵰� �����)

class Vcard {
	final String KIND = "heart";
	final int NUM = 10;
	void method() {
		//�ý��� ���(static final double PI = 3.14159...)
		System.out.println(Math.PI);
	}
}

//����: Vcard Ÿ������ ����� ��� ��ü�� ���� ������� ������
//�����Ǵ� ��ü���� �ٸ� ������� ������ �;��
//??

class Vcard2 {
	final String KIND;
	final int NUM;
	/*
	Vcar2() {
		this.KIND = "heart";
		this.NUM = 1;
	}
	*/
	//Vcard2() {} �ڵ�
	
	Vcard2(String kind, int num) {
		this.KIND = kind;
		this.NUM = num;
	}
	
}

public class Ex07_Final {
	public static void main(String[] args) {
		Vcard c = new Vcard();
		System.out.println(c.KIND + " / " + c.NUM);
		c.method();
		//c.KIND = "AAA"; //The final field Vcard.KIND cannot be assigned
		
		//����� ��ü���� �ٸ� ���� ���� �� �ִ� (������ �����ε��� ���ؼ�)
		Vcard2 c2 = new Vcard2("heard", 1);
		System.out.println(c2.KIND + " / " + c2.NUM);
	}
}
