package com.kh.example.menu.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.example.menu.controller.BreakfastController;
import com.kh.example.menu.controller.DinnerController;
import com.kh.example.menu.controller.LunchController;

public class MenuView {
	private Scanner sc = new Scanner(System.in);
	private BreakfastController bc = new BreakfastController();
	private LunchController lc = new LunchController();
	private DinnerController dc = new DinnerController();
	private int menu1, menu2, randomChoice;
	private int b=1, l=1 ,d=1, rdb=1, rdl=1, rdd=1;
	private Calendar cal = Calendar.getInstance();
	private int hour_of_day = cal.get(Calendar.HOUR_OF_DAY);
	private int hour = cal.get(Calendar.HOUR);;
	int min = cal.get(Calendar.MINUTE);
	int sec = cal.get(Calendar.SECOND);
	private String beforeNoonNow = "현재 시각은 오전 " + hour + "시 " + min + "분 " + sec + "초 입니다.";
	private String afterNoonNow = "현재 시각은 오후 " + hour + "시 " + min + "분 " + sec + "초 입니다.";
	
	public void mainMenu() {
		System.out.println("===== 식사 선택 =====");
		System.out.println("1. 아침");
		System.out.println("2. 점심");
		System.out.println("3. 저녁");
		System.out.println("7. 오늘의 추천!");
		System.out.println("9. 종료");
		System.out.print("메뉴 번호 : ");
		menu1 = sc.nextInt(); sc.nextLine();
		
		
		if(menu1 == 1) {
			this.breakfastMenu();
		}else if(menu1 == 2){
			this.lunchMenu();
		}else if(menu1 == 3){
			this.dinnerMenu();
		}else if(menu1 == 7) {
			if(hour_of_day / 12 >= 1) {
				System.out.println(afterNoonNow);
			}
			else{
				System.out.println(beforeNoonNow);
			}
			
			if(hour_of_day >= 6 && hour_of_day < 12) {
				if(rdb==1) {
					bc.setBreakfastArr();
				}
				bc.printRandBreakfast();
				while(true) {
					rdb++;
					System.out.print("맘에 들면 1, 아니면 2 : ");
					randomChoice = sc.nextInt(); sc.nextLine();
					if(randomChoice == 1) {
						System.out.println(bc.printBreakfastFood(bc.getGetChoice1(), bc.getGetChoice2()));
						this.mainMenu();  break;
					}else if(randomChoice == 2){
						this.mainMenu(); break;
					}
				}
			}else if(hour_of_day >= 12 && hour_of_day < 16) {
				if(rdl==1) {
					lc.setLunchArr();
				}
				lc.printRandLunch();
				while(true) {
					rdb++;
					System.out.print("맘에 들면 1, 아니면 2 : ");
					randomChoice = sc.nextInt(); sc.nextLine();
					if(randomChoice == 1) {
						System.out.println(lc.printLunchFood(lc.getGetChoice1(), lc.getGetChoice2()));
						this.mainMenu();  break;
					}else if(randomChoice == 2){
						this.mainMenu(); break;
					}
				}
			}else if(hour_of_day >= 16 && hour_of_day < 23) {
				if(rdd==1) {
					dc.setDinnerArr();
				}
				dc.printRandDinner();
				while(true) {
					rdb++;
					System.out.print("맘에 들면 1, 아니면 2 : ");
					randomChoice = sc.nextInt(); sc.nextLine();
					if(randomChoice == 1) {
						System.out.println(dc.printDinnerFood(dc.getGetChoice1(), dc.getGetChoice2()));
						this.mainMenu();  break;
					}else if(randomChoice == 2){
						this.mainMenu(); break;
					}
				}
			}else {
				System.out.println("오늘의 추천! 메뉴가 마감되었습니다. 지금은 잘 시간zzZ");
				this.mainMenu();
			}
			
		}else {
			System.out.println("종료합니다.");
			System.exit(0);
		}
		
	}



	private void breakfastMenu() {
		System.out.println("===== 아침 메뉴 선택 =====");
		System.out.println("1. 한식");
		System.out.println("2. 중식");
		System.out.println("3. 양식");
		System.out.println("4. 메뉴");
		System.out.print("메뉴 번호 : ");
		menu2 = sc.nextInt(); sc.nextLine();
		
		
		if(menu2 < 4) {
			this.choiceBreakfast();		
		}else if(menu2 == 4) {
			this.mainMenu();
		}else {
			System.out.println("아침 메뉴 선택을 종료합니다.");
			this.mainMenu();
		}
		
	}

	
	private void lunchMenu() {
		System.out.println("===== 점심 메뉴 선택 =====");
		System.out.println("1. 한식");
		System.out.println("2. 중식");
		System.out.println("3. 양식");
		System.out.println("4. 메뉴");
		System.out.print("메뉴 번호 : ");
		menu2 = sc.nextInt(); sc.nextLine();
		
		
		if(menu2 < 4) {
			this.choiceLunch();		
		}else if(menu2 == 4) {
			this.mainMenu();
		}else {
			System.out.println("점심 메뉴 선택을 종료합니다.");
			this.mainMenu();
		}
	}

	private void dinnerMenu() {
		System.out.println("===== 저녁 메뉴 선택 =====");
		System.out.println("1. 한식");
		System.out.println("2. 중식");
		System.out.println("3. 양식");
		System.out.println("4. 메뉴");
		System.out.print("메뉴 번호 : ");
		menu2 = sc.nextInt(); sc.nextLine();
		
		
		if(menu2 < 4) {
			this.choiceDinner();		
		}else if(menu2 == 4) {
			this.mainMenu();
		}else {
			System.out.println("저녁 메뉴 선택을 종료합니다.");
			this.mainMenu();
		}
	}



	private void choiceBreakfast() {
		if(menu2 == 1) {
			System.out.println("===== 아침 한식 선택 =====");			
		}else if(menu2 == 2) {
			System.out.println("===== 아침 중식 선택 =====");
		}else if(menu2 == 3) {
			System.out.println("===== 아침 양식 선택 =====");
		}
		int count = 1;
		
		if(b==1) {
			bc.setBreakfastArr();
		}
		for(int i=0; i < bc.getBreakfastfArr()[menu2-1].length ; i++) {
			System.out.println(i+1 + ". " + bc.getBreakfastfArr()[menu2-1][i].getName());
			count++;
		}
		System.out.println(count++ + ". 메뉴추가");
		System.out.println(count + ". 이전 메뉴...");
		System.out.print("메뉴 번호 : ");
		int lastMenu = sc.nextInt(); sc.nextLine();
		
		if(lastMenu == bc.getBreakfastfArr()[menu2-1].length+1) {
			System.out.print("추가할 메뉴를 입력 : ");
			String addFood = sc.nextLine();
			System.out.print("해당 메뉴의 가격을 책정(원) :");
			int price = sc.nextInt();  sc.nextLine();
			System.out.println(bc.addFoodList(menu2, addFood, price));
			b++;
			this.mainMenu();
		}else if(lastMenu == bc.getBreakfastfArr()[menu2-1].length+2) {
			this.choiceBreakfast();
		}else {
			int i=1;
			while(true) {
				
				if(lastMenu == i) {
					System.out.println(bc.printBreakfastFood(menu2-1, lastMenu-1));
					this.mainMenu();  break;
				}
				i++;
				if(i > bc.getBreakfastfArr()[menu2-1].length) {
					System.out.println("메뉴 번호 선택 다시...!");
					this.choiceBreakfast(); break;
				}
			}
		}
	}
	
	private void choiceLunch() {
		if(menu2 == 1) {
			System.out.println("===== 점심 한식 선택 =====");			
		}else if(menu2 == 2) {
			System.out.println("===== 점심 중식 선택 =====");
		}else if(menu2 == 3) {
			System.out.println("===== 점심 양식 선택 =====");
		}
		
		int count = 1;
		
		if(l==1) {
			lc.setLunchArr();
		}
		for(int i=0; i < lc.getLunchfArr()[menu2-1].length ; i++) {
			System.out.println(i+1 + ". " + lc.getLunchfArr()[menu2-1][i].getName());
			count++;
		}
		System.out.println(count++ + ". 메뉴추가");
		System.out.println(count + ". 이전 메뉴...");
		System.out.print("메뉴 번호 : ");
		int lastMenu = sc.nextInt(); sc.nextLine();
		
		if(lastMenu == lc.getLunchfArr()[menu2-1].length+1) {
			System.out.print("추가할 메뉴를 입력 : ");
			String addFood = sc.nextLine();
			System.out.print("해당 메뉴의 가격을 책정(원) :");
			int price = sc.nextInt();  sc.nextLine();
			System.out.println(lc.addFoodList(menu2, addFood, price));
			l++;
			this.mainMenu();
		}else if(lastMenu == lc.getLunchfArr()[menu2-1].length+2) {
			this.choiceLunch();
		}else {
			int i=1;
			while(true) {
				
				if(lastMenu == i) {
					System.out.println(lc.printLunchFood(menu2-1, lastMenu-1));
					this.mainMenu();  break;
				}
				i++;
				if(i > lc.getLunchfArr()[menu2-1].length) {
					System.out.println("메뉴 번호 선택 다시...!");
					this.choiceLunch(); break;
				}
			}
		}
	}

	private void choiceDinner() {
		if(menu2 == 1) {
			System.out.println("===== 저녁 한식 선택 =====");			
		}else if(menu2 == 2) {
			System.out.println("===== 저녁 중식 선택 =====");
		}else if(menu2 == 3) {
			System.out.println("===== 저녁 양식 선택 =====");
		}
		
		int count = 1;
		
		if(d==1) {
			dc.setDinnerArr();
		}
		for(int i=0; i < dc.getDinnerfArr()[menu2-1].length ; i++) {
			System.out.println(i+1 + ". " + dc.getDinnerfArr()[menu2-1][i].getName());
			count++;
		}
		System.out.println(count++ + ". 메뉴추가");
		System.out.println(count + ". 이전 메뉴...");
		System.out.print("메뉴 번호 : ");
		int lastMenu = sc.nextInt(); sc.nextLine();
		
		if(lastMenu == dc.getDinnerfArr()[menu2-1].length+1) {
			System.out.print("추가할 메뉴를 입력 : ");
			String addFood = sc.nextLine();
			System.out.print("해당 메뉴의 가격을 책정(원) :");
			int price = sc.nextInt();  sc.nextLine();
			System.out.println(dc.addFoodList(menu2, addFood, price));
			d++;
			this.mainMenu();
		}else if(lastMenu == dc.getDinnerfArr()[menu2-1].length+2) {
			this.choiceDinner();
		}else {
			int i=1;
			while(true) {
				
				if(lastMenu == i) {
					System.out.println(dc.printDinnerFood(menu2-1, lastMenu-1));
					this.mainMenu();  break;
				}
				i++;
				if(i > dc.getDinnerfArr()[menu2-1].length) {
					System.out.println("메뉴 번호 선택 다시...!");
					this.choiceDinner(); break;
				}
			}
		}
		
	}

}
