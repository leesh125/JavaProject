package com.kh.exam10;

import java.util.Scanner;

class Snack {
	private String kind;
	private String name;
	private String	 flavor;
	private int numOf;
	private int price;
	
	public Snack() {
		
	}
	
	public Snack(String kind, String name, String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}

	
	
	public String information() {
		return this.kind + "(" + this.name + " - " + this.flavor + ") " 
				  + this.numOf + "개 " + this.price + "원";
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		String kind; String name; String flavor; int numOf; int price;
		
		System.out.println("스낵류를 입력");
		System.out.print("종류 : ");  kind = sc.nextLine();
		System.out.print("이름 : ");  name = sc.nextLine();
		System.out.print("맛 : ");    flavor = sc.nextLine();
		System.out.print("개수 : ");  numOf = sc.nextInt();  sc.nextLine();
		System.out.print("가격 : ");  price = sc.nextInt();  sc.nextLine();
		
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		String yn = sc.nextLine();
		
		
		
		if(yn.equals("y")) {
			System.out.println(scr.confirmData());
		}else if(yn.equals("n")) {
			return;
		}
	} 
}

class SnackController {
	private Snack s = new Snack();
	
	public SnackController() {
		
	}
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다. \n";
	}
	
	public String confirmData() {
		return s.information();
	}
}

// Run 클래스 대신 Sample5로 작성.
public class Sample5 {

	public static void main(String[] args) {
		// OOP 실습문제 PDF 보고 작성
		SnackMenu sm = new SnackMenu();
		
		
		sm.menu();
		
	}

}
