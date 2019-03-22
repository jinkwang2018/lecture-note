/*
������: �ζ� ���α׷�
�ۼ���: ������
��¥   : 2018-01-31
����   : Ex02_Lotto_Main_Class.java
 */

/*
1. 1~45������ ������ �߻����� 6���� �迭�� ��������
2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�
3. �迭�� �ִ� 6���� ���� ���� ������ ���Ľ�Ű����
4. �ζ� �迭�� ����� 30~35 ���̰� �ƴѰ�� ������
������ ����� ������ class �����ϼ���
member field , method (���) , �޴�
*/

import java.util.Arrays;
import java.util.Scanner;

class Lotto{
	int[] arr;
	
	//1. 1~45������ ������ �߻����� 6���� �迭�� ��������
	void selectNumber() {
		arr = new int[6];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			for(int j = 0; j < i; j++) {
				if(i != j) {
					if(arr[i] == arr[j]) {
						do { //2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ�
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
		
		//3. �迭�� �ִ� 6���� ���� ���� ������ ���Ľ�Ű����
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
		
		System.out.println("���İ�: " + Arrays.toString(arr));
	}
	
	//4. �ζ� �迭�� ����� 30~35 ���̰� �ƴѰ�� ������
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
		
		System.out.printf("����: %d / ���: %f\n", sum, average);
	}
	
}

public class Ex02_Lotto_Main_Class {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� ���?: ");
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= num; i++) {
			System.out.println(i +"��");
			lotto.selectNumber();
			lotto.lottoPrint();
		}
	}
}