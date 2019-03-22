/*
�䱸����
īƮ (Cart)
īƮ���� ���忡 �ִ� ��� ������ǰ�� ���� �� �ִ� 
īƮ�� ũ��� �����Ǿ� �ִ� (10��) : 1��  , 2�� ���� �� �ְ� �ִ� 10������ ���� �� �ִ�
���� ������ ���� �ϸ� ... īƮ�� ��´�

���뿡 ���� ��ü ���
������� �ʿ�
summary() ��� �߰��� �ּ���
����� ������ �����̸� �� �������� ����
�� �����ݾ� ��� ���
ȣ��
hint) īƮ ������ ��� ���� (Buy())
hint) Buyer ..>> summary()  main �Լ����� ����Ҷ�

�����ڴ� default �ݾ��� ������ �ְ� �ʱ�ݾ��� ������ �� �� �ִ�

*/
class Product2{
	int price;
	int bonuspoint;
	Product2() {}
	Product2(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv2 extends Product2{
	KtTv2(){
		super(500);
	}
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2{
	Audio2(){
		super(100);
	}
	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product2{
	NoteBook2(){
		super(150);
	}
	@Override
	public String toString() {
		return "NoteBook2";
	}
}

class Buyer2{ //������
	int money = 0;
	int bonuspoint=0;

	//��ٱ��� ���� (������) **************
	Product2[] Cart = new Product2[10]; 
	int index=0;
	//**********************************

	Buyer2(){
		this(1000,0);
	}

	Buyer2(int money , int bonuspoint){
		this.money = money;
		this.bonuspoint = bonuspoint;
	}

	void Buy(Product2 product){
		//īƮ�� ��� �� (���� �ڵ� ����)
		if(this.money < product.price){
			System.out.println(" [ ���� �ܾ��� �����մϴ� ]");
			return; //�Լ��� ����
		}
		//Cart ���� ����
		if(this.index >= 10){
			System.out.println("[ ���� �� ���� ��̾�� ]");
			return;
		}

		//��ٱ��� ���***********************************
		//����ó�� : if ���ؼ� �迭 ���� üũ
		Cart[index++] = product; //++index ������ (1����)
		//**********************************************
		this.money -= product.price;
		this.bonuspoint += product.bonuspoint;
		System.out.println("[������ ���� :" + product.toString() + "]");
		System.out.println("[���� �ܾ� :" + this.money + "]");
		System.out.println("[���� ����Ʈ :" + this.bonuspoint + "]");

	}
    //���� (��ٱ���)
	//��ٱ��Ͽ� ��� ������ ���
	//������ �Ѿ�
	//������ ���  ���
	void Summary(){
			//ȭ�����
			//������ ��ǰ�� �ѱݾ� 
			//�� ����Ʈ
			//������ ������ ���
			int totalprice = 0;
			int totalbonuspoint = 0;
			String productList = "";
					for(int i=0 ; i < index ;i++){
					//for(int i=0 ; i < Cart.length ;i++){
					//	if(Cart[i] == null) break;
						totalprice += Cart[i].price;
						totalbonuspoint += Cart[i].bonuspoint;
						productList += Cart[i].toString() + "  ";
					}
					System.out.println("**************************************");
					System.out.println("������ ���� �Ѿ� : " + totalprice);
					System.out.println("����Ʈ �Ѿ� : " + totalbonuspoint);
					System.out.println("������ ���� ��� : " + productList + "");
					System.out.println("*************************************");
		}

}
public class Ex13_Inherit_KeyPoint_Override_Array {
	public static void main(String[] args) {
		Buyer2 buyer = new Buyer2(2000,0);
		KtTv2 tv = new KtTv2();
		Audio2 audio = new Audio2();
		NoteBook2 notebook = new NoteBook2();
		
		buyer.Buy(tv);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		
		buyer.Summary();
	}
}
