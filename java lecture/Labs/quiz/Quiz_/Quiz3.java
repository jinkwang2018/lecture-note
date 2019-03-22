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
				
		}System.out.println("1~20까지의 정수의 합 : " + sum);
		
		
		
		for(int i = 1 ; i <= 6 ; i++) {
			for(int j = 1 ; j <= 6 ; j++) {
				if(i+j == 6) {System.out.printf("[%d,%d]",i,j );}				}
			}
		System.out.println();
		//가위 , 바위 ,보 게임 또 제어문을 통해서 작성하세요 (IF)

		//예를 들면)

		//컴퓨터가 자동으로 나온 가위 , 바위 , 보 에 대해서 사용자가 값을 입력 해서 처리 하세요

		//( 예를 들면 : 가위=> 1   , 바위 => 2  , 보 => 3)
	
		int inputdata = 0;
		int i = 0;
		do{i = ((int)(Math.random()*10)+1);}
		while(i>3);
		System.out.println("가위(1),바위(2),보(3)을 입력하세요");
		Scanner sc = new Scanner(System.in);
		inputdata = Integer.parseInt(sc.nextLine());
		if(i == 1) {
			System.out.println("컴퓨터는 가위");
			if(inputdata == 1) {
				System.out.println("비겼습니다.");
			}else if(inputdata == 2) {
				System.out.println("이겼습니다.");
			}else if(inputdata == 3) {
				System.out.println("졌습니다.");		
			}
		}else if(i == 2) {
			System.out.println("컴퓨터는 바위");
			if(inputdata == 1) {
				System.out.println("졌습니다.");
			}else if(inputdata == 2) {
				System.out.println("비겼습니다.");
			}else if(inputdata == 3) {
				System.out.println("이겼습니다.");		
			}
		}else if(i == 3) {
			System.out.println("컴퓨터는 보");
			if(inputdata == 1) {
				System.out.println("이겼습니다.");
			}else if(inputdata == 2) {
				System.out.println("졌습니다.");
			}else if(inputdata == 3) {
				System.out.println("비겼습니다.");		
			}

		}
	}
}
		
		