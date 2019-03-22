package kr.or.bit.Three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
 
 
/**
 ������Ʈ : ��Ʈ���� ķ�� �ý��� 
 �����̸� : Student.java
 ��      ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� �� / �� â ��
*/
 
/**
 Ŭ������ : Student
 ��      ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� �� / �� â ��
 */
public class Student extends Member {
 
    //�л��� ������ ��������
    public Student(String id, String password, String name, int userLevel, String phoneNumber) {
        super(id, password, name, userLevel, phoneNumber);
    }
    public Student() {}
    
    private String takingLecture = ""; //�������� ����
    private Map<Integer, Attendance> map = new HashMap<Integer, Attendance>(); 
              //����ī��Ʈ, �⼮
    private int count = 1; // ����ī��Ʈ
    
    // Getters and Setters
    public String getTakingLecture() {return takingLecture;}
	public void setTakingLecture(String takingLecture) {this.takingLecture = takingLecture;}

	/**
    ��      ¥ : 2018. 2. 23. 
    ��      �� : �⼮�ϱ� �Լ� 
    �ۼ��ڸ� : �� â ��
    */
    public void attending() {
        Attendance attendance = new Attendance();
        if(takingLecture == null) {
            System.out.println("�������� ���ǰ� �����ϴ�. ���� �������� ���� �ϼ���.");
            return;
        }
        try {
            map.put(count++, attendance.input(attendance,super.getName(), takingLecture));
        } catch (Exception e) {
            System.out.println("�⼮�ϱ⿡ �����Ͽ����ϴ�. ���� �������� ���� �ϼ���.");
            e.printStackTrace();
        }
        System.out.println("�⼮�� �Ϸ� �Ǿ����ϴ�.");
    }
    
    /**
    ��      ¥ : 2018. 2. 23. 
    ��      �� : �⼮üũ�ϸ鼭 �ش系�� attendance\\id.txt ���Ͽ� �����ϴ� �Լ� 
    �ۼ��ڸ� : �� â ��
    */
    public void attendingCheck() {
        Set<Integer> set = map.keySet();
        int count2 = 1;
 
        for (Integer number : set) {
 
            String sname = map.get(number).getStudentName();
            String lname = map.get(number).getLectureName();
            String date = map.get(number).getDate();
            String attendanceRecord = map.get(number).getAttendanceRecord();
            System.out.printf("��ȣ : %s �л�ID : %s ���¸� : %s ��¥&�ð� : %s ��Ῡ�� : %s\n", count2, sname, lname, date, attendanceRecord);
            count2++;
            File fileDir = new File("attendance"); // ���������ϱ�
            if (!fileDir.exists()) { // ���� �̸��� ������ ���� �ϴ��� Ȯ�� �ϴ� if��
                fileDir.mkdirs();
            }
            File file = new File("attendance\\id.txt");// �����ȿ� ���� �����ϱ�
            FileWriter fw = null;
            BufferedWriter bfw = null;
            try {
                fw = new FileWriter(file, true); // file �ȿ� �Է��س��� ����
                bfw = new BufferedWriter(fw);
                bfw.write("�л��̸� :" + sname + " / ");
                bfw.write("�����̸� :" + lname + " / ");
                bfw.write("��¥�׽ð� :" + date + " / ");
                // bfw.write(time + " ");
                bfw.write("��᳻�� :" + attendanceRecord);
                bfw.newLine(); // �������� �ٹٲ��ϱ�
 
            } catch (Exception e) {
                System.out.println("�ҷ����µ� �����߽��ϴ�.");
                System.out.println(e.getMessage());
            } finally {
                try {
                    bfw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
 
            }
        }
 
    }
 
    /**
    ��      ¥ : 2018. 2. 23. 
    ��      �� : id.txt���Ͽ� ����Ǿ��ִ� ������ �ҷ����� �Լ� 
    �ۼ��ڸ� : �� â ��
    */
    public void attendingLoad() {
        File file = new File("attendance\\id.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
 
            String line = "";
            while ((line = bfr.readLine()) != null) {
                String[] word = line.split(" ");
                for (int i = 0; i < word.length; i++) {
                    System.out.print(word[i] + " ");
                }
                System.out.println();
 
            }
        } catch (Exception e) {
            System.out.println("�ҷ����µ� �����߽��ϴ�.");
            e.printStackTrace();
        }
 
    }
 
    /**
    ��      ¥ : 2018. 2. 23.
    ��      �� : ���Ȯ�� (�л��� �ڽ���  (����û)�� ����� Ȯ�� �Ѵ�)
    �ۼ��ڸ� : �� �� ��
    */
    public void consultinCheck() {
        String baseDir = "consult"; //�˻��� ���丮
        String save = super.getId()+".txt"; //�ش� �л��� ������� ����� ���ϸ�
        
        File dir = new File(baseDir); // �л��������
        File file = new File(baseDir + "\\" + save); // �л�������� + �л������ ����
        
        //�˻��� ���丮�� ������ ���� {ex)�ƹ��� ����� ������ ����(������ �������� ����)}
        if(!dir.isDirectory()){ 
            System.out.println("�л���������� �����ϴ�.\n"
                            + super.getName() +"�� �Ӹ��� �ƴ϶� �л� ��� ������ ����û�� ������ �����ϴ� \n"
                            + "��� ��û�� ���� ���ּ���.");
            return; //�Լ�����
        }
        
        //������ �л�������� ���ٸ�
        if(!file.exists()) { 
            System.out.println(super.getName()+"���� ��� ����� �����ϴ�."
                            + "��� ��û�� ���� ���ּ���.");
            return; //�Լ�����
        }
        
        //�л��� ��� ����� �ִٸ�
        BufferedReader br = null;
 
        File[] files = dir.listFiles(); // (consult)�� ���� �ڿ�(����, ����)
        try {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isFile()) { // �л�ID.txt �� �ʿ��ϹǷ�
                    continue; // ������ �ƴ� ��� skip
                }
 
                // files[i] = {"consult\�л�ID.txt", "consult\�л�ID.txt", ... } �� �� ����
                br = new BufferedReader(new FileReader(files[i]));
 
                // files[i] = consult\�л�ID.txt
                // file = consult\�л�ID.txt
                if (files[i].equals(file)) { // ���ϵ��� �̸��� �л��̸����� �� txt������ ������
                    String line = "";
                    while ((line = br.readLine()) != null) { // ������ �� ���� �� ����
                        System.out.println(line); // ���
                    }
                    break; //for�� ����
                }
            }
        } catch (IOException e) {
            System.out.println("ã�� ����~");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
    ��      ¥ : 2018. 2. 23.
    ��      �� : ����û (�л��� ������ Ŭ������ �ִ� consultingList.add�� ����û�� �Ѵ�)
    �ۼ��ڸ� : �� �� ��
    */
    public void consultingAdd() {
        Student student; //�ڽ�! (�ڽ��� �л���)
        Consulting consulting = new Consulting(); //��� Ŭ����
        
        if(takingLecture == null) { //�л����� �� ������ �� �Ǿ��ִٸ�
            System.out.println("�ݹ����� �Ϸ���� �ʾҽ��ϴ�.\n"
                             + "������������ ���� ���ּ���.");
            return; //�Լ�����
        }
        
        //��㸮��Ʈ��  �ڽ�(�л�)! �� add���ش�.
        consulting.consultingList.add(this);

        
        System.out.println(super.getName() + "���� ����û�� ���������� �Ϸ�Ǿ����ϴ�.");
        
        //����û�� �Ϸ�Ǹ� 
        //�л� ��� ��Ͽ� ������ �Ǿ�� �Ѵ�.
        String path = "consult\\"+super.getId()+".txt"; //������ ���
        
        File file = new File(path); //��θ� ���Ͽ� ����
        
        File filepath = new File("consult"); //���������� ������ �������� FileŸ��
        if(!filepath.mkdir()) { //���� ������ ���ٸ�
            filepath.mkdirs(); //���� ������ ���� ���ش�.
        }
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            Calendar cal = Calendar.getInstance();
            Date_Time date = new Date_Time(); // ��¥�� ����ϱ�����!!
            
            fw = new FileWriter(file, true); //���� �������(�߰� write �����ϰ�)
            bfw = new BufferedWriter(fw); //���۱��
            
            String text = "��¥&�ð� : " + date.getDate(cal) + " ��� ���� ���¸� : " + takingLecture; //���Ͽ� �Է� �� ����
            
            bfw.write(text); //�Է��� ���ش�
            bfw.newLine(); //������ �� ��û�� �Է��� �����ϵ���
            bfw.flush(); //���۸� ����
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                bfw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
    ��      ¥ : 2018. 2. 23.
    ��      �� : ����Ȯ�� (�л��� �ڽ��� ���躻 �������� Ȯ�� �� �� �ִ�)
    �ۼ��ڸ� : �� �� ��
    */
    public void scoreCheck() {        
        if(LectureList.s_getInstance().getLectureList().size() < 1) {
            return; // �Լ� ����
        }
        
        String lectureName = takingLecture; //�����̸�
        
        for(Map.Entry<String, Lecture> map : LectureList.s_getInstance().getLectureList().entrySet()){
            //(Lecture)map.getValue()).getLectureName() => �����̸�
            if(((Lecture)map.getValue()).getLectureName().equals(takingLecture)) {;// �������� ���¿� �̸��� ���ٸ�
                lectureName = ((Lecture)map.getValue()).getLectureName(); //�����̸�
                break;//for�� ����������
            }
        }
        
        if(lectureName.equals("")) { //�� ���ڿ��̶��
            System.out.println("������ �̸��� �ٸ��ų� �����ϴ� ���°� �����ϴ�.");
            return; // �Լ� ����
        }
        
        // -> score/lectureName.txt �������� ������ �����ϴ� ��
        String baseDir = "score"; //�˻��� ���丮 (������ ����Ǿ��ִ°�)
        String save = lectureName+".txt"; //�ش� �л��� ������� ����� ���ϸ�
        File dir = new File(baseDir); // ������������
        File file = new File(baseDir + "\\" + save); // ������������ + ���¸�_�л�������� ����
        
        //�˻��� ���丮�� ������ ���� {ex)������ ����� �������� ����(������ �������� ����)}
        if(!dir.isDirectory()){ 
            System.out.println("����� ������ ������ �����ϴ�.\n"
                            + "�������� ����� ������ �����ϴ�.\n"
                            + "�����Բ� �������ֽñ� �ٶ��ϴ�.");
            return; //�Լ�����
        }
        
        //������ ���¸�_�л���������� ���ٸ�
        if(!file.exists()) { 
            System.out.println(lectureName+" ���¿� ��ϵ� ��������� �����ϴ�."
                            + "�����Բ� �������ֽñ� �ٶ��ϴ�.");
            return; //�Լ�����
        }
            
        //���¸�_�л���������� �ִٸ�
        BufferedReader br = null;
 
        File[] files = dir.listFiles(); // (score)�� ���� �ڿ�(����, ����)
        try {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isFile()) { // lectureName.txt �� �ʿ��ϹǷ�
                    continue; // ������ �ƴ� ��� skip
                }
 
                // files[i] = {"score\���¸�.txt", "score\���¸�.txt", ... } �� �� ����
                br = new BufferedReader(new FileReader(files[i]));
 
                
                if (files[i].equals(file)) { // ���ϵ��� �̸��� �л��̸����� �� txt������ ������
                    String line = "";
                    while ((line = br.readLine()) != null) { // ������ �� ���� �� ����
                        System.out.println(line); // ���
                    }
                    break; //for�� ����
                }
                
                //�� ������ �����͸� ���δ����� �о
                String line = "";
                while((line = br.readLine()) != null){
                    if(line.indexOf(super.getId()) != -1){ // txt���� �ȿ� �ش� �л��� ���̵� ��� �ִٸ�
                        System.out.println(line); // �� Line�� ����Ѵ�.
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ã�� ����~");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
