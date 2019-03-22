package kr.or.bit.Three;

/**
프로젝트 : 비트코인 캠프 시스템
파일이름 : Staff.java
날      짜 : 2018. 2. 23.
작성자명 : 김 명 수
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Scanner;
 
public class Staff extends Member {
 
    Scanner sc = new Scanner(System.in);
    String path = null;
    String before = null;
    String after = null;
    String id = "";
    String name = "";
    String pwd = "";
    int userLevel = 0;
    String phoneNumber = "";
    String filename = "";
    String yesOrNo = "";
    String selectnum;
 
    Staff(String id, String password, String name, int userLevel, String phoneNumber) {
        super(id, password, name, userLevel, phoneNumber);
        // TODO Auto-generated constructor stub
    }
 
    /**
     날 짜 : 2018. 2. 24. 
     기 능 : 
     작성자명 : 김 명 수
     */
    void userManagement() {
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("------------학원 사용자 관리 시스템-----------------------");
            System.out.println("-----1.사용자 등록_2.사용자 삭제_3.사용자 수정_4.반배정_5.나가기---------");
            System.out.println("--------------------------------------------------");
            System.out.print("실행 원하는  숫자를 입력해주세요");
            selectnum = sc.nextLine().trim();
            switch (selectnum) {
            case "1":
                userAdd();
                break;
            case "2":
                userDelete();
                break;
            case "3":
                userModify();
                break;
            case "4":
                classAssign();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("다시 입력해 주세요");
                break;
            }
 
        }
 
    }
 
    /**
     날 짜 : 2018. 2. 23. 
     기 능 : 등록된 사용자의 정보를 수정
     작성자명 : 김 명 수
     */
    void userModify() {
 
        System.out.println("수정할 id를 입력해 주세요");
        id = sc.nextLine();
 
        if (UserLists.getInstance().getStudentList().containsKey(id)) {
            path = "member/student/" + id + ".txt";
            Map<String, Member> listname = UserLists.getInstance().getStudentList();
            listchange(listname);
            filechange(before, after);
 
        } else if (UserLists.getInstance().getTeacherList().containsKey(id)) {
            path = "member/teacher/" + id + ".txt";
            Map<String, Member> listname = UserLists.getInstance().getTeacherList();
            listchange(listname);
            filechange(before, after);
 
        } else if (UserLists.getInstance().getStaffList().containsKey(id)) {
            path = "member/staff/" + id + ".txt";
            Map<String, Member> listname = UserLists.getInstance().getStaffList();
            listchange(listname);
            filechange(before, after);
        } else {
            System.out.println(id + "라는 user가 없습니다.");
        }
 
    }
 
    /**
     날 짜 : 2018. 2. 23. 
     기 능 : 등록된 사용자를 삭제
     작성자명 : 김 명 수
     */
    void userDelete() {
 
        Scanner sc = new Scanner(System.in);
 
        System.out.println("삭제할 id를 입력해주세요");
        String id = sc.next();
 
        if (UserLists.getInstance().getStudentList().containsKey(id)) {
            delet("member/student/" + id + ".txt");
            UserLists.getInstance().getStudentList().remove(id);
        } else if (UserLists.getInstance().getTeacherList().containsKey(id)) {
            delet("member/teacher/" + id + ".txt");
            UserLists.getInstance().getTeacherList().remove(id);
        } else if (UserLists.getInstance().getStaffList().containsKey(id)) {
            delet("member/staff/" + id + ".txt");
            UserLists.getInstance().getStaffList().remove(id);
        } else {
            System.out.println(id + "라는 id가 없습니다.");
        }
 
    }
 
    /** 
     날 짜 : 2018. 2. 24. 
     기 능 : 학생의 반 배정을 하는 함수
     작성자명 : 이 진 우
     */
    void classAssign() {
        Scanner sc = new Scanner(System.in);
        String lectureNo =""; 
        String name = "";
        String id = "";
 
        System.out.println("------개설된 강의 리스트------ ");
        if(LectureList.s_getInstance().getLectureList().size() == 0) {
            System.out.println("개설된 강의가 없습니다");
        } else {
            for(Map.Entry<String, Lecture> map : LectureList.s_getInstance().getLectureList().entrySet()){
                System.out.println(map.getValue().toString());
            }
            System.out.print("등록할 강의의 번호를 입력하세요 : ");
              lectureNo = sc.nextLine();
       
            while(true) {
                if(!LectureList.s_getInstance().getLectureList().containsKey(lectureNo)) {
                    System.out.print("강의가 존재하지 않습니다. 다시 입력하세요 : ");
                    while(true) {
                        try {
                            lectureNo = sc.nextLine();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }     else if(LectureList.s_getInstance().getLectureList().get(lectureNo).getStudentList().size() == 
                        LectureList.s_getInstance().getLectureList().get(lectureNo).getClassMaxNum()) {//현재 강의에 등록된 사람 수 ==현재 강의에 등록할수 있는 사람의 수
                    System.out.print("해당 강의의 최대인원이 초과하였습니다. 다른 강의를 입력하세요 : ");
                    while(true) {
                        try {
                            lectureNo = sc.nextLine();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                            }
                    }
                }  else {
                        break;
                }
            }
            System.out.print("학생의 아이디를 입력하세요 : ");
            id = sc.nextLine();
            
            while(true) {
                if(LectureList.s_getInstance().getLectureList().get(lectureNo).getStudentList().containsKey(id)) {
                    System.out.println("학생이 이미 존재합니다. 다시 입력하세요 : ");
                    id = sc.nextLine();
                } else if (!UserLists.getInstance().getStudentList().containsKey(id)) {
                    System.out.println("그런 학생이 존재하지 않습니다. 다시 입력하세요 : ");
                    id = sc.nextLine();
                }else {
                    LectureList.s_getInstance().getLectureList().get(lectureNo).getStudentList().put(id, (Student) UserLists.getInstance().getStudentList().get(id));
                    break;
                }
            }
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter("lecture\\"+lectureNo+".txt",true);
                bw = new BufferedWriter(fw);
                bw.write(id+" "+UserLists.getInstance().getStudentList().get(id).getPassword() +" "+
                        UserLists.getInstance().getStudentList().get(id).getName()+" " +UserLists.getInstance().getStudentList().get(id).getUserLevel()+" "+
                        UserLists.getInstance().getStudentList().get(id).getPhoneNumber());
                bw.newLine(); // 장점
                bw.flush();
                
                ((Student)UserLists.getInstance().getStudentList().get(id)).setTakingLecture(lectureNo);
                
                fw = new FileWriter("member\\student\\"+id+".txt", true);
                bw = new BufferedWriter(fw);
                bw.write(LectureList.s_getInstance().getLectureList().get(lectureNo).getLectureName());
                bw.flush();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
            	try {
					bw.close();
					fw.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
            	
			}
            System.out.println(UserLists.getInstance().getStudentList().get(id).getName() + " 학생의 등록이 완료되었습니다.");
        }
    }
 
    void userAdd() {
 
        while (true) {
            // 아이디 입력 알고리즘
            System.out.println("아이디를 입력하세요 : ");
            id = sc.nextLine().toLowerCase().trim();
            while (true) {
                if (!UserLists.getInstance().getStudentList().containsKey(id)
                        && !UserLists.getInstance().getStaffList().containsKey(id)
                        && !UserLists.getInstance().getStaffList().containsKey(id)) {// 학생 이름이
                    System.out.println("아이디를 사용하실수 있습니다");
                    break;
                } else {
                    System.out.println("이미 사용하는 아이디입니다!");
                    System.out.println("아이디를 다시입력하세요 : ");
                    id = sc.nextLine().toLowerCase().trim();
                }
            }
 
            // 비밀번호 입력 알고리즘
            System.out.println("비밀번호를 입력하세요 : ");
            pwd = sc.nextLine().trim();
 
            // 이름을 입력
            System.out.println("이름을 입력하세요 : ");
            name = sc.nextLine().trim();
 
            // 회원 분류 입력
            System.out.println("회원분류를 입력하세요 (학생 (1), 선생님 (2), 행정직원(3) : ");
            while (true) {
                try {
                    userLevel = Integer.parseInt(sc.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                if (userLevel == 1 || userLevel == 2 || userLevel == 3) {
                    break;
                } else {
                    System.out.println("입력이 잘못되었습니다");
                    System.out.println("다시 회원분류를 입력하세요 (학생 (1), 선생님 (2), 행정직원(3) : ");
                    while (true) {
                        try {
                            userLevel = Integer.parseInt(sc.nextLine().trim());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            // 전화번호 입력
            System.out.print("회원의 전화번호를 입력하세요(형식 : 010-XXXX-XXXX) : ");
            phoneNumber = sc.nextLine().trim();
            while (true) {
                if (phoneNumber.length() == 13) { // 형식을 고정한다
                    break;
                } else {
                    System.out.println("입력이 잘못되었습니다");
                    System.out.println("회원의 전화번호를 다시 입력하세요(형식 : 010-XXXX-XXXX) : ");
                    phoneNumber = sc.nextLine().trim();
                }
            }
            System.out.println(id + "/" + name + "/" + pwd + "/" + userLevel + "/" + phoneNumber);
            System.out.println("입력한 정보가 맞습니까 ? (Y/N)");
            yesOrNo = sc.nextLine().toLowerCase().trim();
            if (yesOrNo.equals("y")) {
                break;
            }
        }
        System.out.println("유저레벨 : " + userLevel);
        switch (userLevel) {
        case 1:
            UserLists.getInstance().getStudentList().put(id, new Student(id, pwd, name, userLevel, phoneNumber)); // 학생리스트에
                                                                                                                    // 추가
            fileWrite(id, pwd, name, userLevel, phoneNumber, "student"); // 학생 파일 추가
 
            try {// 학생 출결파일 추가
                FileWriter fw = new FileWriter("attendance\\" + id + ".txt");
                fw.close();
            } catch (Exception e) {
 
            }
            break;
        case 2:
            UserLists.getInstance().getTeacherList().put(id, new Teacher(id, pwd, name, userLevel, phoneNumber));
            fileWrite(id, pwd, name, userLevel, phoneNumber, "teacher");
            break;
        case 3:
            UserLists.getInstance().getStaffList().put(id, new Staff(id, pwd, name, userLevel, phoneNumber));
            fileWrite(id, pwd, name, userLevel, phoneNumber, "staff");
            break;
        }
        System.out.println("아이디가 생성되었습니다");
 
    }
 
    /**
     날 짜 : 2018. 2. 23. 
     기 능 : 파일 지우기 
     작성자명 : 김 명 수
     */
    void delet(String path) {
        File f = new File(path);
        if (f.delete()) {
            System.out.println(path + "파일 을 성공적으로 지웠습니다: ");
        } else {
            System.err.println(path + "파일 지우기 실패: ");
        }
 
    }
 
    /**
     날 짜 : 2018. 2. 23. 
     기 능 : 파일 안 단어 변경 
     작성자명 : 김 명 수
     */
    void filechange(String oldname, String newname) {
 
        File inputfile = new File(path);
        File outputfile = new File(path + ".txt");
        FileInputStream fileinputstream = null;
        BufferedReader bufferedreader = null;
        FileOutputStream fileoutputstream = null;
        BufferedWriter bufferedwriter = null;
        boolean result = false;
 
        try {
            fileinputstream = new FileInputStream(inputfile);
            fileoutputstream = new FileOutputStream(outputfile);
            bufferedreader = new BufferedReader(new InputStreamReader(fileinputstream));
            bufferedwriter = new BufferedWriter(new OutputStreamWriter(fileoutputstream));
 
            String line = "";
            String repline = "";
            String originalline = oldname;
            String replaceline = newname;
 
            while ((line = bufferedreader.readLine()) != null) {
                repline = line.replace(originalline, replaceline);
                bufferedwriter.write(repline, 0, repline.length());
 
            }
            result = true;
 
        } catch (IOException e) {
            e.printStackTrace();
 
        } finally {
            try {
                bufferedwriter.close();
                bufferedreader.close();
 
            } catch (Exception e) {
            }
 
            if (result) {
                System.out.println("삭제하고 파일 바꾸기");
                inputfile.delete();
                outputfile.renameTo(new File(path));
            }
 
        }
 
    }
 
    /**
         날 짜 : 2018. 2. 23. 
         기 능 : list 수정
         작성자명 : 김 명 수
     */
    void listchange(Map<String, Member> listname) {
 
        System.out.println("변경하고자 하는 정보를 선택하세요");
        System.out.println("1.비밀번호, 2.전화번호");
        int num = sc.nextInt();
 
        System.out.println("변경 내용을 작성해주세요");
        after = sc.next();
 
        if (num == 1) {
            before = listname.get(id).getPassword();
            listname.get(id).setPassword(after);
        } else if (num == 2) {
            before = listname.get(id).getPhoneNumber();
            listname.get(id).setPhoneNumber(after);
 
        } else {
            System.out.println("변경하고자 하는 정보의 번호를 잘못입력하셨습니다.");
 
        }
 
    }
 
    /** 
     날 짜 : 2018. 2. 23. 
     기 능 : 파일 저장 기능 
     작성자명 : 이 진 우
     */
    void fileWrite(String id, String pwd, String name, int userLevel, String phoneNumber, String level) {
 
        String data = id + " " + pwd + " " + name + " " + userLevel + " " + phoneNumber + " ";
        String path = "member\\" + level + "\\" + id + ".txt"; // level은 사람마다 다른 파일에 저장하기 위해서
        File file = new File(path);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(data); // 학생의 자료 입력
            if(userLevel == 2 || userLevel == 3) {
            	bw.newLine();
            }
            bw.flush();
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


