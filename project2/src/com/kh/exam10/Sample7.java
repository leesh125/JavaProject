package com.kh.exam10;

import java.util.Scanner;

class Employee {
	private int coNum;
	private String name;
	private String dept;
	private String rank;
	private int age;
	private char gender;
	private int salary;
	private int pNum;
	private String addr;
	private boolean lastYear;
	
	static Scanner sc = new Scanner(System.in);
	
	public Employee() {
		
	}
	
	public Employee(int coNum, String name, String dept, String rank) {
		this.coNum = coNum;      this.name = name;
		this.dept = dept;        this.rank = rank;
	}
	
	public void setLastYear(boolean lastYear) {
		this.lastYear = lastYear;
	}
	
	public int getSalary(int salary) {
		int mSalary = this.salary / 12 ;
		mSalary -= (mSalary * (8/100)); 
		return mSalary;
	}
	
	public void negoSalary() {
		double nego;
		System.out.print("전년도 성과가 좋으면 true, 아니면 false 입력 : ");
		this.setLastYear(sc.nextBoolean());   sc.nextLine(); 

		if(this.lastYear) {
		
			while(true) {
				System.out.print("협상 후 올릴 퍼센트 : ");
				nego = sc.nextDouble();  sc.nextLine();
				if(nego > 2.5) {
					System.out.println("2.5% 초과해서 올릴 수 없습니다.");
					continue;
				}else {
					this.salary += (double)this.salary * nego; 
					System.out.println("연봉은 : " + this.salary);
					break;
				}
			}
			
		}else {
			System.out.print("협상 후 올리거나 내릴 퍼센트 : ");
			nego = sc.nextDouble();  sc.nextLine();
			
			if(nego>0.0) {
				this.salary += (double)this.salary * nego;
				System.out.println("연봉은 : " + this.salary);
			}else {
				nego *= -1;
				this.salary -= (double)this.salary * nego;
				System.out.println("연봉은 : " + this.salary);
			}
		}
		
	}
}

public class Sample7 {

	public static void main(String[] args) {
		/*
		 * 직원 정보를 가지고 있는 Employee 클래스가 있다.
		 * 이 클래스를 사용하여 직원들의 사번, 이름, 부서, 직급, 나이, 성별, 연봉, 연락처, 주소등의
		 * 정보를 관리할 것이다.
		 */
		Employee e = new Employee();
		/*
		 * 직원 정보 관리를 위한 객체를 생성할 때 반드시 사번, 이름, 부서, 직급의 정보가 있어야 한다.
		 */
		Employee e1 = new Employee(1692132, "이석현", "풀스택",);
		/*
		 * 급여는 연봉에서 12개월을 나눈 값으로 지급하나 매달 세금으로 급여의 8% 를 빼고 수령받게
		 * 될것이다. 따라서 급여 정보를 반환하는 메서드는 위의 사항을 고려하여 값이 반환될 수 있게
		 * 해야 한다.
		 */

		/*
		 * 회사 내규에 따라 연봉 협상은 현재 연봉의 2.5% 까지만 최대로 올릴 수 있다. 이는 모든 직원들이
		 * 동일하다. 단, 전년도 실적에 따라 더 높이거나 낮출 수는 있다.
		 */

	}

}
