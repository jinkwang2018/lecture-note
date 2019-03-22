import javax.swing.JOptionPane;

/*
  ����
 main �Լ� ������ Thread 2�� �߰�
 1. �ð�(time) �����ϴ� Thread
 2. �ܾ� �Է��� ó���ϴ� Thread
 
 main �Լ� 2�� ����
 
 ��  �ܾ �ϳ��� �Է��ؼ� Ȯ�� ��ư�� ������ �ð��� ���߰� �ϼ���
hint() �����ڿ� 
   
*/

class WordInputProcess extends Thread{
	@Override
	public void run() {
		String dan="2";
		String inputdata = JOptionPane.showInputDialog("dan" + "�� ���� �Է�");
		if(inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame_Teacher.inputcheck = true;
		}
		System.out.println("�Է��� ����: " + inputdata);
	}
}


class WordTimeOut extends Thread{
	@Override
	public void run() {
		for(int i=10; i > 0 ; i--) {
			
			if(Ex05_WordGame_Teacher.inputcheck)return; //run�Լ� Ż��
			
			System.out.println("���� �ð�: " + i);
			try {
				 Thread.sleep(1000); //���ǿ��� 1�ʰ� ������ ....
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex05_WordGame_Teacher {
	//���� : static 
	static boolean inputcheck= false;
	public static void main(String[] args) {
		WordInputProcess word = new WordInputProcess();
		WordTimeOut time = new WordTimeOut();
		
		word.start();
		time.start();
		
		
		try {
			word.join(); //main Thread���� ���� ���������� ��ٷ� �޶� ��
			time.join(); ////main Thread���� ���� ���������� ��ٷ� �޶� ��
			//Join �޼ҵ�� �ϳ��� �����尡 �ٸ� �����尡 �ϴ� ���� �Ϸ�� �� ���� ��ٸ����� �� �� ���δ�. ���� ���� ���ư��� �ִ� ������(A)���� �� �ٸ� ������(B) �� �Ϸ�� �� ���� ��ٸ����� �Ѵٸ�, 
            //B.join();
            //�̷��� ȣ�� ���ָ� �ȴ�. �̷��� �ϸ�,  
			//���� ���ư��� �ִ� ������ A �� ������ B �� �ϴ� ���� ��ĥ �� ����, �����ְ�(pause) �ȴ�. join �޼ҵ带 �����ε�(overloading) �� �޼ҵ� ���� �ִµ� �� �޼ҵ���� �����ڰ� �� ���� �����ְ� �� ���� ������ �� �ִ�. 
		}catch (Exception e) {
			
		}
		System.out.println("Main END");
		
	}
	
}
/*
4. join() : �ٸ� �������� ���Ḧ ��ٸ�

��� �۾��� �ϴ� �����尡 ��� ��� �۾��� ������ ��, ��� ������� �޾� �̿��ϴ� ��� ����Ѵ�. 

ThreadA�� ThreadB�� join() �޼ҵ带 ȣ���ϸ� ThreadA�� ThreadB�� ������ ������ �Ͻ� ���� ���°� �ȴ�.
ThreadB�� run() �޼ҵ尡 ����Ǹ� ThreadA�� �Ͻ� �������� Ǯ�� �����ִ� �ڵ带 �����Ѵ�. 
http://cafe.naver.com/bitcamp104/537

*/