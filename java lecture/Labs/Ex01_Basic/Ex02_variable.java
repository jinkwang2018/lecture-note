class Vtest { // �Ʒ��� ������ public class ��� �Ұ�
	// int iv = 1000; // �ʱ�ȭ
	int iv; // �ʱⰪ�� ������ �ִ�. why? 
	
	void print() {
		System.out.println("instance variable : " + iv);
	}
}

class Apt { // �Ʒ��� ������ public class ��� �Ұ�
	String color;
	Apt(String color) { // Ư���� �Լ� (������ �Լ�(constructor)): �Ϲ��Լ��� �ٸ���, class�� �̸��� ���� �ؾ��Ѵ�.
		this.color = color;
	}
	void aptPrint() {
		System.out.println("����: " + this.color);
	}
}

public class Ex02_variable { // public class�� java���� �� �ϳ��� �����ؾߵǰ�, class���� ���ϸ�� ��ġ�ؾ� �ȴ�.
	public static void main(String[] args) {
		Vtest t = new Vtest();
		t.print();
		Vtest t2 = new Vtest();
		t2.iv = 3000;
		t2.print();
		Vtest t3 = new Vtest();
		t3.print();
		///////////////////////
		
		Apt a = new Apt("blue");
		a.aptPrint();
		
		Apt b = new Apt("red");
		b.aptPrint();
		
	}
}
