import kr.or.bit.AirPlane;

public class Ex06_Static_Airplane {
	public static void main(String[] args) {
		//������ �Լ��� �� ����ϸ��ڵ尡 �پ��
		AirPlane a1 = new AirPlane(707, "�����װ�");
		a1.airPlaneInfo();
		a1.airPlaneTotalCount();
		
		AirPlane a2 = new AirPlane(808, "�����װ�");
		a2.airPlaneInfo();
		a2.airPlaneTotalCount();
		
		/* ������ ���� �� �ڵ�
		AirPlane a1 = new AirPlane();
		a1.makeAirPlane(707, "�����װ�");
		// ** a1. �Է� ��, AirPlane Ŭ������ privateó���� ������ ������ �ʰ� �ϴ� ���� �ٽ� (ĸ��ȭ)
		a1.airPlaneTotalCount();
		
		AirPlane a2 = new AirPlane();
		a2.makeAirPlane(808, "�ƽþƳ�");
		a2.airPlaneTotalCount();
		
		AirPlane a3 = new AirPlane();
		a3.makeAirPlane(999, "������");
		a3.airPlaneTotalCount();
		*/
		
//���� �ۼ��� �ڵ� : �ڵ尡 �� -> ���̴� ������ ����.
/*		
		// 1��
		AirPlane air = new AirPlane();
		air.name = "red";
		air.no = 31;
		air.count();
		air.check("red", 30);
		
		// 2��
		AirPlane air2 = new AirPlane();
		air2.name = "green";
		air2.no = 22;
		air2.count();
		air2.check("green", 22);
		
		// 3��
		AirPlane air3 = new AirPlane();
		air3.name = "blue";
		air3.no = 15;
		air3.count();
		air3.check("blue", 15);
		
		System.out.println("����� �� ���: " + air.amount);
*/
	}
}
