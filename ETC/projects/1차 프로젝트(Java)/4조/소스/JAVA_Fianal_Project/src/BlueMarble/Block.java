package BlueMarble;
class Block {
	int num; // 칸의 번호
	private String name; // 칸의 이름
    String p1 = "  "; // 플레이어 1의 말
	String p2 = "  "; // 플레이어 2의 말

	public String getName() {
		return name;
	}

	public Block(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public void playerToken(int who, boolean exist) { // who 어떤 플레이어  exist말을 지울지 표시할지
		if (who == 1) {
			if (exist == false) {
				p1 = "  "; // 플레이어1의 말을 지운다.
			} else {
				p1 = "P1"; // 플레이어1의 말을 표시한다.

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
	private int land; // 땅의 가격
	private int landpay; // 땅에 걸렸을때 지불하는 가격
	private int hotel; // 호텔의 가격
	private int hotelpay; // 호텔에 결렸을때 지불하는 가격
	private int building; // 빌딩의 가격
	private int buildingpay; // 빌딩에 결렸을때 지불하는 가격
	private String owner= "        "; // 땅 소유자
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

	public void setOwner(int id) { //땅의 주인이 누구인지 표시
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

class Tax extends Block { //세관 클래스
	private int cost= 100;  //세금 비용
	public Tax(int num, String name) {
		super(num, name);
	}
	public int getCost() {
		return cost;
	}
}
class StartArea extends Block { //시작점 클래스
	private int cost= 50; //시작점 월급
	public StartArea(int num, String name) {
		super(num, name);
	}
	public int getCost() {
		return cost;
	}
}

class Island extends Block { //무인도 클래스
	private boolean p1island = false; //플레이어 1이 무인도에 걸렸을때 true로 바뀐다.
	private boolean p2island = false; //플레이어 2가 무인도에 걸렸을때 true로 바뀐다.
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



