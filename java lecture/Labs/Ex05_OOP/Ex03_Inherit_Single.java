class Tv {
	boolean power;
	int ch;
	
	void power() {
		this.power = !this.power;
		
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class Vcr {
	boolean power;
	
	void power() {
		this.power = !this.power;
	}
	
	void play() {
		System.out.println("재생하기");
	}
	
	void stop() {
		System.out.println("정지");
	}
	
	void rew() {}
	void ff() {}
}

//Vcr기능과  Tv기능을 갖춘 설계도를 만들어 주세요. (Vcr이 내장된 Tv를 만들어 주세요.)
//설계도 이름은 TvVcr

//class TvVcr extends Tv, Vcr {} 다중상속(x)
//Tv extends Vcr
//TvVcr extends Tv (계층적 상속)

//선택: 둘중에 하나 상속, 포함
//어떤것 상속, 어떤것 포함
//Tv 상속 (주기능, 메인기능), Vcr 포함
//비중이 높은 클래스 => 상속

//둘다 포함 관계 (가능)
//class TvVcr {Tv t; Vcr v;}

//1. 계층적 상속
//2. 둘다 포함 관계
//3. 하나는 상속, 하나는 포함 => 주로 사용, 무조건은 아니다

class TvVcr extends Tv{ //확장합니다, 구체화합니다
	Vcr vcr;
	TvVcr() {
		vcr = new Vcr(); //vcr memory는 생성자에서
	}
}

public class Ex03_Inherit_Single {
	public static void main(String[] args) {
		TvVcr t = new TvVcr();
		t.power();
		System.out.println("Tv 전원상태: " + t.power);
		t.chUp();
		System.out.println("Tv 채널정보: " + t.ch);
		
		//비디오 켜보세요
		t.vcr.power(); //접근방법
		System.out.println(t.vcr.power);
		t.vcr.play();
		t.vcr.stop();
		t.vcr.power(); //비디오 전원 끄기
		t.power(); //Tv 전원
		System.out.println("Tv 전원: " + t.power);
		System.out.println("비디오 전원: " + t.vcr.power);
	}
}
