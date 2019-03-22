import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex13_HashMap_Quiz {
	public static void main(String[] args) {
		//�ý��ۿ� �α��� �ϴ� �ó�����
		//ID(o), PWD(o) >> ȸ�� (ȯ��)
		//ID(o), PWD(x) >> ���� (��� �ٽ� �Է�)
		
		//ID(x), PWD(x) >> ���� (�ٽ� �Է�)
		//ID(x), PWD(o)
		
		//Scanner ����ؼ� ID, PWD �Է¹�������
		//loginmap ���ؼ� ���� ���� ó��
		//ID �Ǵ� PWD Ʋ���� �ٽ� �Է� ��û
		//ID, PWD �� ������ ȸ���� �湮 ȯ���մϴ� (��� ���α׷� ����)
		
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("ID , PWD �Է��� �ּ���");
			System.out.print("ID:");
			String id = sc.nextLine().trim().toLowerCase();
			
			System.out.print("PWD:");
			String pwd = sc.nextLine().trim();
			
			if(!loginmap.containsKey(id)) {
				System.out.println("ID Ʋ���� ���Է� �ϼ���");
			}else {
				if(loginmap.get(id).equals(pwd)) { //loginmap.get(id) >> value return
					System.out.println("ȸ���� �氡�氡 ^^");
					break;
				}else {
					System.out.println("��� Ȯ�� �ϼ���");
				}
			}
		}
		
		/*���� § �ڵ�
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("ID �Է�: ");
			String id = sc.nextLine();
			
			System.out.print("PWD �Է�: ");
			String pwd = sc.nextLine();
			
			if(loginmap.containsKey(id)) {
				if(loginmap.get(id).equals(pwd)) {
					System.out.println(id + " ȸ���� �湮�� ȯ���մϴ�.");
					break;
				}else {
					System.out.println("��й�ȣ�� �ٽ� �Է� ���ּ���.");
				}
			}else {
				System.out.println("�ش� ���̵� �����ϴ�. �ٽ� �Է� ���ּ���.");
			}
		}while(true);
		*/
	}
}
