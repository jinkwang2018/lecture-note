package BlueMarble;
class Block {
	int num; // ĭ�� ��ȣ
	private String name; // ĭ�� �̸�
    String p1 = "  "; // �÷��̾� 1�� ��
	String p2 = "  "; // �÷��̾� 2�� ��

	public String getName() {
		return name;
	}

	public Block(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public void playerToken(int who, boolean exist) { // who � �÷��̾�  exist���� ������ ǥ������
		if (who == 1) {
			if (exist == false) {
				p1 = "  "; // �÷��̾�1�� ���� �����.
			} else {
				p1 = "P1"; // �÷��̾�1�� ���� ǥ���Ѵ�.

			}

		} else if (who == 2) {
			if (exist == false) {
				p2 = "  "; 
			} else {
				p2 = "P2"; 
			}

		}
	}
}

class City extends Block {
	private int land; // ���� ����
	private int landpay; // ���� �ɷ����� �����ϴ� ����
	private int hotel; // ȣ���� ����
	private int hotelpay; // ȣ�ڿ� ������� �����ϴ� ����
	private int building; // ������ ����
	private int buildingpay; // ������ ������� �����ϴ� ����
	private String owner= "        "; // �� ������
	private int cost; 
	private String structure = "   ";
	
	public City(int num, String name, int land, int landpay, int hotel, int hotelpay,
			int building, int buildingpay) {
		super(num, name);
		this.land = land;
		this.landpay = landpay;
		this.hotel = hotel;
		this.hotelpay = hotelpay;
		this.building = building;
		this.buildingpay = buildingpay;

	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public void setOwner(int id) { //���� ������ �������� ǥ��
		switch(id) {
		case 1: this.owner = "Owner:p1";
			break;
		case 2: this.owner = "Owner:p2";
			break;	
		}
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getLandpay() {
		return landpay;
	}

	public int getHotelpay() {
		return hotelpay;
	}

	public int getBuildingpay() {
		return buildingpay;
	}

	public int getCost() {
		return cost;
	}
	public int getLand() {
		return land;
	}
	public int getHotel() {
		return hotel;
	}
	public int getBuilding() {
		return building;
	}
	public String getOwner() {
		return owner;
	}
}

class Tax extends Block { //���� Ŭ����
	private int cost= 100;  //���� ���
	public Tax(int num, String name) {
		super(num, name);
	}
	public int getCost() {
		return cost;
	}
}
class StartArea extends Block { //������ Ŭ����
	private int cost= 50; //������ ����
	public StartArea(int num, String name) {
		super(num, name);
	}
	public int getCost() {
		return cost;
	}
}

class Island extends Block { //���ε� Ŭ����
	private boolean p1island = false; //�÷��̾� 1�� ���ε��� �ɷ����� true�� �ٲ��.
	private boolean p2island = false; //�÷��̾� 2�� ���ε��� �ɷ����� true�� �ٲ��.
	public Island(int num, String name) {
		super(num, name);
	}
	public boolean isP1island() {
		return p1island;
	}
	public void setP1island(boolean p1island) { 
		this.p1island = p1island;
	}
	public boolean isP2island() {
		return p2island;
	}
	public void setP2island(boolean p2island) {
		this.p2island = p2island;
	}

	

}



