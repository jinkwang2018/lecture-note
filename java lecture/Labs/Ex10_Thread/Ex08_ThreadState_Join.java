//Thread : state ����(���� , ���� ....)
//state ������ ���� :Thread ������ ������ , �Լ�
//sleep() , join()

//������ ����� �������� ������� ����� ó��
//�� ��� ����� �����ؼ� �������� ����� ����� �;��

//Thread  ���� ó���Ҷ� (���� ���� ������� �˼� ����) 

//main �Լ� Thread ,,, �ٸ� ������ Thread
//main Thread �� �ٸ� �����尡 ������ ���� ��ٸ��� ... 

//��ٸ��� �༮�� ������ Thread ��û (join())

class Thread_join extends Thread{
	@Override
	public void run() {
		for(int i=0; i < 3000 ;i++) {
			System.out.println("----------");
		}
	}
}

class Thread_join2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i < 3000 ;i++) {
			System.out.println("||||||||||");
		}
	}
}
public class Ex08_ThreadState_Join {

	public static void main(String[] args) {
		Thread_join th = new Thread_join();
		Thread_join2 th2 = new Thread_join2();
		
		th.start();
		th2.start();
		
		long starttime = System.currentTimeMillis();
		
		try {
			  th.join();
			  th2.join();
			  //main ��û ....
			  //main �� ��ٸ��ž� th , th2 �۾��� ����������
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0 ; i < 3000 ;i++) {
			System.out.println("^^^^^^^^");
		}
		
		//3���� �����尡 ������ ���(�� �ɸ� �ð�)
		System.out.println("3���� ������ �� �۾� �ð� :");
		System.out.println(System.currentTimeMillis());
		System.out.println(starttime);
		System.out.println(System.currentTimeMillis()-starttime);
		System.out.println("Main END");
	}

}
