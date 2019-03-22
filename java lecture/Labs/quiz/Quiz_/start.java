package Quiz_;
/*
게임이 시작된다..
게임의 유저는 6명이다. 유저는 각각 hp를 가지고 있고 
유저는 modern과 past로 팀이 나뉜다.
각각의 팀마다 가지는 직업의 종류가 다르다 . 
modern팀은 sniper,assulter,healer이다.
past 팀은 bowman,sword, docter이다. 
sniper (damage : 100 , hp : 50)
assulter (damage : 50, hp : 100)
healer (회복능력이 있고 ,hp : 150)
bowman (damage : 100 , hp : 50)
sword (damage : 50, hp : 100)
docter (회복능력이 있고 ,hp : 150)로 초기값이 설정되어 있다.
서로의 팀은 각각의 무기로 상대편의 hp를 달게 할 수 있다.

*/
public class start {

	public static void main(String[]args) {
		Sniper s = new Sniper();
		Assaulter a = new Assaulter();
		Healer h = new Healer();
		Bowman b = new Bowman();
		Swordman w = new Swordman();
		Doctor d = new Doctor();
		s.shoot(w);
		System.out.println(Swordman.hp);
	}


}
