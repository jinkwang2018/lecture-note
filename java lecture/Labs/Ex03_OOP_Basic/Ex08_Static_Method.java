
public class Ex08_Static_Method {
	public void method() {
		System.out.println("�� �Ϲ��Լ���");
	}
	public static void smethod() {
		System.out.println("�� static�Լ���");
	}
	
	public static void main(String[] args) { 
		//**java ���α׷��� �����Ű�� ���ؼ��� main�Լ��� ���������μ� �ݵ�� �ʿ�
		//���� ��� public static void start() {} ���� ���α׷� ������ �� ����.
		//(main�̶�� �̸��� ���������� �ϰڴٴ� ���)
		System.out.println("�� static main�Լ���");
		smethod();
		//Ex08_Static_Method.smethod();
		
		Ex08_Static_Method ss = new Ex08_Static_Method();
		ss.method();
	}
}
