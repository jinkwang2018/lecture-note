package Quiz_;

class cardarr{
	String shape = "";
	String number = "";
	cardarr(){
		for(int i = 0 ; i < 4 ; i++) { //for���� ������ S,D,C,H�� �迭�� �ִ´�.
			if(i==0) {shape = "S";} 
			if(i==1) {shape = "D";}
			if(i==2) {shape = "C";}
			if(i==3) {shape = "H";}
			for(int j = 2 ; j < 15 ; j++) { //for���� ������ 2~10���� �ְ� J,Q,K,A�� �ٲ㼭 �ִ´�.
				number = Integer.toString(j);
				switch(j){
				case 11 : number = "J";
				break;
				case 12 : number = "Q";
				break;
				case 13 : number = "K";
				break;
				case 14 : number = "A";
				
				}
				System.out.printf("[%s%s]",shape,number); // ���Ŀ� �°� ����Ѵ�.
						
				
			}System.out.println();	//���� �ٲ۴�	
		
		}
		
	}
	
}
public class Quiz_2018_02_01_02 {
	public static void main(String[] args) {
		/*2. ī�� ��� (Hint: if / for ���� �̿� )
		Spade / Diamond / Club / Heart
		2, 3, 4, 5, 6, 7, 8, 9, 10, J (jack),Q (queen), K (king), A (ace)

		ex)
		S2 S3 S4 S5 S6......... SK SA
		D2 D3 D4 D5 D6......... DK DA
		C2 C3.........  CK CA
		H2 H3.........  HK HA
		*/
		
		cardarr arr = new cardarr();
		
		
		
		
		
		
	}


}
