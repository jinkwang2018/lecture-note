import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class P01_IO_DOS2_ver2 {
	public static void main(String[] args) {
				
		if(args[0].equals("copy")) {
			File original = new File(args[1]); //원본 파일명
			File copy = new File(args[2]); //사본 디렉토리명/파일명
			
			if(args.length != 3) {
				System.out.println("사용법 : java [자바클래스명] [원본 파일명] [사본 디렉토리명/파일명]");
				System.out.println("예시   : java [자바클래스명] copy a.txt b.txt");
				System.exit(0);
			}
			
			if(!original.isFile()) { //파일 존재 여부 확인
				System.out.println("지정된 파일을 찾을 수 없습니다.");
				System.exit(0);
			}
			
			if(copy.getName().contains(".")) { //"."존재 여부로 확장자를 가진 파일인지, 디렉토리인지 구분
				if(copy.equals(original)) { //원본 파일명과 사본 파일명 중복처리
					System.out.println("같은 파일로 복사할 수 없습니다.");
					System.out.println("\t 0개 파일이 복사되었습니다.");
					System.exit(0);
				}
				Copy(original, copy);
			}else {
				copy.mkdir(); //폴더 생성
				String dirPath = copy.getAbsolutePath() + "//" + original.getName(); //새로운 폴더 내 원본 파일명 경로 지정
				File copyInDir = new File(dirPath); // 위의 경로로 새로운 파일 객체 생성
				Copy(original, copyInDir);
			}
			
		}
	}
		
	static void Copy(File original, File copy) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(original);
			fos = new FileOutputStream(copy);
			
			int data=0;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
				System.out.println("\t 1개 파일이 복사되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}