package Quiz_;

import java.util.Scanner;

public class Quiz_2018_02_01_01 {

	public static void main(String[] args) {
		//1. ��� ���� �������� ( Hint: Scanner, String.split() )
		//split�� �迭�� ��´�. ������ ��Ƽ� ���ڳ� ���ڸ� �ڸ���. �ּҰ��� �����Ѵ�.
		//ex) abcdef  ------> cd
		//    abcde   ------> c
		//    Bitcamp ------> c
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine(); //console�� �� �Է� �� �� �ְ� �Ѵ�.
		
		String []str1 = text.split(""); // ""�� �������� ���ڿ��� ������
		if(str1.length%2 == 0) { //���ڿ��� ¦ �� �� �� ��� ���ڿ� �� ���� ������.
			System.out.println(str1[str1.length/2-1]+str1[str1.length/2]);}
		else {
			System.out.println(str1[str1.length/2]); // ���ڿ��� Ȧ�� �� �� ��� ���ڷ� ������.
		}
		
		
		
	}

}
