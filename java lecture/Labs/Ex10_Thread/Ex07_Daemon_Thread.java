//�ѱ� �۾� (���۾�) ... ���������� (����) >> Daemon ...
//Daemon�� ���۾��� ������ �����Ѵ�

public class Ex07_Daemon_Thread implements Runnable{
	static boolean autosave = false;
	
	public static void main(String[] args) {
		Thread th = new Thread(new Ex07_Daemon_Thread());
		th.setDaemon(true);
		th.start();
		//main �ϳ��� ������ (non-daemon)
		//main�� ������ th (th�� mian�Լ��� ���󾲷���)
		//th�� main�� ����� �����Ѵ�
		
		for(int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Main Thread: " + i);
			if(i == 5) { //i�� 5�� �Ǵ� ������
				System.out.println(i);
				autosave = true;
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				
			}
			if(autosave) { //autosave�� true���
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("������ 3�� �������� �ڵ� ���� �Ǿ����ϴ�");
	}
}
