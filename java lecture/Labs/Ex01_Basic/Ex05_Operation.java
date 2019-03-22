import javax.rmi.CORBA.Util;

// ������
public class Ex05_Operation {
	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13/2;
		System.out.println(result);
		
		result = 13%2; // �������� ���ϴ� ������
		System.out.println(result);
		
		// ������ ������(++, --) 1�� ����, ����
		int i = 10;
		++i; // ��ġ ����
		System.out.println(i);
		i++; // ��ġ ����
		// ���� �ϳ��� ��ġ, ��ġ ����
		System.out.println(i);
		
		// POINT ��ġ, ��ġ �����ڴ� �ٸ� �İ� ���� (����)
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2;
		System.out.println(result2);
		// result2: 10 = i2(5) + j2(5)
		System.out.println("result2: " + result2 + " j2: " + j2);
		result2 = i2 + j2++;
		System.out.println("result2: " + result2 + " j2: " + j2);
		// result2: 10 j2: 6
		
		// POINT
		// �ڹ��� ���� ��Ģ
		// ������ ��� [����]�� int ��ȯ �� ó��
		// byte + byte => �����Ϸ� int + int
		byte b = 100; // -128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c);
		//1. int d = b + c;
		//2. byte d = (byte)(b + c);
		System.out.println("d: " + d);
		
		// byte + short => �����Ϸ� int + int
		// char + char  => �����Ϸ� int + int
		// ����ó����....
		// POINT: ���꿡�� int ���� ���� Ÿ���� int ��ȯ (long ����)
		// ����ÿ� (byte, char, short -> int) �ٲپ ���� ó��
		
		// �ǿ����� �� ǥ�������� ū Ÿ������ ����ȯ
		// byte + short -> int + int -> int
		// char + int   -> int + int -> int
		// int  + long  -> long + long -> long
		
		// (������ �Ǽ�: �Ǽ�)
		// float + int -> float + float -> float
		// long  + float -> float + float -> float
		// float + dobule -> double + double -> double
		
		float num2 = 10.45f;
		int num3 = 20;
		// num2 + num3 ����
		// int result5 = (int)(num2 + num3); // float + float
		// System.out.println("result5: " + result5); // ������ �ս�
		
		float result5 = num2 + num3;
		System.out.println(result5);
		
		double result5a = num2 + num3;
		System.out.println(result5a); // ���: 30.450000762939453 // [?] �� �׷��� ã�ƺ���.
		
		char c2 = '!';
		char c3 = '!';
		// c2 + c3 ���
		// char result6 = c2 + c3;
		int result6 = c2 + c3; // �ƽ�Ű �ڵ�ǥ ���� 'A'�� ���� 10����: 65 + 65
		System.out.println("result6 : " + result6);
		// result6�� ������ �������� ���ڸ�....
		System.out.println((char)result6);
		
		// ���
		// �߼ұ�� ���蹮�� (������ ���)
		// �����
		int sum = 0;
		for(int j = 1; j <= 100; j++) {
			// System.out.println("j: " + j);
			if (j%2 == 0) {
				sum += j; // sum = sum + j;
			}
		}
		System.out.println("sum: " + sum);
		
		// == ������ ([��]�� ���ϴ� ������)
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		// != ����������
		if('A' != 65) {
			System.out.println("�� ���� ���� �ƴϾ�");
		}else {
			System.out.println("�� ���� ���̾�");
		}
		
		// �ϱ�(POINT)
		// ���� ������ *�߾��� ���� �߿�*
		int p = 10;
		int k = -10;
		int result8 = (p == k)? p : k;
		System.out.println("result8: " + result8);
		// ���� �����ڴ� if ��� ���� ����
		
		// if��
		if(p == k) {
			result8 = p;
		}else {
			result8 = k;
		}
		System.out.println("result8: " + result8);
		
		// ����ǥ
		/*
			0: false
			1: true
			
			      OR    AND
			0 0   0      0
			0 1   1      0
			1 0   1      0
			1 1   1      1
			
			sql �� (oracle)
			select *
			from emp
			where empno = 1000 and sal > 2000
			
			select *
			from emp
			where empno = 1000 or sal > 2000
			
			������
			 | OR ������
			 & AND ������
			 0 �� 1 ��ȯ�ؼ� bit ����
		 */
		
		int x = 3;
		int y = 5;
		System.out.println("x|y: " + (x|y)); // OR
		System.out.println("x&y: " + (x&y)); // AND
		// ������ -> 2���� (0�� 1�θ� �̷���� ������)
		// 128 64 32 16 8 4 2 1
		//              0 0 1 1 *3 ������
		//              0 1 0 1 *5 ������
		// OR           0 1 1 1 => 1+2+4 = 7 ������
		// AND          0 0 0 1 => 1 ������
		
		// POINT �� ���� (&&(and), ||(or)) -> ������ return boolean
		// short circuit (���� ������ Ȯ��)
		// if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1 && .....)
		// if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1 || .....)		
		
		
	}
}