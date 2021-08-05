package com.kh.exam2;

// default 접근제한자를 사용하는 다른 패키지의 클래스를 가져오지 못함. 
// import com.kh.exam2.oth.OtherPackage;

/*
 * 클래스 접근 제한자.
 * 		public : 모든 영역에서 사용 가능
 * 		default : 동일 패키지 영역에서만 사용 가능
 */

public class Sample1 {

	public static void main(String[] args) {
		SamePackage same = new SamePackage();
		System.out.println("OtherClass 접근 가능 -> " + same.attribute);
		
		// default 접근제한자를 사용하는 다른 패키지의 클래스를 가져오지 못함. 
		// OtherPackage other = new OtherPackage();
		// System.out.println("NoAccessClass 접근 가능 -> " + other.attribute);
	}

}
