package com.kh.exam15;

public class Novel extends Book {
	private String name;
	private String company;
	private String genre;
	private String writer;
		
	public Novel(String name, String company, String genre, 
				String writer,int totalPageNum) {
		super(totalPageNum);
		this.name = name;
		this.company = company;
		this.genre = genre;
		this.writer = writer;
	}

	@Override
	public void read() {
		System.out.println("'" + this.name + "' 소설을 읽습니다.");
	}
	
	public void search(String search) {
		System.out.println(search + " 내용을 '" + 
						this.name + "' 소설에서 검색합니다.");
	}

	@Override
	public String toString() {
		return "소설책 [제목 : " + name + ", 출판사 : " + company + ", 장르 : " + genre + ", 작가 :" + writer
				+ super.toString();
	}
	
	
}
