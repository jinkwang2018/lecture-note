import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object_KeyPoint {
	public static void main(String[] args) {
		//�����迭(Array)
		//��� 1���� ���弼��
		Emp e = new Emp(100, "������", "����");
		System.out.println(e.toString());
		
		//�����迭(Array) ���
		//��� 2�� ���弼��
		Emp[] emplist = {new Emp(10, "�达", "IT"), new Emp(20, "�ھ�", "SALES")};
		
		for(Emp em : emplist) {
			System.out.println(em.toString());
		}
		/////////////////// ���� �迭 (����) ���� ///////////////////////
		
		//ArrayList�� ����ؼ� ��� 2���� ���弼��
		ArrayList elist = new ArrayList();
		
		elist.add(new Emp(1,"��","IT"));
		elist.add(new Emp(2,"��","����"));
		
		System.out.println(elist.toString());
		
		//for�� ����ؼ� ��� ������ ���� ���
		for(int i = 0; i < elist.size(); i++) {
			//System.out.println(elist.get(i).toString());
			//System.out.println(((Emp)elist.get(i)).toString());
			Emp m = (Emp)elist.get(i);
			System.out.println(m.getEmpno() + " / " + m.getEname() + " / " + m.getJob());
		}
		
		//������ for��
		for(Object obj : elist) {
			Emp m = (Emp)obj;
			System.out.println(m.getEmpno());
		}
		
		//Object �����ؼ� ���� �Ⱦ��...���� ����� ���ʸ�(generic)
		//generic (100%)
		ArrayList<Emp> elist2 = new ArrayList<Emp>();
		elist2.add(new Emp(1, "A", "IT"));
		elist2.add(new Emp(2, "B", "SALES"));
		
		for(Emp em : elist2) {
			System.out.println(em.getEmpno() + "/" + em.getEname() + "/" + em.getJob());
		}
	}
}
