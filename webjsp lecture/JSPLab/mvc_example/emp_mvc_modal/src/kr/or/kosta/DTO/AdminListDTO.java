package kr.or.kosta.DTO;

public class AdminListDTO {
	
	private String userid;
	private String pwd;
	
	public AdminListDTO(){}

	public AdminListDTO(String userid, String pwd) {
		super();
		this.userid = userid;
		this.pwd = pwd;
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

	@Override
	public String toString() {
		return "AdminListDTO [userid=" + userid + ", pwd=" + pwd + "]";
	};
	
	

}
