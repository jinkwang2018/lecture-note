import java.util.ArrayList;

class EmpData {
	private ArrayList elist;
	private int[] numbers;
	
	EmpData() {
		this.elist = new ArrayList();
		this.numbers = new int[10];
	}
	
	//getter
	public ArrayList getElist() {
		return this.elist;
	}
	//setter
	public void setElist(ArrayList elist) {
		this.elist = elist;
	}
	
	//private int[] numbers;
	//getter
	public int[] getNumbers() {
		return this.numbers;
	}
	
	//setter
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}

public class Ex04_ArrayList_Parameter {
	public static void main(String[] args) {
		EmpData empdata = new EmpData();
		System.out.println(empdata);
		System.out.println(empdata.getElist().toString());
		
		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);
		li.add(300);
		
		empdata.setElist(li);
		System.out.println(empdata.getElist().toString());
	}
}
