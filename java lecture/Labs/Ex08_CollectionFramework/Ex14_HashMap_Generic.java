import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Today Point
//HashMap generic ���
//HashMap<K, V>
//HashMap<String, String>
//HashMap<String, Integer>
//HashMap<String, Emp> >> value������ ��ü�� (Ŭ����) ���

//IO, Network, Thread >> ArrayList<Emp>, HashMap<String, Emp> Ȱ��
class Student {
	int kor = 100;
	int math = 80;
	int eng = 20;
	String name;
	Student(String name) {
		this.name = name;
	}
}

public class Ex14_HashMap_Generic {
	public static void main(String[] args) {
		HashMap<String, Student> students = new HashMap<>();
		students.put("hong", new Student("ȫ�浿"));
		students.put("kim", new Student("������"));
		
		Student std = students.get("hong");
		System.out.println(std.name);
		System.out.println(std.eng);
		
		//������������
		//Map �ȿ� �ִ� key, value ��� ����ϰ� �;��
		Set set = students.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//�������� CASE: value�� ��ü(object) �� ��
		//Map.Entry m ���� ������ (Ÿ��)
		//m.geyKey(), m.getValue()
		for(Map.Entry m : students.entrySet()) {
			System.out.println(m.getKey() + "/" + ((Student)m.getValue()).name);
			// casting ���ؼ� ����������
		}
		
		/*
		�Ϲ����� ���
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		
		Set set2 = map.entrySet();
		Iterator it = set2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
	}
}
