import kr.or.bit.Emp;

//�迭���� ���� �߿��� �ڵ�: ��ü�迭 -> 2�� �۾�����. 1.�游��� / 2.�޸𸮿ø���
//[�ǹ����� ���� ���� ���]
public class Ex04_Array_Object {
	public static void main(String[] args) {
		//��� 3���� ���弼��
		/*
		�迭�� ����� �ʾҾ��
		Emp e = new Emp();
		Emp e2 = new Emp();
		Emp e3 = new Emp();
		*/
		
		Emp[] emplist = new Emp[3];
		
		emplist[0] = new Emp();
		emplist[0].setEmpno(1000);
		emplist[0].setEname("ȫ�浿");
		
		emplist[1] = new Emp(); //�ּҰ� �Ҵ�: emplist[1] �޸� �ּ� �Ҵ�
		emplist[1].insertEmp(2000, "������"); // �ʱ�ȭ
		
		emplist[2] = new Emp();
		emplist[2].insertEmp(3000, "������");
		
		//emplist ��� ��ȣ�� ����̸��� ����ϼ��� (for)
		for(int i = 0; i < emplist.length; i++) {
			// System.out.println(emplist[i].getEmpno() + "/" + emplist[i].getEname()); // ���� § �ڵ�
			emplist[i].empInfo();
		}
		
		//int[] arr = new int[]{10, 20, 30} ������ ��� 3�� ���� ���� ����ϼ���
		Emp[] emplist2 = new Emp[] {new Emp(1,"�̾�"), new Emp(2,"�ھ�"), new Emp(3,"�达")};
		for(int i = 0; i < emplist2.length; i++) {
			emplist2[i].empInfo();
		}
		
		//int[] arr = {10, 20, 30} ������ ��� 3�� ���� ���� ����ϼ���
		Emp[] emplist3 = {new Emp(111,"A"), new Emp(222,"B")};
		for(int i = 0; i < emplist3.length; i++) {
			emplist3[i].empInfo();
		}
	}
}
