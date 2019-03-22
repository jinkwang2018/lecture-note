/*
<Today Point> [��Ӱ���]���� override: ��Ӱ��迡�� �޼��� ������
-��Ӱ��迡�� �ڽ�Ŭ������ �θ�Ŭ������ �޼��带 ������
-������ (�Լ�) (��Ӱ���) (�θ�) (�ڽ���)
-������ �ǹ�: Ʋ�� ��ȭ�� �ƴ϶� ������ ��ȭ ��) void �Լ��� { ��ȣ �ȿ� ���븸 ���� }
����)
1. �θ��Լ� �̸��� ����
2. �θ��Լ� parameter �Լ� ����
3. �θ��Լ� return type ����
4. �ᱹ���� { ��ȣ�ȿ� �ִ� ���븸 �����ض� }

[overloading�� override�� ����]
*overloading: �Լ��� �̸����� �������� ����� �ϴ� ��
*override: ��ӿ����� ������
 */

class Point2 {
	int x = 4;
	int y = 5;
	String getPosition() {
		return "x:" + this.x + " y:" + this.y;
	}
}

class Point3D extends Point2 {
	//x, y ��Ӱ��� �θ� �ڿ� ���
	int z = 6;
	/*String getPosition3() {
		return "x:" + this.x + " y:" + this.y + " z:" + this.z;
	}*/

	//POINT: @Override >> Annotation
	//Annotation�� Java code������ ������ �� ���� �ΰ����� ������ [�����Ϸ�]�� [������]�� ������ �� �ִ�.
	@Override
	String getPosition() {
		//return super.getPosition(); //super: �θ� Ŭ����
		return "x:" + this.x + " y:" + this.y + " z:" + this.z;
	}
	
}

public class Ex04_Inherit_override {
	public static void main(String[] args) {
		Point3D point = new Point3D();
		//String result = point.getPosition3();
		//System.out.println(result);
		
		String result = point.getPosition();
		System.out.println(result);
	}
}
