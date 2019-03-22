import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex03_TCP_Echo_Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serversocket = new ServerSocket(9999);
		System.out.println("���� �����...");
		Socket socket = serversocket.accept(); //Ŭ���̾�Ʈ�� ������ �ϸ�
		System.out.println("����Ϸ�");
		
		//Client write ������ ������ �޾Ƽ� �ٽ� Client write
		//server >> read, write
		//client >> write, read
		
		//socket�� ������ �ִ� input, output Stream �� ���
		
		//read
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		//write
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		while(true) {
			//read
			//client write�� �����Ͱ� �ִٸ�
			String clientmsg = dis.readUTF(); //client write�ϸ� ����
			System.out.println("Client Msg :" + clientmsg);
			
			if(clientmsg.equals("exit")) break; //client "exit" ���� ����
			
			//�޾Ƹ� ���
			dos.writeUTF(clientmsg);
			dos.flush(); //close() �־ �Ǵµ�... �ٷ� ����ϱ� ���� flush() ���
		}
		System.out.println("Ŭ���̾�Ʈ ���� ��û(exit) ��������");
		
		dis.close();
		dos.close();
		in.close();
		out.close();
		socket.close();
		serversocket.close();
	}
}
