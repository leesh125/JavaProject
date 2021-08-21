package com.kh.exam17;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Subject {
	private int score;
	private String name;
		
	public Subject( String name,int score) {
		this.score = score;
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Subject [score=" + score + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
}

public class Sample3 {

	public static void main(String[] args) {
		List<Subject> sList = new ArrayList<Subject>();
		sList.add(new Subject("과학", 70));
		sList.add(new Subject("국어", 80));
		sList.add(new Subject("영어", 85));
		
		Subject s = new Subject("영어", 83);
		boolean resBool = sList.contains(s);
		System.out.println("최종 결과 : " + resBool);
		
		int resInt = sList.indexOf(s);
		System.out.println("indexOf 최종 결과 : " + resInt);
	}

}
