package kr.or.bit.dto;

import java.sql.Date;

public class ReplyDto {
	private int no;       //자동증가 sequence 객체사용 :reply_no
	private String id;
	private String reply_content;
	private String reply_date;
	private int idx; //참조제약 (FK) > shareboard 테이블(idx)
	
	public ReplyDto(){
	}
	
	public ReplyDto(int no, String id, String reply_content, String reply_date, int idx) {
		super();
		this.no = no;
		this.id = id;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.idx = idx;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
