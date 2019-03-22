import java.util.Arrays;

public class Ex01_Array_Quiz {
	public static void main(String[] args) {
		//[문제1] 수학과 학생들의 기말고사 시험점수
		System.out.println("[문제1]");
		int[] score = new int[] {79, 88, 97, 54, 56, 95};
		int max = score[0];
		int min = score[0];
		
		/*
		제어문을 사용해서 max라는 변수에는 최대값, min 변수에는 최소값이 담기도록 작성하세요
		ex) max = 97, min = 54
		 */
		for(int i = 0; i < score.length; i++) {
			max = (score[i] > max) ? score[i] : max;
			min = (score[i] < min) ? score[i] : min;
			//if(score[i] > max) { max = score[i]; }
			//if(score[i] < min) { min = score[i]; }
		}
		System.out.println("max = " + max + " / " + "min = " + min);
		
		System.out.println();
		
		/* [문제2]
		10개의 방의 값을 1~10까지로 초기화
		number[0] 출력하면 1이라고 출력
		단) 하나의 for문만 사용
		 */
		System.out.println("[문제2]");
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++) {
			number[i] = i + 1;
			System.out.printf("number[%d]: %d\n", i, number[i]); //내가 작성한 코드
		}
		// System.out.println(Arrays.toString(number)); //수업시간에 배운 코드
		
		System.out.println();
		
		/* [문제3]
		어느 학생의 기말고사 시험점수 (5과목)
		1. 총 과목 수
		2. 과목의 합
		3. 과목의 평균
		단) 하나의 for문만 사용
		 */
		System.out.println("[문제3]");
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100, 55, 90, 60, 78};
		
		for(int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
			// 수업시간의 코드
			if (i == jumsu.length - 1) {
				average = sum / (float)jumsu.length;
			}
		}
		// average = (float)sum / jumsu.length; // 내가 짠 코드
		
		System.out.println("1.총 과목 수: " + jumsu.length);
		System.out.println("2.과목의 합: " + sum);
		System.out.println("3.과목의 평균: " + average);
	}
}
