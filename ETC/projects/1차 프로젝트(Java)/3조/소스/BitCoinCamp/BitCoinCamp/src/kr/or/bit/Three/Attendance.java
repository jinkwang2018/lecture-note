package kr.or.bit.Three;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
Ŭ������ : Attendance
��      ¥ : 2018. 2. 23.
�ۼ��ڸ� : �� â ��
*/
public class Attendance {
 
    private String studentName;
    private String lectureName;
    private String date;
    private String time;
    private String attendanceRecord;
	/**
	��      ¥ : 2018. 2. 23.
	��      �� : �л��� ���� ����ϴ� �Լ� 
	�ۼ��ڸ� : �� â ��
	*/
    public Attendance input(Attendance attendance, String sname, String lname){
        Calendar cal = Calendar.getInstance();
        this.studentName = sname;
        this.lectureName = lname;
        this.date = Date_Time.getDate(cal);
        String reqDateStr = Date_Time.getDate2(cal) + "0900";// �����ð�
        Date curDate = new Date(); // ����ð� �ּҰ� Ȯ���ϱ�
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        // ��û�ð��� Date�� parsing �� time��������
 
        Date reqDate; 
        long reqDateTime = 0;
                
        
        try {
        	reqDate = dateFormat.parse(reqDateStr);
        	reqDateTime = reqDate.getTime();
            // ����ð��� ��û�ð��� ���·� format �� time ��������
            curDate = dateFormat.parse(dateFormat.format(curDate));
            // ����ð� �ּ�Ÿ������ ��ȯ�ϱ�
        } catch (ParseException e) {
            
            e.printStackTrace();
        } 
 
        long curDateTime = curDate.getTime(); // ������ ǥ��
        long min = (curDateTime - reqDateTime) / 60000;
        if (min <= 10) {
            this.attendanceRecord = "- �⼮ -";
        } else if (min > 10 && min <= 240) {
            if (min > 59) {
                String time = min / 60 + "�ð�" + min % 60 + "�� ";
                this.attendanceRecord = "- ���� -  *���� ���� �� " + time + " �ʰ� �Ǿ����ϴ�.";
            } else {
                this.attendanceRecord = "- ���� -  *���� ���� �� " + min + "�� �ʰ� �Ǿ����ϴ�.";
            }
 
        } else {
            String time = min / 60 + "�ð�" + min % 60 + "�� ";
            this.attendanceRecord = "- �Ἦ -  *���� ���� �� " + time + " �ʰ� �Ǿ����ϴ�.";
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
