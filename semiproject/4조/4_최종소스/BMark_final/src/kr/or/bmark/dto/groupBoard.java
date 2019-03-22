package kr.or.bmark.dto;

public class groupBoard {
	private int mnbid;
	private int gid;
	
	public groupBoard(int mnbid, int gid) {
		super();
		this.mnbid = mnbid;
		this.gid = gid;
	}
	public int getMnbid() {
		return mnbid;
	}
	public void setMnbid(int mnbid) {
		this.mnbid = mnbid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "groupBoard [mnbid=" + mnbid + ", gid=" + gid + "]";
	}
}
