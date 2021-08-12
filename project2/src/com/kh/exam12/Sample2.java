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
	
	public void printArea() {
		System.out.print(name + "의 면적은 ");
		System.out.printf("%.2f\n", getArea());
	}
	
}

class Triangle extends Shape {
	private double n1;
	private double n2;
	private double n3;
	
	
	public Triangle(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public double getArea() {
		return (double)super.getArea() / 2.0;
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
	
}

public class Sample2 {

	public static void main(String[] args) {
		Triangle t = new Triangle("삼각형", 3, 5);
		t.printArea();
		
		Rectangle r = new Rectangle("사각형", 3, 5);
		r.printArea();
		
		Circle c = new Circle("원", 3);
		c.printArea();
	}

}
