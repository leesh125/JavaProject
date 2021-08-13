package com.kh.practice.point.model.vo;

public class Triangle extends Point{
	private int n1, n2, n3;
	
	public Triangle() {
		
	}
	
	public Triangle(int x, int y, int n1, int n2, int n3) {
		super(x, y);
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getN3() {
		return n3;
	}

	public void setN3(int n3) {
		this.n3 = n3;
	}

	@Override
	public String toString() {
		return this.getX() + ", " + this.getY() + ", " +
				this.getN1() + ", " + this.getN2() + ", " + this.getN3();
	}
	
	
}
