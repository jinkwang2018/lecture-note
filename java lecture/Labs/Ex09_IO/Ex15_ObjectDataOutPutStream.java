import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import kr.or.bit.UserInfo;

//객체를 파일에 write
public class Ex15_ObjectDataOutPutStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			//객체 (직렬화)
			//write (객체 단위로)
			ObjectOutputStream out = new ObjectOutputStream(bos);
			UserInfo u1 = new UserInfo("superman", "super", 500);
			UserInfo u2 = new UserInfo("scott", "tiger", 50);
			
			//직렬화
			out.writeObject(u1);
			out.writeObject(u2);
			
			out.close();
			bos.close();
			fos.close();
			System.out.println("파일생성 -> buffer -> 직렬화객체 -> write");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
