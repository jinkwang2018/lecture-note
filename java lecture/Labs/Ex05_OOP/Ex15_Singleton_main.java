import kr.or.bit.Singleton;

public class Ex15_Singleton_main {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s == s2);
		System.out.println(s2 == s3);
	}
}
