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
		
		
		//클래스 설계시 내가 가지고 있는 자원을 사용하는 개발자에게 강제로 예외처리를 하도록 하는 방법
		//생성자, 함수 뒤에 [throws 예외클래스명, 예외클래스명, 예외클래스명, ...]
		
		//JAVA API 제공 클래스들은 throws ... (IO)
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
