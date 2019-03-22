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
		
		this.setLayout(new FlowLayout()); //순서 (add)
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		
		this.add(lbl_pwd);
		this.add(txt_pwd);
		
		this.add(btn_ok);
		
		//Inner Class로 (LoginForm2 outer 자원을 사용)
		class Btn_Handler2 implements ActionListener {
			//버튼을 클릭하면 actionPerformed 호출
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
		}
		btn_ok.addActionListener(new Btn_Handler2());
		
		//WindowListener 인터페이스 구현 (구현하는 클래스가 없는 익명타입)
		//단점: 모든 행위를 재정의 해줘야 한다.
		//     결국 인터페이스를 구현하기 때문에 사용하지 않는 함수도 구현된다.
		/*-> 극복하기 위해
			this.addWindowListener(new WindowAdapter() {
				원하는 것만 override
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
				//창닫기...
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
		LoginForm2 login = new LoginForm2("로그인");
	}
}
