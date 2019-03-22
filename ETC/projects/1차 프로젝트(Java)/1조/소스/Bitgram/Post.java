import java.io.Serializable;
import java.util.*;

/*
날      짜: 2018-02-23
작성자명: 김정권
기      능: 게시글 기능
*/

public class Post implements Serializable{

	private List<String> content; // 게시글 리스트
	private String date;          // 게시글 날짜
	private String writer;        // 게시글 작성자
	private int contentNum;       // 게시글 순서

	
	Post(){
		this.content = null;
		this.date = "";
		this.writer = "";
		this.contentNum =0;
	}
	
	
	public void printContent() {

		for (String s : content) {
			System.out.println(s);
		}

	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	public void printPost() { //게시글 출력
		System.out.printf("--[No. %d]--------------------------\n", this.contentNum);
		System.out.println("작성자명 : " + this.writer);
		System.out.println("작성일    : " + this.date);
		System.out.println();
		
		for(String s : content) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("-----------------------------------");
		
	}
	
	public void printNotice() { //관리자 권한 공지사항 출력
		System.out.println("---------------공지사항---------------");
		System.out.println("작성일    : " + this.date);
		System.out.println();
		
		for(String s : content) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("-----------------------------------");
	}
}
