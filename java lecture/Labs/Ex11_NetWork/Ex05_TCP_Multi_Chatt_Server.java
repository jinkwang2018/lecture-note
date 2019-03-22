import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

//���� ä��
//���� 1��
//�������� Ŭ���̾�Ʈ ����
//Ŭ���̾�Ʈ 1��( socket )
public class Ex05_TCP_Multi_Chatt_Server {
	
	ServerSocket serversocket = null;
	Socket socket = null;
	//KEY POINT
	HashMap<String,DataOutputStream> ClientMap;
	
	Ex05_TCP_Multi_Chatt_Server(){
		//�� Ŭ���̾�Ʈ (socket ������ ��°�ü�� ����)
		ClientMap = new HashMap<>();
	}
	//1. ���� �ʱ�ȭ �۾�
	public void init() {
		try {
			serversocket = new ServerSocket(9999);
			System.out.println("[�������� ... ������ ...]");
			while(true) {
			socket = serversocket.accept();
			System.out.println("[" + socket.getInetAddress() + "/" 
			                  + socket.getPort() + "]");
			//�ڵ��۾�
			//Ŭ���̾�Ʈ ���ӽ� ���� ....
				Thread client = new MultiServerRev(socket);
				client.start();
			//
			}	
			
			
		}catch (Exception e) {
			System.out.println("Init() : " + e.getMessage());
		}
	}
	
	//2. ���ӵ� ��� Ŭ���̾�Ʈ���� (socket) �޽����� �����ϴ� �Լ�
	//Map(key ,value)
	//key => �����ID (������ ��) ex) kglim , hong , kim , lee ..
	//ClientMap<"hong" ������  socket��ü���� �� DataOutPutStream��ü ����>)
	//ClientMap<"kim"  ������  socket��ü���� �� DataOutPutStream��ü ����>)
	void sendAllMsg(String msg) {
		Iterator<String> ClientKeySet = ClientMap.keySet().iterator();
		while(ClientKeySet.hasNext()) {
			try {
				DataOutputStream clientout = ClientMap.get(ClientKeySet.next());
				//������ ������ client ���� �޽��� ���
				clientout.writeUTF(msg);
			}catch(Exception e) {
				System.out.println("Send AllMsg :" +  e.getMessage());
			}
		}
	}
	
	//3. ���ӵ� ���� ����Ʈ ��� �����ϱ�
	String showUserList(String name) {
		//���ڿ� ���� (String name ="��" ;  name+="��" ; name+="��"
		//��ü �ؼ� : StringBuilder
		StringBuilder output = new StringBuilder("<<������ ���>>\n\r");
		Iterator<String> users = ClientMap.keySet().iterator();
		while(users.hasNext()) {
			try {
				String key = users.next(); //kim , park ,,,,,(������ ID)
				if(key.equals(name)) { //����� ��û�� ID
					key+="(*)";
				}
				output.append(key+"\n\r");
				
			}catch(Exception e) {
				System.out.println("showUserList ���� : " + e.getMessage());
			}
		}
		output.append("<<" + ClientMap.size() + ">>" + "�� ������ \n\r");
		return output.toString();
	}
	
	//4. ���Ӹ� ���
	void SendToMsg(String fromname, String toname , String toMsg) {
		try {
			 ClientMap.get(toname).writeUTF("�ӼӸ� from (" + fromname +")=>"+ toMsg);
			 ClientMap.get(fromname).writeUTF("�ӼӸ� to (" + toname +")=>"+ toMsg);
		}catch (Exception e) {
			System.out.println("SendToMsg ���� : " + e.getMessage());
		}
	}
	
	//Thread ��� (������ , �ޱ�)
	//inner class ����
	class MultiServerRev extends Thread{
		Socket socket = null;
		DataInputStream in;
		DataOutputStream out;
		
		public MultiServerRev(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
				out = new DataOutputStream(this.socket.getOutputStream());
			}catch(Exception e) {
				System.out.println("MultiServerRev ���� :" + e.getMessage());
			}
		}
		
		@Override
		public void run() {
			//�⺻ Ŭ���̾�Ʈ : in.readUTF() , out.WriteUTF()
			String name=""; //Ŭ���̾�Ʈ �̸� ����(key)
			try {
					//����� socket�� ���ؼ� Client �޽��� ����
					out.writeUTF("�̸��� �Է��ϼ���");
					name = in.readUTF();
					out.writeUTF("���� ä�ù濡 �����ϼ̽��ϴ�");
				
					//������ ���ӵ� ��� ����ڿ�(socket) �Էµ� ���� ����
					sendAllMsg(name +"�� ����^^");
					
					//KEY POINT
					ClientMap.put(name, out); //Map(�̸�, ���� socket ��°�ü)
					System.out.println("���� ����͸� : ���� �����ڴ� �� " + ClientMap.size() +"��");
					
					//�߰����(��ȭ)
					while(in != null) {
						String msg = in.readUTF();
						
						//ä���忡 �����ϰ� �ִ� �����ڿ��� ����
						if(msg.startsWith("/")) {
							if(msg.trim().equals("/������")) {
								out.writeUTF(showUserList(name)); //������ ��� ���
							}else if(msg.startsWith("/�ӼӸ�")) {
								String[] msgArr = msg.split(" ",3); // /�ӼӸ� ȫ�浿 �氡�氡
								if(msgArr == null || msgArr.length < 3) {
									out.writeUTF("HELP:����\n\r /�ӼӸ� [�����̸�] [�޽���]");
								}else {
									String toName = msgArr[1];
									String toMsg  = msgArr[2];
									if(ClientMap.containsKey(toName)) {
										//�޽��� ������
										//Ư�� ��뿡�� �޽��� ������
										SendToMsg(name, toName, toMsg);
									}else {
										out.writeUTF("�Է��� ����ڰ� �����ϴ�");
									}
								}
							}else {
								out.writeUTF("�߸��� ��ɾ� �Դϴ�");
							}
						}else {
							//��ü ����ڿ��� write
							sendAllMsg("[" + name + "]" + msg);
						}
					}//while end
					
			}catch (Exception e) {
				System.out.println("Thread run ���� :" + e.getMessage());
			}finally {
				//Client ���� (����)
				ClientMap.remove(name);
				sendAllMsg(name + "�� �����Ͽ����ϴ�");
				System.out.println("���� ����͸� : ���� �����ڴ� " + ClientMap.size() +"��" );
			}
		}
	}
	
	public static void main(String[] args) {
		Ex05_TCP_Multi_Chatt_Server server = new Ex05_TCP_Multi_Chatt_Server();
		server.init();
	}
}
