/*
<Today Point> [상속관계]에서 override: 상속관계에서 메서드 재정의
-상속관계에서 자식클래스가 부모클래스의 메서드를 재정의
-재정의 (함수) (상속관계) (부모) (자식이)
-재정의 의미: 틀의 변화가 아니라 내용의 변화 예) void 함수명 { 괄호 안에 내용만 변경 }
문법)
1. 부모함수 이름과 동일
2. 부모함수 parameter 함수 동일
3. 부모함수 return type 동일
4. 결국에는 { 괄호안에 있는 내용만 수정해라 }

[overloading과 override의 차이]
*overloading: 함수의 이름으로 여러가지 기능을 하는 것
*override: 상속에서의 재정의
 */

class Point2 {
	int x = 4;
	int y = 5;
	String getPosition() {
		return "x:" + this.x + " y:" + this.y;
	}
}

class Point3D extends Point2 {
	//x, y 상속관계 부모 자원 사용
	int z = 6;
	/*String getPosition3() {
		return "x:" + this.x + " y:" + this.y + " z:" + this.z;
	}*/

	//POINT: @Override >> Annotation
	//Annotation은 Java code만으로 전달할 수 없는 부가적인 정보를 [컴파일러]나 [개발툴]로 전달할 수 있다.
	@Override
	String getPosition() {
		//return super.getPosition(); //super: 부모 클래스
		return "x:" + this.x + " y:" + this.y + " z:" + this.z;
	}
	
}

public class Ex04_Inherit_override {
	public static void main(String[] args) {
		Point3D point = new Point3D();
		//String result = point.getPosition3();
		//System.out.println(result);
		
		String result = point.getPosition();
		System.out.println(result);
	}
}
