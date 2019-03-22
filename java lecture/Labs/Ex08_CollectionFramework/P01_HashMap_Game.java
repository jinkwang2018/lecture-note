import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class QuizInfo {
    String question;
    String answer;
    String result;
    
    public QuizInfo(String question, String answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
    
    public String toString() {
        return "����: "+this.question+" / ����: "+this.answer+" / ä��: "+this.result;
    }
}

public class P01_HashMap_Game {
	public static void main(String[] args) {
		//���� ������ ������ HashMap �� Ȱ���Ͽ� ó��
		//QuizInfo  Ŭ������ Ȱ���Ͽ� ������ ����� ���� ������ ���� ���� �ϴ�.
		HashMap<String, String> quiz = new HashMap<>();
		quiz.put("ȣ���� ������?", "ĵ����");
		quiz.put("��  ��  ��  ��  ��  ��  ��  ��", "�ٶ���");
		quiz.put("�¾�迡�� ���� ū �༺�� �����ΰ���?", "��");
		quiz.put("�븣������ ������?", "������");
		quiz.put("���ϰ� ������ ���� �����Ϸ���?", "�ٸ���");
		quiz.put("������ �̰ſ� ��?", "�ұ���");
		quiz.put("������ ���ְ� ���� ��?", "�����ֱ�");
		quiz.put("�ܴ��ϱⰡ Ȳ�ݰ� ����, �Ƹ���Ⱑ ���� ���� ���� ����̶�� ���� ���ڼ���?", "�ݶ�����");
		
		Map<Integer, QuizInfo> save = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < quiz.size() ; i++) {
		    Set set = quiz.keySet();
		    Object[] obj= set.toArray();
		    System.out.println((i+1) + "�� ����" );
		    System.out.println(obj[i]);
		    
		    System.out.print("��: ");
			String answer = sc.nextLine();
			String correct = quiz.get(quiz.keySet().toArray()[i]);
			String result = answer.equals(correct) ? "����" : "����";
			
			save.put(i, new QuizInfo((String)obj[i], answer, result));
			System.out.println(save.get(i).toString());
		    System.out.println("����: " + correct);
		    System.out.println("===================================================");
		}
		
		do {
			System.out.printf("�ٽú��� ���� ���� ��ȣ �Է�(�� %d����)(0.����): ", save.size());
			int num = Integer.parseInt(sc.nextLine());
			if(num == 0) {
				System.out.println("����!");
				break;
			}else if (num >= 1 && num <= save.size()) {
				System.out.println(save.get(num-1).toString());
			}else {
				System.out.println("�ش� ���� ��ȣ�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
		}while(true);
	}
}
