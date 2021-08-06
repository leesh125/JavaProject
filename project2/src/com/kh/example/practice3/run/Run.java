package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		System.out.println("======Circle 패키지=======");
		Circle c = new Circle();
		System.out.print("현재 원의 넓이는 : ");
		c.getAreaOfCircle();
		
		System.out.print("현재 원의 둘레는 : ");
		c.getSizeOfCircle();
		
		System.out.println();
		c.incrementRadius();
		System.out.println();
		
		System.out.print("현재 원의 넓이는 : ");
		c.getAreaOfCircle();
		
		System.out.print("현재 원의 둘레는 : ");
		c.getSizeOfCircle();

	}

}
