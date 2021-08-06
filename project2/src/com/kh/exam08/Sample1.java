package com.kh.exam08;

import java.util.Arrays;

public class Sample1 {
	
	public static void example1() {
		Prac1 p = new Prac1();
		
		p.method1();
		p.method2(true);
		p.method2(1.13);
		p.method2(100);
		p.method2("hello");
		int x[] = {1,2,3,4};
		p.method2(x);
		
		System.out.println("메서드 실행 후 배열의 변화 -> " + Arrays.toString(x));
		
		p.method3(false, 100, 1.123);
		
		double y[] = {1.1, 2.1, 3.1};
		p.method3(x, y);
		System.out.println("메서드 실행 후 배열의 변화 -> " + Arrays.toString(x));
		System.out.println("메서드 실행 후 배열의 변화 -> " + Arrays.toString(y));
		
		p.method4();
		p.method4(1);
		p.method4(1, 2);
		p.method4(1, 2, 3, 4);
		
		MyData d = new MyData();
		p.method5(d);
		System.out.println(d.name + "|" + d.num + "|" + Arrays.toString(d.arr));
		
		p.method5(new MyData());
	}
	
	public static void example2() {
		Prac2 p = new Prac2();
		
		System.out.println(p.method1());
		System.out.println(p.method1(5));
		System.out.println(p.method1(3.14));
		
		int x = p.method1() * p.method1(3);
		System.out.println(x);
		
		System.out.println(p.method2(10) + " | " + p.method2(11));
		
		int a[] = p.method3(5);
		System.out.println(a + " | " + a.length + " | " + Arrays.toString(a));
		
		int b[] = p.method3(5, 10);
		System.out.println(b + " | " + b.length + " | " + Arrays.toString(b));
		
		p.method4();
		
		MyData2 data2 = p.method4();
		System.out.println(data2.num + " | " + data2.name + " | " + Arrays.toString(data2.arr));
		
		MyData2 data2_1 = p.method4("박인비");
		System.out.println(data2_1.num + " | " + data2_1.name + " | " + Arrays.toString(data2_1.arr));
		
	}

	public static void main(String[] args) {
		// example1();
		example2();
	}

}
