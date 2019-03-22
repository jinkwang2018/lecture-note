package kr.or.bmark.dto;
/**
 * 
 * @author : joon
 * @date   : 2018. 4. 12.
 * @desc   : 그룹(팀)의 DTO 생성 
 *
 */
public class team {
	private int gid;
	private String name;
	private String pw;
	private String content;
	private String register;
	private String regday;
	private int membercount;
	
	public team() {	}
	
	public team(int gid, String name, String register, String regday, int membercount) {
		this.gid = gid;
		this.name = name;
		this.register = register;
		this.regday = regday;
		this.membercount = membercount;
	}
	
	public team(int gid, String name, String pw, String content, String register, String regday) {
		this.gid = gid;
		this.name = name;
		this.pw = pw;
		this.content = content;
		this.register = register;
		this.regday = regday;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegday() {
		return regday;
	}
	public void setRegday(String regday) {
		this.regday = regday;
	}
	public int getMembercount() {
		return membercount;
	}
	public void setMembercount(int membercount) {
		this.membercount = membercount;
	}

	@Override
	public String toString() {
		return "team [gid=" + gid + ", name=" + name + ", pw=" + pw + ", content=" + content + ", register=" + register
				+ ", regday=" + regday + "]";
	}
}
