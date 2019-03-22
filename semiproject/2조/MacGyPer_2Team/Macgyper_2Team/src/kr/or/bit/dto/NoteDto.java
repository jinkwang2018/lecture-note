package kr.or.bit.dto;

import java.sql.Date;

public class NoteDto {
	int note_num;
	String note_title;
	String id;
	String note_content;
	String note_date;
	int book_no;
	public int getNote_num() {
		return note_num;
	}
	public void setNote_num(int note_num) {
		this.note_num = note_num;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	public String getNote_date() {
		return note_date;
	}
	public void setNote_date(String note_date) {
		this.note_date = note_date;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
}
