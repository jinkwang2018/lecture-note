package kr.or.bit;
//������ ���� (���� ����)
//singleton >> ��ü�� �ϳ��� ���� ����

//�ϳ��� ��ü�� �����ؼ� [�����ϰ� �ʹٸ�] ...static

//1. ���� ���� ��ü�� ���� (new ������) ���´� (������ private)
//2. �ϳ��� ��ü�� ���� ���� ���
//3. �ᱹ �ϳ��� ��ü�� ����� ����ϰ� ����

//�ǻ�Ȱ
//ȸ��: ���� ������, ��Ʈ��ũ �ڿ� ...
//JDBC ������ Ȱ�� �ϴ� �ڵ� ������^^

public class Singleton {
	private static Singleton p; //p ��� ������ Singleton ��ü�� �ּҸ� ������ �ְ�
	private Singleton() {} //������ private ������ ��ü�� �������� ���ϰ�
	
	public static Singleton getInstance() {
		if(p == null) {
			p = new Singleton(); //������ ȣ���ؼ� �޸�
		}
		return p;
	}
	
}
