package com.kh.exam1;

// 1. 편의점에서 판매하는 커피 상품에 대한 클래스를 작성
class Coffee {
	private String cName;
	private int ml;
	private int date;
	private String company;
	private double oz;
	
	public void method1() {
		
	}
	public void method2() {
			
	}
	public void method3() {
		
	}
}
// 2. RPG 게임의 게임 캐릭터에 대한 클래스를 작성
class Character{
	private	String name;
	private	int str;
	private	int luc;
	private	double hp;
	private double mp;
	
	public void method1() {
		
	}
	public void method2() {
			
	}
	public void method3() {
		
	}
}
// 멤버 메서드에 대해서는 구체화된 기능은 필요 없으며, 메서드 이름만 작성
// public void 메서드명

public class ClassPrac {

	public static void main(String[] args) {
		Coffee c = new Coffee();
		c.method1();
		c.method2();
		c.method3();
		
		Character ch = new Character();
		ch.method1();
		ch.method2();
		ch.method3();
	}

}
