package com.kh.rand.menu;

import java.util.Random;
import java.util.Scanner;

public class RandomMenu {

	public static void main(String[] args) {
		/*
		 * 
			미리 선정된 아침, 점심, 저녁, 야식, 안주 메뉴를 임의로 선택하여 제공하는 프로그램
			
			1. 정해진 메뉴를 배열로 만들고 사용자가 메뉴 추가를 원하는 경우 해당하는 아침,
			   점심, 저녁... 의 메뉴로 추가 가능
			
			프로그램 메뉴
			  1. 아침 랜덤 선택
			  2. 점심 랜덤 선택
			  3. 저녁 랜덤 선택
			  4. 야식 랜덤 선택
			  5. 안주 랜덤 선택
			  6. 메뉴 추가
			
			  입력 : 6
			
			  1. 아침 메뉴 추가
			  2. 점심 메뉴 추가
			  3. 저녁 메뉴 추가
			  4. 야식 메뉴 추가
			  5. 안주 메뉴 추가
			
			  입력 : 2
			
			  메뉴 입력 : 라면+김밥
			  점심 메뉴에 "라면+김밥" 이 추가되었습니다.
			
			  1. 아침 랜덤 선택
			  2. 점심 랜덤 선택
			  3. 저녁 랜덤 선택
			  4. 야식 랜덤 선택
			  5. 안주 랜덤 선택
			  6. 메뉴 추가
			
			  입력 : 
		 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int ran;
		String addMenu = "";
		
		String food[][] = new String[5][];
		food[0] = new String[] {"해장국", "순대국"};
		food[1] = new String[] {"빅맥 세트", "돈까스"};
		food[2] = new String[] {"곱창", "피자"};
		food[3] = new String[] {"족발", "떡볶이"};
		food[4] = new String[] {"감자튀김", "오돌뼈"};

		int inp,count=0;
		
		while(true) {
			System.out.println("프로그램 메뉴");
			System.out.println("  1 . 아침 랜덤 선택");
			System.out.println("  2 . 점심 랜덤 선택");
			System.out.println("  3 . 저녁 랜덤 선택");
			System.out.println("  4 . 야식 랜덤 선택");
			System.out.println("  5 . 안주 랜덤 선택");
			System.out.println("  6 . 메뉴추가");
			System.out.println("  7 . 종료");
			System.out.println();
			System.out.print("  입력 : ");
			inp = sc.nextInt();    sc.nextLine();
			
			if(inp == 1) {
				ran = rd.nextInt(food[0].length);
				System.out.println("랜덤 아침 메뉴는 " + food[0][ran]);
				
				while(true) {
					System.out.print("맘에 들면 1, 별로면 2, 메뉴창은 3 : ");
					inp = sc.nextInt();  sc.nextLine();
					if(inp == 1) {
						System.out.println("아침 메뉴는 " + food[0][ran] + " 입니다.\n");
	
						break;
					}else if(inp == 2) {
						ran++;
						if(ran >= food[0].length)
							ran = 0;
						if(count >= food[0].length) {
							System.out.println("우리 아침 메뉴는 " + food[0].length +"개 뿐입니다...");
							count = 0;
						}
							
						System.out.println("다른 추천 아침메뉴는 " + food[0][ran]);
						System.out.println();
						count++;
						continue;
					}else if(inp == 3) {
						System.out.println();
						break;
					}
				}
				continue;
			}else if(inp == 2) {
				ran = rd.nextInt(food[1].length);
				System.out.println("랜덤 점심 메뉴는 " + food[1][ran]);
				System.out.println("맘에 들면 1, 별로면 2, 메뉴창은 3");
				inp = sc.nextInt();  sc.nextLine();
				if(inp == 1) {
					System.out.println("점심 메뉴는 " + food[1][ran] + " 입니다.\n");

					continue;
				}else if(inp == 2) {
					ran++;
					if(ran >= food[1].length )
						ran = 0;
					System.out.println("다른 추천 점심메뉴는 " + food[1][ran]);
					System.out.println();
					continue;
				}else if(inp == 3) {
					System.out.println();
					continue;
				}
			}else if(inp == 3) {
				ran = rd.nextInt(food[2].length);
				System.out.println("랜덤 저녁 메뉴는 " + food[2][ran]);
				System.out.println("맘에 들면 1, 별로면 2, 메뉴창은 3");
				inp = sc.nextInt();  sc.nextLine();
				if(inp == 1) {
					System.out.println("저녁 메뉴는 " + food[2][ran] + " 입니다.\n");

					continue;
				}else if(inp == 2) {
					ran++;
					if(ran >= food[2].length )
						ran = 0;
					System.out.println("다른 추천 저녁메뉴는 " + food[2][ran]);
					System.out.println();
					continue;
				}else if(inp == 3) {
					System.out.println();
					continue;
				}
			}else if(inp == 4) {
				ran = rd.nextInt(food[3].length);
				System.out.println("랜덤 야식 메뉴는 " + food[3][ran]);
				System.out.println("맘에 들면 1, 별로면 2, 메뉴창은 3");
				inp = sc.nextInt();  sc.nextLine();
				if(inp == 1) {
					System.out.println("야식 메뉴는 " + food[3][ran] + " 입니다.\n");

					continue;
				}else if(inp == 2) {
					ran++;
					if(ran >= food[3].length )
						ran = 0;
					System.out.println("다른 야식 아침메뉴는 " + food[3][ran]);
					System.out.println();
					continue;
				}else if(inp == 3) {
					System.out.println();
					continue;
				}
			}else if(inp == 5) {
				ran = rd.nextInt(food[4].length);
				System.out.println("랜덤 안주 메뉴는 " + food[4][ran]);
				System.out.println("맘에 들면 1, 별로면 2, 메뉴창은 3");
				inp = sc.nextInt();  sc.nextLine();
				if(inp == 1) {
					System.out.println("안주 메뉴는 " + food[4][ran] + " 입니다.\n");

					continue;
				}else if(inp == 2) {
					ran++;
					if(ran >= food[4].length )
						ran = 0;
					System.out.println("다른 추천 안주메뉴는 " + food[4][ran]);
					System.out.println();
					continue;
				}else if(inp == 3) {
					System.out.println();
					continue;
				}
			}else if(inp == 6) {
				System.out.println();
				System.out.println("  1 . 아침 메뉴 추가");
				System.out.println("  2 . 점심 메뉴 추가");
				System.out.println("  3 . 저녁 메뉴 추가");
				System.out.println("  4 . 야식 메뉴 추가");
				System.out.println("  5 . 안주 메뉴 추가");
				System.out.println();
				System.out.print("  입력 : ");
				inp = sc.nextInt();  sc.nextLine();
				
				System.out.print("메뉴 입력 : ");
				addMenu = sc.nextLine();    
				
				if(inp == 1) {
					String copyArr[] = new String[food[0].length + 1];
					System.arraycopy(food[0], 0, copyArr, 0, food[0].length);
					food[0] = copyArr;
					food[0][food[0].length-1] = addMenu;
					System.out.println("추가된 아침 메뉴 : " + addMenu);
					System.out.println();
					continue;
				}else if(inp == 2) {
					String copyArr[] = new String[food[1].length + 1];
					System.arraycopy(food[1], 0, copyArr, 0, food[1].length);
					food[1] = copyArr;
					food[1][food[1].length-1] = addMenu;
					System.out.println("추가된 아침 메뉴 : " + addMenu);
					System.out.println();
					continue;
				}
				else if(inp == 3) {
					String copyArr[] = new String[food[2].length + 1];
					System.arraycopy(food[2], 0, copyArr, 0, food[2].length);
					food[2] = copyArr;
					food[2][food[2].length-1] = addMenu;
					System.out.println("추가된 아침 메뉴 : " + addMenu);
					System.out.println();
					continue;
				}
				else if(inp == 4) {
					String copyArr[] = new String[food[3].length + 1];
					System.arraycopy(food[3], 0, copyArr, 0, food[3].length);
					food[3] = copyArr;
					food[3][food[3].length-1] = addMenu;
					System.out.println("추가된 아침 메뉴 : " + addMenu);
					System.out.println();
					continue;
				}
				else if(inp == 5) {
					String copyArr[] = new String[food[4].length + 1];
					System.arraycopy(food[4], 0, copyArr, 0, food[4].length);
					food[4] = copyArr;
					food[4][food[4].length-1] = addMenu;
					System.out.println("추가된 아침 메뉴 : " + addMenu);
					System.out.println();
					continue;
				}
			}else {
				System.exit(0);
			}
			

		}
	}

}
