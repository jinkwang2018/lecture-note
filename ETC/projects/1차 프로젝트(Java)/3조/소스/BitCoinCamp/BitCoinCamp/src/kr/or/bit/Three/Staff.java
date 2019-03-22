package kr.or.bit.Three;

/**
������Ʈ : ��Ʈ���� ķ�� �ý���
�����̸� : Staff.java
��      ¥ : 2018. 2. 23.
�ۼ��ڸ� : �� �� ��
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
     �� ¥ : 2018. 2. 24. 
     �� �� : 
     �ۼ��ڸ� : �� �� ��
     */
    void userManagement() {
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("------------�п� ����� ���� �ý���-----------------------");
            System.out.println("-----1.����� ���_2.����� ����_3.����� ����_4.�ݹ���_5.������---------");
            System.out.println("--------------------------------------------------");
            System.out.print("���� ���ϴ�  ���ڸ� �Է����ּ���");
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
                System.out.println("�ٽ� �Է��� �ּ���");
                break;
            }
 
        }
 
    }
 
    /**
     �� ¥ : 2018. 2. 23. 
     �� �� : ��ϵ� ������� ������ ����
     �ۼ��ڸ� : �� �� ��
     */
    void userModify() {
 
        System.out.println("������ id�� �Է��� �ּ���");
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
            System.out.println(id + "��� user�� �����ϴ�.");
        }
 
    }
 
    /**
     �� ¥ : 2018. 2. 23. 
     �� �� : ��ϵ� ����ڸ� ����
     �ۼ��ڸ� : �� �� ��
     */
    void userDelete() {
 
        Scanner sc = new Scanner(System.in);
 
        System.out.println("������ id�� �Է����ּ���");
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
            System.out.println(id + "��� id�� �����ϴ�.");
        }
 
    }
 
    /** 
     �� ¥ : 2018. 2. 24. 
     �� �� : �л��� �� ������ �ϴ� �Լ�
     �ۼ��ڸ� : �� �� ��
     */
    void classAssign() {
        Scanner sc = new Scanner(System.in);
        String lectureNo =""; 
        String name = "";
        String id = "";
 
        System.out.println("------������ ���� ����Ʈ------ ");
        if(LectureList.s_getInstance().getLectureList().size() == 0) {
            System.out.println("������ ���ǰ� �����ϴ�");
        } else {
            for(Map.Entry<String, Lecture> map : LectureList.s_getInstance().getLectureList().entrySet()){
                System.out.println(map.getValue().toString());
            }
            System.out.print("����� ������ ��ȣ�� �Է��ϼ��� : ");
              lectureNo = sc.nextLine();
       
            while(true) {
                if(!LectureList.s_getInstance().getLectureList().containsKey(lectureNo)) {
                    System.out.print("���ǰ� �������� �ʽ��ϴ�. �ٽ� �Է��ϼ��� : ");
                    while(true) {
                        try {
                            lectureNo = sc.nextLine();
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }     else if(LectureList.s_getInstance().getLectureList().get(lectureNo).getStudentList().size() == 
                        LectureList.s_getInstance().getLectureList().get(lectureNo).getClassMaxNum()) {//���� ���ǿ� ��ϵ� ��� �� ==���� ���ǿ� ����Ҽ� �ִ� ����� ��
                    System.out.print("�ش� ������ �ִ��ο��� �ʰ��Ͽ����ϴ�. �ٸ� ���Ǹ� �Է��ϼ��� : ");
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
            System.out.print("�л��� ���̵� �Է��ϼ��� : ");
            id = sc.nextLine();
            
            while(true) {
                if(LectureList.s_getInstance().getLectureList().get(lectureNo).getStudentList().containsKey(id)) {
                    System.out.println("�л��� �̹� �����մϴ�. �ٽ� �Է��ϼ��� : ");
                    id = sc.nextLine();
                } else if (!UserLists.getInstance().getStudentList().containsKey(id)) {
                    System.out.println("�׷� �л��� �������� �ʽ��ϴ�. �ٽ� �Է��ϼ��� : ");
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
                bw.newLine(); // ����
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
            System.out.println(UserLists.getInstance().getStudentList().get(id).getName() + " �л��� ����� �Ϸ�Ǿ����ϴ�.");
        }
    }
 
    void userAdd() {
 
        while (true) {
            // ���̵� �Է� �˰���
            System.out.println("���̵� �Է��ϼ��� : ");
            id = sc.nextLine().toLowerCase().trim();
            while (true) {
                if (!UserLists.getInstance().getStudentList().containsKey(id)
                        && !UserLists.getInstance().getStaffList().containsKey(id)
                        && !UserLists.getInstance().getStaffList().containsKey(id)) {// �л� �̸���
                    System.out.println("���̵� ����ϽǼ� �ֽ��ϴ�");
                    break;
                } else {
                    System.out.println("�̹� ����ϴ� ���̵��Դϴ�!");
                    System.out.println("���̵� �ٽ��Է��ϼ��� : ");
                    id = sc.nextLine().toLowerCase().trim();
                }
            }
 
            // ��й�ȣ �Է� �˰���
            System.out.println("��й�ȣ�� �Է��ϼ��� : ");
            pwd = sc.nextLine().trim();
 
            // �̸��� �Է�
            System.out.println("�̸��� �Է��ϼ��� : ");
            name = sc.nextLine().trim();
 
            // ȸ�� �з� �Է�
            System.out.println("ȸ���з��� �Է��ϼ��� (�л� (1), ������ (2), ��������(3) : ");
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
                    System.out.println("�Է��� �߸��Ǿ����ϴ�");
                    System.out.println("�ٽ� ȸ���з��� �Է��ϼ��� (�л� (1), ������ (2), ��������(3) : ");
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
            // ��ȭ��ȣ �Է�
            System.out.print("ȸ���� ��ȭ��ȣ�� �Է��ϼ���(���� : 010-XXXX-XXXX) : ");
            phoneNumber = sc.nextLine().trim();
            while (true) {
                if (phoneNumber.length() == 13) { // ������ �����Ѵ�
                    break;
                } else {
                    System.out.println("�Է��� �߸��Ǿ����ϴ�");
                    System.out.println("ȸ���� ��ȭ��ȣ�� �ٽ� �Է��ϼ���(���� : 010-XXXX-XXXX) : ");
                    phoneNumber = sc.nextLine().trim();
                }
            }
            System.out.println(id + "/" + name + "/" + pwd + "/" + userLevel + "/" + phoneNumber);
            System.out.println("�Է��� ������ �½��ϱ� ? (Y/N)");
            yesOrNo = sc.nextLine().toLowerCase().trim();
            if (yesOrNo.equals("y")) {
                break;
            }
        }
        System.out.println("�������� : " + userLevel);
        switch (userLevel) {
        case 1:
            UserLists.getInstance().getStudentList().put(id, new Student(id, pwd, name, userLevel, phoneNumber)); // �л�����Ʈ��
                                                                                                                    // �߰�
            fileWrite(id, pwd, name, userLevel, phoneNumber, "student"); // �л� ���� �߰�
 
            try {// �л� ������� �߰�
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
        System.out.println("���̵� �����Ǿ����ϴ�");
 
    }
 
    /**
     �� ¥ : 2018. 2. 23. 
     �� �� : ���� ����� 
     �ۼ��ڸ� : �� �� ��
     */
    void delet(String path) {
        File f = new File(path);
        if (f.delete()) {
            System.out.println(path + "���� �� ���������� �������ϴ�: ");
        } else {
            System.err.println(path + "���� ����� ����: ");
        }
 
    }
 
    /**
     �� ¥ : 2018. 2. 23. 
     �� �� : ���� �� �ܾ� ���� 
     �ۼ��ڸ� : �� �� ��
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
                System.out.println("�����ϰ� ���� �ٲٱ�");
                inputfile.delete();
                outputfile.renameTo(new File(path));
            }
 
        }
 
    }
 
    /**
         �� ¥ : 2018. 2. 23. 
         �� �� : list ����
         �ۼ��ڸ� : �� �� ��
     */
    void listchange(Map<String, Member> listname) {
 
        System.out.println("�����ϰ��� �ϴ� ������ �����ϼ���");
        System.out.println("1.��й�ȣ, 2.��ȭ��ȣ");
        int num = sc.nextInt();
 
        System.out.println("���� ������ �ۼ����ּ���");
        after = sc.next();
 
        if (num == 1) {
            before = listname.get(id).getPassword();
            listname.get(id).setPassword(after);
        } else if (num == 2) {
            before = listname.get(id).getPhoneNumber();
            listname.get(id).setPhoneNumber(after);
 
        } else {
            System.out.println("�����ϰ��� �ϴ� ������ ��ȣ�� �߸��Է��ϼ̽��ϴ�.");
 
        }
 
    }
 
    /** 
     �� ¥ : 2018. 2. 23. 
     �� �� : ���� ���� ��� 
     �ۼ��ڸ� : �� �� ��
     */
    void fileWrite(String id, String pwd, String name, int userLevel, String phoneNumber, String level) {
 
        String data = id + " " + pwd + " " + name + " " + userLevel + " " + phoneNumber + " ";
        String path = "member\\" + level + "\\" + id + ".txt"; // level�� ������� �ٸ� ���Ͽ� �����ϱ� ���ؼ�
        File file = new File(path);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(data); // �л��� �ڷ� �Է�
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


