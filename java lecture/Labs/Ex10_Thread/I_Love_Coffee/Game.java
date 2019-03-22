package I_Love_Coffee;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

public class Game extends JFrame implements Runnable {
	// 컴포넌트
	private JProgressBar PopularityBar; // 인기도바
	private Label Score; // 점수
	private Label Level; // 레벨
	private Label Order; // 주문
	private Label Time; // 남은시간
	private Label[] materials; // 재료
	private Button[] button_list; // 버튼

	// 변수
	private int level = 1; // 레벨
	private String order = "아이스카라멜라떼"; // 주문
	private int time = 0; // 남은시간
	private int materials_count = 0; // 재료순서
	
	//객체
	private Frame recipe; //레시피
	private Player player; //플레이어 객체
	private scoreIO scoreIO; //결과파일 입출력

	Game() {
		// 메시지 대화상자
		// showMessageDialog(메시지를 출력할 프레임, "출력할 메시지")
		JOptionPane.showMessageDialog(new Frame(), "Game Start","I Love Coffee", 1);
		
		// Frame 설정
		this.setSize(800, 500);// 화면 크기 설정
		this.setLocation(300, 100); // 화면 위치 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료버튼 종료 할수 있게
		this.setTitle("I LOVE COFFEE"); // title 설정
		this.setResizable(false); // 화면크기 조정 차단
		this.setLayout(null); // 레이아웃 설정

		// 인기도
		PopularityBar = new JProgressBar(0, 100); // 0~100(시작값,끝값)
		PopularityBar.setValue(PopularityBar.getMaximum());
		PopularityBar.setStringPainted(true); // 진행률을 텍스트로 표시
		PopularityBar.setSize(765, 30);
		PopularityBar.setLocation(8, 20);
		PopularityBar.setBorder(new LineBorder(new Color(255, 255, 255), 0));// 테두리
		
		// 제거
		PopularityBar.setBorderPainted(false); // 내부 음영
		PopularityBar.setBackground(new Color(80, 80, 80)); // 배경색
		PopularityBar.setForeground(new Color(220, 160, 10)); // 전경색
		PopularityBar.setVisible(true);
		this.add(PopularityBar);

		Label Popularity = new Label("인기도");
		Popularity.setSize(50, 50);
		Popularity.setLocation(PopularityBar.getX(), PopularityBar.getY() - 35);
		this.add(Popularity);

		// 스코어
		Label Score_label = new Label("Score");
		// 좌표와 크기 한번에 설정
		Score_label.setBounds(PopularityBar.getX() + 5,
				PopularityBar.getY() + 40, 40, 20);
		this.add(Score_label);

		Score = new Label();
		Score.setBounds(Score_label.getX() + Score_label.getWidth(),
				Score_label.getY(), 50, 20);
		this.add(Score);

		// 레벨
		Label Level_label = new Label("Level");
		Level_label.setBounds(Score_label.getX(), Score_label.getY() + 25, 40,
				20);
		this.add(Level_label);

		Level = new Label(level + "");
		Level.setBounds(Level_label.getX() + Level_label.getWidth(),
				Level_label.getY(), 50, 20);
		this.add(Level);

		// 주문
		Order = new Label(order, Label.CENTER);
		Order.setSize(400, 50);
		Order.setLocation((this.getWidth() / 2) - (Order.getWidth() / 2),
				(this.getHeight() / 2) - (Order.getHeight() / 2) - 50);
		// Order.setBackground(Color.gray);
		Order.setForeground(new Color(80, 80, 80));
		Order.setFont(new Font(null, Font.PLAIN, 30));
		this.add(Order);

		// 남은시간
		Time = new Label(timeFormat(time), Label.CENTER);
		Time.setSize(80, 40);
		Time.setLocation((this.getWidth() / 2) - (Time.getWidth() / 2),
				(this.getHeight() / 2) - (Time.getHeight() / 2) - 10);
		// Time.setBackground(Color.gray);
		Time.setForeground(new Color(80, 80, 80));
		Time.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		this.add(Time);

		// 버튼
		String[] button_name = { "얼음", "에스프레소샷", "우유", "물", "카라멜시럽", "초코시럽",
				"시나몬가루", "바닐라시럽", "생크림", "녹차파우더", "고구마라떼파우더", "블랜더" };
		button_list = new Button[button_name.length];
		int button_height = 50;
		int button_width = 123;
		int padding = 5;
		for (int i = 0; i < button_name.length; i++) {
			button_list[i] = new Button(button_name[i]);
			button_list[i].setBackground(new Color(200,200,200));
			button_list[i].setSize(button_width, button_height);
			button_list[i].setLocation(
							(10 + ((i % 6) * (button_width + padding))),
							((this.getHeight() - (button_height * 3)) - (-(i / 6) * (button_height + padding))));
			button_list[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mix(e.getActionCommand());
					player.btn_compare(e.getActionCommand(), materials_count);
				}
			});
			button_list[i].setEnabled(false);
			this.add(button_list[i]);
		}

		// 재료
		int material_width = 150;
		int material_height = 40;
		int materialsNum = 6;

		Panel kitchen_bg = new Panel(null);
		kitchen_bg.setBounds(this.getWidth() - 200, 80, material_width + 20,
				(material_height * materialsNum) + 10);
		kitchen_bg.setBackground(Color.gray);
		this.add(kitchen_bg);

		Panel kitchen = new Panel(null);
		kitchen.setBounds(10, 0, material_width, material_height * materialsNum);
		kitchen.setBackground(Color.WHITE);
		kitchen_bg.add(kitchen);

		materials = new Label[materialsNum];
		for (int i = 1; i <= materials.length; i++) {
			materials[i - 1] = new Label("", Label.CENTER);
			materials[i - 1].setSize(material_width, material_height);
			materials[i - 1].setLocation(0, kitchen.getHeight()
					- (material_height * i));
			materials[i - 1].setBackground(new Color(
					(int) (Math.random() * 105) + 150,
					(int) (Math.random() * 105) + 150,
					(int) (Math.random() * 105) + 150));
			materials[i - 1].setVisible(false);
			kitchen.add(materials[i - 1]);
		}

		// 화면 출력 (setVisible은 frame에 객체들을 추가한뒤 마지막에 코딩한다)
		this.setVisible(true);

		
		// 보조 프레임 설정
		recipe = new Frame();
		recipe.setSize(200, 500);
		recipe.setLocation(90, 100);
		recipe.setLayout(null);
		recipe.setResizable(false);


		TextArea txt_recipe = new TextArea("",5,5,1);
		txt_recipe.setSize(190, 400);
		txt_recipe.setLocation(10, 100);
		txt_recipe.setEditable(false);

		String tempString = "";
		Recipe rec = new Recipe();
		Iterator iterator = rec.getMenu_List().keySet().iterator();
		while (iterator.hasNext()) {
			String temp = iterator.next() + "";
			tempString += temp + "\r\n";
			for (int i = 0; i < rec.getMenu_List().get(temp).size(); i++) {
				tempString += "-" + rec.getMenu_List().get(temp).get(i)
						+ "\r\n";
			}
			tempString += "\r\n";
		}

		txt_recipe.setText(tempString);
		recipe.add(txt_recipe);

		// URL 버튼
		JButton button1 = new JButton("홈페이지");
		button1.setSize(100, 50);
		button1.setLocation(50, 40);
		recipe.add(button1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime()
							.exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE http://cafe.naver.com/kosta75");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		recipe.setVisible(true);
		
/*
		// 배경음
		AudioClip adc = null;
		String bgm = "/music/BGM.wav";

		try {
			adc = JApplet.newAudioClip(getClass().getResource(bgm));
		} catch (Exception e2) {
			System.out.println("음향 파일 로딩 실패");
		}

		adc.loop();// 배경음 플레이
*/
		
		// player 생성
		player = new Player();
		player.playGame();
		
		// scoreIO 생성
		scoreIO = new scoreIO();

		// Thread start
		Thread thread = new Thread(this);
		thread.start();
	}

	// 재료표시
	public void mix(String recipe_name) {
		if (materials_count < materials.length) {
			materials[materials_count].setText(recipe_name);
			materials[materials_count++].setVisible(true);
		}
	}

	// 재료표시 초기화
	public void mix_init() {
		for (int i = 0; i < materials.length; i++) {
			materials[i].setVisible(false);
		}
		materials_count = 0;
	}

	// Level별 버튼 활성화
	public void button_enble(int level) {
		int activebtn = level * 4;
		if (activebtn > button_list.length)
			activebtn = button_list.length;
		for (int i = 0; i < activebtn; i++) {
			button_list[i].setEnabled(true);
		}
	}

	// 시간 포맷
	public String timeFormat(int time) {
		int mm = time / 60;
		int ss = time % 60;
		String timeformat;
		if (mm < 10)
			timeformat = "0" + mm + ":";
		else
			timeformat = "" + mm + ":";
		if (ss < 10)
			timeformat += "0" + ss;
		else
			timeformat += "" + ss;
		return timeformat;
	}

	@Override
	public void run() {// 화면 갱신 Thread
		int i = 100;
		while (true) {
			button_enble(10); // 버튼 레벨별 활성화
			PopularityBar.setValue(player.getPopularity()); // 인기도바 갱신
			Score.setText(String.valueOf(player.getScore())); // 점수 갱신
			Level.setText(String.valueOf(player.getLevel())); // 레벨 갱신
			Order.setText(player.getRandMenu()); //주문 갱신
			Time.setText(timeFormat(player.npc.getTime())); // 시간 갱신
			
			if (player.getPopularity() <= 0) break; // 게임종료
			if (player.getFalseOrder())	mix_init(); //문제 틀릴경우 (새 주문)
			if (player.npc.getTime() == 0) {    //시간 초과시 (새주문)
				mix_init();
				player.timeover();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

		System.out.println("-----------gameover-------------");
		String message = JOptionPane.showInputDialog(this, "이름을 입력하세요.","점수 입력", 1);

		scoreIO.Saving(message, player.getScore()); //점수 저장
		JOptionPane.showMessageDialog(this, scoreIO.View()); // 점수 표시
		
		this.setVisible(false);
		recipe.setVisible(false);
		System.exit(0);
	}

	public static void main(String[] args) {
		new Game();
	}
}