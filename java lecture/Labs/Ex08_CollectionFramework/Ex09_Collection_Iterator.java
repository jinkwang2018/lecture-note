import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//Collection Framework
//������ �ڿ��� ���� ���������� �����ؼ� ���� �����ϴ� ǥ�� ����
//Iterator �������̽�
//hasNext(), Next() => �ڿ��� ArrayList �����ϰ� �ִ�
//Iterator: ������ ������ read�ϴ� ǥ��
//ListIterator: ����� ������ read�ϴ� ǥ�� (���������� ���� ��, ���������� ����)

public class Ex09_Collection_Iterator {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//ǥ��ȭ�� �������̽� ����ؼ� ����Ѵٸ�
		//Iterator
		//Collection { Iterator iterator(); } //�߻� �޼���
		//List extends Collection
		//ArrayList implements List
		//ArrayList�� iterator(){} �߻� �޼��� ���� ����
		//�θ� Ÿ���� Iterator �� ���� Override�� ArrayList�� iterator �Լ� ȣ��
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println("[" + it.next() + "]");
		}
		
		//generic
		ArrayList<Integer> intlist = new ArrayList<>();
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.iterator();
		while(list2.hasNext()) {
			System.out.println("[" + list2.next() + "");
		}
		
		//������
		for(int i = intlist.size()-1; i >= 0; i--) {
			System.out.println(intlist.get(i));
		}
		
		//ListIterator (������, ������) ��ȸ ����
		ListIterator<Integer> li2 = intlist.listIterator();
		while(li2.hasNext()) {
			System.out.println(li2.next());
		}
		
		//������
		while(li2.hasPrevious()) {
			System.out.println("[" + li2.previous() + "]");
		}
	}
}
