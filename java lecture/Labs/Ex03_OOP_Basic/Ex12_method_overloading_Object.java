class Human2 {
	String name;
	int age;
}

class Test{
	Human2 add(Human2 h) {
		h.name = "ȫ�浿";
		h.age = 200;
		return h;
		// return null;
	}
	
	Human2 add(Human2 h, Human2 h2) {
		h2.age = h.age;
		h2.name = h.name;
		return h2;
	}
	
	void add(Human2[] harry) {
		System.out.println(harry.length);
	}
}

// �޸� ���� �׸� �׸���

public class Ex12_method_overloading_Object {
	public static void main(String[] args) {
		Test t = new Test();
		Human2 man = new Human2();
		Human2 man2 = t.add(man);
		System.out.println("man �������� == man2 �������� �ּҰ�: " + (man == man2));
		System.out.println(man2.name + " / " + man2.age);
		
		Human2 m = new Human2();
		m.name = "�ƹ���";
		m.age = 1;
		
		Human2 m2 = new Human2();
		
		Human2 m3 = t.add(m, m2);
		System.out.println(m3.age + ", " + m3.name);
		System.out.println(m == m3); //�ٸ� �޸�
		System.out.println(m2 == m3); //���� �޸�
		
		Human2[] arr = {new Human2(), new Human2()};
		t.add(arr);
	}
}
