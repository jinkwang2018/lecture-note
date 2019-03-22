package kr.or.bit.library;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
Ŭ������ : AutoReturnThread
��¥ : 2018-02-23
�ۼ��ڸ� : ���¿�
*/
public class AutoReturnThread extends Thread {   //�ǽð� ����
	private Library library;									// main ���� ������ Library �ּҸ� ���� ����, library
	private Manager manager;									// Library ��ü���� ������ Manager �ּҸ� ���� ����, manager
	private List<String> conList;								// �뿩�� å���� ��ü�� ���� ���� conList
	private String[] mainTime;									// Library ������ �ð��� ���� ����, mainTime
	private final String PATH = "c:\\Temp\\library\\Users";		// ������ Users ���� Path
	
	public AutoReturnThread(Library library, Manager manager) {
		this.library = library;
		this.manager = manager;
	}
	/**
	 * 
	��¥ : 2018-02-24
	��� : ���� �뿩 ���� å���� ����Ʈ�� ��������, ���� �뿩 �Ⱓ�� �� �� �ݳ��� å���� ����Ʈ�� �ٽ� ��ȯ�ϴ� �Լ�
	�ۼ��ڸ� : ���¿�
	 */
	public Map<String, String> getRentList() {
		Map<String, String> returnList = new HashMap<>(); 	// ��ȯ getName
		conList = library.rentBookList(manager);			// ��� �뿩�� å List�� �������� ���� manager��ü�� ���
		mainTime = library.getTime();						// ���� �ð�
		Iterator<String> it = conList.iterator();
		// write --> [0] ������ ��, [1]�����ڵ�, [2]�뿩 ��¥, [3]�ý��� �ð�, [4]������, [5]�۰�
		while (it.hasNext()) {
			try {
				String[] item = it.next().split("@");
				if(isReturn(Long.parseLong(mainTime[1]), Long.parseLong(item[3]))) {
					returnList.put(item[1], item[0]); // Map<�����ڵ�, ��������>
				}
			}catch (Exception e) {
			}
		}
		return returnList; // �ݳ��� å���� ����Ʈ
	}
	/**
	 * 
	��¥ : 2018-02-24
	��� : getRentList()���� ã�� map<Book code, id>�� �Ķ���ͷ� ������
		 library�� booklist.txt, bookMap �ֽ�ȭ
	�ۼ��ڸ� : ���¿�
	 */
	public void returnBook(Map<String, String> map) { 			// �ݳ��� å���� �޾Ƽ�~
		Map<Integer, Book> libBookMap= library.getBookMap(); 	// �������� �ִ� ��ü å map �ް�
		Set<String> bookcode = map.keySet(); 					// Map<�����ڵ�, ��������>
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
				System.out.println("�ڵ� �ݳ��� å�� �������� �ʽ��ϴ�.");
			}
		}
		library.listModify(libBookMap);
	}
	/**
	 * 
	��¥ : 2018-02-24
	��� : �ݳ��� å���� ����ð��� �뿩�� �ð��� ���� �̿��� true/false ����
	�ۼ��ڸ� : ���¿�
	 */
	public boolean isReturn(long now, long past) {
		boolean isReturn = false;
		long term = (now - past) / 1000;	// �ʴ����� ȯ��
		long returnPeriod = 60;				// �ݳ�����: �ʴ���.
		if(term > returnPeriod)
			isReturn = true;
		
		return isReturn;
	}
	/**
	 * 
	��¥ : 2018-02-24
	��� : Library System���� background���� �ڵ� ���� �ݳ� ����� �������� thread run �Լ�
	�ۼ��ڸ� : ���¿�
	 */
	@Override
	public void run() {
		while(true) {
			returnBook(getRentList());
			try {
				Thread.sleep(30000);				// x / 1000 �ʸ�ŭ Auto-Return �ݺ�
			} catch (Exception e) {
			}
		}
	}
}
