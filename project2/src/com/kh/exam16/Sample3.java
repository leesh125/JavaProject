package com.kh.exam16;

import java.util.Arrays;
import java.util.Scanner;

public class Sample3 {
	public static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		// 사용자 입력 한 번에 여러 데이터를 입력 받기.
		
		String input = sc.nextLine();
		String inputs[] = input.split(" ");
		int[] intArr = new int[inputs.length];
		for(int i=0; i<inputs.length; i++) {
			intArr[i] = Integer.parseInt(inputs[i]);
		}
		
		System.out.println(Arrays.toString(intArr));
		
	}
	
	public static void ex2() {
		// 영문자는 소문자로만 입력받기.
		System.out.print("소문자로만 입력하세요. : ");
		String input = sc.nextLine();
		input = input.toLowerCase();
		System.out.println(input);
	}
	
	public static void ex3() {
		// 금지어가 입력되는 것을 막기
		System.out.println("유튜브, 네이버, 카카오 는 금지어 입니다.");
		System.out.print("입력 : ");
		String input = sc.nextLine();
		if(input.indexOf("유튜브") >= 0 || input.indexOf("네이버") >= 0 ||
				input.indexOf("카카오") >= 0) {
					System.out.println("금지어가 발견되었습니다. 다시 입력하세요.");
				}
	}
	
	public static void ex4() {
		// 금지어가 입력되는 것을 막기
		System.out.println("유튜브, 네이버, 카카오 는 금지어 입니다.");
		System.out.print("입력 : ");
		String input = sc.nextLine();
		input = input.replace("유튜브", "*****")
					.replace("네이버", "*****")
					.replace("카카오", "*****");
		
		System.out.println(input);
	}

	public static void ex5() {
		// 금지어가 입력되는 것을 막기
		String[] words = new String[] {"유튜브", "네이버", "카카오"};
		System.out.println("유튜브, 네이버, 카카오 는 금지어 입니다.");
		System.out.print("입력 : ");
		String input = sc.nextLine();
		
		for(int i=0; i<words.length; i++) {
			input = input.replace(words[i], "*****");
		}
		
		// Another solution
//		for(String s: words) {
//			input = input.replace(s, "*****");			
//		}

		
		System.out.println(input);
	}
	public static void main(String[] args) {
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		ex5();

	}

}
