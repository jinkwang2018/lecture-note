//자바에서 다형성은 상속관계에서...

class Pbase {
	int p = 100;
}

class Cbase extends Pbase { // 같은 부모
	int c = 200;
}

class Dbase extends Pbase { // 같은 부모
	
}

public class Ex11_Inherit_Poly {
	public static void main(String[] args) {
		Cbase c = new Cbase();
		System.out.println(c.toString());
		//다형성: 부모타입의 참조변수가 자식타입의 주소값을 가질 수 있다 (상속관계에서)
		//단 그렇지만 메모리에 모든 자원에 접근하는 것이 아니라 부모타입의 자원만 접근 가능
		
		Pbase p = c;
		System.out.println("p 부모타입 변수: " + p);
		System.out.println("p 상속한 c 타입 변수: " + c);
		
		System.out.println(c.p + " / " + c.c);
		System.out.println("자신의 것만 볼 수 있다: " + p.p);
		
		Dbase d = new Dbase();
		p = d; //하나의 참조변수p 가 c의 주소값도, d의 주소값도 가질 수 있다.
		
		Dbase dd = (Dbase)p; //부모는 [상위타입] (casting해야 한다)
		//부모타입의 값을 자식타입에게 전달(자식타입으로 casting)
		
	}
}
