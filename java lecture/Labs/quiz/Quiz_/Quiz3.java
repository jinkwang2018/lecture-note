package Quiz_;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		int sum = 0;
		for(int num = 0 ; num <=20 ; num++) {
			if(num%2 == 0 || num%3 ==0) {
				sum += 0;
			}else {
				sum += num;
			}
				
		}System.out.println("1~20������ ������ �� : " + sum);
		
		
		
		for(int i = 1 ; i <= 6 ; i++) {
			for(int j = 1 ; j <= 6 ; j++) {
				if(i+j == 6) {System.out.printf("[%d,%d]",i,j );}				}
			}
		System.out.println();
		//���� , ���� ,�� ���� �� ����� ���ؼ� �ۼ��ϼ��� (IF)

		//���� ���)

		//��ǻ�Ͱ� �ڵ����� ���� ���� , ���� , �� �� ���ؼ� ����ڰ� ���� �Է� �ؼ� ó�� �ϼ���

		//( ���� ��� : ����=> 1   , ���� => 2  , �� => 3)
	
		int inputdata = 0;
		int i = 0;
		do{i = ((int)(Math.random()*10)+1);}
		while(i>3);
		System.out.println("����(1),����(2),��(3)�� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		inputdata = Integer.parseInt(sc.nextLine());
		if(i == 1) {
			System.out.println("��ǻ�ʹ� ����");
			if(inputdata == 1) {
				System.out.println("�����ϴ�.");
			}else if(inputdata == 2) {
				System.out.println("�̰���ϴ�.");
			}else if(inputdata == 3) {
				System.out.println("�����ϴ�.");		
			}
		}else if(i == 2) {
			System.out.println("��ǻ�ʹ� ����");
			if(inputdata == 1) {
				System.out.println("�����ϴ�.");
			}else if(inputdata == 2) {
				System.out.println("�����ϴ�.");
			}else if(inputdata == 3) {
				System.out.println("�̰���ϴ�.");		
			}
		}else if(i == 3) {
			System.out.println("��ǻ�ʹ� ��");
			if(inputdata == 1) {
				System.out.println("�̰���ϴ�.");
			}else if(inputdata == 2) {
				System.out.println("�����ϴ�.");
			}else if(inputdata == 3) {
				System.out.println("�����ϴ�.");		
			}

		}
	}
}
		
		