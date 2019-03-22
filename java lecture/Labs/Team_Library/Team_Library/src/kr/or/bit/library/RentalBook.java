package kr.or.bit.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//private Map<Book, User> rental; 삭제
// 메니저이면 권한 주기
// 재귀함수
// txt 불러오기 ( 방 번호 : 0 >시간 , 1 > 시간 , 2 > 제목 , 3 >작가 ,4 >장르 , 5 >내용이다.
//나는 2345만 불러오게하기
public class RentalBook {
	public static List<String> conList = new ArrayList<String>();
	String path = "c:\\Temp\\Library\\Users\\";
	File f = new File(path);
	FileReader fr;
	BufferedReader br;
	Register register;
	public void RentalBook(Register register){
		this.register = register;
		this.Type();
	}
	
	void Type() {
		if(register instanceof Manager) {
			this.ManagerrentalList(f);
		}else {
			this.UserrentalList();
		}
	}
		
	public void ManagerrentalList(File f) {// 현재 대여 중인 목록 변경
		File[] arrFS = f.listFiles();
		
		for (int i = 0; i < arrFS.length; i++) {
			if (arrFS[i].isDirectory()) {
				ManagerrentalList(arrFS[i]);
			} else {
				try {
					fr = new FileReader(arrFS[i].getPath());
					br = new BufferedReader(fr);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					String line = "";
					String line1 = "";
					for (int j = 0; (line = br.readLine()) != null; j++) {
						line1 += line;	
					}
					conList.add(line1);
					line1 = "";
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	void sample(File f) throws Exception {
		ManagerrentalList(f);
		Iterator<String> it = conList.iterator();
		System.out.println();
		while (it.hasNext()) {
			String[] item = it.next().split("@");
			for(int i = 0 ; i < item.length ; i+=4) {
				System.out.printf("제목 : %s, 작가 : %s , 장르 : %s",item[0],item[1],item[2]);
				System.out.println();
			}	
		}	
	}

	public void UserrentalList() {
		try {
			fr = new FileReader(f + ((User) register).getMemberId());
			br = new BufferedReader(fr);
			String line = "";
			for (int i = 0; (line = br.readLine()) != null; i++) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

		}
	}
}
