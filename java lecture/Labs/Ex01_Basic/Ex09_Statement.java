
public class Ex09_Statement {

	public static void main(String[] args) {
		// 제어문
		// 조건문: if (3가지), switch() case (break 활용)
		// 반복문: for(반복횟수 명확), while(), do~while()
		// break (블럭탈출), continue (아래구문 skip)
		
		// 조건문
		int count = 0; // local variable 사용전에 초기화
		if(count < 1) {
			System.out.println("True 입니다");
		}
		
		if(count > 1) System.out.println("True {생략}");
		
		char data = 'A';
		switch (data) { // switch (조건값) 숫자(정수), char, String 가능
			case 'A': System.out.println("문자비교");
				break;
			default: System.out.println("default");
		}
		
		// 반복문
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			//System.out.println(i);
			sum += i; //sum = sum + i;
		}
		System.out.println("sum 1~10까지 합: " + sum);
		
		// for문을 사용해서 1~100까지의 홀수의 합을 구해 보세요
		// for문 자체로 해결 (for문에 다른 제어구문 쓰지 마세요)
		int sum2 = 0;
		for(int i = 1; i <= 10; i += 2) {
			sum2 += i;
		}
		System.out.println("sum 1~10까지 홀수 합: " + sum2);
		
		// 짝수의 합 (1~100)
		// for문 안에서 if 문 사용
		int sum3 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i%2 == 0) {
				sum3 += i;
			}
		}
		System.out.println("sum 1~100까지 짝수 합: " + sum3);
		
		// 입사시험 대표적인 문제
		// 중첩 for문 => 구구단 (행열)
		// 2~9 가지고 (1~9)까지 반복
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				// System.out.println(i + "/" + j);
				System.out.printf("[%d]*[%d]=[%d]", i, j, i*j);
			}
			System.out.println();
		}
		System.out.println();
		
		// Key Point (break (탈출), continue (스킵))
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
		
		// 수열 (피보나치) 간단한 원리
		System.out.println("피보나치");
		int a = 0, b = 1, c = 0;
		for(int i = 0; i < 10; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(" " + c);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
