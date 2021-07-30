package com.kh.exam8;

public class ArrayData {
	
	public static void sample1() {
		// 정수 배열 생성
		int[] iArr = new int[5];
		
		// 정수 배열에 접근
		System.out.println(iArr[0]);
		System.out.println(iArr[1]);
		System.out.println(iArr[2]);
		System.out.println(iArr[3]);
		System.out.println(iArr[4]);
	}
	
	public static void sample2() {
		int iArr[] = new int[5];
		
		// 반복문을 사용하여 정수 배열에 접근
		for(int i=0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
	}
	
	public static void sample3() {
		// 선언과 동시에 초기화
		// int[] iArr = {1, 2, 3, 4, 5};
		int[] iArr = new int[] {1,2,3,4,5}; 
		
		for(int i=0; i<iArr.length; i++) {
			System.out.println(iArr[i]);
		}
	}
	
	public static void sample4() {
		// 선언 후 초기화
		int[] iArr = new int[5];
		
		// 초기화를 위해 반복문 사용
		for(int i=0; i<iArr.length; i++) {
			iArr[i] = i + 1;
			System.out.println(iArr[i]);
		}
	}
	
	public static void sample5() {
		boolean[] boolArr = new boolean[] {true,false};
		byte[] bArr = {1, 2, 3, 4, 5};
		char[] cArr = {'a', 'b', 'c', 'd'};
		double[] dArr = {1.0, 2.0, 3.0};
		String[] sArr = {"hello", "hi", "안녕하세요"};
		
		for(int i=0; i<boolArr.length; i++) {
			System.out.print(i + ":" + boolArr[i] + " ");
		}
		
		System.out.println();
		
		for(int i=0; i<bArr.length; i++) {
			System.out.print(i + ":" + bArr[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i<cArr.length; i++) {
			System.out.print(i + ":" + cArr[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i<dArr.length; i++) {
			System.out.print(i + ":" + dArr[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i<sArr.length; i++) {
			System.out.print(i + ":" + sArr[i] + " ");
		}
		
//		System.out.println(boolArr);
//		System.out.println(bArr);
//		System.out.println(cArr);
//		System.out.println(dArr);
//		System.out.println(sArr);

	}

	public static void sample6() {
		
	}
	public static void main(String[] args) {
//		sample1();
//		sample2();
//		sample3();
//		sample4();
		sample5();

		
	}

}
