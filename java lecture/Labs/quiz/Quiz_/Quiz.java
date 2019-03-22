package Quiz_;

public class Quiz {
		public static void main(String[] args) {
			for (int i = 10; i >= 1; i--) {          //i가 10부터 1까지 1씩 감소하면서 for문으로 들어간다. i가 0이 되면 종료된다.
				for (int j = 1; j <= 10; j++) {      //j가 1부터 10까지 1씩 증가하면서 for문으로 들어간다. j가 11이 되면 종료된다.
					if (i == j) break;               //들어온 i값과 j값이 같을 때에는 바깥의 for문으로 빠져나간다.
				System.out.printf("%s", "*");        //i값과 j값이 같게 나오기 전까지 *을 출력하고 같게 나온 이후에는 별을 출력하지 않는다.
				}
				System.out.println();                //줄바꿈
			}

			for (int k = 1; k <= 10; k++) { //k가 1부터 10까지 1씩 증가하면서 for문으로 들어간다. k가 11이 되면 종료된다.
				for (int p = 1; p <= 10; p++) { //p가 1부터 10까지 1씩 증가하면서 for문으로 들어간다. p가 11이 되면 종료된다.
					if (k <= p) {              //들어온 k와 p값을 비교하여 서로 다른 것을 출력하게 한다. 
						System.out.printf("%s", "*"); //k값이 p보다 작으면 출력되는 *
					} else {
						System.out.printf("%s", " "); //k값이 p보다 크면 출력되는 빈칸
					}
				}System.out.println();//줄바꿈
			}
		}
}
