/*
��ü ���� ��� Ư¡
���, ĸ��ȭ, ������

ĸ��ȭ (����ȭ) -> private

[method overloading]
�ϳ��� �̸����� �������� ����� �ϴ� �Լ�
���: println() ��ǥ���� �Լ�
Ư¡: �����ε��� ���� ��� ������ �ش� (x) -> �������
     why) �����ڰ� ���ϰ� ����Ϸ���
	  ����� � ���� �����ϸ�: �Լ��� Ȱ���� ���� ��� (parameter ����)
	 ex)System.out.println() : static�̸鼭 overloading
     
����: �Լ��� �̸��� ���� parameter�� ������ Ÿ���� �޸��ϴ� ���
1. �Լ��� �̸��� ���ƾ� �Ѵ�
2. [parameter] ���� �Ǵ� [type]�� �޶�� �Ѵ�
3. return type�� overloading �Ǵ� ���� (x)
4. parameter ������ �ٸ��� �����Ѵ�
 */

class Human {
	String name;
	int age;
	
}

class OverTest{
	//�����ε�
	void add(Human h) {
		h.name = "ȫ�浿";
		h.age = 100;
		
	}
	
	
	int add(int i) {
		return 100 + i;
	}
	String add(String s) {
		return "hello" + s;
	}
	/* �浹(�����ε� ���� ����)
	void add(int k) {
		return k;
	}
	*/
	int add(int i, int k) {
		return i+k;
	}
	void add(int i, String s) {
		System.out.println("�����ε�");
	}
	void add(String s, int i) { //������ �ٸ��� ����
		System.out.println("parameter ������ �ٸ��� ����");
	}
	
	//�迭(Array)�� �������..
	//������ �ڵ�
	//int[] source = {1,2,3,4,5}
	int[] add(int[] param) { // int �����迭�� �ּҰ��� �ްڴ�
		int[] target = new int[param.length];
		for(int i = 0; i < param.length; i++) {
			target[i] = param[i] + 1;
		}
		return target;
		//int �����迭�� �ּҰ��� �����ϰڴ�.
	}
	/////////////////�����ε�//////////////////////
	int[] add(int[] so, int[] so2) {
		int[] result = new int[so.length];
		for(int i = 0; i < so.length; i++) {
			result[i] = so[i] + so2[i];
		}
		return result;
	}
	
	
}

public class Ex11_method_overloading {
	public static void main(String[] args) {
		OverTest t = new OverTest();
		t.add(100, "AAA");
		t.add("BBB", 2000);
		//t.add("A", "B"); (x) �����ε� �Ǿ����� ����
		
		//void add(Human h) {} �� ���ؼ�
		//1. ok 
		Human m = new Human();
		t.add(m);
		
		//2. ok
		t.add(new Human()); 
		// heap�޸𸮿� ��ü�� �����ǰ�, �ּҰ��� ������ ���� �ʾұ� ������ ���ÿ��� �ּҰ��� ���� ���� �ʴ�.
		
		//////////////////////////////////////
		int[] source = {10, 20, 30, 40, 50};
		int[] target = t.add(source); //source �迭�� �ּҰ�
		
		//1. source ������ target �迭������ �ּҰ���: �ٸ���
		System.out.println(source + " / " + target);
		for(int v : target) {
			System.out.println(v);
		}
		//////////////////////////////////////
		int[] test1 = {10, 20, 30};
		int[] test2 = {2, 4, 5};
		
		int[] addition = t.add(test1, test2);
		for(int v: addition) {
			System.out.println(v);
		}
		
	}
	
	
}
