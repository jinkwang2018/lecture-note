import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class LoginForm2 extends Frame {
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm2(String title) {
		super(title);
		lbl_id = new Label("ID", Label.RIGHT);
		lbl_pwd = new Label("PWD", Label.RIGHT);
		
		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('*');
		btn_ok = new Button("login");
		
		this.setLayout(new FlowLayout()); //���� (add)
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		
		this.add(lbl_pwd);
		this.add(txt_pwd);
		
		this.add(btn_ok);
		
		//Inner Class�� (LoginForm2 outer �ڿ��� ���)
		class Btn_Handler2 implements ActionListener {
			//��ư�� Ŭ���ϸ� actionPerformed ȣ��
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText().trim();
				String pwd = txt_pwd.getText();
				System.out.println("ActionEvent �߻��� ��ü�� �ּ�: " + e.getSource());
				if(id.equals("hong")) {
					System.out.println("ȯ���մϴ�. " + id + " / " + pwd);
				}else {
					System.out.println("�����ִ� ���� �����ϱ�? " + id);
				}
			}
		}
		btn_ok.addActionListener(new Btn_Handler2());
		
		//WindowListener �������̽� ���� (�����ϴ� Ŭ������ ���� �͸�Ÿ��)
		//����: ��� ������ ������ ����� �Ѵ�.
		//     �ᱹ �������̽��� �����ϱ� ������ ������� �ʴ� �Լ��� �����ȴ�.
		/*-> �غ��ϱ� ����
			this.addWindowListener(new WindowAdapter() {
				���ϴ� �͸� override
			});
		 */
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				//â�ݱ�...
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

public class Ex13_Button_Event_InnerClass {
	public static void main(String[] args) {
		LoginForm2 login = new LoginForm2("�α���");
	}
}
