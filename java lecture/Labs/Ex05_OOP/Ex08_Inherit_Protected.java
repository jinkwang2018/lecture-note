import kr.or.bit.Pclass;

//접근자 (제어자): private, default, protected, public
//상속관계에서 존재하는 protected
//양면성: default, public(상속) ...

//증명: 상속이 없는 클래스 안에 protected 접근자는 default와 같다
//why) 상속이 없는 상황에서는 protected 접근자 의미 없다 (default 접근자와 동일)

//상속관계에서 Protected
class Child2 extends Pclass {
	void method() {
		this.k = 1000; //상속관계에서는 public 처럼 처리
		// this.p = 11; (x)
		System.out.println(this.k);
	}
}

class Dclass {
	private int i;
	public int j;
	protected int k;
	int p; //default
}

public class Ex08_Inherit_Protected {
	public static void main(String[] args) {
		Dclass d = new Dclass();
		//d.j ok
		//d.k ok (protected -> 같은 폴더 내에서는 default처럼)
		//d.p ok (default 접근자)
		
		Pclass p = new Pclass();
		//p.j public (o)
		//p.i private (x)
		//p.p 같은 폴더 (x)
		//p.k 같은 폴더가 아니니까 (x)
		
		Child2 c2 = new Child2();
		c2.method();
	}
}
