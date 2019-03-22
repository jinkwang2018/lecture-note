import java.util.Scanner;
/*
날      짜: 2018-02-23
작성자명: 정희섭
기      능: Main UI
*/
public class UI {

	public Bitgram bgm;
	Scanner sc = new Scanner(System.in);
	
	public UI() {
		bgm = new Bitgram();
	}
	
	public void start() { //Main UI 실행 함수
		bgm.makeFirstFile(); //파일검사 함수 호출
		
		while(true) {
	    System.out.println();
		System.out.println("===================================");
		System.out.println("*--------- B I T G R A M ---------*");
		System.out.println("원하시는 메뉴를 입력해 주세요");
		System.out.println("1) 로그인");
		System.out.println("2) 회원가입");
		System.out.println("3) 종료");
							
		try {

				System.out.print("입력 > ");
				int select = Integer.parseInt(sc.nextLine());
				
				if (select==1){   // 로그인
					System.out.print("ID : ");
					Main.id = sc.nextLine();
					
					System.out.print("PASSWORD : ");
					String pwd = sc.nextLine();
					bgm.login(Main.id, pwd);		
					//로그인시 프린트로 가도록
				}
				
				else if(select==2) { // 회원가입
					System.out.println("회원 가입");
					bgm.register();
					continue;
				}
				else if(select==3) { //프로그램 종료
					System.out.println("*--------- G O O D-B Y E ---------*");
					System.exit(0);
				}
				else {
					System.out.println("1번과 2번중 하나를 입력해주세요");
				}
			} catch (Exception e) {
				System.out.println("1번과 2번중 하나를 입력해주세요");
				continue;
			}
		} // end - while
		
	} // end - Main

} // end - class
