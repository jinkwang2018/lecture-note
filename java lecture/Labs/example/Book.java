import java.util.Vector;

public class Book {
	boolean borrow; // �뿩����
	String name; // ������
	int num; // ���� ����
	String auth; // ����
	String publisher; // ���ǻ�
	String personname; // �뿩��	
	public Book(String name2, String auth2) {
		borrow = false; // �뿩�� ����
		name = name2;
		auth = auth2;
	}
	public Book() {} // ������
	public Vector<Object> getall() { // ���׸� ����
		Vector<Object> myvector = new Vector<Object>();
		myvector.add(name);
		myvector.add(auth);
		myvector.add(personname);
		return myvector;
	}
	public boolean isBorrow() {
		return borrow;
	}
	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
}
