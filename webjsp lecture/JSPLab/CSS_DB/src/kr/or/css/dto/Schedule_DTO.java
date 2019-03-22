package kr.or.css.dto;

import java.sql.Date;

public class Schedule_DTO {
	private String id;
	private Date date;
	
	public Schedule_DTO() {
		
	}
	public Schedule_DTO(String id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
