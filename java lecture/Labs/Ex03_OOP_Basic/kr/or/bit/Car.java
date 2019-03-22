package kr.or.bit;
/*
������(modifier)
public (����: ����(package) ���о��� ��� �ڿ� ����)
private(����: Ŭ���� ���ο��� ����, ���������� �� �� �����(���Ұ�) >> ��ü���忡�� ���� �Ұ�

��ü������ Ư¡(ĸ��ȭ, ����ȭ)
1. Ŭ���� ���� �ڿ��� ���� >> member field (instance variable): private int age;
1.1 private �ǹ�: �����Ҵ��� ���� **[�����Ҵ�]�� ���ؼ� �ڿ� ��ȣ
1.2 �������� �ǵ� (���ϴ� ���� ó��) > private int age > 1 ~ 200���� ������ �ְڴ�. > ������ �Լ��� ���� ����
1.3 private ������ ������ ���(���� ���� write �Լ�, ������ ���� read �Լ�)
	ĸ��ȭ�� member field���� ���� write, read ����� ���� �Լ� 
	-> setter(����), getter(�б�) �Լ� �̸� �ο�

private int age = 100;
-setter �Լ��� ��� ����
-getter �Լ��� ��� ����
-setter, getter �Լ� ��� ��� ����

2. Ŭ���� ���� �ڿ��� ���� >> method: private void call() {}
2.1 �Լ��� private�� �ϴ� ����: Ŭ�������ο��� �ٸ� �Լ��� �����ִ� ���� �ϴ� �Լ� (�����Լ�)


 */
public class Car {
	private int window;
	private int speed;
	
	//window ������ setter, getter �Լ��� ���ؼ� write, read ���
	//write(setter) �Լ�
	public void setWindow(int data) {
		window = data;
	}
	public int getWindow() {
		return window;
	}
	
	//�ڵ����� ������ getter �Լ�
	public int getSpeed() {
		return speed;
	}
	//�ڵ����� ������ setter �Լ�
	public void setSpeed(int speed) {
		//�����Ҵ��� ����
		if(speed < 0) {
			this.speed = 0;
		}else {
			this.speed = speed;
		}
	}
	
	//�߰��Լ� ���� �ȴ�
	public void speedUp() {
		speed += 5;
	}
	
	public void speedDown() {
		if(speed > 0) {
			speed -= 5;
		}else {
			speed = 0;
		}
	}
	
	
}
