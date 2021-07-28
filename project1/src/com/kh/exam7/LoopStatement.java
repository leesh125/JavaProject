package com.kh.exam7;

public class LoopStatement {

	public static void sample1() {
		// 초기값을 증가시키면서 반복
		for(int i = 1; i <= 5; i++) {
			System.out.println(i + " 번째 반복");
		}
	}
	
	public static void sample2() {
		// 초기값을 감소시키면서 반복
		for(int i=5; i>=1; i--) {
			System.out.println(i + "입니다.");
		}
	}
	
	public static void sample3() {
		// 반복문 밖에 미리 초기값을 설정
		int i = 1;
		
		//초기값 생략
		for(; i<=5; i++) {
			System.out.println(i + "입니다.");
		}
	}
	
	public static void sample4() {	
		// 증감식을 반복문 안에 넣어서 사용.
		// 증감식 생략
		for(int i=1; i<=5;) {
			System.out.println(i + "입니다.");
			i++;
		}
	}
	
	public static void sample5() {	
		// 2씩 증가하면서 반복
		for(int i=1; i<=5; i+=2) {
			System.out.println(i + "입니다.");
		}
	}
	
	public static void sample6() {
		// 초기식, 조건식, 증감식을 모두 생략
		for(;;) {
			System.out.println("무한 반복!!");
		}
	}
	
	public static void sample7() {
		int i = 1; // 초기값
		for(;;) {
			System.out.println(i + "입니다.");
			i++; // 증감식
			if(i > 5) { // 조건식
				break; // 반복을 강제 종료시킴.
			}
		}
	}
	
	public static void main(String[] args) {
		sample1();
		sample2();
		sample3();
		sample4();
		sample5();
		//sample6(); <- 무한 반복 메소드
		sample7();
	}

}
