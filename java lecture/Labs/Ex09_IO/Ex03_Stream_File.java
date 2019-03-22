import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex03_Stream_File {
	public static void main(String[] args) throws Exception {
		String orifile = "C:\\Temp\\1.png";
		String targetfile = "copy.png";
		//D:\bitcamp104\Java\Labs\Ex09_IO default 경로
		
		FileInputStream fis = new FileInputStream(orifile);
		FileOutputStream fos = new FileOutputStream(targetfile);
		
		int data=0;
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
		fis.close();
		fos.close();
		System.out.println("작업완료");
	}
}
