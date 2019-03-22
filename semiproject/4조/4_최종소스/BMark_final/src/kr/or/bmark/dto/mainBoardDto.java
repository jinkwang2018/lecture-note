package kr.or.bmark.dto;
/* 
* @FileName : mainBoardDto.java 
* @Project : BMark
* @Date : 2018.04.10. 
* @Author : 이 진 우 
*/
public class mainBoardDto {
	private int mnbid; // 키값 (자동증가 : sequence : jspboard_idx)
	private int ccode; // not null
	private String cname;

	private String name; // not null
	private String addr; // not null
	private String icon; 
	private String content; //not null
	private String type;//not null
	private int hit;
	
	private int good;
	private int bad;
	
	public mainBoardDto() {}

	public mainBoardDto(int mnbid, int ccode, String cname, String name, String addr, String icon, String content,
			String type, int hit, int good, int bad) {
		super();
		this.mnbid = mnbid;
		this.ccode = ccode;
		this.cname = cname;
		this.name = name;
		this.addr = addr;
		this.icon = icon;
		this.content = content;
		this.type = type;
		this.hit = hit;
		this.good = good;
		this.bad = bad;
	}

	@Override
	public String toString() {
		return "mainBoardDto [mnbid=" + mnbid + ", ccode=" + ccode + ", cname=" + cname + ", name=" + name + ", addr="
				+ addr + ", icon=" + icon + ", content=" + content + ", type=" + type + ", hit=" + hit + ", good="
				+ good + ", bad=" + bad + "]";
	}


	public int getSnum() {
		return mnbid;
	}

	public void setSnum(int snum) {
		this.mnbid = snum;
	}

	public int getCcode() {
		return ccode;
	}

	public void setCcode(int ccode) {
		this.ccode = ccode;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHit() {
		return hit;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}
	
	public void setBad(int bad) {
		this.bad = bad;
	}
	
}
