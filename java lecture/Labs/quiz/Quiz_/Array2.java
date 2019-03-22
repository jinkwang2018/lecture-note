package Quiz_;
class Ip{
	int ip1;
	int ip2;
	int ip3;
	int ip4;
	Ip(){
		this(192,168,0,20);
	}
	Ip(int ip1 , int ip2 , int ip3 , int ip4){
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.ip3 = ip3;
		this.ip4 = ip4;
	}
	
}
class Computer{
	Ip[] array;
	Computer(){
		this(new Ip[]{new Ip(192,168,0,29),new Ip(192,168,0,16), new Ip(192,168,0,25), new Ip(192,168,0,19)});
	}
	Computer(Ip[]array) {
		this.array = array;
	}
	public void ComputerInfo() {
		for(Ip Info: array) {
			System.out.printf("[%d.%d.%d.%d]",Info.ip1,Info.ip2,Info.ip3,Info.ip4);
			System.out.println();
		}
	}
}

public class Array2 {
	public static void main(String[]args) {
		Computer c = new Computer(new Ip[] {new Ip(),new Ip(),new Ip(),new Ip()});
		c.ComputerInfo();
		
	}
}
