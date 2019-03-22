package kr.or.bit.dto;

public class JoinDto {
	private String id;
	private String name;
	private String pwd;
	private String pwdcheck;
	private int pno;
	private String email;
	
	public String getPwdcheck() {
		return pwdcheck;
	}
	public void setPwdcheck(String pwdcheck) {
		this.pwdcheck = pwdcheck;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
