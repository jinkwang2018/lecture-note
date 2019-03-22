import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		/*
		Format 클래스
		 
		화폐단위 처리
		DecimalFormat df = new DecimalFormat("#,###.0");
		String result = df.format(1234567.89);
		System.out.println(result);
		
		날짜 형식 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		
		문자열 처리
		String message = "회원 Id :{0} \n회원 이름 : {1} \n회원 전화번호 : {2}";
		String result = MessageFormat.format(message, userId, userName, userTel);
		*/
		
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles(); //모든 자원(폴더 또는 파일)
		
		for(int i = 0; i < files.length; i++) {
			File file = files[i];
			String name = file.getName(); //폴더명, 파일명
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String atrribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				atrribute = "<DIR>";
			}else { //나머지는 파일(a.txt, copy.jpg ...)
				size = file.length() + "byte";
				atrribute = file.canRead() ? "R" : "";
				atrribute += file.canWrite() ? "W" : "";
				atrribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s   %3s   %10s   %s   \n",
							df.format(file.lastModified()),
							atrribute,
							size,
							name);
		}
	}
}
