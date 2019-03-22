package kr.or.bit.library;

public class Book {
	private String title;
	private int bookNumber;
	private String content;
	private String author;
	private String genre;
	private int rentalCount;
	private boolean rental;
	
	public Book(String title, String content, String author, String genre) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.genre = genre;
		this.rentalCount = 0;
		this.rental = false;
		this.bookNumber = createBookNumber();
	}
	
	private int createBookNumber() { //ºÏ³Ñ¹ö »ý¼º °ãÄ¡Áö ¾Ê°Ô
		
		return 0;
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
	
	
	
}
