package com.kh.exam16;

public class Sample4 {

	public static void main(String[] args) {
		/*
		 *  StringBuilder / StringBuffer
		 *      - 두 클래스의 기능은 동일하나 멀티쓰레드의 안정성을 제공하는지 제공하지 않는지에 대한
		 *        차이만을 가진다.(StringBuffer가 멀티쓰레드의 안정성을 제공한다.)
		 */
		StringBuilder sb = new StringBuilder();
		
		// 기존 문자열 뒤에 데이터 삽입
		sb.append("StringBuilder의 메서드");
		sb.append(" append() 는 기존 문자열 뒤에 추가 합니다.\n");
		System.out.println(sb);
		
		// 지정한 위치에 데이터 삽입
		sb.insert(0, "StringBuffer/");
		// StringBuffer/StringBuilder의 메서드 append() 메서드는 기존 문자열 뒤에 추가 합니다.
		sb.insert(sb.indexOf("append()") + 9, "메서드");
		System.out.println(sb);
		
		// 수정 : 수정할 문자열의 위치를 작성하여 수정한다.
//		int stIdx = sb.indexOf("메서드");
//		sb.replace(stIdx, stIdx + 3, "method");
//		System.out.println(sb);
		
		// 수정 처리를 할 때 동일한 문자열에 대해 전부 수정될 수 있도록 반복문을 활용해 본다.
		int idx = -1;
		String find = "메서드";
		while(true) {
			idx = sb.indexOf(find, idx + 1);
			if(idx != -1) {
				sb.replace(idx, idx + find.length(), "method");
			} else {
				break;
			}
		}
		System.out.println(sb);
		
		// 삭제 : 삭제할 문자열의 위치를 작성하여 삭제한다.
//		stIdx = sb.indexOf("method");
//		sb.delete(stIdx, stIdx + 7);
//		System.out.println(sb);
		
		// 삭제 처리를 할 때 동일한 문자열에 대해 전부 삭제될 수 있도록 반복문을 활용해 본다.
		idx = -1;
		find = " method";
		while(true) {
			idx = sb.indexOf(find, idx + 1);
			if(idx != -1) {
				sb.delete(idx, idx + find.length());
			} else {
				break;
			}
		}
		System.out.println(sb);
	}

}
