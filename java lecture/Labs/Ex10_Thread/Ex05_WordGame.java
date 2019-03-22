import javax.swing.JOptionPane;

/*
����
main�Լ� ������ Thread 2�� �߰�
1. �ð�(time) �����ϴ� Thread
2. �ܾ� �Է��� ó���ϴ� Thread

main�Լ����� 2�� Thread ����

��, �ܾ �ϳ��� �Է��ؼ� Ȯ�� ��ư�� ������ �ð��� ���߰� �ϼ���
hint() �����ڿ�
 */

class TimeControl extends Thread {
	@Override
	public void run() {
		try {
			for(int i = 10; i > 0; i--) {
				if(Ex05_WordGame.check) return;
				//if(WordInput.inputdata != null) {
					//System.exit(0);
				//}
				System.out.println("�����ð�: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class  WordInput extends Thread {
	//public static String inputdata;
	@Override
	public void run() {
		String inputdata = JOptionPane.showInputDialog("���� �Է��ϼ���");
		System.out.println("�Է°�: " + inputdata);
		Ex05_WordGame.check = true;
	}
}

public class Ex05_WordGame {
	public static boolean check;
	public static void main(String[] args) {
		TimeControl time = new TimeControl();
		WordInput word = new WordInput();
		
		time.start();
		word.start();
	}
}
