package Quiz_;

import java.util.Scanner;

class Java_104{
	String name;
	String sex;
	int age;
	int cm;
	int kg;
	public Java_104(String name, String sex, int age, int cm, int kg) {
		this.name = name; //parameter 5���� java_104 class�� ��´�.
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
			new Java_104("ju","male",25,180,60)}; //Java_104 �迭�� ������ ��´�. 
	void display() {
		print();
		System.out.println("ã���ô� �л��� �̸��� �Է��� �ּ���");
		Scanner sc = new Scanner(System.in);
		String stt = sc.nextLine(); //�̸��� �Է� �޴´�.
		print(stt); //�Է� ���� �̸��� �´� ������ ������ش�.
		
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
		3. ��Ʈ�п� �ڹ� 104�� 2�� �ο��� Ŭ������ ����� �迭�� �����ϰ� �ҷ�����.
		* �ʼ�

		�̸�, ����, ����, Ű, ������

		* ���

		 - ����� ��� ����� �̸�, ����, ����, Ű, ������ ����ϱ�. ����for

		 - �̸��� ���� �� ����� ����, ����, Ű, ������ ����ϱ�.
		*/
		pri arr1 = new pri();
		arr1.display();
		

	}

}
