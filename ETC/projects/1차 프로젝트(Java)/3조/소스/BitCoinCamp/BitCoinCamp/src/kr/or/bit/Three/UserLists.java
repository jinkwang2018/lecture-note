/**
 프로젝트 : 비트코인 캠프 시스템
 파일이름 : UserLists.java
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
*/

package kr.or.bit.Three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 클래스명 : UserLists
 날    짜 : 2018. 2. 23.
 작성자명 : 김 희 준
 */
public class UserLists {
	
	private static UserLists userLists;
	private Map<String, Member> studentList; // 학생리스트
	private Map<String, Member> staffList; // 행정직원리스트
	private Map<String, Member> teacherList; // 선생님리스트
	private FileReader fr;
	private BufferedReader br;
	private File studentFile;
	private File teacherFile;
	private File staffFile;
	
	// Getters
	public Map<String, Member> getStudentList() {return studentList;}
	public Map<String,Member> getStaffList() {return staffList;}
	public Map<String, Member> getTeacherList() {return teacherList;}
	
	/**
	 날    짜 : 2018. 2. 23.
	 기    능 : Singleton 패턴을 이용해서 하나의 객체만 만들어서 공유
	 작성자명 : 김 희 준
	 */
	public static UserLists getInstance() {
		if(userLists == null) { // 만들어놓은 객체가 없으면 만듬
			userLists = new UserLists();
		}
		return userLists;
	}
	
	private UserLists() {
		studentList = new HashMap<>();
		staffList = new HashMap<>();
		teacherList = new HashMap<>();
		
		fr = null;
		br = null;
		
		studentFile = new File("member/student");
		teacherFile = new File("member/teacher/");
		staffFile = new File("member/staff");
		
		saveStudentList();
		saveTeacherList();
		saveStaffList();
	}

	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : member/student 폴더로 들어가서 각각의 student 파일을 studentList에 저장
	 작성자명 : 김 희 준
	 */
	private void saveStudentList() {
		if(!studentFile.exists()) {
			System.out.println("studnet 디렉토리가 존재하지 않습니다.");
		}else {
			File[] studentFileList = studentFile.listFiles();
			if(studentFileList.length == 0) {
				System.out.println("student 파일이 존재하지 않습니다.");
			}else {
				try {
					for(int i = 0; i < studentFileList.length; i++) {
						fr = new FileReader(studentFileList[i]);
						br = new BufferedReader(fr);
							
						String line = br.readLine();
						String[] std = line.split(" ");
						
						Student student = new Student();
						for(int j = 0; j < std.length; j++) {
							switch (j) {
							case 0:
								student.setId(std[j]);
								break;
							case 1:
								student.setPassword(std[j]);
								break;
							case 2:
								student.setName(std[j]);
								break;
							case 3:
								int num = 0;
								try {
									num = Integer.parseInt(std[j]);
								} catch (NumberFormatException e) {
									System.out.println(e.getMessage());
									num = 1;
								} finally {
									student.setUserLevel(num);
								}
								break;
							case 4:
								student.setPhoneNumber(std[j]);
								break;
							case 5:
								student.setTakingLecture(std[j]);
								break;
							default:
								break;
							}
						}
						
						studentList.put(std[0], student);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : member/teacher 폴더로 들어가서 각각의 teacher 파일을 teacherList에 저장
	 작성자명 : 김 희 준
	 */
	private void saveTeacherList() {
		if(!teacherFile.exists()) {
			System.out.println("teacher 디렉토리가 존재하지 않습니다.");
		}else {
			File[] teacherFileList = teacherFile.listFiles();
			if(teacherFileList.length == 0) {
				System.out.println("teacher 파일이 존재하지 않습니다.");
			}else {
				try {
					for(int i = 0; i < teacherFileList.length; i++) {
						fr = new FileReader(teacherFileList[i]);
						br = new BufferedReader(fr);
							
						String line = br.readLine();
						String[] std = line.split(" ");
							
						teacherList.put(std[0], new Teacher(std[0], std[1], std[2], Integer.parseInt(std[3]), std[4]));
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
	
	/**
	 날    짜 : 2018. 2. 24.
	 기    능 : member/staff 폴더로 들어가서 각각의 staff 파일을 staffList에 저장
	 작성자명 : 김 희 준
	 */
	private void saveStaffList() {
		if(!staffFile.exists()) {
			System.out.println("sfaff 디렉토리가 존재하지 않습니다.");
		}else {
			File[] staffFileList = staffFile.listFiles();
			if(staffFileList.length == 0) {
				System.out.println("sfaff 파일이 존재하지 않습니다.");
			}else {
				try {
					for(int i = 0; i < staffFileList.length; i++) {
						fr = new FileReader(staffFileList[i]);
						br = new BufferedReader(fr);
							
						String line = br.readLine();
						String[] std = line.split(" ");
							
						staffList.put(std[0], new Staff(std[0], std[1], std[2], Integer.parseInt(std[3]), std[4]));
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
