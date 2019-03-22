import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Inner Class 사용해서 구현
//Clientsend
//ClientReceive

public class Ex04_TCP_Chat_Client {
	public static void main(String[] args) {
		Ex04_TCP_Chat_Client client = new Ex04_TCP_Chat_Client();
	}
	
	Socket socket = null;
	public Ex04_TCP_Chat_Client() {
		try {
			socket = new Socket("192.168.0.39", 9999);
			System.out.println("서버와 연결 되었습니다");
			
			new ClientSend().start();
			new ClientReceive().start();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	class ClientSend extends Thread {
		@Override
		public void run() {
			BufferedReader br = null;
			PrintWriter pw = null;
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				pw = new PrintWriter(socket.getOutputStream(), true);
				
				while(true) {
					String data = br.readLine();
					if(data.equals("exit")) break;
					pw.println(data);
				}
				System.out.println("client send 작업 종료");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
		
	class ClientReceive extends Thread {
		@Override
		public void run() {		
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;
				while((data = br.readLine()) != null) {
					System.out.println("Server로부터 받은 메시지 [ " + data + " ]");
				}
				System.out.println("ClientReceive 종료");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					br.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}




	
