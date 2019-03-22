package BlueMarble;

import java.util.Calendar;

public class Calender { //날짜 시간 리턴 함수

        Calendar cal = Calendar.getInstance();
        private String ymd  = null;       
    public String calender() {
    	ymd = cal.get(Calendar.YEAR)+"년  " +(cal.get(Calendar.MONTH)+1) +"월  " + cal.get(Calendar.DATE)+ "일  ";
        System.out.println(cal.get(Calendar.YEAR)+"년  " +(cal.get(Calendar.MONTH)+1) +"월  " + cal.get(Calendar.DATE)+ "일  ");
        int AMPM = cal.get(Calendar.AM_PM);
         switch (AMPM) {
         case Calendar.AM:
        	 ymd += "오전  ";
             break;
         case Calendar.PM:
        	 ymd += "오후  "; 
            break;
         } 
         ymd += cal.get(Calendar.HOUR)+"시  " +cal.get(Calendar.MINUTE)+"분  "+ cal.get(Calendar.SECOND) +"초 ";
    	 return ymd;
    }
 
}