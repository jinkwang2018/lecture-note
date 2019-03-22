/**
 프로젝트 : 비트코인 캠프 시스템
 파일이름 : Date.java
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
 수정자명 : 이 창 훈
*/

package kr.or.bit.Three;

import java.text.SimpleDateFormat;
import java.util.Calendar;
 
/**
 클래스명 : Date
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
 수정자명 : 이 창 훈
 */
public class Date_Time {
 
    private static SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmm"); 
    private static SimpleDateFormat date2 = new SimpleDateFormat("yyyyMMdd");
   
    /**
     날    짜 : 2018. 2. 23.
     기    능 : Calendar를 받아서 현재 날짜를 돌려주는 함수
     작성자명 : 김 희 준
     수정자명 : 이 창 훈
     */
    public static String getDate(Calendar cal) {
        return date.format(cal.getTime());
    }
    
    public static String getDate2(Calendar cal) {
        return date2.format(cal.getTime());
    }
}