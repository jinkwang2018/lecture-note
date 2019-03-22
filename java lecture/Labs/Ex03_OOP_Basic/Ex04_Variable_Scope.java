//1. �ϳ��� �ڹ������� �������� Ŭ������ ���� �� �ִ� (�� public �����ڴ� �Ѱ��� Ŭ������)

//������ (������: ���������� ���� ������ default ������)
class Variable {
	int iv;
	/*
	1. member field, instance variable
	2. ����: ������ �������� �Ѵ�(����������, ���µ�����, ����������) >> �����Ǵ� ��ü���� �ٸ� ���� ���� ���ؼ�
	3. Ư¡: �ʱⰪ ������ �ִ� (������ Ÿ���� �����ϴ�: int - 0, float - 0.0, bloolean - false
	                                      String �Ǵ� ����Ÿ���� �⺻�� - null)
	4. ��������(memory�� ���� ����): new��� �����ڸ� ���ؼ� heap ��ü�� ��������� ����
	 */
	
	static int cv;
	/*
	1. class variable, static variable(�����ڿ�)
	2. ����: ������ �������� �Ѵ� (�����Ǵ� ��� ��ü�� �����ϴ� �ڿ����μ�): ��ü�� �����ڿ�
	3. Ư¡: ���ٹ��: Ŭ�����̸�.static�ڿ� (��ü�� ��������� ���� ��Ȳ������ ���� ����): Math.random()
					�Ǵ� ��������.static �ڿ�(variable v = new variable() ... v.cv)
	4. ��������: ���α׷� ���� (class loader�� ����Ŭ���� ������ �о class area, static area�� �ø��� ����
		�� �� Ŭ���� static �ڿ��� ������ �ִٸ� static �ڿ��� ���� memory �ø�
		>> static ��ü���� ������ �޸𸮿�  memory�� �ö󰡴� ���
	**static area���� Garbage collector�� �������� ����.	
	
	 */	
	void method() {
		int lv = 0;
		//local variable (��������)
		//Ư¡: ���������� ����ϱ� �� �ݵ�� �ʱ�ȭ
		//��������: �Լ��� ȣ��Ǹ� ��������� �Լ��� ������ �Ҹ�(stack)������ �ö󰡴� �ڿ�
	}
}

class Card {
	int num;
	String shape;
	static int width;
	static int height;
	
}


public class Ex04_Variable_Scope {
	public static void main(String[] args) {
		Variable.cv = 100;
		Variable v = new Variable();
		v.cv = 500;
		System.out.println(Variable.cv);
		
		Variable v2 = new Variable();
		System.out.println(v2.cv);
		
		Variable v3 = new Variable();
		v3.cv = 500; //����(��ü��)
		System.out.println(v3.cv);
		Variable v4 = new Variable();
		System.out.println(v4.cv);
	}
}
