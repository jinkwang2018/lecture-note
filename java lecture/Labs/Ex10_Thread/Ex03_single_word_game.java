import javax.swing.JOptionPane;

//�ܾ� ���߱� ����
//������ ����
public class Ex03_single_word_game {
	public static void main(String[] args) {
		String inputdata = JOptionPane.showInputDialog("���� �Է��ϼ���");
		System.out.println("�Է°�: " + inputdata);
		timer();
	}
	static void timer() {
		for(int i = 10; i > 0; i--) {
			System.out.println("�����ð�: " + i);
			try {
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}