package BlueMarble;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class BlueMarble {
	HashMap<Integer, Block> block = new HashMap<>();//�� �ؽø����� ����
	ArrayList<Player> player = new ArrayList<>(); //�÷��̾� ����
	Dice diceobj = new Dice(); //�ֻ��� ����
	Timeout to = new Timeout();  //�ð����� Ŭ���� ����
	Calender cal = new Calender(); //���� �ð� Ŭ���� ����

	public static void clearScreen() {  //�ܼ� ȭ�� �ʱ�ȭ �Լ�
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}

	public BlueMarble() {
		init(); //���� �� �ʱ�ȭ�� �ݷ��ǿ� �����ϴ� �Լ�
	}

	void init() {//���� �� �ʱ�ȭ�� �ݷ��ǿ� �����ϴ� �Լ�
		block.put(1, new StartArea(1, "START"));
		block.put(2, new City(2, "ȫ��", 10, 30, 20, 40, 30, 55));
		block.put(3, new City(3, "�̰���", 20, 40, 30, 50, 40, 65));
		block.put(4, new City(4, "���׳�", 30, 50, 40, 60, 50, 75));
		block.put(5, new City(5, "������", 40, 60, 50, 80, 60, 90));
		block.put(6, new Island(6, "���ε�"));
		block.put(7, new City(7, "�Ͽ���", 55, 80, 70, 100, 80, 120));
		block.put(8, new City(8, "������", 60, 85, 80, 120, 90, 130));
		block.put(9, new City(9, "���ֵ�", 80, 100, 90, 130, 100, 140));
		block.put(10, new City(10, "�õ��", 50, 70, 60, 90, 70, 100));
		block.put(11, new City(11, "����", 70, 110, 100, 140, 110, 150));
		block.put(12, new City(12, "�ĸ�", 75, 120, 110, 150, 120, 160));
		block.put(13, new City(13, "�θ�", 85, 125, 120, 160, 130, 170));
		block.put(14, new City(14, "����", 90, 130, 130, 170, 140, 180));
		block.put(15, new City(15, "����", 100, 140, 140, 180, 150, 190));
		block.put(16, new City(16, "LA", 110, 150, 150, 190, 160, 200));
		block.put(17, new City(17, "����", 120, 160, 160, 200, 170, 250));
		block.put(18, new Tax(18, "����"));

		String userName1 = JOptionPane.showInputDialog("p1�� �̸��� �Է��ϼ���");//�÷��̾� ���� �� ����
		player.add(new Player(1, userName1));
		String userName2 = JOptionPane.showInputDialog("p2�� �̸��� �Է��ϼ���");
		player.add(new Player(2, userName2));
	}

	void map() {//�� ��� �Լ�
		System.out.println("-------------------------------------------------------------");
		System.out.println("���� �����ð��� : " + Timeout.i + "�� �Դϴ�.");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� " + block.get(1).p1 + "   " + block.get(1).p2 + " �� " + block.get(2).p1 + "   "
				+ block.get(2).p2 + " �� " + block.get(3).p1 + "   " + block.get(3).p2 + " �� " + block.get(4).p1 + "   "
				+ block.get(4).p2 + " �� " + block.get(5).p1 + "   " + block.get(5).p2 + " �� " + block.get(6).p1 + "   "
				+ block.get(6).p2 + " ��");
		System.out.println("��  " + block.get(1).getName() + "  ��   " + block.get(2).getName() + "         ��   "
				+ block.get(3).getName() + "      ��   " + block.get(4).getName() + "      ��   " + block.get(5).getName()
				+ "      ��   " + block.get(6).getName() + "      ��");
		System.out.println("��         ��" + ((City) (block.get(2))).getOwner() + " ��"
				+ ((City) (block.get(3))).getOwner() + " ��" + ((City) (block.get(4))).getOwner() + " ��"
				+ ((City) (block.get(5))).getOwner() + " ��         ��");
		System.out.println("��         ��   " + ((City) (block.get(2))).getStructure() + "   ��   "
				+ ((City) (block.get(3))).getStructure() + "   ��   " + ((City) (block.get(4))).getStructure()
				+ "   ��   " + ((City) (block.get(5))).getStructure() + "   ��         ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� " + block.get(18).p1 + "   " + block.get(18).p2
				+ " ��                                       �� " + block.get(7).p1 + "   " + block.get(7).p2 + " ��");
		System.out.println("��   " + block.get(18).getName() + "         ��                                       ��   "
				+ block.get(7).getName() + "      ��");
		System.out.println(
				"��         ��                                       ��" + ((City) (block.get(7))).getOwner() + " ��");
		System.out.println("��         ��                                       ��   "
				+ ((City) (block.get(7))).getStructure() + "   ��");
		System.out.println("����������������������                                       ����������������������");
		System.out.println("�� " + block.get(17).p1 + "   " + block.get(17).p2
				+ " ��                                       �� " + block.get(8).p1 + "   " + block.get(8).p2 + " ��");
		System.out.println("��   " + block.get(17).getName() + "         ��                                       ��   "
				+ block.get(8).getName() + "      ��");
		System.out.println("��" + ((City) (block.get(17))).getOwner() + " ��                                       ��"
				+ ((City) (block.get(8))).getOwner() + " ��");
		System.out.println("��   " + ((City) (block.get(17))).getStructure()
				+ "   ��                                       ��   " + ((City) (block.get(8))).getStructure() + "   ��");
		System.out.println("����������������������                                       ����������������������");
		System.out.println("�� " + block.get(16).p1 + "   " + block.get(16).p2
				+ " ��                                       �� " + block.get(9).p1 + "   " + block.get(9).p2 + " ��");
		System.out.println("��   " + block.get(16).getName() + "    ��                                       ��   "
				+ block.get(9).getName() + "      ��");
		System.out.println("��" + ((City) (block.get(16))).getOwner() + " ��                                       ��"
				+ ((City) (block.get(9))).getOwner() + " ��");
		System.out.println("��   " + ((City) (block.get(16))).getStructure()
				+ "   ��                                       ��   " + ((City) (block.get(9))).getStructure() + "   ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� " + block.get(15).p1 + "   " + block.get(15).p2 + " �� " + block.get(14).p1 + "   "
				+ block.get(14).p2 + " �� " + block.get(13).p1 + "   " + block.get(13).p2 + " �� " + block.get(12).p1
				+ "   " + block.get(12).p2 + " �� " + block.get(11).p1 + "   " + block.get(11).p2 + " �� "
				+ block.get(10).p1 + "   " + block.get(10).p2 + " ��");
		System.out.println("��   " + block.get(15).getName() + "         ��   " + block.get(14).getName()
				+ "         ��   " + block.get(13).getName() + "         ��   " + block.get(12).getName()
				+ "         ��   " + block.get(11).getName() + "         ��   " + block.get(10).getName() + "      ��");
		System.out.println("��" + ((City) (block.get(15))).getOwner() + " ��" + ((City) (block.get(14))).getOwner() + " ��"
				+ ((City) (block.get(13))).getOwner() + " ��" + ((City) (block.get(12))).getOwner() + " ��"
				+ ((City) (block.get(11))).getOwner() + " ��         ��");
		System.out.println("��   " + ((City) (block.get(15))).getStructure() + "   ��   "
				+ ((City) (block.get(14))).getStructure() + "   ��   " + ((City) (block.get(13))).getStructure()
				+ "   ��   " + ((City) (block.get(12))).getStructure() + "   ��   "
				+ ((City) (block.get(11))).getStructure() + "   ��         ��");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������");
		System.out.println("p1 : " + "[" + player.get(0).getName() + "] " + player.get(0).getBudget()+"����");
		System.out.println("p2 : " + "[" + player.get(1).getName() + "] " + player.get(1).getBudget()+"����");
		System.out.println("-------------------------------------------------------------");
	}

	public void start() { //���� ����
		to.start();  //�ð� ���� ������ �۵�
		int dice = 0; //�ֻ��� ���ϰ� ���� ����
		int location = 1; //�÷��̾� ��ġ ���� ����
		int cost = 0; //��� ���� ��

		block.get(location).playerToken(1, true); //�������� �÷��̾��� �� ��ġ��Ű��
		block.get(location).playerToken(2, true);
		clearScreen();
		map(); // ó�� �� ���� ���

		while (true) {
			if (Timeout.i != 0) { //���ѽð� ����� �ι��� �÷��̾���� �� ������ ���� ����
				if (((Island) (block.get(6))).isP1island()) { //���� true�̸� ���ε����� ���� ����.
					
					
					System.out.println("["+player.get(0).getName()+"]�� ���� ���ϴ�.");
					((Island) (block.get(6))).setP1island(false);//�ٽ� ���� false�� �ʱ�ȭ
				} else {
					System.out.println("["+player.get(0).getName()+"]���� �����Դϴ�!");
					location = player.get(0).getLocation(); // �ֻ��� ������ ���� ��ġ ��������
					block.get(location).playerToken(1, false); // ������ ��ġ�� ������ �� �� �����
					dice = player.get(0).dice(diceobj); // �ֻ��� ������ �� �� �������ֱ�
					player.get(0).move(dice); // �ֻ��� ����ŭ �÷��̾� location �������ִ� �Լ� ȣ��
					location = player.get(0).getLocation(); // �ֻ��� ������ �� ���� �÷��̾� ��ġ ��������
					block.get(location).playerToken(1, true); // ������ ��ġ�� ������ �� �� ǥ�����ֱ�
					clearScreen();
					map();
					if (block.get(location) instanceof City) { // ������ ���� �����̸�
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						City city = (City) (block.get(location));
						if (city.getOwner() == "        ") { // ������ ���� ������ ������
							player.get(0).buy(city); // ���� ������ �Ѵ�.
							clearScreen();
							map();
							System.out.println("�������� ��!!");
						} else if (city.getOwner().equals("Owner:p1")) { // �����Ѷ��� ������ �ڽ��̸�
							// �ƹ��ϵ� ���Ͼ��.
						} else if (city.getOwner().equals("Owner:p2")) { // ������ ���� ������ p2�̸�
							clearScreen();
							map();
							System.out.println("��� ���� �ɷȽ��ϴ�!!");
							cost = city.getCost(); // ���� ���� ��ȯ�ؼ� cost������ �־���
							System.out.println("�ݾ��� [" + cost + "����] �Դϴ�.");
							player.get(0).calculation(cost); // �÷��̾�� cost�� �ݾ׸�ŭ ����� �Ѵ�.
							if (player.get(0).getBudget() < 0) { //���� 0���̸� ���� ����
								break;
							}
						}
					} else if (block.get(location) instanceof Tax) {//������ ���� �����̸�
						clearScreen();
						map();
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						System.out.println("������ ���� �ϼ̽��ϴ�. ���� [100����]�� �����մϴ�.");
						Tax tax = (Tax) (block.get(location));
						cost = tax.getCost();
						player.get(0).calculation(cost);
						if (player.get(0).getBudget() < 0) {//���� 0���̸� ���� ����
							break;
						}
					} else if (block.get(location) instanceof StartArea) {//�������� �����Ұ��
						clearScreen();
						map();
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						System.out.println("�������� ���� �ϼ̽��ϴ�. ���� [50����]�� �޽��ϴ�.");
						StartArea startarea = (StartArea) (block.get(location));
						cost = startarea.getCost();
						player.get(0).calculation(-cost); //�� �߰�������ϱ� ������ -����
					} else if (block.get(location) instanceof Island) {//���ε� ������
						clearScreen();
						map();
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						System.out.println("���ε��� �����߽��ϴ�. �����ϱ��� ������ �� �����ϴ�.");
						Island island = (Island) (block.get(location)); 
						island.setP1island(true); //���� true�� ����
					}
				}
				//�÷��̾� 1������ ����
				if (((Island) (block.get(6))).isP2island()) {
				
					System.out.println("["+player.get(1).getName()+"]�� ���� ���ϴ�.");
					((Island) (block.get(6))).setP2island(false);
				} else {
					// player2
					System.out.println("["+player.get(1).getName()+"]���� �����Դϴ�!");
					location = player.get(1).getLocation(); 
					block.get(location).playerToken(2, false); 
					dice = player.get(1).dice(diceobj); 
					player.get(1).move(dice); 
					location = player.get(1).getLocation();
					block.get(location).playerToken(2, true); 
					clearScreen();
					map();
					if (block.get(location) instanceof City) { 
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						City city = (City) (block.get(location));
						if (city.getOwner() == "        ") { 
							player.get(1).buy(city); 
							clearScreen();
							map();
							System.out.println("�������� ��!!");
						} else if (city.getOwner().equals("Owner:p2")) { 
							
						} else if (city.getOwner().equals("Owner:p1")) { 
							cost = city.getCost(); 
							clearScreen();
							map();
							System.out.println("���� ���� �ɷȽ��ϴ�.");
							System.out.println("������ �ݾ��� [" + cost + "����] �Դϴ�!!");

							player.get(1).calculation(cost); 
							if (player.get(1).getBudget() < 0) {
								break;
							}
						}
					} else if (block.get(location) instanceof Tax) {
						clearScreen();
						map();
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						System.out.println("������ ���� �ϼ̽��ϴ�. ���� 100������ �����մϴ�.");
						Tax tax = (Tax) (block.get(location));
						cost = tax.getCost();
						player.get(1).calculation(cost);
						if (player.get(1).getBudget() < 0) {
							break;
						}
					} else if (block.get(location) instanceof StartArea) {
						clearScreen();
						map();
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						System.out.println("�������� ���� �ϼ̽��ϴ�. ���� 50������ �޽��ϴ�.");
						StartArea startarea = (StartArea) (block.get(location));
						cost = startarea.getCost();
						player.get(1).calculation(-cost);
					} else if (block.get(location) instanceof Island) {
						clearScreen();
						map();
						System.out.println("�ֻ��� ����� ["+dice+"] �Դϴ�.");
						System.out.println("���ε��� �����߽��ϴ�. �����ϱ��� ������ �� �����ϴ�.");
						Island island = (Island) (block.get(location));
						island.setP2island(true);
					}
				}
				
			} else {
				break;
			}
		}
		//���� ����� �κ� (������ ����� ��¥, �ð��� ���� �����Ѵ�.)
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("score.txt",true));
			String s = null;
			String date = "["+cal.calender()+"]";
			if (player.get(0).getBudget() < player.get(1).getBudget()) {
				s= player.get(1).getName() + "�� �¸�!! "+player.get(0).getName() + "�� �й�!!";
				out.write(date);
				out.newLine();
				out.write(s);
				out.newLine();
			} else {
				s=player.get(0).getName() + "�� �¸�!! "+player.get(1).getName() + "�� �й�!!";
				out.write(date);
				out.newLine();
				out.write(s);
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			System.out.println("��������");
		}
		System.out.println("������ ������ ����� ���� �Ǿ����ϴ�.");
	}
}
