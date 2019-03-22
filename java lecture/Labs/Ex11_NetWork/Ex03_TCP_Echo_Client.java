import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex03_TCP_Echo_Client {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("192.168.0.39", 9999);
		System.out.println("������ ���� �Ǿ����ϴ�");
		
		//read
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		//write
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("������ ���۵� ���� �Է�: ");
			String msg = sc.nextLine();
			
			//���� ����
			dos.writeUTF(msg);
			dos.flush();
			
			if(msg.equals("exit")) break;
			
			//�����κ���
			String servermsg = dis.readUTF();
			System.out.println("Echo �޽���: " + servermsg);
		}
		System.out.println("Ŭ���̾�Ʈ ����");
		dis.close();
		dos.close();
		socket.close();
	}
}
