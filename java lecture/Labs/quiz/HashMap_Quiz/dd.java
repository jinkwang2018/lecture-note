package HashMap_Quiz;

public class dd {

	public static void main(String[] args) {
		String[][] seat = new String[4][9];
		
		for(int i = 0 ; i < seat.length ; i++) {
			for(int j = 0 ; j < seat[i].length ; j++) {
				if(j==0) {
				 seat[i][j] = i+"열";
				}else{seat[i][j] = j+"◻︎";}
				System.out.printf("%s " , seat[i][j]);
			}System.out.println();
			
		}
		

	}

}
