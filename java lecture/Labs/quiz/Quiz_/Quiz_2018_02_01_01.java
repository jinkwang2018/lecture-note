package Quiz_;

import java.util.Scanner;

public class Quiz_2018_02_01_01 {

	public static void main(String[] args) {
		//1. 가운데 글자 가져오기 ( Hint: Scanner, String.split() )
		//split은 배열에 담는다. 기준을 잡아서 글자나 숫자를 자른다. 주소값을 전달한다.
		//ex) abcdef  ------> cd
		//    abcde   ------> c
		//    Bitcamp ------> c
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine(); //console에 글 입력 할 수 있게 한다.
		
		String []str1 = text.split(""); // ""을 기준으로 문자열을 나눈다
		if(str1.length%2 == 0) { //문자열이 짝 수 일 때 가운데 문자열 두 개로 나눈다.
			System.out.println(str1[str1.length/2-1]+str1[str1.length/2]);}
		else {
			System.out.println(str1[str1.length/2]); // 문자열이 홀수 일 때 가운데 글자로 나눈다.
		}
		
		
		
	}

}
