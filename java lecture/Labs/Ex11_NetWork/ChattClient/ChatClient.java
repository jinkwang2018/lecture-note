package ChattClient;
import javax.swing.*;

public class ChatClient
{
  public static String getLogonID(){
    String logonID = "";
    try{
      while(logonID.equals("")){
        logonID = JOptionPane.showInputDialog("�α׿� ID�� �Է��ϼ���.");
      }
    }catch(NullPointerException e){
      System.exit(0);
    }
    return logonID;
  }

  public static void main(String args[]){
    String id = getLogonID();
    try{
      if (args.length == 0){
        ClientThread thread = new ClientThread();
        thread.start();
        thread.requestLogon(id);
      } else if (args.length == 1){
        ClientThread thread = new ClientThread(args[0]);
        thread.start();
        thread.requestLogon(id);
      } 
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
