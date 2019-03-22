/**
 프로젝트 : 비트코인 캠프 시스템
 파일이름 : Member.java
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
*/

package kr.or.bit.Three;

public class Member {
	private String id;
	private String password;
	private String name;
	private int userLevel;
	private String phoneNumber;
	
	public Member() {}
	public Member(String id, String password, String name, int userLevel, String phoneNumber) {
		this.id = id;
		this.password = password;
		this.userLevel = userLevel;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}
	
	// Getters and Setters
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getUserLevel() {return userLevel;}
	public void setUserLevel(int userLevel) {this.userLevel = userLevel;}
	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

	@Override
	public String toString() {
		return "[id=" + id + ", password=" + password + ", name=" + name + ", userLevel=" + userLevel
				+ ", phoneNumber=" + phoneNumber + "]";
	}
}
