package com.kh.exam16;

import java.util.Arrays;

public class Sample1 {

	public static void main(String[] args) {
		String str = "동일 문자열 확인";
		boolean res = str.equals("동일 문자열 확인");
		System.out.println(res);
		
		str = "문자열에서 일부 문자문 추출";
		char resChar = str.charAt(2);
		System.out.println(resChar);
		
		str = "문자열의 길이를 구함";
		int resInt = str.length();
		System.out.println(resInt);
		
		str = "문자열과 문자열 붙이기";
		String resStr= str.concat("이 문자열이 붙었습니다.");
		System.out.println(resStr);
		
		str = "문자열 사전순 비교";
		resInt = str.compareTo("가나다");
		System.out.println(resInt);
		resInt = str.compareTo("아자차");
		System.out.println(resInt);
		
		str = "문자열에서 특정 문자열을 변경";
		resStr= str.replace("특정", "일부");
		System.out.println(resStr);
		
		str = "문자열에서 특정 구분자를 기준으로 문자열 분리";
		String[] resStrArr= str.split(" ");
		System.out.println(Arrays.toString(resStrArr));
		str = "010-1234-5678";
		resStrArr = str.split("-");
		System.out.println(Arrays.toString(resStrArr));
		str = "username@sample.com";
		resStrArr = str.split("@");
		System.out.println(Arrays.toString(resStrArr));

		str = "분리된 문자열을 특정 구분자를 기준으로 다시 결합";
		resStrArr = str.split(" ");
		resStr = str.join("\t", resStrArr);
		System.out.println(resStr);
		str = "010-1234-5678";
		resStrArr = str.split("-");
		resStr = str.join("-", resStrArr);
		System.out.println(resStr);
		
		str = "     불필요한 앞/뒤 공백을 제거      ";
		resStr = str.trim();
		System.out.println(resStr);
		str = "\t\t불필요한 앞/뒤 공백을 제거\t\t";
		resStr = str.trim();
		System.out.println(resStr);
		
		str = "문자열에서 일부 문자열만 분리";
		resStr = str.substring(2);
		System.out.println(resStr);
		resStr = str.substring(0, 5);
		System.out.println(resStr);
		
		str = "문자열에서 지정한 문자열의 위치 찾기";
		resInt = str.indexOf("위치");
		System.out.println(resInt + "에 " + str.substring(resInt, resInt+2) + 
				"가 있습니다.");
		resInt = str.indexOf("문자열");
		System.out.println(resInt);
		// 이전에 찾은 위치 다음 인덱스 부터 다시 찾기
		resInt = str.indexOf("문자열", resInt + 1);
		System.out.println(resInt);
		str = "이 문자열에는 다양한 문자들이 포함되어 있는 문자열 입니다.";
		resInt = str.indexOf("문자");
		System.out.println(resInt);
		resInt = str.indexOf("문자", resInt + 1);
		System.out.println(resInt);
		resInt = str.indexOf("문자", resInt + 1);
		System.out.println(resInt);
		resInt = str.indexOf("문자", resInt + 1);
		System.out.println(resInt);
		
		
		// 문자열에서 특정 문자열의 모든 위치를 찾아 배열에 담는 코드
		int[] resIntArr = new int[0];
		int idx = -1;
		while(true) {
			if(str.indexOf("문자", ++idx) != -1) {
				int temp[] = new int[resIntArr.length + 1];
				System.arraycopy(resIntArr, 0, temp, 0, resIntArr.length);
				idx = str.indexOf("문자", idx + 1);
				temp[temp.length - 1] = idx;
				resIntArr = temp;
			} else {
				break;
			}
		}
		System.out.println(Arrays.toString(resIntArr));
		
		str = "영문자를 대문자/소문자로 변경한다. abCdEF";
		resStr = str.toUpperCase();
		System.out.println(resStr);
		resStr = str.toLowerCase();
		System.out.println(resStr);
	
		str = "정수 포맷 : %d";
		resStr = String.format(str, 10);
		System.out.println(resStr);
		
		str = "실수 포맷 : %.2f";
		resStr = String.format(str, 10.123);
		System.out.println(resStr);
		
		str = "천단위구분 포맷 : %,d";
		resStr = String.format(str, 123456789);
		System.out.println(resStr);
		str = "천단위구분 포맷 : %,.2f";
		resStr = String.format(str, 10123412.123);
		System.out.println(resStr);
		
		str = "문자열 포맷 : %s";
		resStr = String.format(str, "문자열");
		System.out.println(resStr);
		
		str = "일정한 영역에서 오른쪽 정렬 포맷 : %5d";
		resStr = String.format(str, 123);
		System.out.println(resStr);
		
		str = "일정한 영역에서 왼쪽 정렬 포맷 : %-5d";
		resStr = String.format(str, 123);
		System.out.println(resStr);
		
		str = "일정한 영역에서 오른쪽 정렬 포맷 : %5s";
		resStr = String.format(str, "abc");
		System.out.println(resStr);
		
		str = "일정한 영역에서 왼쪽 정렬 포맷 : %-5s";
		resStr = String.format(str, "abc");
		System.out.println(resStr);
		
		str = "빈 공간을 0으로 채우기 포맷 : %05d";
		resStr = String.format(str, 123);
		System.out.println(resStr);
		
		str = "%s의 나이는 %d 세 입니다.";
		resStr = String.format(str, "홍길동", 23);
		System.out.println(resStr);
		
		str = "%2$s의 나이는 %1$d 세 입니다.";
		resStr = String.format(str, 23, "홍길동");
		System.out.println(resStr);
		
		str = "아스키 코드 %1$d 는 아스키 문자 %1$c 입니다.";
		resStr = String.format(str, 65);
		System.out.println(resStr);
	}

}
