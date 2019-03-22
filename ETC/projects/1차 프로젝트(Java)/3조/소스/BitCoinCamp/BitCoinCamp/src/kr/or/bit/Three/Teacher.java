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
클래스명 : Teacher
날      짜 : 2018. 2. 23.
작성자명 : 최 재 욱 / 정 민 재
 */
public class Teacher extends Member{
 
    public Teacher(String id, String password, String name, int userLevel, String phoneNumber) {
        super(id, password, name, userLevel, phoneNumber);
    }
    /**
    날      짜 : 2018. 2. 23.
    기      능 : 강좌를 추가하는 기능
    작성자명 : 최 재 욱
     */
    public void lectureAddLecture() {
        
         File file = new File("lecture"); // 상위폴더가 없을시 생성해줄 File타입
         
         if (!file.mkdir()) { // 상위 폴더가 없다면
             file.mkdirs(); // 상위 폴더를 생성 해준다.
         }
         
        System.out.println("개설할 강좌를 입력하세요");
        Scanner scan = new Scanner(System.in);
        System.out.println("강좌번호를 입력해주세요");
        int lectureNo = 0;
        
        try {
            lectureNo = Integer.parseInt(scan.nextLine());
        }catch(Exception e) {
            System.out.println("틀렷습니다");
            return;
        }
        System.out.println("강좌이름을 입력하세요");
        String lectureName = scan.nextLine();
        String teacherName = super.getName();
        System.out.println("최대수강인원을 입력하세요");
        int classMaxNum = 0;
        try {
            classMaxNum = Integer.parseInt(scan.nextLine());    //String을 int타입으로 바꿔준다
        }catch(Exception e) {
            System.out.println("틀렷습니다");
            return;
        }
        System.out.println("시작날짜를 입력하세요 ex)18.02.23");
        String startDate = scan.nextLine();
        System.out.println("종료날짜를 입력하세요 ex)18.03.23");
        String endDate = scan.nextLine();
        System.out.println("시작시간을 입력하세요 ex)9:00");
        String lectureStartTime = scan.nextLine();
        System.out.println("종료시간을 입력하세요 ex)18:00");
        String lectureEndTime = scan.nextLine();
        
        FileWriter fw = null;
        BufferedWriter bfw = null;
        
        try {
            
             fw = new FileWriter("lecture\\" + String.valueOf(lectureNo) + ".txt");
             bfw = new BufferedWriter(fw);
             
             
             bfw.write(lectureNo+" ");        // 강좌 번호
             bfw.write(lectureName+" ");    // 강좌 이름
             bfw.write(teacherName+" ");    // 강사 이름
             bfw.write(classMaxNum+" ");    // 최대 수강 인원
             bfw.write(startDate+" ");    // 강좌 시작 날짜
             bfw.write(endDate+" ");    // 강좌 종료 날짜
             bfw.write(lectureStartTime+" ");    // 강좌 시작 시간
             bfw.write(lectureEndTime);    // 강좌 종료 시간
             bfw.newLine();
             bfw.flush();
             
             /////////////////// 배열에 값 저장하기 ///////////////
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
    날      짜 : 2018. 2. 24.
    기      능 : 점수를 등록한다
    작성자명 : 최 재 욱 / 정 민 재 / 김 진 원
     */
    public void scoreManagement(){
 
        Score score; // 점수
        Student student; // 학생
 
        //score\\lectureName.txt 에 저장 될 거임.
        /////// score 폴더를 만들어줌 || 있으면 생성되지 않음 ////////
        File file = new File("score"); // 상위폴더가 없을시 생성해줄 File타입
        
        if (!file.mkdir()) { // 상위 폴더가 없다면
            file.mkdirs(); // 상위 폴더를 생성 해준다.
        }
        /////// score 폴더를 만들어줌 || 있으면 생성되지 않음  완료 ////////
        
        /////// 강좌명을 입력하여 lectureName(강좌명).txt 를 찾기 ///////
        System.out.println("강좌명을 입력하세요");
        Scanner sc = new Scanner(System.in);
        
        String lecNametxt = sc.nextLine(); // 강좌명을 입력
        
        //score\\lectureName.txt 에 저장 될 곳
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            fw = new FileWriter("score\\"+ lecNametxt + ".txt", true);
            bfw = new BufferedWriter(fw);
            
            System.out.println("점수를 등록할 학생의 ID를 입력하세요");
            
            String studentId = ""; 
            studentId = sc.nextLine(); // 학생ID
            
            System.out.println("학생의 점수를 입력하세요");
            int studentScore = sc.nextInt(); // 점수
            
            if(studentScore>990||studentScore<0) {
                System.out.println("잘못된 점수를 입력하셧습니다. 990이하의 점수를 입력해주세요");
            }else {
                bfw.write("학생ID:" + studentId+"/ 점수:"+studentScore+"점");
                bfw.newLine();
                bfw.flush();
                System.out.println("점수가 등록되었습니다");
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
    날      짜 : 2018. 2. 24.
    기      능 : 학생의 점수를 수정한다 
    작성자명 : 최 재 욱 / 정 민 재 / 김 진 원
    */
    public void scoreModify() {
        ////////////// 강좌명.txt 찾기 /////////////
        System.out.println("강좌명을 입력하세요");
        Scanner sc = new Scanner(System.in);
        
        String lecNametxt = sc.nextLine(); // 강좌명을 입력
        
        /////////////  점수 수정할 학생ID ////////////
        System.out.print("수정할 학생의 ID를 입력해 주세요 : ");
        String id = sc.nextLine();
        
        System.out.print("수정할 학생의 점수를 입력해 주세요 : ");
        int score = sc.nextInt();
        
        if(score>990||score<0) {
            System.out.println("잘못된 점수를 입력했습니다. 990점 이하의 점수를 입력하세요");
        }else {
            //강좌명.txt 경로
            String path = "score\\"+lecNametxt+".txt";
            File file = new File(path);
            
            //배열에 읽어온 라인 값들을 넣어준다.
            List<String> tempLine = new ArrayList<>();
            
            //읽기
            FileReader fr = null;
            BufferedReader bfr = null;
            
            try {
                fr = new FileReader(file);
                bfr = new BufferedReader(fr);
                
                String line = "";
                while((line = bfr.readLine()) != null) {
                    if(line.indexOf(id)<0) { //라인에 학생의 아이디가 없다면
                        tempLine.add(line);  //List에 저장
                    }else { //라인에 학생의 아이디가 있다면
                        tempLine.add("학생ID:" + id +"/ 점수:"+score+"점");
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
            
            //덮어쓰기
            FileWriter fw = null;
            BufferedWriter bfw = null;
            
            try {
                fw = new FileWriter(file);
                bfw = new BufferedWriter(fw);
                
                //List에 있는 String들을 강좌명.txt파일에 덮어씌운다.
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
    날      짜 : 2018. 2. 23.
    기      능 : 생성한 강좌 확인
    작성자명 : 최 재 욱
     */
    public void lectureChecking() {
        /*
        4. 강좌를 선택하면 강좌의 자세한 정보(강좌번호, 강좌이름, 선생님이름, 
                수강가능인원, 시작날짜, 종료날짜, 강좌시작시간, 강좌종료시간)를 보여준다.*/
        
        for(Map.Entry<String, Lecture> map : LectureList.s_getInstance().getLectureList().entrySet()){
            System.out.println("["+ map.getValue().toString()+"]");    // 가져온 값들을 출력
        }
    }
    
    public void lectureDelete() {
        System.out.println("지울 강좌 번호를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();    // 강좌 번호 입력
        
        
        ///////     LectureList 클래스의 getLectureList 함수 사용 ////////
        //     입력한 내용과 key값을 비교하여 파일 경로에 key값과 동일한 이름의 파일을 찾아서 삭제
        if(LectureList.s_getInstance().getLectureList().containsKey(String.valueOf(no))){
            LectureList.s_getInstance().getLectureList().remove(String.valueOf(no));
            String path = "lecture\\" + String.valueOf(no) + ".txt";
            File file = new File(path);
            if (file.exists()) {    // 해당 파일이 존재한다면
                file.delete();      // 파일을 삭제한다
                System.out.println(path);    
                System.out.println("삭제성공");
            }
        }else {
            System.out.println("해당강좌번호가 없습니다.");
        }
    }
}

