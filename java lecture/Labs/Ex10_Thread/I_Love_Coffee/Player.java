package I_Love_Coffee;

import java.util.ArrayList;

public class Player {
	String playerName;
	private int popularity;
	private int level;
	private int score;
	private String order;
	private int time;

	boolean falseOrder;
	private int sucessOrder;
	
	NPC npc;

	public int getTime() {
		return time;
	}

	public Player() {
		this.popularity = 100;
		this.level = 10;
		this.score = 0;
		this.order = "";
		this.time = 0;
		this.falseOrder = false;
		this.sucessOrder = 0;
	
	}

	public String getRandMenu() {
		return order;
	}

	public void setRandMenu(String randMenu) {
		this.order = randMenu;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPopularity() {
		if (popularity < 0)
			popularity = 0;
		if(popularity >= 100)
			popularity=100;
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public boolean getFalseOrder(){
		return this.falseOrder;
	}


	private int popularityMinus() {
		popularity -= 20;
		return popularity;
	}

	private int popularityPlus() {
		popularity += 10;
		return popularity;
	}

	public int LevelUp(){
		level = (score/200)+1;
		if(level > 10) level =10;
		return level;
	}

	private int scorePlus() {
		score += 50;
		return score;
	}
	

	public void playGame() {
		sucessOrder=0;
		npc = new NPC(level);
		order = npc.getMenu(); // recipe key 값 추출
		time = npc.getTime(); // 남은 시간 추출
	}
	
	public void timeover(){
		popularityMinus();
		npc.setFalseOreder(falseOrder);//쓰레드 종료
		playGame();
	}
	
	public void btn_compare(String btnStr, int materials_count){
		materials_count = materials_count-1;
		Recipe recipe = new Recipe();
		//System.out.println("btnStr" + btnStr); //버튼이름 
		ArrayList<String> order_list = recipe.getMenu_List().get(order); // 키값으로 받은 레시피 추출
		//System.out.println(order_list.toString());
		//System.out.println("order.get("+materials_count+")" + order_list.get(materials_count));
		falseOrder = compareRecipe(order_list, btnStr, materials_count); // 레시피 순서 비교
		npc.setFalseOreder(falseOrder); // npc 쓰레드 종료
		if(falseOrder){
				playGame();
		}
	}

	public boolean compareRecipe(ArrayList<String> order, String btnStr,
			int recipeIndex) {
		this.falseOrder = false;
		
		if (!(order.get(recipeIndex).equals(btnStr))) {
			System.out.println("재료 틀림");
			popularityMinus();
			falseOrder = true;
			sucessOrder=0;
		}else sucessOrder++;
		
		if (order.size()==sucessOrder){
			System.out.println("완성");
			popularityPlus();
			scorePlus();
			LevelUp();
			falseOrder = true;
		}
		return falseOrder;
	}
}
