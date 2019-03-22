import javax.swing.JOptionPane;

class WordTime extends Thread{
	@Override
	public void run() { //main
		for(int i = 10; i > 0; i--) {
			System.out.println("남은시간: " + i);
			try {
				Thread.sleep(1000); //대기실에서 1초간 쉬어
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex04_Multi_word_game {
	public static void main(String[] args) {
		WordTime timer = new WordTime();
		timer.start();
		
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력값: " + inputdata);
	}
}
