import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Set �������̽� �����ϴ� Ŭ����
//Set ����(x), �ߺ�(x) �̷� ������ ������ �ٷ� ��
//HashSet, TreeSet
//���� (���� ������ �������� ����)

public class Ex10_Set_Interface {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(100);
		hs.add(55);
		System.out.println(hs.toString());
		
		//�ߺ� ������ ó��(POINT)
		boolean bo = hs.add(1);
		System.out.println(bo);
		System.out.println(hs.toString());
		hs.add(2);
		System.out.println(hs.toString());
		
		HashSet<String> hs2 = new HashSet<>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("c");
		hs2.add("z");
		System.out.println(hs2.toString());
		
		//1.�ߺ� ������� ����
		String[] obj = {"A", "B", "A", "C", "D", "B", "A"};
		HashSet<String> hs3 = new HashSet<>();
		for(int i = 0; i < obj.length; i++) {
			hs3.add(obj[i]);
		}
		System.out.println(hs3.toString());
		
		//Quiz
		//HashSet ����ؼ� 1~45���� ���� 6���� ��������
		//�� �ߺ����� ������ �ȵǿ�
		//(int)(Math.Random()*45)+1
		Set set = new HashSet();
		
		//for�� ���
		/*
		for(int i = 0; set.size() < 6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		System.out.println(set.toString());
		*/
		
		//while�� ���
		int index = 0;
		while(set.size() < 6) {
			++index;
			set.add((int)(Math.random()*45)+1);
		}
		System.out.println(index);
		System.out.println(set.toString());
		
		HashSet<String> set3 = new HashSet<>();
		set3.add("AA");
		set3.add("DD");
		set3.add("AAC");
		set3.add("FFFF");
		System.out.println(set3.toString());
		
		Iterator<String> s = set3.iterator();
		while(s.hasNext()) {
			System.out.println(s.next());
		} //���� (add�� ����) ���� ���� �ʴ´� (�迭�� �ƴϹǷ�)
		
		//Collections.sort(list); //List �������̽� ������ ��ü�� ���⿡ �� �� �ִ�.
		//Collections.reverse(List<T> li);
		
		//Set �������̽� ���� �ڿ�: sort �ǹ� ����
		//List list = new ArrayList(set3);
		List list = new ArrayList(set3);
		System.out.println("before ������: " + list.toString());
		Collections.sort(list);
		System.out.println("after ����: " + list.toString());
		Collections.reverse(list);
		System.out.println("after ������: " + list.toString());
		
		
	}
}
















