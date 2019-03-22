import java.util.ArrayList;
import java.util.List;

class Product {
	
}

class Tv extends Product {
	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product {
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product {
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex07_Generic_Quiz {
	public static void main(String[] args) {
		//1. Array(배열)를 사용해서 Cart를 만들고 Cart에 제품(Tv, Audio, Notebook) 담으세요
		//Product[] cart = {new Tv(), new Audio(), new Notebook()}; //내가 짠 코드
		Product[] cart = new Product[3]; //다형성을 사용한 배열
		cart[0] = new Tv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		
		//2. ArrayList(Collection를 사용해서 Cart를 만들고 Cart에 제품(Tv, Audio, Notebook) 담으세요
		//ArrayList<Product> pcart = new ArrayList<>();
		List<Product> pcart = new ArrayList<>();
		pcart.add(new Tv());
		pcart.add(new Tv());
		pcart.add(new Tv());
		pcart.add(new Audio());
		pcart.add(new NoteBook());
		pcart.add(new NoteBook());
		
		for(Product product : pcart) {
			System.out.println(product.toString());
		}
	}
}
