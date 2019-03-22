//우선순위: CPU 점유율을 높이겠다
//default: 5 (Max: 10, Min: 1)

class Pth extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("-----------");
		}
	}
}

class Pth2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("||||||||||");
		}
	}
}

class Pth3 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("**********");
		}
	}
}

public class Ex06_priority {
	public static void main(String[] args) {
		Pth ph = new Pth();
		Pth2 ph2 = new Pth2();
		Pth3 ph3 = new Pth3();
		
		System.out.println(ph.getPriority()); //기본값: 5
		System.out.println(ph2.getPriority());
		System.out.println(ph3.getPriority());
		
		ph.setPriority(10); //먼저 끝나길 원해요 ----------
		//ph3.setPriority(1); //나중에 **********
		
		ph.start();
		ph2.start();
		ph3.start();
		
		System.out.println("Main END...");
	}
}












