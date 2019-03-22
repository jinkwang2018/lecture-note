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
        return "문제: "+this.question+" / 쓴답: "+this.answer+" / 채점: "+this.result;
    }
}

public class P01_HashMap_Game {
	public static void main(String[] args) {
		//쿼즈 문제와 정답을 HashMap 을 활용하여 처리
		//QuizInfo  클래스를 활용하여 문제의 결과에 대한 사항을 저장 가능 하다.
		HashMap<String, String> quiz = new HashMap<>();
		quiz.put("호수의 수도는?", "캔버라");
		quiz.put("ㅈ  ㅏ  ㄹ  ㅜ  ㅁ  ㅏ  ㄷ  ㅣ", "다람쥐");
		quiz.put("태양계에서 가장 큰 행성은 무엇인가요?", "목성");
		quiz.put("노르웨이의 수도는?", "오슬로");
		quiz.put("심하게 구겨진 옷을 손질하려면?", "다림질");
		quiz.put("음식이 싱거울 땐?", "소금질");
		quiz.put("차가운 맥주가 없을 땐?", "얼음넣기");
		quiz.put("단단하기가 황금과 같고, 아름답기가 난초 향기와 같은 사귐이라는 뜻의 사자성어?", "금란지교");
		
		Map<Integer, QuizInfo> save = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < quiz.size() ; i++) {
		    Set set = quiz.keySet();
		    Object[] obj= set.toArray();
		    System.out.println((i+1) + "번 문제" );
		    System.out.println(obj[i]);
		    
		    System.out.print("답: ");
			String answer = sc.nextLine();
			String correct = quiz.get(quiz.keySet().toArray()[i]);
			String result = answer.equals(correct) ? "정답" : "오답";
			
			save.put(i, new QuizInfo((String)obj[i], answer, result));
			System.out.println(save.get(i).toString());
		    System.out.println("정답: " + correct);
		    System.out.println("===================================================");
		}
		
		do {
			System.out.printf("다시보고 싶은 문제 번호 입력(총 %d문제)(0.종료): ", save.size());
			int num = Integer.parseInt(sc.nextLine());
			if(num == 0) {
				System.out.println("빠염!");
				break;
			}else if (num >= 1 && num <= save.size()) {
				System.out.println(save.get(num-1).toString());
			}else {
				System.out.println("해당 문제 번호가 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
		}while(true);
	}
}
