//연산자, 제어문

public class Ex06_Operation {
	public static void main(String[] args) {
		int sum = 0;
		// 대입 연산자 (+=, -=, *= ...): 습관적으로 사용
		sum += 1; // sum = sum + 1;
		sum -= 1; // sum = sum - 1;
		System.out.println("sum: " + sum);

		// 간단한 학점 계산기
		// 학점에 대해서 A+ , B-
		// 94점
		// 95점 보다 크면 A+
		// 그 외는 A-
		
		// 일반 방식
		int score = 75;
		String grade = ""; // 문자열 초기화 ""
		System.out.println("당신의 점수는: " + score);

		if (score >= 90) {
			grade = "A";
			if (score >= 95) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println("당신의 학점은: " + grade + "입니다");
		
		// 삼항 연산자 사용: 변수 = (조건식)? A:B
		int score2 = 95;
		String grade2 = "";
		System.out.println("점수: " + score2);
		
		if (score2 >= 90) {
			grade2 = "A";
			grade2 += (score2 >= 95) ? "+" : "-"; 
		}else if (score2 >= 80) {
			grade2 = "B";
			grade2 += (score2 >= 85) ? "+" : "-";
		}else if (score2 >= 70) {
			grade2 = "C";
			grade2 += (score2 >= 75) ? "+" : "-";
		}else {
			grade2 = "F";
		}
		System.out.println("학점: " + grade2);
		
		// [단축키]
		// syso > ctrl + space
		// 코드 정렬하기: ctrl + A 블럭 선택 > ctrl + shift + F (자동 들여쓰기 정렬)
		
		
		// switch 문
		int data = 100;
		switch (data) {
			case 100:
				System.out.println("100입니다");
				break;
			case 90:
				System.out.println("90입니다");
				break;
			case 80:
				System.out.println("80입니다.");
				break;
			default:
				System.out.println("default");
		}
		
		// break 구문은 없어도 된다
		switch (data) {
		case 100: System.out.println("100입니다");
		case 90: System.out.println("90입니다");
		case 80: System.out.println("80입니다.");
		default: System.out.println("default");
		}
		
		// 적절한 break 구문의 사용 예
		int month = 3;
		String res = "";
		
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: res = "31"; break;
   
            case 4:
            case 6:
            case 9:
            case 11: res = "30"; break;
   
            case 2: res = "29"; break;
   
            default : res ="월이 아닙니다.";
        }
        System.out.println(month + "월은 " + res + "일까지 입니다.");
		
        // 난수 (랜덤값: 임의의 추출값)
        // import java.lang.Math (Math 클래스)
        // java.lang 하위폴더들은 자바에서 자주 사용하기 때문에 이미 import가 되어 있다. (default로 오픈된 박스)
        // default > java.lang > import 내부적으로...
        // java.lang 안에 있는 자원은 import 없이 사용가능하다
        // Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
        // Math.random() 자원은 random() 함수가 static 이기 때문에 객체 생성 없이도 사용 가능하다.
        // 결과: 0.0 <= random < 1.0의 dobule 타입의 값을 추출
        
        
        System.out.println("Math.random(): " + Math.random()); // double 타입
        System.out.println("Math.random() * 10: " + Math.random() * 10);
        // 0~9까지의 정수
        System.out.println("0~9까지의 정수: " + (int)(Math.random() * 10));
        // 1~10까지의 정수
        System.out.println("1~10까지의 정수: " + (int)(Math.random() * 10 + 1));
        
        /*
         * 개별 Quiz
         * 만들려고 하는 시스템은 백화점 경품 추첨 시스템입니다.
         * 경품 추첨시 1000 점수가 나오면
         * 경품으로 Tv, NoteBook, 냉장고, 한우세트, 휴지
         * 경품 추첨시 900 점수가 나오면
         * 경품으로 NoteBook, 냉장고, 한우세트, 휴지
         * 경품 추첨시 800 점수가 나오면
         * 경품으로 냉장고, 한우세트, 휴지
         * 경품 추첨시 700 점수가 나오면
         * 경품으로 한우세트, 휴지
         * 경품 추첨시 600 점수가 나오면
         * 경품으로 휴지
         * 그 외는 100 ~ 500 까지는 칫솔
         * 
         * 사용자가 와서 경품 시스템을 사용하게 되면 랜덤하게 100 ~ 1000까지의 점수가 나온다.
         */
        
	}
}