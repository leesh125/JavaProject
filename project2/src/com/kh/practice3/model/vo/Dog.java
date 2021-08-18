package com.kh.practice3.model.vo;

public class Dog extends Animal {
	public final String PLACE = "애견카페";
	private int weight;
		
	public Dog() {
		
	}
	
	public Dog(String name, String kinds, int weight) {
		super(name, kinds);
		this.weight = weight;
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPLACE() {
		return PLACE;
	}

	@Override
	public void speak() {
		System.out.println(super.toString() + "\n몸무게는 " + weight + "kg 입니다.");
	}

}
