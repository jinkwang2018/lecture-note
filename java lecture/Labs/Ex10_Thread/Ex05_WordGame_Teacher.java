import javax.swing.JOptionPane;

/*
  문제
 main 함수 제외한 Thread 2개 추가
 1. 시간(time) 제어하는 Thread
 2. 단어 입력을 처리하는 Thread
 
 main 함수 2개 실행
 
 단  단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추게 하세요
hint() 공유자원 
   
*/

class WordInputProcess extends Thread{
	@Override
	public void run() {
		String dan="2";
		String inputdata = JOptionPane.showInputDialog("dan" + "단 값을 입력");
		if(inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame_Teacher.inputcheck = true;
		}
		System.out.println("입력한 값은: " + inputdata);
	}
}


class WordTimeOut extends Thread{
	@Override
	public void run() {
		for(int i=10; i > 0 ; i--) {
			
			if(Ex05_WordGame_Teacher.inputcheck)return; //run함수 탈출
			
			System.out.println("남은 시간: " + i);
			try {
				 Thread.sleep(1000); //대기실에서 1초간 쉬었다 ....
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex05_WordGame_Teacher {
	//변수 : static 
	static boolean inputcheck= false;
	public static void main(String[] args) {
		WordInputProcess word = new WordInputProcess();
		WordTimeOut time = new WordTimeOut();
		
		word.start();
		time.start();
		
		
		try {
			word.join(); //main Thread에게 내가 끝날때까지 기다려 달라 함
			time.join(); ////main Thread에게 내가 끝날때까지 기다려 달라 함
			//Join 메소드는 하나의 스레드가 다른 스레드가 하는 일이 완료될 때 까지 기다리도록 할 때 쓰인다. 가령 현재 돌아가고 있는 스레드(A)에서 또 다른 스레드(B) 가 완료될 때 까지 기다리려고 한다면, 
            //B.join();
            //이렇게 호출 해주면 된다. 이렇게 하면,  
			//현재 돌아가고 있는 스레드 A 는 스레드 B 가 하는 일이 마칠 때 까지, 멈춰있게(pause) 된다. join 메소드를 오버로딩(overloading) 한 메소드 들이 있는데 이 메소드들은 개발자가 얼마 동안 멈춰있게 할 지를 결정할 수 있다. 
		}catch (Exception e) {
			
		}
		System.out.println("Main END");
		
	}
	
}
/*
4. join() : 다른 스레드의 종료를 기다림

계산 작업을 하는 스레드가 모든 계산 작업을 마쳤을 때, 계산 결과값을 받아 이용하는 경우 사용한다. 

ThreadA가 ThreadB의 join() 메소드를 호출하면 ThreadA는 ThreadB가 종료할 때까지 일시 정지 상태가 된다.
ThreadB의 run() 메소드가 종료되면 ThreadA는 일시 정지에서 풀려 남아있는 코드를 실행한다. 
http://cafe.naver.com/bitcamp104/537

*/