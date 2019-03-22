//������, ���

public class Ex06_Operation {
	public static void main(String[] args) {
		int sum = 0;
		// ���� ������ (+=, -=, *= ...): ���������� ���
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum - 1;
		System.out.println("sum: " + sum);

		// ������ ���� ����
		// ������ ���ؼ� A+ , B-
		// 94��
		// 95�� ���� ũ�� A+
		// �� �ܴ� A-
		
		// �Ϲ� ���
		int score = 75;
		String grade = ""; // ���ڿ� �ʱ�ȭ ""
		System.out.println("����� ������: " + score);

		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println("����� ������: " + grade + "�Դϴ�");
		
		// ���� ������ ���: ���� = (���ǽ�)? A:B
		int score2 = 95;
		String grade2 = "";
		System.out.println("����: " + score2);
		
		if (score2 >= 90) {
			grade2 = "A";
			grade2 += (score2 >= 95) ? "+" : "-"; 
		}else if (score2 >= 80) {
			grade2 = "B";
			grade2 += (score2 >= 85) ? "+" : "-";
		}else if (score2 >= 70) {
			grade2 = "C";
			grade2 += (score2 >= 75) ? "+" : "-";
		}else {
			grade2 = "F";
		}
		System.out.println("����: " + grade2);
		
		// [����Ű]
		// syso > ctrl + space
		// �ڵ� �����ϱ�: ctrl + A �� ���� > ctrl + shift + F (�ڵ� �鿩���� ����)
		
		
		// switch ��
		int data = 100;
		switch (data) {
			case 100:
				System.out.println("100�Դϴ�");
				break;
			case 90:
				System.out.println("90�Դϴ�");
				break;
			case 80:
				System.out.println("80�Դϴ�.");
				break;
			default:
				System.out.println("default");
		}
		
		// break ������ ��� �ȴ�
		switch (data) {
		case 100: System.out.println("100�Դϴ�");
		case 90: System.out.println("90�Դϴ�");
		case 80: System.out.println("80�Դϴ�.");
		default: System.out.println("default");
		}
		
		// ������ break ������ ��� ��
		int month = 3;
		String res = "";
		
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: res = "31"; break;
   
            case 4:
            case 6:
            case 9:
            case 11: res = "30"; break;
   
            case 2: res = "29"; break;
   
            default : res ="���� �ƴմϴ�.";
        }
        System.out.println(month + "���� " + res + "�ϱ��� �Դϴ�.");
		
        // ���� (������: ������ ���Ⱚ)
        // import java.lang.Math (Math Ŭ����)
        // java.lang ������������ �ڹٿ��� ���� ����ϱ� ������ �̹� import�� �Ǿ� �ִ�. (default�� ���µ� �ڽ�)
        // default > java.lang > import ����������...
        // java.lang �ȿ� �ִ� �ڿ��� import ���� ��밡���ϴ�
        // Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
        // Math.random() �ڿ��� random() �Լ��� static �̱� ������ ��ü ���� ���̵� ��� �����ϴ�.
        // ���: 0.0 <= random < 1.0�� dobule Ÿ���� ���� ����
        
        
        System.out.println("Math.random(): " + Math.random()); // double Ÿ��
        System.out.println("Math.random() * 10: " + Math.random() * 10);
        // 0~9������ ����
        System.out.println("0~9������ ����: " + (int)(Math.random() * 10));
        // 1~10������ ����
        System.out.println("1~10������ ����: " + (int)(Math.random() * 10 + 1));
        
        /*
         * ���� Quiz
         * ������� �ϴ� �ý����� ��ȭ�� ��ǰ ��÷ �ý����Դϴ�.
         * ��ǰ ��÷�� 1000 ������ ������
         * ��ǰ���� Tv, NoteBook, �����, �ѿ켼Ʈ, ����
         * ��ǰ ��÷�� 900 ������ ������
         * ��ǰ���� NoteBook, �����, �ѿ켼Ʈ, ����
         * ��ǰ ��÷�� 800 ������ ������
         * ��ǰ���� �����, �ѿ켼Ʈ, ����
         * ��ǰ ��÷�� 700 ������ ������
         * ��ǰ���� �ѿ켼Ʈ, ����
         * ��ǰ ��÷�� 600 ������ ������
         * ��ǰ���� ����
         * �� �ܴ� 100 ~ 500 ������ ĩ��
         * 
         * ����ڰ� �ͼ� ��ǰ �ý����� ����ϰ� �Ǹ� �����ϰ� 100 ~ 1000������ ������ ���´�.
         */
        
	}
}