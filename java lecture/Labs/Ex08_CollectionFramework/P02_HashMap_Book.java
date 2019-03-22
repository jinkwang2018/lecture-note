import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
�������� ���α׷����� ���� (���, ��ȸ , ���� , ���� , ��ü��ȸ ...)
ArrayList, HashMap �� Colletion ����ϱ�

��� -> HashMap����
��ȸ -> HashMap�� Ű������. Ű�� ��ȣ��, ���� Ŭ������ ������ ��ü �ּҷ�
���� -> HashMap�� Ű������.
���� -> HashMap�� Ű������
��ü��ȸ -> Set����.

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
		System.out.println(index + "�� å�� ��ϵǾ����ϴ�.");
	}
	
	void search(String title) {
		
	}
}

public class P02_HashMap_Book {
	public static void main(String[] args) {
		
	}
}
