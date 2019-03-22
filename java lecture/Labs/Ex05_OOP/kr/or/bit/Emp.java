package kr.or.bit;

//[DTO]: Data Transfer Object ([VO]: Value Object, DOMAIN) Ŭ����
public class Emp { // class Emp extends Object (default)
	private int empno;
	private String ename;
	
	//Constructor
	public Emp(int empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	//getter, setter �Լ�
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	//Object�� ������ �ִ� toString() �Լ��� �ּҰ��� return�ϴ� �Լ�
	//������(override)
	//�ַ� member field �� ��¿����� ���
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}
	
	
	
	
}
