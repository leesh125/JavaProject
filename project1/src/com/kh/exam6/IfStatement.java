package com.kh.exam6;

import java.util.Scanner;

public class IfStatement {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a;
		
		System.out.print("a 정수 입력 :");
		a = sc.nextInt();
		
		if(a>10) {
			System.out.println("a는 10보다 큼");
		}
		
		int b;
		System.out.print("b 정수 입력 :");
		b=sc.nextInt(); 
		
		if(b % 5 == 0) {
			System.out.println("b는 5의 배수");
		} else {
			System.out.println("b는 5의 배수가 아님");
		}

	}

}
