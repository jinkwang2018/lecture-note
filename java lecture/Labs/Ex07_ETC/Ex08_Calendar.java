import java.util.Calendar;
import java.util.Date;

import kr.or.bit.EduDate;

/*
* Calendar 를 상속받아 완전히 구현한 클래스는 
 * GregorianCalendar
   buddhisCalendar 있는데 getInstance()는 [시스템의 국가와 지역설정]을 [확인]해서
   태국인 경우 buddhisCalendar 의 인스턴스를 반환하고 그 외에는 GregorianCalendar
   의 인스턴스를 반환한다
   GregorianCalendar 는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 
   그레고리력에 맞게 구현한 것으로 태국을 제외한 나머지 국가에서는 GregorianCalendar 사용
   그래서 인스턴스를 직접 생성해서 사용하지 않고 메서드를 통해서 인스턴스를 반환받게하는
   이유는 최소의 변경으로 프로그램 동작을 하도록 하기 위함
   class MyApp{
     static void main(){
      Calendar cal = new GregorianCalendar();
      다른 종류의 역법의 사용하는 국가에서 실행하면 변경......    }  }
   class MyApp{
     static void main(){
      Calendar cal = new getInstance();
        다른 종류의 역법의 사용하는 국가에서 실행하면 변경......   }  }
  API : 생성자 Protected Calendar() 
 */
//JAva API
//날짜 : Date (구) -> Calendar(신)

public class Ex08_Calendar {
	public static void main(String[] args) {
		//모든 시스템은 날짜를 제어
		Date dt = new Date(); //구버전
		System.out.println(dt);
		
		Calendar cal = Calendar.getInstance(); //싱글톤이 아니다. 나라마다 다른 객체를 리턴하기 위해서 사용
		System.out.println(cal.toString()); //toString 재정의 (날짜 정보 문자열 나열)
		//Calendar cal2 = new GregorianCalendar();
		//System.out.println(cal2);
		System.out.println("년도: " + cal.get(Calendar.YEAR));
		System.out.println("월(0~11): " + (cal.get(Calendar.MONTH)+1));
		System.out.println("일: " + cal.get(Calendar.DATE));
		
		System.out.println("이 달의 몇째 주: " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		//시 분 초
		//오전 오후 (AM 0 / PM 1)
		System.out.println("오전 오후: " + cal.get(Calendar.AM_PM));
		System.out.println("시: " + cal.get(Calendar.HOUR));
		System.out.println("분: " + cal.get(Calendar.MINUTE));
		System.out.println("초: " + cal.get(Calendar.SECOND));
		
		//웹 사이트 (교육 시스템)
		//150본 (페이지) >> 120페이지 날짜 정보를 가지고 있다 (서버쪽 시간)
		//2018년 02월 12일 >> 변경 >> 2018-02-12
		//날짜 정보 한번만 수정해서 전체 반영: 클래스 >> 함수 (static) >> 날짜
		String date = EduDate.DateString(Calendar.getInstance());
		System.out.println(date);
		
		String date2 = EduDate.DateString(Calendar.getInstance(), "::");
		System.out.println(date2);
		
		String date3 = EduDate.monthFormat_DateString(Calendar.getInstance());
		System.out.println(date3);
		
	}
}
