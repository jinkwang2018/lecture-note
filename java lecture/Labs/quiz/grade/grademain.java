package grade;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

public class grademain {
	static HashMap<Integer, Key> map = new HashMap<Integer, Key>();
	static int count = 0;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		grademain m = new grademain();
		while(true) {
			System.out.println("성적관리 시스템입니다.");
			System.out.println("<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 : ");
			int i = scan.nextInt();
			switch(i) {
			case 1 : m.add();
			break;
			case 2 : m.del();
			break;
			case 3 : m.print();
			break;
			case 4 : m.save(); 
			break;
			case 5 : m.load();
			break;
			case 6 : m.exit();
			break;
			}
		}
	}
	public void add() {
		Key grade = new Key();
		map.put(count , grade.input(grade));
		count++;
		
	}
	public void del() {
		System.out.println("삭제할 데이터의 숫자를 입력해 주세요");
		int num = scan.nextInt();
		if(map.containsKey(num)) {
			map.remove(num);
			System.out.println(num+"번째의 데이터가 삭제 되었습니다.");
		}else {
			System.out.println("존재하지 않는 번호 입니다.");
			
		}
	}

	public void print() {
		Set<Integer> set = map.keySet();
		System.out.println("수학\t자바\t파이선\t평균\t학점");
	
			for (int i = 0; i < map.size(); i++) {
				for (Integer key : set) {
					double math = map.get(key).getMath();
					double java = map.get(key).getJava();
					double phyton = map.get(key).getPython();
					double average = map.get(key).getAvg();
					String you = map.get(key).getYou();
					
					System.out.printf("%.2f \t %.2f \t %.2f \t %.2f \t %S\n", math, java, phyton, average, you);

				}

			}
		} 
	

	public void save() {
		File file = new File("grade.txt");
		FileOutputStream fo = null;
		BufferedOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			fo = new FileOutputStream(file);
			bo = new BufferedOutputStream(fo);
			oo = new ObjectOutputStream(bo);

			oo.writeObject(map);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				oo.close();
				bo.close();
				fo.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	public void load() {
		String filename = "grade.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			
			map = (HashMap)in.readObject();
			Set<Integer> set = map.keySet();
			System.out.println("수학\t자바\t파이선\t평균\t학점");
			for(Integer i : set) {
				double math = map.get(i).getMath();
				double java = map.get(i).getJava();
				double phyton = map.get(i).getPython();
				double average = map.get(i).getAvg();
				String you = map.get(i).getYou();			
				System.out.printf("%.2f \t %.2f \t %.2f \t %.2f \t %S\n", math, java, phyton, average, you);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	}
	public void exit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close();
	}

}
