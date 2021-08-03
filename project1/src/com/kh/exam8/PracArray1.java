package com.kh.exam8;

import java.util.Arrays;

public class PracArray1 {

	public static void ex1() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.
		 * 
		 */
		
		int arr[] = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int odd[] = new int[0];  
		int even[] = new int[0];
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 2 == 0) {
				int evenCopy[] = new int[even.length + 1];
				System.arraycopy(even, 0, evenCopy, 0, even.length);
				even = evenCopy;
				even[even.length - 1] = arr[i];
			}else {
				int oddCopy[] = new int[odd.length + 1];
				System.arraycopy(odd, 0, oddCopy, 0, odd.length);
				odd = oddCopy;
				odd[odd.length - 1] = arr[i];
			}
		}
		
		System.out.println(Arrays.toString(even));
		System.out.println(Arrays.toString(odd));

	}
	
	public static void ex2() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 가장 큰값과 가장 작은 값만을 분리하여 별도의 배열에 저장하도록 한다.
		 * 
		 */
		int arr[] = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		int max = arr[0];
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) 	max = arr[i];
			if(arr[i] < min)    min = arr[i];
			
		}
	
		int num[] = {max,min};
		
		System.out.println(Arrays.toString(num));
		
	}
	
	public static void ex3() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 중복된 값을 찾아 중복이 없는 새로운 배열을 만든다.
		 * 
		 */
		int arr[] = new int[] {37, 92, 58, 46, 94, 29, 25, 58};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					int copyArr[] = new int[arr.length - 1];
					System.arraycopy(arr, 0, copyArr, 0, copyArr.length);
					
					for(int k=j;k<arr.length-1; k++) {
						copyArr[k] = arr[k+1];
					}
					
					arr = copyArr;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void ex4() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열)
		 */
		int[] arr = new int[] {7,92,58,46,94,29,25,58};
		int[][] arrEvenOdd = new int[2][8];
		int evenCount=0, oddCount=0; 
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 2 ==0) {
				arrEvenOdd[0][evenCount++] = arr[i];
			}else {
				arrEvenOdd[1][oddCount++] = arr[i];				
			}
		}

		for(int i=0; i<arrEvenOdd.length; i++) {
			System.out.println(Arrays.toString(arrEvenOdd[i]));
		}
	}
	
	public static void ex5() {
		/*
		 * 다음의 정수 배열이 있다.
		 * 		37, 92, 58, 46, 94, 29, 25, 58
		 * 
		 * 위 배열에서 짝수에 해당하는 값과 홀수에 해당하는 값을 별도의 짝수값만 저장하는 짝수배열
		 * 홀수값만 저장하는 홀수배열로 분리하여 저장하도록 한다.(정적배열)
		 */
		int[] arr = new int[] {7,92,58,46,94,29,25,58};
		int[][] arrEvenOdd = new int[2][];

		// arrEvenOdd[0] : 짝수 저장
		// arrEvenOdd[1] : 홀수 저장
		int arrEven[] = new int[0];
		int arrOdd[] = new int[0];
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 2 ==0) {
				int arrEvenCopy[] = new int[arrEven.length + 1];
				System.arraycopy(arrEven, 0, arrEvenCopy, 0, arrEven.length);
				arrEven = arrEvenCopy;
				arrEven[arrEven.length - 1] = arr[i];
			}else {
				int arrOddCopy[] = new int[arrOdd.length + 1];
				System.arraycopy(arrOdd, 0, arrOddCopy, 0, arrOdd.length);
				arrOdd = arrOddCopy;
				arrOdd[arrOdd.length - 1] = arr[i];
			}
		}
		
		arrEvenOdd[0] = arrEven;
		arrEvenOdd[1] = arrOdd;

		
		System.out.println(Arrays.deepToString(arrEvenOdd));
	}
	
	
	public static void main(String[] args) {
//		ex1();
//		ex2();
//		ex3();
//		ex4();
		ex5();
	}

}
