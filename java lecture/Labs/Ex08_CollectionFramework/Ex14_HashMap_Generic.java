import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Today Point
//HashMap generic 사용
//HashMap<K, V>
//HashMap<String, String>
//HashMap<String, Integer>
//HashMap<String, Emp> >> value값으로 객체를 (클래스) 사용

//IO, Network, Thread >> ArrayList<Emp>, HashMap<String, Emp> 활용
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
		students.put("hong", new Student("홍길동"));
		students.put("kim", new Student("김유신"));
		
		Student std = students.get("hong");
		System.out.println(std.name);
		System.out.println(std.eng);
		
		//예외적인으로
		//Map 안에 있는 key, value 모두 출력하고 싶어요
		Set set = students.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//예외적인 CASE: value가 객체(object) 일 때
		//Map.Entry m 리턴 받으면 (타입)
		//m.geyKey(), m.getValue()
		for(Map.Entry m : students.entrySet()) {
			System.out.println(m.getKey() + "/" + ((Student)m.getValue()).name);
			// casting 통해서 테이터접근
		}
		
		/*
		일반적인 사례
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
