public class Faculty extends Person{ // Faculty 클래스가 Person 클래스를 상속
	static int due = Policy.dueto*10; // 스태틱 변수 지정
	public Faculty(String name, int age, String address) {
		super();
		super.status = "Faculty";
		super.name = name;
		super.age = age;
		super.address = address;
	}
}
