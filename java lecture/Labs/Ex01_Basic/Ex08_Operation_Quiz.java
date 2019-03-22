import java.util.Scanner;

/*
������ ��Ģ ����� (+, -, *, /)
�Է°� 3�� (�Է°��� nextLine() �޾Ƽ� �ʿ��ϴٸ� ���ڷ� ��ȯ)
����: Integer.parseInt(), equals() Ȱ��

ȭ��
> �Է°�1(����): 100
> �Է°�(��ȣ): +
> �Է°�2: ����
> ������(����): 200

��ȣ �޴� ��)
String opr = sc.nextLine();

hint) if() {}, else if() {}
hint) if(opr == "+") { ���ϱ� �����Ұž� } // �������� -> ���ڿ� String�� �ּҰ��� ������ ������ �Ʒ��� opr.equals("+")�� ���

*����) ���ڸ� ���ڷ� ��� �ٲܲ�����? Integer.parseInt(s)

TODAY POINT
**���ڿ��� ���� �񱳴� == �ƴϰ� (equals() �Լ��� ����Ѵ�)

hint) if(opr.equals("+")) { ���ϱ� ���� }
 */
public class Ex08_Operation_Quiz {
	public static void main(String[] args) {
		String opr = ""; // �ʱ�ȭ
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����1: ");
		num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("�����ȣ(+, -, *, /): ");
		opr = sc.nextLine();
		
		System.out.print("����2: ");
		num2 = Integer.parseInt(sc.nextLine());
		
		// ��� 1: if�� ���
		if(opr.equals("+")) result = num1 + num2;
		else if(opr.equals("-")) result = num1 - num2;
		else if(opr.equals("*")) result = num1 * num2;
		else if(opr.equals("/")) result = num1 / num2;
		else {
			System.out.println("�������� �ʴ� ������ �Դϴ�.");
			// Key point
			// return Ű����: [�Լ�����]�� ������ > main �Լ� Ż�� > ����
			return;
		}
		
		// ��� 2: switch�� ���
		/*switch (opr) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = num1 / num2; break;
			default:
				System.out.println("�������� �ʴ� �������Դϴ�.");
				return;
		}*/
		
		System.out.printf("���: [%d %s %d = %d]", num1, opr, num2, result);
	}
}
