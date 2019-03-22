package HashMap_Quiz;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 이름을 입력해주세요->김유신

1.조회 2.예약 3.예약자취소 4.관리자취소 5.종료(기능) 6.로그인(김유신)
원하시는 서비스를 선택해주세요->1
좌석조회 서비스 입니다.



1.조회 2.예약 3.예약자취소 4.관리자취소 5.종료(기능) 6.로그인(김유신)
원하시는 서비스를 선택해주세요->2
열을 선택하세요->2
행을 선택하세요->1
2열1행 좌석이 예약되었습니다.



1.조회 2.예약 3.예약자취소 4.관리자취소 5.종료(기능) 6.로그인(김유신)
원하시는 서비스를 선택해주세요->
*/
class Movie{
	String[][] seat = new String[4][9];
	void system() {
			
			System.out.println("1.조회 2.예약 3.예약자취소 4.관리자취소 5.종료(기능) 6.로그인(김유신)");
			Scanner Sc = new Scanner(System.in);
			int k = Integer.parseInt(Sc.nextLine());	
			
			switch(k) {
			case 1 : System.out.println("1. 조회");
			inq();
			break;
			case 2 : System.out.println("2. 예약");
			inq();
			reser();
			
			
			break;
			case 3 : System.out.println("3. 예약자 취소");
			
			break;
			case 4 : System.out.println("4. 관리자 취소");
			
			break;
			case 5 : System.out.println("5. 종료");
			
			break;
			case 6 : System.out.println("6. 로그인(김유신)");
			
			break;
			}
			
		
			
		}


	
	void inq() {
		for(int i = 0 ; i < seat.length ; i++) {
			for(int j = 0 ; j < seat[i].length ; j++) {
				if(j==0) {
				 seat[i][j] = i+"행";
				}else{seat[i][j] = j+"◻︎";}
				System.out.printf("%s " , seat[i][j]);
			}System.out.println();
		}
		
	}
	void reser() {
		System.out.println("원하시는 행을 입력하세요");
		Scanner Sc1 = new Scanner(System.in);
		int god = Integer.parseInt(Sc1.nextLine());
		System.out.println("원하시는 열을 입력하세요");
		Scanner Sc2 = new Scanner(System.in);
		int duf = Integer.parseInt(Sc2.nextLine());
		seat[god][duf] = duf+"◼︎";
		for(int i = 0 ; i < seat.length ; i++) {
			for(int j = 0 ; j < seat[i].length ; j++) {
				if(j==0) {
				 seat[i][j] = i+"행";
				}else{seat[i][j] = j+"◻︎";}
				seat[god][duf] = duf+"◼︎";
				System.out.printf("%s " , seat[i][j]);
			}System.out.println();
		}
	}
	void cancel() {
		
		
	}
	
}
public class Second_Quiz {

	public static void main(String[] args) {
		Movie m = new Movie();
		m.system();
	}

}
