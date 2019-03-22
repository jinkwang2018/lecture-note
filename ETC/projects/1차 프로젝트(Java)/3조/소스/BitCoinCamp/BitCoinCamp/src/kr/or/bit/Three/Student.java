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
 프로젝트 : 비트코인 캠프 시스템 
 파일이름 : Student.java
 날      짜 : 2018. 2. 23.
 작성자명 : 김 진 원 / 이 창 훈
*/
 
/**
 클래스명 : Student
 날      짜 : 2018. 2. 23.
 작성자명 : 김 진 원 / 이 창 훈
 */
public class Student extends Member {
 
    //학생의 정보를 가져오기
    public Student(String id, String password, String name, int userLevel, String phoneNumber) {
        super(id, password, name, userLevel, phoneNumber);
    }
    public Student() {}
    
    private String takingLecture = ""; //수강중인 강좌
    private Map<Integer, Attendance> map = new HashMap<Integer, Attendance>(); 
              //누적카운트, 출석
    private int count = 1; // 누적카운트
    
    // Getters and Setters
    public String getTakingLecture() {return takingLecture;}
	public void setTakingLecture(String takingLecture) {this.takingLecture = takingLecture;}

	/**
    날      짜 : 2018. 2. 23. 
    기      능 : 출석하기 함수 
    작성자명 : 이 창 훈
    */
    public void attending() {
        Attendance attendance = new Attendance();
        if(takingLecture == null) {
            System.out.println("수강중인 강의가 없습니다. 행정 직원에게 문의 하세요.");
            return;
        }
        try {
            map.put(count++, attendance.input(attendance,super.getName(), takingLecture));
        } catch (Exception e) {
            System.out.println("출석하기에 실패하였습니다. 행정 직원에게 문의 하세요.");
            e.printStackTrace();
        }
        System.out.println("출석이 완료 되었습니다.");
    }
    
    /**
    날      짜 : 2018. 2. 23. 
    기      능 : 출석체크하면서 해당내용 attendance\\id.txt 파일에 저장하는 함수 
    작성자명 : 이 창 훈
    */
    public void attendingCheck() {
        Set<Integer> set = map.keySet();
        int count2 = 1;
 
        for (Integer number : set) {
 
            String sname = map.get(number).getStudentName();
            String lname = map.get(number).getLectureName();
            String date = map.get(number).getDate();
            String attendanceRecord = map.get(number).getAttendanceRecord();
            System.out.printf("번호 : %s 학생ID : %s 강좌명 : %s 날짜&시간 : %s 출결여부 : %s\n", count2, sname, lname, date, attendanceRecord);
            count2++;
            File fileDir = new File("attendance"); // 폴더생성하기
            if (!fileDir.exists()) { // 같은 이름의 폴더가 존재 하는지 확인 하는 if문
                fileDir.mkdirs();
            }
            File file = new File("attendance\\id.txt");// 폴더안에 파일 생성하기
            FileWriter fw = null;
            BufferedWriter bfw = null;
            try {
                fw = new FileWriter(file, true); // file 안에 입력해놓을 내용
                bfw = new BufferedWriter(fw);
                bfw.write("학생이름 :" + sname + " / ");
                bfw.write("과정이름 :" + lname + " / ");
                bfw.write("날짜및시간 :" + date + " / ");
                // bfw.write(time + " ");
                bfw.write("출결내역 :" + attendanceRecord);
                bfw.newLine(); // 마지막에 줄바꿈하기
 
            } catch (Exception e) {
                System.out.println("불러오는데 실패했습니다.");
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
    기      능 : id.txt파일에 저장되어있는 내용을 불러오는 함수 
    작성자명 : 이 창 훈
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
            System.out.println("불러오는데 실패했습니다.");
            e.printStackTrace();
        }
 
    }
 
    /**
    날      짜 : 2018. 2. 23.
    기      능 : 상담확인 (학생은 자신이  (상담신청)한 목록을 확인 한다)
    작성자명 : 김 진 원
    */
    public void consultinCheck() {
        String baseDir = "consult"; //검색할 디렉토리
        String save = super.getId()+".txt"; //해당 학생의 상담목록이 저장된 파일명
        
        File dir = new File(baseDir); // 학생상담폴더
        File file = new File(baseDir + "\\" + save); // 학생상담폴더 + 학생상담목록 파일
        
        //검색할 디렉토리의 폴더가 없다 {ex)아무도 상담을 한적이 없다(폴더가 생성되지 않음)}
        if(!dir.isDirectory()){ 
            System.out.println("학생상담폴더가 없습니다.\n"
                            + super.getName() +"님 뿐만이 아니라 학생 어느 누구도 상담신청을 한적이 없습니다 \n"
                            + "상담 신청을 먼저 해주세요.");
            return; //함수종료
        }
        
        //만약의 학생상담목록이 없다면
        if(!file.exists()) { 
            System.out.println(super.getName()+"님의 상담 목록이 없습니다."
                            + "상담 신청을 먼저 해주세요.");
            return; //함수종료
        }
        
        //학생의 상담 목록이 있다면
        BufferedReader br = null;
 
        File[] files = dir.listFiles(); // (consult)의 하위 자원(폴더, 파일)
        try {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isFile()) { // 학생ID.txt 만 필요하므로
                    continue; // 파일이 아닌 경우 skip
                }
 
                // files[i] = {"consult\학생ID.txt", "consult\학생ID.txt", ... } 이 들어가 있음
                br = new BufferedReader(new FileReader(files[i]));
 
                // files[i] = consult\학생ID.txt
                // file = consult\학생ID.txt
                if (files[i].equals(file)) { // 파일들의 이름중 학생이름으로 된 txt파일이 있으면
                    String line = "";
                    while ((line = br.readLine()) != null) { // 라인을 다 읽을 때 까지
                        System.out.println(line); // 출력
                    }
                    break; //for문 종료
                }
            }
        } catch (IOException e) {
            System.out.println("찾기 실패~");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
    날      짜 : 2018. 2. 23.
    기      능 : 상담신청 (학생은 컨설팅 클래스에 있는 consultingList.add로 상담신청을 한다)
    작성자명 : 김 진 원
    */
    public void consultingAdd() {
        Student student; //자신! (자신은 학생임)
        Consulting consulting = new Consulting(); //상담 클래스
        
        if(takingLecture == null) { //학생에게 반 배정이 안 되어있다면
            System.out.println("반배정이 완료되지 않았습니다.\n"
                             + "행정직원에게 문의 해주세요.");
            return; //함수종료
        }
        
        //상담리스트에  자신(학생)! 을 add해준다.
        consulting.consultingList.add(this);

        
        System.out.println(super.getName() + "님의 상담신청이 정상적으로 완료되었습니다.");
        
        //상담신청이 완료되면 
        //학생 상담 목록에 저장이 되어야 한다.
        String path = "consult\\"+super.getId()+".txt"; //파일의 경로
        
        File file = new File(path); //경로를 파일에 대입
        
        File filepath = new File("consult"); //상위폴더가 없을시 생성해줄 File타입
        if(!filepath.mkdir()) { //상위 폴더가 없다면
            filepath.mkdirs(); //상위 폴더를 생성 해준다.
        }
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            Calendar cal = Calendar.getInstance();
            Date_Time date = new Date_Time(); // 날짜를 사용하기위해!!
            
            fw = new FileWriter(file, true); //파일 생성기능(추가 write 가능하게)
            bfw = new BufferedWriter(fw); //버퍼기능
            
            String text = "날짜&시간 : " + date.getDate(cal) + " 상담 받은 강좌명 : " + takingLecture; //파일에 입력 될 내용
            
            bfw.write(text); //입력을 해준다
            bfw.newLine(); //다음에 또 신청시 입력이 가능하도록
            bfw.flush(); //버퍼를 비운다
            
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
    날      짜 : 2018. 2. 23.
    기      능 : 점수확인 (학생은 자신이 시험본 점수들을 확인 할 수 있다)
    작성자명 : 김 진 원
    */
    public void scoreCheck() {        
        if(LectureList.s_getInstance().getLectureList().size() < 1) {
            return; // 함수 종료
        }
        
        String lectureName = takingLecture; //강좌이름
        
        for(Map.Entry<String, Lecture> map : LectureList.s_getInstance().getLectureList().entrySet()){
            //(Lecture)map.getValue()).getLectureName() => 강좌이름
            if(((Lecture)map.getValue()).getLectureName().equals(takingLecture)) {;// 수강중인 강좌와 이름이 같다면
                lectureName = ((Lecture)map.getValue()).getLectureName(); //강좌이름
                break;//for문 빠져나가기
            }
        }
        
        if(lectureName.equals("")) { //빈 문자열이라면
            System.out.println("강좌의 이름이 다르거나 수강하는 강좌가 없습니다.");
            return; // 함수 종료
        }
        
        // -> score/lectureName.txt 선생님이 점수를 저장하는 곳
        String baseDir = "score"; //검색할 디렉토리 (점수가 저장되어있는곳)
        String save = lectureName+".txt"; //해당 학생의 상담목록이 저장된 파일명
        File dir = new File(baseDir); // 점수저장폴더
        File file = new File(baseDir + "\\" + save); // 점수저장폴더 + 강좌명_학생점수목록 파일
        
        //검색할 디렉토리의 폴더가 없다 {ex)점수를 등록한 선생님이 없다(폴더가 생성되지 않음)}
        if(!dir.isDirectory()){ 
            System.out.println("저장된 점수의 폴더가 없습니다.\n"
                            + "선생님이 등록한 점수가 없습니다.\n"
                            + "선생님께 문의해주시기 바랍니다.");
            return; //함수종료
        }
        
        //만약의 강좌명_학생점수목록이 없다면
        if(!file.exists()) { 
            System.out.println(lectureName+" 강좌에 등록된 점수목록이 없습니다."
                            + "선생님께 문의해주시기 바랍니다.");
            return; //함수종료
        }
            
        //강좌명_학생점수목록이 있다면
        BufferedReader br = null;
 
        File[] files = dir.listFiles(); // (score)의 하위 자원(폴더, 파일)
        try {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isFile()) { // lectureName.txt 만 필요하므로
                    continue; // 파일이 아닌 경우 skip
                }
 
                // files[i] = {"score\강좌명.txt", "score\강좌명.txt", ... } 이 들어가 있음
                br = new BufferedReader(new FileReader(files[i]));
 
                
                if (files[i].equals(file)) { // 파일들의 이름중 학생이름으로 된 txt파일이 있으면
                    String line = "";
                    while ((line = br.readLine()) != null) { // 라인을 다 읽을 때 까지
                        System.out.println(line); // 출력
                    }
                    break; //for문 종료
                }
                
                //각 파일의 데이터를 라인단위를 읽어서
                String line = "";
                while((line = br.readLine()) != null){
                    if(line.indexOf(super.getId()) != -1){ // txt파일 안에 해당 학생의 아이디가 들어 있다면
                        System.out.println(line); // 그 Line을 출력한다.
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("찾기 실패~");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
