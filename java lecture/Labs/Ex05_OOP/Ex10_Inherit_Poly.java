//������(��Ӱ��迡��)
//������: �������� ����(����)�� ���� �� �ִ� �ɷ�
//C#: ������ �ȿ� overloading, override ����
//java: [��Ӱ���]���� �ϳ��� [��������]�� �������� [Ÿ��]�� ���� �� �ִ�
//���������� �θ�Ÿ���� �̾߱� �Ѵ�
//����Ŭ���� Ÿ���� ���������� �������� �ڽ�Ŭ���� ��ü�� ���� ����

//java: �ڽ��� �θ𿡰� ���Ǿ��� �帰�� (���Ǽ���� �ݴ�)

class Tv2 { //�θ� (�Ϲ�ȭ, �߻�ȭ) ����
	boolean power;
	int ch;
	void power() {
		this.power = !this.power;
	}
	void chUp() {
		ch++;
	}
	void chDown() {
		ch--;
	}
}

//Tv2 Ŭ����
class CapTv extends Tv2 { //Ư��ȭ, ��üȭ, ������ ����
	String text;
	String caption() {
		return this.text = "���� �ڸ� ó�� ��...";
	}
}

public class Ex10_Inherit_Poly {
	public static void main(String[] args) {
		CapTv tv = new CapTv();
		tv.power();
		System.out.println("����: " + tv.power);
		tv.chUp();
		System.out.println("ä������: " + tv.ch);
		System.out.println("�ڸ�ó��: " + tv.caption());
		//�������� ��� ����
		
		//Tv2 tv2 = new Tv2();
		//������ Tv2 Ÿ���� ��ü�� heap memory�� �ִµ� ���� �� heap memory�� �ø� �ʿ䰡 ������?
		
		Tv2 tv2 = tv; // CapTv�� �θ�Ÿ������ Tv2�� ������ �־�� �Ѵ�
		//tv2 Ÿ�� ���������� Tv2 ��ü�� �ڿ��� ������ ����
		//�̷� ����� ������
		System.out.println("�ּҰ�: " + tv.toString());
		System.out.println("�ּҰ�: " + tv2.toString());
		
		////////////////////////////
		CapTv cc = new CapTv(); //Tv2 ���
		CapTv dd = new CapTv(); //Tv2 ���
		Tv2 tt;
		tt = cc;
		tt = dd;
		//������ (��, ���͸� ����)
	}
}
