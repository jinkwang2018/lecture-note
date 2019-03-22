/**
 프로젝트 : 비트코인 캠프 시스템
 파일이름 : BitCoinCamp.java
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
*/

package kr.or.bit.Three;

import java.util.Scanner;

/**
 클래스명 : BitCoinCamp
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
 */
public class BitCoinCamp {
	
	private Scanner sc;
	private Member member; // 사용자가 학생, 선생님, 행정직원 누가 들어올지 몰라서 부모타입으로 선언
	
	public BitCoinCamp() {
		sc = new Scanner(System.in);
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : 메인화면으로 사용자(학생, 선생님, 행정직원)의 맞는 화면을 보여줌
	 작성자명 : 김 희 준
	 */
	public void start() {
		login();
		System.out.println("로그인이 되었습니다.");
		
		int menu = 0;
		if(member instanceof Student) { // 학생으로 로그인했을 때
			do {
				printStudnetMenu();
				try {
					menu = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					menu = 0;
					continue;
				}
				switch (menu) {
				case 1:
					((Student) member).attending();
					break;
				case 2:
					((Student) member).attendingCheck();
					break;
				case 3:
					((Student) member).consultinCheck();
					break;
				case 4:
					((Student) member).consultingAdd();
					break;
				case 5:
					((Student) member).scoreCheck();
					break;
				case 6:
					System.out.println("종료되었습니다.");
					break;
				default:
					break;
				}
			}while(menu != 6);
		}else if(member instanceof Teacher) { // 선생님으로 로그인했을 때
			do {
				printTeacherMenu();
				try {
					menu = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					menu = 0;
					continue;
				}
				
				switch (menu) {
				case 1:
					((Teacher) member).lectureAddLecture();
					break;
				case 2:
					((Teacher) member).lectureChecking();
					break;
				case 3:
					((Teacher) member).lectureDelete();
					break;
				case 4:
					((Teacher) member).scoreManagement();
					break;
				case 5:
					((Teacher) member).scoreModify();
					break;
				case 6:
					System.out.println("종료 되었습니다.");
					break;
				default:
					break;
				}
			}while(menu != 6);
		}else if(member instanceof Staff) { // 행정직원으로 로그인했을 때
			do {
				printStaffMenu();
				try {
					menu = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					menu = 0;
					continue;
				}
				switch (menu) {
				case 1:
					((Staff) member).userManagement();
					break;
				case 2:
					System.out.println("종료 되었습니다.");
					break;
				default:
					break;
				}
			}while(menu != 2);
		}
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : 사용자로부터 ID와 비밀번호를 입력받아서 UserList에 같은 아이디와 비밀번호가 있는지 확인
	 작성자명 : 김 희 준
	 */
	private void login() {
		while(true) {
			System.out.println("ID를 입력하세요.");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력하세요.");
			String password = sc.nextLine();
			
			if(UserLists.getInstance().getStudentList().containsKey(id)) {
				if(UserLists.getInstance().getStudentList().get(id).getPassword().equals(password)) {
					member = UserLists.getInstance().getStudentList().get(id); // 학생이면 member에 Student를 넣음(다형성 이용)
					break;
				}else {
					System.out.println("ID와 비밀번호를 확인해주세요");
				}
			}else if(UserLists.getInstance().getTeacherList().containsKey(id)) {
				if(UserLists.getInstance().getTeacherList().get(id).getPassword().equals(password)) {
					member = UserLists.getInstance().getTeacherList().get(id); //선생님이면 member에 Teacher를 넣음(다형성 이용)
					break;
				}else {
					System.out.println("ID와 비밀번호를 확인해주세요");
				}
			}else if(UserLists.getInstance().getStaffList().containsKey(id)) {
				if(UserLists.getInstance().getStaffList().get(id).getPassword().equals(password)) {
					member = UserLists.getInstance().getStaffList().get(id); // 행정직원이면 member에 Teacher를 넣음(다형성 이용)
					break;
				}else {
					System.out.println("ID와 비밀번호를 확인해주세요");
				}
			}else {
				System.out.println("ID와 비밀번호를 확인해주세요");
			}
		}
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : 학생 메뉴 출력하는 함수
	 작성자명 : 김 희 준
	 */
	private void printStudnetMenu() {
		System.out.println("메뉴를 입력해주세요.");
		System.out.println("1. 출석	2. 출석확인	3. 상담확인	4. 상담추가	5. 점수확인	6. 종료");
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : 선생님 메뉴 출력하는 함수
	 작성자명 : 김 희 준
	 */
	private void printTeacherMenu() {
		System.out.println("메뉴를 입력해주세요.");
		System.out.println("1. 강좌개설 2.강좌확인 3.강좌삭제 4.점수등록 5.점수수정	6.종료");
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : 행정직원 메뉴 출력하는 함수
	 작성자명 : 김 희 준
	 */
	private void printStaffMenu() {
		System.out.println("메뉴를 입력해주세요.");
		System.out.println("1. 회원관리	2. 종료");
	}
}
