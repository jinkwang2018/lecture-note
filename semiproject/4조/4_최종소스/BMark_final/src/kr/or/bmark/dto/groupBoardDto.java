package kr.or.bmark.dto;

public class groupBoardDto {
	private int mnbid; // 키값 (자동증가 : sequence : jspboard_idx)
	private int ccode; // not null
	private String name; // not null
	private String addr; // not null
	private String content;
	private String icon; 
	private int hit;
	private int good;
	private int bad;
	private String type;
	private int gid;//not null

	// 생성자
	public groupBoardDto() {
	}
	
	public groupBoardDto(int mnbid, int ccode, String name, String addr, String content, String icon, int hit, int good,
			int bad, String type) {
		super();
		this.mnbid = mnbid;
		this.ccode = ccode;
		this.name = name;
		this.addr = addr;
		this.content = content;
		this.icon = icon;
		this.hit = hit;
		this.good = good;
		this.bad = bad;
		this.type = type;
	}
	//GETTER SETTER
	public int getMnbid() {
		return mnbid;
	}

	public void setMnbid(int mnbid) {
		this.mnbid = mnbid;
	}


	public int getCcode() {
		return ccode;
	}

	public void setCcode(int ccode) {
		this.ccode = ccode;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "groupBoardDto [mnbid=" + mnbid + ", ccode=" + ccode + ", name=" + name + ", addr=" + addr + ", content="
				+ content + ", icon=" + icon + ", hit=" + hit + ", good=" + good + ", bad=" + bad + ", type=" + type
				+ ", gid=" + gid + "]";
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}
	
	
}
