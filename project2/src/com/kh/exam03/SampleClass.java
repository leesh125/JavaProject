
package com.kh.exam03;


/*
 *  static : 멤버 변수/필드에 이 예약어를 사용하면 동일 클래스로 만들어진 모든
 *			 인스턴스 간에 공유할 수 있는 변수/필드로 사용할 수 있다.
 */

class Other {
	static int share = 100;
	int noShare = 200;
	
	public Other() {};
}
public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other();
		Other oth2 = new Other();
		
		System.out.println(oth1.noShare + " | " + oth2.noShare);
		System.out.println(oth1.share + " | " + oth2.share);
		
		oth1.noShare = 250;
		Other.share = 150;
		
		System.out.println(oth1.noShare + " | " + oth2.noShare);
		System.out.println(oth1.share + " | " + oth2.share);
	}

}
