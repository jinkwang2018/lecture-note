package kr.or.bit.library;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
Ŭ������ : Time
��¥ : 2018-02-22
�ۼ��ڸ� : ���¿�
*/
public class Time {
	private String[] times; // times[0]: yyyy-MM-dd hh:mm:ss, times[1]: ���� �ð��� 1970�� 1�� 1�� ���� 0�ÿ��� ����
	
	public Time() {
		times = new String[2];
	}
	/** 
	 * 
	  ��¥ : 2018-02-22 
	  ��� : �������� �ý��� �ð� return �Լ� -> yyyy-MM-dd hh:mm:ss �������� ��ȯ
	  �ۼ��ڸ� : ���¿�
	 */
	public String[] getTimes() {
		long sec = System.currentTimeMillis(); 									// ���� �ð��� 1970�� 1�� 1�� ���� 0�ÿ��� ���̸� long �� ����
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	// yyyy-MM-dd hh:mm:ss
		String str = dayTime.format(new Date(sec));
		times[0] = str;
		times[1] = Long.toString(sec);
		return times;
	}
}
