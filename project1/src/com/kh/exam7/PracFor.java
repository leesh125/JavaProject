package com.kh.exam7;

import java.lang.reflect.Array;
import java.util.Scanner;

public class PracFor {

	static Scanner sc = new Scanner(System.in);
	
	public static void ex1() {
		System.out.println("문제 1.");
		/*
		 * 정수값을 입력받아 1 부터 입력받은 값까지 1씩 증가된 값을 출력하는
		 * 코드를 작성한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		1
		 * 		2
		 * 		3
		 */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		for(int i=1; i<=num; i++) {
			System.out.println(i);
		}
		
	}
	
	public static void ex2() {
		System.out.println("문제 2.");
		/*
		 * 정수값을 입력받고 입력받은 값부터 1씩 감소된 값을 출력하는 코드를 작성한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		3
		 *		2 
		 *		1
		 */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		for(int i=num; i>0; i--) {
			System.out.println(i);
		}
		
	}
	
	public static void ex3() {
		System.out.println("문제 3.");
		/*
		 * 정수값을 입력받을 때 지정된 범위의 입력값이 아닌 경우 최대 3번 다시
		 * 입력 받을 수 있도록 하는 코드를 작성한다.
		 * (지정된 범위는 1 ~ 100 사이의 값이다.)
		 */
		int res=0;
		for(int i=1; i<=3; i++) {
			
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();  sc.nextLine();
			if(num >= 1 && num <=100) {
				//System.out.println(num);
				res = num;
				break;
			}else if(i==3) {
				System.out.println("3번의 기회를 놓쳤습니다..");
				break;
			}else{
				System.out.println("다시 입력 (1~100사이의 값)");
			}
			
		}
		
		if(res != 0)
			System.out.println("입력한 정수의 값은 : " + res);
		
	}
	public static void ex4() {
		System.out.println("문제 4.");
		/*
		 * ex1() 처럼 동작하는 코드를 작성한다. 단, 출력 메시지는 다음과 같이 나오도록 한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		1 2 3 
		 */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		for(int i=1; i<=num; i++) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}

	public static void ex5() {
		System.out.println("문제 5.");
		/*
		 * ex4() 처럼 동작하는 코드를 작성한다. 단, 1 부터 시작하는 값이 아닌 100 부터 시작하는
		 * 형태로 나오게 한다.
		 * 
		 * 예)
		 * 		정수 입력 : 3
		 * 		100 101 102
		 */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		for(int i=1; i<=num; i++) {
			System.out.print((i+99)+ " ");
		}
		System.out.println();
	}

	public static void ex6() {
		System.out.println("문제 6.");
		/*
		 * 정수값을 입력받아 1 부터 입력받은 값까지 1씩 증가된 값을 누적하여 합을 구하는 코드를
		 * 작성한다.
		 * 
		 * 예 1.)
		 * 		정수 입력 : 3
		 * 		누적합 : 6
		 * 
		 * 예 2.)
		 * 		정수 입력 : 5
		 * 		누적합 : 15
		 * 
		 * 예 3.)
		 * 		정수 입력 : 10
		 * 		누적합 : 55
		 */
		int sum=0;
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.println("누적합 : " + sum);
		
		
	}
	public static void ex7() {
		/*
		 * 정수값을 입력받아 1 부터 입력받은 값까지 출력을 하는 코드를 작성한다. 단, 3의 배수에
		 * 해당하는 값만을 출력하도록 한다.
		 * 
		 * 예)
		 * 		정수 입력 : 10
		 * 		3 6 9
		 */
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		if(num>=3) {
			for(int i=3; i<=num; i+=3) {
				System.out.print(i + " ");
			}
		}else {
			System.out.println("당신은 3보다 작은 수를 입력했습니다.");
		}
		
	}

	public static void ex8() {
		/*
		 * 사용자가 입력한 문자열을 기반으로 파일명이 자동으로 생성되는 프로그램을 만들려고 한다.
		 * 다음의 요구 사항을 파악하여 사용자가 원하는 기능이 동작하도록 코드를 작성하시오.
		 * 
		 * 1. 임의의 파일명을 입력할 수 있어야 한다.
		 * 2. 파일은 1개를 생성할 수도 있지만 원하는 경우 2개 이상도 생성할 수 있다.
		 * 3. 만약 2개 이상의 파일을 생성하는 경우 2번째 파일 부터는 파일명 뒤에 "[2]" 접미사가 붙는다.
		 * 4. 3번 요구사항의 접미사 숫자값은 2 로 고정하는 것이 아니라 파일 수에 맞추어 1씩 증가해야 한다.
		 * 
		 * 예)
		 * 		파일명 입력 : newFile
		 * 		생성 파일수 : 1
		 * 		결과
		 * 			newFile 생성 완료!
		 * 
		 * 예)
		 * 		파일명 입력 : newFile
		 * 		생성 파일수 : 3
		 * 		결과
		 * 			newFile 생성 완료!
		 * 			newFile[2] 생성 완료!
		 * 			newFile[3] 생성 완료!
		 */
//		String filename = "";
//		int num=0;
//		System.out.print("파일명 입력 : ");
//		filename = sc.nextLine();
//		
//		System.out.print("생성 파일 수 : ");
//		num = sc.nextInt(); sc.nextLine();
//		
//		System.out.println("결과:");
//		
//		if(num <= 0) {
//			System.out.println("파일 수는 1개보다 작을 수 없습니다. 양수로 입력!");
//			System.exit(0);
//		}
//		for(int i=1; i<=num; i++) {
//			
//			if(i==1) {
//				System.out.println("\t" + filename+ " 생성 완료!");
//			}else if(i>1) {
//				System.out.println("\t"+ filename + "[" + i + "] 생성 완료! " );
//			}
//		}
		
		// 배열 방식
		System.out.print("파일명 입력 : ");
		String filename = sc.nextLine();
		
		System.out.print("생성 파일 수 : ");
		int num = sc.nextInt(); sc.nextLine();
		
		if(num <= 0) {
			System.out.println("파일 수는 1개보다 작을 수 없습니다. 양수로 입력!");
			System.exit(0);
		}
			
		System.out.println("결과:");
		
		String[] arr = new String[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = filename;
			if(i==0) {
				System.out.println("\t" + filename+ " 생성 완료!");
			}else if(i>0) {
				System.out.println("\t"+ filename + "[" + (i+1) + "] 생성 완료! " );
			}
		}
		
		
	}
	
	public static void ex9() {
		/*
		 * 사칙연산 계산기 프로그램
		 * 간단한 사칙 연산을 수행하는 계산기 프로그램 코드를 작성하시오.
		 * 
		 * 예 1.)
		 * 		숫자 입력1 : 10
		 * 		연산자 입력 : +
		 * 		숫자 입력2 : 20
		 * 		결과
		 * 			10 + 20 = 30
		 * 
		 * 예 2.)
		 * 		숫자 입력1 : 10
		 * 		연산자 입력 : /
		 * 		숫자 입력2 : 20
		 * 		결과
		 * 			10 / 20 = 0.5
		 */
		
		int num1,num2;
		int rep = 1;
		char op;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			num1 = sc.nextInt();   sc.nextLine();
			
			System.out.print("연산자 입력 : ");
			op = sc.nextLine().charAt(0);
			
			System.out.print("숫자 입력 : ");
			num2 = sc.nextInt();   sc.nextLine();
			
			if(op == '+' | op == '-' | op == '*'| op == '/')
				System.out.println("결과");
			
			
			switch(op) {
				case '+':
					System.out.println("\t" + num1 + " " + op + " " + num2
										+ " = " + (num1+num2));
					break;
				case '-':
					System.out.println("\t" + num1 + " " + op + " " + num2
										+ " = " + (num1-num2));
					break;
				case '*':
					System.out.println("\t" + num1 + " " + op + " " + num2
										+ " = " + (num1*num2));
					break;
				case '/':
					System.out.print("\t" + num1 + " " + op + " " + num2
										+ " = ");
					System.out.printf("%.2f",((double)num1/num2));

					break;
				default :
					rep--;
					System.out.println("사칙연산 기호만 가능합니다.(+,-,*,/)\n");
					System.out.println("\n 총 " + rep + "번 연산 끝");
					System.exit(0);
			}
			System.out.println("\n 총" + rep + "번 연산 끝");
			System.out.println("================\n");
			rep++;
		}
		
	}
	
	

	public static void main(String[] args) {
//		ex1();
//		ex2();
//		ex3();
//		ex4();
//		ex5();
//		ex6();
//		ex7();
//		ex8();
		ex9();

	}

}
