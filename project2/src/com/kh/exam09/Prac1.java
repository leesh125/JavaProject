
package com.kh.exam09;



public class Prac1 {

	public void isEven(int num) {
		if(num % 2 == 0) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public void isOdd(int num) {
		if(num % 2 == 1) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public void isMulti(int num) {
		if(num % 2 == 0) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public void isMulti(int num1, int num2) {
		if(num1 % num2 == 0) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public void max(int num1, int num2) {
		if(num1 > num2) {
			System.out.println("둘 중 더 큰 값은 : " + num1);
		}else if(num2 > num1) {
			System.out.println("둘 중 더 큰 값은 : " + num2);
		}else {
			System.out.println("두 수는 같습니다.");
		}
	}
	
	public void max(int arr[]) {
		if(arr.length < 1) {
			System.out.println("배열 길이는 최소 1이상 이어야함");
		}
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println("배열 내에서 최댓값은 : " + max);
	}
	
	public void min(int num1, int num2) {
		if(num1 > num2) {
			System.out.println("둘 중 더 작은 값은 : " + num2);
		}else if(num2 > num1) {
			System.out.println("둘 중 더 작은 값은 : " + num1);
		}else {
			System.out.println("두 수는 같습니다.");
		}
	}
	
	public void min(int arr[]) {
		if(arr.length < 1) {
			System.out.println("배열 길이는 최소 1이상 이어야함");
		}
		int min = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		System.out.println("배열 내에서 최소값은 : " + min);
	}
	
}
