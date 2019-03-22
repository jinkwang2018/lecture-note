import java.util.Vector;

public class Book {
	boolean borrow; // 대여여부
	String name; // 도서명
	int num; // 도서 수량
	String auth; // 저자
	String publisher; // 출판사
	String personname; // 대여자	
	public Book(String name2, String auth2) {
		borrow = false; // 대여자 없음
		name = name2;
		auth = auth2;
	}
	public Book() {} // 생성자
	public Vector<Object> getall() { // 제네릭 설정
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
