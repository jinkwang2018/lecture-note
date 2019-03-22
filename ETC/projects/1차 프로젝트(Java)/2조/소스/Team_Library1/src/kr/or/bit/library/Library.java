package kr.or.bit.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/** 
클래스명 : Library
날짜 : 2018-02-20
작성자명 : 아윤근,이아림
*/
public class Library {

	private Map<Integer, User> userMap;	// 회원가입한 순으로 회원가입한 User 객체를 저장할 Map, userMap 
	private Map<Integer, Book> bookMap;	// 새롭게 추가된 순으로 Book 객체를 저장할 Map, bookMap
	private Manager manager;			// 단 한명의 Manager 객체
	private User user;					// 여러명의 User 객체
	private Time times;					// Library 기준의 Time 객체
	AutoReturnThread autoReturn;		// Thread로 background로 돌아가면서 자동 반납 기능을 가진 AutoReturnThread 객체

	private int count = 1;				
	private Scanner sc;					// Main이 가지고 있는 static Scanner 주소 저장 변수
	
	/**
	 * 
	 날짜 : 2018-02-22 
	 기능 : 라이브러리 생성할 때 유저리스트와 북리스트 함수실행시키기 
	 작성자명 : 아윤근
	 */
	public Library() {
		manager = new Manager();
		user = new User();
		userMap = new HashMap<>();
		bookMap = new HashMap<>();
		times = new Time();
		autoReturn = new AutoReturnThread(this, manager);
		sc = LibraryMain.sc; 
		/* 이미 저장되어있는 User객체들과 Book객체들을 담고 있는 파일 read */
		userList();	
		File f = new File("c:\\Temp\\library\\Books\\booklist.txt");
		if (f.exists()) {
			bookList();
		}
		// 자동반납 Thread 실행
		autoReturn.setDaemon(true);
		autoReturn.start(); 	
	}
	public Map<Integer, Book> getBookMap() {
		return bookMap;
	}
	public Map<Integer, User> getMap() {
		return userMap;
	}
	public User getUser() {
		return user;
	}
	public String[] getTime() {
		return times.getTimes(); // [0]: yyyy-MM-dd hh:mm:ss / [1]: 213123132543242343245
	}
	public Time getTimes() {
		return times;
	}
	/**
	 * 
	 날짜 : 2018-02-22 
	 기능 : 회원가입 정보 입력 
	 작성자명 : 아윤근
	 */
	public User register(User user) {

		Map<Integer, User> map = new HashMap<>();
		
		while (true) { // 아이디 중복체크
			boolean idCheck = true; // 중복 false 가능 true
			System.out.print("아이디 : ");
			user.setMemberId(sc.nextLine());

			Set<Integer> set = map.keySet();

			for (Integer i : set) {
				if (map.get(i).getMemberId().equals(user.getMemberId()))
					idCheck = false;
			}
			if(user.getMemberId().toLowerCase().equals("manager")) {
				idCheck = false;
			}
			if (!idCheck) {
				System.out.println("아이디가 중복됩니다 다시 입력해주세요");
			} else {
				break;
			}
		}
		System.out.print("비밀번호 : ");
		user.setMemberPw(sc.nextLine());
		System.out.print("이름 : ");
		user.setMemberName(sc.nextLine());

		return user;
	}
	
	/**
	 * 
	 날짜 : 2018-02-22 
	 기능 : 회원가입 
	 작성자명 : 아윤근
	 */
	public void register() { // 회원가입
		userMap.put(count, register(user));
		count++;
		userWrite(user);
	}
	
	/**
	 *
	 날짜 : 2018-02-22 
	 기능 : 로그인 
	 작성자명 : 아윤근
	 */
	public Register login() { // 로그인

		System.out.print("아이디 : ");
		String loginId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String loginPw = sc.nextLine();

		boolean login = false;

		if (manager.getManagerId().equals(loginId) && manager.getManagerPw().equals(loginPw)) {
			System.out.println("도서관 관리자님 환영합니다");
			return manager;
		}

		Set<Integer> set = userMap.keySet();
		for (Integer i : set) {
			
			if (userMap.get(i).getMemberId().equals(loginId)) {
				if (userMap.get(i).getMemberPw().equals(loginPw)) {
					user = userMap.get(i);
					login = true;
				}
			}
		}
		if (login) {
			System.out.println(user.getMemberName() + "님 환영합니다");
			return user;
		} else {
			System.out.println("로그인에 실패 했습니다.");
			return null;
		}
	}
	
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 전체 유저목록 리스트 Map에 담고, 회원 카운트 초기화시키기
	 작성자명 : 아윤근
	 */
	public void userList() { // 전체 유저 목록
		String path = "c:\\Temp\\library\\Users";

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(String.join("\\", path, "User.txt"));
			ois = new ObjectInputStream(fis);

			userMap = (Map) ois.readObject();

			Set<Integer> set = userMap.keySet();

			for (Integer number : set) {
				count = ++number;
			}
		} catch (Exception e) {
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (Exception e) {

			}
		}
	}
	
	/**
	 * 
	 날짜 : 2018-02-22 
	 기능 : 전체 유저목록 리스트 출력 
	 작성자명 : 아윤근
	 */
	public void allUserPrint() { // 전체 유저 출력

		Set<Integer> set = userMap.keySet();

		System.out.println("유저목록\t아이디\t\t비밀번호\t\t이름");

		int num = 1;
		for (Integer i : set) {
			System.out.printf("%d\t%-10s\t%-10s\t%s\n", num++, userMap.get(i).getMemberId(),
					userMap.get(i).getMemberPw(), userMap.get(i).getMemberName());
		}
	}
	
	/**
	 * 
	 날짜 : 2018-02-22 
	 기능 : 유저 객체 리스트 파일 쓰기 
	 작성자명 : 아윤근
	 */
	public void userWrite(User user) { // 유저 저장
		String path = "c:\\Temp\\library\\Users";
		try {
			File f = new File(String.join("\\", path, user.getMemberId()));
			f.mkdir();

			FileOutputStream fos = new FileOutputStream(path + "\\User.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(userMap);

			oos.close();
			fos.close();

		} catch (Exception e) {
		}
	}
	
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 책 대여,삭제 등등 수정 
	 작성자명 : 아윤근
	 */
	public void modify(Book book) {
		bookModify(book);
		bookMap.put(book.getBookNumber(), book);
		listModify(bookMap);
	}
	
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 로그인 
	 작성자명 : 아윤근
	 */
	public void listModify(Map<Integer, Book> bookMap) {
		String path = "c:\\Temp\\library\\Books\\";
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
	 기능 : 책 객체 파일 덮어쓰기 
	 작성자명 : 아윤근
	 */
	public void bookModify(Book book) {
		String path = "c:\\Temp\\library\\Books\\";
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
	 기능 : 책 리스트 출력하기 
	 작성자명 : 아윤근
	 */
	public void bookListPrint() {
		// bookList();
		Set<Integer> set = bookMap.keySet();
		List<Book> bookList = new ArrayList<>();
		for (Integer i : set) {
			bookList.add(bookMap.get(i));
		}
		if (bookList.size() != 0) {
			listPrint(bookList);
		} else {
			System.out.println("검색결과 없습니다");
		}
	}
	
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 책 리스트 Map에 담기
	  작성자명 : 아윤근
	 */
	public void bookList() { // 전체 도서 목록
		String path = "c:\\Temp\\library\\Books\\";

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(path + "booklist.txt");
			ois = new ObjectInputStream(fis);

			bookMap = (Map) ois.readObject();

		} catch (Exception e) {
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (Exception e) {

			}
		}
	}
	
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 책 삭제하기 
	 작성자명 : 아윤근
	 */
	public void bookListDel(int bookNumber) {

		bookMap.remove(bookNumber);

		listModify(bookMap);

	}
	
	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 현재 대여 중인 책들의 리스트를 반환
	 작성자명 : 김태웅
	 */
	public List<String> rentBookList(Register register) {
		RentalBook rentList = new RentalBook(register);
		List<String> temp = rentList.type();
		return temp;
	}

	/**
	 * 
	 날짜 : 2018-02-22 
	 기능 : 입력한 단어가 포함된 책 제목 검색하기 
	 작성자명 : 이아림
	 */
	public void searchTitle() { // 제목 검색
		System.out.println("제목으로 검색");
		Set<Integer> set = bookMap.keySet();
		List<Book> searchedList = new ArrayList<>();

		System.out.print("제목 : ");
		String text = sc.nextLine();
		for (Integer i : set) {
			if (bookMap.get(i).getTitle().contains(text)) {
				searchedList.add(bookMap.get(i));
			}
		}
		
		if (searchedList.size() != 0) {
			listPrint(searchedList);
		} else {
			System.out.println("검색결과 없습니다");
		}
	}

	/**
	 * 
	 날짜 : 2018-02-23 
	 기능 : 책 인기순으로 검색하기 
	 작성자명 : 이아림
	 */
	public void searchPopular() { // 인기순 검색
		// rentalCount
		System.out.println("인기순 검색");

		Set<Integer> set = bookMap.keySet();

		List<Book> bookList = new ArrayList<>();

		for (Integer i : set) {
			bookList.add(bookMap.get(i));
		}

		Collections.sort(bookList, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {

				if (o1.getRentalCount() > o2.getRentalCount()) {
					return -1;
				} else if (o1.getRentalCount() < o2.getRentalCount()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		listPrint(bookList);
	}
	
	public void listPrint(List<Book> bookList) {
		System.out.printf("%s \t%s \t%-50s \t%-15s \t%-10s \t%s\n", "No.", "대여횟수", "제목", "저자", "장르", "대여가능여부");
		for (Book book : bookList) {
			char rentalSymbol = book.isRental() ? 'O' : 'X';
			System.out.printf("%d \t%d \t%-50s \t%-15s \t%-10s \t%c\n", book.getBookNumber(), book.getRentalCount(),
					book.getTitle(), book.getAuthor(), book.getGenre(), rentalSymbol);
		}
	}

}
