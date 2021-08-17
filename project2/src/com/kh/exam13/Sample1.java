package com.kh.exam13;

public class Sample1 {

	public static void main(String[] args) {
		Shape[] sArr1 = new Shape[3];
		sArr1[0] = new Square(10,20); 		sArr1[1] = new Triangle(10,20);
		sArr1[2] = new Circle(10);

		sArr1[0].setWidth(15);
		sArr1[1].setWidth(25);
		((Circle)sArr1[2]).setRadius(35);
		
		System.out.println(sArr1[0].getWidth() + " | " + sArr1[1].getWidth() + " | " + ((Circle)sArr1[2]).getRadius() );
	
		for(Shape s: sArr1) {
			if(s instanceof Circle) {
				((Circle) s).setRadius(45);
				System.out.println(((Circle) s).getRadius());
			} else {
				s.setWidth(45);
				System.out.println(s.getWidth());
			}
		}
		System.out.println("=====");
		
		Shape[] sArr2 = new Shape[7];
		
		for(int i=0; i<sArr2.length; i++) {
			int val = (i+1) + (i*3);
			if(i % 3 == 0) {
				sArr2[i] = new Triangle(val, val);
			} else if (i % 3 == 1) {
				sArr2[i] = new Square(val, val);
			} else if (i % 3 == 2) {
				sArr2[i] = new Circle(val);
			}
		}
		int count = 1;
		
		for(Shape s: sArr2) {
			if(s instanceof Circle) {
				Circle c = (Circle) s;
				System.out.println("원의 넓이는 "+c.getArea()+ ", pi는 " + c.getPI());
			} else {
				if(count++ % 2 == 0) {
					System.out.println("사각형의 넓이는 " + s.getArea());
				}else {
					System.out.println("삼각형의 넓이는 " + s.getArea());
				}
			} 
			
		}
		
	}
	

	
}
