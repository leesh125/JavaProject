package com.kh.exam10;

class Subject {
	private int jumsu;
	private String name;
	private int min=0;
	private int max=100;
	
	public Subject() {
		
	}
	
	public Subject(String name) {
		this.name = name;
	}
	
	public Subject(String name, int jumsu) {
		this.name = name;
		this.jumsu = jumsu;
	}
	
	public int getJumsu() {
		return jumsu;
	}
	public void setJumsu(int jumsu) {
		if(this.jumsu < this.min | this.jumsu > this.max) {
			System.out.println("-1");
		}else {
			this.jumsu = jumsu;
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		if(this.jumsu >= 0 && this.jumsu <= 100) {
			return true;
		}else {
			return false;
		}
	}

	public char getGrade() {
		if(this.jumsu >= max-(max/10) && this.jumsu <= max) {
			return 'A';
		}else if(this.jumsu >= max-(2*max/10) && this.jumsu <= max-(max/10)) {
			return 'B';
		}else if(this.jumsu >= max-(3*max/10) && this.jumsu <=max-(2*max/10)) {
			return 'C';
		}else if(this.jumsu >= max-(4*max/10) && this.jumsu <=max-(3*max/10)) {
			return 'D';
		}else {
			return 'F';
		}
	}

	public void setRangeJumsu(int i, int j) {
		this.min = i;    this.max = j;
		double dJumsu;
		dJumsu = (double)this.jumsu * ((double)j/100);
		this.jumsu = (int) dJumsu;
		
	}

	public int[] getRangeJumsu() {
		int arr[] = new int[this.max-this.min];
		int count = this.min;
		for(int i=0; i<arr.length; i++) {
			arr[i] = count++;
		}
		return arr;
	}

	public boolean equalSubject(Subject sub2) {
		if(this.name.equals(sub2.name)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean gt(Subject sub2) {
		if(this.jumsu > sub2.jumsu) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ge(Subject sub2) {
		if(this.jumsu >= sub2.jumsu) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean lt(Subject sub2) {
		if(this.jumsu < sub2.jumsu) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean le(Subject sub2) {
		if(this.jumsu <= sub2.jumsu) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean eq(Subject sub2) {
		if(this.jumsu == sub2.jumsu) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean nq(Subject sub2) {
		if(this.jumsu != sub2.jumsu) {
			return true;
		}else {
			return false;
		}
	}
	
}

public class Sample6 {

	public static void main(String[] args) {
		// 과목 클래스
		// 아래와 같은 다양한 방식으로 과목 클래스의 인스턴스 생성 가능
		Subject sub1 = new Subject();
		Subject sub2 = new Subject("국어");		// 과목명을 전달하여 인스턴스 생성
		Subject sub3 = new Subject("수학", 80);	// 과목명과 점수를 전달하여 인스턴스 생성
		
		sub1.setName("영어");		// 과목명을 별도의 Setter 이용하여 저장 가능
		
		/*
		 * 점수는 0 ~ 100 사이의 정수만 입력받아 저장할 수 있다.
		 * 범위를 벗어난 값의 입력이 있는 경우 -1 이 저장되도록 한다.
		 */
		sub1.setJumsu(70);		// 점수를 별도의 Setter 이용하여 저장 가능
		
		/*
		 * 저장된 점수가 올바른 범위의 점수인지 확인하는 메서드이다.
		 * 올바른 점수인 경우 true, 올바르지 않은 경우 false 를 반환한다.
		 */
		if(sub1.isValid()) {
			System.out.println("점수가 유효합니다.");
		} else {
			System.out.println("점수가 유효하지 않습니다.");
		}
		
		/*
		 * 저장된 점수를 기반으로 등급 반환, 등급은 A ~ D 그리고 F
		 * A 등급은 100 ~ 90 이상
		 * B 등급은 90 미만 ~ 80 이상
		 * C 등급은 80 미만 ~ 70 이상
		 * D 등급은 70 미만 ~ 60 이상
		 * F 등급은 60 미만
		 */
		System.out.println(sub1.getGrade());
		
		/* 
		 * 점수의 입력 범위를 한정하기 위한 메서드이다. 기본값으로 0 ~ 100 의 범위가 설정되어 있지만
		 * 아래의 메서드를 통해 입력 범위를 제한 할 수 있다.
		 * 이미 점수가 입력되어 있는 상태에서 범위가 변경되면 기존 점수도 범위에 맞추어 재설정 되어야 한다.
		 */
		sub1.setRangeJumsu(0, 10);	// 점수의 입력 범위를 0 ~ 10 으로 한정한다.
		
		// 점수의 입력 범위를 확인 할 수 있게 만들어 주는 메서드이다.
		int[] rg = sub1.getRangeJumsu();
		
		// 점수의 범위가 변경이 되면 등급 또한 변경된 범위에 맞추어 계산이 이루어져야 한다.
		System.out.println(sub1.getGrade());
		
		// 동일한 과목인지 비교하는 메서드이다.
		if(sub1.equalSubject(sub2)) {
			System.out.println("동일한 과목 입니다.");
		} else {
			System.out.println("동일한 과목이 아닙니다.");
		}
		
		/* 
		 * 점수를 비교하는 메서드이다.
		 * 이 메서드는 gt, lt, ge, le, eq, nq 의 추가 메서드도 만들어서 동작하게 한다.
		 * gt : 큰값인지 비교하기 위해 사용
		 * ge : 크거나 같은 값인지 비교하기 위해 사용
		 * lt : 작은값인지 비교하기 위해 사용
		 * le : 작거나 같은값인지 비교하기 위해 사용
		 * eq : 같은 값인지 비교하기 위해 사용
		 * nq : 다른 값인지 비교하기 위해 사용
		 */
		if(sub1.gt(sub2)) {
			System.out.println(sub1.getName() + "의 점수가 더 높습니다.");
		}

	}

}
