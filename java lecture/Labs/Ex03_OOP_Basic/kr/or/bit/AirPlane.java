package kr.or.bit;
/*
우리 회사는 비행기를 주문 제작 판매 하는 회사입니다
우리 회사는 비행기를 생산하는 설계도를 작성하려고 합니다
[요구사항]
1. 비행기를 생산하면 비행기의 이름과 번호를 부여해야 합니다 <변수>
2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인 작업이 필요합니다. (출력정보 확인) <기능>
3. 공장장은 현재까지 만들어진 비행기의 총대수 (누적)을 확인할 수 있습니다. <기능>

단 오늘 배운 코드로 설계도 만드시고 비행기 3대 생산 정보확인하고 누적대수 확인...

 */
// 사실 아래 작성한 코드는 수정되어야 합니다 -> 생성자 배운 이후에 다시 수정
/*
public class AirPlane {
	private int airnum; //**private 사용해서 함수로 클래스 내 변수를 컨트롤 하는지
	private String airname;
	private static int airtotalcount;
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		airtotalcount++;
		System.out.printf("번호[%d], 이름[%s]\n", airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.println("총 제작 비행기 수: " + airtotalcount);
	}
}
*/

public class AirPlane {
	private int airnum; //**private 사용해서 함수로 클래스 내 변수를 컨트롤 하는지
	private String airname;
	private static int airtotalcount;
	
	//public AirPlane() {} 구현하지 않을 거에요 why) 강제적인 초기화 int num, String name
	
	public AirPlane(int airnum, String airname) {
		this.airnum = airnum;
		this.airname = airname;
		airtotalcount++;
	}
	
	public void airPlaneInfo() {
		System.out.printf("번호[%d], 이름[%s]\n", airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.println("총 제작 비행기 수: " + airtotalcount);
	}
}

//내가 작성한 코드

/*
public class AirPlane {
	public String name;
	public int no;
	public static int amount;
	
	public void check(String name, int no) {
		if (this.name == name && this.no == no) {
			System.out.printf("비행기의 이름: %s / 번호: %d 맞게 부여되었습니다.\n", name, no);
		}else {
			System.out.println("등록되지 않은 비행기입니다.");
		}
	}
	
	public int count() {
		return amount++;
	}
}
*/