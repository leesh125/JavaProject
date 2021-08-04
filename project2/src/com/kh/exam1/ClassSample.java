package com.kh.exam1;

class Nation {
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	public void method() {
		name = "김철수";
		pNo = "123456-1234567";
		gender = 'm';
		address = "서울시 강남구 역삼동";
		phone = "010-1234-5678";
		age = 30;
	}
}

class Mom {
	private int money = 50000;
	
	public void 용돈() {
		
	}
}
public class ClassSample {

	public static void main(String[] args) {
		Nation nat = new Nation();
		nat.method();
		
		Mom m = new Mom();
		//int myMoney = m.money;
		m.용돈();
	}

}
