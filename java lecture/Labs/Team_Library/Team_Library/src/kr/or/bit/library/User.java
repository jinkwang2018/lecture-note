package kr.or.bit.library;

import java.util.List;

public class User implements Register {
	private String memberId;
	private String memberPw;
	private String memberName;
	private List rentalList;
	
	public void rentBook() {  //도서 대여
		
	}
	public void readBook() {  //대여 도서 읽기
		
	}
	public String getMemberId() {
		return memberId;
	}
	
}
