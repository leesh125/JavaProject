package com.kh.exam14;

public class StudentA extends NativePerson implements Sports{
	@Override
	public void run() {
		System.out.println(this.getName() + "은 운동부 입니다. 운동부는 뛸 수 있습니다.");
	}
}
