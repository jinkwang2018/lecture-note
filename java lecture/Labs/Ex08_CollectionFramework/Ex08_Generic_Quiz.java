import java.util.ArrayList;
import java.util.Iterator;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz {
	public static void main(String[] args) {
		//1. Emp Ŭ������ ����ؼ� ��� 3���� �����ϼ���
		//�� ArrayList<T> ���ʸ��� ����ϼ���
		ArrayList<Emp> earr = new ArrayList<>();
		
		earr.add(new Emp(1, "��", "����"));
		earr.add(new Emp(2, "��", "IT"));
		earr.add(new Emp(3, "��", "����"));
		
		
		//2. ����� ���� (���, �̸�, ����)�� ������ for���� ����ؼ� ����ϼ���
		//�� toString() ��� ����
		for(Emp e : earr) {
			System.out.println(e.getEmpno() + "/" + e.getEname() + "/" + e.getJob());
		}
		
		System.out.println();
		
		//3. ����� ���� (���, �̸�, ����)�� �Ϲ� for���� ����ؼ� ����ϼ���
		//�� toString() ��� ����
		for(int i = 0; i < earr.size(); i++) {
			System.out.println(earr.get(i).getEmpno() + "/" + earr.get(i).getEname() + "/" + earr.get(i).getJob());
		}
		
		System.out.println();
		
		//4. CopyEmp ��� Ŭ������ ���弼��(Emp�� ������)
		//job member field ��ſ�>>
		//private int sal; �� �ٲپ� ���弼��(getter, setter ����)
		//kr.or.bit.CopyEmp �� �ϼ���
		//ArrayList<> ���ʸ� ����ؼ� ��� 3�� ���弼��
		//�Ʒ� ������ ���
		//100, "��", 1000
		//200, "��", 2000
		//300, "��", 3000
		ArrayList<CopyEmp> carr = new ArrayList<>();
		carr.add(new CopyEmp(100, "��", 1000));
		carr.add(new CopyEmp(200, "��", 2000));
		carr.add(new CopyEmp(300, "��", 3000));
		
		//5. 200�� ����� �޿��� 5000���� �����ؼ� ����ϼ��� (�Ϲ� for�� �ȿ���...)
		for(int i = 0; i < carr.size(); i++) {
			if(carr.get(i).getEmpno() == 200) {
				carr.get(i).setSal(5000);
				System.out.println(carr.get(i).toString());
			}
		}
		
		System.out.println();
		
		//6. 300�� ����� �̸��� "�ñ���"�� �����ؼ� ����ϼ��� (�Ϲ� for�� �ȿ���...)
		for(CopyEmp c : carr) {
			if(c.getEmpno() == 300) {
				c.setEname("�ñ���");
				System.out.println(c.toString());
			}
		}
		
		System.out.println();
		
		//7.��������� Iterator �������̽��� ����ؼ� ����ϼ���
		/*
		ArrayList<Integer> intlist = new ArrayList<>();
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.iterator();
		while(list2.hasNext()) {
			System.out.println("[" + list2.next() + "");
		}
		*/
		Iterator<CopyEmp> it = carr.iterator();
		while(it.hasNext()) {
			//next() �̵��ؼ� ���� return
			//System.out.println(it.next().getEmpno());
			//System.out.println(it.next().getEname());
			//System.out.println(it.next().getSal());
			CopyEmp e = it.next();
			System.out.println(e.getEmpno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
		}
		
		
	}
}
