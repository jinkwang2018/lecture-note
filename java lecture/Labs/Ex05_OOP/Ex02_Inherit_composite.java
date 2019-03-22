/*
���赵 �� 1���� ���� �� ����
�������� ���赵 �ۼ���

*������
��Ӱ��� (is ~a: ���) �� ~�̴� (�θ����� �ڷ�)

���԰��� (has ~a: ����) �� ~������ �ִ�
-------------------------------
��Ŭ����, ����Ŭ����
���� �����̴� (��Ӱ���)
>> �� extends ����

���� ���̴�(X)
���� ���� (x,y)
���� ���� ������ �ִ� (has ~a) (���԰���)
>> �� { �� ������ ; }

����, ��
������ ���̴� (X)
������ ���� ������ �ִ� (���԰���)

���� ���
��, �ﰢ��, �簢���� ����� ���赵�� �ۼ��Ѵٸ�

���� �����̴�
�ﰢ���� �����̴�
�簢���� �����̴�

���⼭ ����(�Ϲ�ȭ, �߻�ȭ)�� ����: ����, �׸���
���� (��üȭ, Ư��ȭ) -> (��, ������)

���� ��ǥ�� (x,y)
���� ���� ������ �ִ�
�ﰢ���� ���� ������ �ִ�
�簢���� ���� ������ �ִ�

�Ϲ�ȭ(����, �߻�): shape (����, �׸���), point (��)
class Shape{}, class Point{}

��üȭ, Ư��ȭ: circle, triangle
--------------------------------------------
*/

//�߻�ȭ, �Ϲ�ȭ
class Shape {
	String color = "gold";
	void draw() {
		System.out.println("�׸���");
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

//���� ���弼�� (����: �� ���� �������� ������ �ֽ��ϴ�)
//���� �����̴� (is ~a): extends
//���� ���� ������ �ִ�(has ~a): ��������
//���� Ư������ ������ (r)

class Circle extends Shape{
	int r; //������
	Point center; //���԰���
	
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

//����1)
//�ﰢ�� Ŭ������ ���弼��
//����)�ﰢ���� 3���� ���� ���� �׸��� �׸��ٶ�� ����� ������ �ִ�
//Shape, Point ���� �޾ƿ�
//hint) (x,y) (x,y) (x,y)
//KEY POINT (��ü �迭)
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
			System.out.println("��ǥ: " + point.x + "," + point.y);
		}
	}
}

public class Ex02_Inherit_composite {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		System.out.println(c.color);
		System.out.println(c.r);
		System.out.println(c.center.x); //������ �ٽ��ڵ�: (����)�ּҰ�.(����)�ּҰ�.��
		System.out.println(c.center.y);
		
		//���� ���� ������ �ϰ� ������ �����ؼ� ���� �׸��� �;��
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


/* ���� �� �ڵ�
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
		System.out.println(c.center.x); //������ �ٽ��ڵ�: (����)�ּҰ�.(����)�ּҰ�.��
		System.out.println(c.center.y);
		
		//���� ���� ������ �ϰ� ������ �����ؼ� ���� �׸��� �;��
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