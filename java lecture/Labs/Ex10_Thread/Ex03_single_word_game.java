import javax.swing.JOptionPane;

//단어 맞추기 게임
//구구단 게임
public class Ex03_single_word_game {
	public static void main(String[] args) {
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력값: " + inputdata);
		timer();
	}
	static void timer() {
		for(int i = 10; i > 0; i--) {
			System.out.println("남은시간: " + i);
			try {
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}