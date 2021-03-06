package com.kh.exam11;

import java.util.Scanner;

/*
 * 학생 클래스
 * 		학생의 정보를 담아서 관리하기 위한 객체로 사용하기 위한 클래스
 * 		
 * 		속성(멤버 변수)
 * 			이름, 성별, 나이, 과목정보(Subject 클래스의 인스턴스가 담겨있는 객체배열)
 * 
 * 		기능(메서드)
 * 			getter/setter, 새로운 과목추가/수정/삭제, 전체과목점수확인, 총점확인, 평균확인
 */
public class Student {
	private String name;
	private String gender;
	private int age;
	private Subject[] subjects;
	private int index;
	
	static Scanner sc = new Scanner(System.in);
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		this.subjects = new Subject[index];
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addSubject(Subject sub) {
		Subject copySub[] = new Subject[this.subjects.length+1];
		System.arraycopy(this.subjects, 0, copySub, 0, this.subjects.length);
		copySub[copySub.length-1] = sub;
		this.subjects = copySub;
//		if(this.index != this.subjects.length) {
//			this.subjects[this.index] = sub;
//			this.index++;
//		}
		
		for(Subject s: this.subjects) {
			System.out.print(s.getName() + ":" + s.getJumsu() + ",");
		}
		System.out.println();
	
	}
	
	public int total() {
		int sum = 0;
		for(Subject s: this.subjects) {
			sum += s.getJumsu();
		}
		return sum;
	}
	
	// subjects 객체 배열에 저장된 과목들의 평균을 구한다.
	public double avg() {
		return (double)this.total() / this.subjects.length;
	}
	
	// subjects 객체 배열에 저장된 과목의 점수를 반환한다.
	// 과목 이름으로 검색하여 반환할 수 있게 한다.(없는 이름이면 -1 반환)
	public int getSubjectJumsu(String subjectName) {
//		int count = -1;
		
		for(Subject s: this.subjects) {
			if(s.getName().equals(subjectName)) {
				return s.getJumsu();
			}
		}
			return -1;
		}
//		for(int i=0; i<this.subjects.length; i++) {
//			if(subjectName.equals(this.subjects[i].getName())) {
//				count = i;
//			}
//		}
//		
//		if(count==-1) {
//			return -1;
//		}else {
//			return subjects[count].getJumsu();
//		}
//		
//	}
	
	// subjects 객체 배열에 저장된 과목의 이름을 반환한다.
	// 위치값으로 과목명을 반환할 수 있게 한다. (잘못된 index 번호를 사용하면 null 반환)
	public String getSubjectName(int index) {
		if(index < 0 || index > subjects.length-1) {
			return null;
		}
			return this.subjects[index].getName();
		
	}
	
	public String editSub(String sub, String changeSub) {
		for(Subject s: this.subjects) {
			if(s.getName().equals(sub)) {
				s.setName(changeSub);
				return s.getName() + ":" + s.getJumsu();
			}
		}
		return "그런 과목은 없습니다.";
	}
	
	public int editSub(String sub, int changeJum) {
		for(Subject s: this.subjects) {
			if(s.getName().equals(sub)) {
				s.setJumsu(changeJum);
				return s.getJumsu();
			}
		}
		return -1;
	}
	
	public String editSub(String sub, String changeSub, int changeJum) {
		for(Subject s: this.subjects) {
			if(s.getName().equals(sub)) {
				s.setName(changeSub);
				s.setJumsu(changeJum);
				return s.getName() + ":" + s.getJumsu();
			}
		}
		return "그런 과목 없습니다";
	}
	
	public boolean deleteSubject(String find) {
		/*
		 * 1. 기존 객체배열의 크기보다 작은 객체배열을 만든다.
		 * 2. 기존 객체배열의 데이터를 새로 생성한 객체배열에 복사한다(깊은복사)
		 * 3. 2번 과정에서 데이터를 객체배열에 복사할 때 삭제할 데이터를 제외하고 복사한다.
		 * 4. 기존 객체배열이 저장된 변수를 새로 생성한 객체배열로 참조할 수 있게 얕은복사를 한다.
		 */
		if(this.getSubjectJumsu(find) == -1) {
			return false;
		}else {
			Subject copySub[] = new Subject[this.subjects.length -1];
			int idx  = 0;
			
			for(Subject s: this.subjects) {
				if(!find.equals(s.getName())) {
					copySub[idx++] = s;
				}
			}
			this.subjects = copySub;
			
			return true;
		}
	}
	
	public boolean deleteSubject(int index) {
		if(this.getSubjectName(index) == null) {
			return false;
		}else {
			Subject copySub[] = new Subject[this.subjects.length -1];
			int idx  = 0;
			
			for(int i=0; i<this.subjects.length; i++) {
				if(index != i) {
					copySub[idx++] = this.subjects[i];
				}
			}
			this.subjects = copySub;
			
			return true;
		}
	}
	
}
