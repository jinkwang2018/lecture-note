package Quiz_;

import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		int inputdata = 0; //���� ��
		int purchase = 0; //��ǰ�� �Ѿ�
	
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� �Է��ϼ���");
		inputdata = Integer.parseInt(sc.nextLine());
		System.out.println("��ǰ�� ������ �Է��ϼ���");
		purchase = Integer.parseInt(sc.nextLine());
		int change = inputdata - purchase; //�ܵ�
		System.out.println("�ܵ��� : " + change + "�Դϴ�.");
		int surtax = purchase/10;
		System.out.println("�ΰ����� : " + surtax + "�Դϴ�.");

	}

}
