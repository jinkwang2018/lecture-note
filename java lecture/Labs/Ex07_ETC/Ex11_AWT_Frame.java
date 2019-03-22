import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//메모장, 계산기 만들 수 있도록 JAVA 지원하는 자원
//AWT, SWING

class MyFrame extends Frame {
	public MyFrame(String title) {
		super(title);
	}
}

//이벤트 구현(이벤트 핸들러 클래스)
class BtnClick_Handler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		//안에 코드는 개발자 마음대로
		System.out.println("개발자 원하는 행위");
	}
}


public class Ex11_AWT_Frame {
	public static void main(String[] args) {
		MyFrame my = new MyFrame("Login");
		my.setSize(350, 300);
		my.setVisible(true);
		my.setLayout(new FlowLayout());
		
		Button btn = new Button("나 버튼");
		Button btn2 = new Button("two button");
		Button btn3 = new Button("Three button");
		
		//버튼을 클릭하면 행위
		//메서드를 찾는다: actionPerformed (button 클릭하면 호출되는 함수) API
		//ActionListener 인터페이스가 actionPerformed 가지고 있다
		//이벤트 핸들러를 만들어야지: ActionListener를 구현하는 클래스
		//actionPerformed 함수에 대한 구현 >> override
		//Button에 붙이기(리스너를 통해서 등록하기)
		
		//행위 btn 클릭하면 사용.. 필요없잖아 (1회성) >> 특정 btn에 사용
		btn.addActionListener(new ActionListener() { //익명(일회성) 클래스: 재사용이 안됨
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("인터페이스 익명타입으로 직접 구현");
			}
		});
		
		
		
		BtnClick_Handler handler = new BtnClick_Handler();
		btn2.addActionListener(handler);
		
		//클래스 이벤트 핸들러 만들면 (공통기능) >> 재사용 가능
		btn3.addActionListener(handler);
		
		my.add(btn);
		my.add(btn2);
		my.add(btn3);
	}
}
