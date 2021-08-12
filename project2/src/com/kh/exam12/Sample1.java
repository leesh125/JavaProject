package com.kh.exam12;

class Person {
	protected String name;
	protected int age;
	public String getName() {
		return name;
	}
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

class Student extends Person {
	private int grade;
	private int group;
	private int stuNum;
	private int record;
	
	
	public Student(int grade, int group, int stuNum, int record) {
		
		this.grade = grade;
		this.group = group;
		this.stuNum = stuNum;
		this.record = record;
	}

	public Student(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	@Override
	public String toString() {
		return  "Student [name=" + name + ", age=" + age + "]";
	}
}

class Employee extends Person {
	private String company;
	private String rank;
	private String dept;
	
	
	
	public Employee(String name, int age, String company, String rank, String dept) {
		this.name = name;
		this.age = age;
		this.company = company;
		this.rank = rank;
		this.dept = dept;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "=====직원정보=====\n이름 : " + name + 
				" \n나이 : " + age + 
				"세\n회사 : " + company + 
				" \n직급 : " + rank + 
				" \n부서 : " + dept + 
				"\n==============";
	}
	
	
	
	
}

class Soldier extends Person {
	private String division;
	private String company;
	private String platoon;
	private int solNum;			// 군번
	private String species;		// 종과
	
	public Soldier(String name, int age, int solNum, String division, String company, String platoon, String species) {
		this.name = name;
		this.age = age;
		this.solNum = solNum;
		this.division = division;
		this.company = company;
		this.platoon = platoon;
		this.species = species;
	}
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPlatoon() {
		return platoon;
	}
	public void setPlatoon(String platoon) {
		this.platoon = platoon;
	}

	@Override
	public String toString() {
		return "=====군인정보=====\n이름 : " + name + 
				" \n나이 : " + age + 
				"세\n군번 : " + solNum + 
				" \n사단 : " + division + 
				" \n중대 : " + company + 
				" \n소대 : " + platoon + 
				" \n종과 : " + species +
				"\n==============";
	}
	
	
	
	
}

public class Sample1 {

	public static void main(String[] args) {
		Student s = new Student("홍길동", 30);
//		s.setName("홍길동");   s.setAge(30);
		System.out.println(s);
		
		Soldier sd = new Soldier("이석현", 25, 73048029 , "3야수교", "4중대", "2소대", "조교");
		System.out.println(sd);
		
		System.out.println();
		Employee e = new Employee("카카오", 25, "풀스택 개발","이석현", "전무");
		System.out.println(e);
	}

}
