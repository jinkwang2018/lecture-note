import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class P01_IO_DOS_COPY {
	public static void main(String[] args) {
		if(args[1].equals("copy")) {
			copy(args);
		}
	}
		
	static void copy(String[] args) {
		File original = new File(args[0] + "\\" + args[2]); //���� ���ϸ�
		File copy = new File(args[0] + "\\" + args[3]); //�纻 ���丮��/���ϸ�
		
		if(args.length != 4) {
			System.out.println("���� : java [�ڹ�Ŭ������] [���] copy [���� ���ϸ�] [�纻 ���丮��/���ϸ�]");
			System.out.println("����   : java P01_IO_DOS_COPY C:\temp copy a.txt b.txt");
			System.exit(0);
		}
		
		if(!original.isFile()) { //���� ���� ���� Ȯ��
			System.out.println("������ ������ ã�� �� �����ϴ�.");
			System.exit(0);
		}
		
		if(copy.getName().contains(".")) { //"."���� ���η� Ȯ���ڸ� ���� ��������, ���丮���� ����
			if(copy.equals(original)) { //���� ���ϸ�� �纻 ���ϸ� �ߺ�ó��
				System.out.println("���� ���Ϸ� ������ �� �����ϴ�.");
				System.out.println("\t 0�� ������ ����Ǿ����ϴ�.");
				System.exit(0);
			}
			copyProcess(original, copy);
		}else {
			copy.mkdir(); //���� ����
			String dirPath = copy.getAbsolutePath() + "\\" + original.getName(); //���ο� ���� �� ���� ���ϸ� ��� ����
			File copyInDir = new File(dirPath); // ���� ��η� ���ο� ���� ��ü ����
			copyProcess(original, copyInDir);
		}
	}
	
	static void copyProcess(File original, File copy) {
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
				System.out.println("\t 1�� ������ ����Ǿ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}