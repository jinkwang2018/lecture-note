import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex13_HashMap_Quiz {
	public static void main(String[] args) {
		//시스템에 로그인 하는 시나리오
		//ID(o), PWD(o) >> 회원 (환영)
		//ID(o), PWD(x) >> 실패 (비번 다시 입력)
		
		//ID(x), PWD(x) >> 실패 (다시 입력)
		//ID(x), PWD(o)
		
		//Scanner 사용해서 ID, PWD 입력받으세요
		//loginmap 통해서 검증 로직 처리
		//ID 또는 PWD 틀리면 다시 입력 요청
		//ID, PWD 다 맞으면 회원님 방문 환영합니다 (출력 프로그램 종료)
		
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("ID , PWD 입력해 주세요");
			System.out.print("ID:");
			String id = sc.nextLine().trim().toLowerCase();
			
			System.out.print("PWD:");
			String pwd = sc.nextLine().trim();
			
			if(!loginmap.containsKey(id)) {
				System.out.println("ID 틀려요 재입력 하세요");
			}else {
				if(loginmap.get(id).equals(pwd)) { //loginmap.get(id) >> value return
					System.out.println("회원님 방가방가 ^^");
					break;
				}else {
					System.out.println("비번 확인 하세요");
				}
			}
		}
		
		/*내가 짠 코드
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("ID 입력: ");
			String id = sc.nextLine();
			
			System.out.print("PWD 입력: ");
			String pwd = sc.nextLine();
			
			if(loginmap.containsKey(id)) {
				if(loginmap.get(id).equals(pwd)) {
					System.out.println(id + " 회원님 방문을 환영합니다.");
					break;
				}else {
					System.out.println("비밀번호를 다시 입력 해주세요.");
				}
			}else {
				System.out.println("해당 아이디가 없습니다. 다시 입력 해주세요.");
			}
		}while(true);
		*/
	}
}
