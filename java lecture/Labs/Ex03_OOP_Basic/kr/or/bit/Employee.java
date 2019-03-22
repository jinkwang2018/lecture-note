package kr.or.bit;
//����� ���, �̸�, ����(job)�� ������ �ִ� => ��Ģ(ĸ��ȭ) => read, write ���� setter, getter
//��� ������ default�� ���=9999, �̸�=�ƹ���, ����=����
//Employee e = new Employee()
//������ ���, �̸�, ������ ���ؼ� ��� ������ �����ϴ�
//����� ������ ���, �̸�, ���� ���� �� ���� ������ �� �ִ�
//��������� ���, �̸�, ������ �ѹ��� Ȯ���� �� �ְ� (������ ������ Ȯ�� �Ұ� �ϴ�)
public class Employee {
	private int empno;
	private String ename;
	private String job;
	
	//default constructor
	public Employee() {
		empno = 9999;
		ename = "�ƹ���";
		job = "����";
	}
	//overloading constructor
	public Employee(int no, String name, String jobdata) {
		empno = no;
		ename = name;
		job = jobdata;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	//�Ϲ� �Լ�
	public void employeeInfo() {
		System.out.printf("���: [%d], �̸�: [%s], ����: [%s]\n", empno, ename, job);
	}
	
}
