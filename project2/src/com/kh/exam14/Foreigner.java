package com.kh.exam14;

public class Foreigner extends Person {
	private String fNumber;
	private int durationDay;
	
	public void extDuration(int day) {
		this.durationDay += day;
	}

	public String getfNumber() {
		return fNumber;
	}

	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	public int getDurationDay() {
		return durationDay;
	}

	public void setDurationDay(int durationDay) {
		this.durationDay = durationDay;
	}
	
}
