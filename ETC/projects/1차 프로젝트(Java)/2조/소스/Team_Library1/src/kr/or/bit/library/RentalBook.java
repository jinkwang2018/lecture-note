/**
������Ʈ : �����뿩 �ý���
�����̸� : RentalBook
��¥ : 2018-02-23
�ۼ��ڸ� : ������
*/
package kr.or.bit.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//private Map<Book, User> rental; ����
// txt �ҷ����� ( �� ��ȣ : 0 >�ð� , 1 > �ð� , 2 > ���� , 3 >�۰� ,4 >�帣 , 5 >�����̴�. )
/** 
Ŭ������ : RentalBook
��¥ : 2018-02-23
�ۼ��ڸ� : ������
*/
public class RentalBook {
	private List<String> managerConList; //�����ڰ� �뿩����� �������� �뿩����� ��Ƶδ� ����Ʈ
	private FileReader fr;
	private BufferedReader br;
	private Register register; //�����ڿ� �̿����� Ÿ�Ժ񱳸� �ϱ� ���� ������ ����
	/**
	 *
	��¥ : 2018-02-23
	��� : RentalBook class �� constructor method
		Type�Լ��� �ҷ��´�.
	�ۼ��ڸ� : ������
	 */
	public RentalBook(Register register){
		this.register = register;
	}
	/**
	 * 
	��¥ : 2018-02-23
	��� : RentalBook�� ����ϴ� ����� Manager���� User����
		�Ǻ��Ͽ� �Լ��� �ٸ��� ���� ��Ų��.
	�ۼ��ڸ� : ������
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
	��¥ : 2018-02-23
	��� : Manager�� �뿩 ����� �ҷ��� �� ����ϴ� �Լ��̴�.
	�ۼ��ڸ� : ������
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
	��¥ : 2018-02-23
	��� : Manager�� User�� ��� �뿩����� �� �� �����Ƿ�
		����Լ��� ����ؼ� ��� User�� ������ ��� �� �� �ֵ��� ���ִ�
		�Լ��̴�.
	�ۼ��ڸ� : ������
	 */
	private void managerRentalSupport(File f) {
		File[] arrFS = f.listFiles(); //������ �ּҰ��� ��Ƶδ� �迭
		for (int i = 0; i < arrFS.length; i++) {
			if (arrFS[i].isDirectory()) {
				managerRentalSupport(arrFS[i]); //�ٽ� ������ ���� �ϴ� ��� �Լ�
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
	��¥ : 2018-02-23
	��� : User�� �뿩����� �� �� ����ϴ� �Լ��̴�. User�������� 
		���� �� �Ŀ� member ID�� �ּҿ� ���� ������ ������ �� �� �ִ�.
	�ۼ��ڸ� : ������
	 */
	public List<String> userRentalList(User user) {
		String path = "c:\\Temp\\Library\\Users\\" + user.getMemberId(); //�α����� ������� ������ ���� ���
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
	 * ��¥ : 2018-02-23 ��� : �о�� ������ ���ϴ� �������� ����Ʈ ���ִ� �Լ���
	 * UserrentalList,ManagerrentalList���� ����Ѵ�. �ۼ��ڸ� : ������
	 */
	public static void printList(List<String> conList) {
		
		Iterator<String> it = conList.iterator();
		while (it.hasNext()) {
			try {
				String[] item = it.next().split("@");
				System.out.printf("���� �ڵ�: %s, ���� : %s, �۰� : %s , �帣 : %s, ������ ���: %s\n", item[1], item[4], item[5], item[6], item[0]);			
			}catch (Exception e) {
			}
		}
	}
}

