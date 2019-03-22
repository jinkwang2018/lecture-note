import java.util.Arrays;

/*
(main�Լ� �ȿ���)
1. 1~45������ ������ �߻����� 6���� �迭�� ��������
2. �迭�� ��� 6���� �迭���� �ߺ����� ������ �ȵǿ� (�ٽ� ����)
3. �迭�� �ִ� 6���� ���� ���� ������ ���� ��Ű����
4. �� ����� ��� �ִ� �迭�� ����ϼ���
 */
public class Ex02_Lotto_Main_Myself {
	public static void main(String[] args) {
		// 6���� �迭 ����
		int[] arr = new int[6];
		
		// ���� �߻� (���), 6���� �迭 ���
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			for(int j = 0; j < i; j++) {
				if(i != j) {
					if(arr[i] == arr[j]) {
						do { // 6�� �ߺ��� X ó��
							arr[i] = (int)(Math.random() * 45 + 1);
						}while(arr[i] == arr[j]);
					}
				}
			}	
		}
		
		System.out.println("������: " + Arrays.toString(arr)); // ���� �߻� Ȯ��
		
		// ���� �� ����
		int temp = 0;
		int cnt = 0;
		
		do {
			cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[i]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
				
						cnt++;
						break;
					}
				}
			}
		}while(!(cnt == 0));
		
		// ���
		System.out.println("���İ�: " + Arrays.toString(arr));
	}
}
