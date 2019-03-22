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
		//1. Array(�迭)�� ����ؼ� Cart�� ����� Cart�� ��ǰ(Tv, Audio, Notebook) ��������
		//Product[] cart = {new Tv(), new Audio(), new Notebook()}; //���� § �ڵ�
		Product[] cart = new Product[3]; //�������� ����� �迭
		cart[0] = new Tv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		
		//2. ArrayList(Collection�� ����ؼ� Cart�� ����� Cart�� ��ǰ(Tv, Audio, Notebook) ��������
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
