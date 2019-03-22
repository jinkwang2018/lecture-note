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
	// ������Ʈ
	private JProgressBar PopularityBar; // �α⵵��
	private Label Score; // ����
	private Label Level; // ����
	private Label Order; // �ֹ�
	private Label Time; // �����ð�
	private Label[] materials; // ���
	private Button[] button_list; // ��ư

	// ����
	private int level = 1; // ����
	private String order = "���̽�ī����"; // �ֹ�
	private int time = 0; // �����ð�
	private int materials_count = 0; // ������
	
	//��ü
	private Frame recipe; //������
	private Player player; //�÷��̾� ��ü
	private scoreIO scoreIO; //������� �����

	Game() {
		// �޽��� ��ȭ����
		// showMessageDialog(�޽����� ����� ������, "����� �޽���")
		JOptionPane.showMessageDialog(new Frame(), "Game Start","I Love Coffee", 1);
		
		// Frame ����
		this.setSize(800, 500);// ȭ�� ũ�� ����
		this.setLocation(300, 100); // ȭ�� ��ġ ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �����ư ���� �Ҽ� �ְ�
		this.setTitle("I LOVE COFFEE"); // title ����
		this.setResizable(false); // ȭ��ũ�� ���� ����
		this.setLayout(null); // ���̾ƿ� ����

		// �α⵵
		PopularityBar = new JProgressBar(0, 100); // 0~100(���۰�,����)
		PopularityBar.setValue(PopularityBar.getMaximum());
		PopularityBar.setStringPainted(true); // ������� �ؽ�Ʈ�� ǥ��
		PopularityBar.setSize(765, 30);
		PopularityBar.setLocation(8, 20);
		PopularityBar.setBorder(new LineBorder(new Color(255, 255, 255), 0));// �׵θ�
		
		// ����
		PopularityBar.setBorderPainted(false); // ���� ����
		PopularityBar.setBackground(new Color(80, 80, 80)); // ����
		PopularityBar.setForeground(new Color(220, 160, 10)); // �����
		PopularityBar.setVisible(true);
		this.add(PopularityBar);

		Label Popularity = new Label("�α⵵");
		Popularity.setSize(50, 50);
		Popularity.setLocation(PopularityBar.getX(), PopularityBar.getY() - 35);
		this.add(Popularity);

		// ���ھ�
		Label Score_label = new Label("Score");
		// ��ǥ�� ũ�� �ѹ��� ����
		Score_label.setBounds(PopularityBar.getX() + 5,
				PopularityBar.getY() + 40, 40, 20);
		this.add(Score_label);

		Score = new Label();
		Score.setBounds(Score_label.getX() + Score_label.getWidth(),
				Score_label.getY(), 50, 20);
		this.add(Score);

		// ����
		Label Level_label = new Label("Level");
		Level_label.setBounds(Score_label.getX(), Score_label.getY() + 25, 40,
				20);
		this.add(Level_label);

		Level = new Label(level + "");
		Level.setBounds(Level_label.getX() + Level_label.getWidth(),
				Level_label.getY(), 50, 20);
		this.add(Level);

		// �ֹ�
		Order = new Label(order, Label.CENTER);
		Order.setSize(400, 50);
		Order.setLocation((this.getWidth() / 2) - (Order.getWidth() / 2),
				(this.getHeight() / 2) - (Order.getHeight() / 2) - 50);
		// Order.setBackground(Color.gray);
		Order.setForeground(new Color(80, 80, 80));
		Order.setFont(new Font(null, Font.PLAIN, 30));
		this.add(Order);

		// �����ð�
		Time = new Label(timeFormat(time), Label.CENTER);
		Time.setSize(80, 40);
		Time.setLocation((this.getWidth() / 2) - (Time.getWidth() / 2),
				(this.getHeight() / 2) - (Time.getHeight() / 2) - 10);
		// Time.setBackground(Color.gray);
		Time.setForeground(new Color(80, 80, 80));
		Time.setFont(new Font("���� ���", Font.PLAIN, 28));
		this.add(Time);

		// ��ư
		String[] button_name = { "����", "���������Ҽ�", "����", "��", "ī���÷�", "���ڽ÷�",
				"�ó��󰡷�", "�ٴҶ�÷�", "��ũ��", "�����Ŀ��", "�������Ŀ��", "����" };
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

		// ���
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

		// ȭ�� ��� (setVisible�� frame�� ��ü���� �߰��ѵ� �������� �ڵ��Ѵ�)
		this.setVisible(true);

		
		// ���� ������ ����
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

		// URL ��ư
		JButton button1 = new JButton("Ȩ������");
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
		// �����
		AudioClip adc = null;
		String bgm = "/music/BGM.wav";

		try {
			adc = JApplet.newAudioClip(getClass().getResource(bgm));
		} catch (Exception e2) {
			System.out.println("���� ���� �ε� ����");
		}

		adc.loop();// ����� �÷���
*/
		
		// player ����
		player = new Player();
		player.playGame();
		
		// scoreIO ����
		scoreIO = new scoreIO();

		// Thread start
		Thread thread = new Thread(this);
		thread.start();
	}

	// ���ǥ��
	public void mix(String recipe_name) {
		if (materials_count < materials.length) {
			materials[materials_count].setText(recipe_name);
			materials[materials_count++].setVisible(true);
		}
	}

	// ���ǥ�� �ʱ�ȭ
	public void mix_init() {
		for (int i = 0; i < materials.length; i++) {
			materials[i].setVisible(false);
		}
		materials_count = 0;
	}

	// Level�� ��ư Ȱ��ȭ
	public void button_enble(int level) {
		int activebtn = level * 4;
		if (activebtn > button_list.length)
			activebtn = button_list.length;
		for (int i = 0; i < activebtn; i++) {
			button_list[i].setEnabled(true);
		}
	}

	// �ð� ����
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
	public void run() {// ȭ�� ���� Thread
		int i = 100;
		while (true) {
			button_enble(10); // ��ư ������ Ȱ��ȭ
			PopularityBar.setValue(player.getPopularity()); // �α⵵�� ����
			Score.setText(String.valueOf(player.getScore())); // ���� ����
			Level.setText(String.valueOf(player.getLevel())); // ���� ����
			Order.setText(player.getRandMenu()); //�ֹ� ����
			Time.setText(timeFormat(player.npc.getTime())); // �ð� ����
			
			if (player.getPopularity() <= 0) break; // ��������
			if (player.getFalseOrder())	mix_init(); //���� Ʋ����� (�� �ֹ�)
			if (player.npc.getTime() == 0) {    //�ð� �ʰ��� (���ֹ�)
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
		String message = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���.","���� �Է�", 1);

		scoreIO.Saving(message, player.getScore()); //���� ����
		JOptionPane.showMessageDialog(this, scoreIO.View()); // ���� ǥ��
		
		this.setVisible(false);
		recipe.setVisible(false);
		System.exit(0);
	}

	public static void main(String[] args) {
		new Game();
	}
}