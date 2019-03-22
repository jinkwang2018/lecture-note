
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

/*
��    ¥ : 2018-02-23
�ۼ��ڸ� : �ڹν�, �跡��
��    ��: �Ϲ����� UI ���� 
*/
public class User implements Serializable {
	private String id;
	private String pwd;
	private String nickname;
	private String email;
	TimeLine mytimeline; //���� Ÿ�Ӷ���
	HashMap<String, User> friendslist; //ģ�����
	
	public User() {
		this.mytimeline = new TimeLine();
		friendslist = new HashMap<>();
	} //mytimeline, firendslist ����� ���� �����ڿ��� �ʱ�ȭ ��� (default ������)

	public User(String id, String pwd, String nickname, String email) {
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
		this.mytimeline = new TimeLine();
		friendslist = new HashMap<>();
	} //�Ű����� �ִ� ������


	public void showFriendsList() { //ģ�� ��Ϻ���
		
		if(!(friendslist.isEmpty())){
			User u = null;
			for (Map.Entry<String, User> e : friendslist.entrySet()) {
	
				u = e.getValue();
				
				System.out.println("---------------------");
				System.out.println("[Id] : " + u.getId());
				System.out.println("[Nickname] : " + u.getNickname());
				System.out.println("[E-mail] : " + u.getEmail());
				System.out.println();
			} //ģ����Ͽ� ģ���� ������ �� ������� ������ ������
		} else { 
			System.out.println("��ϵ� ģ���� �����ϴ�.");
			System.out.println();
		} //ģ����Ͽ� ģ���� ���� ��� �� ���� ����
	
	} //end - showFriendsList
	
	public void addFriend(String id) { //ģ���߰�
		
		if(Bitgram.userinfo.containsKey(id)) { //��ϵ� ������ �ִ��� ���� Ȯ��
			
			if(friendslist.containsKey(id)) { // �� ģ�� ����Ʈ�� �߰��Ǿ� �ִ� �������� Ȯ��
				System.out.println("�̹� �߰��� ģ���Դϴ�.");
			} else {
				friendslist.put(id, Bitgram.userinfo.get(id));
				System.out.println("ģ�� �߰� �Ǿ����ϴ�!");	
			}
		} else {
			System.out.println("�������� �ʴ� ID�Դϴ�.");
		}
		Bitgram.putToDB(); //�ش� ���� ���Ͽ� ���� 

	} //ends - addFriend

	public void deleteFriend(String id) { //ģ������
		
		if(friendslist.containsKey(id)) {
			friendslist.remove(id);
			System.out.println(id +"���� ģ����Ͽ��� �����Ͽ����ϴ�.");
		} else {
			System.out.println("ģ����Ͽ� ���� ���̵��Դϴ�.");
		}
		Bitgram.putToDB(); //�ش� ���� ���Ͽ� ���� 
		
	} //end - deleteFriend
	
	public void showAllUser() { //���Ե� ��� ���� ����
		
		User u= null;
		
		for(Map.Entry<String, User> e : Bitgram.userinfo.entrySet()) {
			
			u = e.getValue();
			
			System.out.println("---------------------");
			System.out.println("[Id] : " + u.getId());
			System.out.println("[Nickname] : " + u.getNickname());
			System.out.println("[E-mail] : " + u.getEmail());
			System.out.println();
		} //���Ե� ������ ������ �� ������ ����
			
	} //end - showAllUser
	
	public void visitTimeLine(String id) { //ģ�� Ÿ�Ӷ��� �湮
		
		if(friendslist.containsKey(id)) {
			friendslist.get(id).getMytimeline().showPosts();;
		}else {
			System.out.println("��ϵ� ģ���� �ƴմϴ�");
		} 
		
	} //end - visitTimeLine
	
	public void visitMyTimeLine() { //���� Ÿ�Ӷ��� �湮
		
		if(!(mytimeline.getPosts().isEmpty())) {
			for(Map.Entry<Integer, Post> e :  mytimeline.getPosts().entrySet()) {
				e.getValue().printPost();
			}
		} else {
			System.out.println("�ۼ��� �Խù��� �����ϴ�.");
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
	public void printall() { //ȸ�� ���� ���
		System.out.printf("%s//%s//%s//%s\n", this.id, this.pwd, this.nickname, this.email);
	}
/////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return this.getId() + "/" + mytimeline + "/" + friendslist;
	}
///////////////////////////////process for User//////////////////////
	/*	1. ���� Ÿ�Ӷ��� ����
	 * 		1) �۾���   O (���� O)
	 * 		2) �ۼ���   X
	 * 		3) �ۻ���   X
	 * 		4) ���� �ܰ��
	 *  2. ģ�� ��� ����
	 *  	1) ģ�� Ÿ�Ӷ��� �湮  O
	 *  	2) ģ�� ���� O
	 *  	3) ���� �ܰ��
	 *  
	 *  3. ��� ���� ���� ���� & ģ���߰�
	 *  	1) ģ�� �߰� O
	 *  	2) ���� �ܰ��
	 *  
	 *  4. �α׾ƿ�
	 *  
	 * */
	public void process() { //������� UI
		Scanner sc = new Scanner(System.in);
		boolean userprocessstop = true;	 // �޴����� �α׾ƿ�(4)�� �Է��ϸ� false�� �ٲ�鼭 while�� Ż��
		
		while(userprocessstop){	
		    System.out.println();
			System.out.println("===================================");
			System.out.println("<<���Ͻô� �޴� ��ȣ�� �Է��� �ּ���>>");
			System.out.println("1. ���� Ÿ�Ӷ��� ����");
			System.out.println("2. ģ�� ��� ����");
			System.out.println("3. ��� ���� ���� ���� & ģ���߰�");
			System.out.println("4. �α׾ƿ�");
			System.out.print("�Է�> ");
			
			try {
				switch(Integer.parseInt(sc.nextLine())) {
				
					/////////////// 1. ���� Ÿ�Ӷ��� ���� ///////////////
				case 1:
					 System.out.println();
					 System.out.println("------------My-TimeLine------------");
					 visitMyTimeLine();
					 System.out.println("-----------------------------------");
						System.out.println("���Ͻô� �۾��� ������ �ּ���");
						System.out.println("[1]�۾���\t[2]�ۼ���\t[3]�ۻ���\t[4]�ڷΰ���");
						System.out.print("�Է�> ");
						
						switch(Integer.parseInt(sc.nextLine())) {
						case 1 : mytimeline.writePost(this.nickname); //writer�� �г���
							break;
						case 2 : 
							System.out.print("�����ϰ��� �ϴ� �Խù��� ��ȣ�� �Է��ϼ��� > ");
							mytimeline.changePost(Integer.parseInt(sc.nextLine()));
							break;	
						case 3 :
							System.out.print("�����ϰ��� �ϴ� �Խù��� ��ȣ�� �Է��ϼ��� > ");
							mytimeline.deletePost(Integer.parseInt(sc.nextLine()),Main.id);
							break;
						case 4 :
							continue;
						default :
							System.out.println("�ٽ� �Է����ּ���");
							break;
						}
					break;
					
					/////////////// 2. ģ�� ��� ���� ///////////////
				case 2:
					System.out.println();
					System.out.println("----------My-Friends-List----------");
					showFriendsList();
					System.out.println("-----------------------------------");
					System.out.println("���Ͻô� �۾��� ������ �ּ���");
					System.out.println("[1] ģ�� Ÿ�Ӷ��ι湮     [2] ģ������     [3] �ڷΰ���");
					System.out.print("�Է�> ");
					switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						System.out.print("�湮�ϰ� ���� ģ���� ���̵� �Է��ϼ��� > ");
						visitTimeLine(sc.nextLine());
						break;
					case 2:
						System.out.print("�����ϰ� ���� ģ���� ���̵� �Է��ϼ��� > ");
						deleteFriend(sc.nextLine());
						break;
					case 3:
						continue;
					default :
						System.out.println("�ٽ� �Է����ּ���");
						break;
					}
					break;
					 /////////////// 3. ��� ���� ���� ���� & ģ���߰�  ///////////////
				case 3:
					System.out.println();
					System.out.println("-----------All-User-List-----------");
					showAllUser();
					System.out.println("-----------------------------------");
					System.out.println("���Ͻô� �۾��� ������ �ּ���");
					System.out.println("[1] ģ�� �߰�\t[2] �ڷΰ���");
					System.out.print("�Է�> ");
					
					switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						System.out.print("ģ���߰� �ϰ� ���� ���̵� �Է��ϼ��� : ");
						addFriend(sc.nextLine());
						break;
					case 2:
						continue;
					default :
						System.out.println("�ٽ� �Է����ּ���");
						break;
					}
					break;
					 /////////////// 4. �α׾ƿ�  ///////////////
				case 4: 
					Bitgram.putToDB();
					System.out.println("���������� �α׾ƿ� �Ǿ����ϴ�");
					userprocessstop = false;
					break;
				default: 
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
					break;
				}
			} catch(Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
			}
		}
	} //end - process 

} //end - class