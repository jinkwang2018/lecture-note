package kr.or.bit.common;

public class Program {
	public static void main(String[] args) {
		// default 접근자를 가지고 있는 CommonClass 사용시 문제 없음
		CommonClass c = new CommonClass();
		CommonClassPublic common = new CommonClassPublic();
		// common.a -> public
		// common.b -> default 접근자. 같은 폴더라면 사용 가능
		// common.c -> private
		common.a = -100;
		System.out.println(common.a);
		
		common.write(-4444);
		System.out.println(common.read());
	}
}
