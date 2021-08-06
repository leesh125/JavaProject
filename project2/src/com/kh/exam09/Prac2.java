package com.kh.exam09;

public class Prac2 {
	public boolean isEven(int num) {
		return this.isMulti(num, 2);
	}
	
	public boolean isOdd(int num) {
		return !this.isMulti(num, 2);
	}
	
	public boolean isMulti(int num) {
		return this.isMulti(num, 2);
	}
	
	public boolean isMulti(int num1, int num2) {
		if(num1 % num2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public int max(int num1, int num2) {
//		if(num1 > num2) {
//			return num1;
//		}else
//			return num2;
		return num1 > num2 ? num1 : num2;
		
	}
	
	public int max(int arr[]) {
		
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	public int min(int num1, int num2) {
		if(num1 > num2) { 
			return num2;
		}
		return num1;
	}
	
	public int min(int arr[]) {
		
		int min = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		return min;
	}
}
