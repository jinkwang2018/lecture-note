//���ݱ��� �̱����μ��� + �̱۾����� (main)�Լ�
//JVM >> call stack �ϳ��� ����
//�Լ� 10�� ������ �־ ���� ����Ǵ� �Լ� 1��

//�ѹ��� �ϳ��� �Լ��� ����
//�Լ��� [������]���� ����
public class Ex01_single_Thread {
	public static void main(String[] args) {
		System.out.println("�� main �ϲ��̾�");
		worker();
		worker2();
		System.out.println("�� main ����");
	}
	static void worker() {
		System.out.println("�� 1�� �ϲ��̾�");
	}
	static void worker2() {
		System.out.println("�� 2�� �ϲ��̾�");
	}
}
