import kr.or.bit.AirPlane;

public class Ex06_Static_Airplane {
	public static void main(String[] args) {
		//생성자 함수를 잘 사용하면코드가 줄어요
		AirPlane a1 = new AirPlane(707, "대한항공");
		a1.airPlaneInfo();
		a1.airPlaneTotalCount();
		
		AirPlane a2 = new AirPlane(808, "대한항공");
		a2.airPlaneInfo();
		a2.airPlaneTotalCount();
		
		/* 생성자 배우기 전 코드
		AirPlane a1 = new AirPlane();
		a1.makeAirPlane(707, "대항항공");
		// ** a1. 입력 시, AirPlane 클래스의 private처리된 변수가 보이지 않게 하는 것이 핵심 (캡슐화)
		a1.airPlaneTotalCount();
		
		AirPlane a2 = new AirPlane();
		a2.makeAirPlane(808, "아시아나");
		a2.airPlaneTotalCount();
		
		AirPlane a3 = new AirPlane();
		a3.makeAirPlane(999, "에어진");
		a3.airPlaneTotalCount();
		*/
		
//내가 작성한 코드 : 코드가 김 -> 줄이는 연습을 하자.
/*		
		// 1대
		AirPlane air = new AirPlane();
		air.name = "red";
		air.no = 31;
		air.count();
		air.check("red", 30);
		
		// 2대
		AirPlane air2 = new AirPlane();
		air2.name = "green";
		air2.no = 22;
		air2.count();
		air2.check("green", 22);
		
		// 3대
		AirPlane air3 = new AirPlane();
		air3.name = "blue";
		air3.no = 15;
		air3.count();
		air3.check("blue", 15);
		
		System.out.println("비행기 총 대수: " + air.amount);
*/
	}
}
