package kr.or.bmark.dto;

public class evalData {
	private int mnbid;
	private String userid;
	private String eval;
	private String evalday;
	
	public evalData() {}
	
	public evalData(String eval) {
		this.eval = eval;
	}
	
	public evalData(int mnbid, String userid, String eval) {
		this.mnbid = mnbid;
		this.userid = userid;
		this.eval = eval;
	}
	
	public evalData(int mnbid, String userid, String eval, String evalday) {
		this.mnbid = mnbid;
		this.userid = userid;
		this.eval = eval;
		this.evalday = evalday;
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

	public evalData(String eval, String evalday) {
		this.eval = eval;
		this.evalday = evalday;
	}

	public String getEval() {
		return eval;
	}

	public void setEval(String eval) {
		this.eval = eval;
	}

	public String getEvalday() {
		return evalday;
	}

	public void setEvalday(String evalday) {
		this.evalday = evalday;
	}

	@Override
	public String toString() {
		return "evalData [mnbid=" + mnbid + ", userid=" + userid + ", eval=" + eval + ", evalday=" + evalday + "]";
	}
}
