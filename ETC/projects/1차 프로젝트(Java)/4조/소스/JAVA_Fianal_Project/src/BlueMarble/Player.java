package BlueMarble;

import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Player {
	
	private int id; // �÷��̾� id
	private String name;//�̸�
	private int location = 1;// ������ġ
	private int budget=500; // ����
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getLocation() {
		return location;
	}
	public int getBudget() {
		return budget;
	}
	public int dice(Dice dice) {   // �ֻ��� ������ �� �� �������ִ� �Լ�
		int dicetemp=0;
		System.out.println("****�ֻ����� �����ּ���****");

		while(dicetemp==0) {            //�Է°����� �׽�Ʈ�� �ϰ� �����ø� ������� ������ �ּ�ó���ϰ� �Ʒ� �ּ��� Ǯ���ּ��� 
			dicetemp = dice.diceNum();
			System.out.print("");
		}
		
//		Scanner s = new Scanner(System.in); //�Ʒ� ���� : �׽�Ʈ�� �Է� 
//		dicetemp = s.nextInt();
		
		return dicetemp;  //�ֻ��� �� ����
	}
	public void move(int diceNumber) {  //�̵��ϴ� �Լ� 18�� ���� �������� �־ ��ȯ �ϵ��� ����
		location = (location+diceNumber)%18;
		if(location == 0) {
			location = 18;
		}
	}

	void buy(City city) { //�ǹ� ���� �Լ�
		int choice =0;
		if (city.getLand() < budget) {  //���� ���� ���ݺ��� ������ ��� ����.
			while (true) {
				Scanner s = new Scanner(System.in);
				System.out.println("������ �����Ͻðڽ��ϱ�?");
				System.out.println("�� :1  ȣ�� :2  ���� :3 �Ȼ�� :4");

				choice = Integer.parseInt(s.nextLine());
				if(choice == 1) {
					budget -= city.getLand();          //�� ���ݸ�ŭ ���� ����
					city.setCost(city.getLandpay());  //������ �Ϳ� �´� ����� ����
					city.setStructure("[L]");         //�� ǥ�� 
					break;
				}else if(choice == 2) {
					if(city.getHotel()<budget) {      //�̵����� ȣ���� ��� �ִ��� Ȯ��
						budget -= city.getHotel();      //ȣ�� ���ݸ�ŭ ����
						city.setCost(city.getHotelpay());  //����� ����
						city.setStructure("[H]");          //ȣ�� ǥ��
						break;
					}else {                              //���� �����ҽ�
						System.out.println("ȣ���� ��⿣ ���� �����մϴ�.");
					}
				}else if(choice == 3) {
					if(city.getBuilding()<budget) {   //���� ����
						budget -= city.getBuilding();
						city.setCost(city.getBuildingpay());
						city.setStructure("[B]");
						break;
					}else {
						System.out.println("������ ��⿣ ���� �����մϴ�.");
					}
				}else if(choice == 4) {
					System.out.println("�ƹ��͵� ���� �ʽ��ϴ�.");
					break;
				}else{
					System.out.println("1,2,3,4 �߿� �ϳ��� ������ �ּ���!");
				}
				
				
				
			}
			if(choice != 4) {
				city.setOwner(id);   //���� ǥ�� 
			}
		} else {
			System.out.println("���� �����մϴ�.");
		}

	}
	
	void calculation(int cost) {
		budget -= cost;
	}
}
