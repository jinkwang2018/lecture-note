package kr.or.bit;
/*
å�� å�̸��� ������ �ְ� å�� ������ ������ �ִ�
å�� ���ǵǸ� �ݵ�� å�̸��� å�� ������ ������ �־�� �Ѵ�
å�� �̸��� ���� ������ Ư�� ����� ���ؼ��� �� �� �ְ�, ���ǵ� ���Ŀ��� ������ �� ����

(�߰� ��û)
å �̸��� ���� ������ ���� Ȯ���� �� �ִ�.
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
		System.out.println("å����: " + this.name + "/" + this.price);
	}
}


/* ���� �ۼ��� �ڵ�
public class Book {
	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void getBookInfo() {
		System.out.println("å�� �̸�: " + name + " / " + "���� ����: " + price);
	}
}
*/