import javax.rmi.CORBA.Util;

// 연산자
public class Ex05_Operation {
	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13/2;
		System.out.println(result);
		
		result = 13%2; // 나머지를 구하는 연산자
		System.out.println(result);
		
		// 증가감 연산자(++, --) 1씩 증가, 감소
		int i = 10;
		++i; // 전치 증가
		System.out.println(i);
		i++; // 후치 증가
		// 변수 하나는 전치, 후치 동일
		System.out.println(i);
		
		// POINT 전치, 후치 연산자는 다른 식과 결합 (성질)
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2;
		System.out.println(result2);
		// result2: 10 = i2(5) + j2(5)
		System.out.println("result2: " + result2 + " j2: " + j2);
		result2 = i2 + j2++;
		System.out.println("result2: " + result2 + " j2: " + j2);
		// result2: 10 j2: 6
		
		// POINT
		// 자바의 연산 규칙
		// 정수의 모든 [연산]은 int 변환 후 처리
		// byte + byte => 컴파일러 int + int
		byte b = 100; // -128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c);
		//1. int d = b + c;
		//2. byte d = (byte)(b + c);
		System.out.println("d: " + d);
		
		// byte + short => 컴파일러 int + int
		// char + char  => 컴파일러 int + int
		// 연산처리시....
		// POINT: 연산에서 int 보다 작은 타입은 int 변환 (long 제외)
		// 연산시에 (byte, char, short -> int) 바꾸어서 연산 처리
		
		// 피연산자 중 표현범위가 큰 타입으로 형변환
		// byte + short -> int + int -> int
		// char + int   -> int + int -> int
		// int  + long  -> long + long -> long
		
		// (정수와 실수: 실수)
		// float + int -> float + float -> float
		// long  + float -> float + float -> float
		// float + dobule -> double + double -> double
		
		float num2 = 10.45f;
		int num3 = 20;
		// num2 + num3 연산
		// int result5 = (int)(num2 + num3); // float + float
		// System.out.println("result5: " + result5); // 데이터 손실
		
		float result5 = num2 + num3;
		System.out.println(result5);
		
		double result5a = num2 + num3;
		System.out.println(result5a); // 결과: 30.450000762939453 // [?] 왜 그런지 찾아보자.
		
		char c2 = '!';
		char c3 = '!';
		// c2 + c3 결과
		// char result6 = c2 + c3;
		int result6 = c2 + c3; // 아스키 코드표 기준 'A'에 대한 10진수: 65 + 65
		System.out.println("result6 : " + result6);
		// result6이 가지는 정수값의 문자를....
		System.out.println((char)result6);
		
		// 제어문
		// 중소기업 시험문제 (구구단 출력)
		// 별찍기
		int sum = 0;
		for(int j = 1; j <= 100; j++) {
			// System.out.println("j: " + j);
			if (j%2 == 0) {
				sum += j; // sum = sum + j;
			}
		}
		System.out.println("sum: " + sum);
		
		// == 연산자 ([값]을 비교하는 연산자)
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		// != 부정연산자
		if('A' != 65) {
			System.out.println("어 같은 값이 아니야");
		}else {
			System.out.println("어 같은 값이야");
		}
		
		// 암기(POINT)
		// 삼항 연산자 *잘쓰는 것이 중요*
		int p = 10;
		int k = -10;
		int result8 = (p == k)? p : k;
		System.out.println("result8: " + result8);
		// 삼항 연산자는 if 제어문 변경 가능
		
		// if문
		if(p == k) {
			result8 = p;
		}else {
			result8 = k;
		}
		System.out.println("result8: " + result8);
		
		// 진리표
		/*
			0: false
			1: true
			
			      OR    AND
			0 0   0      0
			0 1   1      0
			1 0   1      0
			1 1   1      1
			
			sql 문 (oracle)
			select *
			from emp
			where empno = 1000 and sal > 2000
			
			select *
			from emp
			where empno = 1000 or sal > 2000
			
			연산자
			 | OR 연산자
			 & AND 연산자
			 0 과 1 변환해서 bit 연산
		 */
		
		int x = 3;
		int y = 5;
		System.out.println("x|y: " + (x|y)); // OR
		System.out.println("x&y: " + (x&y)); // AND
		// 십진수 -> 2진수 (0과 1로만 이루어진 값으로)
		// 128 64 32 16 8 4 2 1
		//              0 0 1 1 *3 이진수
		//              0 1 0 1 *5 이진수
		// OR           0 1 1 1 => 1+2+4 = 7 이진수
		// AND          0 0 0 1 => 1 이진수
		
		// POINT 논리 연산 (&&(and), ||(or)) -> 연산자 return boolean
		// short circuit (가장 빠르게 확인)
		// if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1 && .....)
		// if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1 || .....)		
		
		
	}
}