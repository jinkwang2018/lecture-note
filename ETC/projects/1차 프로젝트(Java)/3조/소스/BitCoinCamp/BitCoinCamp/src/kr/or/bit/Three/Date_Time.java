/**
 ������Ʈ : ��Ʈ���� ķ�� �ý���
 �����̸� : Date.java
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
 �����ڸ� : �� â ��
*/

package kr.or.bit.Three;

import java.text.SimpleDateFormat;
import java.util.Calendar;
 
/**
 Ŭ������ : Date
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
 �����ڸ� : �� â ��
 */
public class Date_Time {
 
    private static SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmm"); 
    private static SimpleDateFormat date2 = new SimpleDateFormat("yyyyMMdd");
   
    /**
     ��    ¥ : 2018. 2. 23.
     ��    �� : Calendar�� �޾Ƽ� ���� ��¥�� �����ִ� �Լ�
     �ۼ��ڸ� : �� �� ��
     �����ڸ� : �� â ��
     */
    public static String getDate(Calendar cal) {
        return date.format(cal.getTime());
    }
    
    public static String getDate2(Calendar cal) {
        return date2.format(cal.getTime());
    }
}