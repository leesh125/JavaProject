package com.kh.exam14;

public class StudentC extends Foreigner implements Sports, Art{

	@Override
	public void draw() {
		System.out.println(this.getName() + "은 미술부 입니다. 미술부는 그릴 수 있습니다.");
	}
	
	@Override
	public void run() {
		System.out.println(this.getName() + "은 운동부 입니다. 운동부는 뛸 수 있습니다.");
	}
	
}
