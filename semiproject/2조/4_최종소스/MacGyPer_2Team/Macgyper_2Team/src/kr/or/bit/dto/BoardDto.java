package kr.or.bit.dto;

import java.sql.Date;

public class BoardDto {
    private int idx; // 키값 (자동증가 : sequence : jspboard_idx)
    private String id; // not null
    private String board_title; // not null
    private String board_content; // not null
    private Date board_date; // default sysdate
    private int board_count; // default 0
    private String board_filename;
    // 계층형
    private int refer; // 참조
    private int depth; // 들여쓰기
    private int step; // 글의 순서
    
    // 생성자
    public BoardDto() {
    }
    
    // overloading
    public BoardDto(int idx, String writer, String subject, String content) {
        this.idx = idx;
        this.id = writer;
        this.board_title = subject;
        this.board_content = content;
    }
    
    public BoardDto(int idx, String id, String board_title, String board_content, Date board_date, int board_count,
			String board_filename, int refer, int depth, int step) {
		super();
		this.idx = idx;
		this.id = id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_count = board_count;
		this.board_filename = board_filename;
		this.refer = refer;
		this.depth = depth;
		this.step = step;
	}

	public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getBoard_title() {
        return board_title;
    }
    
    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }
    
    public String getBoard_content() {
        return board_content;
    }
    
    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }
    
    public Date getBoard_date() {
        return board_date;
    }
    
    public void setBoard_date(Date board_date) {
        this.board_date = board_date;
    }
    
    public int getBoard_count() {
        return board_count;
    }
    
    public void setBoard_count(int board_count) {
        this.board_count = board_count;
    }
    
    public String getBoard_filename() {
        return board_filename;
    }
    
    public void setBoard_filename(String board_filename) {
        this.board_filename = board_filename;
    }
    
    public int getIdx() {
        return idx;
    }
    
    public void setIdx(int idx) {
        this.idx = idx;
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
    
}