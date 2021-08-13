package com.kh.example.menu.controller;

import com.kh.example.menu.model.vo.Food;
import com.kh.example.menu.model.vo.Lunch;

public class LunchController {
	private Lunch l = new Lunch();
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
	
	public String printLunchFood(int x, int y) {
		l.setChoice1(x);   l.setChoice2(y);
//		l.setfArr(l.listFood());
//		return b.listFood()[x][y] + " 메뉴가 선택 되었습니다!";
		return l.toString();
	}
	
	public Food[][] getLunchfArr() {
		return l.getfArr();
	}
	
	public void setLunchArr() {
		l.listFood();
	}
	
	public String addFoodList(int x, String addFood, int price) {
		l.addFood(x, addFood, price);
		
		return "점심 메뉴로 " + addFood + "(" + price + "원) 이/가 추가 되었습니다!";
	}
	
	public void printRandLunch() {
		l.randomLunch();
		this.getChoice1 = l.getGetChoice1();  this.getChoice2 = l.getGetChoice2();
	}
}
