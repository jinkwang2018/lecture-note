package kr.or.bit;

public class Emp {
	private int empno;
	private String ename;
	
	//�����ڸ� ����� �ڵ� (overloading constructor)
	//������ �Լ� (member filed �ʱ�ȭ: ��ü������ ���ÿ� ó��)
	//�Լ��� �̸��� Ŭ���� �̸��� ����
	public Emp() {
		//default constructor �⺻ ������
	}
	public Emp(int empno, String ename) {
		//overloading constructor
		this.empno = empno;
		this.ename = ename;
	}
	
	public void insertEmp(int data, String data2) {
		empno = data;
		ename = data2;
	}
	
	public void setEmpno(int data) {
		empno = data;
	}
	public int getEmpno() {
		return empno;
	}
	
	//�ڵ� ����
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public void empInfo() {
		System.out.println(empno + " / " + ename);
	}
	
}
