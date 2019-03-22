package Quiz_;

import java.util.Scanner;

class Java_104{
	String name;
	String sex;
	int age;
	int cm;
	int kg;
	public Java_104(String name, String sex, int age, int cm, int kg) {
		this.name = name; //parameter 5개를 java_104 class에 담는다.
		this.sex = sex;
		this.age = age;
		this.cm = cm;
		this.kg = kg;
	}
}
class pri{
	Java_104 [] arr= new Java_104[] {new Java_104("yoon","male",28,180,100),
			new Java_104("jun","male",29,180,80),new Java_104("jin","male",28,172,75),
			new Java_104("tae","male",26,180,75),new Java_104("ah","female",27,165,50),
			new Java_104("ju","male",25,180,60)}; //Java_104 배열에 정보를 담는다. 
	void display() {
		print();
		System.out.println("찾으시는 학생의 이름을 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		String stt = sc.nextLine(); //이름을 입력 받는다.
		print(stt); //입력 받은 이름에 맞는 정보를 출력해준다.
		
	}
	void print() {
	for(Java_104 Info : arr) {
		System.out.printf("[%s,%s,%d,%d,%d]\n",Info.name,Info.sex,Info.age,Info.cm,Info.kg);
	}
	}
	void print(String stt) {
		for(Java_104 Info : arr) {
			if(Info.name.equals(stt)) {
				System.out.printf("[%s,%s,%d,%d,%d]\n",Info.name,Info.sex,Info.age,Info.cm,Info.kg);
			}
			
		}
	}
	
	
	
	
}

public class Quiz_2018_02_01_03 {

	public static void main(String[] args) {
		/*
		3. 비트학원 자바 104기 2조 인원의 클래스를 만들고 배열에 저장하고 불러오기.
		* 필수

		이름, 성별, 나이, 키, 몸무게

		* 기능

		 - 저장된 모든 사람의 이름, 성별, 나이, 키, 몸무게 출력하기. 개선for

		 - 이름을 통해 그 사람의 성별, 나이, 키, 몸무게 출력하기.
		*/
		pri arr1 = new pri();
		arr1.display();
		

	}

}
