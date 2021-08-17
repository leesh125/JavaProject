package com.kh.exam13;

public class Circle extends Shape{
	private int radius;
	private double PI=3.14;
	
	public double getPI() {
		return PI;
	}

	public void setPI(double pI) {
		PI = pI;
	}

	public Circle(int radius) {
		super(radius, radius);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
		this.radius = width;
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
		this.radius = height;
	}

	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return (int)(getWidth() * getHeight() * PI);
	}

	
	
	
}
