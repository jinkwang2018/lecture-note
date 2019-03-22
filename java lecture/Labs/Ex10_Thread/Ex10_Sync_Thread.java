//은행계좌를 하나 가지고 있다
//은행계좌를 통해 입금, 출금 처리를 할 수 있다

//친구 5명(똑같은 카드)
//동시에 계좌 출금 ('동시'라는 말은 쓰레드를 쓰겠다!의 의미)

//통장 1000만원
//ATM 기기에서 동시에 출금

//개발자
//누군가 [출금 ~ 행위] 끝날때 까지 LOCK 통해서 자원 보호

class Account{ //계좌
	int balance = 1000; //잔액
	 synchronized void withDraw(int money) { //출금
		System.out.println("고객 : " + Thread.currentThread().getName());
		System.out.println("현재 잔액 : " + this.balance);
		if(this.balance >= money) {
			try {
				Thread.sleep(1000); //은행업무 처리되는 과정(인증 ,카드 확인....)
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.balance -= money;
		}
		System.out.println("인출금액 : " + money);
		System.out.println("인출후 잔액 :" + this.balance);
	}
}

class Bank implements Runnable{
	Account acc = new Account();
	@Override
	public void run() {
		while(acc.balance > 0) {
			
			int money = ((int)(Math.random()*3)+1)*100;
			//실 출금 처리
			acc.withDraw(money);
		}
	}
}

//class T extends Thread{}

public class Ex10_Sync_Thread {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Thread th = new Thread(bank,"Park");
		Thread th2 = new Thread(bank,"Kim");
		Thread th3 = new Thread(bank,"Lee");
		
		/* class T extends Thread{}의 경우 Thread의 이름을 설정하는 방법
		T t = new T();
		t.setName("Park");
		*/
		
		th.start();
		th2.start();
		th3.start();
	}
}
