package com.kh.exam6;

import com.kh.exam6.memeber.Member;
import com.kh.exam6.product.Product;
import com.kh.exam6.shape.Circle;

/*
 * 아래의 클래스를 만든 후 동작확인이 되면, 각각의 클래스를 동일 패키지 안에 
 * 개별 파일로 만들어서도 동일하게 동작이 되는지 확인을 한다.
 * 
 * 동일 패키지안에 개별 파일로도 동작이 되는것을 확인하면,
 *  다른 패키지로도 분리하여 작성했을 때도 동작이 되게 만들어 본다.
 *  
 *  패키지는 다음과 같이 분리하여
 */
//class Member{
//	private String memberId;
//	private String memberPwd;
//	private String memberName;
//	private int age;
//	private char gender;
//	private String phone;
//	private String email;
//	
//	public Member() {
//		
//	}
//	
//	public void chageName(String name) {
//		this.memberName = name;
//	}
//	
//	public void printName() {
//		System.out.println(this.memberName);
//	}
//	
//}

//class Product {
//	private String pName = "키보드";
//	private int price = 250000;
//	private String brand = "X오X드";
//	
//	public Product() {
//		
//	}
//	
//	public void information() {
//		System.out.println("물건 이름은 " + this.pName +","
//							+ "물건 가격은 " + this.price +","
//							+ "물건 브랜드는 " + this.brand);
//	}
//}

//class Circle {
//	private double PI=3.14;
//	private int radius = 1;
//	
//	public Circle() {
//		
//	}
//	
//	public void incrementRadius() {
//		this.radius++;
//		System.out.println("현재 원의 반지름을 +1 했습니다.");
//		System.out.println("현재 원의 반지름은 : " + this.radius);
//	}
//	
//	public void getAreaOfCircle() {
//		System.out.println(this.radius * this.radius * this.PI);	
//	}
//	
//	public void getSizeOfCircle() {
//		System.out.println(2 * this.radius * this.PI);
//	}
//	
//}

public class SampleClass {

	public static void main(String[] args) {
		
		System.out.println("======Member 패키지=======");
		Member m = new Member();
		m.chageName("김연경");  m.printName();
		
		System.out.println("\n======Product 패키지=======");
		Product p = new Product();
		p.information();
		
		System.out.println("\n======Circle 패키지=======");
		Circle c = new Circle();
		System.out.print("현재 원의 넓이는 : ");
		c.getAreaOfCircle();
		
		System.out.print("현재 원의 둘레는 : ");
		c.getSizeOfCircle();
		
		c.incrementRadius();
		
		System.out.print("현재 원의 넓이는 : ");
		c.getAreaOfCircle();
		
		System.out.print("현재 원의 둘레는 : ");
		c.getSizeOfCircle();
		
		
	}

}
