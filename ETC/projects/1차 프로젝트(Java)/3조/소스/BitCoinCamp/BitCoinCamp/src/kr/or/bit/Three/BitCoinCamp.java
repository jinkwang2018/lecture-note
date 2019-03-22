/**
 ������Ʈ : ��Ʈ���� ķ�� �ý���
 �����̸� : BitCoinCamp.java
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
*/

package kr.or.bit.Three;

import java.util.Scanner;

/**
 Ŭ������ : BitCoinCamp
 ��    ¥ : 2018. 2. 23.
 �ۼ��ڸ� : �� �� ��
 */
public class BitCoinCamp {
	
	private Scanner sc;
	private Member member; // ����ڰ� �л�, ������, �������� ���� ������ ���� �θ�Ÿ������ ����
	
	public BitCoinCamp() {
		sc = new Scanner(System.in);
	}
	
	/**
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : ����ȭ������ �����(�л�, ������, ��������)�� �´� ȭ���� ������
	 �ۼ��ڸ� : �� �� ��
	 */
	public void start() {
		login();
		System.out.println("�α����� �Ǿ����ϴ�.");
		
		int menu = 0;
		if(member instanceof Student) { // �л����� �α������� ��
			do {
				printStudnetMenu();
				try {
					menu = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					menu = 0;
					continue;
				}
				switch (menu) {
				case 1:
					((Student) member).attending();
					break;
				case 2:
					((Student) member).attendingCheck();
					break;
				case 3:
					((Student) member).consultinCheck();
					break;
				case 4:
					((Student) member).consultingAdd();
					break;
				case 5:
					((Student) member).scoreCheck();
					break;
				case 6:
					System.out.println("����Ǿ����ϴ�.");
					break;
				default:
					break;
				}
			}while(menu != 6);
		}else if(member instanceof Teacher) { // ���������� �α������� ��
			do {
				printTeacherMenu();
				try {
					menu = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					menu = 0;
					continue;
				}
				
				switch (menu) {
				case 1:
					((Teacher) member).lectureAddLecture();
					break;
				case 2:
					((Teacher) member).lectureChecking();
					break;
				case 3:
					((Teacher) member).lectureDelete();
					break;
				case 4:
					((Teacher) member).scoreManagement();
					break;
				case 5:
					((Teacher) member).scoreModify();
					break;
				case 6:
					System.out.println("���� �Ǿ����ϴ�.");
					break;
				default:
					break;
				}
			}while(menu != 6);
		}else if(member instanceof Staff) { // ������������ �α������� ��
			do {
				printStaffMenu();
				try {
					menu = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
					menu = 0;
					continue;
				}
				switch (menu) {
				case 1:
					((Staff) member).userManagement();
					break;
				case 2:
					System.out.println("���� �Ǿ����ϴ�.");
					break;
				default:
					break;
				}
			}while(menu != 2);
		}
	}
	
	/**
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : ����ڷκ��� ID�� ��й�ȣ�� �Է¹޾Ƽ� UserList�� ���� ���̵�� ��й�ȣ�� �ִ��� Ȯ��
	 �ۼ��ڸ� : �� �� ��
	 */
	private void login() {
		while(true) {
			System.out.println("ID�� �Է��ϼ���.");
			String id = sc.nextLine();
			System.out.println("��й�ȣ�� �Է��ϼ���.");
			String password = sc.nextLine();
			
			if(UserLists.getInstance().getStudentList().containsKey(id)) {
				if(UserLists.getInstance().getStudentList().get(id).getPassword().equals(password)) {
					member = UserLists.getInstance().getStudentList().get(id); // �л��̸� member�� Student�� ����(������ �̿�)
					break;
				}else {
					System.out.println("ID�� ��й�ȣ�� Ȯ�����ּ���");
				}
			}else if(UserLists.getInstance().getTeacherList().containsKey(id)) {
				if(UserLists.getInstance().getTeacherList().get(id).getPassword().equals(password)) {
					member = UserLists.getInstance().getTeacherList().get(id); //�������̸� member�� Teacher�� ����(������ �̿�)
					break;
				}else {
					System.out.println("ID�� ��й�ȣ�� Ȯ�����ּ���");
				}
			}else if(UserLists.getInstance().getStaffList().containsKey(id)) {
				if(UserLists.getInstance().getStaffList().get(id).getPassword().equals(password)) {
					member = UserLists.getInstance().getStaffList().get(id); // ���������̸� member�� Teacher�� ����(������ �̿�)
					break;
				}else {
					System.out.println("ID�� ��й�ȣ�� Ȯ�����ּ���");
				}
			}else {
				System.out.println("ID�� ��й�ȣ�� Ȯ�����ּ���");
			}
		}
	}
	
	/**
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : �л� �޴� ����ϴ� �Լ�
	 �ۼ��ڸ� : �� �� ��
	 */
	private void printStudnetMenu() {
		System.out.println("�޴��� �Է����ּ���.");
		System.out.println("1. �⼮	2. �⼮Ȯ��	3. ���Ȯ��	4. ����߰�	5. ����Ȯ��	6. ����");
	}
	
	/**
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : ������ �޴� ����ϴ� �Լ�
	 �ۼ��ڸ� : �� �� ��
	 */
	private void printTeacherMenu() {
		System.out.println("�޴��� �Է����ּ���.");
		System.out.println("1. ���°��� 2.����Ȯ�� 3.���»��� 4.������� 5.��������	6.����");
	}
	
	/**
	 ��    ¥ : 2018. 2. 24.
	 ��    �� : �������� �޴� ����ϴ� �Լ�
	 �ۼ��ڸ� : �� �� ��
	 */
	private void printStaffMenu() {
		System.out.println("�޴��� �Է����ּ���.");
		System.out.println("1. ȸ������	2. ����");
	}
}
