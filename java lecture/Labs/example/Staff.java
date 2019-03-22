
public class Staff extends Person{
	static int due = Policy.dueto*7;
	public Staff(String name, int age, String address) {
		super();
		super.status = "staff";
		super.name = name;
		super.age = age;
		super.address = address;
	}

}
