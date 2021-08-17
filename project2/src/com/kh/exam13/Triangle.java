package com.kh.exam13;

public class Triangle extends Shape {
	public Triangle(int width, int height) {
		super(width, height);
	}

	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return this.getWidth() * this.getHeight() / 2;
	}
	
	
}
