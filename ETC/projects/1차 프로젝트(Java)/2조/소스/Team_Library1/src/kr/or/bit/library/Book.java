package kr.or.bit.library;

import java.io.File;
import java.io.Serializable;
/** 
Ŭ������ : Book
��¥ : 2018-02-20
�ۼ��ڸ� : ���ֿ�
*/
public class Book implements Serializable {
	private int bookNumber;
	private String title;
	private String author;
	private String genre;
	private String content;

	private int rentalCount;
	private boolean rental;

	public Book(String title, String author, String content, String genre) {
		this.bookNumber = createBookNumber();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.content = content;

		this.rentalCount = 0;
		this.rental = true;
	}

	public boolean isRental() {
		return rental;
	}

	public String getTitle() {
		return title;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public int getRentalCount() {
		return rentalCount;
	}
	
	public void setRentalCount(int rentalCount) {
		this.rentalCount = ++rentalCount;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}
	/**
	 * 
	��¥ : 2018-02-23
	��� : �ϳѹ� �����ϱ� ��ġ���ʰ�
	�ۼ��ڸ� : ���ֿ�
	 */
	private int createBookNumber() { // �ϳѹ� ���� ��ġ�� �ʰ�

		File f = new File("c:\\Temp\\library\\Books");
		if (f.exists()) {
			File[] num = f.listFiles();
			if (num.length != 0) {
				try {
					int filename = Integer.parseInt(num[num.length - 2].getName().replace(".", "@").split("@")[0]);
					return ++filename;
				}catch (Exception e) {
					File temp = new File("c:\\Temp\\library\\Books\\booklist.txt");
					if(temp.exists()) temp.delete();
				}
			}
		}
		return 10001;
	}

}
