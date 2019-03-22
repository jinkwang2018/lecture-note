
public class Ex09_Statement {

	public static void main(String[] args) {
		// ���
		// ���ǹ�: if (3����), switch() case (break Ȱ��)
		// �ݺ���: for(�ݺ�Ƚ�� ��Ȯ), while(), do~while()
		// break (��Ż��), continue (�Ʒ����� skip)
		
		// ���ǹ�
		int count = 0; // local variable ������� �ʱ�ȭ
		if(count < 1) {
			System.out.println("True �Դϴ�");
		}
		
		if(count > 1) System.out.println("True {����}");
		
		char data = 'A';
		switch (data) { // switch (���ǰ�) ����(����), char, String ����
			case 'A': System.out.println("���ں�");
				break;
			default: System.out.println("default");
		}
		
		// �ݺ���
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			//System.out.println(i);
			sum += i; //sum = sum + i;
		}
		System.out.println("sum 1~10���� ��: " + sum);
		
		// for���� ����ؼ� 1~100������ Ȧ���� ���� ���� ������
		// for�� ��ü�� �ذ� (for���� �ٸ� ����� ���� ������)
		int sum2 = 0;
		for(int i = 1; i <= 10; i += 2) {
			sum2 += i;
		}
		System.out.println("sum 1~10���� Ȧ�� ��: " + sum2);
		
		// ¦���� �� (1~100)
		// for�� �ȿ��� if �� ���
		int sum3 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i%2 == 0) {
				sum3 += i;
			}
		}
		System.out.println("sum 1~100���� ¦�� ��: " + sum3);
		
		// �Ի���� ��ǥ���� ����
		// ��ø for�� => ������ (�࿭)
		// 2~9 ������ (1~9)���� �ݺ�
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				// System.out.println(i + "/" + j);
				System.out.printf("[%d]*[%d]=[%d]", i, j, i*j);
			}
			System.out.println();
		}
		System.out.println();
		
		// Key Point (break (Ż��), continue (��ŵ))
		for(int i=2; i < 10; i++) {
			for(int j=1; j < 10; j++) {
				// if(i == j) break;
				// System.out.printf("[%d]*[%d]=[%d]", i, j, i*j);
				// System.out.printf("%s", "*");
				if (i == j) continue;
				System.out.printf("[%d]*[%d]=[%d]", i, j, i*j);
			}
			System.out.println();
		}
		
		for(int i=2; i <= 9; i++) {
			for(int j=1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 100; i >= 0; i--) {
			System.out.println(i);
		}
		
		// ���� (�Ǻ���ġ) ������ ����
		System.out.println("�Ǻ���ġ");
		int a = 0, b = 1, c = 0;
		for(int i = 0; i < 10; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(" " + c);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
