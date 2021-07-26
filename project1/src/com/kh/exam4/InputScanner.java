package com.kh.exam4;

import java.util.Scanner;

public class InputScanner {

	// 클래스 변수 : 클래스 안 어느 곳에서도 사용 가능
	static Scanner sc = new Scanner(System.in);

	// 메서드
	public static void main(String[] args) {
		// 지역 변수 : 소속된 메서드 안에서만 사용 가능
		
		System.out.print("당신의 나이를 입력하세요 : ");
		int age;
		age = sc.nextInt();
		
		// nextInt()로 입력받은 정수값 뒤에 \r\n 값이 있어서 이를 처리하기 위해 사용.
		sc.nextLine(); 
		
		System.out.print("당신의 이름을 입력하세요 : ");
		String name;
		name = sc.nextLine();
		
		
		
		
		System.out.printf("당신의 이름은 %s, 나이는 %d 입니다.",name, age);
	}

}
