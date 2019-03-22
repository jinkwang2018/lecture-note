/*
과제명: 로또 프로그램
작성자: 강성훈
날짜   : 2018-01-31
파일   : Ex02_Lotto_Main_Class.java
 */

/*
1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요
3. 배열에 있는 6개의 값을 낮은 순으로 정렬시키세요
4. 로또 배열의 평균이 30~35 사이가 아닌경우 재추출
위에서 만드시 내용을 class 설계하세요
member field , method (기능) , 메뉴
*/

import java.util.Arrays;
import java.util.Scanner;

class Lotto{
	int[] arr;
	
	//1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
	void selectNumber() {
		arr = new int[6];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			for(int j = 0; j < i; j++) {
				if(i != j) {
					if(arr[i] == arr[j]) {
						do { //2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요
							arr[i] = (int)(Math.random() * 45 + 1);
						}while(arr[i] == arr[j]);
					}
				}
			}	
		}
	}
	
	void lottoPrint() {
		int temp = 0;
		int cnt = 0;
		
		lottoAvg();
		
		//3. 배열에 있는 6개의 값을 낮은 순으로 정렬시키세요
		do {
			cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[i]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
				
						cnt++;
						break;
					}
				}
			}
		}while(!(cnt == 0));
		
		System.out.println("정렬값: " + Arrays.toString(arr));
	}
	
	//4. 로또 배열의 평균이 30~35 사이가 아닌경우 재추출
	void lottoAvg() {
		int sum = 0;
		float average = 0;
		
		do {
			sum = 0;
			for(int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			average = (float)sum / arr.length;
	
			selectNumber();
		}while (!(average >= 30 && average <= 35));
		
		System.out.printf("총합: %d / 평균: %f\n", sum, average);
	}
	
}

public class Ex02_Lotto_Main_Class {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 번 출력?: ");
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= num; i++) {
			System.out.println(i +"번");
			lotto.selectNumber();
			lotto.lottoPrint();
		}
	}
}