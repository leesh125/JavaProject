package com.kh.exam5;

public class Operator {

	public static void main(String[] args) {
		//전위 연산
		int x1 = 10;
		int y1 = ++x1;
		
		System.out.println("전위연산 결과 : " + y1);
		
		//후위 연산

		int x2 = 10;
		int y2 = x2++;
				
		System.out.println("후위연산 결과 : " + y2);
		
		System.out.println("x1 : " + x1 + " | x2 : " + x2);
		
		// 산술 연산
		int x3 = 10;
		int y3 = 7;
		int z3 = x3 / y3;
		int z4 = x3 % y3;
		double z5 = (double)x3 / y3;
		
		System.out.println("정수 나누기 결과 : " + z3);
		System.out.println("실수 나누기 결과 : " + z5);
		System.out.println("나머지 결과 : " + z4);
		
		// 0 으로 나누면 Infinity라고 출력됨(0으로 나누기 X)
		double z6 = x3 / 0.0;
		System.out.println("나머지 결과 : " + z6);

		// 0으로 나머지 계산을 하면 java.lang.ArithmeticException 에러
		// int z7 = x3 % 0;
		// System.out.println("나머지 결과 : " + z7);
		
		
		// 비교 연산 : 결과는 항상 boolean
		int a = 10, b = 20;
		
		boolean c1 = a == b;	// 같은지 비교
		boolean c2 = a != b;	// 다른지 비교
		boolean c3 = a > b;		// a가 큰지 비교
		boolean c4 = a < b;		// a가 작은지 비교
		boolean c5 = a >= b;	// a가 크거나 같은지 비교
		boolean c6 = a <= b;	// a가 작거나 같은지 비교
		
		System.out.println("a == b -> " + c1);
		System.out.println("a != b -> " + c2);
		System.out.println("a > b -> " + c3);
		System.out.println("a < b -> " + c4);
		System.out.println("a >= b -> " + c5);
		System.out.println("a <= b -> " + c6);
		
		
		// 문자에 대한 비교
		char d1 = 'a';
		
		boolean d2 =  d1 == 'a';
		boolean d3 =  d1 == 'b';
		boolean d4 =  d1 == 97;
		boolean d5 =  d1 == 98;
		
		System.out.println("d1 == 'a' -> " + d2);
		System.out.println("d1 == 'b' -> " + d3);
		System.out.println("d1 == 97 -> " + d4);
		System.out.println("d1 == 98 -> " + d5);


		// 문자열에 대한 비교
		String s1 = "abcd";
		String s2 = new String("abcd");
		
		boolean s3 = s1 == "abcd";
		boolean s4 = s2 == "abcd";

		System.out.println("s1 == \"abcd\" -> " + s3);
		System.out.println("s2 == \"abcd\" -> " + s4);
		
		boolean s5 = s2.equals("abcd");
		boolean s6 = s1.equals("abcd");

		System.out.println("s2.equals(\"abcd\") -> " + s5);
		System.out.println("s1.equals(\"abcd\") -> " + s6);
		
		/* 논리 연산 결과표.
		 * x		y		&&		||
		 * true		true	true	true
		 * true		false	false	true
		 * false	true	false	true
		 * false	false	false	false
		 */
		
		
		// 복합 대입 연산자
		int x4 = 10;
		x4 += 2;
		System.out.println("x4 += 2 -> " + x4);
		
		x4 *= 3;
		System.out.println("x4 *= 3 -> " + x4);
		
		x4 %= 5;
		System.out.println("x4 %= 2 -> " + x4);
		
		// 삼항 연산자
		// 조건식 ? 조건이 참일 때 계산식 : 조건이 거짓일 때 계산식
		int x5 = 4;
		boolean res;
		
		res = (x5 % 2 == 0) ? true : false;
		
		System.out.println("x5는 짝수? -> "+ res);



	}

}
