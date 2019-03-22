import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class P01_IO_DOS2_ver1 {
	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("사용법 : java P01_IO_DOS copy [원본 파일명] [사본 디렉토리명/파일명]");
			System.out.println("예시   : java P01_IO_DOS copy a.txt b.txt");
			System.exit(0);
		}
		
		File original = new File(args[1]); //원본 파일명
		File copy = new File(args[2]); //사본 디렉토리명/파일명
		
		if(args[0].equals("copy")) {
			if(!original.exists()) {
				System.out.println("지정된 파일을 찾을 수 없습니다.");
				System.exit(0);
			}
			
			if(copy.getName().contains(".")) {
				if(copy.equals(original)) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("\t 1개 파일이 복사되었습니다.");
		}
	}
}


