package BlueMarble;

class Timeout extends Thread{
	static int i=180;
	@Override
	public void run() {
		for(; i > 0 ; i--) {		
			try {
				 Thread.sleep(1000); //���ǿ��� 1�ʰ� ������ ....
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}