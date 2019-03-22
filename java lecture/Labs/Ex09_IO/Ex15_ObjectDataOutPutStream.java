import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import kr.or.bit.UserInfo;

//��ü�� ���Ͽ� write
public class Ex15_ObjectDataOutPutStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			//��ü (����ȭ)
			//write (��ü ������)
			ObjectOutputStream out = new ObjectOutputStream(bos);
			UserInfo u1 = new UserInfo("superman", "super", 500);
			UserInfo u2 = new UserInfo("scott", "tiger", 50);
			
			//����ȭ
			out.writeObject(u1);
			out.writeObject(u2);
			
			out.close();
			bos.close();
			fos.close();
			System.out.println("���ϻ��� -> buffer -> ����ȭ��ü -> write");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
