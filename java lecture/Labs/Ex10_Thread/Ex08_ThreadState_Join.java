//Thread : state 정보(동작 , 멈춤 ....)
//state 정보를 강제 :Thread 가지는 생성자 , 함수
//sleep() , join()

//복잡한 계산을 여러개의 쓰레드로 나누어서 처리
//그 계산 결과를 참조해서 최종적인 결과를 만들고 싶어요

//Thread  동시 처리할때 (누가 먼저 수행될지 알수 없다) 

//main 함수 Thread ,,, 다른 여러개 Thread
//main Thread 가 다른 쓰레드가 끝날때 까지 기다리게 ... 

//기다리는 녀석이 각각의 Thread 요청 (join())

class Thread_join extends Thread{
	@Override
	public void run() {
		for(int i=0; i < 3000 ;i++) {
			System.out.println("----------");
		}
	}
}

class Thread_join2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i < 3000 ;i++) {
			System.out.println("||||||||||");
		}
	}
}
public class Ex08_ThreadState_Join {

	public static void main(String[] args) {
		Thread_join th = new Thread_join();
		Thread_join2 th2 = new Thread_join2();
		
		th.start();
		th2.start();
		
		long starttime = System.currentTimeMillis();
		
		try {
			  th.join();
			  th2.join();
			  //main 요청 ....
			  //main 나 기다릴거야 th , th2 작업이 끝날때까지
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for(int i = 0 ; i < 3000 ;i++) {
			System.out.println("^^^^^^^^");
		}
		
		//3개의 쓰레드가 실행한 결과(총 걸린 시간)
		System.out.println("3개의 쓰레드 총 작업 시간 :");
		System.out.println(System.currentTimeMillis());
		System.out.println(starttime);
		System.out.println(System.currentTimeMillis()-starttime);
		System.out.println("Main END");
	}

}
