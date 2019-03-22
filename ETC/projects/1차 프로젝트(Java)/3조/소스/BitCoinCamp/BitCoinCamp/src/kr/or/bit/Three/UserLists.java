/**
 ������Ʈ : ��Ʈ���� ķ�� �ý���
 �����̸� : UserLists.java
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
*/

package kr.or.bit.Three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 Ŭ������ : UserLists
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
 */
public class UserLists {
	
	private static UserLists userLists;
	private Map<String, Member> studentList; // �л�����Ʈ
	private Map<String, Member> staffList; // ������������Ʈ
	private Map<String, Member> teacherList; // �����Ը���Ʈ
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
	 ��    ¥ : 2018. 2. 23.
	 ��    �� : Singleton ������ �̿��ؼ� �ϳ��� ��ü�� ���� ����
	 �ۼ��ڸ� : �� �� ��
	 */
	public static UserLists getInstance() {
		if(userLists == null) { // �������� ��ü�� ������ ����
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
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : member/student ������ ���� ������ student ������ studentList�� ����
	 �ۼ��ڸ� : �� �� ��
	 */
	private void saveStudentList() {
		if(!studentFile.exists()) {
			System.out.println("studnet ���丮�� �������� �ʽ��ϴ�.");
		}else {
			File[] studentFileList = studentFile.listFiles();
			if(studentFileList.length == 0) {
				System.out.println("student ������ �������� �ʽ��ϴ�.");
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
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : member/teacher ������ ���� ������ teacher ������ teacherList�� ����
	 �ۼ��ڸ� : �� �� ��
	 */
	private void saveTeacherList() {
		if(!teacherFile.exists()) {
			System.out.println("teacher ���丮�� �������� �ʽ��ϴ�.");
		}else {
			File[] teacherFileList = teacherFile.listFiles();
			if(teacherFileList.length == 0) {
				System.out.println("teacher ������ �������� �ʽ��ϴ�.");
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
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : member/staff ������ ���� ������ staff ������ staffList�� ����
	 �ۼ��ڸ� : �� �� ��
	 */
	private void saveStaffList() {
		if(!staffFile.exists()) {
			System.out.println("sfaff ���丮�� �������� �ʽ��ϴ�.");
		}else {
			File[] staffFileList = staffFile.listFiles();
			if(staffFileList.length == 0) {
				System.out.println("sfaff ������ �������� �ʽ��ϴ�.");
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
