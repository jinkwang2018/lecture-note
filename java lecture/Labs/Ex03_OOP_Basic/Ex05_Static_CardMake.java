import kr.or.bit.Card;

public class Ex05_Static_CardMake {
	public static void main(String[] args) {
		
		Card c = new Card();
		c.number = 1;
		c.kind = "Heart";
		//�������
		c.h = 500;
		c.w = 200;
		//53�� �ϳ��� ��ġ�ڴ�
		c.cardInfo();
		//ī�� 1�� ���� ���� Ȯ��
		
		Card c2 = new Card();
		c2.number = 10;
		c2.kind = "Heart";
		c2.cardInfo();
		
		//...53���� ī�� ����
		//�� ��, ���� ī�� h, w ���� �䱸
		//h = 500, w = 200 �䱸����...
		
	}
}
