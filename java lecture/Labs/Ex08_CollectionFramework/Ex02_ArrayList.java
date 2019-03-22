import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

//Today Keypoint (ArrayList)
//ArrayList ���ؼ� ��ü �ٷ��

public class Ex02_ArrayList {
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		//Tip: capacity() �Լ��� Vector���� ����������, ArrayList���� �������� �ʴ´�.
		//��� ArrayList���� capacityó�� �ʱⰪ�� ������ �� �ִ�.
		//ArrayList arraylist2 = new ArrayList(10);
		
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		System.out.println(arraylist.toString());
		for(int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		System.out.println("����[0]: " + arraylist.get(0));
		//POINT (Ư�� ��ġ��..)
		arraylist.add(0, 1111); //��������� ������ �߰� ����(�����ƿ�)
		//�������� ������ �߰� ����(���ƿ�) 
		System.out.println("����[0]: " + arraylist.get(0));
		System.out.println(arraylist.toString());
		
		//������ ���� (add): �߰��� >> ������ �̵�
		//�߰�(���������) ������ �߰�, �����ϴ� �۾��� ���ɻ� ���� �ʴ�
		//�������� ������ �߰�, ���� ���ƿ�
		
		//ArrayList �Լ� Ȱ��
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(333));
		
		System.out.println(arraylist.isEmpty()); //�� ��� �ִ� (true, false): true�� ��� �ִ� ��
		arraylist.clear();
		System.out.println(arraylist.isEmpty()); //clear >> size = 0 >> true
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.toString());
		
		//0��° �濡 �ִ� ������ ����
		Object value = arraylist.remove(0); //�ʿ��ϴٸ� �������� ���� ���� �� �ִ�
		System.out.println(value);
		System.out.println(arraylist.toString());
		
		ArrayList list = new ArrayList();

		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		
		System.out.println("ArrayList:��������: " + list.toString());
		list.remove("��"); //���� �ָ� �տ��� ã�Ƽ� ����
		System.out.println("ArrayList ����: " + list.toString());
		
		//�� �ڵ忡 �����ϼž� �մϴ�!!!!!!
		//List �������̽��� �θ�  Ÿ������
		List li = new ArrayList();
		li = new Vector();
		
		li.add("��");
		li.add("��");
		li.add("��");
		li.add("��");
		
		List li4 = li.subList(0, 2); // new ArrayList() >> add("��"), add("��")
		System.out.println(li.toString());
		System.out.println(li4.toString());
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(7);
		alist.add(15);
		
		System.out.println("before: " + alist.toString());
		//Arrays.sort(); //����Ŭ����
		Collections.sort(alist);
		
		System.out.println("after: " + alist.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
