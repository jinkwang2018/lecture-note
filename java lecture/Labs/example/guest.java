
public class guest extends Person{
	static int due= Policy.dueto*2;
	String visit;
	public guest(String name, int age, String address, String visit) {
		super();
		super.status = "guest";
		super.name = name;
		super.age = age;
		super.address = address;
		this.visit = visit;
	}
}
