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
	JTextArea ta;//���â(���߶���)
	JTextField txtinput;//�Է�â
	DataInputStream in;
	DataOutputStream out;

	Ex05_TCP_Multi_Chatt_Client(){
		//UI ����
		this.setTitle("Multiä��");
		ta = new JTextArea();
		txtinput = new JTextField();
		JScrollPane sp =  new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setAutoscrolls(true);
		ta.setBackground(Color.WHITE);
		ta.setLineWrap(true);//�ؽ�Ʈ �ڵ� �ٹٲ�
		ta.setEditable(false);//���� �ȵǿ�
		
		txtinput.setText("�̸� �Է�");
		txtinput.requestFocus();
		txtinput.selectAll();
		
		this.add(sp,"Center");
		this.add(txtinput, "South");
		this.setSize(400, 500);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TextField �̺�Ʈ ó�� (����)
		txtinput.addActionListener(this);
		
		//���� �����ϱ�
		try {
			 Socket socket = new Socket("192.168.0.24", 9999);
			 in = new DataInputStream(socket.getInputStream());
			 out = new DataOutputStream(socket.getOutputStream());
			 //������ ����
			 ta.append("������ ���ӵǾ����ϴ�\n\r");
			 
			 //Thread ����
			 Thread client = new Thread(this);
			 client.start();
			 ////////////
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TextField �Է��ϰ� Enter ó���ϸ�
		//txtinput.addAction...(this)
		if(e.getSource().equals(txtinput)) {
			String msg = txtinput.getText();
			try {
				out.writeUTF(msg); //������ ���
				//System.out.println("�Է°� : "+msg);
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
			System.out.println("������ ������ ���� ����");
			return;
		}
		
	}
	
	public static void main(String[] args) {
		Ex05_TCP_Multi_Chatt_Client client = new Ex05_TCP_Multi_Chatt_Client();
	}
}
