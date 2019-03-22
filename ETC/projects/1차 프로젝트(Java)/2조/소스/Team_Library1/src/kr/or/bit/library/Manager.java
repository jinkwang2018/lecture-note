package kr.or.bit.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
/** 
클래스명 : Manager
날짜 : 2018-02-20
작성자명 : 박주원
*/
public class Manager implements Register {
	private String managerId;	//관리자 Id
	private String managerPw;	//관리자 Pw
	private Book book;			//Book이라는 객체에 정보담기위해
	private String path;		//리스트와 책 파일을 생성하는 경로

	public Manager() {
		this.managerId = "manager";
		this.managerPw = "1234";
		this.path = "c:\\Temp\\library\\Books\\";
	}
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 책 추가하기 
	 작성자명 : 박주원
	 */
	public void addBook(Map<Integer, Book> bookMap) { // 책 추가
		String title;
		String author;
		String genre;
		String path;
		String contents;

		System.out.print("제목을 입력하세요 : ");
		title = LibraryMain.sc.nextLine();
		System.out.print("저자를 입력하세요 : ");
		author = LibraryMain.sc.nextLine();
		System.out.print("장르를 입력하세요 : ");
		genre = LibraryMain.sc.nextLine();
		File f;
		String exists = "";
		do {
			System.out.print("파일 경로를 입력하세요 : ");
			path = LibraryMain.sc.nextLine();

			exists = (f = new File("C:\\Temp\\library\\" + path)).exists() ? "Y" : "N";		//입력뱓은 경로가 있는지 확인
			if (exists.equals("N")) {
				System.out.println("잘못된 경로입니다");
			}
		} while (exists.equals("N"));

		contents = readContents(path);

		book = new Book(title, author, contents, genre);
		writeBook();

		bookMap.put(book.getBookNumber(), book);
		writeList(bookMap);
	}
	/**
	 * 
	 날짜 : 2018-02-23
	 기능 : 책 내용 읽어오기 
	 작성자명 : 박주원
	 */
	public String readContents(String path) {
		FileReader fr = null;
		BufferedReader br = null;
		String contents = "";
		try {
			fr = new FileReader("C:\\Temp\\library\\" + path);
			br = new BufferedReader(fr);

			String temp;
			while ((temp = br.readLine()) != null) {		//내용이 담겨있는 텍스트파일에 있는 줄을 한 줄씩 읽어서 contents에 담기
				contents += temp + "\n";
			}
		} catch (Exception e) {
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
			}
		}
		return contents;
	}
	/**
	 * 
	 날짜 : 2018-02-23
	 기능 : 책 파일 쓰기
	 작성자명 : 박주원
	 */
	public void writeBook() {

		String filename = path + book.getBookNumber() + ".txt";
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fos);

			out.writeObject(book);

			out.close();
			fos.close();

		} catch (IOException e) {
		}

	}
	/**
	 * 
	 날짜 : 2018-02-23
	 기능 : 책 리스트 파일쓰기 
	 작성자명 : 박주원
	 */
	public void writeList(Map<Integer, Book> bookMap) { // 책 목록 쓰는 함수

		try {
			FileOutputStream fos = new FileOutputStream(path + "booklist.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);

			out.writeObject(bookMap);

			out.close();
			fos.close();

		} catch (IOException e) {
		}
	}
	/**
	 * 
	 날짜 : 2018-02-23
	 기능 : 책 삭제하기
	 작성자명 : 박주원
	 */
	public int delBook() { // 책 삭제
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 도서 코드 입력: ");
		String filename = sc.nextLine();

		File f = new File(path + filename + ".txt");

		if (f.exists()) {
			f.delete();
			System.out.println("성공적으로 삭제했습니다.");
		} else {
			System.out.println("존재하지 않는 파일입니다 다시 입력하세요.");
		}
		return Integer.parseInt(filename);
	}
	
	public String getManagerId() {
		return managerId;
	}

	public String getManagerPw() {
		return managerPw;
	}
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerPw=" + managerPw + "]";
	}
}
