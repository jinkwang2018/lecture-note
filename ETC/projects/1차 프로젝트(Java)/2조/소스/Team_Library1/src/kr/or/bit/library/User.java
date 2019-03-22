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
  클래스명 : AutoReturnThread 
  날짜 : 2018-02-20 
  작성자명 : 김준수, 아윤근
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
	  날짜 : 2018-02-22 
	  기능 : 도서 번호를 파라미터로 받아와서 도서번호에 해당하는 도서를 대여하는 함수 
	  작성자명 : 김준수
	 */
	public Book rentBook(int num, Time time) { // 도서 대여
		String filename = "C:\\Temp\\Library\\"; // 도서관 안에 도서 폴더 경로
		FileInputStream fr = null; 
		ObjectInputStream ois = null;
		Book book = null; //txt파일에서  역직렬화된 객체를 담는 변수
		
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
				System.out.println("대여가 불가능 합니다");
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
	  날짜 : 2018-02-22 
	  기능 : 도서 번호를 파라미터로 받아와서 자신이 대여한 도서 읽기 
	  작성자명 : 김준수
	 */
	public void readBook(int num) {
		String filename = "C:\\Temp\\Library\\Users\\" + memberId;//userid 폴더 경로
		File f = new File(filename); 
		File[] fl = f.listFiles(); //f가 참조하는 폴더의 파일들의 주소를 변수fl에 넣는다.
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
					System.out.println("날짜 :" + data[1] + "\n넘버 : " + data[0] + "\n제목: " + data[3] + "\n저자 : " + data[4]
							+ "\n<<<<<<<<<< 내용 >>>>>>>>>>>");
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
