/**
프로젝트 : 도서대여 시스템
파일이름 : RentalBook
날짜 : 2018-02-23
작성자명 : 강진광
*/
package kr.or.bit.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//private Map<Book, User> rental; 삭제
// txt 불러오기 ( 방 번호 : 0 >시간 , 1 > 시간 , 2 > 제목 , 3 >작가 ,4 >장르 , 5 >내용이다. )
/** 
클래스명 : RentalBook
날짜 : 2018-02-23
작성자명 : 강진광
*/
public class RentalBook {
	private List<String> managerConList; //관리자가 대여목록을 보기위해 대여목록을 담아두는 리스트
	private FileReader fr;
	private BufferedReader br;
	private Register register; //관리자와 이용자의 타입비교를 하기 위해 선언한 변수
	/**
	 *
	날짜 : 2018-02-23
	기능 : RentalBook class 의 constructor method
		Type함수를 불러온다.
	작성자명 : 강진광
	 */
	public RentalBook(Register register){
		this.register = register;
	}
	/**
	 * 
	날짜 : 2018-02-23
	기능 : RentalBook을 사용하는 사람이 Manager인지 User인지
		판별하여 함수를 다르게 실행 시킨다.
	작성자명 : 강진광
	 */
	public List<String> type() {
		if(register instanceof Manager) {
			return this.managerRentalList();
		}else {
			return this.userRentalList((User)register);
		}
	}
	/**
	 * 
	날짜 : 2018-02-23
	기능 : Manager가 대여 목록을 불러올 때 사용하는 함수이다.
	작성자명 : 강진광
	 */
	public List<String> managerRentalList(){
		managerConList = new ArrayList<>(); 
		String path = "c:\\Temp\\Library\\Users\\";
		File f = new File(path);
		
		managerRentalSupport(f);
		
		return managerConList;
	}
	/**
	 * 
	날짜 : 2018-02-23
	기능 : Manager는 User의 모든 대여목록을 볼 수 있으므로
		재귀함수를 사용해서 모든 User의 폴더에 들어 갈 수 있도록 해주는
		함수이다.
	작성자명 : 강진광
	 */
	private void managerRentalSupport(File f) {
		File[] arrFS = f.listFiles(); //파일의 주소값을 담아두는 배열
		for (int i = 0; i < arrFS.length; i++) {
			if (arrFS[i].isDirectory()) {
				managerRentalSupport(arrFS[i]); //다시 폴더에 들어가게 하는 재귀 함수
			} else {
				try {
					fr = new FileReader(arrFS[i].getPath());
					br = new BufferedReader(fr);
				
					String line = "";
					String line1 = "";
					for (int j = 0; (line = br.readLine()) != null; j++) {
						line1 += line;	
					}
					managerConList.add(String.join("@", f.getName(), line1));
					line1 = "";
				} catch (IOException e) {
				} finally {
					try {
						br.close();
						fr.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}
	/**
	 * 
	날짜 : 2018-02-23
	기능 : User가 대여목록을 볼 때 사용하는 함수이다. User폴더까지 
		들어가고 그 후에 member ID를 주소에 더해 본인의 폴더만 볼 수 있다.
	작성자명 : 강진광
	 */
	public List<String> userRentalList(User user) {
		String path = "c:\\Temp\\Library\\Users\\" + user.getMemberId(); //로그인한 사용자의 폴더에 들어가는 경로
		File f = new File(path);
		List<String> conList = new ArrayList<String>(); 
		File[] arrFS = f.listFiles();
		for (int j = 0; j < arrFS.length; j++) {
			try {
				fr = new FileReader(arrFS[j].getPath());
				br = new BufferedReader(fr);
				String line = "";
				String line1 = "";
				for (int i = 0; (line = br.readLine()) != null; i++) {
					line1 += line;
				}
				conList.add(String.join("@", f.getName(), line1));
				line1 = "";
				
			} catch (Exception e) {
			} finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
				}
			}
		}
		return conList;
	}

	/**
	 * 
	 * 날짜 : 2018-02-23 기능 : 읽어온 파일을 원하는 형식으로 프린트 해주는 함수로
	 * UserrentalList,ManagerrentalList에서 사용한다. 작성자명 : 강진광
	 */
	public static void printList(List<String> conList) {
		
		Iterator<String> it = conList.iterator();
		while (it.hasNext()) {
			try {
				String[] item = it.next().split("@");
				System.out.printf("도서 코드: %s, 제목 : %s, 작가 : %s , 장르 : %s, 빌려간 사람: %s\n", item[1], item[4], item[5], item[6], item[0]);			
			}catch (Exception e) {
			}
		}
	}
}

