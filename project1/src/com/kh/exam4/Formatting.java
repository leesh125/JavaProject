package com.kh.exam4;

public class Formatting {

	public static void main(String[] args) {
		int age = 34;
		String name = "홍길동";
		
		System.out.printf("%s님의 나이는 %d 입니다.\n", name, age);

		double temp = 37.8;
		System.out.printf("현재의 온도는 %f 도 입니다\n", temp);
		System.out.printf("현재의 온도는 %.2f 도 입니다\n", temp);

	}

}
