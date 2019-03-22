package kr.or.kosta;

public class Member {
	private String username="kosta";
	private String password="1004";
	private String address="경기도 성남시";
	private String admin="1";
	
	public Member() {}

	public Member(String username, String password, String address, String admin) {
		
		this.username = username;
		this.password = password;
		this.address = address;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Member [username=" + username + ", password=" + password + ", address=" + address + ", admin=" + admin
				+ "]";
	}
	
}
