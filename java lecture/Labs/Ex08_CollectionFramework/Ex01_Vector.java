import java.util.Vector;

/*
Collection FrameWork
[�ټ��� �����͸� �ٷ�� ǥ��ȭ�� �������̽��� �����ϰ� �ִ� Ŭ������ ����]

Collection �������̽� -> List (���) -> ���� (ArrayList ...)
                  -> Set  (���) -> ���� (HashSet, TreeSet ...)
                  
Map �������̽� -> ���� (HashMap ...)
------------------------------------------------------------
List Interface (���� ���ÿ�)
: ����(O), �ߺ�(O) -> ���������� ������(�ڷ�, ��ü) ���� -> Array [0][1][2][3]

1.Vector(������) -> ����ȭ(��Ƽ ������) -> ����(lock) default -> ��ȣ
ex) �Ѱ� ������� ȭ��� �Ѱ��� 100���� ����Ѵٰ� ����. �Ѹ��� ���� ���� ����.
2.ArrayList(�Ź���) -> ����ȭ(��Ƽ ������) -> ����(lock)�� �ʿ信 ���� ���� -> �� �� ���� ���� (���� 60%)
ex) �Ѱ� ������� ����� 100�κ��� 100���� ���� �Դ´�.

Array (�迭)
���� ������ ���� (�ѹ� ���� ũ�⸦ �����ϸ� ����Ұ�)
int[] arr = new int[10];
int[] arr = {10, 20, 30};

Array (����, ����)
1. �迭�� ũ�� ����: Car[] cars = {new Car(), new Car()}; �� 2�� ����
2. �迭�� ����: index(÷��) ���� >> cars[0], cars[0].name
3. �ʱ⿡ ������ ũ�� ���� �Ұ�

List (����) �������̽��� ������ Ŭ����
1. �迭�� ũ�⸦ ���� Ȯ��, ��Ұ� ���� => �迭�� ���Ҵ�
2. ������ ����(Array ���), ����(index), �ߺ��� ���
3. ������ ���� ���� (Array ���)
4. List �������̽��� �����ϴ� ��� �ڿ� Ŭ���� (new�� ���� ��ü ����)
5. ���� Ŭ������ default type(�ڷᱸ��): 
	ObjectŸ�� >> ����(�ڷ�ֱ�) >> int, Car, ... 
			 >> ����(������ Ÿ�� üũ, ����� casting)
			 >> casting ���� �������� >> Object obj = ...
6. �� Object Ÿ�� ������ �غ��ϰ��� >> ���ʸ� (Ÿ���� ����)

 */

public class Ex01_Vector {
	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("�ʱ� default �뷮: " + v.capacity()); //10�� default
		v.add("AA");
		v.add("BB");
		v.add("AA");
		v.add(100);
		//v.add(v); // �̷��� ���� ��, v�� ���� ��: (this collection)
		
		System.out.println(v); //v.toString() default
		System.out.println(v.toString()); //toString() ������
		
		//Array >> length() >> Car[index]
		
		//List�迭 : size() ������ ����
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i)); //get return Type >> Object
		}
		
		//������ for�� vector ���
		for(Object obj : v) {
			System.out.println(obj);
		}
		
		//���ʸ�(Object ����..>> Ÿ���� ����)
		Vector<String> v2 = new Vector<String>();
		v2.add("Hello");
		v2.add("World");
		v2.add("King");
		for(String str : v2) {
			System.out.println(str);
		}
		
		System.out.println(v2.toString());
		System.out.println(v2.get(2));
		System.out.println("size: " + v.size());
		System.out.println("capacity: " + v.capacity());
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity());
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		System.out.println(v3.capacity());
		v3.add("A");
		System.out.println("size: " + v3.size());
		System.out.println("11��°: " + v3.capacity());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
