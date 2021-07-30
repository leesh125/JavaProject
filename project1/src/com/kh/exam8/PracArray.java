package com.kh.exam8;

import java.util.Random;
import java.util.Scanner;

public class PracArray {

	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	public static void ex1() {
		/*
		 *  길이가 10인 정수 배열을 선언하고 1 ~ 10까지의 값을 배열에
		 *  초기화하는 코드를 작성
		 * 
		 */
		
		int arr[] = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}

	public static void ex2() {
		/*
		 * 길이가 10인 정수 배열을 선언하고 짝수에 해당하는 값을 배열에
		 * 순차적으로 초기화하는 코드를 작성
		 * 
		 */
		
		int arr[] = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			
			arr[i] = i * 2 + 2;
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}

	public static void ex3() {
		/*
		 * 길이가 20 인 정수 배열을 선언하고 홀수에 해당하는 값을 배열에 순차적으로
		 * 초기화하는 코드를 작성
		 * 단, 99 부터 역순으로 초기화값을 저장한다.
		 * 
		 * int[] iArr = new int[20];
		 * int[0] = 99;	int[1] = 97;
		 * int[2] = 95;	int[3] = 93;
		 * ...
		 */
		
		int arr[] = new int[20];
		int j=0;
		for(int i=99; i>=arr.length; i -= 2) {
			if(j == 20)  break;
			arr[j] = i;
			System.out.print(arr[j] + " ");
			j++;
		}
		System.out.println();
	}
	
	public static void ex4() {
		/*
		 * 길이가 26 인 정수 배열을 선언하고 아스키 문자 영문자(대문자)를 순차적으로
		 * 초기화하는 코드를 작성
		 */
		int arr[] = new int[26];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%c ", i+65);
		}
		System.out.println();
	}
	
	public static void ex5() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 100 부터 배열의 크기만큼
		 * 초기화를 진행한다.
		 */
		System.out.print("1차원 배열의 크기 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		if(num<1) {
			System.out.println("배열의 크기는 0보다 작을 수 없습니다.");
			System.exit(0);
		}
		int arr[] = new int[num];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i + 100;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void ex6() {
		/*
		 * 생성할 배열의 크기를 사용자 입력을 이용하여 생성한 후 다시 사용자 입력을 이용하여
		 * 사용자가 직접 배열의 크기 만큼 초기화 할 수 있도록 한다.
		 * (생성 할 배열 타입은 문자열로 한다.)
		 */
		int j=0;
		System.out.print("1차원 배열의 크기 입력 : ");
		int num = sc.nextInt();  sc.nextLine();
		String sArr[] = new String[num];
		String str = "";
		
		for(int i=0; i<sArr.length; i++) {
			System.out.print("배열의 " + (i+1) + "번째 원소 입력 : ");
			str = sc.nextLine();
			sArr[i] = str;
		}
		while(j < sArr.length) {
			System.out.print(sArr[j]+ " ");
			j++;
		}
		
	}
	
	public static void ex7() {
		/*
		 * 2021년 7월에 한정하여 사용자 입력을 통해 일자 데이터를 입력 받고 해당하는 일자가
		 * 어떤 요일인지 알려주는 코드를 배열을 활용하여 작성한다.
		 */
		int day;
		char cArr[] = {'월', '화', '수', '목', '금', '토', '일'};
		
		System.out.print("원하는 일자를 입력 : ");
		day = sc.nextInt();   sc.nextLine();
		
		if(day <1 || day > 31) {
			System.out.println("1 ~ 31 사이를 입력해주세요.");
			System.exit(0);
		}
		
		switch(day % 7) {
			case 1:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[3] + "요일 입니다");
				break;
			case 2:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[4] + "요일 입니다");
				break;
			case 3:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[5] + "요일 입니다");
				break;
			case 4:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[6] + "요일 입니다");
				break;
			case 5:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[0] + "요일 입니다");
				break;
			case 6:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[1] + "요일 입니다");
				break;
			case 7:
				System.out.println("2021년 7월 " + day + "일은 " + cArr[2] + "요일 입니다");
				break;
			default :
				System.out.println("그런 요일은 없어요..");
				break;
		}
		
		
	}
	
	public static void ex8() {
		String str[] = {"가위","바위","보"};
		String me ="";
		String com ="";
		
		while(true) {
			int i = rd.nextInt(3);
			com = str[i];
			
			
			System.out.print("가위, 바위, 보 중 입력 : ");
			me = sc.nextLine();
			
				
			
			if(me == "가위") {
				if(com == "가위") {
					System.out.println("비김");
				}
				else if(com == "보") {
					System.out.println("내가 이김!");
				}
				else if(com == "바위") {
					System.out.println("내가 짐 ㅠ");
				}
			}
			else if(me == "바위") {
				if(com == "바위") {
					System.out.println("비김");
				}
				else if(com == "가위") {
					System.out.println("내가 이김!");
				}
				else if(com == "보") {
					System.out.println("내가 짐 ㅠ");
				}
			}
			else if(me == "보") {
				if(com == "보") {
					System.out.println("비김");
				}
				else if(com == "바위") {
					System.out.println("내가 이김!");
				}
				else if(com == "가위") {
					System.out.println("내가 짐 ㅠ");
				}
			}
			
			System.out.println("=================\n");
		}
		
	}
	
	public static void main(String[] args) {
		// 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
		
//		ex1();
//		ex2();
//		ex3();
//		ex4();
//		ex5();
//		ex6();
//		ex7();
		ex8();
	}

}
