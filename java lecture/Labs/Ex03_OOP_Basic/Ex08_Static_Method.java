
public class Ex08_Static_Method {
	public void method() {
		System.out.println("나 일반함수야");
	}
	public static void smethod() {
		System.out.println("나 static함수야");
	}
	
	public static void main(String[] args) { 
		//**java 프로그램을 실행시키기 위해서는 main함수가 진입점으로서 반드시 필요
		//예를 들어 public static void start() {} 으로 프로그램 실행할 수 없다.
		//(main이라는 이름을 시작점으로 하겠다는 약속)
		System.out.println("나 static main함수야");
		smethod();
		//Ex08_Static_Method.smethod();
		
		Ex08_Static_Method ss = new Ex08_Static_Method();
		ss.method();
	}
}
