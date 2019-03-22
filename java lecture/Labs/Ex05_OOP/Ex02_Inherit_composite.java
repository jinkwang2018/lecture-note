/*
설계도 단 1개만 만들 수 없다
여러개의 설계도 작성시

*기준점
상속관계 (is ~a: 상속) 은 ~이다 (부모쪽을 뒤로)

포함관계 (has ~a: 포함) 은 ~가지고 있다
-------------------------------
원클래스, 도형클래스
원은 도형이다 (상속관계)
>> 원 extends 도형

원은 점이다(X)
점의 정의 (x,y)
원은 점을 가지고 있다 (has ~a) (포함관계)
>> 원 { 점 변수명 ; }

경찰, 총
경찰은 총이다 (X)
경찰은 총을 가지고 있다 (포함관계)

예를 들면
원, 삼각형, 사각형을 만드는 설계도를 작성한다면

원은 도형이다
삼각형은 도형이다
사각형은 도형이다

여기서 도형(일반화, 추상화)된 공통: 색상, 그리다
원은 (구체화, 특수화) -> (점, 반지름)

점은 좌표값 (x,y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다

일반화(공통, 추상): shape (색상, 그리다), point (점)
class Shape{}, class Point{}

구체화, 특수화: circle, triangle
--------------------------------------------
*/

//추상화, 일반화
class Shape {
	String color = "gold";
	void draw() {
		System.out.println("그리다");
	}
}

class Point{
	int x;
	int y;
	
	Point() {
		//this.x = 1;
		//this.y = 1;
		this(1, 1);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//원을 만드세요 (정의: 한 점과 반지름을 가지고 있습니다)
//원은 도형이다 (is ~a): extends
//원은 점을 가지고 있다(has ~a): 참조변수
//원의 특수성은 반지름 (r)

class Circle extends Shape{
	int r; //반지름
	Point center; //포함관계
	
	Circle() {
		//this.r = 10;
		//this.center = new Point(10, 12);
		this(10, new Point(10, 12));
	}
	/*
	Circle c = new Circle();
	Circle c2 = new Circle(4, new Point(5,8));
	 */
	
	Circle(int r, Point center) {
		this.r = r;
		this.center = center;
	}
}

//문제1)
//삼각형 클래스를 만드세요
//정의)삼각형은 3개의 점과 색과 그리고 그리다라는 기능을 가지고 있다
//Shape, Point 제공 받아요
//hint) (x,y) (x,y) (x,y)
//KEY POINT (객체 배열)
class Triangle extends Shape {
	Point[] pointarray;
	
	Triangle() {
		this(new Point[] {new Point(1,2), new Point(3,4), new Point(5,6)});
	}
	
	Triangle(Point[] pointarray) {
		this.pointarray = pointarray;
	}
	
	public void print() {
		for(Point point : this.pointarray) {
			System.out.println("좌표: " + point.x + "," + point.y);
		}
	}
}

public class Ex02_Inherit_composite {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		System.out.println(c.color);
		System.out.println(c.r);
		System.out.println(c.center.x); //오늘의 핵심코드: (변수)주소값.(변수)주소값.값
		System.out.println(c.center.y);
		
		//저는 원의 반지름 하고 중점을 설정해서 원을 그리고 싶어요
		//Point point = new Point(20, 45);
		//Circle c2 = new Circle(50, point);
		Circle c2 = new Circle(50, new Point(20,45));
		System.out.println(c2.color);
		System.out.println(c2.r);
		System.out.println(c2.center.x);
		System.out.println(c2.center.y);
		
		Triangle t = new Triangle();
		t.print();
	}
}


/* 내가 쓴 코드
class Triangle extends Shape {
	Point[] p = new Point[3];
	
	Triangle() {
		this(new Point(1,1), new Point(2,2), new Point(3,3));
	}
	
	Triangle(Point p, Point q, Point r) {
		this.p[0] = p;
		this.p[1] = q;
		this.p[2] = r;
	}
}

public class Ex02_Inherit_composite {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		System.out.println(c.color);
		System.out.println(c.r);
		System.out.println(c.center.x); //오늘의 핵심코드: (변수)주소값.(변수)주소값.값
		System.out.println(c.center.y);
		
		//저는 원의 반지름 하고 중점을 설정해서 원을 그리고 싶어요
		//Point point = new Point(20, 45);
		//Circle c2 = new Circle(50, point);
		Circle c2 = new Circle(50, new Point(20,45));
		System.out.println(c2.color);
		System.out.println(c2.r);
		System.out.println(c2.center.x);
		System.out.println(c2.center.y);
		
		Triangle t = new Triangle();
		System.out.println(t.color);
		System.out.println(t.p[0].x + "," + t.p[0].y);
		System.out.println(t.p[1].x + "," + t.p[1].y);
		System.out.println(t.p[2].x + "," + t.p[2].y);
		
		Triangle t2 = new Triangle(new Point(10,10), new Point(20,20), new Point(30,30));
		System.out.println(t2.color);
		System.out.println(t2.p[0].x + "," + t2.p[0].y);
		System.out.println(t2.p[1].x + "," + t2.p[1].y);
		System.out.println(t2.p[2].x + "," + t2.p[2].y);
	}
} */