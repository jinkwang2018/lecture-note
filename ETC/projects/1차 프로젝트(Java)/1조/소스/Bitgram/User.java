
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

/*
날    짜 : 2018-02-23
작성자명 : 박민식, 김래영
기    능: 일반유저 UI 구현 
*/
public class User implements Serializable {
	private String id;
	private String pwd;
	private String nickname;
	private String email;
	TimeLine mytimeline; //나의 타임라인
	HashMap<String, User> friendslist; //친구목록
	
	public User() {
		this.mytimeline = new TimeLine();
		friendslist = new HashMap<>();
	} //mytimeline, firendslist 사용을 위해 생성자에서 초기화 사용 (default 생성자)

	public User(String id, String pwd, String nickname, String email) {
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
		this.mytimeline = new TimeLine();
		friendslist = new HashMap<>();
	} //매개변수 있는 생성자


	public void showFriendsList() { //친구 목록보기
		
		if(!(friendslist.isEmpty())){
			User u = null;
			for (Map.Entry<String, User> e : friendslist.entrySet()) {
	
				u = e.getValue();
				
				System.out.println("---------------------");
				System.out.println("[Id] : " + u.getId());
				System.out.println("[Nickname] : " + u.getNickname());
				System.out.println("[E-mail] : " + u.getEmail());
				System.out.println();
			} //친구목록에 친구가 있으면 위 순서대로 정보를 보여줌
		} else { 
			System.out.println("등록된 친구가 없습니다.");
			System.out.println();
		} //친구목록에 친구가 없을 경우 위 내용 노출
	
	} //end - showFriendsList
	
	public void addFriend(String id) { //친구추가
		
		if(Bitgram.userinfo.containsKey(id)) { //등록된 유저에 있는지 유무 확인
			
			if(friendslist.containsKey(id)) { // 내 친구 리스트에 추가되어 있는 유저인지 확인
				System.out.println("이미 추가된 친구입니다.");
			} else {
				friendslist.put(id, Bitgram.userinfo.get(id));
				System.out.println("친구 추가 되었습니다!");	
			}
		} else {
			System.out.println("존재하지 않는 ID입니다.");
		}
		Bitgram.putToDB(); //해당 내용 파일에 저장 

	} //ends - addFriend

	public void deleteFriend(String id) { //친구삭제
		
		if(friendslist.containsKey(id)) {
			friendslist.remove(id);
			System.out.println(id +"님을 친구목록에서 삭제하였습니다.");
		} else {
			System.out.println("친구목록에 없는 아이디입니다.");
		}
		Bitgram.putToDB(); //해당 내용 파일에 저장 
		
	} //end - deleteFriend
	
	public void showAllUser() { //가입된 모든 유저 보기
		
		User u= null;
		
		for(Map.Entry<String, User> e : Bitgram.userinfo.entrySet()) {
			
			u = e.getValue();
			
			System.out.println("---------------------");
			System.out.println("[Id] : " + u.getId());
			System.out.println("[Nickname] : " + u.getNickname());
			System.out.println("[E-mail] : " + u.getEmail());
			System.out.println();
		} //가입된 유저의 정보를 위 내용대로 노출
			
	} //end - showAllUser
	
	public void visitTimeLine(String id) { //친구 타임라인 방문
		
		if(friendslist.containsKey(id)) {
			friendslist.get(id).getMytimeline().showPosts();;
		}else {
			System.out.println("등록된 친구가 아닙니다");
		} 
		
	} //end - visitTimeLine
	
	public void visitMyTimeLine() { //나의 타임라인 방문
		
		if(!(mytimeline.getPosts().isEmpty())) {
			for(Map.Entry<Integer, Post> e :  mytimeline.getPosts().entrySet()) {
				e.getValue().printPost();
			}
		} else {
			System.out.println("작성된 게시물이 없습니다.");
		}
		
	} //end - visitMyTimeLine

////////////////////////////Getter & Setter ////////////////////////////
	public TimeLine getMytimeline() {
		return mytimeline;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/////////////////////////////////////////////////////////////////////
	public void printall() { //회원 정보 출력
		System.out.printf("%s//%s//%s//%s\n", this.id, this.pwd, this.nickname, this.email);
	}
/////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return this.getId() + "/" + mytimeline + "/" + friendslist;
	}
///////////////////////////////process for User//////////////////////
	/*	1. 나의 타임라인 보기
	 * 		1) 글쓰기   O (구현 O)
	 * 		2) 글수정   X
	 * 		3) 글삭제   X
	 * 		4) 이전 단계로
	 *  2. 친구 목록 보기
	 *  	1) 친구 타임라인 방문  O
	 *  	2) 친구 삭제 O
	 *  	3) 이전 단계로
	 *  
	 *  3. 모든 유저 정보 보기 & 친구추가
	 *  	1) 친구 추가 O
	 *  	2) 이전 단계로
	 *  
	 *  4. 로그아웃
	 *  
	 * */
	public void process() { //유저모드 UI
		Scanner sc = new Scanner(System.in);
		boolean userprocessstop = true;	 // 메뉴에서 로그아웃(4)를 입력하면 false로 바뀌면서 while문 탈출
		
		while(userprocessstop){	
		    System.out.println();
			System.out.println("===================================");
			System.out.println("<<원하시는 메뉴 번호를 입력해 주세요>>");
			System.out.println("1. 나의 타임라인 보기");
			System.out.println("2. 친구 목록 보기");
			System.out.println("3. 모든 유저 정보 보기 & 친구추가");
			System.out.println("4. 로그아웃");
			System.out.print("입력> ");
			
			try {
				switch(Integer.parseInt(sc.nextLine())) {
				
					/////////////// 1. 나의 타임라인 보기 ///////////////
				case 1:
					 System.out.println();
					 System.out.println("------------My-TimeLine------------");
					 visitMyTimeLine();
					 System.out.println("-----------------------------------");
						System.out.println("원하시는 작업을 선택해 주세요");
						System.out.println("[1]글쓰기\t[2]글수정\t[3]글삭제\t[4]뒤로가기");
						System.out.print("입력> ");
						
						switch(Integer.parseInt(sc.nextLine())) {
						case 1 : mytimeline.writePost(this.nickname); //writer는 닉네임
							break;
						case 2 : 
							System.out.print("수정하고자 하는 게시물의 번호를 입력하세요 > ");
							mytimeline.changePost(Integer.parseInt(sc.nextLine()));
							break;	
						case 3 :
							System.out.print("삭제하고자 하는 게시물의 번호를 입력하세요 > ");
							mytimeline.deletePost(Integer.parseInt(sc.nextLine()),Main.id);
							break;
						case 4 :
							continue;
						default :
							System.out.println("다시 입력해주세요");
							break;
						}
					break;
					
					/////////////// 2. 친구 목록 보기 ///////////////
				case 2:
					System.out.println();
					System.out.println("----------My-Friends-List----------");
					showFriendsList();
					System.out.println("-----------------------------------");
					System.out.println("원하시는 작업을 선택해 주세요");
					System.out.println("[1] 친구 타임라인방문     [2] 친구삭제     [3] 뒤로가기");
					System.out.print("입력> ");
					switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						System.out.print("방문하고 싶은 친구의 아이디를 입력하세요 > ");
						visitTimeLine(sc.nextLine());
						break;
					case 2:
						System.out.print("삭제하고 싶은 친구의 아이디를 입력하세요 > ");
						deleteFriend(sc.nextLine());
						break;
					case 3:
						continue;
					default :
						System.out.println("다시 입력해주세요");
						break;
					}
					break;
					 /////////////// 3. 모든 유저 정보 보기 & 친구추가  ///////////////
				case 3:
					System.out.println();
					System.out.println("-----------All-User-List-----------");
					showAllUser();
					System.out.println("-----------------------------------");
					System.out.println("원하시는 작업을 선택해 주세요");
					System.out.println("[1] 친구 추가\t[2] 뒤로가기");
					System.out.print("입력> ");
					
					switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						System.out.print("친구추가 하고 싶은 아이디를 입력하세요 : ");
						addFriend(sc.nextLine());
						break;
					case 2:
						continue;
					default :
						System.out.println("다시 입력해주세요");
						break;
					}
					break;
					 /////////////// 4. 로그아웃  ///////////////
				case 4: 
					Bitgram.putToDB();
					System.out.println("정상적으로 로그아웃 되었습니다");
					userprocessstop = false;
					break;
				default: 
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
					break;
				}
			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
			}
		}
	} //end - process 

} //end - class