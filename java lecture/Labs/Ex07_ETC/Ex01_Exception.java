//����
//1. ����(Error): ��Ʈ��ũ ���, �޸�, �ϵ����
//2. ����(Exception): ������ �ڵ� ó�� (���� ���� ...> ��������)

//����ó�� ����: ���α׷��� ���������� �����ϴ� ���� �ƴϰ� ������ �߻��� ���������� ���� ���ϰ� �ϴ� ��
/*
������ �߻��� �� �ִ� �ڵ�
try{
	������ �� �� �ִ� �ڵ�
}catch(Exception e)
{
	ó�� (������ ���� ������ �ϰ�...)
	ex)�����ڿ��� ������ ������?
	log���Ͽ� ����ұ�?
}finally{
	���ܰ� �߻��ϴ� �߻������ʴ� ���������� ����Ǵ� ����
}
 */

public class Ex01_Exception {
	public static void main(String[] args) {
		System.out.println("Main Start");
			System.out.println("Main Logic ó��");
			try {
				System.out.println (0/0); //������ ���� (���� �߻� �������� �� ���� �ڵ� ���� �ȵ�)
				//java.lang.ArithmeticException: / by zero
				//new ArithmeticException()
			}catch(Exception e) {
				//ó��
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
		System.out.println("Main End");
	}
}
