import kr.or.bit.common.CommonClassPublic;

/*
Ŭ���� == ���赵 == ������ Ÿ��

Ŭ������ �������: **�ʵ�(����, ����, ����) - �ܿ��, ������(�ʵ��� �ʱ�ȭ�� �������� �ϴ� �Լ�), �Լ�
������(������, Modifier): public, private, default, protected (protected�� ��Ӱ��迡�� ���)

1. public
public class Test{}

2. default
class Test{} >> default �����ڰ� �����Ǿ� �ִ�
(default �����ڴ� ����(���� ������ ��ġ: ���� ���� �ȿ�, �ٸ� ������ �ִ��Ŀ� ���� �ڿ� ��뿩�� �Ǵ�)

3. default class ���� ����ϴ� ����? -> ���� ���� ������ �ٸ� Ŭ������ ���� ��������, ������������

4. �ϳ��� �ڹ� ������ �������� Ŭ������ ���� �� �ִ� (Test.java) => ��, True
	EX01_main.java ��� ������ public class Ex01_main �̶�� Ŭ������ ������ �ִ�.



 */

class TTT { // default class TTT (���� ������ ���� Ŭ�������� ���� �� �� ����)
	int a; // default
	
	void print() { // default
		System.out.println(a);
	}
}

class PPP {
	
}


public class Ex01_main {
	public static void main(String[] args) {
		// public�̶� �ٸ� ������Ʈ���� ������ ���� �ʴ´�. �����ϱ����ؼ��� ���̺귯������ ��°�� �����;� �Ѵ�.
		// 1. kr.or.bit.common ���� �ȿ� �ִ� Ŭ������ ����Ϸ���
		// a) Full name ���
		//	kr.or.bit.common.CommonClass c = new kr.or.bit.common.CommonClass();
		// b) import kr.or.bit.common.CommonClass;
		// ��, �����ڰ� public�� ���
		//	CommonClass c = new CommonClass();
		
		CommonClassPublic common = new CommonClassPublic();
		// common.a = 10; a��� ����: public
		
		TTT t = new TTT();
		t.a = 100;
		t.print();
	}
}
