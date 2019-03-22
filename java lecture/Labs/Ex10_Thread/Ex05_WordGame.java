import javax.swing.JOptionPane;

/*
문제
main함수 제외한 Thread 2개 추가
1. 시간(time) 제어하는 Thread
2. 단어 입력을 처리하는 Thread

main함수에서 2개 Thread 실행

단, 단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추게 하세요
hint() 공유자원
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
				System.out.println("남은시간: " + i);
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
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력값: " + inputdata);
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
