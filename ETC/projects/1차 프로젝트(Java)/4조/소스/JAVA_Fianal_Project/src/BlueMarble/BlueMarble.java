package BlueMarble;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class BlueMarble {
	HashMap<Integer, Block> block = new HashMap<>();//블럭 해시맵으로 저장
	ArrayList<Player> player = new ArrayList<>(); //플레이어 저장
	Dice diceobj = new Dice(); //주사위 생성
	Timeout to = new Timeout();  //시간제한 클래스 생성
	Calender cal = new Calender(); //날자 시간 클래스 생성

	public static void clearScreen() {  //콘솔 화면 초기화 함수
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}

	public BlueMarble() {
		init(); //생성 및 초기화후 콜렉션에 저장하는 함수
	}

	void init() {//생성 및 초기화후 콜렉션에 저장하는 함수
		block.put(1, new StartArea(1, "START"));
		block.put(2, new City(2, "홍콩", 10, 30, 20, 40, 30, 55));
		block.put(3, new City(3, "싱가폴", 20, 40, 30, 50, 40, 65));
		block.put(4, new City(4, "아테네", 30, 50, 40, 60, 50, 75));
		block.put(5, new City(5, "베를린", 40, 60, 50, 80, 60, 90));
		block.put(6, new Island(6, "무인도"));
		block.put(7, new City(7, "하와이", 55, 80, 70, 100, 80, 120));
		block.put(8, new City(8, "리스본", 60, 85, 80, 120, 90, 130));
		block.put(9, new City(9, "제주도", 80, 100, 90, 130, 100, 140));
		block.put(10, new City(10, "시드니", 50, 70, 60, 90, 70, 100));
		block.put(11, new City(11, "도쿄", 70, 110, 100, 140, 110, 150));
		block.put(12, new City(12, "파리", 75, 120, 110, 150, 120, 160));
		block.put(13, new City(13, "로마", 85, 125, 120, 160, 130, 170));
		block.put(14, new City(14, "런던", 90, 130, 130, 170, 140, 180));
		block.put(15, new City(15, "뉴욕", 100, 140, 140, 180, 150, 190));
		block.put(16, new City(16, "LA", 110, 150, 150, 190, 160, 200));
		block.put(17, new City(17, "서울", 120, 160, 160, 200, 170, 250));
		block.put(18, new Tax(18, "세관"));

		String userName1 = JOptionPane.showInputDialog("p1의 이름을 입력하세요");//플레이어 생성 및 저장
		player.add(new Player(1, userName1));
		String userName2 = JOptionPane.showInputDialog("p2의 이름을 입력하세요");
		player.add(new Player(2, userName2));
	}

	void map() {//맵 출력 함수
		System.out.println("-------------------------------------------------------------");
		System.out.println("현재 남은시간은 : " + Timeout.i + "초 입니다.");
		System.out.println("┌─────────┬─────────┬─────────┬─────────┬─────────┬─────────┐");
		System.out.println("│ " + block.get(1).p1 + "   " + block.get(1).p2 + " │ " + block.get(2).p1 + "   "
				+ block.get(2).p2 + " │ " + block.get(3).p1 + "   " + block.get(3).p2 + " │ " + block.get(4).p1 + "   "
				+ block.get(4).p2 + " │ " + block.get(5).p1 + "   " + block.get(5).p2 + " │ " + block.get(6).p1 + "   "
				+ block.get(6).p2 + " │");
		System.out.println("│  " + block.get(1).getName() + "  │   " + block.get(2).getName() + "         │   "
				+ block.get(3).getName() + "      │   " + block.get(4).getName() + "      │   " + block.get(5).getName()
				+ "      │   " + block.get(6).getName() + "      │");
		System.out.println("│         │" + ((City) (block.get(2))).getOwner() + " │"
				+ ((City) (block.get(3))).getOwner() + " │" + ((City) (block.get(4))).getOwner() + " │"
				+ ((City) (block.get(5))).getOwner() + " │         │");
		System.out.println("│         │   " + ((City) (block.get(2))).getStructure() + "   │   "
				+ ((City) (block.get(3))).getStructure() + "   │   " + ((City) (block.get(4))).getStructure()
				+ "   │   " + ((City) (block.get(5))).getStructure() + "   │         │");
		System.out.println("├─────────┼─────────┴─────────┴─────────┴─────────┼─────────┤");
		System.out.println("│ " + block.get(18).p1 + "   " + block.get(18).p2
				+ " │                                       │ " + block.get(7).p1 + "   " + block.get(7).p2 + " │");
		System.out.println("│   " + block.get(18).getName() + "         │                                       │   "
				+ block.get(7).getName() + "      │");
		System.out.println(
				"│         │                                       │" + ((City) (block.get(7))).getOwner() + " │");
		System.out.println("│         │                                       │   "
				+ ((City) (block.get(7))).getStructure() + "   │");
		System.out.println("├─────────┤                                       ├─────────┤");
		System.out.println("│ " + block.get(17).p1 + "   " + block.get(17).p2
				+ " │                                       │ " + block.get(8).p1 + "   " + block.get(8).p2 + " │");
		System.out.println("│   " + block.get(17).getName() + "         │                                       │   "
				+ block.get(8).getName() + "      │");
		System.out.println("│" + ((City) (block.get(17))).getOwner() + " │                                       │"
				+ ((City) (block.get(8))).getOwner() + " │");
		System.out.println("│   " + ((City) (block.get(17))).getStructure()
				+ "   │                                       │   " + ((City) (block.get(8))).getStructure() + "   │");
		System.out.println("├─────────┤                                       ├─────────┤");
		System.out.println("│ " + block.get(16).p1 + "   " + block.get(16).p2
				+ " │                                       │ " + block.get(9).p1 + "   " + block.get(9).p2 + " │");
		System.out.println("│   " + block.get(16).getName() + "    │                                       │   "
				+ block.get(9).getName() + "      │");
		System.out.println("│" + ((City) (block.get(16))).getOwner() + " │                                       │"
				+ ((City) (block.get(9))).getOwner() + " │");
		System.out.println("│   " + ((City) (block.get(16))).getStructure()
				+ "   │                                       │   " + ((City) (block.get(9))).getStructure() + "   │");
		System.out.println("├─────────┼─────────┬─────────┬─────────┬─────────┼─────────┤");
		System.out.println("│ " + block.get(15).p1 + "   " + block.get(15).p2 + " │ " + block.get(14).p1 + "   "
				+ block.get(14).p2 + " │ " + block.get(13).p1 + "   " + block.get(13).p2 + " │ " + block.get(12).p1
				+ "   " + block.get(12).p2 + " │ " + block.get(11).p1 + "   " + block.get(11).p2 + " │ "
				+ block.get(10).p1 + "   " + block.get(10).p2 + " │");
		System.out.println("│   " + block.get(15).getName() + "         │   " + block.get(14).getName()
				+ "         │   " + block.get(13).getName() + "         │   " + block.get(12).getName()
				+ "         │   " + block.get(11).getName() + "         │   " + block.get(10).getName() + "      │");
		System.out.println("│" + ((City) (block.get(15))).getOwner() + " │" + ((City) (block.get(14))).getOwner() + " │"
				+ ((City) (block.get(13))).getOwner() + " │" + ((City) (block.get(12))).getOwner() + " │"
				+ ((City) (block.get(11))).getOwner() + " │         │");
		System.out.println("│   " + ((City) (block.get(15))).getStructure() + "   │   "
				+ ((City) (block.get(14))).getStructure() + "   │   " + ((City) (block.get(13))).getStructure()
				+ "   │   " + ((City) (block.get(12))).getStructure() + "   │   "
				+ ((City) (block.get(11))).getStructure() + "   │         │");
		System.out.println("└─────────┴─────────┴─────────┴─────────┴─────────┴─────────┘");
		System.out.println("p1 : " + "[" + player.get(0).getName() + "] " + player.get(0).getBudget()+"만원");
		System.out.println("p2 : " + "[" + player.get(1).getName() + "] " + player.get(1).getBudget()+"만원");
		System.out.println("-------------------------------------------------------------");
	}

	public void start() { //게임 로직
		to.start();  //시간 제한 쓰레드 작동
		int dice = 0; //주사위 리턴값 담을 변수
		int location = 1; //플레이어 위치 담을 변수
		int cost = 0; //비용 담을 블럭

		block.get(location).playerToken(1, true); //시작점에 플레이어의 말 위치시키기
		block.get(location).playerToken(2, true);
		clearScreen();
		map(); // 처음 맵 상태 출력

		while (true) {
			if (Timeout.i != 0) { //제한시간 종료시 두번쨰 플레이어까지 턴 진행후 게임 종료
				if (((Island) (block.get(6))).isP1island()) { //값이 true이면 무인도에서 한턴 쉰다.
					
					
					System.out.println("["+player.get(0).getName()+"]은 한턴 쉽니다.");
					((Island) (block.get(6))).setP1island(false);//다시 값을 false로 초기화
				} else {
					System.out.println("["+player.get(0).getName()+"]님의 차례입니다!");
					location = player.get(0).getLocation(); // 주사위 돌리기 전에 위치 가져오기
					block.get(location).playerToken(1, false); // 가져온 위치의 블럭에서 내 말 지우기
					dice = player.get(0).dice(diceobj); // 주사위 돌리고 그 값 리턴해주기
					player.get(0).move(dice); // 주사위 수만큼 플레이어 location 변경해주는 함수 호출
					location = player.get(0).getLocation(); // 주사위 돌리고 난 후의 플레이어 위치 가져오기
					block.get(location).playerToken(1, true); // 가져온 위치의 블럭에서 내 말 표시해주기
					clearScreen();
					map();
					if (block.get(location) instanceof City) { // 도착한 땅이 도시이면
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						City city = (City) (block.get(location));
						if (city.getOwner() == "        ") { // 도착한 땅의 주인이 없으면
							player.get(0).buy(city); // 구매 행위를 한다.
							clearScreen();
							map();
							System.out.println("구매행위 끝!!");
						} else if (city.getOwner().equals("Owner:p1")) { // 도착한땅이 주인이 자신이면
							// 아무일도 안일어난다.
						} else if (city.getOwner().equals("Owner:p2")) { // 도착한 땅의 주인이 p2이면
							clearScreen();
							map();
							System.out.println("상대 땅에 걸렸습니다!!");
							cost = city.getCost(); // 땅의 가격 반환해서 cost변수에 넣어줌
							System.out.println("금액은 [" + cost + "만원] 입니다.");
							player.get(0).calculation(cost); // 플레이어는 cost의 금액만큼 계산을 한다.
							if (player.get(0).getBudget() < 0) { //돈이 0원이면 게임 종료
								break;
							}
						}
					} else if (block.get(location) instanceof Tax) {//도착한 블럭이 세관이면
						clearScreen();
						map();
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						System.out.println("세관에 도착 하셨습니다. 세금 [100만원]을 지불합니다.");
						Tax tax = (Tax) (block.get(location));
						cost = tax.getCost();
						player.get(0).calculation(cost);
						if (player.get(0).getBudget() < 0) {//돈이 0원이면 게임 종료
							break;
						}
					} else if (block.get(location) instanceof StartArea) {//시작점에 도착할경우
						clearScreen();
						map();
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						System.out.println("시작점에 도착 하셨습니다. 월급 [50만원]을 받습니다.");
						StartArea startarea = (StartArea) (block.get(location));
						cost = startarea.getCost();
						player.get(0).calculation(-cost); //돈 추가해줘야하기 때문에 -붙임
					} else if (block.get(location) instanceof Island) {//무인도 도착시
						clearScreen();
						map();
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						System.out.println("무인도에 도착했습니다. 다음턴까지 움직일 수 없습니다.");
						Island island = (Island) (block.get(location)); 
						island.setP1island(true); //값을 true로 변경
					}
				}
				//플레이어 1로직과 동일
				if (((Island) (block.get(6))).isP2island()) {
				
					System.out.println("["+player.get(1).getName()+"]은 한턴 쉽니다.");
					((Island) (block.get(6))).setP2island(false);
				} else {
					// player2
					System.out.println("["+player.get(1).getName()+"]님의 차례입니다!");
					location = player.get(1).getLocation(); 
					block.get(location).playerToken(2, false); 
					dice = player.get(1).dice(diceobj); 
					player.get(1).move(dice); 
					location = player.get(1).getLocation();
					block.get(location).playerToken(2, true); 
					clearScreen();
					map();
					if (block.get(location) instanceof City) { 
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						City city = (City) (block.get(location));
						if (city.getOwner() == "        ") { 
							player.get(1).buy(city); 
							clearScreen();
							map();
							System.out.println("구매행위 끝!!");
						} else if (city.getOwner().equals("Owner:p2")) { 
							
						} else if (city.getOwner().equals("Owner:p1")) { 
							cost = city.getCost(); 
							clearScreen();
							map();
							System.out.println("상대방 땅에 걸렸습니다.");
							System.out.println("지불할 금액은 [" + cost + "만원] 입니다!!");

							player.get(1).calculation(cost); 
							if (player.get(1).getBudget() < 0) {
								break;
							}
						}
					} else if (block.get(location) instanceof Tax) {
						clearScreen();
						map();
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						System.out.println("세관에 도착 하셨습니다. 세금 100만원을 지불합니다.");
						Tax tax = (Tax) (block.get(location));
						cost = tax.getCost();
						player.get(1).calculation(cost);
						if (player.get(1).getBudget() < 0) {
							break;
						}
					} else if (block.get(location) instanceof StartArea) {
						clearScreen();
						map();
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						System.out.println("시작점에 도착 하셨습니다. 월급 50만원을 받습니다.");
						StartArea startarea = (StartArea) (block.get(location));
						cost = startarea.getCost();
						player.get(1).calculation(-cost);
					} else if (block.get(location) instanceof Island) {
						clearScreen();
						map();
						System.out.println("주사위 결과는 ["+dice+"] 입니다.");
						System.out.println("무인도에 도착했습니다. 다음턴까지 움직일 수 없습니다.");
						Island island = (Island) (block.get(location));
						island.setP2island(true);
					}
				}
				
			} else {
				break;
			}
		}
		//파일 입출력 부분 (게임의 결과를 날짜, 시간과 같이 저장한다.)
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("score.txt",true));
			String s = null;
			String date = "["+cal.calender()+"]";
			if (player.get(0).getBudget() < player.get(1).getBudget()) {
				s= player.get(1).getName() + "님 승리!! "+player.get(0).getName() + "님 패배!!";
				out.write(date);
				out.newLine();
				out.write(s);
				out.newLine();
			} else {
				s=player.get(0).getName() + "님 승리!! "+player.get(1).getName() + "님 패배!!";
				out.write(date);
				out.newLine();
				out.write(s);
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			System.out.println("문제있음");
		}
		System.out.println("게임이 끝나고 결과가 저장 되었습니다.");
	}
}
