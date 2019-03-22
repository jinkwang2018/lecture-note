//한글 작업 (주작업) ... 보조적으로 (저장) >> Daemon ...
//Daemon은 주작업과 생명을 같이한다

public class Ex07_Daemon_Thread implements Runnable{
	static boolean autosave = false;
	
	public static void main(String[] args) {
		Thread th = new Thread(new Ex07_Daemon_Thread());
		th.setDaemon(true);
		th.start();
		//main 하나의 쓰레드 (non-daemon)
		//main의 보조는 th (th는 mian함수의 데몬쓰레드)
		//th는 main과 운명을 같이한다
		
		for(int i = 0; i <= 30; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Main Thread: " + i);
			if(i == 5) { //i가 5가 되는 시점에
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
			if(autosave) { //autosave가 true라면
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("문서가 3초 간격으로 자동 저장 되었습니다");
	}
}
