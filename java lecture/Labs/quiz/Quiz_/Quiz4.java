package Quiz_;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		int j = 0;
		int inputdata = 0;
		do{j = ((int)(Math.random()*10)+1);}
		while(j>3);
		
		System.out.println("����(1),����(2),��(3)�� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		inputdata = Integer.parseInt(sc.nextLine());
		System.out.println(j);
		
		int sum = inputdata-j;
		System.out.println(sum);
		if(sum == 0) {
			System.out.println("�����ϴ�.");
		}else if(sum == -2 || sum == 1){
			System.out.println("�̰���ϴ�.");
		}else if(sum == -1 || sum ==2)
			System.out.println("�����ϴ�.");
		}

	}


