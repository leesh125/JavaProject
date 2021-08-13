package com.kh.example.menu.controller;

import com.kh.example.menu.model.vo.Breakfast;
import com.kh.example.menu.model.vo.Food;


public class BreakfastController {
	private Breakfast b = new Breakfast();
	private int getChoice1, getChoice2;
	
	public int getGetChoice1() {
		return getChoice1;
	}

	public void setGetChoice1(int getChoice1) {
		this.getChoice1 = getChoice1;
	}

	public int getGetChoice2() {
		return getChoice2;
	}

	public void setGetChoice2(int getChoice2) {
		this.getChoice2 = getChoice2;
	}

	public String printBreakfastFood(int x, int y) {
		b.setChoice1(x);   b.setChoice2(y);
//		b.setfArr(b.listFood());
//		return b.listFood()[x][y] + " 메뉴가 선택 되었습니다!";
		return b.toString();
	}
	
	public Food[][] getBreakfastfArr() {
		
		return b.getfArr();
	}
	
	public void setBreakfastArr() {
		b.listFood();
	}
	
	public String addFoodList(int x, String addFood, int price) {
		b.addFood(x, addFood, price);
		
		return "아침 메뉴로 " + addFood + "(" + price + "원) 이/가 추가 되었습니다!";
	}
	
	public void printRandBreakfast() {
		b.randomBreakfast();
		this.getChoice1 = b.getGetChoice1();  this.getChoice2 = b.getGetChoice2();
	}
	
	
	
}
