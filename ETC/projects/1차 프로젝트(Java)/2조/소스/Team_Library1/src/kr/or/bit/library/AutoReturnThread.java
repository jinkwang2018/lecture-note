package kr.or.bit.library;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
클래스명 : AutoReturnThread
날짜 : 2018-02-23
작성자명 : 김태웅
*/
public class AutoReturnThread extends Thread {   //실시간 갱신
	private Library library;									// main 에서 생성된 Library 주소를 담을 변수, library
	private Manager manager;									// Library 객체에서 생성된 Manager 주소를 담을 변수, manager
	private List<String> conList;								// 대여된 책들의 객체를 담을 변수 conList
	private String[] mainTime;									// Library 기준의 시간을 담을 변수, mainTime
	private final String PATH = "c:\\Temp\\library\\Users";		// 고정된 Users 폴더 Path
	
	public AutoReturnThread(Library library, Manager manager) {
		this.library = library;
		this.manager = manager;
	}
	/**
	 * 
	날짜 : 2018-02-24
	기능 : 현재 대여 중인 책들의 리스트를 가져오고, 기준 대여 기간과 비교 후 반납될 책들의 리스트를 다시 반환하는 함수
	작성자명 : 김태웅
	 */
	public Map<String, String> getRentList() {
		Map<String, String> returnList = new HashMap<>(); 	// 변환 getName
		conList = library.rentBookList(manager);			// 모든 대여된 책 List를 가져오기 위해 manager객체를 사용
		mainTime = library.getTime();						// 현재 시간
		Iterator<String> it = conList.iterator();
		// write --> [0] 빌려간 놈, [1]도서코드, [2]대여 날짜, [3]시스템 시간, [4]도서명, [5]작가
		while (it.hasNext()) {
			try {
				String[] item = it.next().split("@");
				if(isReturn(Long.parseLong(mainTime[1]), Long.parseLong(item[3]))) {
					returnList.put(item[1], item[0]); // Map<도서코드, 빌려간놈>
				}
			}catch (Exception e) {
			}
		}
		return returnList; // 반납될 책들의 리스트
	}
	/**
	 * 
	날짜 : 2018-02-24
	기능 : getRentList()에서 찾은 map<Book code, id>를 파라미터로 가져와
		 library의 booklist.txt, bookMap 최신화
	작성자명 : 김태웅
	 */
	public void returnBook(Map<String, String> map) { 			// 반납될 책들의 받아서~
		Map<Integer, Book> libBookMap= library.getBookMap(); 	// 도서관에 있는 전체 책 map 받고
		Set<String> bookcode = map.keySet(); 					// Map<도서코드, 빌려간놈>
		Iterator<String> it = bookcode.iterator();
		while(it.hasNext()) {
			String code = it.next();
			File f = new File(String.join("\\", PATH, map.get(code), code) + ".txt"); 
			// join("\\", PATH, id, code) + ".txt"
			if(f.exists()) {
				f.delete();
				libBookMap.get(Integer.parseInt(code)).setRental(true);
				library.bookModify(libBookMap.get(Integer.parseInt(code)));
				System.out.println("Auto Book Return");
			}else {
				System.out.println("자동 반납할 책이 존재하지 않습니다.");
			}
		}
		library.listModify(libBookMap);
	}
	/**
	 * 
	날짜 : 2018-02-24
	기능 : 반납할 책인지 현재시간과 대여한 시간의 차를 이용해 true/false 리턴
	작성자명 : 김태웅
	 */
	public boolean isReturn(long now, long past) {
		boolean isReturn = false;
		long term = (now - past) / 1000;	// 초단위로 환산
		long returnPeriod = 60;				// 반납기한: 초단위.
		if(term > returnPeriod)
			isReturn = true;
		
		return isReturn;
	}
	/**
	 * 
	날짜 : 2018-02-24
	기능 : Library System에서 background에서 자동 도서 반납 기능을 수행해줄 thread run 함수
	작성자명 : 김태웅
	 */
	@Override
	public void run() {
		while(true) {
			returnBook(getRentList());
			try {
				Thread.sleep(30000);				// x / 1000 초만큼 Auto-Return 반복
			} catch (Exception e) {
			}
		}
	}
}
