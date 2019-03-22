package ChattServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
  public static final int cs_port = 9999;
  public static final int cs_maxclient = 50;

  public static void main(String args[]){
    try{
      ServerSocket ss_socket = new ServerSocket(cs_port);
      System.out.println("�������� ���� : Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
      while(true){
        Socket sock = null;
        ServerThread client = null;
        try{
          sock = ss_socket.accept();
          client = new ServerThread(sock);
          client.start();
        } catch(IOException e){
          System.out.println(e);
          try{
            if(sock != null) sock.close();
          }catch(IOException e1){
            System.out.println(e1);
          }finally{
            sock = null;
          }
        }
      }
    }catch(IOException e){}
  }
}
