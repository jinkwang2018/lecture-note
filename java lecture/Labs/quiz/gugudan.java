
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

class Thread1 extends Thread {

	@Override
	public void run() {

		for (int i = 30; i >= 0; i--) {

			try {
				System.out.println("남은 시간은 : " + i + "입니다.");
				sleep(1000);
				if (gugudan.i == false) {
					return;
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		gugudan.timeout = true;
	}

}

class Thread2 extends Thread {

	@Override
	public void run() {
		gugudan.timeout = false;
		gugudan.i = true;

		Map<Integer, String> map = new HashMap();
		for (int a = 0; a < 5; a++) {

			int i = (int) ((Math.random() * 8) + 1);
			int j = (int) ((Math.random() * 8) + 1);
			int k = i * j;
			System.out.println(i + "*" + j + "의 값은?");
			System.out.println("답을 입력하세요");
			
			Scanner Sc = new Scanner(System.in);
			
			int l = 0 ;
			try {
			   l = Integer.parseInt(Sc.nextLine());
			}catch(Exception e) {
				System.out.println("숫자가 아닙니다.");
			}
				
			
			System.out.println("입력값은 : " + l + "입니다.");
			if (k == l) {
				System.out.println("정답입니다.");
				map.put(a + 1, "O");
			} else {
				System.out.println("오답입니다.");
				map.put(a + 1, "X");
			}

			if (gugudan.timeout == true) {
				System.out.println("시간초과되었습니다.");
				break;
			}
		}
		gugudan.i = false;

		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + "\t" + m.getValue());
		}

	}

}

public class gugudan {

	public static boolean i;
	public static boolean timeout;

	public static void main(String[] args) {
		Thread1 timer = new Thread1();
		Thread2 cha = new Thread2();
		cha.start();
		timer.start();

	}

}
