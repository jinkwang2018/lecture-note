package kr.or.kosta.dto;

import java.sql.Date;

public class board {
	private int idx;          //not null
	private String writer;    //not null
	private String pwd;       //not null
	private String subject;   //not null
	private String content;   //not null
	
	private Date writedate;   //default sysdate
	private int readnum;      //default 0
	private String filename;
	private int filesize;
	private String homepage;
	private String email;
	
	//계층형(답글)
	private int refer;
	private int depth; //들여쓰기
	private int step;  //글의 순서
	
	public board() {}

	public board(int idx, String writer, String pwd, String subject, String content, Date writedate, int readnum, 
			String filename, int filesize, String homepage, String email, int refer, int depth, int step) {
		
		this.idx = idx;
		this.writer = writer;
		this.pwd = pwd;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.readnum = readnum;
		this.filename = filename;
		this.filesize = filesize;
		this.homepage = homepage;
		this.email = email;
		this.refer = refer;
		this.depth = depth;
		this.step = step;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		//필요에 따라서 구현
		return "board [idx=" + idx + ", pwd=" + pwd + ", subject=" + subject + ", content=" + content + "]";
	}
	
	
	
	 
}
