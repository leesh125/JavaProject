package com.kh.practice.chap01_poly.model.vo;

public class AniBook extends Book {
	private int accessAge;
	
	public AniBook() {
		
	}

	public AniBook(int accessAge) {
		super();
		this.accessAge = accessAge;
	}

	
	public AniBook(String title, String author, String publisher, int age) {
		super(title, author, publisher);
		this.accessAge = age;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "AniBook" + super.toString() + ", accessAge ="+  accessAge + "]";
	}

	
	
	
}
