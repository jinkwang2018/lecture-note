/*
�ڹٴ� �ý��ۿ��� 8���� �⺻Ÿ�� ���� (�ڷ���)
8���� �⺻ Ÿ�� (���� �����ϴ� Ÿ��)
[����]
���� (��������, 0, ��������)
	-> byte(-128~127)
	-> char(�� ���ڸ� ǥ���ϴ� �ڷ���: �� ����(2Byte), unicode ����), ���������� �����ϰ� �ִ� ���� ������
	-> short
	-> int(-21�� ~ 21��): **java ������ ���� �⺻ Ÿ�� (4Byte)**
	-> long(8Byte): int ���� ū ��

�Ǽ� (�ε��Ҽ���)
	-> float(4Byte)
	-> double(8Byte): **java �Ǽ��� ���� �⺻ Ÿ��**, ���е��� ����(ǥ�� ������ ũ��)
	
��
	-> boolean (true, false): ���α׷��� ������

�ñ�����: ���ڿ� ǥ�� �����???
String �� Ŭ���� (���赵) > String s = new String("�ȳ��ϼ���");
�� ����: String s = "ȫ�浿";
	
��Ÿ�� -> ����, �� (������ ������ ���� "��")
����Ÿ�� -> Ŭ����, �迭 (������ ������ ���� "�ּ�")

class == ���赵 == Ÿ��
class�� ���� Ÿ���� ��� ���� ū Ÿ��.
> class �ݵ�� �޸𸮿� ���� (�÷�����) ���
	-> new �����ڸ� ����ϸ� ����ȴ�.


 */

class Car { // Car��� Type ���� -> Type ������: Car c;
	String color;
	int data;
}


public class Ex03_DataType {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println("c��� ������ ��: " + c); // ����Ÿ��
		
		Car c2;
		c2 = new Car();
		System.out.println("c2��� ������ ��: " + c2);
		
		Car c3 = c; // ���� Ÿ���� �Ҵ���: �ּҰ� �Ҵ� -> ���� ���� ��ٰ� ��������.
		System.out.println(c + " : " + c3);
		System.out.println(c3 == c);
		c3.data = 3333;
		System.out.println(c.data);
		c.data = 4444;
		// c3.data, c.data (�ٶ󺸴� �ּ� ����)
		
		
		
		int i = 200; // ����� �Ҵ�
		System.out.println("i��� ������ ��: " + i); // ��Ÿ��
		
		int j; // ����
		j = 1000; // �Ҵ�(�ʱ�ȭ)
		
		int a, b; // ����: ���� �ʱ�ȭ
		a = 10;
		b = 11;
		
		System.out.println(a + " : " + b);
		
		int k = 1111;
		int k2 = k;
		k2 = 2222;
		// �̶� k���� ����ϸ�?? k = 1111;
		
		// int (-21�� ~ 21��) ũ��
		long number = 1000000000; // ���� �����
		long number2 = 10000000000L; // 100�� ���ͷ� �ڿ� L�� �Ἥ long������ �˷��ش�.
		// The literal 10000000000 of type [int] is out of range
		// 10000000000 ������ 100�� (int ���� ����)
		// ������ ���ͷ��� (�⺻Ÿ��) : int (Today point)
		// int ������ ����� �������ͷ� ���� ������ ���̻� ���ؼ� ���� ����
		
		System.out.println(number + " / " + number2);
		
		Integer p = new Integer(100);
		System.out.println(p.MAX_VALUE);
		System.out.println(p.MIN_VALUE);
		
		Long q = new Long(100);
		System.out.println(q.MAX_VALUE);
		System.out.println(q.MIN_VALUE);
		
		// char : �������� ������ �ִ� (2Byte)
		// ���ڸ� ǥ���ϴ� �ڷ���
		// 1. [�ѹ���] => 2Byte
		// 2. �ѱ� �� ����: 2Byte
		// 3. ������, Ư������, ����: 1Byte
		// �ѱ� �� ����, ���� �� ���� ��� 2Byte �� ǥ�� (unicode)
		
		// java ���ڿ�: "��": String s= "��", String s2 = "�����ٶ󸶹�"
		// java ����: '��': char c = '��' -> ���������� ������ ����ǹǷ� ASCII�ڵ�� ȣȯ�ȴ�.
		
		char single = '��';
		System.out.println(single);
		System.out.println((int)single);
		char ch = 'A';
		System.out.println(ch);
		System.out.println((int)ch); // (int): Ÿ�Ժ�ȯ(casting) // �ƽ�Ű �ڵ�ǥ 10������: 65
		
		char ch2 = 'a';
		System.out.println(ch2);
		System.out.println((int)ch2); // �ƽ�Ű �ڵ�ǥ 10������: 97
		
		int ch3 = 65;
		char ch4 = (char)ch3; // ����: 'A' // ����� ����ȯ
		System.out.println(ch4);
		
		// ch4 Ÿ��: char
		// cint2: int
		int cint2 = ch4; // �Ͻ��� ����ȯ
		System.out.println(cint2);
		// Today Point
		// ������ ������ �ִ� [���� ��������] [����Ÿ��]�� ������
		// Ÿ���� ũ�⸦ ����
		// ūŸ�Կ��� ����Ÿ�� ���� ���� �� �ִ�.
		// ����Ÿ�Կ��� ūŸ�԰��� ���� �� ����.
		// char <- int (X) ����, char <- (char)int (O)
		// int <- char (O) ���������δ� int <- (int)char �� �� ���̴�.
		
		// �������� �� ���� ���
		int intValue = 103029770;
		byte byteValue = (byte)intValue;
		System.out.println(byteValue); // �����Ⱚ
		
		// String (���ڿ�) Ÿ��
		// String �� Ÿ�� �ƴϰ� Ŭ���� Ÿ�� (new ���ؼ� �޸� �ø��� ���)
		// ��Ģ: String str = new String("ȫ�浿");
		// POINT: String �Ϲ� ��Ÿ�� �ᵵ ��������. (int, double Ÿ�� ó�� ���)
		
		String str = "Hello world";
		System.out.println(str);
		
		String str2 = str + "������"; // DB (����Ŭ  + ���, ���� ||)
		System.out.println(str2);
		
		// Tip: java Ư������ ����ϱ�
		// ���ڸ� ������Ű�� ���ؼ�: \ ��������
		char sing = '\'';
		System.out.println(sing);
		
		// ȫ"��"�� �̶�� ���ڿ��� ���
		String name = "ȫ\"��\"��";
		System.out.println(name);
		
		String str3 = "1000";
		String str4 = "10";
		String result = str3 + str4;
		System.out.println(result);
		
		System.out.println("100" + 100); // ���: 100100 *�߿�
		System.out.println(100 + "100"); // ���: 100100
		System.out.println(100 + 100 + "100"); // ���: 200100
		System.out.println(100 + (100 + "100")); // ���: 100100100
		System.out.println(100 + "100" + 100); // ���: 100100100
		
		// C:\temp ��� ���ڿ��� ����ϼ��� (Ư������)
		String path = "C:\\temp"; // ���: C:\temp
		System.out.println(path);
		
		// �Ǽ�(�ε��Ҽ���)
		// float(4Byte)
		// double(8Byte): **�Ǽ��� �⺻ ���ͳ��� double (���е��� ���� (�Ҽ����� �ڸ� �� ���� ǥ��))
		
		float f = 3.14f; // ���̻� (F, f) ���ͳΰ��� ����
		float f2 = 1.123456789f; // **�ݿø� ó��, �뷫 �Ҽ��� ���� 7�ڸ� ǥ��
		System.out.println("f2: " + f2); // f2: 1.1234568
		
		double d = 1.123456789123456789; // �뷫 �Ҽ��� ���� 16�ڸ� ǥ��
		System.out.println("d: " + d); // d: 1.1234567891234568
		
		// Test
		// double d2 = 100; // ������ ����ȯ: 100 int���� ���ͷ� ���� ����ȯ
		double d2 = (double)100;		
		System.out.println(d2);
		
		//Quiz
		double d3 = 100;
		int i5 = 100;
		
		// int result2 = d3 + i5; // error
		// 1. double result2 = d3 + i5; // ������ �ս��� ����
		// 2. int result2 = (int)d3 + i5; // ������ ���� �� ������ ���Ŀ� ���� �սǵ� �� �ִ�
		// 3. int result = (int)(d3 + i5); // �̵� ���� ����������
		
		// Today Point
		// ����Ÿ�� + ūŸ�� => ūŸ��
		// Ÿ�԰� ����ȯ: ������ ������ ���� ���� ���� ������ Ÿ������ �Ǵ�����
		// ����� ����ȯ(casting)
		
		int i6 = 100;
		byte b2 = (byte)i6;
		System.out.println(i6);
		
		byte b3 = 20;
		int i7 = b3; // ������ ����ȯ(promotion, ���������� (int)b3)
		
		
		
		
		
	}
}