package com.kh.exam8;

import java.util.*;

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
		// 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
		String str[] = {"가위","바위","보"};
		String me ="";
		String com ="";
		
		while(true) {
			int i = rd.nextInt(3);
			com = str[i];
			
			
			System.out.print("가위, 바위, 보 중 입력(그만하고 싶은 z입력후 엔터) : ");
			me = sc.nextLine();  
			
			if(me.equals("z")) break;
				
			
			if(me.equals("가위")) {
				if(i == 0) {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 가위");
					System.out.println("비김");
				}
				else if(i == 2) {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 가위");
					System.out.println("내가 이김!");
				}
				else if(i == 1) {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 가위");
					System.out.println("내가 짐 ㅠ");
				}
			}
			else if(me.equals("바위")) {
				if(com == "바위") {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 바위");
					System.out.println("비김");
				}
				else if(com == "가위") {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 바위");
					System.out.println("내가 이김!");
				}
				else if(com == "보") {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 바위");
					System.out.println("내가 짐 ㅠ");
				}
			}
			else if(me.equals("보")) {
				if(com == "보") {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 보");
					System.out.println("비김");
				}
				else if(com == "바위") {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 보");
					System.out.println("내가 이김!");
				}
				else if(com == "가위") {
					System.out.println("컴퓨터 : " + str[i] + ", 나 : 보");
					System.out.println("내가 짐 ㅠ");
				}
			}else {
				System.out.println("가위, 바위, 보 중 입력!!\n");
				continue;
			}
			
			System.out.println("=================\n");
		}
		
	}
	public static void ex9() {
		// 업앤 다운. -> 임의의 값을 하나 생성하고 사용자가 일정 범위의 정수값 안에서 정수를 입력하면
		//            미리 생성된 값과 비교를 통해 업 또는 다운 으로 힌트를 주어 최종 생성값을 맞추는 게임.
		int num, ran, max = 100, min = 1;
		
		while(true) {
			System.out.println("업 앤 다운 게임 시작!\n");
			
			ran = rd.nextInt(100)+1;
			
			while(true) {
				System.out.print(min + " ~ " + max + "사이의 수 입력 (그만하고 싶은 0입력후 엔터) :");
				num = sc.nextInt();    sc.nextLine();
				
				if(num == 0) break;
				
				if(num < 1 && num > 100) {
					System.out.println("1 ~ 100 사이 입력!!!\n");
					continue;
				}

				if(num > ran) {
					System.out.println("다운\n");
					max = num;
					continue;
				}else if( num < ran) {
					System.out.println("업\n");
					min = num;
					continue;
				}else if(num == ran) {
					System.out.println("정답!! (임의의 수 : " + ran + " )\n" );
					break;
				}
			}
			
			System.out.println("\n=================\n");
			break;
		}
		System.out.println("게임 종료");
	}
	
	public static void ex10() {
		// 바쁜 직장인들을 위해 미리 선정된 점심 메뉴를 임의로 선택하여 제공하는 프로그램.
		//     1. 미리 선정된 메뉴를 사용하여 임의로 제공.
		//     2. 사용자가 직접 메뉴를 입력하여 임의의 메뉴가 선택될 수 있도록 제공.
		
		List<String> menu = new ArrayList<String>();
		menu.add("짜장면");  menu.add("배떡");  menu.add("강준치");  
		
		List<String> addMenu = new ArrayList<String>();
		
		
		int heart = rd.nextInt(3);
		int count = 0;
		int ran = rd.nextInt(3);
		String myMenu = "";
		
		while(true) {
			System.out.println("오늘의 점심은 " + menu.get(ran) + " 입니다!");
			while(true) {
				System.out.print( menu.get(ran) + "이 맘에 들면 1, 맘에 들지 않으면 2, 메뉴 선택 혹은 추가는 3을 눌러주세요");
				heart = sc.nextInt();   sc.nextLine();		
				
				if(heart == 1) {
					System.out.println("오늘의 메뉴는 : " + menu.get(ran) + " 입니다.");
					System.exit(0);
				}else if(heart == 2) {
					if(ran == 2) {
						ran = 0;
					}else {
						ran = (ran % 3) + 1; 
					}
					count = (count % 3) + 1; 
					
					if(count >= 3) {
						System.out.println("우리는 메뉴가 "+ menu.size() +"개뿐입니다..\n");
						continue;
					}
					
					System.out.print("다른 추천 메뉴는 " );
					
					if(ran >= 3)
						ran = 0;
					
					System.out.println(menu.get(ran) + "입니다.");
					continue;
				}else if(heart == 3) {
					System.out.print("원하는 메뉴를 입력해주세요 :");
					myMenu = sc.nextLine();
					
					if(myMenu.equals("강준치")) {
						System.out.println("오늘의 메뉴는 강준치 입니다.");
						System.exit(0);
					}else if(myMenu.equals("배떡")) {
						System.out.println("오늘의 메뉴는 배떡 입니다.");
						System.exit(0);
					}else if(myMenu.equals("짜장면")) {
						System.out.println("오늘의 메뉴는 짜장면 입니다.");
						System.exit(0);
					}else {
						System.out.println(myMenu +"는 오늘부로 주문해서 내일 드실 수 있습니다.\n");
						addMenu.add(myMenu);
						continue;
					}
					
				}
				System.out.println("오늘의 메뉴는  " + menu.get(ran) + " 입니다.");
				break;
			}
			
		}
		
		
	}
	
	public static void ex11() {
		// 사용자 입력을 통해 과목 정보를 입력 받는다.
		// 사용자 입력이 계속 이루어 질 때마다 배열의 크기를 +1씩 늘려 입력한만큼 저장하게 한다.
		// 사용자 입력이 종료인 경우 더이상 입력을 받지 않고 최종 입력된 모든 과목 정보를 출력.
		String sub[] = new String[0];
		String inp = "";
		
		while(true) {
			System.out.print("추가할 과목을 입력 : ");
			inp = sc.nextLine();
			
			if(inp.equals("종료")) {
				break;
			}else {
				String sub2[] = new String[sub.length + 1];
				for(int i=0; i<sub.length; i++) {
					sub2[i] = sub[i];
				}
				sub = sub2;
				sub[sub.length - 1] = inp;
				
			}
		}
		for(int i=0; i<sub.length; i++) {
			System.out.print("추가한 " + (i+1) + " 번째 과목 : " + sub[i]);
			System.out.println();
		}
		
	}
	
	public static void ex12() {
		/*
		 * 1 ~ 49 사이의 정수 값을 사용자 입력을 통해 입력 받고 이를 정수 배열에 저장을 한다.
		 * -1 이 입력될 때 까지 배열의 크기를 +1씩 증가시키면서 사용자 입력 값을 배열에 저장을 하며
		 * -1 이 입력되어 더 이상 사용자 입력을 받지 않을 때 배열에 저장된 모든 값의 합을 출력한다.
		 */
		int arr[] = new int[0];
		int num, sum=0;
		
		while(true) {
			System.out.print("1 ~ 49 사이의 정수 입력(종료는 -1 입력 후 엔터) : ");
			num = sc.nextInt();  sc.nextLine();
			
			if(num == -1) {
				break;
			}else if(num < 1 || num >49) {
				System.out.println(" 1 ~ 49 사이 정수 입력!!!!!\n");
				continue;
			}else {
				int copyArr[] = new int[arr.length + 1];
				for(int i=0; i<arr.length; i++) {
					copyArr[i] = arr[i];
				}
				arr = copyArr;
				arr[arr.length - 1] = num;
			}
		}
		
		if(arr.length > 0) {
			for(int i=0; i<arr.length; i++) {
				sum += arr[i];
			}
			
			System.out.println("작성한 정수 배열에 모든 원소의 합은 : " + sum);
		}else {
			System.out.println("원소 입력을 안했습니다.");
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
//		ex9();
//		ex10();
//		ex11();
//		ex12();

	}

}
