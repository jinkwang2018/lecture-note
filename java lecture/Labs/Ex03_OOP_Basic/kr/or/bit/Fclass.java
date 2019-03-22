package kr.or.bit;
/*
�Լ�: ����� �ּҴ��� (method)

�Լ��� ����
	*void ����ϸ� (�����ִ� ���� ����): return value�� ����
	*return type: [8���� �⺻ Ÿ��] / String / ����(���������) / �迭 / Collection / Interface
		-return type ������ �ݵ�� �����ȿ��� return Ű���带 ���
	*parameter: [8���� �⺻ Ÿ��] / String / ����(���������) / �迭 / Collection / Interface
	
	1. void, parameter�� �ִ�: void print(String str) { �����ڵ� }
	2. void, parameter�� ����: void print() { �����ڵ� }
	3. return type, parameter�� �ִ�: int print(int data) { return 100 + data; }
	4. return type, parameter�� ����: int print() { return 200; }

**�Լ��� �ݵ�� ȣ��(Call) �Ǿ�߸� ����ȴ�: ������ ���� �̸��� �ҷ��־��...
 */

public class Fclass {
	public void m() { // �Լ��� �̸��� �ǹ��ִ� �ܾ��� ���� void getChannelNumber()
		System.out.println("�Ϲ��Լ�: void, param(x)");
	}
	
	public void m2(int i) {
		System.out.println("param value: " + i);
		System.out.println("�Ϲ��Լ�: void, param(o)");
	}
	
	public int m3() { // return type ������ �ݵ�� return Ű���� ���
		return 123;
	}
	
	public int m4(int data) {
		return data + 1;
	}
	// 
	// ������(������) private: class ���ο����� ��� (�ٸ� �Լ��� �����ִ� ����)
	// �ٸ� �������� �Լ��� ������ �������� ������ �� ���� �Լ��� ��Ƽ� ��� �����ϸ� ��������(���� ó��)�� ���ϴ� (���ȭ)
	private int operationMethod(int data) {
		return data * 100;
	}
	
	public int sum(int data) {
		return operationMethod(data);
	}
	
	public int sum2(int data) {
		return operationMethod(data);
	}
	
	// Ȯ���Լ� (parameter ...)
	public int sum3(int i, int j) {
		return i + j;
	}
	
	// Quiz
	// a�� b �� �߿� ū ���� return �ϴ� �Լ��� ���弼��
	// ex) max(500, 200) �̸� return �Ǵ� ���� 500
	// public int max(int a, int b) {}
	
	// **return�� �� ���� ����ϴ� ���� ����.
	
	public int max(int a, int b) {
		return (a > b) ? a : b; //�����ڷ� �ذ�
		// ���� �� �ڵ�: return ((a - b) >= 0) ? a : b;
		
		/* 
		1. 30��¥��	
		if(a >= b) {
			return a;
		}else {
			return b;
		}
		
		2. 60��¥��
		int result = 0;
		if(a >= b) {
			result = a;
		}else{
			result = b;
		}
		return result;
		
		3. 100��¥��
		return (a > b) ? a : b;
		*/
	}
	
	public String concat(String s, String s2, String s3) {
		//String result = s + "/" + s2 + "/" + s3;
		//return result;
		return s + "/" + s2 + "/" + s3;
	}
	//��������� �������̴�
	//Ŭ������ Ÿ���̴�
	//public int call() {return 100;}
	//public Tv call() { return Tv; } (x) �޸𸮿� �ø��� ���� �����̹Ƿ�
	
	//[Today Point]
	//public Tv call() { Tv t = new Tv(); return t; } (o)
	//public Tv call() { return new Tv(); } (o) ���� ���� �ڵ��̴�.
	
	public Tv objMethod() {
		Tv t = new Tv();
		t.brandname = "LG";
		return t;
	}
	
	public Tv objMethod2() {
		return new Tv(); //new ������ heap �޸𸮿� Tv ��ü�� ����� �ּҸ� �����ϴ� ������
		//�ּҰ� ����
	}
	
	//��� �ϳ��� �Լ� �� ��
	public void objMethod3(Tv t) { //Tv Ÿ���� ���� ��ü�� �ּҸ� �ѱ�� �� �ȿ� ������ ����ϴ� �Լ�
		System.out.println("���� ���");
		System.out.println("ä������: " + t.ch);
		System.out.println("�귣�� �̸�: " + t.brandname);
	}
	
/*	
	public String concat(String s, s2, s3) { // �Ķ���͸� �̷��� �ϸ� �ȵ�. Ÿ���� ���� ������ߵ�.
		return;
	}
*/
}
