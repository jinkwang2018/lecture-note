package Quiz_;

public class Quiz_3_7 {
	public static void main(String[]args) {
		int fahrenheit = 100;
		float celcius = (float)(((int)(((((float)(fahrenheit-32)*5)/9)*100)+0.5))/100.0); 
		System.out.println("fahrenheit : " + fahrenheit);
		System.out.println("celcius : " + celcius);										   
		//ȭ���µ� -32�� �Ѱ��� float type���� �ٲ� �� 5�� ���ϰ� 9�� ������ ���� �µ� ���� ���´�.
    }   //�װ��� 100�� ���ϰ�(�Ҽ��� ��°���� �Ҽ��� ���� �ø�) 0.5�� ���ѵ�(�ݿø�) 
	    //��Ƽ�������� �ٲٰ�(�Ҽ��� ��°������ ���� ����) 100���� ������ �ָ�(�Ҽ��� ��°�ڸ����� �����) 
	    //�Ҽ��� ��°�ڸ������� ���� ������ �ȴ�.
}		
