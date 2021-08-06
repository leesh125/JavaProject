package com.kh.exam7;

import java.util.Scanner;

public class PracWhile {

	static Scanner sc = new Scanner(System.in);

	public static void ex1() {
		/*
         * 영문자 소문자 a ~ z 까지 츨력하시오.
         * 
         * a, b, c, d, e, f, g ... x, y, z
         */
		char c = 'a';
		while(c <= 'z') {
			System.out.print(c++ + ", ");
			}
	}
	
	public static void ex2() {
		/*
         * 영문자 대문자를 역순으로 츨력하시오.
         * 
         * Z, Y, X, ... D, C, B, A
         */
		char c = 'Z';
		while(c >= 'A') {
			System.out.print(c-- + " ");
		}
	}
	
	public static void ex3() {
		/*
         * 다음과 같은 형식의 출력이 나오도록 하시오.
         * 
         * 1	2	3	4	5
         * 6	7	8	9	10
         * 11	12	13	14	15
         * 16	17	18	19	20
         */
		int n = 1;
		while(n <= 20) {
			System.out.printf("%-5d",n);
			if(n % 5 ==0)
				System.out.println();
			n++;
		}
	}
	
	public static void ex4() {
		/*
    	 * 사용자가 입력한 정수값 범위에 해당하는 값만 출력하시오.
    	 * 
    	 * 예)
    	 * 		최소값 : 11
    	 * 		최대값 : 99
    	 * 		열 수 : 10
    	 * 
    	 * 		11	12	13	14	15	16	17	18	19	20
    	 * 		21	22	23	24	25	26	27	28	29	30
    	 * 		...
    	 * 		...
    	 * 		91	92	93	94	95	96	97	98	99	
    	 */
		
		int num = 0, min, max, col;
		
		
		System.out.print("최소값 : ");
		min = sc.nextInt();   sc.nextLine();
		
		System.out.print("최대값 : ");
		max = sc.nextInt();   sc.nextLine();
		
		if(min >= max) {
			System.out.println("최소값은 최대값보다 클 수 없습니다.");
			System.exit(0);
		}
		System.out.print("열 수  : ");
		col = sc.nextInt();   sc.nextLine();
		
		num = min;
		
		while(num <= max) {
			System.out.printf("%-5d", num);
			if(num % col == 0 && num != col)
				System.out.println();
			num++;
		}
	}
	
	public static void ex5() {
		/*
         * 100 ~ 999 범위에 해당하는 배수 값을 출력한다.
         * 출력할 배수 값은 사용자 입력을 통해 알아낸다.
         * 
         * 예)
         * 		배수 값 : 13
         * 		104		117		130		143		156	
         * 		169		...		
         * 		...
         * 		...		...		...		988		
         */
		
		int num, max=0, j=0, i=1;
		
		System.out.print("배수 값 : ");
		num = sc.nextInt();  sc.nextLine();
		
		
		while(max < 1000) {
			max = num * i; 
			
			if(max >= 1000) {
				break;
			}
			if(max > 100) {
				System.out.printf("%-5d", max);
				j++;
			}
			if(j % 5 == 0 && max >100)
				System.out.println();
			
			i++;
		}
	}
	
	public static void ex6() {
        /*
         * 사용자로 부터 임의의 문자열을 입력 받은 후
         * a, e, i, o, u 문자가 얼마나 포함되어 있는지 확인하는 코드를 작성한다.
         * 
         * Tip 1.) 사용자가 입력한 문자열의 문자를 탐색하기 위해 .charAt(index) 메서드를
         * 활용한다.
         * 		String text = "hello";
         * 		text.charAt(0); // 'h'
         * 		text.charAt(1); // 'e'
         * 		text.charAt(2); // 'l'
         * 
         * Tip 2.) 문자열의 길이를 알기 위해 .length() 메서드를 사용한다.
         * 		String text = "hello";
         * 		text.length(); // 5
         */
		
			
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		int sum = 0, j=0;
		int arr[] = new int[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		while(j < str.length()) {
			switch(arr[j]) {
				case 'a':
					sum++;
					break;
				case 'e':
					sum++;
					break;
				case 'i':
					sum++;
					break;
				case 'o':
					sum++;
					break;
				case 'u':
					sum++;
					break;
			}
			
			j++;		
		}
		if(sum > 0) {
			System.out.println("입력한 문장에서 a,e,i,o,u는 총 " + sum + "개 있습니다.");
		}else {
			System.out.println("입력한 문장에서 a,e,i,o,u는 없습니다.");
		}
    }
	
	public static void main(String[] args) {
		
//		ex1();
//		ex2();
//		ex3();
//		ex4();
		ex5();
//		ex6();
	}

}
