import java.util.Scanner;
/*
��      ¥: 2018-02-23
�ۼ��ڸ�: ����
��      ��: Main UI
*/
public class UI {

	public Bitgram bgm;
	Scanner sc = new Scanner(System.in);
	
	public UI() {
		bgm = new Bitgram();
	}
	
	public void start() { //Main UI ���� �Լ�
		bgm.makeFirstFile(); //���ϰ˻� �Լ� ȣ��
		
		while(true) {
	    System.out.println();
		System.out.println("===================================");
		System.out.println("*--------- B I T G R A M ---------*");
		System.out.println("���Ͻô� �޴��� �Է��� �ּ���");
		System.out.println("1) �α���");
		System.out.println("2) ȸ������");
		System.out.println("3) ����");
							
		try {

				System.out.print("�Է� > ");
				int select = Integer.parseInt(sc.nextLine());
				
				if (select==1){   // �α���
					System.out.print("ID : ");
					Main.id = sc.nextLine();
					
					System.out.print("PASSWORD : ");
					String pwd = sc.nextLine();
					bgm.login(Main.id, pwd);		
					//�α��ν� ����Ʈ�� ������
				}
				
				else if(select==2) { // ȸ������
					System.out.println("ȸ�� ����");
					bgm.register();
					continue;
				}
				else if(select==3) { //���α׷� ����
					System.out.println("*--------- G O O D-B Y E ---------*");
					System.exit(0);
				}
				else {
					System.out.println("1���� 2���� �ϳ��� �Է����ּ���");
				}
			} catch (Exception e) {
				System.out.println("1���� 2���� �ϳ��� �Է����ּ���");
				continue;
			}
		} // end - while
		
	} // end - Main

} // end - class
