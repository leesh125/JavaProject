package com.kh.exam5;

class Other {
	int x;
	private int y;
	
	public Other() {
		
	}
	
	public Other(int x) {
		this.x = x;
	}
	
	// 매개변수 명과는 관계없이 타입이 int로 동일하기 때문에 안됨.
//	public Other(int y) {
//		this.y = y;
//	}
	
	public Other(int x, int y) {
		System.out.println("this -> " + this);
		this.x = x;
		this.y = y;
	}
	
	// 매개변수 명이 다르다고 해서 오버로딩이 되는건 아님
//	public Other(int y, int x) {
//		this.y = y;
//		this.x = x;
//	}
	
	public int getY() {
		return this.y;
	}
	
	public int getY(double y) {
		return this.y;
	}
	
	public int getY(int y, int z) {
		return this.y;
	}
}
public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other();
		System.out.println("oth1 -> " + oth1);
		Other oth2 = new Other(10,20);
		System.out.println("oth2 -> " + oth2);

		System.out.println(oth1.x + " | " + oth2.x);
		//System.out.println(oth1.y + " | " + oth2.y);
		System.out.println(oth1.getY()+ " | " + oth2.getY());
	}

}
