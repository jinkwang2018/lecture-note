/*
�߻� Ŭ������ �������̽� ������
1. ������ ��ü ������ �Ұ��� (new������ ���Ұ�)
2. ���, ������ ���ؼ��� ��밡�� (�޸𸮿� ���� ����)
3. ������ ���ؼ� ���� ������ ����

�߻� Ŭ������ �������̽� �ٸ���
1. �������̽��� ���� ����� ���� (����)
2. �߻�Ŭ���� ���ϻ�� ��Ģ
3. �߻�Ŭ���� (�ϼ��� �ڵ� + �̿ϼ��� �ڵ�)
4. �������̽��� ����� ������ �������� �̿ϼ� �ڵ� (�߻��ڿ�)

*�������̽� ������ ��Ӱ���
interface Ia extends Ib, Ic, Id {}

*�ϳ��� Ŭ������ �������� �������̽��� ���� ����
class Test extends Object implements Ia, Ib, Ic
class Test implements Ia, Ib, Ic

***** ������ ���� ****
1. �������̽��� [������] ���忡�� ���� (�������̽��� �θ�Ÿ���̴�)
2. ���� �������� ���� Ŭ������ ���ؼ� �ϳ��� ���� ����� ���� (�θ� ����)
<<1, 2���� �ٽ�!>>


3. �������̽��� (~able): �����ִ�, �����Ҽ� �ִ� (����)
4. ��ü���� ���� �� (��ü���� ������ ����)

 */
interface Irepairable {} //~�� �� �ִ� ���� �̸�... //������ �� �ִ�

class Unit2 {
	int hitpoint;
	final int MAX_HP;
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}

//���� ����
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}
}



//���� ����
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank2 extends GroundUnit implements Irepairable {
	Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Tank2";
	}
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Marine2";
	}
}

class CommandCenter implements Irepairable {} 

class Scv extends GroundUnit implements Irepairable {
	Scv() {
		super(60);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Scv";
	}
	//Scv ��üȭ Ư��ȭ ������ ���
	//�����ϴ� (repair)
	
	/*
	void repair(Tank2 tank) {
		if(tank.hitpoint != tank.MAX_HP)
			tank.hitpoint += 5;
	}
	
	void repair(Scv scv) {
		if(scv.hitpoint != scv.MAX_HP) {
			scv.hitpoint += 5;
		}
	}
	*/
	
	//scv ������ �� �ִ� unit �����Ǹ�, unit ���� ��ŭ
	//repair �Լ� �߰� �ؾ� �Ѵ�
	//�����: �ϳ��� �Լ��� �ٸ� ��� unit�� ������ �� ������?
	//Unit2 <- GroundUnit <- Tank2, Marine2(repair (x)), Scv
	//void repair(Unit2 unit) {} (x) >> Marine2 ������ (x)
	//��Ӱ����� �θ�Ÿ���� ������ ��� ���� END
	
	//2. �������̽� interface Irepairable {}
	//�������̽��� �ϳ��� [������ Ÿ��]���� �����ؾ� �Ѵ�.
	
	void repair(Irepairable repairunit) {
		//1. Tank2, Scv ������ �� �� �ִ�
		/*if(scv.hitpoint != scv.MAX_HP) {
			scv.hitpoint += 5;
		}*/
		
		//repairunit >>Tank2 Ÿ������
		//downcasting -> Tank2 t = (Tank2)repairunit; (����Ÿ���� ����Ÿ������)
		
		//repairunit >> Scv Ÿ������
		//downcasting -> Scv t = (Tank2)repairunit; (����Ÿ���� ����Ÿ������)
		
		//repair ������ ����� �ƴ� CommandCenter�� �� �� �ִ� (unit �ƴϴ�)
		
		//Tank2 > GroundUnit > Unit2
		//Scv   > GroundUnit > Unit2
		//������: Unit2 ���
		
		//CommandCenter: Unit2 �ƴϴ�
		//downcasting �Ұ�
		
		//������ ��ü�� Ÿ���� �� �Ǵ�
		if(repairunit instanceof Unit2) {
			Unit2 unit = (Unit2)repairunit;
			if(unit.hitpoint != unit.MAX_HP) {
				unit.hitpoint = unit.MAX_HP;
			}
		}else {
			System.out.println("Unit2 Ÿ���� �ƴϿ��� �ٸ� repair �մϴ�");
		}
	}
}


public class Ex03_Interface {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		//����
		tank.hitpoint -= 10;
		System.out.println("��ũ����: " + tank.hitpoint);
		System.out.println("������û! Scv!");
		scv.repair(tank);
		System.out.println("�����Ϸ�: " + tank.hitpoint);
		
		CommandCenter center = new CommandCenter();
		scv.repair(center);
		
		//scv.repair(Mairne2); // �����ϵ� �ȵǿ�
		
	}
}
