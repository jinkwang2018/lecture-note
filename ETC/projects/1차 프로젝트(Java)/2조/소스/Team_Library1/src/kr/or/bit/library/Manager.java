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
Ŭ������ : Manager
��¥ : 2018-02-20
�ۼ��ڸ� : ���ֿ�
*/
public class Manager implements Register {
	private String managerId;	//������ Id
	private String managerPw;	//������ Pw
	private Book book;			//Book�̶�� ��ü�� �����������
	private String path;		//����Ʈ�� å ������ �����ϴ� ���

	public Manager() {
		this.managerId = "manager";
		this.managerPw = "1234";
		this.path = "c:\\Temp\\library\\Books\\";
	}
	/**
	 * 
	 ��¥ : 2018-02-23 
	 ��� : å �߰��ϱ� 
	 �ۼ��ڸ� : ���ֿ�
	 */
	public void addBook(Map<Integer, Book> bookMap) { // å �߰�
		String title;
		String author;
		String genre;
		String path;
		String contents;

		System.out.print("������ �Է��ϼ��� : ");
		title = LibraryMain.sc.nextLine();
		System.out.print("���ڸ� �Է��ϼ��� : ");
		author = LibraryMain.sc.nextLine();
		System.out.print("�帣�� �Է��ϼ��� : ");
		genre = LibraryMain.sc.nextLine();
		File f;
		String exists = "";
		do {
			System.out.print("���� ��θ� �Է��ϼ��� : ");
			path = LibraryMain.sc.nextLine();

			exists = (f = new File("C:\\Temp\\library\\" + path)).exists() ? "Y" : "N";		//�Էt�� ��ΰ� �ִ��� Ȯ��
			if (exists.equals("N")) {
				System.out.println("�߸��� ����Դϴ�");
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
	 ��¥ : 2018-02-23
	 ��� : å ���� �о���� 
	 �ۼ��ڸ� : ���ֿ�
	 */
	public String readContents(String path) {
		FileReader fr = null;
		BufferedReader br = null;
		String contents = "";
		try {
			fr = new FileReader("C:\\Temp\\library\\" + path);
			br = new BufferedReader(fr);

			String temp;
			while ((temp = br.readLine()) != null) {		//������ ����ִ� �ؽ�Ʈ���Ͽ� �ִ� ���� �� �پ� �о contents�� ���
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
	 ��¥ : 2018-02-23
	 ��� : å ���� ����
	 �ۼ��ڸ� : ���ֿ�
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
	 ��¥ : 2018-02-23
	 ��� : å ����Ʈ ���Ͼ��� 
	 �ۼ��ڸ� : ���ֿ�
	 */
	public void writeList(Map<Integer, Book> bookMap) { // å ��� ���� �Լ�

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
	 ��� : å �����ϱ�
	 �ۼ��ڸ� : ���ֿ�
	 */
	public int delBook() { // å ����
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �ڵ� �Է�: ");
		String filename = sc.nextLine();

		File f = new File(path + filename + ".txt");

		if (f.exists()) {
			f.delete();
			System.out.println("���������� �����߽��ϴ�.");
		} else {
			System.out.println("�������� �ʴ� �����Դϴ� �ٽ� �Է��ϼ���.");
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
