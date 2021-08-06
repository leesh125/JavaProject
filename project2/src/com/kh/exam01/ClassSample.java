package com.kh.exam01;

class Kukmin {
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	public void method() {}
}

class Mom {
	private int money = 5000000;
	
	public void 용돈() {
		
	}
}

public class ClassSample {

	public static void main(String[] args) {
//		Kukmin kim = new Kukmin();
//		kim.method();
		
		Mom m = new Mom();
		// int myMoney = m.money;	// 직접 돈을 가져가는 형태가 아님
		m.용돈();		// 간접적으로 돈을 가져가는 형태임.
	}

}
