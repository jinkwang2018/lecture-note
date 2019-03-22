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
        return "문제:"+this.question+" 쓴답:"+this.answer+" 채점:"+this.result;
    }

	
}

public class QuizInfo {
	public static void main(String[] args) {
		HashMap<String, String> Info = new HashMap<>();
		Info.put("해를보면 죽는사람은?", "눈사람");
		Info.put("'오뎅'을 다섯 글자로 늘이면?", "뎅뎅뎅뎅뎅");
		Info.put("언제든지 손에 쥐고 다니는 금은 ?", "손금");
		Info.put("사람이 즐겨 마시는 피는 ?", "커피");
		Info.put("별중에 가장 슬픈 별은?", "이별");
		Info.put("탤런트 최지우가 기르는 개 이름은?", "지우개");
		
		
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
					System.out.println("정답입니다.");
					
					sum += 1;
					break;
				} else {
					System.out.println("틀렸습니다.");
					System.out.println(Info.get(Info.keySet().toArray()[i]));
					break;
				}
			}
			

		}System.out.println("결과 : " + sum);

	}
}