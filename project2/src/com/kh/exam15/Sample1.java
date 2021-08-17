package com.kh.exam15;

public class Sample1 {

	public static void main(String[] args) {
		/*
		 * 1. 페이지 인터페이스 생성
		 *     a. read()
		 *     
		 * 2. 페이지 인터페이스를 상속하여 책 클래스 생성
		 *     a. 전체 페이지 번호, 현재 페이지 번호 속성을 정의
		 *     b. page(), next(), prev() 메서드 정의
		 *     
		 * 3. 책 클래스를 상속하여 소설, 만화, 잡지 클래스 정의
		 *     a. 책이름, 출판사
		 *     b. 소설은 read() 구현할 때 "글자를 읽습니다." 로 구현
		 *        만화는 read() 구현할 때 "그림을 봅니다." 로 구현
		 *        잡지는 read() 구현할 때 "그림과 글자를 보고 읽습니다." 로 구현
		 *        
		 * 4. 소설 클래스에는 다음의 내용을 추가 구현
		 *     a. 장르, 작가 속성 
		 *     b. search() 구현
		 *     
		 * 5. 만화 클래스에는 다음의 내용을 추가 구현
		 *     a. 글작가, 그림작가, 연령 제한 속성
		 *     
		 * 6. 잡지 클래스에는 다음의 내용을 추가 구현
		 *     a. 에디터, 종류 속성
		 *     b. QRCapture() 구현
		 */
		Magazine[] mArr = new Magazine[0];
		Comics[] cArr = new Comics[0];
		Novel[] nArr = new Novel[0];

		
		Book[] books = new Book[5];
		books[0] = new Novel("해리포트 불의 잔", "문학수첩", "판타지", "J.K 롤링", 268);
		books[1] = new Comics("원피스 98", "대원", "오다에이이치로", "오다에이이치로", 12, 192);
		books[2] = new Magazine("에스콰이어", "허스트중앙", "에스콰이어 편집부", "여성/남성", 82);
		books[3] = new Novel("해리포트 마법사의 돌", "문학수첩", "판타지", "J.K 롤링", 244);
		books[4] = new Comics("원피스 97", "대원", "오다에이이치로", "오다에이이치로", 12, 192);
		
		for(Book b: books) {
			System.out.println(b);
		}

		for(Book b: books) {
			if(b instanceof Magazine) {
				Magazine[] copy = new Magazine[mArr.length + 1];
				for(int i=0; i<mArr.length; i++) {
					copy[i] = mArr[i];
				}
				copy[copy.length - 1] = (Magazine) b;
				mArr = copy;
			}else if(b instanceof Novel) {
				Novel[] copy = new Novel[nArr.length + 1];
				for(int i=0; i<nArr.length; i++) {
					copy[i] = nArr[i];
				}
				copy[copy.length - 1] = (Novel) b;
				nArr = copy;
			}else if(b instanceof Comics) {
				Comics[] copy = new Comics[cArr.length + 1];
				for(int i=0; i<cArr.length; i++) {
					copy[i] = cArr[i];
				}
				copy[copy.length - 1] = (Comics) b;
				cArr = copy;
			}
		}
		for(Magazine m: mArr) {
			System.out.println(m);
		}
		for(Comics c: cArr) {
			System.out.println(c);
		}
		for(Novel n: nArr) {
			System.out.println(n);
		}
		
		
	}

}
