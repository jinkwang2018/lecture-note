import java.util.Arrays;

public class Ex01_Array_Quiz {
	public static void main(String[] args) {
		//[����1] ���а� �л����� �⸻��� ��������
		System.out.println("[����1]");
		int[] score = new int[] {79, 88, 97, 54, 56, 95};
		int max = score[0];
		int min = score[0];
		
		/*
		����� ����ؼ� max��� �������� �ִ밪, min �������� �ּҰ��� ��⵵�� �ۼ��ϼ���
		ex) max = 97, min = 54
		 */
		for(int i = 0; i < score.length; i++) {
			max = (score[i] > max) ? score[i] : max;
			min = (score[i] < min) ? score[i] : min;
			//if(score[i] > max) { max = score[i]; }
			//if(score[i] < min) { min = score[i]; }
		}
		System.out.println("max = " + max + " / " + "min = " + min);
		
		System.out.println();
		
		/* [����2]
		10���� ���� ���� 1~10������ �ʱ�ȭ
		number[0] ����ϸ� 1�̶�� ���
		��) �ϳ��� for���� ���
		 */
		System.out.println("[����2]");
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++) {
			number[i] = i + 1;
			System.out.printf("number[%d]: %d\n", i, number[i]); //���� �ۼ��� �ڵ�
		}
		// System.out.println(Arrays.toString(number)); //�����ð��� ��� �ڵ�
		
		System.out.println();
		
		/* [����3]
		��� �л��� �⸻��� �������� (5����)
		1. �� ���� ��
		2. ������ ��
		3. ������ ���
		��) �ϳ��� for���� ���
		 */
		System.out.println("[����3]");
		int sum = 0;
		float average = 0f;
		int[] jumsu = {100, 55, 90, 60, 78};
		
		for(int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
			// �����ð��� �ڵ�
			if (i == jumsu.length - 1) {
				average = sum / (float)jumsu.length;
			}
		}
		// average = (float)sum / jumsu.length; // ���� § �ڵ�
		
		System.out.println("1.�� ���� ��: " + jumsu.length);
		System.out.println("2.������ ��: " + sum);
		System.out.println("3.������ ���: " + average);
	}
}
