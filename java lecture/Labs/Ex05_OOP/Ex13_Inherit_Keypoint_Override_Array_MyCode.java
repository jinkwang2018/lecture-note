/*
요구사항
카트 (Cart)
카트에는 매장에 있는 모든 전자제품을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... 카트에 담는다

계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy())
hint) summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
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
			System.out.println("카트 한도를 초과하셨습니다.");
			return;
		}
		n[numcnt] = new Goods(name, price);
		if(this.money < n[numcnt].price) {
			System.out.println("고객님 잔액이 부족합니다^^");
			return;
		}
		this.money -= n[numcnt].price;
		this.count += n[numcnt].price;
		System.out.println("구매한 물건은: " + n[numcnt].toString());
		System.out.println("잔액: " + this.money);
		System.out.println("누적금액: " + this.count);
		this.numcnt++;
	}
	
	void summary(ProductParent[] n) {
		for(ProductParent v : n) {
			if(v != null) {
				System.out.println("물건이름: " + v.toString() + " / " + "가격: " + v.price);
			}
		}
		System.out.println("누적금액: " + this.count);
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
