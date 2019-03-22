/*
��Ÿũ����Ʈ
����(unit)

unit ������ (�̵���ǥ, �̵�, �����)
unit �̵� ����� �ٸ��� (unit ���� �̵������ �ٸ���)
abstract class �̸� { abstract method ���� ���� }

 */

abstract class Unit {
	int x, y;
	
	void stop() {
		System.out.println("Unit Stop");
	}
	//�̵�...
	abstract void move(int x, int y); // { ���ư��� }, { �ɾ�� }
}

//move �߻�ȭ -> ��üȭ (Ư��ȭ)
class Tank extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank �̵�: " + this.x + ", " + this.y);
	}
	//Tank�� ������ ��üȭ(Ư��ȭ) ������ ���
	void changeMode() {
		System.out.println("��ũ ��ȯ ���");
	}
	//�ʿ��ϴٸ� ����...
}

class Marine extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine �̵�: " + this.x + ", " + this.y);
	}
	
	void stimpack() {
		System.out.println("�����ѱ��");
	}
}

class DropShip extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("���� �̵�: " + this.x + ", " + this.y);
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
		
		//1.Quiz ��ũ 3�븦 ����� [���� ��ǥ]�� �̵���Ű����
		//hint) ���� Ÿ�� ������ (��ü �迭)
		Tank[] tankarray = {new Tank(), new Tank(), new Tank()};
		//������ for��
		/*for(Tank ta : tankarray) {
			ta.move(10, 50);
		}*/
		for(int i = 0; i < tankarray.length; i++) {
			tankarray[i].move(555, 333);
		}
		
		//���� § �ڵ�
		/*Tank[] tt = new Tank[3];
		for(Tank v : tt) {
			v = new Tank();
			v.move(400, 500);
		}*/
		
		//2.�������� Unit (Tank, Marine, Dropship) ���� ��ǥ�� �̵� ��Ű����
		//hint ������(�θ�Ÿ��) >> ������ǰ void buy(Product p) {}
		//					>> ������ǰ cart >> Product[] cart = new Product[10]; 
		Unit[] unitarray = {new Tank(), new Marine(), new DropShip()};
		//�θ� ������ move ���� ����
		for(Unit unit : unitarray) {
			unit.move(111, 222);
		}
		
		//���� § �ڵ�
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
