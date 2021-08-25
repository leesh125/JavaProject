package com.kh.practice.chap01_poly.controller;

import java.util.ArrayList;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryController {
	private Member mem = null;
	//private Book[] bList = new Book[5];
	private ArrayList<Book> bList = new ArrayList<Book>();
	{
		bList.add(new CookBook("백종원의 집밥", "백종원", "tvN", true));
		bList.add(new AniBook("한번 더 해요", "미티", "원모어", 19));
		bList.add(new AniBook("루피의 원피스", "루피", "japan", 12));
		bList.add(new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false));
		bList.add(new CookBook("최현석 날 따라해봐", "최현석", "소금책", true));

	}

	
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return mem;
	}
	
	public ArrayList<Book> selectAll(){
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
//		int count=0;
//		Book[] findBook = new Book[count];
//		for(int i=0; i<bList.length; i++) {
//			String resStr = bList[i].getTitle();
//			if(resStr.indexOf(keyword) != -1) {
//				findBook = new Book[++count];
//				findBook[findBook.length-1] = bList[i];
//			}
//		}
		int count = 0;
		Book[] findBook = new Book[5];
		for(Book b : bList) {
			if(b.getTitle().contains(keyword)) {
				findBook[count++] = b;
			}
		}
		
		return findBook;
	}
	
	public int rentBook(int index) {
		int result = 0;
		int i = 0;
		
		if(bList.get(index) instanceof AniBook) {
			if(((AniBook) bList.get(index)).getAccessAge() > mem.getAge()) {
				result = 1;
			}
		}else if(bList.get(index) instanceof CookBook) {
			if(((CookBook) bList.get(index)).isCoupon() == true) {
				result = 2;
				mem.setCouponCount(++i);
			}
		}
		return result;
	}

	public Member getMem() {
		return mem;
	}

	public void setMem(Member mem) {
		this.mem = mem;
	}

	public ArrayList<Book> getbList() {
		return bList;
	}

	public void setbList(ArrayList<Book> bList) {
		
		this.bList = bList;
	}
	
	public void addBookList(Book b) {
		bList.add(b);
	}
	
	
	
	
}
