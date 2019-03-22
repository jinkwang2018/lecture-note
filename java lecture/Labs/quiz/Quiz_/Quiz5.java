package Quiz_;

import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		int inputdata = 0; //받은 돈
		int purchase = 0; //상품의 총액
	
		Scanner sc = new Scanner(System.in);
		System.out.println("받은 돈을 입력하세요");
		inputdata = Integer.parseInt(sc.nextLine());
		System.out.println("상품의 가격을 입력하세요");
		purchase = Integer.parseInt(sc.nextLine());
		int change = inputdata - purchase; //잔돈
		System.out.println("잔돈은 : " + change + "입니다.");
		int surtax = purchase/10;
		System.out.println("부가세는 : " + surtax + "입니다.");

	}

}
