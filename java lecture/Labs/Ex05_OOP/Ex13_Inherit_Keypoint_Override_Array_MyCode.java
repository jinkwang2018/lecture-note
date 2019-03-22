/*
�䱸����
īƮ (Cart)
īƮ���� ���忡 �ִ� ��� ������ǰ�� ���� �� �ִ� 
īƮ�� ũ��� �����Ǿ� �ִ� (10��) : 1��  , 2�� ���� �� �ְ� �ִ� 10������ ���� �� �ִ�
���� ������ ���� �ϸ� ... īƮ�� ��´�

���뿡 ���� ��ü ���
������� �ʿ�
summary() ��� �߰��� �ּ���
����� ������ �����̸� �� �������� ����
�� �����ݾ� ��� ���

hint) īƮ ������ ��� ���� (Buy())
hint) summary()  main �Լ����� ����Ҷ�

�����ڴ� default �ݾ��� ������ �ְ� �ʱ�ݾ��� ������ �� �� �ִ�
*/

class BuyerPerson {
	int money;
	int numcnt;
	int count;
	
	BuyerPerson() {
		this(1000);
	}
	
	BuyerPerson(int money) {
		this.money = money;
	}
	
	void buy(ProductParent[] n, String name, int price) {
		if(numcnt >= 10) {
			System.out.println("īƮ �ѵ��� �ʰ��ϼ̽��ϴ�.");
			return;
		}
		n[numcnt] = new Goods(name, price);
		if(this.money < n[numcnt].price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return;
		}
		this.money -= n[numcnt].price;
		this.count += n[numcnt].price;
		System.out.println("������ ������: " + n[numcnt].toString());
		System.out.println("�ܾ�: " + this.money);
		System.out.println("�����ݾ�: " + this.count);
		this.numcnt++;
	}
	
	void summary(ProductParent[] n) {
		for(ProductParent v : n) {
			if(v != null) {
				System.out.println("�����̸�: " + v.toString() + " / " + "����: " + v.price);
			}
		}
		System.out.println("�����ݾ�: " + this.count);
	}
}

class ProductParent {
	String name;
	int price;
	int count;
	
	ProductParent(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

class Goods extends ProductParent {
	Goods(String name, int price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return super.name;
	}
}

/*class KtTv2 extends Goods {
	KtTv2() {
		super("KtTv", 500);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio2 extends Goods { 
	Audio2() {
		super("Audio", 100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class Notebook2 extends Goods {
	Notebook2() {
		super("Notebook", 150);
	}
	
	@Override
	public String toString() {
		return "Notebook";
	}
}*/

public class Ex13_Inherit_Keypoint_Override_Array_MyCode {
	public static void main(String[] args) {
		Goods[] goods = new Goods[10];
		BuyerPerson buyer = new BuyerPerson(30000);
		
		buyer.buy(goods, "Tv", 500);
		buyer.buy(goods, "Audio", 100);
		buyer.buy(goods, "Notebook", 150);
		buyer.buy(goods, "Tv", 150);
		buyer.buy(goods, "Tv", 150);
		buyer.buy(goods, "Tv", 150);
		buyer.buy(goods, "Tv", 150);
		buyer.buy(goods, "Tv", 150);
		buyer.summary(goods);
	}
}
