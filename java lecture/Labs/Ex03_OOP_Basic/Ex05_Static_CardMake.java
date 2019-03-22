import kr.or.bit.Card;

public class Ex05_Static_CardMake {
	public static void main(String[] args) {
		
		Card c = new Card();
		c.number = 1;
		c.kind = "Heart";
		//변경사항
		c.h = 500;
		c.w = 200;
		//53장 하나씩 고치겠다
		c.cardInfo();
		//카드 1장 만들어서 정보 확인
		
		Card c2 = new Card();
		c2.number = 10;
		c2.kind = "Heart";
		c2.cardInfo();
		
		//...53장의 카드 생성
		//이 때, 고객이 카드 h, w 수정 요구
		//h = 500, w = 200 요구사항...
		
	}
}
