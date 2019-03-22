import java.util.*;
import java.io.*;

/*
��    ¥ : 2018-02-23
�ۼ��ڸ� : ������
��    ��: ID, PWD �˻� �� ȸ�� ���
*/

public class Bitgram {

	public static Map<String, User> userinfo; // �������� <id, ������ü>
	public User user;
	public Admin admin;
	public boolean authority; // login�� Ȱ�� (*)
	public static String file = "UserInfoTest.txt"; // ���� �̸�
	public File filecheck = new File(file);
	Scanner sc = new Scanner(System.in);

	// ������ call �� �ʿ� �÷��� ���� �ø�
	public Bitgram() {
		userinfo = new HashMap<String, User>();
		user = new User();
		admin = new Admin();
	}

	public void makeFirstFile() { // ���� ���� ���� �˻�
		if (filecheck.exists()) { // ���� ����� �Լ� ���� x
			// System.out.println("������ �����մϴ�.");
			return;
		}
		// System.out.println("������ �������� �ʴ´�."); //���� ������ ���� ����
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			userinfo.put("scott", new User("scott", "tiger", "admin", "scott@bit.or.kr"));
			out.writeObject(userinfo);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ȸ�����Խ� ȸ�� ������ DB�� ���
	// User ��ü�� �޾Ƽ� ������ ���ͼ� Stream�� ���� ����
	public void register() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			userinfo = (HashMap<String, User>) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ������� ȸ������ ���μ���
		// id �ߺ��˻� �� ����� ��� ������ ����
		String id = null;
		boolean getoutid = false;
		do {
			System.out.print("ID�� �Է����ּ��� : ");
			id = sc.nextLine();

			// �ϴ� ������ false ó�� ���༭ Ż���ϵ��� ����
			getoutid = false;

			// �޾ƿ� ȸ�� DB���� �ߺ� id�� üũ
			for (HashMap.Entry<String, User> e : userinfo.entrySet()) {

				// �ߺ��� �ϳ��� �߰ߵǸ� boolean�� true
				if (id.equals(e.getKey())) {
					System.out.println("�ߺ��� ID �Դϴ�");
					System.out.println("�ٽ� ID�� �Է��մϴ�");
					System.out.println();
					getoutid = true;
				}

			} // end - for entry

		} while (getoutid); // end - Dowhile

		User temp_user = new User();
		temp_user.setId(id);

		System.out.print("Password�� �Է����ּ��� : ");
		String pwd = sc.nextLine();
		temp_user.setPwd(pwd);

		System.out.print("�г����� �Է����ּ��� : ");
		String nickname = sc.nextLine();
		temp_user.setNickname(nickname);

		System.out.print("E-mail�� �Է����ּ��� : ");
		String email = sc.nextLine();
		temp_user.setEmail(email);

		// ȸ�������� �Ϸ�Ǹ� DB�� �ְ� OutputStream
		System.out.println();
		System.out.println("������ �Ϸ�Ǿ����ϴ�");
		userinfo.put(id, temp_user);

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(userinfo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
			}
		}

	} // end - register

	// id�� pwd�� �Ķ���ͷ� �ް� ���� ������ ���Ͽ� ��ġ�� �α���
	public void login(String id, String pwd) {

		userinfo = new HashMap<String, User>();
		ObjectInputStream in = null;
		// �Էµ� id, pwd ������ DB�� �� ����� id, pwd �񱳸� ���� ����
		// ���� �̹� �����ϴ� ȸ�� DB�� Map ����
		try {
			in = new ObjectInputStream(new FileInputStream(file));

			userinfo = (HashMap<String, User>) in.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}

		boolean loginfail = true;
		do {
			// ������ ����
			if (id.equals("scott") && pwd.equals("tiger")) {

				authority = true; // login�� Ȱ�� (*)
				loginfail = false;
				admin.showNotice();
				System.out.println("Bitgram ������ ����");
				admin.process();
				break;
			}

			// �ҷ��� map���� ��� User��ü�� �����Ͽ� login �õ�
			for (Map.Entry<String, User> e : userinfo.entrySet()) {
				User temp_user = (e.getValue());

				if (id.equals(temp_user.getId())) {
					if (pwd.equals(temp_user.getPwd())) {

						loginfail = false;
						admin.showNotice();
						System.out.println("Bitgram ������ ȯ���մϴ�");
						getUserInfo().get(id).process();
						break;
					}
				}
			} // end - for

			if (loginfail) {
				System.out.println("�α��ο� �����Ͽ����ϴ�");
				// ui.start();
				break;
			}
		} while (loginfail);
	}

	// �ֽ� DB�� �ҷ��´�
	// ������ ������ �ʿ��ϸ� getfromDB�� �ֽ�DB�� �ҷ�����
	// �ٽ� puttoDB�� ���� DB�� ��� �ֽ�ȭ �ϱ� ���ؼ� �ʿ�
	public static void getFromDB() {

		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new FileInputStream(file));
			userinfo = (HashMap<String, User>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}
	} // end - getFromDB

	// �ֽ� DB�� ���Ͽ� �����Ѵ�
	// ������ ������ �ʿ��ϸ� getfromDB�� �ֽ�DB�� �ҷ�����
	// �ٽ� puttoDB�� ���� DB�� ��� �ֽ�ȭ �ϱ� ���ؼ� �ʿ�
	public static void putToDB() {

		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(userinfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e2) {
			}
		}

	} // end - putToDB

	public Map<String, User> getUserInfo() {
		return userinfo;
	}

} // end - class
