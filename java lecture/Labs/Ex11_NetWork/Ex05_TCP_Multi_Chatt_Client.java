import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ex05_TCP_Multi_Chatt_Client extends JFrame implements ActionListener , Runnable {
	JTextArea ta;//출력창(다중라인)
	JTextField txtinput;//입력창
	DataInputStream in;
	DataOutputStream out;

	Ex05_TCP_Multi_Chatt_Client(){
		//UI 구성
		this.setTitle("Multi채팅");
		ta = new JTextArea();
		txtinput = new JTextField();
		JScrollPane sp =  new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setAutoscrolls(true);
		ta.setBackground(Color.WHITE);
		ta.setLineWrap(true);//텍스트 자동 줄바꿈
		ta.setEditable(false);//편집 안되요
		
		txtinput.setText("이름 입력");
		txtinput.requestFocus();
		txtinput.selectAll();
		
		this.add(sp,"Center");
		this.add(txtinput, "South");
		this.setSize(400, 500);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TextField 이벤트 처리 (엔터)
		txtinput.addActionListener(this);
		
		//소켓 설정하기
		try {
			 Socket socket = new Socket("192.168.0.24", 9999);
			 in = new DataInputStream(socket.getInputStream());
			 out = new DataOutputStream(socket.getOutputStream());
			 //서버와 연결
			 ta.append("서버에 접속되었습니다\n\r");
			 
			 //Thread 구동
			 Thread client = new Thread(this);
			 client.start();
			 ////////////
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TextField 입력하고 Enter 처리하면
		//txtinput.addAction...(this)
		if(e.getSource().equals(txtinput)) {
			String msg = txtinput.getText();
			try {
				out.writeUTF(msg); //서버로 출력
				//System.out.println("입력값 : "+msg);
				//ta.setText(msg);
				txtinput.setText("");
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	@Override
	public void run() {
		try {
			String msg = in.readUTF();
			ta.append(msg + "\n\r");
			while(in != null) {
				msg = in.readUTF();
				ta.append(msg +"\n\r");
			}
		}catch (Exception e) {
			System.out.println("접속중 서버와 연결 종료");
			return;
		}
		
	}
	
	public static void main(String[] args) {
		Ex05_TCP_Multi_Chatt_Client client = new Ex05_TCP_Multi_Chatt_Client();
	}
}
