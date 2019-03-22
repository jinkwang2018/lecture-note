import java.util.Scanner;

public class Ex07_Printf_format {
	public static void main(String[] args) {
		// java.lang �Ʒ� �ִ� �ڿ��� ����(import) ���� ��� ���� (default open)
		System.out.println("Static �Լ�");
		// �����ε�: �Լ��� �̸��� ������ �Ķ������ ������ Ÿ���� �ٸ��� �� �� �ִ� �� (������ �����ε带 ����)
		// �����ε��� ���ɿ� �����ϴ�, ���ϰ� ���� ���ؼ� �ϴ� ���
		
		//C#: Console.WriteLine()
		//C#: Console.ReadLine()
		//Java: System.out.println()

		System.out.print("B");
		System.out.print("C");
		System.out.print("D");
		System.out.println("S"); // �ٹٲ�, ln: line new
		
		int num = 100;
		System.out.println(num);
		System.out.println("num ����: " + num + " �Դϴ�.");
		
		// ���� (format)
		System.out.printf("num ����: %d �Դϴ�.\n", num); // ������ �����ؼ� ���
		// format ���Ĺ��� (���)
		// %d (10���� ������ ����): d��� �ڸ���
		// %f (�Ǽ�)
		// %s (���ڿ�)
		// %c (����)
		// Ư������: \t (��Ű), \n (�ٹٲ�)
		
		System.out.printf("num�� ���� [%d] �Դϴ�. �׸��� [%d]�� �־��\n", num, 1000);
		
		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f ���� �� %f �Դϴ�\n", f); // f ���� �� 3.140000 �Դϴ�
		
		//cmd (console) ���� �Է°� �о����
		
		Scanner sc = new Scanner(System.in); // ctrl + shift + o: import �ڵ��ϼ�
		// java.util.Scanner sc = new java.util.Scanner(System.in);
		// �� ����� ���������� ����� ������ ��� ����� �ϹǷ� import java.util.Scanner �ϰ� ����ϴ� ���� ����
		
		System.out.println("���� �Է��ϼ���");
		// String value = sc.nextLine(); // �Է��� �� ���� [���] ... public String nextLine()
		// System.out.println("�Է°�: " + value);
		
		// int number = sc.nextInt(); // ���
		// System.out.println("�Է°�: " + number); // ���� Ÿ�Ը� ó��
		
		// float number = sc.nextFloat();
		// System.out.println("�Է°�: " + number);
		
		// ������� (���ڷ� �޾Ƽ� ��ȯ�ؼ� ���)
		// TODAY POINT
		// [[[ ���ڸ� -> ���ڷ� ]]]
		// Integer.parseInt(s) ���ڸ� ������
		// Float.parseFloat(s) ���ڸ� �Ǽ���
		// Double.parseDouble(s) ���ڸ� �Ǽ���
		
		System.out.println("���� �Է��ϼ���");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println("����: " + number);
		
		// ���� -> ���� (���� ����...)
		// String data = String.valueOf(1000);
		// System.out.println(data); // [?] Ÿ�������� ����� �� �ִ� �� ã�ƺ���
		
		
		
		Ex07_Printf_format ex = new Ex07_Printf_format();
		// main�Լ��� (class = method = static) ������ �ö� �ִµ�
		// ���� �ڵ�� Heap �޸𸮿� ��ü�� �����ϸ� main�Լ��� Heap�޸𸮿� �����Ǵ� ���� �ƴ϶� main�Լ��� �ּҸ� ������ ���� �����.
		ex.print();
	}
	public void print() {
		// System.out.println("�Ϲ� �Լ�");

	}
}

// public int a () {} ���⼭ int�� �� �� �ִ� Ÿ�Ե�
// byte, char, short, int, long
// float, double
// boolean
// String
// class�� -> �ּҰ��� return