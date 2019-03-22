package Quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class GradeCheck {
	static HashMap<Integer, Grade> map = new HashMap<>();
	static int count = 1;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GradeCheck gc = new GradeCheck();
		while(true){
			System.out.println("������  ����մϴ�!!!!");
			System.out.print("<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� : ");
	
			switch (scan.nextInt()) {
				case 1:
					gc.add();
					break;
				case 2:
					gc.delete();
					break;
				case 3:
					gc.print();
					break;
				case 4 :
					gc.save();
					break;
				case 5:
					gc.load();
					break;
				case 6:
					gc.exit();
					break;
				}
			}
	}
	
	private void save() {
		File file = new File("grade.txt");
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map);
			
			oos.close();
			fos.close();
		}catch(Exception e){
			System.out.println("�����߻�!!!");
			e.printStackTrace();
		}
		System.out.println("����Ǿ����ϴ�.");
	}

	private void exit() {
		System.out.println("�ý����� �����մϴ�.");
		System.exit(0);
		scan.close();
	}

	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("��ȣ\t����\t�ڹ�\t���̽�\t���\t����");
		for (Integer number : set) {
			double math = map.get(number).getMath();
			double java = map.get(number).getJava();
			double python = map.get(number).getPython();
			double avg = map.get(number).getAvg();
			String you = map.get(number).getYou();

			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n", number, math, java, python, avg, you);
		}
	}

	private void delete() {
		System.out.print("�����Ͻ� �ѹ��� �Է��� �ּ��� : ");
		int num = scan.nextInt();
		if (map.containsKey(num)) {
			map.remove(num);
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�. �ش� ������ �����ϴ�.");
		}
	}

	private void add() {
		Grade grade = new Grade();
		count = 0;
		for(int i = 0; i <= map.size(); i++) {
			count++;
			if (!map.containsKey(count)) {
				map.put(count, grade.input(grade));
				break;
			}
		}
	}
	
	private void load() {
		File file = new File("grade.txt");
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			map = (HashMap)oos.readObject();
			
			Set<Integer> set = map.keySet();
			System.out.println("��ȣ\t����\t�ڹ�\t���̽�\t���\t����");
			for (Integer number : set) {
				double math = map.get(number).getMath();
				double java = map.get(number).getJava();
				double python = map.get(number).getPython();
				double avg = map.get(number).getAvg();
				String you = map.get(number).getYou();

				System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n", number, math, java, python, avg, you);
			}
			oos.close();
			fis.close();
			
		}catch(Exception e){
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
}
