class Tv {
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
		
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class Vcr {
	boolean power;
	
	void power() {
		this.power = !this.power;
	}
	
	void play() {
		System.out.println("����ϱ�");
	}
	
	void stop() {
		System.out.println("����");
	}
	
	void rew() {}
	void ff() {}
}

//Vcr��ɰ�  Tv����� ���� ���赵�� ����� �ּ���. (Vcr�� ����� Tv�� ����� �ּ���.)
//���赵 �̸��� TvVcr

//class TvVcr extends Tv, Vcr {} ���߻��(x)
//Tv extends Vcr
//TvVcr extends Tv (������ ���)

//����: ���߿� �ϳ� ���, ����
//��� ���, ��� ����
//Tv ��� (�ֱ��, ���α��), Vcr ����
//������ ���� Ŭ���� => ���

//�Ѵ� ���� ���� (����)
//class TvVcr {Tv t; Vcr v;}

//1. ������ ���
//2. �Ѵ� ���� ����
//3. �ϳ��� ���, �ϳ��� ���� => �ַ� ���, �������� �ƴϴ�

class TvVcr extends Tv{ //Ȯ���մϴ�, ��üȭ�մϴ�
	Vcr vcr;
	TvVcr() {
		vcr = new Vcr(); //vcr memory�� �����ڿ���
	}
}

public class Ex03_Inherit_Single {
	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv ��������: " + t.power);
		t.chUp();
		System.out.println("Tv ä������: " + t.ch);
		
		//���� �Ѻ�����
		t.vcr.power(); //���ٹ��
		System.out.println(t.vcr.power);
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power(); //���� ���� ����
		t.power(); //Tv ����
		System.out.println("Tv ����: " + t.power);
		System.out.println("���� ����: " + t.vcr.power);
	}
}
