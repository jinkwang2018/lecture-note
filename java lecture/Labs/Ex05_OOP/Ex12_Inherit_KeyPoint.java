/*
�ó�����(�䱸����)
����� ������ǰ ���� �ַ���� �����ϴ� ������Դϴ�
A��� ������ǰ ������ ���µǸ�

[Ŭ���̾�Ʈ �䱸����]
������ǰ�� ��ǰ�� ����, ��ǰ�� ����Ʈ ������ ���������� ������ �ֽ��ϴ�
������ ������ǰ�� ��ǰ�� ������ �̸��� ������ �ִ�
ex)
������ ������ǰ�� �̸��� ������ �ִ� (ex: Tv, Audio, Notebook)
������ ������ǰ�� �ٸ� ������ ������ �ִ� (Tv: 5000, Audio: 6000 ...)
��ǰ�� ����Ʈ�� ������ 10% �����Ѵ�

�ùķ��̼� �ó�����
������: ��ǰ�� �����ϱ� ���� �ݾ�����, ����Ʈ ������ ������ �ִ�
���� ���: 10����, ����Ʈ 0
�����ڴ� ��ǰ�� ������ �� �ִ�, ���������� �ϰԵǸ� ������ �ִ� ���� �����ϰ� ����Ʈ�� �ö󰣴�
�����ڴ� ó�� �ʱ� �ݾ��� ���� �� �ִ�
 */


class Buyer { //������
	int money = 1000;
	int bonuspoint = 0;
	
	//��������
	//�������� (�ܾ� - ��ǰ�� ����, ����Ʈ ���� ����)
	//�����ڴ� ���忡 �ִ� ��� ��ǰ�� ������ �� �ִ�
	//���� �Լ�
	//���忡 �ִ� ��ǰ(kttv, audio, notebook)
	
	//1�� ���� ����
	//�Ͽ��� �ް�^^
	
	//���忡 ��ǰ�� 1000�� �ٸ� ��ǰ�� �߰� (POS ��� �ڵ�ȭ)
	//������ ���� ���忡 ��ġ �ڵ�ȭ
	//���� >> �� >> �ڵ��� ���� -> ���� �߻�
	//�ٸ� 997���� ��ǰ�� ���� ���������� �� �� ����
	//�� ģ���� 997 �޼��带 �����...����� �ð��� �� �Ǿ���.
	
/*
	void kttvBuy(KtTv n) { //�Լ��� ��ǰ ��ü�� parameter�� ���� �� [POINT!]
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += this.bonuspoint;
		System.out.println("������ ������: " + n.toString());
	}
	
	void audioBuy(Audio n) { //�Լ��� ��ǰ ��ü�� parameter�� ���� �� [POINT!]
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += this.bonuspoint;
		System.out.println("������ ������: " + n.toString());
	}
	
	void notebookBuy(Notebook n) { //�Լ��� ��ǰ ��ü�� parameter�� ���� �� [POINT!]
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += this.bonuspoint;
		System.out.println("������ ������: " + n.toString());
	}
*/
//2�� ����
//���� 1000���� ��ǰ�� �ִٸ� 1000���� �ٸ� �Լ����� ȣ���Ͽ��� �Ѵ�
//�����ϴ� �Լ����� �ٸ��� ������ >> �����ϴ� �Լ��� ���� >> method overloading
/*
	void Buy(KtTv n) { //�Լ��� ��ǰ ��ü�� parameter�� ���� �� [POINT!]
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += this.bonuspoint;
		System.out.println("������ ������: " + n.toString());
	}
	
	void Buy(Audio n) { //�Լ��� ��ǰ ��ü�� parameter�� ���� �� [POINT!]
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += this.bonuspoint;
		System.out.println("������ ������: " + n.toString());
	}
	
	void Buy(Notebook n) { //�Լ��� ��ǰ ��ü�� parameter�� ���� �� [POINT!]
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += this.bonuspoint;
		System.out.println("������ ������: " + n.toString());
	}
	*/

//3�� ����
//��ǰ�� ��������� �߰��Ǵ��� ���������� ���� �Լ��� �߰������� ������ �ʰڴ�
//why: ���� ��ſ� �ް��� ������ ���ؼ�
//** �ݺ����� �ڵ� ����.....
//** �ϳ��� �Լ��� ��� ���ǿ� ���� ���� ������ ����
//Key Point: ��� ��ǰ�� Product�� ����ϰ� �ִ� (��� ��ǰ�� �θ�� Product�Դϴ�)

//�ڵ� �ϳ��� �Լ��� ��� ���������� �ذ��ϼ��� (10��)
//Product p �θ�Ÿ���� ������ ��Ӱ��迡�� �ڽ�Ÿ���� �ּҸ� ���� �� �ִ�.
	void Buy(Product n) { //�Լ��� ��ǰ��ü�� parameter�� POINT
		//** ��Ӱ��迡�� �θ�Ÿ������ �����ϴ��� ������ �Լ��� �ڽİ��� ��� **
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^");
			return; //���������� ���� ����
		}
		//�� ���� ����
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("������ ������: " + n.toString());
		System.out.println("��: " + this.money);
		System.out.println("����Ʈ: " + this.bonuspoint);
	}
}

class Product { //������ǰ
	int price;
	int bonuspoint;
	
	//Product() {}
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price / 10.0);
	}
	
}

class KtTv extends Product { //Product�� KtTv ���
	KtTv() {
		super(500);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
}
//KtTv lgtv = new KtTv(500);
//System.out.println(lgtv); KtTv ��� ��µȴ�

class Audio extends Product { //Product�� Audio ���
	Audio() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}

class Notebook extends Product { //Product�� Computer ���
	Notebook() {
		super(150);
	}
	
	@Override
	public String toString() {
		return "Notebook";
	}
}

public class Ex12_Inherit_KeyPoint {
	public static void main(String[] args) {
		KtTv kttv = new KtTv();
		System.out.println(kttv.toString());
		Audio audio = new Audio();
		System.out.println(audio.toString());
		Notebook notebook = new Notebook();
		System.out.println(notebook.toString());
		
		Buyer buyer = new Buyer();
		//1�� ����
		//��������
		/*
		buyer.audioBuy(audio);
		buyer.notebookBuy(notebook);
		buyer.audioBuy(audio);
		buyer.notebookBuy(notebook);
		buyer.kttvBuy(kttv);
		buyer.kttvBuy(kttv);
		*/
		
		buyer.Buy(audio);
		buyer.Buy(notebook);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		buyer.Buy(kttv);
		buyer.Buy(kttv);
		System.out.println(buyer.money);
		System.out.println(buyer.bonuspoint);
	}
}