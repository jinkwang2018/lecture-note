import java.util.Properties;

/*
[Properties]
Map 인터페이스 구현한 클래스
특수한 목적: <String, String> 정의

<사용목적>
App 공통속성 정의 (환경변수): 프로그램의 버전, 파일경로, 공통변수

<활용>
data.properties 파일을 만들어서 (key, value) 구조
DB계정(id, pwd)
버전
다국어
*/

public class Ex16_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("Master", "bit@bit.or.kr");
		prop.setProperty("version", "1.0.0.0");
		prop.setProperty("defaultpath", "C:\\Temp\\images");
		
		//사용 (페이지 100개)
		System.out.println(prop.getProperty("Master"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("defaultpath"));
	}
}
