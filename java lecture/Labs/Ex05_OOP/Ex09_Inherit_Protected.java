import kr.or.bit.Bird;

//protected ������: ��Ӱ��迡�� ���
//������: ��Ӱ��迡�� �����Ǹ� �����ϴ� ���
//�����Ǹ� ���־����� ���ھ�(�ǵ�)

//��Ӱ��迡�� �����Ǹ� [����]�ϴ� ��� (Protected)
//����: ���� �� �� �ִ�, ���� ������
class Ostrich extends Bird {
	void run() {
		System.out.println("�޸���^^");
	}

	@Override
	protected void movefast() {
		run();
	}
}

class Bi extends Bird {
	@Override
	protected void movefast() {
		super.movefast();
	}
}

public class Ex09_Inherit_Protected {
	public static void main(String[] args) {
		Ostrich o = new Ostrich();
		o.run();
		o.movefast();
		
		Bi b = new Bi();
		b.movefast();
	}
}
