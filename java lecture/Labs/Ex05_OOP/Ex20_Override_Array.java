
class Product3{
	int price;
	int bonuspoint;
	Product3() {}
	Product3(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv2 extends Product3{
	KtTv2(){
		super(500);
	}
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product3{
	Audio2(){
		super(100);
	}
	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product3{
	NoteBook2(){
		super(150);
	}
	@Override
	public String toString() {
		return "NoteBook2";
	}
}

class Buyer3{ //구매자
	int money = 0;
	int bonuspoint=0;

	//장바구니 생성 (다형성) **************
	Product3[] Cart = new Product3[10]; 
	int index=0;
	//**********************************

	Buyer3(){
		this(1000,0);
	}

	Buyer3(int money , int bonuspoint){
		this.money = money;
		this.bonuspoint = bonuspoint;
	}

	void Buy(Product3 product){
		//카트에 담는 것 (기존 코드 동일)
		if(this.money < product.price){
			System.out.println(" [ 고객님 잔액이 부족합니다 ]");
			return; //함수의 종료
		}
		//Cart 범위 제한
		if(this.index >= 10){
			System.out.println("[ 고객님 넘 많이 사셨어요 ]");
			return;
		}

		//장바구니 담기***********************************
		//예외처리 : if 통해서 배열 길이 체크
		Cart[index++] = product; //++index 차이점 (1번쨰)
		//**********************************************
		this.money -= product.price;
		this.bonuspoint += product.bonuspoint;
		System.out.println("[구매한 물건 :" + product.toString() + "]");
		System.out.println("[현재 잔액 :" + this.money + "]");
		System.out.println("[현재 포인트 :" + this.bonuspoint + "]");

	}
    //계산대 (장바구니)
	//장바구니에 담긴 물건을 계산
	//물건의 총액
	//물건의 목록  출력
	void Summary(){
			//화면출력
			//구매한 물품의 총금액 
			//총 포인트
			//구매한 물건의 목록
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
					System.out.println("구매한 물건 총액 : " + totalprice);
					System.out.println("포인트 총액 : " + totalbonuspoint);
					System.out.println("구매한 물건 목록 : " + productList + "");
					System.out.println("*************************************");
		}

}
public class Ex20_Override_Array {
	public static void main(String[] args) {
		Buyer3 buyer3 = new Buyer3();
		KtTv2 tv = new KtTv2();
		Audio2 audio = new Audio2();
		NoteBook2 notebook = new NoteBook2();
		
		buyer3.Buy(tv);
		buyer3.Buy(tv);
		buyer3.Buy(audio);
		buyer3.Buy(audio);
		buyer3.Buy(notebook);
		
		buyer3.Summary();
		

	}

}
