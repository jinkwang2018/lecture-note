/*
������ �Լ� (constructor)
1.�Լ� ("Ư���� ����"�� ������ �Լ�)
2.Ư���� ���� (member field �ʱ�ȭ)

3.�Ϲ��Լ��� �ٸ���
3.1 �Լ��� �̸��� ���� (class �̸��� ����)
3.2 return type(x), void(x) >> ����� ��� ������ �Լ� (void)
3.3 why void (default): �������: ��ü������ ���ÿ� ȣ��Ǵ� �Լ�: ������ ���� ���� �༮�� �����
3.4 �Ϲ��Լ� (�̸��� ȣ��: print();), ������ �Լ��� new�� ���ؼ� class�� ��ü�� ����� �� ��

4.����: �����Ǵ� ��ü���� �ٸ� �ʱⰪ�� �ο��� ��

5.�Լ��� overloading�� �����ϴ� (������ �Լ��� overloading ���)

new Car(); �޸𸮿� �ø� �� �Լ��� ȣ���ϸ鼭 �ø��ڴ� (default constructor)

class ������ default �����ڴ� ���� ���� >> �����Ϸ��� ������

 */

class Car {
	String name;
	// Car() { System.out.println("�� ������ �Լ���"); }
}

class Car2 {
	String carname; // member field
	Car2() { //������ �Լ� >> member field �ʱ�ȭ
		carname = "pony";
	}
}

class Car3 {
	int number;
	//�������: �����ؼ� ���
	Car3() {
		System.out.println("�ǵ��� �ڵ� (�ʱ�ȭ)");
	}
}
/////////////////////////////////////////////
class Car4 {
	int door;
	int wheel;
	
	Car4() { //default
		System.out.println("default");
	}
	
	Car4(int num) { //overloading
		door = num;
		System.out.println("overloading door");
	}
	
	Car4(int num, int num2) { //overloading
		door = num;
		wheel = num2;
		System.out.println("overloading door, wheel");
	}
}

//***** ���� �߿��� �������� �ǵ� *****
//���������� overloading�� ������ �Լ��� �ϳ��� �����Ѵٸ�
//�����Ϸ��� �ڵ����� default ������ �Լ��� ������ �ʴ´�.
//���� default ������ �Լ��� ����ϰ� �ʹٸ� ���� ���� �ϼ���

//������ �ǵ�: [�������� �ʱ�ȭ] �ǵ�
class Car5 {
	int number;
	Car5(int num) {
		number = num;
	}
}




public class Ex13_Constructor_Function {
	public static void main(String[] args) {
		Car c = new Car();
		Car2 c2 = new Car2();
		System.out.println(c2.carname);
		
		Car4 c4 = new Car4(10, 4);
		
		// Car5 c5 = new Car5(); // Error
		Car5 c5 = new Car5(2);
		System.out.println(c5.number);
	}
}
