import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class P01_IO_DOS2_ver1 {
	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("���� : java P01_IO_DOS copy [���� ���ϸ�] [�纻 ���丮��/���ϸ�]");
			System.out.println("����   : java P01_IO_DOS copy a.txt b.txt");
			System.exit(0);
		}
		
		File original = new File(args[1]); //���� ���ϸ�
		File copy = new File(args[2]); //�纻 ���丮��/���ϸ�
		
		if(args[0].equals("copy")) {
			if(!original.exists()) {
				System.out.println("������ ������ ã�� �� �����ϴ�.");
				System.exit(0);
			}
			
			if(copy.getName().contains(".")) {
				if(copy.equals(original)) {
					System.out.println("���� ���Ϸ� ������ �� �����ϴ�.");
					System.out.println("\t 0�� ������ ����Ǿ����ϴ�.");
					System.exit(0);
				}
				Copy(original, copy);
			}else {
				copy.mkdir(); //���� ����
				String dirPath = copy.getAbsolutePath() + "//" + original.getName(); //���ο� ���� �� ���� ���ϸ� ��� ����
				File copyInDir = new File(dirPath); // ���� ��η� ���ο� ���� ��ü ����
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
			System.out.println("\t 1�� ������ ����Ǿ����ϴ�.");
		}
	}
}


