package kr.or.kosta.dto;

public class MvcRegister {
	private int id;
	private String pwd;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MvcRegister [id=" + id + ", pwd=" + pwd + ", email=" + email + "]";
	}
	
	
}
