
package com.kh.exam07;


class Other{
	public void method() {
		System.out.println("메서드 실행이 잘 되었습니다.");
	}
	
	public static void function() {
		System.out.println("함수 실행이 잘 되었습니다.");
	}
	
	public final void method1() {
		System.out.println("final은 상속 관계에서 오버라이딩을 하지 못하게 한다.");
	}
}

public class Sample1 {

	public static void ex1() {
		System.out.println("문제 1. ");
	}
	public static void main(String[] args) {
		Other oth = new Other();
		oth.method();
		
		Other.function();
		
		ex1();  // Java 기본 코드 문제 풀때 사용해봄
		
		// 자신의 클래스 안에 정의된 static 메서드 이기 떄문에
		// 자신의 클래스 이름은 생략해도 되었던 것.
		
		Sample1.ex1();
	}

}
