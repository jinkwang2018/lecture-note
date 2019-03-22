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
		System.out.println("서버와 연결 되었습니다");
		
		//서버에서 보낸 메시지 받기
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		String servermsg = dis.readUTF();
		System.out.println("서버에서 보낸 메시지: " + servermsg);
		
		dis.close();
		in.close();
		socket.close();
	}
}
