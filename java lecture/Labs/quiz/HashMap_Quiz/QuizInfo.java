package HashMap_Quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Info{
	String question;
    String answer;
    String result;
    
    public Info(String question, String answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
    
    public String toString() {
        return "����:"+this.question+" ����:"+this.answer+" ä��:"+this.result;
    }

	
}

public class QuizInfo {
	public static void main(String[] args) {
		HashMap<String, String> Info = new HashMap<>();
		Info.put("�ظ����� �״»����?", "�����");
		Info.put("'����'�� �ټ� ���ڷ� ���̸�?", "����������");
		Info.put("�������� �տ� ��� �ٴϴ� ���� ?", "�ձ�");
		Info.put("����� ��� ���ô� �Ǵ� ?", "Ŀ��");
		Info.put("���߿� ���� ���� ����?", "�̺�");
		Info.put("�ŷ�Ʈ �����찡 �⸣�� �� �̸���?", "���찳");
		
		
		int sum = 0;
		for (int i = 0; i < Info.size(); i++) {
			Set set = Info.keySet();
			Object[] obj = set.toArray();
			
			System.out.println(obj[i]);
			// System.out.println(quiz.keySet().toArray()[i]);
			Scanner Sc = new Scanner(System.in);
			String answer = Sc.nextLine();
			while (true) {
				if (Info.get(Info.keySet().toArray()[i]).equals(answer)) {
					System.out.println("�����Դϴ�.");
					
					sum += 1;
					break;
				} else {
					System.out.println("Ʋ�Ƚ��ϴ�.");
					System.out.println(Info.get(Info.keySet().toArray()[i]));
					break;
				}
			}
			

		}System.out.println("��� : " + sum);

	}
}