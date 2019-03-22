//������¸� �ϳ� ������ �ִ�
//������¸� ���� �Ա�, ��� ó���� �� �� �ִ�

//ģ�� 5��(�Ȱ��� ī��)
//���ÿ� ���� ��� ('����'��� ���� �����带 ���ڴ�!�� �ǹ�)

//���� 1000����
//ATM ��⿡�� ���ÿ� ���

//������
//������ [��� ~ ����] ������ ���� LOCK ���ؼ� �ڿ� ��ȣ

class Account{ //����
	int balance = 1000; //�ܾ�
	 synchronized void withDraw(int money) { //���
		System.out.println("�� : " + Thread.currentThread().getName());
		System.out.println("���� �ܾ� : " + this.balance);
		if(this.balance >= money) {
			try {
				Thread.sleep(1000); //������� ó���Ǵ� ����(���� ,ī�� Ȯ��....)
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.balance -= money;
		}
		System.out.println("����ݾ� : " + money);
		System.out.println("������ �ܾ� :" + this.balance);
	}
}

class Bank implements Runnable{
	Account acc = new Account();
	@Override
	public void run() {
		while(acc.balance > 0) {
			
			int money = ((int)(Math.random()*3)+1)*100;
			//�� ��� ó��
			acc.withDraw(money);
		}
	}
}

//class T extends Thread{}

public class Ex10_Sync_Thread {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Thread th = new Thread(bank,"Park");
		Thread th2 = new Thread(bank,"Kim");
		Thread th3 = new Thread(bank,"Lee");
		
		/* class T extends Thread{}�� ��� Thread�� �̸��� �����ϴ� ���
		T t = new T();
		t.setName("Park");
		*/
		
		th.start();
		th2.start();
		th3.start();
	}
}
