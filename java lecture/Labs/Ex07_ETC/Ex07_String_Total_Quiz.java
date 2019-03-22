import java.util.Scanner;

//주민번호: 뒷번호 첫자리: 1,3,남자 / 2,4 여자라고 출력...

//main함수 Scanner 사용 주민번호 입력받고
//앞: 6자리 뒷: 7자리
//입력값: 123456-1234567

//1. 자리수 체크 (기능) 함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 / 2,4 여자 출력 기능함수
//3개의 함수 static

public class Ex07_String_Total_Quiz {
	static boolean checkLength(String ssn) {
			return (ssn.length() == 14);
	}
	
	static boolean checkHuman(String ssn) {
		int gender = Integer.parseInt(String.valueOf(ssn.charAt(ssn.indexOf("-") + 1)));
		return (gender >= 1 && gender <= 4);
	}
	
	static void print(String ssn) {
		int gender = Integer.parseInt(String.valueOf(ssn.charAt(ssn.indexOf("-") + 1)));
		String genderStr="";
		if(gender == 1 || gender == 3) {
			genderStr = "남자";
		}else {
			genderStr = "여자";
		}
		
		System.out.println("주민번호: " + ssn + " / " + genderStr);
	}
	
	public static void main(String[] args) {
		String ssn="";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("주민번호 입력(123456-1234567): ");
			ssn = sc.nextLine();
			if(checkLength(ssn) && checkHuman(ssn)) break;
		}while(true); //while(자리check 함수, 1~4까지 check 함수) (1번, 2번 함수)
		print(ssn);
	}
}
