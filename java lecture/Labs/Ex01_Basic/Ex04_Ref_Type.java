// Ŭ������ ���赵�̴�, Ŭ������ Ÿ���̴�
// Ŭ���� == ���赵 == Ÿ��
// Ŭ������ �޸� (heap) new �����ڷ� �÷��ݴϴ� (��(heap)�� ���赵(class)�� ���� �Ȱ��� ����Ʈ(instance ��ü)�� ����ϴ�)

// ���赵 �ۼ� (class �ۼ�)
class Apt2 {
	int door = 10;
	int window = 100;
}

public class Ex04_Ref_Type { // ����: ����, �� �޸� ���� �׷�����
	public static void main(String[] args) {
		Apt2 lgapt = new Apt2();
		// Apt2 Ÿ��(class type)
		// lgapt ����(�ּҸ� ������ ����: ��������, ��ü����, instance variable)
		System.out.println("lgapt ���� � ���� (������ �ּҰ�): " + lgapt); // ������ �ּҰ�: �����ε�
		
		Apt2 ssapt = lgapt; // Apt2@70dea4e (���� Ÿ�Կ��� �Ҵ�: �ּҰ� �Ҵ�)
		ssapt.window = 1000;
		System.out.println("lgapt.window: " + lgapt.window);
		// **���� Ÿ���� �Ҵ��� �ּҰ� �Ҵ��̴�
	}
}