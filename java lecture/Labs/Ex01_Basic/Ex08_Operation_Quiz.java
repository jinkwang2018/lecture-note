import java.util.Scanner;

/*
간단한 사칙 연산기 (+, -, *, /)
입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자로 변환)
목적: Integer.parseInt(), equals() 활용

화면
> 입력값1(숫자): 100
> 입력값(기호): +
> 입력값2: 숫자
> 연산결과(숫자): 200

기호 받는 건)
String opr = sc.nextLine();

hint) if() {}, else if() {}
hint) if(opr == "+") { 더하기 연산할거야 } // 쓰지말고 -> 문자열 String은 주소값을 가지기 때문에 아래의 opr.equals("+")을 사용

*질문) 문자를 숫자로 어떻게 바꿀껀가요? Integer.parseInt(s)

TODAY POINT
**문자열에 대한 비교는 == 아니고 (equals() 함수를 사용한다)

hint) if(opr.equals("+")) { 더하기 연산 }
 */
public class Ex08_Operation_Quiz {
	public static void main(String[] args) {
		String opr = ""; // 초기화
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자1: ");
		num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산기호(+, -, *, /): ");
		opr = sc.nextLine();
		
		System.out.print("숫자2: ");
		num2 = Integer.parseInt(sc.nextLine());
		
		// 방법 1: if문 사용
		if(opr.equals("+")) result = num1 + num2;
		else if(opr.equals("-")) result = num1 - num2;
		else if(opr.equals("*")) result = num1 * num2;
		else if(opr.equals("/")) result = num1 / num2;
		else {
			System.out.println("지원하지 않는 연산자 입니다.");
			// Key point
			// return 키워드: [함수단위]의 종결자 > main 함수 탈출 > 종료
			return;
		}
		
		// 방법 2: switch문 사용
		/*switch (opr) {
			case "+": result = num1 + num2; break;
			case "-": result = num1 - num2; break;
			case "*": result = num1 * num2; break;
			case "/": result = num1 / num2; break;
			default:
				System.out.println("지원하지 않는 연산자입니다.");
				return;
		}*/
		
		System.out.printf("결과: [%d %s %d = %d]", num1, opr, num2, result);
	}
}
