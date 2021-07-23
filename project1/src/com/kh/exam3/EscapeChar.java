 package com.kh.exam3;

public class EscapeChar {

	public static void main(String[] args) {
		
		/*
		이스케이프 문자
			프로그래밍 코드에서 사용하는 문자가 문자열에 사용하는 문자와 중첩되는 경우
			프로그램이 중첩된 의미를 제대로 구분하지 못하기 떄문에 구분할 수 있는 추가 문자로
			이스케이프 문자라는 것을 사용한다.
			
			이스케이프 문자는 \(역슬래쉬) 문자와의 조합으로 만들어진다.
			
			\n : 문자열 안에서 개행(엔터)의 기능을 사용하기 위해 쓰인다.
			\r : 문자열 안에서 커서의 위치를 해당 줄의 앞으로 이동시키기 위해 쓰인다.
			\t : 문자열 안에서 탭 공백(8칸의 공백)을 사용하기 위해 쓰인다.
			\n : 문자열 안에서 개행(엔터)의 기능을 사용하기 위해 쓰인다.
			\' : 문자열 안에서 쌍따옴표 문자를 사용하기 위해 쓰인다.
			\" : 문자열 안에서 홀따옴표 문자를 사용하기 위해 쓰인다.
			\\ : 문자열 안에서 역슬래쉬 문자를 사용하기 위해 쓰인다.
*/
			


			

		
		System.out.println("hello!!\nNice to Meet you");

		System.out.println("abc\r 12"); // eclipse의 콘솔에서는 적용이 안되어 확인 x.
		
		System.out.println("abc\td");
		System.out.println("ab\td");
		System.out.println("a\td");
		
		System.out.println("문자열 안에 \"쌍따옴표\"를 사용 ");
		System.out.println("문자열 안에 \'홀따옴표\'를 사용");
		System.out.println('\'');
		
		System.out.println("문자열 역슬래쉬 \\n 사용");
		

	}

}
