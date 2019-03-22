import kr.or.bit.Person;
import kr.or.bit.Tv;

public class Ex01_Ref_Type {
	public static void main(String[] args) {
		// ���赵�� ������� Person Ÿ���� ���� ��ü�� ���� (heap �޸�: ��ü���� �ö󰡴� �޸� ����)
		// -> new �����ڸ� ���ؼ�
		Person person; // ����(static 4Byte ���� ��(null))
		person = new Person(); // heap �޸𸮿� Person ��ü�� ��������� �� �ּҰ��� person ������ �Ҵ�
		
		person.name = "ȫ�浿";
		person.age = 100;
		person.print();
		
		Person my = new Person(); // �����ϰ� �޸� �Ҵ��� ���ÿ�
		my.name = "���̸���";
		my.age = 10;
		my.print();
		
		int num = 100; // main [�Լ�]�ȿ� ����� ���� local variable (�ݵ�� �ʱ�ȭ)
		
		Person you; // you ����
		// System.out.println(you); // The local variable you may not have been initialized
		
		// ����Ÿ���� �ʱ�ȭ
		// 1. �ʱ�ȭ (new ������)
		you = new Person(); // ����Ÿ�� �ʱ�ȭ (�ʱ�ȭ: ������ ó�� ���� ���� ��)
		
		// 1. ������ ������ �ִ� �ּҰ� �Ҵ� 
		you = my; // �ּҰ� �Ҵ� (�ʱ�ȭ) ó�� ���� ���� ����
		System.out.println(you); // kr.or.bit.Person@70dea4e
		
		// you ���������� my ���������� �ּҰ��� ������ ����
		System.out.println(you == my); // == ���� (���� �ּ�: true)
		System.out.println(you + " / " + my);
		
		// Tv Ŭ���� �̿��� ����
		Tv t = new Tv();
		t.brandname = "�Ｚ";
		
		System.out.println("�⺻ ä��: " + t.ch);
		System.out.println("�귣���: " + t.brandname); // null ���� ����
		
		t.chUp();
		t.chUp();
		t.chUp();
		System.out.println("����� ä��: " + t.ch);
		
		t.chDown();
		System.out.println("����� ä��: " + t.ch);
		
		// Boolean�� �⺻���� false
		
	}
}
