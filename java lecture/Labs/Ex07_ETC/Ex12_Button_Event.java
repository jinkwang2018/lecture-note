import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Btn_Handler implements ActionListener {
	
	//button�� Ŭ���ϸ� id, pwd ������ �ͼ� ��ȿ�� ����
	private TextField txtid;
	private TextField txtpwd;
	public Btn_Handler(TextField txtid, TextField txtpwd) {
		this.txtid = txtid; //�ּҰ�(textfield)
		this.txtpwd = txtpwd;
	}
	
	//��ư�� Ŭ���ϸ� actionPerformed ȣ��
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent �߻��� ��ü�� �ּ�: " + e.getSource());
		if(txtid.getText().equals("hong")) {
			System.out.println("ȯ���մϴ�. " + txtid.getText() + " / " + txtpwd.getText());
		}else {
			System.out.println("�����ִ� ���� �����ϱ�? " + txtid.getText());
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
		
		this.setLayout(new FlowLayout()); //���� (add)
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
		LoginForm login = new LoginForm("�α���");
	}
}
