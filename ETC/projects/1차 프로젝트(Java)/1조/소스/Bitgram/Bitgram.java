import java.util.*;
import java.io.*;

/*
날    짜 : 2018-02-23
작성자명 : 김정권
기    능: ID, PWD 검사 및 회원 등록
*/

public class Bitgram {

	public static Map<String, User> userinfo; // 유저정보 <id, 유저객체>
	public User user;
	public Admin admin;
	public boolean authority; // login시 활용 (*)
	public static String file = "UserInfoTest.txt"; // 파일 이름
	public File filecheck = new File(file);
	Scanner sc = new Scanner(System.in);

	// 생성자 call 시 필요 컬렉션 힙에 올림
	public Bitgram() {
		userinfo = new HashMap<String, User>();
		user = new User();
		admin = new Admin();
	}

	public void makeFirstFile() { // 파일 존재 여부 검사
		if (filecheck.exists()) { // 파일 존재시 함수 실행 x
			// System.out.println("파일이 존재합니다.");
			return;
		}
		// System.out.println("파일이 존재하지 않는다."); //파일 없을시 새로 생성
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

	// 회원가입시 회원 정보를 DB에 등록
	// User 전체를 받아서 변수를 빼와서 Stream을 통해 저장
	public void register() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			userinfo = (HashMap<String, User>) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 여기부터 회원가입 프로세스
		// id 중복검사 후 통과시 모두 순차적 진행
		String id = null;
		boolean getoutid = false;
		do {
			System.out.print("ID를 입력해주세요 : ");
			id = sc.nextLine();

			// 일단 무조건 false 처리 해줘서 탈출하도록 세팅
			getoutid = false;

			// 받아온 회원 DB에서 중복 id를 체크
			for (HashMap.Entry<String, User> e : userinfo.entrySet()) {

				// 중복이 하나라도 발견되면 boolean이 true
				if (id.equals(e.getKey())) {
					System.out.println("중복된 ID 입니다");
					System.out.println("다시 ID를 입력합니다");
					System.out.println();
					getoutid = true;
				}

			} // end - for entry

		} while (getoutid); // end - Dowhile

		User temp_user = new User();
		temp_user.setId(id);

		System.out.print("Password를 입력해주세요 : ");
		String pwd = sc.nextLine();
		temp_user.setPwd(pwd);

		System.out.print("닉네임을 입력해주세요 : ");
		String nickname = sc.nextLine();
		temp_user.setNickname(nickname);

		System.out.print("E-mail을 입력해주세요 : ");
		String email = sc.nextLine();
		temp_user.setEmail(email);

		// 회원가입이 완료되면 DB에 넣고 OutputStream
		System.out.println();
		System.out.println("저장이 완료되었습니다");
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

	// id와 pwd를 파라미터로 받고 유저 정보와 비교하여 일치시 로그인
	public void login(String id, String pwd) {

		userinfo = new HashMap<String, User>();
		ObjectInputStream in = null;
		// 입력된 id, pwd 정보와 DB내 기 저장된 id, pwd 비교를 위한 과정
		// 먼저 이미 존재하는 회원 DB인 Map 구현
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
			// 관리자 접속
			if (id.equals("scott") && pwd.equals("tiger")) {

				authority = true; // login시 활용 (*)
				loginfail = false;
				admin.showNotice();
				System.out.println("Bitgram 관리자 접속");
				admin.process();
				break;
			}

			// 불러온 map내에 모든 User객체에 접근하여 login 시도
			for (Map.Entry<String, User> e : userinfo.entrySet()) {
				User temp_user = (e.getValue());

				if (id.equals(temp_user.getId())) {
					if (pwd.equals(temp_user.getPwd())) {

						loginfail = false;
						admin.showNotice();
						System.out.println("Bitgram 접속을 환영합니다");
						getUserInfo().get(id).process();
						break;
					}
				}
			} // end - for

			if (loginfail) {
				System.out.println("로그인에 실패하였습니다");
				// ui.start();
				break;
			}
		} while (loginfail);
	}

	// 최신 DB를 불러온다
	// 데이터 변동이 필요하면 getfromDB로 최신DB를 불러오고
	// 다시 puttoDB를 통해 DB를 계속 최신화 하기 위해서 필요
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

	// 최신 DB를 파일에 갱신한다
	// 데이터 변동이 필요하면 getfromDB로 최신DB를 불러오고
	// 다시 puttoDB를 통해 DB를 계속 최신화 하기 위해서 필요
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
