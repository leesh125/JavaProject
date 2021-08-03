package com.kh.exam8;

import java.util.Arrays;

public class ArrayData1 {

	public static void sample1() {
		/*
		 *  2차 배열
		 *  		배열안에 요소가 배열로 구성되어 있는 것을 말한다.
		 * 		    (표,테이블과 같은 구조)
		 */
		int arr[][] = new int[3][4];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = i + j;
			}
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void sample2() {
		int arr[][] = {{1,2,3},{4,5,6}};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void sample3() {
		// 2차 복사(깊은 복사)
		int arr[][] = { {1,2,3}, {4,5,6}, {7,8,9} };
		int copyArr[][] = new int[3][3];
		
		for(int i=0; i<arr.length; i++) {
			//System.arraycopy(arr[i], 0, copyArr[i], 0, arr[i].length);
			copyArr[i] = arr[i].clone();
		}
		arr[0][1] = 20;
		
		System.out.println(Arrays.toString(copyArr[0]));
		System.out.println(Arrays.toString(copyArr[1]));
		System.out.println(Arrays.toString(copyArr[2]));
	}
	
	public static void sample4() {
		// 가변 길이 배열 : 2차 배열의 길이가 다르게 구성된 배열
		int arr[][] = new int[3][];
		
		arr[0] = new int[4];
		arr[1] = new int[6];
		arr[2] = new int[3];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + ":" + i + "|" + j + "\t");
			}
				System.out.println();
		}
		
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(arr).replace("], [", "],\n["));
	}
	
	public static void sample5() {
		// 2차 배열(동적배열)
		int arr[][] = new int[3][];
		
		arr[0] = new int[] {1, 2, 3, 4};
		arr[1] = new int[] {5, 6, 7, 8, 9, 10};
		arr[2] = new int[] {11, 12, 13};
		
		int arrCopy[][] = new int[arr.length + 1][];
		for(int i=0; i<arr.length; i++) {
			arrCopy[i] = arr[i].clone();
		}
		
		arr = arrCopy;
		
		arr[arr.length - 1] = new int[] {14, 15, 16, 17 ,18};
		
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepToString(arrCopy));

	}
	public static void main(String[] args) {
//		sample1();
//		sample2();
//		sample3();
//		sample4();
		sample5();
	}

}
