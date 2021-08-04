package com.kh.exam1;

// 1. 편의점에서 판매하는 커피 상품에 대한 클래스를 작성
// 2. 임의의 직업에 대한 클래스를 작성
// 멤버 메서드에 대해서는 구체화된 기능은 필요 없으며, 메서드 이름만 작성한다.
// public void 메서드명() 형식으로 작성만 하면됨.
// 멤버 변수는 최소 5개, 멤버 메서드는 최소 3개 정도 작성한다.

class Coffee {
	private String 원두;
	private String 제조회사;
	private int 가격;
	private String 상품명;
	private int 용량;
	
	public void 뚜껑열기() {}
	public void 뚜겅닫기() {}
	public void 마시기() {}
}

class 개발자 {
	private String 분야;
	private String 사용언어;
	private String 소속기업;
	private int 연봉;
	private int 연차;
	
	public void 일() {}
	public void 휴식() {}
	public void 밥() {}
}

public class ClassPrac {

	public static void main(String[] args) {
		Coffee c = new Coffee();
		c.뚜껑열기();
		
		개발자 노예1 = new 개발자();
		노예1.일();
	}

}
