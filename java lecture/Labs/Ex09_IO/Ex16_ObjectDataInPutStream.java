import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.bit.UserInfo;

//UserData.txt ���Ͽ��� ����ȭ�� ��ü�� read (������ȭ) �ٽ� ����

public class Ex16_ObjectDataInPutStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			
			//UserInfo r1 = (UserInfo)in.readObject(); //������ȭ: ����
			//UserInfo r2 = (UserInfo)in.readObject(); //������ȭ: ����
			
			//System.out.println(r1.toString());
			//System.out.println(r2.toString());
			
			//��ü ���� read ��ü�� ������ null �� ��ȯ
			Object users = null;
			while((users = in.readObject()) != null) {
				System.out.println(users);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
