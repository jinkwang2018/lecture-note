import java.util.Map;
import java.util.Scanner;

/*
��      ¥: 2018-02-23
�ۼ��ڸ�: ������, ������
��      ��: ������ ��� UI ���� (switch -> method()ȣ��)
*/
public class Admin {

	//check ���� ����
	private boolean check = false;
	
	/*
		1. �������
			1. ���
			2. ����
			3. ���� 
			4. ����
		
		2. ��ü Ÿ�Ӷ��� ����
			1. ����
			2. ����
			3. ����
		
		3. ȸ������ ����
			1. �˻�
				1. id�� �˻�
					1. ����
					2. ����
				2. �г������� �˻�
					1. ����
					2. ����
				3. �̸��Ϸ� �˻�
					1. ����
					2. ����
				4. ����
			2. ��ü��ȸ
			3. ���� 
		
		4. ����
	 */
	
	//������ ��� UI
	public void process() {
		System.out.println("[1]�������  [2]��üŸ�Ӷ��� ����  [3]ȸ������ ����  [4]����");

		Scanner sc = new Scanner(System.in);
		int num = 0;
		try {
			System.out.print("�Է�> ");
			num = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("�ٽ� �Է��ϼ���.");
			process();
		}

		endMenu(num); // ���θ޴� ����(�Է¹��� ��==4)
		
		int contentNum = 0;
		String selectId = null;
		
		OUTER: while (true) { // ���θ޴� �ݺ�
			switch (num) { // ���θ޴� ����
				case 1: // 1. �������
					showNotice();
					
					int num1_1 = 0;
					
					try {
						System.out.println("[1]���\t[2]����\t[3]���� \t[4]���� ");
						System.out.print("�Է�> ");
						num1_1 = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("�ٽ� �Է��ϼ���");
						continue;
					}
				
					switch (num1_1) {
						case 1: // 1-1. �������� ���
							try {
								System.out.println("�������� ���");
								addNotice();
								break;
							}catch (Exception e) {
								System.out.println("�ٽ� �Է��ϼ���");
								break;
							}
					
						case 2: // 1-2. �������� ����
							try {
								System.out.print("������ �������� ��ȣ �Է� : ");
								contentNum = Integer.parseInt(sc.nextLine());
								changeNotice(contentNum);
								break;
							} catch (Exception e) {
								System.out.println("�ٽ� �Է��ϼ���");
								break;
							}
						
						case 3: // 1-3. �������� ����
							try {
								System.out.print("������ �������� ��ȣ �Է� : ");
								contentNum = Integer.parseInt(sc.nextLine());
								deleteNotice(contentNum);
								break;
							}catch (Exception e) {
								System.out.println("�ٽ� �Է��ϼ���");
								break;
							}
						
						case 4: // 1-4. ���� �޴��� �̵�
							System.out.println("��������� �����մϴ�");
							break OUTER;
						}
						break; // 1. �������-end

				case 2: // 2. ��üŸ�Ӷ��� ����
					visitAllTimeLine();
					
					int num2_1 = 0;
					try {
						System.out.println("[1]�ۼ�\t[2]����\t[3]����\t[4]���� ");
						System.out.print("�Է�> ");
						num2_1 = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("�ٽ� �Է��ϼ���");
						continue;
					}

					switch (num2_1) {
						case 1: // 2-1. Ÿ�Ӷ��� �ۼ�
							System.out.println("admin�� �ۼ��ϴ� Ÿ�Ӷ����� ������������ �ν��մϴ�.");
							Bitgram.userinfo.get(Main.id).mytimeline.writePost(Main.id);
							break;
						
						case 2: // 2-2. Ÿ�Ӷ��� ����
							try {
								System.out.print("������ id �Է��ϼ��� : ");
								selectId = sc.nextLine();
								System.out.print("������ Ÿ�Ӷ��� ��ȣ : ");
								contentNum = Integer.parseInt(sc.nextLine());
								Bitgram.userinfo.get(selectId).mytimeline.changePost(contentNum);
								break;
							} catch (Exception e) {
								System.out.println("�ٽ� �Է��ϼ���");
								break;
							}
						case 3: // 2-3. Ÿ�Ӷ��� ����
							try {
								System.out.print("������ id �Է��ϼ��� : ");
								selectId = sc.nextLine();
								System.out.print("������ Ÿ�Ӷ��� ��ȣ : ");
								contentNum = Integer.parseInt(sc.nextLine());
								Bitgram.userinfo.get(selectId).mytimeline.deletePost(contentNum, selectId);
								break;
							} catch (Exception e) {
								System.out.println("�ٽ� �Է��ϼ���");
								break;
							}
						case 4: // 2-4. Ÿ�Ӷ��� ����
							System.out.println("Ÿ�Ӷ��� ����� �����մϴ�");
							break OUTER;
						}
						break; // ��üŸ�Ӷ��� �������-end

				case 3: // 3. ȸ������ ����
					System.out.println("[1]�˻�       [2]��ü��ȸ       [3]���� ");
					System.out.print("�Է�> ");
					int num3_1 = 0;
					try {
						num3_1 = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("�ٽ� �Է��ϼ���");
						continue;
					}

					switch (num3_1) {
						case 1: // 3-1. �˻�
							int num3_2 = 0;
							String findid = null;
							String findnick = null;
							String findmail = null;
							try {
								System.out.println("[1]id�� �˻�       [2]�г������� �˻�       [3]�̸��Ϸ� �˻�       [4]���� ");
								System.out.print("�Է�> ");
								num3_2 = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("�ٽ� �Է��ϼ���");
								continue;
							}

						switch (num3_2) {
							case 1: // 3-1-1. id�� �˻�
								int num4_1 = 0;
								try {
									System.out.print("�˻��� id�� �Է��ϼ��� : ");							
									findid = sc.nextLine();
									findUserInfoById(findid);
									if(check) {
										System.out.println("[1]����\t[2]����");
										System.out.print("�Է�> ");
										num4_1 = Integer.parseInt(sc.nextLine());
										switch (num4_1) {
		
											case 1: // 3-1-1-1. ����
												deleteUserInfoById(findid);
												break;
											case 2: // 3-1-1-2. ����
												System.out.println("�����մϴ� ");
												break;
										}
										break;
									}
								} catch (Exception e) {
									System.out.println("�ٽ� �Է��ϼ���.");
									continue;
								}
						
							case 2: // 3-1-2. �г������� �˻�
								int num4_2 = 0;
								try {
									System.out.print("�˻��� �г��Ӹ� �Է��ϼ��� : ");
									findnick = sc.nextLine();
									findUserInfoByNick(findnick);
									
									if(check) {
										System.out.println("[1]����\t[2]����");
										System.out.print("�Է�> ");
										num4_2 = Integer.parseInt(sc.nextLine());
										switch (num4_2) {
		
											case 1: // 3-1-2-1. ����
												deleteUserInfoByNick(findnick);
												break;
											case 2: // 3-1-2-2. ����
												System.out.println("�����մϴ� ");
												break;
										}
										break;
									}
								} catch (Exception e) {
									System.out.println("�ٽ� �Է��ϼ���.");
									continue;
								}
						

							case 3: // 3-1-3. ���Ϸ� �˻�
								int num4_3 = 0;
								try {
									System.out.print("�˻��� �̸����� �Է��ϼ��� : ");
									findmail = sc.nextLine();
									findUserInfoByMail(findmail);
									
									if(check) {
										System.out.println("[1]����\t[2]����");
										System.out.print("�Է�> ");
										num4_3 = Integer.parseInt(sc.nextLine());
										switch (num4_3) {
		
											case 1: // 3-1-3-1. ����
												deleteUserInfoByMail(findmail);
												break;
											case 2: // 3-1-3-2. ����
												System.out.println("�����մϴ� ");
												break;
										}
										break;
									}
								} catch (Exception e) {
									System.out.println("�ٽ� �Է��ϼ���.");
									continue;
								}

							case 4: // 3-1-4. ����
								System.out.println("�����մϴ�");
								break;
							}
							break;

						case 2: // 3-2. ��ü ��ȸ
							System.out.println("��� ȸ�� ������ ���");
							showAllUserInfo();
							break;
						case 3: // 3-3. ȸ������ ���� ��� ����
							System.out.println("ȸ������ ���� ����� �����մϴ�");
							break OUTER;
						}
						break; // ȸ������ ����-end
			}// ���� �޴� ����-end
		} // ���� �޴� �ݺ�-end
		process(); // ���� �޴� �ٽ� ȣ�� 
	}

	public void endMenu(int num) { //���θ޴� ����
		try {
			if (num == 4) {
				System.out.println("������������ �����մϴ�");
				Main.ui.start();
			}else if(!(num >= 1 && num <= 4)) {
				System.out.println("���ڸ� �ٽ� �Է����ּ���.");
				process();
			}
		}catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
			process();
		}
		
	}
	
	public void showNotice() { // �������� ���
		int cnt = 0;
		if(!(Bitgram.userinfo.get("scott").mytimeline.getPosts().isEmpty())) {
			for(Map.Entry<Integer, Post> e : Bitgram.userinfo.get("scott").mytimeline.getPosts().entrySet()) {
				if(cnt == 3) return;
				e.getValue().printNotice();
				cnt++;
			}
		}
	}
	
	public void addNotice() { // �������� ���
		Bitgram.userinfo.get("scott").mytimeline.writePost("scott");
		System.out.println("���������� ���������� ��ϵǾ����ϴ�");
		Bitgram.userinfo.get("scott").visitMyTimeLine();
	}

	public void changeNotice(int contentNum) { // �������� ����
		Bitgram.userinfo.get("scott").mytimeline.changePost(contentNum);
		System.out.println("���������� ���������� �����Ǿ����ϴ�");
		Bitgram.userinfo.get("scott").visitMyTimeLine();
	}

	public void deleteNotice(int contentNum) { // �������� ����
		if (Bitgram.userinfo.get("scott").mytimeline.getPosts().size() <= 0) {
			System.out.println("������ ���������� �������� �ʽ��ϴ�.");
			return;
		}
		Bitgram.userinfo.get("scott").mytimeline.deletePost(contentNum, "scott");
	}
	
	// Ÿ�Ӷ��� ���
	public void visitAllTimeLine() { // ��ü Ÿ�Ӷ��� ����
		for(Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			System.out.println("===================================");
			System.out.println(m.getValue().getId() + " ���� Ÿ�Ӷ���");
			System.out.println("===================================");
			m.getValue().visitMyTimeLine();
		}
	}

	
	// ȸ����������
    
	public void showUserInfo(Map.Entry<String, User> m) { //ȸ�� ���� ����
		
		System.out.println("-----------------------------------");
		System.out.println("[Id] : " + m.getValue().getId());
		System.out.println("[Nickname] : " + m.getValue().getNickname());
		System.out.println("[E-mail] : " + m.getValue().getEmail());
		System.out.println();
	}
	
    public void findUserInfoById(String id) { // Ư�� ȸ������ id�� �˻�(*Ŭ�������̾�׷� �߰�)
		check = false;
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (id.equals(m.getValue().getId())) {
				showUserInfo(m);
				check = true;
				break;
			}else {
				System.out.println("��ϵ� id�� �����ϴ�.");
			}
		}
	}

    public void findUserInfoByNick(String nick) { // Ư�� ȸ������ nick���� �˻�(*Ŭ�������̾�׷� �߰�)
		check = false;
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (nick.equals(m.getValue().getNickname())) {
				showUserInfo(m);
				check = true;
				break;
			}else {
				System.out.println("��ϵ� nickname�� �����ϴ�.");
			}
		}
	}

    public void findUserInfoByMail(String mail) { // Ư�� ȸ������ mail�� �˻�(*Ŭ�������̾�׷� �߰�)
		check = false;
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (mail.equals(m.getValue().getEmail())) {
				showUserInfo(m);
				check = true;
				break;
			}else {
				System.out.println("��ϵ� mail�� �����ϴ�.");
			}
		}
	}
	public void showAllUserInfo() { // ȸ������ ��ü��ȸ
		Bitgram.userinfo.get(Main.id).showAllUser();
	}
	
	public void deleteUserInfoById(String id) { // **������** id ���� �̿��� Ư�� ȸ������ ���� // �ӽð���
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (id.equals(m.getValue().getId())) {
				Bitgram.userinfo.remove(m.getKey());
				System.out.println("���������� �����Ǿ����ϴ�.");
				break;
			}else {
				System.out.println("��ϵ� id�� �����ϴ�.");
			}
		}
		Bitgram.putToDB();
	}

	public void deleteUserInfoByNick(String nick) { // **������** nick ���� �̿��� Ư�� ȸ������ ���� // �ӽð���
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (nick.equals(m.getValue().getNickname())) {
				Bitgram.userinfo.remove(m.getKey());
				System.out.println("���������� �����Ǿ����ϴ�.");
				break;
			}else {
				System.out.println("��ϵ� nickname�� �����ϴ�.");
			}
		}
		Bitgram.putToDB();
	}

	public void deleteUserInfoByMail(String mail) { // **������** mail���� �̿��� Ư�� ȸ������ ���� // �ӽð���
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (mail.equals(m.getValue().getEmail())) {
				Bitgram.userinfo.remove(m.getKey());
				System.out.println("���������� �����Ǿ����ϴ�.");
				break;
			}else {
				System.out.println("��ϵ� nickname�� �����ϴ�.");
			}
		}
		Bitgram.putToDB();
	}
} // end - class
