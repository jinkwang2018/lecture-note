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
Ŭ������ : Library
��¥ : 2018-02-20
�ۼ��ڸ� : ������,�̾Ƹ�
*/
public class Library {

	private Map<Integer, User> userMap;	// ȸ�������� ������ ȸ�������� User ��ü�� ������ Map, userMap 
	private Map<Integer, Book> bookMap;	// ���Ӱ� �߰��� ������ Book ��ü�� ������ Map, bookMap
	private Manager manager;			// �� �Ѹ��� Manager ��ü
	private User user;					// �������� User ��ü
	private Time times;					// Library ������ Time ��ü
	AutoReturnThread autoReturn;		// Thread�� background�� ���ư��鼭 �ڵ� �ݳ� ����� ���� AutoReturnThread ��ü

	private int count = 1;				
	private Scanner sc;					// Main�� ������ �ִ� static Scanner �ּ� ���� ����
	
	/**
	 * 
	 ��¥ : 2018-02-22 
	 ��� : ���̺귯�� ������ �� ��������Ʈ�� �ϸ���Ʈ �Լ������Ű�� 
	 �ۼ��ڸ� : ������
	 */
	public Library() {
		manager = new Manager();
		user = new User();
		userMap = new HashMap<>();
		bookMap = new HashMap<>();
		times = new Time();
		autoReturn = new AutoReturnThread(this, manager);
		sc = LibraryMain.sc; 
		/* �̹� ����Ǿ��ִ� User��ü��� Book��ü���� ��� �ִ� ���� read */
		userList();	
		File f = new File("c:\\Temp\\library\\Books\\booklist.txt");
		if (f.exists()) {
			bookList();
		}
		// �ڵ��ݳ� Thread ����
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
	 ��¥ : 2018-02-22 
	 ��� : ȸ������ ���� �Է� 
	 �ۼ��ڸ� : ������
	 */
	public User register(User user) {

		Map<Integer, User> map = new HashMap<>();
		
		while (true) { // ���̵� �ߺ�üũ
			boolean idCheck = true; // �ߺ� false ���� true
			System.out.print("���̵� : ");
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
				System.out.println("���̵� �ߺ��˴ϴ� �ٽ� �Է����ּ���");
			} else {
				break;
			}
		}
		System.out.print("��й�ȣ : ");
		user.setMemberPw(sc.nextLine());
		System.out.print("�̸� : ");
		user.setMemberName(sc.nextLine());

		return user;
	}
	
	/**
	 * 
	 ��¥ : 2018-02-22 
	 ��� : ȸ������ 
	 �ۼ��ڸ� : ������
	 */
	public void register() { // ȸ������
		userMap.put(count, register(user));
		count++;
		userWrite(user);
	}
	
	/**
	 *
	 ��¥ : 2018-02-22 
	 ��� : �α��� 
	 �ۼ��ڸ� : ������
	 */
	public Register login() { // �α���

		System.out.print("���̵� : ");
		String loginId = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String loginPw = sc.nextLine();

		boolean login = false;

		if (manager.getManagerId().equals(loginId) && manager.getManagerPw().equals(loginPw)) {
			System.out.println("������ �����ڴ� ȯ���մϴ�");
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
			System.out.println(user.getMemberName() + "�� ȯ���մϴ�");
			return user;
		} else {
			System.out.println("�α��ο� ���� �߽��ϴ�.");
			return null;
		}
	}
	
	/**
	 * 
	 ��¥ : 2018-02-23 
	 ��� : ��ü ������� ����Ʈ Map�� ���, ȸ�� ī��Ʈ �ʱ�ȭ��Ű��
	 �ۼ��ڸ� : ������
	 */
	public void userList() { // ��ü ���� ���
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
	 ��¥ : 2018-02-22 
	 ��� : ��ü ������� ����Ʈ ��� 
	 �ۼ��ڸ� : ������
	 */
	public void allUserPrint() { // ��ü ���� ���

		Set<Integer> set = userMap.keySet();

		System.out.println("�������\t���̵�\t\t��й�ȣ\t\t�̸�");

		int num = 1;
		for (Integer i : set) {
			System.out.printf("%d\t%-10s\t%-10s\t%s\n", num++, userMap.get(i).getMemberId(),
					userMap.get(i).getMemberPw(), userMap.get(i).getMemberName());
		}
	}
	
	/**
	 * 
	 ��¥ : 2018-02-22 
	 ��� : ���� ��ü ����Ʈ ���� ���� 
	 �ۼ��ڸ� : ������
	 */
	public void userWrite(User user) { // ���� ����
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
	 ��¥ : 2018-02-23 
	 ��� : å �뿩,���� ��� ���� 
	 �ۼ��ڸ� : ������
	 */
	public void modify(Book book) {
		bookModify(book);
		bookMap.put(book.getBookNumber(), book);
		listModify(bookMap);
	}
	
	/**
	 * 
	 ��¥ : 2018-02-23 
	 ��� : �α��� 
	 �ۼ��ڸ� : ������
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
	 ��¥ : 2018-02-23 
	 ��� : å ��ü ���� ����� 
	 �ۼ��ڸ� : ������
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
	 ��¥ : 2018-02-23 
	 ��� : å ����Ʈ ����ϱ� 
	 �ۼ��ڸ� : ������
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
			System.out.println("�˻���� �����ϴ�");
		}
	}
	
	/**
	 * 
	 ��¥ : 2018-02-23 
	 ��� : å ����Ʈ Map�� ���
	  �ۼ��ڸ� : ������
	 */
	public void bookList() { // ��ü ���� ���
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
	 ��¥ : 2018-02-23 
	 ��� : å �����ϱ� 
	 �ۼ��ڸ� : ������
	 */
	public void bookListDel(int bookNumber) {

		bookMap.remove(bookNumber);

		listModify(bookMap);

	}
	
	/**
	 * 
	 ��¥ : 2018-02-23 
	 ��� : ���� �뿩 ���� å���� ����Ʈ�� ��ȯ
	 �ۼ��ڸ� : ���¿�
	 */
	public List<String> rentBookList(Register register) {
		RentalBook rentList = new RentalBook(register);
		List<String> temp = rentList.type();
		return temp;
	}

	/**
	 * 
	 ��¥ : 2018-02-22 
	 ��� : �Է��� �ܾ ���Ե� å ���� �˻��ϱ� 
	 �ۼ��ڸ� : �̾Ƹ�
	 */
	public void searchTitle() { // ���� �˻�
		System.out.println("�������� �˻�");
		Set<Integer> set = bookMap.keySet();
		List<Book> searchedList = new ArrayList<>();

		System.out.print("���� : ");
		String text = sc.nextLine();
		for (Integer i : set) {
			if (bookMap.get(i).getTitle().contains(text)) {
				searchedList.add(bookMap.get(i));
			}
		}
		
		if (searchedList.size() != 0) {
			listPrint(searchedList);
		} else {
			System.out.println("�˻���� �����ϴ�");
		}
	}

	/**
	 * 
	 ��¥ : 2018-02-23 
	 ��� : å �α������ �˻��ϱ� 
	 �ۼ��ڸ� : �̾Ƹ�
	 */
	public void searchPopular() { // �α�� �˻�
		// rentalCount
		System.out.println("�α�� �˻�");

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
		System.out.printf("%s \t%s \t%-50s \t%-15s \t%-10s \t%s\n", "No.", "�뿩Ƚ��", "����", "����", "�帣", "�뿩���ɿ���");
		for (Book book : bookList) {
			char rentalSymbol = book.isRental() ? 'O' : 'X';
			System.out.printf("%d \t%d \t%-50s \t%-15s \t%-10s \t%c\n", book.getBookNumber(), book.getRentalCount(),
					book.getTitle(), book.getAuthor(), book.getGenre(), rentalSymbol);
		}
	}

}
