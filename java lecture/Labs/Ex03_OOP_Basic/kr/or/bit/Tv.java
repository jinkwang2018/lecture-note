package kr.or.bit;
/*
Tv ���赵
�䱸���� ����
Tv�� ä�� ������ ������ �ִ�. (���� ��� 1 ~ 200)
Tv�� �귣���̸��� ������ �ִ�. (���� ��� �Ｚ, ����)
Tv�� ä����ȯ ����� ������ �ִ�.
ä���� ���� �ø� ���� �ְ� ���� ���� �ִ�. (ä���� �� �ܰ辿 ���� ����)
 */

public class Tv {
	public int ch;
	// �ʱⰪ�� �⺻������ ����
	// class�� ������ ����: field, instance variable
	public String brandname;
	
	public void chUp() {
		ch++;
	}
	
	public void chDown() {
		ch--;
	}
}
