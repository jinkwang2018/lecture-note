import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class LoginForm3 extends Frame {
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm3(String title) {
		super(title);
		lbl_id = new Label("ID", Label.RIGHT);
		lbl_pwd = new Label("PWD", Label.RIGHT);
		
		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('*');
		btn_ok = new Button("login");
		
		this.setLayout(new FlowLayout()); //순서 (add)
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		
		this.add(lbl_pwd);
		this.add(txt_pwd);
		
		this.add(btn_ok);
		
		//최종
		btn_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText().trim();
				String pwd = txt_pwd.getText();
				System.out.println("ActionEvent 발생지 객체의 주소: " + e.getSource());
				if(id.equals("hong")) {
					System.out.println("환영합니다. " + id + " / " + pwd);
				}else {
					System.out.println("졸고있는 나는 누구일까? " + id);
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
		});
		
	}
}

public class Ex14_Button_Event_Final {
	public static void main(String[] args) {
		LoginForm3 login = new LoginForm3("로그인");
	}
}
