package kr.or.bit.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
  Ŭ������ : AutoReturnThread 
  ��¥ : 2018-02-20 
  �ۼ��ڸ� : ���ؼ�, ������
 */

public class User implements Register, Serializable {
	private String memberId; // User  Id
	private String memberPw; // User Pwd
	private String memberName; // User Name

	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "User [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + "]";
	}

	/**
	 * 
	  ��¥ : 2018-02-22 
	  ��� : ���� ��ȣ�� �Ķ���ͷ� �޾ƿͼ� ������ȣ�� �ش��ϴ� ������ �뿩�ϴ� �Լ� 
	  �ۼ��ڸ� : ���ؼ�
	 */
	public Book rentBook(int num, Time time) { // ���� �뿩
		String filename = "C:\\Temp\\Library\\"; // ������ �ȿ� ���� ���� ���
		FileInputStream fr = null; 
		ObjectInputStream ois = null;
		Book book = null; //txt���Ͽ���  ������ȭ�� ��ü�� ��� ����
		
		try {
			fr = new FileInputStream(filename +"Books\\"+ num + ".txt");
			ois = new ObjectInputStream(fr);

			book = (Book) ois.readObject();
			if (book.isRental()) {
				FileWriter fw = new FileWriter(filename + "Users\\" + memberId + "\\" + num + ".txt");
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(num + "@" + time.getTimes()[0] + "@" + time.getTimes()[1] + "@" + book.getTitle() + "@"
						+ book.getAuthor() + "@" + book.getGenre() + "@");
				bw.newLine();
				bw.write(book.getContent());

				book.setRental(false);
				book.setRentalCount(book.getRentalCount());

				bw.close();
				fw.close();
			} else {
				System.out.println("�뿩�� �Ұ��� �մϴ�");
			}
		} catch (Exception e) {
			
		} finally {
			try {
				ois.close();
				fr.close();
			} catch (IOException e) {

			}
		}
		return book;
	}
	/** 
	 * 
	  ��¥ : 2018-02-22 
	  ��� : ���� ��ȣ�� �Ķ���ͷ� �޾ƿͼ� �ڽ��� �뿩�� ���� �б� 
	  �ۼ��ڸ� : ���ؼ�
	 */
	public void readBook(int num) {
		String filename = "C:\\Temp\\Library\\Users\\" + memberId;//userid ���� ���
		File f = new File(filename); 
		File[] fl = f.listFiles(); //f�� �����ϴ� ������ ���ϵ��� �ּҸ� ����fl�� �ִ´�.
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(filename + "\\" + num + ".txt");
			br = new BufferedReader(fr);

			String line = "";
			String[] data;
			for (int j = 0; (line = br.readLine()) != null; j++) {
				if (j == 0) {
					data = line.split("@");
					System.out.println("��¥ :" + data[1] + "\n�ѹ� : " + data[0] + "\n����: " + data[3] + "\n���� : " + data[4]
							+ "\n<<<<<<<<<< ���� >>>>>>>>>>>");
				} else {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
			}
		}
	}



}
