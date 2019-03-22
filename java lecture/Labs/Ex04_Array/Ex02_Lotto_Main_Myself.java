import java.util.Arrays;

/*
(main함수 안에서)
1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (다시 난수)
3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요
4. 위 결과를 담고 있는 배열을 출력하세요
 */
public class Ex02_Lotto_Main_Myself {
	public static void main(String[] args) {
		// 6개의 배열 생성
		int[] arr = new int[6];
		
		// 난수 발생 (기능), 6개의 배열 담기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			for(int j = 0; j < i; j++) {
				if(i != j) {
					if(arr[i] == arr[j]) {
						do { // 6개 중복값 X 처리
							arr[i] = (int)(Math.random() * 45 + 1);
						}while(arr[i] == arr[j]);
					}
				}
			}	
		}
		
		System.out.println("생성값: " + Arrays.toString(arr)); // 난수 발생 확인
		
		// 낮은 순 정렬
		int temp = 0;
		int cnt = 0;
		
		do {
			cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[i]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
				
						cnt++;
						break;
					}
				}
			}
		}while(!(cnt == 0));
		
		// 출력
		System.out.println("정렬값: " + Arrays.toString(arr));
	}
}
