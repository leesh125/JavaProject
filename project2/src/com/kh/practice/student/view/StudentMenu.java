package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("=========학생 정보 출력=========");
//		for(int i=0; i<ssm.printStudent().length; i++) {
//			System.out.println(ssm.printStudent()[i].inform());
//		}
		
		for(Student s : ssm.printStudent()) {
			System.out.println(s.inform());
		}
		
		System.out.println("\n=========학생 성적 출력=========");
		System.out.println("학생 점수 합계 : " + (int)ssm.avgScore()[0]);
		System.out.println("학생 점수 평균 : " + ssm.avgScore()[1]);

		System.out.println("\n=========성적 결과 출력===========");
		
		for(Student s: ssm.printStudent()) {
			if(s.getScore() < ssm.CUT_LINE) {
				System.out.println(s.getName() + "학생은 재시험 대상입니다.");
			}else {
				System.out.println(s.getName() + "학생은 통과입니다.");
			}
		}
	}
}
