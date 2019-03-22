import java.util.Scanner;

// 반복문(while, do~while)

public class Ex10_Statement {
	public static void main(String[] args) {
		int i = 10;
		while(i >= 10) { // 조건 true 블럭안의 구문 실행
			System.out.println(i);
			i--; // 반드시 명시적인 증가감 필요
		}
		// 1~100 까지의 합
		int sum = 0;
		int j = 1;
		while(j <= 100) {
			// j++ (주의사항)
			sum += j; // sum = sum + j
			j++; // 명시적인 증가감
		}
		System.out.println("1~100까지 합: " + sum);
		
		// while 사용해서 구구단
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
		
		// do~while(): 강제적 실행 (무조건 한 번은 실행)
		// do{ 실행문 }while(조건식)
		// 메뉴 구성
		// 1. 인사 / 2. 급여
		Scanner sc = new Scanner(System.in);
		int inputdata = 0;
		do {
			System.out.println("숫자입력해(0~10)");
			inputdata = Integer.parseInt(sc.nextLine()); // 문자 -> 숫자(정수)
		}while(inputdata > 10);
		// 10보다 큰 값이 오면 true면 다시 do문을 실행
		// 0~10까지의 값이 입력되면 조건이 false가 되어서 while문 탈출
		System.out.println("당신이 입력한 숫자는: " + inputdata);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
