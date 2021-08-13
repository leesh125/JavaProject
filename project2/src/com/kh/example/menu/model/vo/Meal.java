package com.kh.example.menu.model.vo;

import java.util.Random;
import java.util.Scanner;

public class Meal {
	
	private String chooseMenu = "";
	private int choice1, choice2;
	private Scanner sc = new Scanner(System.in);

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	private Random rd = new Random();

	
	

	public int getChoice1() {
		return choice1;
	}

	public void setChoice1(int choice1) {
		this.choice1 = choice1;
	}

	public int getChoice2() {
		return choice2;
	}

	public void setChoice2(int choice2) {
		this.choice2 = choice2;
	}
	

	public String getChooseMenu() {
		return chooseMenu;
	}

	public void setChooseMenu(String chooseMenu) {
		this.chooseMenu = chooseMenu;
	}

	
	
	public Random getRd() {
		return rd;
	}

	public void setRd(Random rd) {
		this.rd = rd;
	}
	
	@Override
	public String toString() {
		return "Meal [ chooseMenu=" + chooseMenu + "]";
	}

	

	
	
}
