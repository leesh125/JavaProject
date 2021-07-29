package com.kh.exam7;

import java.util.Scanner;

public class LoopStatement1 {
	
	public static void sample1() {
		int i = 1;
		while(i <= 5) {
			System.out.println(i + " 번째 반복");
			i++;
		}
	}
	
	public static void sample2() {
		int i = 5;
		while(i >= 1) {
			System.out.println(i + " 입니다.");
			i--;
		}
	}
	
	public static void sample3() {
		while(true) {
			System.out.println("무한반복 입니다.");
		}
	}
	
	public static void sample4() {
			int i = 1;
			while(true) {
				System.out.println("반복문 안에 종료 조건을 만들어서 사용.");
				if(i == 1) {
					break;
				}
			}
	}
	
	public static void sample5() {
		// 무조건 1번은 반복
		int num;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("정수 값 입력(11 이상 입력) : ");
			num = sc.nextInt();   sc.nextLine();
		} while(num < 10);
		System.out.println("반복 끝");
	}
	
	
	public static void main(String[] args) {
//		sample1();
//		sample2();
//		sample3();
//		sample4();
		sample5();

		
	}

}
