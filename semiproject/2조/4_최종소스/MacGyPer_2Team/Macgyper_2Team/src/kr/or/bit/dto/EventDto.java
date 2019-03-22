package kr.or.bit.dto;

public class EventDto {
	private String user_id;
	private int event_id;
	private String event_title;
	private String event_content;
	private String event_startdate;
	private String event_enddate;
	private String event_color;
	
	public EventDto(){	
	}
	
	public EventDto(String user_id, int event_id, String event_title, String event_content, String event_startdate, String event_enddate, String event_color){
		this.user_id = user_id;
		this.event_id = event_id;
		this.event_title = event_title;
		this.event_content = event_content;
		this.event_startdate = event_startdate;
		this.event_enddate = event_enddate;
		this.event_color = event_color;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_startdate() {
		return event_startdate;
	}
	public void setEvent_startdate(String event_startdate) {
		this.event_startdate = event_startdate;
	}
	public String getEvent_enddate() {
		return event_enddate;
	}
	public void setEvent_enddate(String event_enddate) {
		this.event_enddate = event_enddate;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	public String getEvent_color() {
		return event_color;
	}

	public void setEvent_color(String event_color) {
		this.event_color = event_color;
	}

}
