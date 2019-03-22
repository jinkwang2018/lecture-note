import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//������

class TimeCon extends Thread {
	@Override
	public void run() {
		int level = 30;
		try {
			for(int i = level; i > 0; i--) {
				if(P01_RandomGame.count > 6) return;
				System.out.println("�����ð�: " + i);
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

class InputCon extends Thread {
	public static List<Quiz> save;
	@Override
	public void run() {
		QuizInfo questions = new QuizInfo();
		save = new ArrayList<>();
		Scanner sc = new Scanner(System.in); 
        
        for(int i = 0 ; i < questions.quiz.size() ; i++) {
            Set set = questions.quiz.keySet();
            Object[] obj= set.toArray(); 
            System.out.println(obj[i]); //�迭�� �ؼ� ���� ���
            
            String answer = sc.nextLine(); //����
            String userwrite = questions.quiz.get(obj[i]); //����
            String result = answer.equals(userwrite) ? "����" : "����"; 
            save.add(new Quiz((String)obj[i], answer, result)); 
            if(result.equals("����")) {
            	P01_RandomGame.check++;
            }
            System.out.println(save.get(P01_RandomGame.count).toString());
            P01_RandomGame.count++;
        }
	}
}

class Quiz {
    String question;
    String answer;
    String result;
 
    public Quiz(String question, String answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
 
    public String toString() {
        return  "user�� ���� : " + this.answer + "\nä�� : " + this.result;
    }
}

class QuizInfo {
	Map<String, String> quiz;
    public QuizInfo() {
        quiz = new HashMap<>();
        quiz.put("3 x 3 = ", "9");
        quiz.put("6 x 7 = " , "42");
        quiz.put("3 x 9 = ", "27");
        quiz.put("12 x 4 = ", "48");
        quiz.put("15 x 15 = ", "225");
        quiz.put("4 x 14 = ", "56");
        quiz.put("2 x 3 = ", "6");
    }
}

public class P01_RandomGame {
	public static int check;
	public static int count;
	public static void main(String[] args) {
		TimeCon time = new TimeCon();
		InputCon input = new InputCon();
		
		time.start();
		input.start();
		
		try {
			time.join();
			input.join();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("==================================================");
		Iterator it = input.save.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("==================================================");
		System.out.println("���� ���� ��: " + check);
	}
}
