package kr.or.bit.library;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
클래스명 : Time
날짜 : 2018-02-22
작성자명 : 김태웅
*/
public class Time {
	private String[] times; // times[0]: yyyy-MM-dd hh:mm:ss, times[1]: 현재 시각과 1970년 1월 1일 오전 0시와의 차이
	
	public Time() {
		times = new String[2];
	}
	/** 
	 * 
	  날짜 : 2018-02-22 
	  기능 : 도서관의 시스템 시간 return 함수 -> yyyy-MM-dd hh:mm:ss 포멧으로 반환
	  작성자명 : 김태웅
	 */
	public String[] getTimes() {
		long sec = System.currentTimeMillis(); 									// 현재 시각과 1970년 1월 1일 오전 0시와의 차이를 long 값 저장
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	// yyyy-MM-dd hh:mm:ss
		String str = dayTime.format(new Date(sec));
		times[0] = str;
		times[1] = Long.toString(sec);
		return times;
	}
}
