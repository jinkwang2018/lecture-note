import java.util.ArrayList;

//Today Point
//generic
//JDK1.5 ���� ����
//C#, Java �ʼ����

//1.Object Ÿ�� ���� -> Object Ÿ�� Ż��
//2.Ÿ�� ������ (Ÿ�� ������)
//3.����ȯ (casting) ���� �ذ�: (Car)obj;

class Person {
	int age = 100;
}

//Generic Ŭ���� ���� >> Ÿ���� �����ؼ� ��ü�� ������ �� �ִ�
//MyGen<String> m = new MyGen<String>();
class MyGen<T> { //Type Parameter
	T obj;
	void add(T obj) {
		this.obj = obj;
	}
	T get() {
		return this.obj;
	}
}
/*
[heap�޸𸮿� �ö� �� ��]
MyGen<Car> c = new MyGen<Car>(); ���ָ�

class MyGen<Car> { //Type Parameter
	Car obj;
	void add(Car obj) {
		this.obj = obj;
	}
	Car get() {
		return this.obj;
	}
}
 */

public class Ex06_Generic {
	public static void main(String[] args) {
		MyGen<String> my = new MyGen<String>();
		my.add("Hello");
		String result = my.get();
		System.out.println(result);
		
		//Person Ÿ���� �����ϴ�
		//MyGen Ÿ���� ��ü ����
		MyGen<Person> myobj = new MyGen<Person>();
		myobj.add(new Person());
		Person p = myobj.get();
		System.out.println(p.age);
		
		//Quiz (Generic x)
		ArrayList list = new ArrayList();
		list.add(500);
		list.add(new Person());
		list.add("ȫ�浿");
		
		//������ for���� ���� ��� >> 500, 100, "ȫ�浿"
		for(Object obj : list) {
			if(obj instanceof Person) {
				Person person = (Person)obj;
				System.out.println(person.age);
			}else {
				System.out.println(obj);
			}
		}
		
		//�� ó�� ������� ���� -> generic ��� ���
		ArrayList<Person> alist = new ArrayList<>();
		alist.add(new Person());
		System.out.println(alist.get(0).age);
		
	}
}
