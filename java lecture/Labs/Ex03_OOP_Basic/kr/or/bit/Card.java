package kr.or.bit;

/*
우리는 카드를 만들어서 판매하는 회사입니다
고객의 요청에 따라 카드 53장을 제작하게 되었습니다.

요구사항
카드는 카드의 번호를 가지고 있고 모양을 가지고 있다.
카드는 크기를 가지고 있습니다. 크기는 높이, 너비를 가지고 있다

혹시 카드의 크기는 변경가능 할까요?
-> 모든 카드의 높이와 너비는 동일 (공통사항)
 */

public class Card {
	public int number;
	public String kind;
	
	//public int h = 50;
	//public int w = 20;
	public static int h = 50;
	public static int w = 20;
	
	//기능(정보)
	public void cardInfo() {
		System.out.printf("번호: %d, 모양: %s, h: %d, w: %d\n", number, kind, h, w);
	}
}
