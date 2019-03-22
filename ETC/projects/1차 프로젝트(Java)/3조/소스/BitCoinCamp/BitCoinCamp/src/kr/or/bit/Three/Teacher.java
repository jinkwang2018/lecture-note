package kr.or.bit.Three;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
Ŭ������ : Teacher
��      ¥ : 2018. 2. 23.
�ۼ��ڸ� : �� �� �� / �� �� ��
 */
public class Teacher extends Member{
 
    public Teacher(String id, String password, String name, int userLevel, String phoneNumber) {
        super(id, password, name, userLevel, phoneNumber);
    }
    /**
    ��      ¥ : 2018. 2. 23.
    ��      �� : ���¸� �߰��ϴ� ���
    �ۼ��ڸ� : �� �� ��
     */
    public void lectureAddLecture() {
        
         File file = new File("lecture"); // ���������� ������ �������� FileŸ��
         
         if (!file.mkdir()) { // ���� ������ ���ٸ�
             file.mkdirs(); // ���� ������ ���� ���ش�.
         }
         
        System.out.println("������ ���¸� �Է��ϼ���");
        Scanner scan = new Scanner(System.in);
        System.out.println("���¹�ȣ�� �Է����ּ���");
        int lectureNo = 0;
        
        try {
            lectureNo = Integer.parseInt(scan.nextLine());
        }catch(Exception e) {
            System.out.println("Ʋ�ǽ��ϴ�");
            return;
        }
        System.out.println("�����̸��� �Է��ϼ���");
        String lectureName = scan.nextLine();
        String teacherName = super.getName();
        System.out.println("�ִ�����ο��� �Է��ϼ���");
        int classMaxNum = 0;
        try {
            classMaxNum = Integer.parseInt(scan.nextLine());    //String�� intŸ������ �ٲ��ش�
        }catch(Exception e) {
            System.out.println("Ʋ�ǽ��ϴ�");
            return;
        }
        System.out.println("���۳�¥�� �Է��ϼ��� ex)18.02.23");
        String startDate = scan.nextLine();
        System.out.println("���ᳯ¥�� �Է��ϼ��� ex)18.03.23");
        String endDate = scan.nextLine();
        System.out.println("���۽ð��� �Է��ϼ��� ex)9:00");
        String lectureStartTime = scan.nextLine();
        System.out.println("����ð��� �Է��ϼ��� ex)18:00");
        String lectureEndTime = scan.nextLine();
        
        FileWriter fw = null;
        BufferedWriter bfw = null;
        
        try {
            
             fw = new FileWriter("lecture\\" + String.valueOf(lectureNo) + ".txt");
             bfw = new BufferedWriter(fw);
             
             
             bfw.write(lectureNo+" ");        // ���� ��ȣ
             bfw.write(lectureName+" ");    // ���� �̸�
             bfw.write(teacherName+" ");    // ���� �̸�
             bfw.write(classMaxNum+" ");    // �ִ� ���� �ο�
             bfw.write(startDate+" ");    // ���� ���� ��¥
             bfw.write(endDate+" ");    // ���� ���� ��¥
             bfw.write(lectureStartTime+" ");    // ���� ���� �ð�
             bfw.write(lectureEndTime);    // ���� ���� �ð�
             bfw.newLine();
             bfw.flush();
             
             /////////////////// �迭�� �� �����ϱ� ///////////////
             LectureList.s_getInstance().getLectureList().put(String.valueOf(lectureNo), new Lecture(lectureNo, lectureName, teacherName,classMaxNum, startDate, endDate, lectureStartTime, lectureEndTime));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bfw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
    ��      ¥ : 2018. 2. 24.
    ��      �� : ������ ����Ѵ�
    �ۼ��ڸ� : �� �� �� / �� �� �� / �� �� ��
     */
    public void scoreManagement(){
 
        Score score; // ����
        Student student; // �л�
 
        //score\\lectureName.txt �� ���� �� ����.
        /////// score ������ ������� || ������ �������� ���� ////////
        File file = new File("score"); // ���������� ������ �������� FileŸ��
        
        if (!file.mkdir()) { // ���� ������ ���ٸ�
            file.mkdirs(); // ���� ������ ���� ���ش�.
        }
        /////// score ������ ������� || ������ �������� ����  �Ϸ� ////////
        
        /////// ���¸��� �Է��Ͽ� lectureName(���¸�).txt �� ã�� ///////
        System.out.println("���¸��� �Է��ϼ���");
        Scanner sc = new Scanner(System.in);
        
        String lecNametxt = sc.nextLine(); // ���¸��� �Է�
        
        //score\\lectureName.txt �� ���� �� ��
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            fw = new FileWriter("score\\"+ lecNametxt + ".txt", true);
            bfw = new BufferedWriter(fw);
            
            System.out.println("������ ����� �л��� ID�� �Է��ϼ���");
            
            String studentId = ""; 
            studentId = sc.nextLine(); // �л�ID
            
            System.out.println("�л��� ������ �Է��ϼ���");
            int studentScore = sc.nextInt(); // ����
            
            if(studentScore>990||studentScore<0) {
                System.out.println("�߸��� ������ �Է��ϼ˽��ϴ�. 990������ ������ �Է����ּ���");
            }else {
                bfw.write("�л�ID:" + studentId+"/ ����:"+studentScore+"��");
                bfw.newLine();
                bfw.flush();
                System.out.println("������ ��ϵǾ����ϴ�");
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bfw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
    ��      ¥ : 2018. 2. 24.
    ��      �� : �л��� ������ �����Ѵ� 
    �ۼ��ڸ� : �� �� �� / �� �� �� / �� �� ��
    */
    public void scoreModify() {
        ////////////// ���¸�.txt ã�� /////////////
        System.out.println("���¸��� �Է��ϼ���");
        Scanner sc = new Scanner(System.in);
        
        String lecNametxt = sc.nextLine(); // ���¸��� �Է�
        
        /////////////  ���� ������ �л�ID ////////////
        System.out.print("������ �л��� ID�� �Է��� �ּ��� : ");
        String id = sc.nextLine();
        
        System.out.print("������ �л��� ������ �Է��� �ּ��� : ");
        int score = sc.nextInt();
        
        if(score>990||score<0) {
            System.out.println("�߸��� ������ �Է��߽��ϴ�. 990�� ������ ������ �Է��ϼ���");
        }else {
            //���¸�.txt ���
            String path = "score\\"+lecNametxt+".txt";
            File file = new File(path);
            
            //�迭�� �о�� ���� ������ �־��ش�.
            List<String> tempLine = new ArrayList<>();
            
            //�б�
            FileReader fr = null;
            BufferedReader bfr = null;
            
            try {
                fr = new FileReader(file);
                bfr = new BufferedReader(fr);
                
                String line = "";
                while((line = bfr.readLine()) != null) {
                    if(line.indexOf(id)<0) { //���ο� �л��� ���̵� ���ٸ�
                        tempLine.add(line);  //List�� ����
                    }else { //���ο� �л��� ���̵� �ִٸ�
                        tempLine.add("�л�ID:" + id +"/ ����:"+score+"��");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    bfr.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            //�����
            FileWriter fw = null;
            BufferedWriter bfw = null;
            
            try {
                fw = new FileWriter(file);
                bfw = new BufferedWriter(fw);
                
                //List�� �ִ� String���� ���¸�.txt���Ͽ� ������.
                Iterator<String> it = tempLine.iterator();
                while(it.hasNext()) {
                    bfw.write(it.next());
                    bfw.newLine();
                }
            } catch (Exception e) {
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
    ��      �� : ������ ���� Ȯ��
    �ۼ��ڸ� : �� �� ��
     */
    public void lectureChecking() {
        /*
        4. ���¸� �����ϸ� ������ �ڼ��� ����(���¹�ȣ, �����̸�, �������̸�, 
                ���������ο�, ���۳�¥, ���ᳯ¥, ���½��۽ð�, ��������ð�)�� �����ش�.*/
        
        for(Map.Entry<String, Lecture> map : LectureList.s_getInstance().getLectureList().entrySet()){
            System.out.println("["+ map.getValue().toString()+"]");    // ������ ������ ���
        }
    }
    
    public void lectureDelete() {
        System.out.println("���� ���� ��ȣ�� �Է��ϼ���");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();    // ���� ��ȣ �Է�
        
        
        ///////     LectureList Ŭ������ getLectureList �Լ� ��� ////////
        //     �Է��� ����� key���� ���Ͽ� ���� ��ο� key���� ������ �̸��� ������ ã�Ƽ� ����
        if(LectureList.s_getInstance().getLectureList().containsKey(String.valueOf(no))){
            LectureList.s_getInstance().getLectureList().remove(String.valueOf(no));
            String path = "lecture\\" + String.valueOf(no) + ".txt";
            File file = new File(path);
            if (file.exists()) {    // �ش� ������ �����Ѵٸ�
                file.delete();      // ������ �����Ѵ�
                System.out.println(path);    
                System.out.println("��������");
            }
        }else {
            System.out.println("�ش簭�¹�ȣ�� �����ϴ�.");
        }
    }
}

