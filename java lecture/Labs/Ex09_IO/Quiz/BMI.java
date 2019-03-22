package Quiz;

import java.io.Serializable;
import java.util.Scanner;


public class BMI implements Serializable{
	private double length = 0;
	private double weight = 0;
	private double result = 0;
	private String you = null;
	
	public BMI input(BMI bmi){
		Scanner scan = new Scanner(System.in);
		System.out.print("Ű�� �Է��ϼ��� : ");
		this.length = scan.nextInt();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		this.weight = scan.nextInt();
		this.result = this.weight/((this.length/100.0)*(this.length/100.0));
		if(this.result<18.5){
			this.you = "ü�� ����";
		}else if(18.5<=this.result && this.result<=22.9){
			this.you = "����";
		}else if(23.0<=this.result && this.result<=24.9){
			this.you = "��ü��";
		}else if(25.0<=this.result){
			this.you = "��";
		}
		return bmi;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getYou() {
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() {
		return length+"\t"+weight+"\t"+result+"\t"+you;
	}
	
	
}//class
