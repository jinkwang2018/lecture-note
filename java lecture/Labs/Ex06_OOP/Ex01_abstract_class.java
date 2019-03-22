/*
[�߻�Ŭ����]
�̿ϼ� ���赵
�̿ϼ� Ŭ����: �ϼ��� �ڵ� + �̿ϼ� �ڵ�
-�̿ϼ� �ڵ�: �̿ϼ� �Լ�(�Լ��� { ����� }�� ����) ex) public void print();
-�ϼ��� �̿ϼ� ���� (new�� ���� ��ü ����(�ϼ�), �������� ���ϸ�(�̿ϼ�))

1. �߻�Ŭ���� ������ ��ü ���� �Ұ� (new ��� �Ұ�)
2. �߻�Ŭ������ �ᱹ �ϼ��� Ŭ������ ���� ��� -> [���]�� ���ؼ�
       �̿ϼ� �ڿ�(�߻��Լ�) �ϼ��ض�(����) -> ������ ����...(override)

Why? �߻�Ŭ���� >> �����ڰ� �ٶ󺸴� ������ �ǹ�: ������ ������ �������� �Ѵ�
 */

//�߻�Ŭ����(new ��� �Ұ�) > �̿ϼ� Ŭ���� = �ϼ��� �ڵ� + �̿ϼ��� �ڵ�(������� ���� ��) -> ����� ���� -> �������ؼ� -> ���� ����.

abstract class Abclass {
	int pos;
	void run() {
		pos++;
	}
	//�� �ڵ�� �ϼ� �ڵ�
	
	//�߻��ڿ�(�߻��Լ�)
	abstract void stop(); // { �����(x) }
}

class Child extends Abclass {
	@Override
	void stop() { //stop �̶�� �Լ��̸� ������ �ڵ�
		this.pos = 0;
		System.out.println("stop: " + this.pos);
	}
}

public class Ex01_abstract_class {
	public static void main(String[] args) {
		//Abclass ab = new Abclass();
		Child ch = new Child();
		ch.run();
		ch.run();
		System.out.println("���� pos: " + ch.pos);
		ch.stop();
		
		Abclass ab = ch;
		ab.run();
		System.out.println("���� pos: " + ab.pos);
		ab.stop();
	}
}
