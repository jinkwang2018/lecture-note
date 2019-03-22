import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
도서관리 프로그램에서 도서 (등록, 조회 , 수정 , 삭제 , 전체조회 ...)
ArrayList, HashMap 등 Colletion 사용하기

등록 -> HashMap으로
조회 -> HashMap의 키값으로. 키는 번호로, 값은 클래스로 생성된 객체 주소로
수정 -> HashMap의 키값으로.
삭제 -> HashMap의 키값으로
전체조회 -> Set으로.

*/
class Book {
	String title;
	String author;
	int page;
	int price;
	
	Book(String title, String author, int page, int price) {
		this.title = title;
		this.author = author;
		this.page = page;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", page=" + page + ", price=" + price + "]";
	}
}

class Process {
	int index;
	Map map;
	Book book;
	
	Process(Map map) {
		this.map = map;
	}
	
	void register(String title, String author, int page, int price) {
		map.put(++index, new Book(title, author, page, price));
		System.out.println(index + "번 책이 등록되었습니다.");
	}
	
	void search(String title) {
		
	}
}

public class P02_HashMap_Book {
	public static void main(String[] args) {
		
	}
}
