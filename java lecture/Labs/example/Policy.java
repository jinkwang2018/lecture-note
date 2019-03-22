public class Policy {
	static int dueto = 1;
	static public void change(int a){
		switch (a) {
		case 0:
			dueto = 3;
			break;
		case 1:
			dueto = 2;
			break;
		case 2:
			dueto = 1;
			break;
		}
	}
}