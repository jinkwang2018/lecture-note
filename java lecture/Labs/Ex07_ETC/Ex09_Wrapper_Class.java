import java.util.ArrayList;

/*
�⺻ Ÿ��(��Ÿ��): 8���� >> JAVA API ����
8���� �⺻ Ÿ�Կ� ���ؼ� ��ü ���·� ��밡�� �ϵ��� ���� ��
wrapper class (���� Ÿ��)
�⺻��Ÿ�� ������ ���δ� ��ü���·� �ٷ������ �ϴ� ���
1.�Ű������� ��ü�� �䱸 �� ��
2.�⺻�� ���� �ƴ� ��ü�� ����Ǿ�� �� ��
3.��ü���� �񱳰� �ʿ��� ��
�� �� wrapper ����ϸ�...
wrapper Ŭ�������� �� Ÿ���� ����(�ּ�ũ��, �ִ�ũ�� ����� ���·� ����)

ex)
	Integer.parseInt(s)
	ArrayList<Integer> li = new ArrayList<>(); >> parameter����
	
	System.out.println(Integer.MIN_VALUE);
	System.out.println(Integer.MAX_VALUE);
 */

public class Ex09_Wrapper_Class {
	public static void main(String[] args) {
		int i = 100;
		Integer n = new Integer(500);
		System.out.println("i: " + i);
		System.out.println("n: " + n.toString()); //������
		
		//parameter ��Ÿ���� ��ü���·� ���� ��
		//Ȱ�뵵�� ���� ���� �ڵ�
		//Generic ���� (���� wrapper Ŭ���� ���)
		ArrayList<Integer> li = new ArrayList<>();
		li.add(100);
		li.add(200);
		for(int r : li) {
			System.out.println(r);
		}
		Integer i2 = new Integer(100);
		Integer i3 = new Integer(100);
		System.out.println(i2 == i3); // == �ּ� �� (false) �ּҰ� ���̱� ������
		
		System.out.println(i2.equals(i3));
		//Object�� ������ equals�Լ� (�� ��) Integer Ŭ�������� ������
		
		Integer t = new Integer(500);
		integerMethod(t); //t �������� �ּҰ�
		intMethod(t); //t��� ���������� ������ ��: 500
	}
	static void integerMethod(Integer i) {
		System.out.println("Integer param: " + i);
	}
	static void intMethod(int i) {
		System.out.println("int param: " + i);
	}
}
