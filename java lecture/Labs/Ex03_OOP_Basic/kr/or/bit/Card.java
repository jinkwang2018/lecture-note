package kr.or.bit;

/*
�츮�� ī�带 ���� �Ǹ��ϴ� ȸ���Դϴ�
���� ��û�� ���� ī�� 53���� �����ϰ� �Ǿ����ϴ�.

�䱸����
ī��� ī���� ��ȣ�� ������ �ְ� ����� ������ �ִ�.
ī��� ũ�⸦ ������ �ֽ��ϴ�. ũ��� ����, �ʺ� ������ �ִ�

Ȥ�� ī���� ũ��� ���氡�� �ұ��?
-> ��� ī���� ���̿� �ʺ�� ���� (�������)
 */

public class Card {
	public int number;
	public String kind;
	
	//public int h = 50;
	//public int w = 20;
	public static int h = 50;
	public static int w = 20;
	
	//���(����)
	public void cardInfo() {
		System.out.printf("��ȣ: %d, ���: %s, h: %d, w: %d\n", number, kind, h, w);
	}
}
