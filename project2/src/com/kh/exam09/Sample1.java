package com.kh.exam09;

public class Sample1 {

	public static void ex1() {
		Prac1 p = new Prac1();
		
		// 짝수 홀수 구분하여 짝수면 true 출력 홀수면 false 출력
		p.isEven(10);	p.isEven(11);
		
		// 짝수 홀수 구분하여 짝수면 false 출력 홀수면 true 출력
		p.isOdd(10);	p.isOdd(11);
		
		// 2의 배수면 true 출력 아니면 false 출력
		p.isMulti(10);	p.isMulti(15);
		
		// 3의 배수면 true 출력 아니면 false 출력
		p.isMulti(10, 3);	p.isMulti(15, 3);
		
		// 5의 배수면 true 출력 아니면 false 출력
		p.isMulti(10, 5);	p.isMulti(15, 5);
		
		// 가장 큰값을 출력
		p.max(10, 20);		p.max(20, 5);
		
		int arr1[] = {1, 7, 9, 3, 8};
		p.max(arr1);
		
		// 가장 작은값을 출력
		p.min(10, 20);		p.min(20, 5);
		
		int arr2[] = {1, 7, 9, 3, 8};
		p.min(arr2);
	}
	
	public static void ex2() {
		Prac2 p = new Prac2();
		
		// 짝수 홀수 구분하여 짝수면 true 리턴 홀수면 false 리턴
		System.out.println(p.isEven(10)); System.out.println(p.isEven(11));
		
		// 짝수 홀수 구분하여 짝수면 false 리턴 홀수면 true 리턴
		System.out.println(p.isOdd(10)); System.out.println(p.isOdd(10));
		
		// 2의 배수면 true 리턴 아니면 false 리턴
		System.out.println(p.isMulti(10)); System.out.println(p.isMulti(15));
		
		// 3의 배수면 true 리턴 아니면 false 리턴
		System.out.println(p.isMulti(10, 3)); System.out.println(p.isMulti(15, 3));
		
		// 5의 배수면 true 리턴 아니면 false 리턴
		System.out.println(p.isMulti(10, 5)); System.out.println(p.isMulti(15, 5));
		
		// 가장 큰값을 리턴
		System.out.println("둘 중 큰 값은 : " + p.max(10, 10));
		
		System.out.println("둘 중 큰 값은 : " + p.max(20, 5));
		
		
		int arr1[] = {1, 7, 9, 3, 8};
		System.out.println("배열 내에서 가장 큰 값은 : " + p.max(arr1));
		
		// 가장 작은값을 리턴
		System.out.println("둘 중 작은 값은 : " + p.min(10, 20));		
		System.out.println("둘 중 작은 값은 : " + p.min(20, 5));	
		
		int arr2[] = {1, 7, 9, 3, 8};
		System.out.println("배열 내에서 가장 작은 값은 : " + p.min(arr2));
	}
	
	public static void main(String[] args) {
		//ex1();
		ex2();
	}

}
