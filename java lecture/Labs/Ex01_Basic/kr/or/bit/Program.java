package kr.or.bit;

public class Program {
	public static void main(String[] args) {
		Emp e = new Emp();
		e.empno = 1000;
		e.ename = "ȫ�浿";
		e.setJob("����");
		
		String info = e.getEmpInfo(); // �Լ� ȣ��
		System.out.println(info);
		
		Emp e2 = new Emp();
		e2.empno = 1000;
		e2.ename = "������";
		e2.setJob("IT");
		
		info = e2.getEmpInfo();
		System.out.println(info);
	}
}
