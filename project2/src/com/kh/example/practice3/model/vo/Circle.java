package com.kh.example.practice3.model.vo;

public class Circle {
	private double PI=3.14;
	private int radius = 1;
	
	public Circle() {
		
	}
	
	public void incrementRadius() {
		this.radius++;
		System.out.println("현재 원의 반지름을 +1 했습니다.");
		System.out.println("현재 원의 반지름은 : " + this.radius);
	}
	
	public void getAreaOfCircle() {
		System.out.println(this.radius * this.radius * this.PI);	
	}
	
	public void getSizeOfCircle() {
		System.out.println(2 * this.radius * this.PI);
	}
	
}