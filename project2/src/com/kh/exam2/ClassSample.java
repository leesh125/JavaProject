package com.kh.exam2;

public class ClassSample {

	public static void main(String[] args) {
		OtherClass other = new OtherClass();
		System.out.println("OtherClass 접근 가능 -> " + other.attribute);
		
		NoAccessClass noAccess= new NoAccessClass();
		System.out.println("NoAccessClass 접근 가능 -> " + noAccess.attribute);
	}

}
