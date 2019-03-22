class Car{
	String color;
	int door;
}


public class Ex05_Array2_Basic {
	public static void main(String[] args) {
		//2차원 (행과 열)
		//[행][열]
		int[][] score = new int[3][2];
		System.out.println(score[0][0]);
		System.out.println(score[2][1]);
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		System.out.println(score.length); //행의 수
		//행의 개수: 배열이름.length > score.length
		//열의 개수: 배열이름[i].length > score[0].length
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				System.out.printf("score[%d][%d] = %d\n", i, j, score[i][j]);
			}
			System.out.println();
		}
		
		//Today Point(Array (정적배열) >> Collection((동적배열)java에서 가장 중요 *****)
		//Today for문 >> 개선된 for문
		//C#: for(Type변수명 in 배열 or 컬렉션) { 출력구문 } => JavaScript와 동일
		//JAVA: for(Type변수명 : 배열 or 컬렉션) { 출력구문 }
		
		int[] arr3 = {5, 6, 7, 8, 9, 10};
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		for(int v : arr3) {
			System.out.println(v);
		}
		
		String[] sarr = {"A", "B", "C", "D", "FFFF"};
		for(String s : sarr) {
			System.out.println(s);
		}
		
		//센스퀴즈
		//커피
		//3행2열
		int[][] score3 = new int[][] {
			{11, 12},
			{13, 14},
			{15, 16}
		};
		
		//개선된 for문 사용해서 값을 출력하세요
		//11, 12
		//score3 가지고 있는 것은 행배열의 주소값
		
		//**그려보기
		for(int[] rows : score3) {
			for(int value: rows) {
				System.out.println("값: " + value);
			}
		}
		
		//객체 배열
		Car[] cararr = new Car[2];
		cararr[0] = new Car();
		cararr[0].color = "red";
		cararr[0].door = 4;
		
		cararr[1] = new Car();
		cararr[1].color = "blue";
		cararr[1].door = 2;
		
		//일반 for문 자동차, 색상, 문의 개수
		for(int i = 0; i <cararr.length; i++) {
			System.out.println(cararr[i].color + "/" + cararr[i].door);
		}
		
		//개선된 for
		for(Car obj : cararr) {
			System.out.println(obj.color + "/" + obj.door);
		}
	}
}
