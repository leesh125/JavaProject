package com.kh.exam15;

public class Comics extends Book{
	private String name;
	private String company;
	private String writer;
	private String illuster;
	private int limitAge;
	
	public Comics(String name, String company, String writer, String illuster, int limitAge, int totalPageNum) {
		super(totalPageNum);
		this.name = name;
		this.company = company;
		this.writer = writer;
		this.illuster = illuster;
		this.limitAge = limitAge;
	}
	
	@Override
	public void read() {
		System.out.println("'" + this.name + "' 만화를 읽습니다.");
	}

	@Override
	public String toString() {
		if(limitAge<20) {
			return "만화책 [제목 : " + name + "], 출판사 : " + company + ", 글 작가 : " + writer + ", 그림 작가 : " + illuster
					+ ", 연령제한 : " + limitAge + "세 미만" + super.toString();
		}else {
			return "만화책 [제목 : " + name + ", 출판사 : " + company + ", 글 작가 : " + writer + ", 그림 작가 : " + illuster
					+ ", 연령제한 : " + limitAge + "세 이상" + super.toString();
		}
	}
	
	
	
}
