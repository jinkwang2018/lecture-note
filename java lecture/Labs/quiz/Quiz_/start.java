package Quiz_;
/*
������ ���۵ȴ�..
������ ������ 6���̴�. ������ ���� hp�� ������ �ְ� 
������ modern�� past�� ���� ������.
������ ������ ������ ������ ������ �ٸ��� . 
modern���� sniper,assulter,healer�̴�.
past ���� bowman,sword, docter�̴�. 
sniper (damage : 100 , hp : 50)
assulter (damage : 50, hp : 100)
healer (ȸ���ɷ��� �ְ� ,hp : 150)
bowman (damage : 100 , hp : 50)
sword (damage : 50, hp : 100)
docter (ȸ���ɷ��� �ְ� ,hp : 150)�� �ʱⰪ�� �����Ǿ� �ִ�.
������ ���� ������ ����� ������� hp�� �ް� �� �� �ִ�.

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
