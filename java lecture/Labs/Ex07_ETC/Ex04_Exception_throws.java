import java.io.FileInputStream;
import java.io.FileNotFoundException;

import kr.or.bit.ExClass;

public class Ex04_Exception_throws {
	public static void main(String[] args) {
		
		try {
			ExClass ex = new ExClass();
			ex.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//Ŭ���� ����� ���� ������ �ִ� �ڿ��� ����ϴ� �����ڿ��� ������ ����ó���� �ϵ��� �ϴ� ���
		//������, �Լ� �ڿ� [throws ����Ŭ������, ����Ŭ������, ����Ŭ������, ...]
		
		//JAVA API ���� Ŭ�������� throws ... (IO)
		//public FileInputStream(String name)
		//throws FileNotFoundException
		/*
		try {
			FileInputStream fi = new FileInputStream("C:\\temp\\a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
}
