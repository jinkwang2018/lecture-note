package kr.or.bmark.dto;

public class category {
	private int ccode;
	private String cname;
	
	public category() {
		
	}
	
	public category(int ccode, String cname) {
		this.ccode = ccode;
		this.cname = cname;
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
	@Override
	public String toString() {
		return "category [ccode=" + ccode + ", cname=" + cname + "]";
	}
}
