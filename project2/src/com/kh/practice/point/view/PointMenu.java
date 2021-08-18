package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;
import com.kh.practice.point.controller.TriangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	private TriangleController tc = new TriangleController();

	public void mainMenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("3. 삼각형");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt(); sc.nextLine();
		
		if(menu == 1) {
			this.circleMenu();
		}else if(menu == 2) {
			this.rectangleMenu();
		}else if(menu == 3) {
			this.triangleMenu();			
		}else {
			System.out.println("종료합니다.");
			System.exit(0);
		}
		
	}
	
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt(); sc.nextLine();
		
		if(menu == 1) {
			this.calcCircum();
		}else if(menu == 2) {
			this.calcCircleArea();
		}else if(menu == 9){
			this.mainMenu();
		}else {
			this.circleMenu();
		}
	}
	
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("3. 사각형 쪼개기");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt(); sc.nextLine();
		
		if(menu == 1) {
			this.calcPerimeter();
		}else if(menu == 2) {
			this.calcRectArea();
		}else if(menu == 3) {
			this.calcRectSplit();
		}else if(menu == 9){
			this.mainMenu();
		}else {
			this.rectangleMenu();
		}
	}
	
	public void triangleMenu() {
		System.out.println("===== 삼각형 메뉴 =====");
		System.out.println("1. 삼각형 둘레");
		System.out.println("2. 삼각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt(); sc.nextLine();
		
		if(menu == 1) {
			this.calcTriperimeter();
		}else if(menu == 2) {
			this.calcTriArea();
		}else if(menu == 9){
			this.mainMenu();
		}else {
			this.triangleMenu();
		}
	}
	
	
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); sc.nextLine();
		
		System.out.print("반지름 : ");
		int radius = sc.nextInt(); sc.nextLine();
		
		System.out.println(cc.calcCircum(x, y, radius));
		this.mainMenu();
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표, y 좌표, 반지름을 쉼표로 구분하여 입력 : ");
		String input = sc.nextLine();
		String inputs[] = input.split(",");
		int[] intArr = new int[3];
		for(int i=0; i<inputs.length; i++) {
			intArr[i] = Integer.parseInt(inputs[i]);
		}
		for(int i=0; i<intArr.length; i++) {
			if(intArr[i] == 0) {
				intArr[i] = 1;
			}
		}
	
		System.out.println(cc.calcArea(intArr[0], intArr[1], intArr[2]));
		
//		System.out.print("x 좌표 : ");
//		int x = sc.nextInt(); sc.nextLine();
//		
//		System.out.print("y 좌표 : ");
//		int y = sc.nextInt(); sc.nextLine();
//		
//		System.out.print("반지름 : ");
//		int radius = sc.nextInt(); sc.nextLine();
//		
//		System.out.println(cc.calcArea(x, y, radius));
		this.mainMenu();
	}
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt(); sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt(); sc.nextLine();
		
		System.out.println(rc.calcPerimeter(x, y, height, width));
		this.mainMenu();
	}
	
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt(); sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt(); sc.nextLine();
		
		System.out.println(rc.calcArea(x, y, height, width));
		this.mainMenu();
	}
	
	public void calcRectSplit() {
		int split;
		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); sc.nextLine();
		
		System.out.print("높이 : ");
		int height = sc.nextInt(); sc.nextLine();
		
		System.out.print("너비 : ");
		int width = sc.nextInt(); sc.nextLine();
		
		System.out.print("분리 갯수 : ");
		split = this.sc.nextInt();  sc.nextLine();
		
		System.out.println(rc.calcSplit(x, y, height, width, split));
		this.mainMenu();
	}
	
	public void calcTriperimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); sc.nextLine();
		
		System.out.print("변 1의 길이 : ");
		int n1 = sc.nextInt(); sc.nextLine();
		
		System.out.print("변 2의 길이 : ");
		int n2 = sc.nextInt(); sc.nextLine();
		
		System.out.print("변 3의 길이 : ");
		int n3 = sc.nextInt(); sc.nextLine();
		
		if(tc.calcPerimeter(x, y, n1, n2, n3) != null) {
			System.out.println(tc.calcPerimeter(x, y, n1, n2, n3));
		}else {
			System.out.println("해당 3개의 변으로는 삼각형을 만들 수 없습니다.");
			this.calcTriperimeter();
		}
		this.mainMenu();
	}
	
	public void calcTriArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt(); sc.nextLine();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt(); sc.nextLine();
		
		System.out.print("변 1의 길이 : ");
		int n1 = sc.nextInt(); sc.nextLine();
		
		System.out.print("변 2의 길이 : ");
		int n2 = sc.nextInt(); sc.nextLine();
		
		System.out.print("변 3의 길이 : ");
		int n3 = sc.nextInt(); sc.nextLine();
		
		if(tc.calcArea(x, y, n1, n2, n3) !=null) {
			System.out.println(tc.calcArea(x, y, n1, n2, n3));
		}else {
			System.out.println("해당 3개의 변으로는 삼각형을 만들 수 없습니다.");
			this.calcTriArea();
		}
		this.mainMenu();
	}
	
}
