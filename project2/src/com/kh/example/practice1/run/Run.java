package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		System.out.println("======Member 패키지=======");
		Member m1 = new Member();
		Member m2 = new Member();
		
		m1.chageName("김연경");  m1.printName();
		m2.chageName("안철수");  m2.printName();
		

	}

}
