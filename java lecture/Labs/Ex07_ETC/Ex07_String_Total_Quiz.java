import java.util.Scanner;

//�ֹι�ȣ: �޹�ȣ ù�ڸ�: 1,3,���� / 2,4 ���ڶ�� ���...

//main�Լ� Scanner ��� �ֹι�ȣ �Է¹ް�
//��: 6�ڸ� ��: 7�ڸ�
//�Է°�: 123456-1234567

//1. �ڸ��� üũ (���) �Լ� (14 ok)
//2. �޹�ȣ ù��° �ڸ��� 1~4������ ���� ��� ����Լ�
//3. �޹�ȣ ù��° �ڸ����� ������ 1,3 ���� / 2,4 ���� ��� ����Լ�
//3���� �Լ� static

public class Ex07_String_Total_Quiz {
	static boolean checkLength(String ssn) {
			return (ssn.length() == 14);
	}
	
	static boolean checkHuman(String ssn) {
		int gender = Integer.parseInt(String.valueOf(ssn.charAt(ssn.indexOf("-") + 1)));
		return (gender >= 1 && gender <= 4);
	}
	
	static void print(String ssn) {
		int gender = Integer.parseInt(String.valueOf(ssn.charAt(ssn.indexOf("-") + 1)));
		String genderStr="";
		if(gender == 1 || gender == 3) {
			genderStr = "����";
		}else {
			genderStr = "����";
		}
		
		System.out.println("�ֹι�ȣ: " + ssn + " / " + genderStr);
	}
	
	public static void main(String[] args) {
		String ssn="";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("�ֹι�ȣ �Է�(123456-1234567): ");
			ssn = sc.nextLine();
			if(checkLength(ssn) && checkHuman(ssn)) break;
		}while(true); //while(�ڸ�check �Լ�, 1~4���� check �Լ�) (1��, 2�� �Լ�)
		print(ssn);
	}
}
