package Quiz_;
//사각형 만들기
class Shape{
	String color;
}
class Point{
	int x;
	int y;
	public Point() {
		this(1,2);
	}
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
class Square extends Shape{
	Point [] arr;
	public Square(){
		this(new Point[]{new Point(1,3),new Point(2,4),new Point(3,5),new Point(2,5)});
		System.out.println(1);
	}
	public Square(Point[]arr){
		this.arr=arr;
		System.out.println(2);
	}
	public void SquareInfo() {
		System.out.println("사각형의 좌표 값");
		for(Point Info : arr) {
			System.out.printf("["+Info.x+","+Info.y+"]");
		}
	}
}

public class Array {
	public static void main(String[]args) {
		Square s = new Square(new Point[]{new Point(5,4),new Point(5,5),new Point(7,8),new Point(9,4)});
		s.SquareInfo();
	}

}
