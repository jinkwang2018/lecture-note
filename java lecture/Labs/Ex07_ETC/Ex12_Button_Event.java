import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Btn_Handler implements ActionListener {
	
	//button을 클릭하면 id, pwd 가지고 와서 유효성 검증
	private TextField txtid;
	private TextField txtpwd;
	public Btn_Handler(TextField txtid, TextField txtpwd) {
		this.txtid = txtid; //주소값(textfield)
		this.txtpwd = txtpwd;
	}
	
	//버튼을 클릭하면 actionPerformed 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent 발생지 객체의 주소: " + e.getSource());
		if(txtid.getText().equals("hong")) {
			System.out.println("환영합니다. " + txtid.getText() + " / " + txtpwd.getText());
		}else {
			System.out.println("졸고있는 나는 누구일까? " + txtid.getText());
		}
	}
}

class LoginForm extends Frame {
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm(String title) {
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
		btn_ok.addActionListener(new Btn_Handler(txt_id, txt_pwd));
	}
}

public class Ex12_Button_Event {
	public static void main(String[] args) {
		LoginForm login = new LoginForm("로그인");
	}
}
