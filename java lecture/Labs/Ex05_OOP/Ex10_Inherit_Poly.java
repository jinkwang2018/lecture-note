//다형성(상속관계에서)
//다형성: 여러가지 성질(형태)를 가질 수 있는 능력
//C#: 다형성 안에 overloading, override 포함
//java: [상속관계]에서 하나의 [참조변수]가 여러개의 [타입]을 가질 수 있다
//참조변수는 부모타입을 이야기 한다
//조상클래스 타입의 참조변수로 여러개의 자식클래스 객체를 참조 가능

//java: 자식은 부모에게 조건없이 드린다 (현실세계와 반대)

class Tv2 { //부모 (일반화, 추상화) 공통
	boolean power;
	int ch;
	void power() {
		this.power = !this.power;
	}
	void chUp() {
		ch++;
	}
	void chDown() {
		ch--;
	}
}

//Tv2 클래스
class CapTv extends Tv2 { //특수화, 구체화, 고유한 내용
	String text;
	String caption() {
		return this.text = "현재 자막 처리 중...";
	}
}

public class Ex10_Inherit_Poly {
	public static void main(String[] args) {
		CapTv tv = new CapTv();
		tv.power();
		System.out.println("전원: " + tv.power);
		tv.chUp();
		System.out.println("채널정보: " + tv.ch);
		System.out.println("자막처리: " + tv.caption());
		//기존까지 배운 내용
		
		//Tv2 tv2 = new Tv2();
		//어차피 Tv2 타입의 객체는 heap memory에 있는데 굳이 또 heap memory에 올릴 필요가 있을까?
		
		Tv2 tv2 = tv; // CapTv는 부모타입으로 Tv2를 가지고 있어야 한다
		//tv2 타입 참조변수는 Tv2 객체의 자원만 접근이 가능
		//이런 방법을 다형성
		System.out.println("주소값: " + tv.toString());
		System.out.println("주소값: " + tv2.toString());
		
		////////////////////////////
		CapTv cc = new CapTv(); //Tv2 상속
		CapTv dd = new CapTv(); //Tv2 상속
		Tv2 tt;
		tt = cc;
		tt = dd;
		//다형성 (단, 내것만 접근)
	}
}
