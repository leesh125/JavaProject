package com.kh.exam12;

class Shape {
	protected String name;
	protected int width;
	protected int height;
	protected int r;
	static final double PI = Math.PI;
	
	public Shape() {
		
	}
	
	public Shape(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getRound() {
		return 2 * (this.width + this.height);
	}
	
	public void printArea() {
		System.out.print(name + "의 면적은 ");
		System.out.printf("%.2f\n", getArea());
	}
	
	public void printRound() {
		System.out.println(name + "의 둘레는 " + getRound());
	}
	
}

class Triangle extends Shape {
	private int n1;
	private int n2;
	private int n3;
	
	
	public Triangle(String name, int width, int height) {
		super(name, width, height);
	}
	
	public Triangle(String name, int n1, int n2, int n3) {
		this.name = name;
		this.n1 = n1;     this.n2 = n2;     this.n3 = n3;
		
		if(n1 <= 0 | n2 <= 0 | n3 <= 0 | 
		n1 + n2 <= n3 | n1 + n3 <= n2 | n2 + n3 <= n1) {
			System.out.println("해당 숫자들로는 삼각형이 될 수 없습니다.");
		}else {
			System.out.println("각 변의 길이가 " + 
								n1 + ", " + n2 + ", "+ n3 +
								" 인 삼각형이 만들어졌습니다.");
		}
	}
	
	
	@Override
	public double getArea() {
		if(this.n1 == 0) {
			return (double)super.getArea() / 2.0;
		}else {
			double s = (n1 + n2 + n3) / 2.0;
			return (Math.sqrt(s*(s-n1)*(s-n2)*(s-n3)));
		}
	}
	
	@Override
	public double getRound() {
		if(this.n1 == 0) {
			return -1;
		}else {
			return n1 + n2 + n3;
		}
	}
	
	@Override
	public void printRound() {
		if(getRound() == -1) {
			System.out.println("둘레를 구하려면 세 변의 길이가 필요합니다!");
		}else {			
			System.out.println(name + "의 둘레는 " + getRound());
		}
	}
	
	
}

class Rectangle extends Shape {
	private double n1;
	private double n2;
	private double n3;
	private double n4;
	
	public Rectangle(String name, int width, int height) {
		super(name, width, height);
	}
	
	
}

class Circle extends Shape {
	
	public Circle(String name, int r) {
		this.name = name;
		this.r = r;
	}
	
	@Override
	public double getArea() {
		return (double)(this.r * this.r * PI);
	}
	
	@Override
	public double getRound() {
		return 2 * PI * r;
	}
	
	@Override
	public void printRound() {
		System.out.print(name + "의 둘레는 ");
		System.out.printf("%.2f\n", getRound());
	}
}

public class Sample2 {

	public static void main(String[] args) {
		Triangle t = new Triangle("삼각형", 3, 5);
		t.printArea();
		t.printRound();
		
		System.out.println();
		
		Triangle t1 = new Triangle("삼각형",3,5,7);
		t1.printArea();
		t1.printRound();
		
		System.out.println();
		
		Rectangle r = new Rectangle("사각형", 3, 5);
		r.printArea();
		r.printRound();
		
		System.out.println();
		
		Circle c = new Circle("원", 3);
		System.out.print("반지름이 " + c.r + "인 "); c.printArea();
		System.out.print("반지름이 " + c.r + "인 "); c.printRound();
	}

}
