package com.kh.exam11;

import java.util.Scanner;

public class Sample1 {

	static Scanner sc = new Scanner(System.in);
	public void ex1() {
		Subject subjects[] = new Subject[3];
		subjects[0] = new Subject("국어",70);
		subjects[1] = new Subject("영어",80);
		subjects[2] = new Subject("수학",90);

		// 사용자 입력을 받아서 과학 과목과 점수 85를 입력받아서 배열의 마지막 인덱스에 추가
		// 단 점수의 경우 0 ~ 100 사이의 입력이 아니면 계속 입력 받을 수 있게 한다.
		System.out.println("===현재 입력된 과목의 정보===\n");
		for(int i=0; i<subjects.length; i++) {
			System.out.println(subjects[i].getName() + " 점수 : " +
								subjects[i].getJumsu());
			System.out.println("등급 : " + subjects[i].getGrade());
		}
		System.out.println("\n========================");
		
		int count=0;
		while(true) {
			System.out.print("추가할 과목을 입력 : ");
			String sub = sc.nextLine();
			
			// for each 문
			for(Subject s: subjects) {
				if(sub.equals(s.getName())) {
					count++;
				}
			}
			
//			for(int i=0; i<subjects.length; i++) {
//				if(sub.equals(subjects[i].getName())) {
//					count++;
//				}
//			}
			
			if(count > 0) {
				System.out.println("이미 입력된 과목명이 있습니다.\n");
				count = 0;
				continue;
			}
			
			if(sub.equals("종료")) {
				System.out.println("\n ===과목 입력을 종료합니다.===");
				break;
			}else {
				Subject copysub[] = new Subject[subjects.length+1];
				System.arraycopy(subjects, 0, copysub, 0, subjects.length);
				subjects = copysub;
			}
			
			while(true) {
				System.out.print("추가한 과목에 점수 입력 : ");
				int jumsu = sc.nextInt();  sc.nextLine();
				if(jumsu < 0 || jumsu > 100) {
					System.out.println("점수 0부터 100사이 입력\n");
					continue;
				}else {
					subjects[subjects.length-1] = new Subject(sub,jumsu);
					break;
				}
			}
		
		}
		
		// for each문
		for(Subject s: subjects) {
			System.out.println(s.getName()+ " 점수 : " + s.getJumsu());
			System.out.println("등급 : " + s.getGrade());
		}
		
		
//		for(int i=0; i<subjects.length; i++) {
//			System.out.println(subjects[i].getName() + " 점수 : " +
//								subjects[i].getJumsu());
//			System.out.println("등급 : " + subjects[i].getGrade());
//		}
//		System.out.println();
		
	}
	
	public static void main(String[] args) {
		Student std = new Student("홍길동", 30);
		
		// 과목추가
		Subject sub = new Subject("국어", 70);
		std.addSubject(sub);
		
		sub = new Subject("영어", 70);
		std.addSubject(sub);

		sub = new Subject("과학", 90);
		std.addSubject(sub);
		
		System.out.println(std.getName() + " 학생의 총점은 " + std.total());
		
		System.out.println(std.getName() + " 학생의 국어 점수는 " + std.getSubjectJumsu("국어"));
		System.out.println(std.getName() + " 학생의 사회 점수는 " + std.getSubjectJumsu("사회"));
		
		System.out.println(std.getName() + " 학생의 2번째 위치의 과목은 " + std.getSubjectName(1));
		
	}
}


