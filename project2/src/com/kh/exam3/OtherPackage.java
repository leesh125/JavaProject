package com.kh.exam3;

// default 접근제한자를 사용하는 다른 패키지의 클래스는 사용 못함.
//import com.kh.exam2.NoAccessClass;
import com.kh.exam2.OtherClass;

public class OtherPackage {

	public static void main(String[] args) {
		OtherClass other = new OtherClass();
		System.out.println("OtherClass 접근 가능 -> " + other.attribute);
		
//		NoAccessClass noAccess= new NoAccessClass();
//		System.out.println("NoAccessClass 접근 가능 -> " + noAccess.attribute);

	}

}
