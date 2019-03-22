package kr.or.bmark.dto;
/* 
* @FileName : chart.java 
* @Project : BMark
* @Date : 2018.04.11. 
* @Author : 김래영 
*/ 
public class chart {
	private String cname;
	private String name; //not null
	private int hit;
	private String writeday;
	
	public chart() {}
	
	public chart(String cname) {
		this.cname = cname;
	}
	
	public chart(String cname, String name, int hit, String writeday) {
		this.cname = cname;
		this.name = name;
		this.hit = hit;
		this.writeday = writeday;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	
	
}
