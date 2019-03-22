package kr.or.bit.Three;

/**
프로젝트 : 비트코인 캠프 시스템
파일이름 : LectureList.java
날    짜 : 2018. 2. 23.
작성자명 : 김 희 준
*/
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * 클래스명 : LectureList
 * 날 짜 : 2018. 2. 23.
 * 작성자명 : 김 희 준
 */
public class LectureList {
 
    private static LectureList s_lectureList;
    private Map<String, Lecture> lectureList;
    private FileReader fr;
    private BufferedReader br;
    File file; // lecture 폴더
    
    /**
     * 날 짜 : 2018. 2. 23. 기 능 : Singleton 패턴을 이용하여 하나의 객체만 사용하기 위해 없으면 new 하고 있으면
     * return 해줌 작성자명 : 김 희 준
     */
    public static LectureList s_getInstance() {
        if (s_lectureList == null) {
            s_lectureList = new LectureList();
        }
        return s_lectureList;
    }
 
    // Getter
    public Map<String, Lecture> getLectureList() {
        return lectureList;
    }
 
    private LectureList() {
        lectureList = new HashMap<>();
        
        fr = null;
        br = null;
        
        file = new File("lecture");
        
        saveLectureList();
    }
    
    /**
     날    짜 : 2018. 2. 24.
     기    능 : lecture 폴더에 있는 lecture 파일을 읽어서 lectureList에 저장
     작성자명 : 김 희 준
     */
    private void saveLectureList() {
    	if(!file.exists()) {
            System.out.println("lecture 폴더가 없습니다.");
        }else {
            File[] lectureFileList = file.listFiles();
            if(lectureFileList.length == 0) {
                System.out.println("lecture 파일이 없습니다.");
            }else {
                try {
                    for(int i = 0; i < lectureFileList.length; i++) {
                        fr = new FileReader(lectureFileList[i]);
                        br = new BufferedReader(fr);
                        
                        String line = br.readLine();
                        String[] std = line.split(" ");
                        
                    
                        lectureList.put(std[0], new Lecture(Integer.parseInt(std[0]), std[1], std[2], Integer.parseInt(std[3]), std[4], std[5], std[6], std[7]));
                        
                        String lectureNo = std[0];
                        while((line = br.readLine()) != null) {
                            std = line.split(" ");
                            lectureList.get(lectureNo).getStudentList().put(std[0], new Student(std[0], std[1], std[2], Integer.parseInt(std[3]), std[4]));
                        }
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

