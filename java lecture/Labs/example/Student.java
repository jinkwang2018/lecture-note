
public class Student extends Person{
	static int due = Policy.dueto*5;;
	public Student(String name, int age, String address) {
		super();
		super.status = "student";
		super.name = name;
		super.age = age;
		super.address = address;
	}
}
