package com.kh.exam15;

public abstract class Book implements Page {
	private int totalPageNum;
	private int currentPageNum;
	
	public Book(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	
	public void page(int pageNum) {
		this.currentPageNum = pageNum;
	}
	
	public void next() {
		this.currentPageNum++;
	}
	
	public void prev() {
		this.currentPageNum--;
	}
	
	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	@Override
	public void read() {
		System.out.println("책을 읽습니다.");
	}

	@Override
	public String toString() {
		return ", 총페이지 : " + totalPageNum + ", 현재 페이지 : " + currentPageNum + "]";
	}

	
}
