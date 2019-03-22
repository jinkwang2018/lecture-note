//Thread: ���μ������� �ϳ��� �ּ� ������� (method)

//Thread �������
//1. Thread Ŭ���� �� ��� -> class Test extends Thread{}
//�ݵ�� Thread ����� ��� run()�Լ� ������ �ؾ���

//2. implements Runnable ���� -> class Test implements Runnable {}
//�ݵ�� run() �߻��Լ� ������
//POINT: Thread_2 implements Runnable >> Thread�� �ƴϴ�, Thread�� �� �� �ִ� ��Ǹ� �����

//why 2���� ����
//class Test extends Car implements Runnable -> Runnable �������̽� ����ϴ� ����: �ٸ� ����� �ޱ� ���ؼ�

//Thread �߻� Ŭ���� �ƴ� �Ϲ� Ŭ����
//�߻�Ŭ�������: new(��ü ����) �� ���� ����

//-> ��Ƽ������� ���ÿ� ����Ǵ� ���� �ƴ϶� ���ÿ� ����� �� �ִ� ��Ȳ�� ������ִ� ��
//start()�� �����Լ��� �ö󰡰� ���ο� stack�� run()�� �ø��� ������� 


class Thread_1 extends Thread {
	@Override
	public void run() { //���ο� stack�� ó�� �ö󰡴� �Լ� (��ġ main�Լ� ó��)
		for(int i = 0; i < 1000; i++) {
			System.out.println("Thread_1: " + i + this.getName());
		}
		System.out.println("Thread_1 run() END");
	}
}

class Thread_2 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("Thread_2: " + i);
		}
		System.out.println("Thread_2 run() END");
	}
}


public class Ex02_Multi_Thread {
	public static void main(String[] args) {
		System.out.println("Main Start");
		
		//1��
		Thread_1 th = new Thread_1();
		th.start(); //POINT > stack �����ϰ� stack run() �÷�����
		
		//2��
		Thread_2 th2 = new Thread_2();
		Thread thread = new Thread(th2); //�Ϲ� Ŭ����
		thread.start(); //POINT > stack �����ϰ� stack run() �÷�����
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("main: " + i);
		}
		System.out.println("Main END");
		
	}
}
