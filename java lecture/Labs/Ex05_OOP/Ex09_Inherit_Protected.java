import kr.or.bit.Bird;

//protected 접근자: 상속관계에서 사용
//사용목적: 상속관계에서 재정의를 강제하는 방법
//재정의를 해주었으면 좋겠어(의도)

//상속관계에서 재정의를 [강제]하는 방법 (Protected)
//공통: 새는 날 수 있다, 새는 빠르다
class Ostrich extends Bird {
	void run() {
		System.out.println("달린다^^");
	}

	@Override
	protected void movefast() {
		run();
	}
}

class Bi extends Bird {
	@Override
	protected void movefast() {
		super.movefast();
	}
}

public class Ex09_Inherit_Protected {
	public static void main(String[] args) {
		Ostrich o = new Ostrich();
		o.run();
		o.movefast();
		
		Bi b = new Bi();
		b.movefast();
	}
}
