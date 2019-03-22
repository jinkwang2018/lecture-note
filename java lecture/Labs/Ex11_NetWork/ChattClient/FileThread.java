package ChattClient;
import java.io.*;
import java.net.*;
import java.util.*;

public class FileThread extends Thread
{
  private ReciveFile recv;
  private Socket sock;
  private DataInputStream in;
  private String header;
  private byte[] data;

  private static final String SEPARATOR = "|";

  public FileThread(ReciveFile recv, Socket sock){
    try{
      this.recv = recv;
      this.sock = sock;
      in = new DataInputStream(sock.getInputStream());
    }catch(IOException e){
      System.out.println(e);
    }
  }

  public void run(){
    try{
      header = in.readUTF();

      StringTokenizer st = new StringTokenizer(header, SEPARATOR);
      String filename = st.nextToken();
      int fileLength = Integer.parseInt(st.nextToken());
      data = new byte[fileLength];

      recv.lbl.setText(filename + "(" + fileLength + "byte) ������ �����մϴ�.");

      BufferedInputStream bin = new BufferedInputStream(in, 2048);
      DataOutputStream dout = new DataOutputStream(sock.getOutputStream());
      readFile(bin, dout, data, fileLength);
      bin.close();
      dout.close();

      File dir = new File("��������\\");
      if(!dir.exists()){
        dir.mkdir();
      }

      File file = new File(dir, filename);
      if(file.exists()){
        file = new File(dir, "re_" + filename);
        recv.txt.append(filename + " ������ �̹� �����մϴ�.\n");
        recv.txt.append(file.getName() + " ���� ���ϸ��� �����մϴ�.\n");
      } else {
        if(!file.createNewFile()){
          recv.txt.append(filename + "���� ���� ����.\n");
          recv.txt.append(filename + "���� ������ ��ҵǾ����ϴ�.\n");
          return;
        }
      }

      FileOutputStream fout = new FileOutputStream(file);
      BufferedOutputStream bout = new BufferedOutputStream(fout, fileLength);
      bout.write(data, 0, fileLength);
      bout.flush();
      bout.close();

      recv.txt.append(filename + "���� ������ �����߽��ϴ�.\n");
      recv.txt.append(filename + "������ġ : " + dir.getAbsolutePath() + "\\" + file.getName() + "\n");
      sock.close();
      recv.btn.setVisible(true);
    }catch(Exception e){
      System.out.println(e);
    }finally{
      try{
        if(sock != null) sock.close();
      }catch(IOException e){
      }finally{
        sock = null;
      }
      try{
        if(in != null) in.close();
      }catch(IOException e){
      }finally{
        in = null;
      }
    }
  }

  private void readFile(BufferedInputStream bin, DataOutputStream dout, byte[] data, int fileLength)
    throws IOException{
    int size = 2048;
    int count = fileLength/size;
    int rest = fileLength%size;
    int flag = 1;

    if(count == 0) flag = 0;

    for(int i=0; i<=count; i++){
      if(i == count && flag == 0){
        bin.read(data, 0, rest);
        recv.lbl.setText("���ϼ��ſϷ�......(" + fileLength + "/" + fileLength + " Byte)");
        return;
      } else if(i == count){
        bin.read(data, i*size, rest);
        recv.lbl.setText("���ϼ��ſϷ�......(" + fileLength + "/" + fileLength + " Byte)");
        return;
      } else {
        bin.read(data, i*size, size);
        recv.lbl.setText("���ϼ�����......(" + ((i+1)*size) + "/" + fileLength + " Byte)");
        dout.writeUTF("flag");
      }
    }
  }
}
