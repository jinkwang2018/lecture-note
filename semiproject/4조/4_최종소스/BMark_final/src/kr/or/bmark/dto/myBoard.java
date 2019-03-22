package kr.or.bmark.dto;

/* 
* @FileName : myBoard.java 
* @Project : BMark
* @Date : 2018.04.10. 
* @Author : 김래영 
*/
public class myBoard {
	private int mnbid; //not null
	private int ccode;
	private String cname; //not null
	private String name; //not null
	private String addr; //not null
	private String icon;
	private String content;
	private int hit;
	private int good;
	private int bad;
	private String type;
	private String writer;
	private String writeday;
	private String userid; //not null

	public myBoard() {
	}
	
	public myBoard(String cname) {
		this.cname = cname;
	}
	
	public myBoard(int mnbid, int ccode, String cname, String name, String addr, String icon, String content, int hit,
			int good, int bad, String type, String writer, String writeday) {
		super();
		this.mnbid = mnbid;
		this.ccode = ccode;
		this.cname = cname;
		this.name = name;
		this.addr = addr;
		this.icon = icon;
		this.content = content;
		this.good = good;
		this.bad = bad;
		this.type = type;
		this.writer = writer;
		this.writeday = writeday;
	}
	
	public myBoard(int mnbid, String cname, String name, String addr, String icon, String content) {
		super();
		this.mnbid = mnbid;
		this.cname = cname;
		this.name = name;
		this.addr = addr;
		this.icon = icon;
		this.content = content;
	}
	
	public myBoard(String cname, String name, String addr, String icon, String content) {
		this.cname = cname;
		this.name = name;
		this.addr = addr;
		this.icon = icon;
		this.content = content;		
	}

	public int getCcode() {
		return ccode;
	}

	public void setCcode(int ccode) {
		this.ccode = ccode;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getMnbid() {
		return mnbid;
	}

	public void setMnbid(int mnbid) {
		this.mnbid = mnbid;
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
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	@Override
	public String toString() {
		return "myBoard [mnbid=" + mnbid + ", ccode=" + ccode + ", cname=" + cname + ", name=" + name + ", addr=" + addr
				+ ", icon=" + icon + ", content=" + content + ", hit=" + hit + ", good=" + good + ", bad=" + bad
				+ ", type=" + type + ", writer=" + writer + ", writeday=" + writeday + ", userid=" + userid + "]";
	}

	
}
