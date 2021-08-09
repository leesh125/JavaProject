package com.kh.exam11;

public class Subject {
	private String name;
	private int jumsu;
	private double[] dblGrade = {100.0, 90.0, 80.0, 70.0, 60.0, 0.0};
	private final String[] GRADE = {"A", "B", "C", "D", "F"};
	
	public Subject() {}
	
	public Subject(String name) {
		this.name = name;
	}
	
	public Subject(String name, int num) {
		this.name = name;
		this.jumsu = num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setJumsu(int num) {
		if(this.dblGrade[this.dblGrade.length - 1] <= num && num <= this.dblGrade[0]) {
			this.jumsu = num;
		} else {
			this.jumsu = -1;
		}
	}
	
	public int getJumsu() {
		return this.jumsu;
	}
	
	public boolean isValid() {
		return this.jumsu == -1 ? false : true;
	}
	
	public String getGrade() {
		if(this.jumsu == this.dblGrade[0]) {
			return this.GRADE[0];
		} else {
			for(int i = 0; i < this.dblGrade.length - 1; i++) {
				if(this.jumsu < this.dblGrade[i] && this.jumsu >= this.dblGrade[i+1]) {
					return this.GRADE[i];
				}
			}
		}
		return this.GRADE[this.GRADE.length - 1];
//		if(this.jumsu <= this.dblGrade[0] && this.jumsu >= this.dblGrade[1]) {
//			return "A";
//		} else if(this.jumsu < this.dblGrade[1] && this.jumsu >= this.dblGrade[2]) {
//			return "B";
//		} else if(this.jumsu < this.dblGrade[2] && this.jumsu >= this.dblGrade[3]) {
//			return "C";
//		} else if(this.jumsu < this.dblGrade[3] && this.jumsu >= this.dblGrade[4]) {
//			return "D";
//		} else {
//			return "F";
//		}
	}
	
	public void setRangeJumsu(int min, int max) {
		this.dblGrade[this.dblGrade.length - 1] = min;
		this.dblGrade[0] = max;
		
		if(this.jumsu > 0) {
			this.setJumsu((int)((double)this.jumsu / 100 * max));
		}
		
		for(int i = 1; i < this.dblGrade.length - 1; i++) {
			this.dblGrade[i] = max / 100.0 * (100 - i * 10);
		}

	}
	
	public int[] getRangeJumsu() {
		return new int[] {(int)this.dblGrade[this.dblGrade.length - 1],
				(int)this.dblGrade[0]};
	}
	
	public boolean equalSubject(Subject s) {
		return this.name.equals(s.name);
	}
	
	public boolean gt(Subject s) {
		return this.jumsu > s.jumsu;
	}
	
	public boolean ge(Subject s) {
		return this.jumsu >= s.jumsu;
	}
	
	public boolean lt(Subject s) {
		return this.jumsu < s.jumsu;
	}
	
	public boolean le(Subject s) {
		return this.jumsu <= s.jumsu;
	}
	
	public boolean eq(Subject s) {
		return this.jumsu == s.jumsu;
	}
	
	public boolean nq(Subject s) {
		return this.jumsu != s.jumsu;
	}
}
