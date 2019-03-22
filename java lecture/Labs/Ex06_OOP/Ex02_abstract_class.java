/*
스타크래프트
유닛(unit)

unit 공통기능 (이동좌표, 이동, 멈춘다)
unit 이동 방법은 다르다 (unit 마다 이동방법은 다르다)
abstract class 이름 { abstract method 강제 구현 }

 */

abstract class Unit {
	int x, y;
	
	void stop() {
		System.out.println("Unit Stop");
	}
	//이동...
	abstract void move(int x, int y); // { 날아간다 }, { 걸어간다 }
}

//move 추상화 -> 구체화 (특수화)
class Tank extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank 이동: " + this.x + ", " + this.y);
	}
	//Tank가 가지는 구체화(특수화) 고유한 기능
	void changeMode() {
		System.out.println("탱크 변환 모드");
	}
	//필요하다면 구현...
}

class Marine extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine 이동: " + this.x + ", " + this.y);
	}
	
	void stimpack() {
		System.out.println("스팀팩기능");
	}
}

class DropShip extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("공중 이동: " + this.x + ", " + this.y);
	}
	void load() {
		System.out.println("Unit load");
	}
	void unload() {
		System.out.println("Unit unload");
	}
}

public class Ex02_abstract_class {
	public static void main(String[] args) {
		Tank t = new Tank();
		t.move(100, 200);
		t.stop();
		t.changeMode();
		
		Marine m = new Marine();
		m.move(300, 200);
		m.stop();
		m.stimpack();
		
		//1.Quiz 탱크 3대를 만들고 [같은 좌표]로 이동시키세요
		//hint) 같은 타입 여러개 (객체 배열)
		Tank[] tankarray = {new Tank(), new Tank(), new Tank()};
		//개선된 for문
		/*for(Tank ta : tankarray) {
			ta.move(10, 50);
		}*/
		for(int i = 0; i < tankarray.length; i++) {
			tankarray[i].move(555, 333);
		}
		
		//내가 짠 코드
		/*Tank[] tt = new Tank[3];
		for(Tank v : tt) {
			v = new Tank();
			v.move(400, 500);
		}*/
		
		//2.여러개의 Unit (Tank, Marine, Dropship) 같은 좌표로 이동 시키세요
		//hint 다형성(부모타입) >> 전자제품 void buy(Product p) {}
		//					>> 전자제품 cart >> Product[] cart = new Product[10]; 
		Unit[] unitarray = {new Tank(), new Marine(), new DropShip()};
		//부모가 가지는 move 강제 구현
		for(Unit unit : unitarray) {
			unit.move(111, 222);
		}
		
		//내가 짠 코드
		/*Tank t2 = new Tank();
		Marine m2 = new Marine();
		DropShip d2 = new DropShip();
		
		Unit u = t2;
		u.move(600, 700);
		u = m2;
		u.move(600, 700);
		u = d2;
		u.move(600, 700);*/
	}
}
