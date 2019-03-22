import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//client

//server IP: 192.168.0.24
//port: 9999
public class Ex02_TCP_Client {
	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("192.168.0.36", 9999);
		System.out.println("������ ���� �Ǿ����ϴ�");
		
		//�������� ���� �޽��� �ޱ�
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		String servermsg = dis.readUTF();
		System.out.println("�������� ���� �޽���: " + servermsg);
		
		dis.close();
		in.close();
		socket.close();
	}
}
