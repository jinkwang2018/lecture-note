package BlueMarble;

import java.util.Calendar;

public class Calender { //��¥ �ð� ���� �Լ�

        Calendar cal = Calendar.getInstance();
        private String ymd  = null;       
    public String calender() {
    	ymd = cal.get(Calendar.YEAR)+"��  " +(cal.get(Calendar.MONTH)+1) +"��  " + cal.get(Calendar.DATE)+ "��  ";
        System.out.println(cal.get(Calendar.YEAR)+"��  " +(cal.get(Calendar.MONTH)+1) +"��  " + cal.get(Calendar.DATE)+ "��  ");
        int AMPM = cal.get(Calendar.AM_PM);
         switch (AMPM) {
         case Calendar.AM:
        	 ymd += "����  ";
             break;
         case Calendar.PM:
        	 ymd += "����  "; 
            break;
         } 
         ymd += cal.get(Calendar.HOUR)+"��  " +cal.get(Calendar.MINUTE)+"��  "+ cal.get(Calendar.SECOND) +"�� ";
    	 return ymd;
    }
 
}