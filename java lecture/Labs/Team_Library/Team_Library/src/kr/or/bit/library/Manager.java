package kr.or.bit.library;

public class Manager implements Register{
	private String managerId;
	private String managerPw;
	private Book book;
	
	public Manager() {
		this.managerId = "manager";
		this.managerPw = "1234";
	}
	
	public void addBook() {  //책 추가
		
	}
	public void delBook() {  //책 삭제
		
	}
}
