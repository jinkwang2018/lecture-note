package BlueMarble;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Display extends JFrame {
	static HashMap<Integer, Block> block = new HashMap<>();
	static ArrayList<Player> player = new ArrayList<>();
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel label17;
	private JLabel label18;
	
	private JLabel labelp1_1;
	private JLabel labelp1_2;
	private JLabel labelp1_3;
	private JLabel labelp1_4;
	private JLabel labelp1_5;
	private JLabel labelp1_6;
	private JLabel labelp1_7;
	private JLabel labelp1_8;
	private JLabel labelp1_9;
	private JLabel labelp1_10;
	private JLabel labelp1_11;
	private JLabel labelp1_12;
	private JLabel labelp1_13;
	private JLabel labelp1_14;
	private JLabel labelp1_15;
	private JLabel labelp1_16;
	private JLabel labelp1_17;
	private JLabel labelp1_18;
	
	private JLabel labelp2_1;
	private JLabel labelp2_5;
	private JLabel labelp2_4;
	private JLabel labelp2_3;
	private JLabel labelp2_2;
	private JLabel labelp2_6;
	private JLabel labelp2_7;
	private JLabel labelp2_8;
	private JLabel labelp2_9;
	private JLabel labelp2_10;
	private JLabel labelp2_11;
	private JLabel labelp2_12;
	private JLabel labelp2_13;
	private JLabel labelp2_14;
	private JLabel labelp2_15;
	private JLabel labelp2_16;
	private JLabel labelp2_17;
	private JLabel labelp2_18;
	
	private JLabel lbljoo;
	private JTextArea textArea;
	private ImageIcon ic; // ÁÖ»çÀ§ »çÁø ÀÌ¹ÌÁö
	private ImageIcon p1_ico; // ÁÖ»çÀ§ »çÁø ÀÌ¹ÌÁö
	private ImageIcon p2_ico; // ÁÖ»çÀ§ »çÁø ÀÌ¹ÌÁö
	
	static int dice = 0;
	static int location = 1;
	static int location_p1 = 1;//ÀÓ½Ã
	static int location_p2 = 1;//ÀÓ½Ã
	static int cost = 0;
	static boolean gubun = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			int dice;
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
					frame.textArea.append("\n["+player.get(0).getName()+"]´ÔÀÇ Â÷·ÊÀÔ´Ï´Ù!");
					//block.get(location).playerToken(1, true);
					//block.get(location).playerToken(2, true);
					
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(132, 120, 443, 225);
		lblNewLabel.setIcon(new ImageIcon("src//img//logo2.PNG"));
		contentPane.add(lblNewLabel);
		
		label1 = new JLabel("Ãâ¹ßÁ¡");
		label1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label1.setBorder(null);
		label1.setBackground(Color.WHITE);
		label1.setOpaque(true);
		label1.setBounds(587, 466, 115, 65);
		label1.setIcon(new ImageIcon("src//img//1area.png"));
		contentPane.add(label1);
		
		label2 = new JLabel("È«Äá");
		label2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label2.setOpaque(true);
		label2.setBackground(new Color(255, 250, 205));
		label2.setBorder(null);
		label2.setBounds(475, 481, 100, 50);
		label2.setIcon(new ImageIcon("src//img//2area.jpg"));
		contentPane.add(label2);
		
		label3 = new JLabel("½Ì°¡Æú");
		label3.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label3.setOpaque(true);
		label3.setBackground(new Color(255, 250, 205));
		label3.setBorder(null);
		label3.setBounds(363, 481, 100, 50);
		label3.setIcon(new ImageIcon("src//img//3area.jpg"));
		contentPane.add(label3);
		
		label4 = new JLabel("¾ÆÅ×³×");
		label4.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label4.setOpaque(true);
		label4.setBackground(new Color(255, 250, 205));
		label4.setBorder(null);
		label4.setBounds(251, 481, 100, 50);
		label4.setIcon(new ImageIcon("src//img//4area.jpg"));
		contentPane.add(label4);
		
		label5 = new JLabel("º£¸¦¸°");
		label5.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label5.setOpaque(true);
		label5.setBackground(new Color(255, 250, 205));
		label5.setBorder(null);
		label5.setBounds(139, 481, 100, 50);
		label5.setIcon(new ImageIcon("src//img//5area.jpg"));
		contentPane.add(label5);
		
		label6 = new JLabel("½Ãµå´Ï");
		label6.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label6.setBorder(null);
		label6.setOpaque(true);
		label6.setBackground(Color.WHITE);
		label6.setBounds(12, 466, 115, 65);
		label6.setIcon(new ImageIcon("src//img//6area.jpg"));
		contentPane.add(label6);
		
		label7 = new JLabel("ÇÏ¿ÍÀÌ");
		label7.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label7.setOpaque(true);
		label7.setBackground(new Color(224, 255, 255));
		label7.setBorder(null);
		label7.setBounds(12, 356, 100, 50);
		label7.setIcon(new ImageIcon("src//img//7area.jpg"));
		contentPane.add(label7);
		
		label8 = new JLabel("¸®½ºº»");
		label8.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label8.setOpaque(true);
		label8.setBackground(new Color(224, 255, 255));
		label8.setBorder(null);
		label8.setBounds(12, 245, 100, 50);
		label8.setIcon(new ImageIcon("src//img//8area.jpg"));
		contentPane.add(label8);
		
		label9 = new JLabel("\uC2A4\uD398\uC778");
		label9.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label9.setOpaque(true);
		label9.setBackground(new Color(224, 255, 255));
		label9.setBorder(null);
		label9.setBounds(12, 135, 100, 50);
		label9.setIcon(new ImageIcon("src//img//9area.jpg"));
		contentPane.add(label9);
		
		label10 = new JLabel("¹«ÀÎµµ");
		label10.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label10.setBorder(null);
		label10.setOpaque(true);
		label10.setBackground(Color.WHITE);
		label10.setBounds(12, 10, 115, 65);
		label10.setIcon(new ImageIcon("src//img//10area.jpg"));
		contentPane.add(label10);
		
		label11 = new JLabel("µµÄì");
		label11.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label11.setBackground(new Color(240, 255, 240));
		label11.setOpaque(true);
		label11.setBorder(null);
		label11.setBounds(139, 10, 100, 50);
		label11.setIcon(new ImageIcon("src//img//11area.jpg"));
		contentPane.add(label11);
		
		label12 = new JLabel("ÆÄ¸®");
		label12.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label12.setBackground(new Color(240, 255, 240));
		label12.setOpaque(true);
		label12.setBorder(null);
		label12.setBounds(251, 10, 100, 50);
		label12.setIcon(new ImageIcon("src//img//12area.jpg"));
		contentPane.add(label12);
		
		label13 = new JLabel("·Î¸¶");
		label13.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label13.setBackground(new Color(240, 255, 240));
		label13.setOpaque(true);
		label13.setBorder(null);
		label13.setBounds(363, 10, 100, 50);
		label13.setIcon(new ImageIcon("src//img//13area.jpg"));
		contentPane.add(label13);
		
		label14 = new JLabel("·±´ø");
		label14.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label14.setBackground(new Color(240, 255, 240));
		label14.setOpaque(true);
		label14.setBorder(null);
		label14.setBounds(475, 10, 100, 50);
		label14.setIcon(new ImageIcon("src//img//14area.jpg"));
		contentPane.add(label14);
		
		label15 = new JLabel("´º¿å");
		label15.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label15.setBorder(null);
		label15.setOpaque(true);
		label15.setBackground(Color.WHITE);
		label15.setBounds(587, 10, 115, 65);
		label15.setIcon(new ImageIcon("src//img//7area.jpg"));
		contentPane.add(label15);
		
		label16 = new JLabel("LA");
		label16.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label16.setOpaque(true);
		label16.setBackground(new Color(255, 228, 225));
		label16.setBorder(null);
		label16.setBounds(602, 135, 100, 50);
		label16.setIcon(new ImageIcon("src//img//7area.jpg"));
		contentPane.add(label16);
		
		label17 = new JLabel("¼­¿ï");
		label17.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label17.setOpaque(true);
		label17.setBackground(new Color(255, 228, 225));
		label17.setBorder(null);
		label17.setBounds(602, 245, 100, 50);
		label17.setIcon(new ImageIcon("src//img//17area.jpg"));
		contentPane.add(label17);
		
		label18 = new JLabel("¼¼°ü");
		label18.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label18.setOpaque(true);
		label18.setBackground(new Color(255, 228, 225));
		label18.setBorder(null);
		label18.setBounds(602, 356, 100, 50);
		label18.setIcon(new ImageIcon("src//img//18area.jpg"));
		contentPane.add(label18);
		
		lbljoo = new JLabel(new ImageIcon("src\\img\\1.PNG"));
		lbljoo.setBounds(435, 342, 140, 129);
		contentPane.add(lbljoo);
		
		JLabel lblpMoney = new JLabel("1P MONEY : 3,000,000");
		lblpMoney.setForeground(Color.RED);
		lblpMoney.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblpMoney.setBounds(139, 378, 212, 28);
		contentPane.add(lblpMoney);
		
		JLabel lblpMoney_1 = new JLabel("2P MONEY : 3,000,000");
		lblpMoney_1.setForeground(Color.BLUE);
		lblpMoney_1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblpMoney_1.setBounds(139, 415, 212, 28);
		contentPane.add(lblpMoney_1);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(731, 74, 212, 384);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setText("\uC8FC\uC0AC\uC704\uB97C \uC785\uB825\uD558\uC138\uC694.");
		textField.setBounds(731, 469, 212, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC8FC\uC0AC\uC704 \uBC84\uD2BC");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("¸¶¿ì½ºÅ¬¸¯!");
				play();
			}
		});
		btnNewButton.setBounds(731, 525, 212, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\uC2DC\uC2A4\uD15C \uBA54\uC138\uC9C0");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(731, 13, 212, 51);
		contentPane.add(lblNewLabel_2);
		
		p1_ico = new ImageIcon("src\\img\\1p.PNG"); // ÀÌ¹ÌÁö 1
		p2_ico = new ImageIcon("src\\img\\2p.PNG"); // ÀÌ¹ÌÁö 1
		
		labelp1_1 = new JLabel(p1_ico);
		labelp1_1.setVerticalAlignment(SwingConstants.TOP);
		labelp1_1.setOpaque(true);
		labelp1_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_1.setBorder(null);
		labelp1_1.setBackground(Color.WHITE);
		labelp1_1.setBounds(587, 531, 57, 50);
		contentPane.add(labelp1_1);
		
		labelp1_2 = new JLabel();
		labelp1_2.setVerticalAlignment(SwingConstants.TOP);
		labelp1_2.setOpaque(true);
		labelp1_2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_2.setBorder(null);
		labelp1_2.setBackground(new Color(255, 250, 205));
		labelp1_2.setBounds(475, 531, 50, 50);
		contentPane.add(labelp1_2);
		
		labelp1_3 = new JLabel();
		labelp1_3.setVerticalAlignment(SwingConstants.TOP);
		labelp1_3.setOpaque(true);
		labelp1_3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_3.setBorder(null);
		labelp1_3.setBackground(new Color(255, 250, 205));
		labelp1_3.setBounds(363, 531, 50, 50);
		contentPane.add(labelp1_3);
		
		labelp1_4 = new JLabel();
		labelp1_4.setVerticalAlignment(SwingConstants.TOP);
		labelp1_4.setOpaque(true);
		labelp1_4.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_4.setBorder(null);
		labelp1_4.setBackground(new Color(255, 250, 205));
		labelp1_4.setBounds(251, 531, 50, 50);
		contentPane.add(labelp1_4);
		
		labelp1_5 = new JLabel();
		labelp1_5.setVerticalAlignment(SwingConstants.TOP);
		labelp1_5.setOpaque(true);
		labelp1_5.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_5.setBorder(null);
		labelp1_5.setBackground(new Color(255, 250, 205));
		labelp1_5.setBounds(139, 531, 50, 50);
		contentPane.add(labelp1_5);
		
		labelp1_6 = new JLabel();
		labelp1_6.setVerticalAlignment(SwingConstants.TOP);
		labelp1_6.setOpaque(true);
		labelp1_6.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_6.setBorder(null);
		labelp1_6.setBackground(Color.WHITE);
		labelp1_6.setBounds(12, 531, 57, 50);
		contentPane.add(labelp1_6);
		
		labelp1_7 = new JLabel();
		labelp1_7.setVerticalAlignment(SwingConstants.TOP);
		labelp1_7.setOpaque(true);
		labelp1_7.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_7.setBorder(null);
		labelp1_7.setBackground(new Color(224, 255, 255));
		labelp1_7.setBounds(12, 406, 50, 50);
		contentPane.add(labelp1_7);
		
		labelp1_8 = new JLabel();
		labelp1_8.setVerticalAlignment(SwingConstants.TOP);
		labelp1_8.setOpaque(true);
		labelp1_8.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_8.setBorder(null);
		labelp1_8.setBackground(new Color(224, 255, 255));
		labelp1_8.setBounds(12, 295, 50, 50);
		contentPane.add(labelp1_8);
		
		labelp1_9 = new JLabel();
		labelp1_9.setVerticalAlignment(SwingConstants.TOP);
		labelp1_9.setOpaque(true);
		labelp1_9.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_9.setBorder(null);
		labelp1_9.setBackground(new Color(224, 255, 255));
		labelp1_9.setBounds(12, 185, 50, 50);
		contentPane.add(labelp1_9);
		
		labelp1_10 = new JLabel();
		labelp1_10.setVerticalAlignment(SwingConstants.TOP);
		labelp1_10.setOpaque(true);
		labelp1_10.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_10.setBorder(null);
		labelp1_10.setBackground(Color.WHITE);
		labelp1_10.setBounds(12, 75, 57, 50);
		contentPane.add(labelp1_10);
		
		labelp1_11 = new JLabel();
		labelp1_11.setVerticalAlignment(SwingConstants.TOP);
		labelp1_11.setOpaque(true);
		labelp1_11.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_11.setBorder(null);
		labelp1_11.setBackground(new Color(240, 255, 240));
		labelp1_11.setBounds(139, 60, 50, 50);
		contentPane.add(labelp1_11);
		
		labelp1_12 = new JLabel();
		labelp1_12.setVerticalAlignment(SwingConstants.TOP);
		labelp1_12.setOpaque(true);
		labelp1_12.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_12.setBorder(null);
		labelp1_12.setBackground(new Color(240, 255, 240));
		labelp1_12.setBounds(251, 60, 50, 50);
		contentPane.add(labelp1_12);
		
		labelp1_13 = new JLabel();
		labelp1_13.setVerticalAlignment(SwingConstants.TOP);
		labelp1_13.setOpaque(true);
		labelp1_13.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_13.setBorder(null);
		labelp1_13.setBackground(new Color(240, 255, 240));
		labelp1_13.setBounds(363, 60, 50, 50);
		contentPane.add(labelp1_13);
		
		labelp1_14 = new JLabel();
		labelp1_14.setVerticalAlignment(SwingConstants.TOP);
		labelp1_14.setOpaque(true);
		labelp1_14.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_14.setBorder(null);
		labelp1_14.setBackground(new Color(240, 255, 240));
		labelp1_14.setBounds(475, 60, 50, 50);
		contentPane.add(labelp1_14);
		
		labelp1_15 = new JLabel();
		labelp1_15.setVerticalAlignment(SwingConstants.TOP);
		labelp1_15.setOpaque(true);
		labelp1_15.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_15.setBorder(null);
		labelp1_15.setBackground(Color.WHITE);
		labelp1_15.setBounds(587, 75, 57, 50);
		contentPane.add(labelp1_15);
		
		labelp1_16 = new JLabel();
		labelp1_16.setVerticalAlignment(SwingConstants.TOP);
		labelp1_16.setOpaque(true);
		labelp1_16.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_16.setBorder(null);
		labelp1_16.setBackground(new Color(255, 228, 225));
		labelp1_16.setBounds(602, 185, 50, 50);
		contentPane.add(labelp1_16);
		
		labelp1_17 = new JLabel();
		labelp1_17.setVerticalAlignment(SwingConstants.TOP);
		labelp1_17.setOpaque(true);
		labelp1_17.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_17.setBorder(null);
		labelp1_17.setBackground(new Color(255, 228, 225));
		labelp1_17.setBounds(602, 295, 50, 50);
		contentPane.add(labelp1_17);
		
		labelp1_18 = new JLabel();
		labelp1_18.setVerticalAlignment(SwingConstants.TOP);
		labelp1_18.setOpaque(true);
		labelp1_18.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp1_18.setBorder(null);
		labelp1_18.setBackground(new Color(255, 228, 225));
		labelp1_18.setBounds(602, 406, 50, 50);
		contentPane.add(labelp1_18);
		
		labelp2_1 = new JLabel(p2_ico);
		labelp2_1.setVerticalAlignment(SwingConstants.TOP);
		labelp2_1.setOpaque(true);
		labelp2_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_1.setBorder(null);
		labelp2_1.setBackground(Color.WHITE);
		labelp2_1.setBounds(645, 531, 57, 50);
		contentPane.add(labelp2_1);
		
		labelp2_5 = new JLabel();
		labelp2_5.setVerticalAlignment(SwingConstants.TOP);
		labelp2_5.setOpaque(true);
		labelp2_5.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_5.setBorder(null);
		labelp2_5.setBackground(new Color(255, 250, 205));
		labelp2_5.setBounds(189, 531, 50, 50);
		contentPane.add(labelp2_5);
		
		labelp2_4 = new JLabel();
		labelp2_4.setVerticalAlignment(SwingConstants.TOP);
		labelp2_4.setOpaque(true);
		labelp2_4.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_4.setBorder(null);
		labelp2_4.setBackground(new Color(255, 250, 205));
		labelp2_4.setBounds(301, 531, 50, 50);
		contentPane.add(labelp2_4);
		
		labelp2_3 = new JLabel();
		labelp2_3.setVerticalAlignment(SwingConstants.TOP);
		labelp2_3.setOpaque(true);
		labelp2_3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_3.setBorder(null);
		labelp2_3.setBackground(new Color(255, 250, 205));
		labelp2_3.setBounds(413, 531, 50, 50);
		contentPane.add(labelp2_3);
		
		labelp2_2 = new JLabel();
		labelp2_2.setVerticalAlignment(SwingConstants.TOP);
		labelp2_2.setOpaque(true);
		labelp2_2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_2.setBorder(null);
		labelp2_2.setBackground(new Color(255, 250, 205));
		labelp2_2.setBounds(525, 531, 50, 50);
		contentPane.add(labelp2_2);
		
		labelp2_6 = new JLabel();
		labelp2_6.setVerticalAlignment(SwingConstants.TOP);
		labelp2_6.setOpaque(true);
		labelp2_6.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_6.setBorder(null);
		labelp2_6.setBackground(Color.WHITE);
		labelp2_6.setBounds(69, 531, 57, 50);
		contentPane.add(labelp2_6);
		
		labelp2_7 = new JLabel();
		labelp2_7.setVerticalAlignment(SwingConstants.TOP);
		labelp2_7.setOpaque(true);
		labelp2_7.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_7.setBorder(null);
		labelp2_7.setBackground(new Color(224, 255, 255));
		labelp2_7.setBounds(62, 406, 50, 50);
		contentPane.add(labelp2_7);
		
		labelp2_8 = new JLabel();
		labelp2_8.setVerticalAlignment(SwingConstants.TOP);
		labelp2_8.setOpaque(true);
		labelp2_8.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_8.setBorder(null);
		labelp2_8.setBackground(new Color(224, 255, 255));
		labelp2_8.setBounds(62, 295, 50, 50);
		contentPane.add(labelp2_8);
		
		labelp2_9 = new JLabel();
		labelp2_9.setVerticalAlignment(SwingConstants.TOP);
		labelp2_9.setOpaque(true);
		labelp2_9.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_9.setBorder(null);
		labelp2_9.setBackground(new Color(224, 255, 255));
		labelp2_9.setBounds(62, 185, 50, 50);
		contentPane.add(labelp2_9);
		
		labelp2_10 = new JLabel();
		labelp2_10.setVerticalAlignment(SwingConstants.TOP);
		labelp2_10.setOpaque(true);
		labelp2_10.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_10.setBorder(null);
		labelp2_10.setBackground(Color.WHITE);
		labelp2_10.setBounds(70, 75, 57, 50);
		contentPane.add(labelp2_10);
		
		labelp2_11 = new JLabel();
		labelp2_11.setVerticalAlignment(SwingConstants.TOP);
		labelp2_11.setOpaque(true);
		labelp2_11.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_11.setBorder(null);
		labelp2_11.setBackground(new Color(240, 255, 240));
		labelp2_11.setBounds(189, 60, 50, 50);
		contentPane.add(labelp2_11);
		
		labelp2_12 = new JLabel();
		labelp2_12.setVerticalAlignment(SwingConstants.TOP);
		labelp2_12.setOpaque(true);
		labelp2_12.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_12.setBorder(null);
		labelp2_12.setBackground(new Color(240, 255, 240));
		labelp2_12.setBounds(301, 60, 50, 50);
		contentPane.add(labelp2_12);
		
		labelp2_13 = new JLabel();
		labelp2_13.setVerticalAlignment(SwingConstants.TOP);
		labelp2_13.setOpaque(true);
		labelp2_13.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_13.setBorder(null);
		labelp2_13.setBackground(new Color(240, 255, 240));
		labelp2_13.setBounds(413, 60, 50, 50);
		contentPane.add(labelp2_13);
		
		labelp2_14 = new JLabel();
		labelp2_14.setVerticalAlignment(SwingConstants.TOP);
		labelp2_14.setOpaque(true);
		labelp2_14.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_14.setBorder(null);
		labelp2_14.setBackground(new Color(240, 255, 240));
		labelp2_14.setBounds(525, 60, 50, 50);
		contentPane.add(labelp2_14);
		
		labelp2_15 = new JLabel();
		labelp2_15.setVerticalAlignment(SwingConstants.TOP);
		labelp2_15.setOpaque(true);
		labelp2_15.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_15.setBorder(null);
		labelp2_15.setBackground(Color.WHITE);
		labelp2_15.setBounds(645, 75, 57, 50);
		contentPane.add(labelp2_15);
		
		labelp2_16 = new JLabel();
		labelp2_16.setVerticalAlignment(SwingConstants.TOP);
		labelp2_16.setOpaque(true);
		labelp2_16.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_16.setBorder(null);
		labelp2_16.setBackground(new Color(255, 228, 225));
		labelp2_16.setBounds(652, 185, 50, 50);
		contentPane.add(labelp2_16);
		
		labelp2_17 = new JLabel();
		labelp2_17.setVerticalAlignment(SwingConstants.TOP);
		labelp2_17.setOpaque(true);
		labelp2_17.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_17.setBorder(null);
		labelp2_17.setBackground(new Color(255, 228, 225));
		labelp2_17.setBounds(652, 295, 50, 50);
		contentPane.add(labelp2_17);
		
		labelp2_18 = new JLabel();
		labelp2_18.setVerticalAlignment(SwingConstants.TOP);
		labelp2_18.setOpaque(true);
		labelp2_18.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		labelp2_18.setBorder(null);
		labelp2_18.setBackground(new Color(255, 228, 225));
		labelp2_18.setBounds(652, 406, 50, 50);
		contentPane.add(labelp2_18);
		
		
		
		block.put(1, new StartArea(1, "START"));
		block.put(2, new City(2, "È«Äá", 10, 30, 20, 40, 30, 55));
		block.put(3, new City(3, "½Ì°¡Æú", 20, 40, 30, 50, 40, 65));
		block.put(4, new City(4, "¾ÆÅ×³×", 30, 50, 40, 60, 50, 75));
		block.put(5, new City(5, "º£¸¦¸°", 40, 60, 50, 80, 60, 90));
		block.put(6, new Island(6, "¹«ÀÎµµ"));
		block.put(7, new City(7, "ÇÏ¿ÍÀÌ", 55, 80, 70, 100, 80, 120));
		block.put(8, new City(8, "¸®½ºº»", 60, 85, 80, 120, 90, 130));
		block.put(9, new City(9, "Á¦ÁÖµµ", 80, 100, 90, 130, 100, 140));
		block.put(10, new City(10, "½Ãµå´Ï", 50, 70, 60, 90, 70, 100));
		block.put(11, new City(11, "µµÄì", 70, 110, 100, 140, 110, 150));
		block.put(12, new City(12, "ÆÄ¸®", 75, 120, 110, 150, 120, 160));
		block.put(13, new City(13, "·Î¸¶", 85, 125, 120, 160, 130, 170));
		block.put(14, new City(14, "·±´ø", 90, 130, 130, 170, 140, 180));
		block.put(15, new City(15, "´º¿å", 100, 140, 140, 180, 150, 190));
		block.put(16, new City(16, "LA", 110, 150, 150, 190, 160, 200));
		block.put(17, new City(17, "¼­¿ï", 120, 160, 160, 200, 170, 250));
		block.put(18, new Tax(18, "¼¼°ü"));

		String userName1 = JOptionPane.showInputDialog("p1ÀÇ ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä");
		player.add(new Player(1, userName1));
		String userName2 = JOptionPane.showInputDialog("p2ÀÇ ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä");
		player.add(new Player(2, userName2));
	}
	public void moveP1(int location,int dice) {
		//System.out.println("ÀÌµ¿°ªÀº :"+dice);
		p1_ico = new ImageIcon("src\\img\\1p.png"); // ÀÌ¹ÌÁö 1
		textField.setText("player1ÀÌ"+dice+"Ä­ ¸¸Å­ ÀÌµ¿ÇÕ´Ï´Ù");
		
			labelp1_1.setIcon(null);
			labelp1_2.setIcon(null);
			labelp1_3.setIcon(null);
			labelp1_4.setIcon(null);
			labelp1_5.setIcon(null);
			labelp1_6.setIcon(null);
			labelp1_7.setIcon(null);
			labelp1_8.setIcon(null);
			labelp1_9.setIcon(null);
			labelp1_10.setIcon(null);
			labelp1_11.setIcon(null);
			labelp1_12.setIcon(null);
			labelp1_13.setIcon(null);
			labelp1_14.setIcon(null);
			labelp1_15.setIcon(null);
			labelp1_16.setIcon(null);
			labelp1_17.setIcon(null);
			labelp1_18.setIcon(null);
			
		switch (location) {
			case 1:
				labelp1_1.setIcon(p1_ico);
				break;
			case 2:labelp1_2.setIcon(p1_ico);
				break;
			case 3:labelp1_3.setIcon(p1_ico);
				break;
			case 4:labelp1_4.setIcon(p1_ico);
				break;
			case 5:labelp1_5.setIcon(p1_ico);
				break;
			case 6:labelp1_6.setIcon(p1_ico);
				break;
			case 7:labelp1_7.setIcon(p1_ico);
				break;
			case 8:labelp1_8.setIcon(p1_ico);
				break;
			case 9:labelp1_9.setIcon(p1_ico);
				break;
			case 10:labelp1_10.setIcon(p1_ico);
				break;
			case 11:labelp1_11.setIcon(p1_ico);
				break;
			case 12:labelp1_12.setIcon(p1_ico);
				break;
			case 13:labelp1_13.setIcon(p1_ico);
				break;
			case 14:labelp1_14.setIcon(p1_ico);
				break;
			case 15:labelp1_15.setIcon(p1_ico);
				break;
			case 16:labelp1_16.setIcon(p1_ico);
				break;
			case 17:labelp1_17.setIcon(p1_ico);
				break;
			case 18:labelp1_18.setIcon(p1_ico);
			break;	
				
		}
	}
	public void moveP2(int location,int dice) {
		//System.out.println("ÀÌµ¿°ªÀº :"+dice);
		p1_ico = new ImageIcon("src\\img\\2p.png"); // ÀÌ¹ÌÁö 1
		textField.setText("player2ÀÌ"+dice+"Ä­ ¸¸Å­ ÀÌµ¿ÇÕ´Ï´Ù");
		
			labelp2_1.setIcon(null);
			labelp2_2.setIcon(null);
			labelp2_3.setIcon(null);
			labelp2_4.setIcon(null);
			labelp2_5.setIcon(null);
			labelp2_6.setIcon(null);
			labelp2_7.setIcon(null);
			labelp2_8.setIcon(null);
			labelp2_9.setIcon(null);
			labelp2_10.setIcon(null);
			labelp2_11.setIcon(null);
			labelp2_12.setIcon(null);
			labelp2_13.setIcon(null);
			labelp2_14.setIcon(null);
			labelp2_15.setIcon(null);
			labelp2_16.setIcon(null);
			labelp2_17.setIcon(null);
			labelp2_18.setIcon(null);
		switch (location) {
			case 1:
				labelp2_1.setIcon(p1_ico);
				break;
			case 2:labelp2_2.setIcon(p1_ico);
				break;
			case 3:labelp2_3.setIcon(p1_ico);
				break;
			case 4:labelp2_4.setIcon(p1_ico);
				break;
			case 5:labelp2_5.setIcon(p1_ico);
				break;
			case 6:labelp2_6.setIcon(p1_ico);
				break;
			case 7:labelp2_7.setIcon(p1_ico);
				break;
			case 8:labelp2_8.setIcon(p1_ico);
				break;
			case 9:labelp2_9.setIcon(p1_ico);
				break;
			case 10:labelp2_10.setIcon(p1_ico);
				break;
			case 11:labelp2_11.setIcon(p1_ico);
				break;
			case 12:labelp2_12.setIcon(p1_ico);
				break;
			case 13:labelp2_13.setIcon(p1_ico);
				break;
			case 14:labelp2_14.setIcon(p1_ico);
				break;
			case 15:labelp2_15.setIcon(p1_ico);
				break;
			case 16:labelp2_16.setIcon(p1_ico);
				break;
			case 17:labelp2_17.setIcon(p1_ico);
				break;
			case 18:labelp2_18.setIcon(p1_ico);
			break;	
				
		}
	}
	public void play() {
		
		if(!gubun) {
		textArea.append("\n["+player.get(1).getName()+"]´ÔÀÇ Â÷·ÊÀÔ´Ï´Ù!");
		//dice = player.get(0).dice(3); // ÁÖ»çÀ§ µ¹¸®°í ±× °ª ¸®ÅÏÇØÁÖ±â
		
		int dice = (int) (Math.random() * 6 + 1); // ·£´ý 1~6
		ic = new ImageIcon("src\\img\\"+dice+".PNG"); // ÀÌ¹ÌÁö 1
		lbljoo.setIcon(ic);
		//location = player.get(0).getLocation(); // ÁÖ»çÀ§ µ¹¸®±â Àü¿¡ À§Ä¡ °¡Á®¿À±â
		location_p1 = (location_p1+dice)%18;
		if(location_p1==0) { location_p1=18; }
		System.out.println("ÁÖ»çÀ§:"+dice);
		System.out.println("³ªÀÇÀ§Ä¡:"+location_p1);
		moveP1(location_p1,dice);
		}else {
		textArea.append("\n["+player.get(0).getName()+"]´ÔÀÇ Â÷·ÊÀÔ´Ï´Ù!");
		//dice = player.get(0).dice(3); // ÁÖ»çÀ§ µ¹¸®°í ±× °ª ¸®ÅÏÇØÁÖ±â
			
		int dice = (int) (Math.random() * 6 + 1); // ·£´ý 1~6
		ic = new ImageIcon("src\\img\\"+dice+".PNG"); // ÀÌ¹ÌÁö 1
		lbljoo.setIcon(ic);
		//location = player.get(1).getLocation(); // ÁÖ»çÀ§ µ¹¸®±â Àü¿¡ À§Ä¡ °¡Á®¿À±â
		location_p2 = (location_p2+dice)%18;
		if(location_p2==0) { location_p2=18; }
		System.out.println("ÁÖ»çÀ§:"+dice);
		System.out.println("³ªÀÇÀ§Ä¡:"+location_p2);
		moveP2(location_p2,dice);
		}
		
		gubun=!gubun;
		//System.out.println("gubun:"+gubun);
	}
}
