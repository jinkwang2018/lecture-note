package Quiz_;

public class Quiz2 {
	public static void main(String[]args) {
		
		for(int i = 65 ; i<=90 ; i++) {
			char j =(char)i;
			System.out.println(j);
		}
		
		for(int a = 0 ; a <=9  ; a++) {
			a*=10;
			for(int b = 1 ; b<=10 ; b++) {
				System.out.printf("%d \t" , a+b);
			}
			a/=10;
			System.out.println();
		}
		
	}
		
}


