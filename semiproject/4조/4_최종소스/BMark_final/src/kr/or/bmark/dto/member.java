package kr.or.bmark.dto;

/**
 * 
 * @author : joon (진우 수정)
 * @date   : 2018. 4. 9.
 * @desc   : 회원정보의 DTO
 *           data transfer object 생성
 *           
 */

public class member {

	private String userid;     //회원아이디 Not Null
	private String pwd;      //비밀번호 Not Null
	private String name; 	 //이름 Not Null
	private String email;    //이메일 Not Null
	private String phone;	 //전화번호
	private String regidate; //가입일
	private int gid;        //그룹번호
	private int zonecode;	//우편번호
	private String addr1;	//주소1
	private String addr2;	//주소2
	
	//생성자
	public member() {

	}
	
	public member(String userid, String pwd, String name, String email, String phone) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public member(String userid, String pwd, String name, String email, String phone, String regidate) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.regidate = regidate;
	}
	public member(String userid, String pwd, String name, String email, String phone, int zonecode, String addr1, String addr2, String regidate) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.regidate = regidate;
		this.zonecode = zonecode;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public int getZonecode() {
		return zonecode;
	}

	public void setZonecode(int zonecode) {
		this.zonecode = zonecode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	 
}
