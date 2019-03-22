package kr.or.bit.Three;
/**
������Ʈ : ��Ʈ���� ķ�� �ý���
�����̸� : Lecture.java
��    ¥ : 2018. 2. 23.
�ۼ��ڸ� : �� �� ��
*/

import java.util.HashMap;
import java.util.Map;

/**
 Ŭ������ : Lecture
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
 */
public class Lecture {

	private Map<String, Student> studentList;
	private int lectureNo;
	private String lectureName;
	private String teacherName;
	private int classMaxNum;
	private String startDate;
	private String endDate;
	private String lectureStartTime;
	private String lectureEndTime;
	
	public Lecture() {
		this.studentList = new HashMap<>();
	}
	public Lecture(int lectureNo, String lectureName, String teacherName, int classMaxNum, 
			String startDate, String endDate, String lectureStartTime, String lectureEndTime){
		this.studentList = new HashMap<>();
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.teacherName = teacherName;
		this.classMaxNum = classMaxNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lectureStartTime = lectureStartTime;
		this.lectureEndTime = lectureEndTime;
	}

	@Override
	public String toString() {
		return "�������� [������ȣ=" + lectureNo + ", ���¸�=" + lectureName + ", ��缱����=" + teacherName
				+ ", �ִ�����ο�=" + classMaxNum + ", ���۳�¥=" + startDate + ", ���ᳯ¥=" + endDate
				+ ", �������۽ð�=" + lectureStartTime + ", ��������ð�=" + lectureEndTime + "]";
	}

	// Getters and Setters
	public Map<String, Student> getStudentList() {return studentList;}
	public void setStudentList(Map<String, Student> studentList) {this.studentList = studentList;}
	public int getLectureNo() {return lectureNo;}
	public void setLectureNo(int lectureNo) {this.lectureNo = lectureNo;}
	public String getLectureName() {return lectureName;}
	public void setLectureName(String lectureName) {this.lectureName = lectureName;}
	public String getTeacherName() {return teacherName;}
	public void setTeacherName(String teacherName) {this.teacherName = teacherName;}
	public int getClassMaxNum() {return classMaxNum;}
	public void setClassMaxNum(int classMaxNum) {this.classMaxNum = classMaxNum;}
	public String getStartDate() {return startDate;}
	public void setStartDate(String startDate) {this.startDate = startDate;}
	public String getEndDate() {return endDate;}
	public void setEndDate(String endDate) {this.endDate = endDate;}
	public String getLectureStartTime() {return lectureStartTime;}
	public void setLectureStartTime(String lectureStartTime) {this.lectureStartTime = lectureStartTime;}
	public String getLectureEndTime() {return lectureEndTime;}
	public void setLectureEndTime(String lectureEndTime) {this.lectureEndTime = lectureEndTime;}
}
