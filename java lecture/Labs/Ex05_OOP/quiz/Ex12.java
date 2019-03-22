package quiz;

class Product {
	int price;
	int point;
	
	Product(int price) {
		this.price = price;
		this.point = (int)(price / 10.0);
	}
}

class Tv extends Product {
	Tv() {
		super(500);
	}

	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product {
	Audio() {
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}

class Computer extends Product {
	Computer() {
		super(150);
	}

	@Override
	public String toString() {
		return "Computer";
	}
}

class Buyer {
	int money;
	int point;
	
	Buyer() {
		this(1000);
	}
	
	Buyer(int money) {
		this.money = money;
	}
	
	void buy(Product n) {
		if(this.money < n.price) {
			System.out.println("금액이 부족합니다");
			return;
		}
		this.money -= n.price;
		this.point += n.point;
		System.out.println("구입한 제품: " + n.toString() + "/ 가격: " + n.price);
		System.out.println("현재 금액: " + this.money);
		System.out.println("누적 포인트: " + this.point);
	}
}

public class Ex12 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		Audio audio = new Audio();
		Computer computer = new Computer();
		
		Buyer buyer = new Buyer(2000);
		
		System.out.println("초기 금액: " + buyer.money);
		buyer.buy(tv);
		buyer.buy(audio);
		buyer.buy(computer);
		buyer.buy(tv);
		buyer.buy(audio);
		buyer.buy(tv);
		buyer.buy(tv);
		buyer.buy(tv);
		buyer.buy(tv);
	}
}
