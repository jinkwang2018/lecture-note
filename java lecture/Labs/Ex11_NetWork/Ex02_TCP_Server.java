import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TCP ����
//server(process) - client(process)

//����: 192.168.0.24
//��Ʈ: port: 9999

public class Ex02_TCP_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serversocket = new ServerSocket(9999);
		System.out.println("���� �����...");
		Socket socket = serversocket.accept(); //Ŭ���̾�Ʈ�� ������ �ϸ�
		System.out.println("����Ϸ�");
		
		//������ �Ǹ�
		//����: Ŭ���̾�Ʈ (read, write)
		//socket�� socket
		//socket(input, output Stream)
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out); //8���� �⺻ Ÿ�� + @
		dos.writeUTF("���ڵ����� Byte ��� ����: �ƴ�, �� ���ε���");
		
		System.out.println("���� ����");
		
		dos.close();
		out.close();
		socket.close();
		serversocket.close();
	}
}
