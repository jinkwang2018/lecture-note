package Quiz;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
import Quiz.BMI;

public class BMICheck {
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>();
	static int count = 1;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		BMICheck bc = new BMICheck();
		while(true){
		System.out.println("�񸸵� �����մϴ�!!!!");
		System.out.print("<1>�߰� <2>���� <3>��� <4>���� <5>�ε� <6>���� : ");

		switch (scan.nextInt()) {
		case 1:
			bc.add();
			break;
		case 2:
			bc.delete();
			break;
		case 3:
			bc.print();
			break;
		case 4 :
			bc.save();
			break;
		case 5:
			bc.load();
			break;
		case 6:
			bc.exit();
			break;

		}// switch
		}//while
	}// main

	private void save() {
		File file = new File("bmi.txt");
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
		System.out.println("��ȣ\tŰ\t������\t���\t����");
		for (Integer number : set) {
			double length = map.get(number).getLength();
			double weight = map.get(number).getWeight();
			double result = map.get(number).getResult();
			String you = map.get(number).getYou();

			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
		}
	}

	private void delete() {
		System.out.print("�����Ͻ� �ѹ��� �Է��� �ּ��� : ");
		int num = scan.nextInt();
		if (map.containsKey(num)) {
			map.remove(num);
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("���ѹ��� �߸��Է��ϼ̽��ϴ�. �ش� ������ �����ϴ�.");
		}
	}

	private void add() {
		BMI bmi = new BMI();
		map.put(count, bmi.input(bmi));
		count++;
	}
	
	private void load() {
		File file = new File("bmi.txt");
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			map = (HashMap)oos.readObject();
			
			Set<Integer> set = map.keySet();
			System.out.println("��ȣ\tŰ\t������\t���\t����");
			for (Integer number : set) {
				double length = map.get(number).getLength();
				double weight = map.get(number).getWeight();
				double result = map.get(number).getResult();
				String you = map.get(number).getYou();

				System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
			}
			oos.close();
			fis.close();
			
		}catch(Exception e){
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
}// class
