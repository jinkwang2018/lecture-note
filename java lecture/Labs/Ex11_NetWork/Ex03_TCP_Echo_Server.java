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
		System.out.println("접속 대기중...");
		Socket socket = serversocket.accept(); //클라이언트가 접속을 하면
		System.out.println("연결완료");
		
		//Client write 데이터 서버가 받아서 다시 Client write
		//server >> read, write
		//client >> write, read
		
		//socket이 가지고 있는 input, output Stream 을 사용
		
		//read
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		//write
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		while(true) {
			//read
			//client write한 데이터가 있다면
			String clientmsg = dis.readUTF(); //client write하면 동작
			System.out.println("Client Msg :" + clientmsg);
			
			if(clientmsg.equals("exit")) break; //client "exit" 서버 종료
			
			//메아리 기능
			dos.writeUTF(clientmsg);
			dos.flush(); //close() 있어도 되는데... 바로 출력하기 위해 flush() 사용
		}
		System.out.println("클라이언트 종료 요청(exit) 서버종료");
		
		dis.close();
		dos.close();
		in.close();
		out.close();
		socket.close();
		serversocket.close();
	}
}
