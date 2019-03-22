package kr.or.bit.Three;

/**
������Ʈ : ��Ʈ���� ķ�� �ý���
�����̸� : LectureList.java
��    ¥ : 2018. 2. 23.
�ۼ��ڸ� : �� �� ��
*/
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Ŭ������ : LectureList
 * �� ¥ : 2018. 2. 23.
 * �ۼ��ڸ� : �� �� ��
 */
public class LectureList {
 
    private static LectureList s_lectureList;
    private Map<String, Lecture> lectureList;
    private FileReader fr;
    private BufferedReader br;
    File file; // lecture ����
    
    /**
     * �� ¥ : 2018. 2. 23. �� �� : Singleton ������ �̿��Ͽ� �ϳ��� ��ü�� ����ϱ� ���� ������ new �ϰ� ������
     * return ���� �ۼ��ڸ� : �� �� ��
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
     ��    ¥ : 2018. 2. 24.
     ��    �� : lecture ������ �ִ� lecture ������ �о lectureList�� ����
     �ۼ��ڸ� : �� �� ��
     */
    private void saveLectureList() {
    	if(!file.exists()) {
            System.out.println("lecture ������ �����ϴ�.");
        }else {
            File[] lectureFileList = file.listFiles();
            if(lectureFileList.length == 0) {
                System.out.println("lecture ������ �����ϴ�.");
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

