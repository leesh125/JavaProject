package com.kh.example.menu.controller;

import com.kh.example.menu.model.vo.Dinner;
import com.kh.example.menu.model.vo.Food;

public class DinnerController {
	private Dinner d = new Dinner();
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
	
	public String printDinnerFood(int x, int y) {
		d.setChoice1(x);   d.setChoice2(y);
//		d.setfArr(d.listFood());
//		return b.listFood()[x][y] + " 메뉴가 선택 되었습니다!";
		return d.toString();
	}
	
	public Food[][] getDinnerfArr() {
		return d.getfArr();
	}
	
	public void setDinnerArr() {
		d.listFood();
	}
	
	public String addFoodList(int x, String addFood, int price) {
		d.addFood(x, addFood, price);
		
		return "저녁 메뉴로 " + addFood + "(" + price + "원) 이/가 추가 되었습니다!";
	}
	
	public void printRandDinner() {
		d.randomDinner();
		this.getChoice1 = d.getGetChoice1();  this.getChoice2 = d.getGetChoice2();
	}
}
