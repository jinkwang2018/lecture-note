import java.util.Map;
import java.util.Scanner;

/*
날      짜: 2018-02-23
작성자명: 강성훈, 정진수
기      능: 관리자 모드 UI 구현 (switch -> method()호출)
*/
public class Admin {

	//check 변수 선언
	private boolean check = false;
	
	/*
		1. 공지기능
			1. 등록
			2. 수정
			3. 삭제 
			4. 종료
		
		2. 전체 타임라인 열람
			1. 수정
			2. 삭제
			3. 종료
		
		3. 회원정보 관리
			1. 검색
				1. id로 검색
					1. 삭제
					2. 종료
				2. 닉네임으로 검색
					1. 삭제
					2. 종료
				3. 이메일로 검색
					1. 삭제
					2. 종료
				4. 종료
			2. 전체조회
			3. 종료 
		
		4. 종료
	 */
	
	//관리자 모드 UI
	public void process() {
		System.out.println("[1]공지기능  [2]전체타임라인 열람  [3]회원정보 관리  [4]종료");

		Scanner sc = new Scanner(System.in);
		int num = 0;
		try {
			System.out.print("입력> ");
			num = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("다시 입력하세요.");
			process();
		}

		endMenu(num); // 메인메뉴 종료(입력받은 값==4)
		
		int contentNum = 0;
		String selectId = null;
		
		OUTER: while (true) { // 메인메뉴 반복
			switch (num) { // 메인메뉴 선택
				case 1: // 1. 공지기능
					showNotice();
					
					int num1_1 = 0;
					
					try {
						System.out.println("[1]등록\t[2]수정\t[3]삭제 \t[4]종료 ");
						System.out.print("입력> ");
						num1_1 = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("다시 입력하세요");
						continue;
					}
				
					switch (num1_1) {
						case 1: // 1-1. 공지사항 등록
							try {
								System.out.println("공지사항 등록");
								addNotice();
								break;
							}catch (Exception e) {
								System.out.println("다시 입력하세요");
								break;
							}
					
						case 2: // 1-2. 공지사항 수정
							try {
								System.out.print("수정할 공지사항 번호 입력 : ");
								contentNum = Integer.parseInt(sc.nextLine());
								changeNotice(contentNum);
								break;
							} catch (Exception e) {
								System.out.println("다시 입력하세요");
								break;
							}
						
						case 3: // 1-3. 공지사항 삭제
							try {
								System.out.print("삭제할 공지사항 번호 입력 : ");
								contentNum = Integer.parseInt(sc.nextLine());
								deleteNotice(contentNum);
								break;
							}catch (Exception e) {
								System.out.println("다시 입력하세요");
								break;
							}
						
						case 4: // 1-4. 메인 메뉴로 이동
							System.out.println("공지기능을 종료합니다");
							break OUTER;
						}
						break; // 1. 공지기능-end

				case 2: // 2. 전체타임라인 열람
					visitAllTimeLine();
					
					int num2_1 = 0;
					try {
						System.out.println("[1]작성\t[2]수정\t[3]삭제\t[4]종료 ");
						System.out.print("입력> ");
						num2_1 = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("다시 입력하세요");
						continue;
					}

					switch (num2_1) {
						case 1: // 2-1. 타임라인 작성
							System.out.println("admin이 작성하는 타임라인은 공지사항으로 인식합니다.");
							Bitgram.userinfo.get(Main.id).mytimeline.writePost(Main.id);
							break;
						
						case 2: // 2-2. 타임라인 수정
							try {
								System.out.print("수정할 id 입력하세요 : ");
								selectId = sc.nextLine();
								System.out.print("수정할 타임라인 번호 : ");
								contentNum = Integer.parseInt(sc.nextLine());
								Bitgram.userinfo.get(selectId).mytimeline.changePost(contentNum);
								break;
							} catch (Exception e) {
								System.out.println("다시 입력하세요");
								break;
							}
						case 3: // 2-3. 타임라인 삭제
							try {
								System.out.print("삭제할 id 입력하세요 : ");
								selectId = sc.nextLine();
								System.out.print("삭제할 타임라인 번호 : ");
								contentNum = Integer.parseInt(sc.nextLine());
								Bitgram.userinfo.get(selectId).mytimeline.deletePost(contentNum, selectId);
								break;
							} catch (Exception e) {
								System.out.println("다시 입력하세요");
								break;
							}
						case 4: // 2-4. 타임라인 종료
							System.out.println("타임라인 기능을 종료합니다");
							break OUTER;
						}
						break; // 전체타임라인 열람기능-end

				case 3: // 3. 회원정보 관리
					System.out.println("[1]검색       [2]전체조회       [3]종료 ");
					System.out.print("입력> ");
					int num3_1 = 0;
					try {
						num3_1 = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {
						System.out.println("다시 입력하세요");
						continue;
					}

					switch (num3_1) {
						case 1: // 3-1. 검색
							int num3_2 = 0;
							String findid = null;
							String findnick = null;
							String findmail = null;
							try {
								System.out.println("[1]id로 검색       [2]닉네임으로 검색       [3]이메일로 검색       [4]종료 ");
								System.out.print("입력> ");
								num3_2 = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("다시 입력하세요");
								continue;
							}

						switch (num3_2) {
							case 1: // 3-1-1. id로 검색
								int num4_1 = 0;
								try {
									System.out.print("검색할 id를 입력하세요 : ");							
									findid = sc.nextLine();
									findUserInfoById(findid);
									if(check) {
										System.out.println("[1]삭제\t[2]종료");
										System.out.print("입력> ");
										num4_1 = Integer.parseInt(sc.nextLine());
										switch (num4_1) {
		
											case 1: // 3-1-1-1. 삭제
												deleteUserInfoById(findid);
												break;
											case 2: // 3-1-1-2. 종료
												System.out.println("종료합니다 ");
												break;
										}
										break;
									}
								} catch (Exception e) {
									System.out.println("다시 입력하세요.");
									continue;
								}
						
							case 2: // 3-1-2. 닉네임으로 검색
								int num4_2 = 0;
								try {
									System.out.print("검색할 닉네임를 입력하세요 : ");
									findnick = sc.nextLine();
									findUserInfoByNick(findnick);
									
									if(check) {
										System.out.println("[1]삭제\t[2]종료");
										System.out.print("입력> ");
										num4_2 = Integer.parseInt(sc.nextLine());
										switch (num4_2) {
		
											case 1: // 3-1-2-1. 삭제
												deleteUserInfoByNick(findnick);
												break;
											case 2: // 3-1-2-2. 종료
												System.out.println("종료합니다 ");
												break;
										}
										break;
									}
								} catch (Exception e) {
									System.out.println("다시 입력하세요.");
									continue;
								}
						

							case 3: // 3-1-3. 메일로 검색
								int num4_3 = 0;
								try {
									System.out.print("검색할 이메일을 입력하세요 : ");
									findmail = sc.nextLine();
									findUserInfoByMail(findmail);
									
									if(check) {
										System.out.println("[1]삭제\t[2]종료");
										System.out.print("입력> ");
										num4_3 = Integer.parseInt(sc.nextLine());
										switch (num4_3) {
		
											case 1: // 3-1-3-1. 삭제
												deleteUserInfoByMail(findmail);
												break;
											case 2: // 3-1-3-2. 종료
												System.out.println("종료합니다 ");
												break;
										}
										break;
									}
								} catch (Exception e) {
									System.out.println("다시 입력하세요.");
									continue;
								}

							case 4: // 3-1-4. 종료
								System.out.println("종료합니다");
								break;
							}
							break;

						case 2: // 3-2. 전체 조회
							System.out.println("모든 회원 정보를 출력");
							showAllUserInfo();
							break;
						case 3: // 3-3. 회원정보 관리 기능 종료
							System.out.println("회원정보 관리 기능을 종료합니다");
							break OUTER;
						}
						break; // 회원정보 관리-end
			}// 메인 메뉴 선택-end
		} // 메인 메뉴 반복-end
		process(); // 메인 메뉴 다시 호출 
	}

	public void endMenu(int num) { //메인메뉴 종료
		try {
			if (num == 4) {
				System.out.println("관리자접속을 종료합니다");
				Main.ui.start();
			}else if(!(num >= 1 && num <= 4)) {
				System.out.println("숫자를 다시 입력해주세요.");
				process();
			}
		}catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			process();
		}
		
	}
	
	public void showNotice() { // 공지사항 출력
		int cnt = 0;
		if(!(Bitgram.userinfo.get("scott").mytimeline.getPosts().isEmpty())) {
			for(Map.Entry<Integer, Post> e : Bitgram.userinfo.get("scott").mytimeline.getPosts().entrySet()) {
				if(cnt == 3) return;
				e.getValue().printNotice();
				cnt++;
			}
		}
	}
	
	public void addNotice() { // 공지사항 등록
		Bitgram.userinfo.get("scott").mytimeline.writePost("scott");
		System.out.println("공지사항이 정상적으로 등록되었습니다");
		Bitgram.userinfo.get("scott").visitMyTimeLine();
	}

	public void changeNotice(int contentNum) { // 공지사항 수정
		Bitgram.userinfo.get("scott").mytimeline.changePost(contentNum);
		System.out.println("공지사항이 정상적으로 수정되었습니다");
		Bitgram.userinfo.get("scott").visitMyTimeLine();
	}

	public void deleteNotice(int contentNum) { // 공지사항 삭제
		if (Bitgram.userinfo.get("scott").mytimeline.getPosts().size() <= 0) {
			System.out.println("삭제할 공지사항이 존재하지 않습니다.");
			return;
		}
		Bitgram.userinfo.get("scott").mytimeline.deletePost(contentNum, "scott");
	}
	
	// 타임라인 기능
	public void visitAllTimeLine() { // 전체 타임라인 열람
		for(Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			System.out.println("===================================");
			System.out.println(m.getValue().getId() + " 님의 타임라인");
			System.out.println("===================================");
			m.getValue().visitMyTimeLine();
		}
	}

	
	// 회원정보관리
    
	public void showUserInfo(Map.Entry<String, User> m) { //회원 정보 보기
		
		System.out.println("-----------------------------------");
		System.out.println("[Id] : " + m.getValue().getId());
		System.out.println("[Nickname] : " + m.getValue().getNickname());
		System.out.println("[E-mail] : " + m.getValue().getEmail());
		System.out.println();
	}
	
    public void findUserInfoById(String id) { // 특정 회원정보 id로 검색(*클래스다이어그램 추가)
		check = false;
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (id.equals(m.getValue().getId())) {
				showUserInfo(m);
				check = true;
				break;
			}else {
				System.out.println("등록된 id가 없습니다.");
			}
		}
	}

    public void findUserInfoByNick(String nick) { // 특정 회원정보 nick으로 검색(*클래스다이어그램 추가)
		check = false;
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (nick.equals(m.getValue().getNickname())) {
				showUserInfo(m);
				check = true;
				break;
			}else {
				System.out.println("등록된 nickname이 없습니다.");
			}
		}
	}

    public void findUserInfoByMail(String mail) { // 특정 회원정보 mail로 검색(*클래스다이어그램 추가)
		check = false;
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (mail.equals(m.getValue().getEmail())) {
				showUserInfo(m);
				check = true;
				break;
			}else {
				System.out.println("등록된 mail이 없습니다.");
			}
		}
	}
	public void showAllUserInfo() { // 회원정보 전체조회
		Bitgram.userinfo.get(Main.id).showAllUser();
	}
	
	public void deleteUserInfoById(String id) { // **수정본** id 값을 이용해 특정 회원정보 삭제 // 임시가능
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (id.equals(m.getValue().getId())) {
				Bitgram.userinfo.remove(m.getKey());
				System.out.println("정상적으로 삭제되었습니다.");
				break;
			}else {
				System.out.println("등록된 id가 없습니다.");
			}
		}
		Bitgram.putToDB();
	}

	public void deleteUserInfoByNick(String nick) { // **수정본** nick 값을 이용해 특정 회원정보 삭제 // 임시가능
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (nick.equals(m.getValue().getNickname())) {
				Bitgram.userinfo.remove(m.getKey());
				System.out.println("정상적으로 삭제되었습니다.");
				break;
			}else {
				System.out.println("등록된 nickname이 없습니다.");
			}
		}
		Bitgram.putToDB();
	}

	public void deleteUserInfoByMail(String mail) { // **수정본** mail값을 이용해 특정 회원정보 삭제 // 임시가능
		for (Map.Entry<String, User> m : Bitgram.userinfo.entrySet()) {
			if (mail.equals(m.getValue().getEmail())) {
				Bitgram.userinfo.remove(m.getKey());
				System.out.println("정상적으로 삭제되었습니다.");
				break;
			}else {
				System.out.println("등록된 nickname이 없습니다.");
			}
		}
		Bitgram.putToDB();
	}
} // end - class
