package kr.or.bit;
/*
책은 책이름을 가지고 있고 책의 가격을 가지고 있다
책이 출판되면 반드시 책이름과 책의 가격을 가지고 있어야 한다
책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고, 출판된 이후에는 수정할 수 없다

(추가 요청)
책 이름과 가격 정보는 각각 확인할 수 있다.
 */

public class Book {
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void bookInfo() {
		System.out.println("책정보: " + this.name + "/" + this.price);
	}
}


/* 내가 작성한 코드
public class Book {
	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void getBookInfo() {
		System.out.println("책의 이름: " + name + " / " + "가격 정보: " + price);
	}
}
*/