package kr.or.bmark.dto;

/**
 * 
 * @author : joon
 * @date   : 2018. 4. 9.
 * @desc   : 회원정보의 DTO
 *           data transfer object 생성
 *           
 */

public class memberDto {

	private String userid;      //회원아이디
	private int gid;        //그룹번호
	private String pw;      //비밀번호
	private String name; 	 //이름
	private String email;    //이메일
	private String phone; 		 //전화번호
	private String regday; //가입일
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegday() {
		return regday;
	}
	public void setRegday(String regday) {
		this.regday = regday;
	}
	 
}
