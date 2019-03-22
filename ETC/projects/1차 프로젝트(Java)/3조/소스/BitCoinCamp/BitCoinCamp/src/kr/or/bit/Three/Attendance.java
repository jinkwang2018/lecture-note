package kr.or.bit.Three;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
클래스명 : Attendance
날      짜 : 2018. 2. 23.
작성자명 : 이 창 훈
*/
public class Attendance {
 
    private String studentName;
    private String lectureName;
    private String date;
    private String time;
    private String attendanceRecord;
	/**
	날      짜 : 2018. 2. 23.
	기      능 : 학생들 정보 기록하는 함수 
	작성자명 : 이 창 훈
	*/
    public Attendance input(Attendance attendance, String sname, String lname){
        Calendar cal = Calendar.getInstance();
        this.studentName = sname;
        this.lectureName = lname;
        this.date = Date_Time.getDate(cal);
        String reqDateStr = Date_Time.getDate2(cal) + "0900";// 지정시간
        Date curDate = new Date(); // 현재시간 주소값 확인하기
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        // 요청시간을 Date로 parsing 후 time가져오기
 
        Date reqDate; 
        long reqDateTime = 0;
                
        
        try {
        	reqDate = dateFormat.parse(reqDateStr);
        	reqDateTime = reqDate.getTime();
            // 현재시간을 요청시간의 형태로 format 후 time 가져오기
            curDate = dateFormat.parse(dateFormat.format(curDate));
            // 현재시간 주소타입으로 변환하기
        } catch (ParseException e) {
            
            e.printStackTrace();
        } 
 
        long curDateTime = curDate.getTime(); // 분으로 표현
        long min = (curDateTime - reqDateTime) / 60000;
        if (min <= 10) {
            this.attendanceRecord = "- 출석 -";
        } else if (min > 10 && min <= 240) {
            if (min > 59) {
                String time = min / 60 + "시간" + min % 60 + "분 ";
                this.attendanceRecord = "- 지각 -  *수업 시작 후 " + time + " 초과 되었습니다.";
            } else {
                this.attendanceRecord = "- 지각 -  *수업 시작 후 " + min + "분 초과 되었습니다.";
            }
 
        } else {
            String time = min / 60 + "시간" + min % 60 + "분 ";
            this.attendanceRecord = "- 결석 -  *수업 시작 후 " + time + " 초과 되었습니다.";
        }
 
        return attendance;
    }
 
    public String getStudentName() {return studentName;}
    public void setStudentName(String studentName) {this.studentName = studentName;}
    public String getLectureName() {return lectureName;}
    public void setLectureName(String lectureName) {this.lectureName = lectureName;}
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}
    public String getAttendanceRecord() {return attendanceRecord;}
    public void setAttendanceRecord(String attendanceRecord) {this.attendanceRecord = attendanceRecord;}
}
