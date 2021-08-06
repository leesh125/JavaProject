package com.kh.exam8;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayData {
	
	static Scanner sc = new Scanner(System.in);
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
		// 배열 복사
		int x1 = 10;
		int x2 = x1;
		System.out.println("x1:" + x1 + "|x2:" + x2);
		
		x1 = 15;
		x2 = 25;
		System.out.println("x1:" + x1 + "|x2:" + x2);
		
		System.out.println("-----배열 복사(얕은 복사)-----");
		
		int[] iArr1 = new int[] {1, 2, 3, 4};
		int[] iArr2 = iArr1;
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----배열 복사 후 값 변경-----");
		
		iArr1[0] = 15;	// 동일한 참조값으로 변경을 하기 때문에 iArr1 이나 iArr2 모두 변경된 것으로 보임
		iArr2[3] = 25;	// 동일한 참조값으로 변경을 하기 때문에 iArr1 이나 iArr2 모두 변경된 것으로 보임
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----참조값 확인-----");
		System.out.println("iArr1 참조값 : " + iArr1);
		System.out.println("iArr2 참조값 : " + iArr2);
	}
	
	public static void sample7() {
		// 배열의 깊은 복사 방법 1
		int[] iArr1 = new int[] {1, 2, 3, 4};
		int[] iArr2 = new int[iArr1.length];
		
		// 깊은 복사 중...
		for(int i = 0; i < iArr1.length; i++) {
			iArr2[i] = iArr1[i];
		}
		
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		iArr1[0] = 15;
		iArr2[3] = 25;
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i] + "|iArr2[" + i + "]:" + iArr2[i]);
		}
		
		System.out.println("-----참조값 확인-----");
		System.out.println("iArr1 참조값 : " + iArr1);
		System.out.println("iArr2 참조값 : " + iArr2);
	}
	
	
	public static void sample8() {
		// 깊은 복사를 사용하여 배열의 크기 늘리기.
		int[] iArr1 = new int[] {1, 2, 3, 4};
		
		System.out.println("-----배열의 크기를 늘리기 전-----");
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
		
		int[] iArr2 = new int[iArr1.length + 1];
		for(int i = 0; i < iArr1.length; i++) {
			iArr2[i] = iArr1[i];
		}
		
		iArr1 = iArr2;
		iArr1[iArr1.length - 1] = 5;	// 마지막 index에 값 저장
		
		System.out.println("-----배열의 크기를 늘린 후-----");
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
	}
	
	public static void sample9() {
		// 깊은 복사를 사용하여 배열의 크기 줄이기.
		int[] iArr1 = new int[] {1, 2, 3, 4};
		
		System.out.println("-----배열의 크기를 줄이기 전-----");
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
		
		int[] iArr2 = new int[iArr1.length - 1];
		for(int i = 0; i < iArr2.length; i++) {
			iArr2[i] = iArr1[i];
		}
		
		iArr1 = iArr2;
		
		System.out.println("-----배열의 크기를 줄인 후-----");
		for(int i = 0; i < iArr1.length; i++) {
			System.out.println("iArr1[" + i + "]:" + iArr1[i]);
		}
	}
	
	public static void sample10() {
		int[] iArr = new int[0];
		int num;
		
		while(true) {
			System.out.print("정수 입력(-1 입력하면 종료) : ");
			num = sc.nextInt();	sc.nextLine();
			
			if(num != -1) {
				int[] copyArr = new int[iArr.length + 1];
				
				//               원본   원본복사위치    복사본     복사본복사위치    복사할길이(원본길이)
				System.arraycopy(iArr,       0,        copyArr,          0,            iArr.length);
//				for(int i = 0; i < iArr.length; i++) {
//					copyArr[i] = iArr[i];
//				}
				iArr = copyArr;
				
				iArr[iArr.length - 1] = num;
				System.out.println(Arrays.toString(iArr));
			} else {
				break;
			}
		}
		
		int tot = 0;
		for(int i = 0; i < iArr.length; i++) {
			tot += iArr[i];
		}
		System.out.println("사용자가 입력한 정수의 총합 : " + tot);
	}
	
	public static void main(String[] args) {
//		sample1();
//		sample2();
//		sample3();
//		sample4();
//		sample5();
//		sample6();
//		sample7();
//		sample8();
//		sample9();
		sample10();
		


		
	}

}
