package kr.or.bit.Three;
/**
프로젝트 : 비트코인 캠프 시스템
파일이름 : Lecture.java
날    짜 : 2018. 2. 23.
작성자명 : 김 희 준
*/

import java.util.HashMap;
import java.util.Map;

/**
 클래스명 : Lecture
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
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
		return "강좌정보 [강봐번호=" + lectureNo + ", 강좌명=" + lectureName + ", 담당선생님=" + teacherName
				+ ", 최대수강인원=" + classMaxNum + ", 시작날짜=" + startDate + ", 종료날짜=" + endDate
				+ ", 수업시작시간=" + lectureStartTime + ", 수업종료시간=" + lectureEndTime + "]";
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
