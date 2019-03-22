package kr.or.bmark.dto;

public class myBoardData {
	private int mnbid;
	private String userid;
	
	
	public myBoardData(int mnbid, String userid) {
		this.mnbid = mnbid;
		this.userid = userid;
	}
	
	public int getMnbid() {
		return mnbid;
	}
	public void setMnbid(int mnbid) {
		this.mnbid = mnbid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "myBoardData [mnbid=" + mnbid + ", userid=" + userid + "]";
	}
}
