package BlueMarble;

import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Player {
	
	private int id; // 플레이어 id
	private String name;//이름
	private int location = 1;// 본인위치
	private int budget=500; // 예산
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getLocation() {
		return location;
	}
	public int getBudget() {
		return budget;
	}
	public int dice(Dice dice) {   // 주사위 굴리는 고 값 리턴해주는 함수
		int dicetemp=0;
		System.out.println("****주사위를 굴려주세요****");

		while(dicetemp==0) {            //입력값으로 테스트를 하고 싶으시면 여기부터 네줄을 주석처리하고 아래 주석을 풀어주세요 
			dicetemp = dice.diceNum();
			System.out.print("");
		}
		
//		Scanner s = new Scanner(System.in); //아래 두줄 : 테스트용 입력 
//		dicetemp = s.nextInt();
		
		return dicetemp;  //주사위 값 리턴
	}
	public void move(int diceNumber) {  //이동하는 함수 18로 나눈 나머지를 넣어서 순환 하도록 설계
		location = (location+diceNumber)%18;
		if(location == 0) {
			location = 18;
		}
	}

	void buy(City city) { //건물 구매 함수
		int choice =0;
		if (city.getLand() < budget) {  //가장 낮은 가격보다 낮으면 살수 없음.
			while (true) {
				Scanner s = new Scanner(System.in);
				System.out.println("무엇을 구매하시겠습니까?");
				System.out.println("땅 :1  호텔 :2  빌딩 :3 안사요 :4");

				choice = Integer.parseInt(s.nextLine());
				if(choice == 1) {
					budget -= city.getLand();          //땅 가격만큼 예산 감소
					city.setCost(city.getLandpay());  //구매한 것에 맞는 통행료 저장
					city.setStructure("[L]");         //땅 표시 
					break;
				}else if(choice == 2) {
					if(city.getHotel()<budget) {      //이도시의 호텔을 살수 있는지 확인
						budget -= city.getHotel();      //호텔 가격만큼 차감
						city.setCost(city.getHotelpay());  //통행료 저장
						city.setStructure("[H]");          //호텔 표시
						break;
					}else {                              //돈이 부족할시
						System.out.println("호텔을 사기엔 돈이 부족합니다.");
					}
				}else if(choice == 3) {
					if(city.getBuilding()<budget) {   //위와 동일
						budget -= city.getBuilding();
						city.setCost(city.getBuildingpay());
						city.setStructure("[B]");
						break;
					}else {
						System.out.println("빌딩을 사기엔 돈이 부족합니다.");
					}
				}else if(choice == 4) {
					System.out.println("아무것도 사지 않습니다.");
					break;
				}else{
					System.out.println("1,2,3,4 중에 하나를 선택해 주세요!");
				}
				
				
				
			}
			if(choice != 4) {
				city.setOwner(id);   //주인 표시 
			}
		} else {
			System.out.println("돈이 부족합니다.");
		}

	}
	
	void calculation(int cost) {
		budget -= cost;
	}
}
