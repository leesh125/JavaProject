package com.kh.exam4;

import java.util.Scanner;

public class Prac1 {

	/*
	   국어,영어,수학 세 과목의 점수를 입력 받아
	 */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		double kor,eng,math;
		int sum=0;
		double avg = 0;
		
		System.out.print("국어 점수를 입력:");
		kor = sc.nextDouble();
		
		System.out.print("영어 점수를 입력:");
		eng = sc.nextDouble();
		
		System.out.print("수학 점수를 입력:");
		math = sc.nextDouble();
		
		sum = (int)(kor + eng + math);
		
		avg = sum / 3.0;
		
		System.out.printf("총점은 %d 평균은 %.2f", sum, avg);	


	}

}
