package Quiz_;

class cardarr{
	String shape = "";
	String number = "";
	cardarr(){
		for(int i = 0 ; i < 4 ; i++) { //for문을 돌려서 S,D,C,H를 배열에 넣는다.
			if(i==0) {shape = "S";} 
			if(i==1) {shape = "D";}
			if(i==2) {shape = "C";}
			if(i==3) {shape = "H";}
			for(int j = 2 ; j < 15 ; j++) { //for문을 돌려서 2~10까지 넣고 J,Q,K,A는 바꿔서 넣는다.
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
				System.out.printf("[%s%s]",shape,number); // 형식에 맞게 출력한다.
						
				
			}System.out.println();	//줄을 바꾼다	
		
		}
		
	}
	
}
public class Quiz_2018_02_01_02 {
	public static void main(String[] args) {
		/*2. 카드 출력 (Hint: if / for 문을 이용 )
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
