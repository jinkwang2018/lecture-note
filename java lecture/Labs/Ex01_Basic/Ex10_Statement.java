import java.util.Scanner;

// �ݺ���(while, do~while)

public class Ex10_Statement {
	public static void main(String[] args) {
		int i = 10;
		while(i >= 10) { // ���� true ������ ���� ����
			System.out.println(i);
			i--; // �ݵ�� ������� ������ �ʿ�
		}
		// 1~100 ������ ��
		int sum = 0;
		int j = 1;
		while(j <= 100) {
			// j++ (���ǻ���)
			sum += j; // sum = sum + j
			j++; // ������� ������
		}
		System.out.println("1~100���� ��: " + sum);
		
		// while ����ؼ� ������
		int k = 2;
		int p = 1;
		while(k <=9) {
			p = 1;
			while(p <= 9) {
				System.out.printf("[%d]*[%d]=[%d]\t", k, p, k*p);
				p++;
			}
			System.out.println();
			k++;
		}
		
		// do~while(): ������ ���� (������ �� ���� ����)
		// do{ ���๮ }while(���ǽ�)
		// �޴� ����
		// 1. �λ� / 2. �޿�
		Scanner sc = new Scanner(System.in);
		int inputdata = 0;
		do {
			System.out.println("�����Է���(0~10)");
			inputdata = Integer.parseInt(sc.nextLine()); // ���� -> ����(����)
		}while(inputdata > 10);
		// 10���� ū ���� ���� true�� �ٽ� do���� ����
		// 0~10������ ���� �ԷµǸ� ������ false�� �Ǿ while�� Ż��
		System.out.println("����� �Է��� ���ڴ�: " + inputdata);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
