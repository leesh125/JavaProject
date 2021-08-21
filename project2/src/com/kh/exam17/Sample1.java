package com.kh.exam17;

import java.text.SimpleDateFormat;
import java.util.*;

public class Sample1 {
	private static Scanner sc = new Scanner(System.in);
	public static void ex1() {
		List<Integer> aList = new ArrayList<Integer>();
		
		// 마지막 인데스에 추가
		aList.add(10);   aList.add(20);    aList.add(30);
		System.out.println(aList);
		
		// 지정한 인덱스에 추가
		aList.add(1,40);
		System.out.println(aList);
		
		// 지정한 인덱스의 데이터 수정
		aList.set(2, 22);
		System.out.println(aList);
		
		// 주어진 객체가 존재하는지 검색
		boolean resBool = aList.contains(10);
		System.out.println(resBool);
		
		resBool = aList.contains(20);
		System.out.println(resBool);

		// 주어진 인덱스로 저장된 객체 검색
		int resInt = aList.get(0);
		System.out.println(resInt);
		
		// 인덱스의 범위를 벗어나면 에러 발생
		// resInt = aList.get(5);
		// System.out.println(resInt);
		
		// iterator() -> 반복자 객체를 반환
		Iterator<Integer> iter = aList.iterator();
		while(iter.hasNext()) {
			System.out.println("Iterator 로 추출 -> " + iter.next());
		}
		
		for(Integer i : aList) {
			System.out.println("for each 로 추출 -> " + i);
		}
		
		// 컬렉션이 비어있는지 조사
		 
		//aList.clear(); // 컬렉션의 모든 객체 제거
		resBool = aList.isEmpty();
		System.out.println("aList의 내용이 비어있습니까? -> " + resBool);
		
		// 저장되어 있는 전체 객체 수
		resInt = aList.size();
		System.out.println("aList의 객체 수 -> " + resInt);
		
		// 주어진 인덱스로 객체 삭제
		resInt = aList.remove(0);
		System.out.println(resInt + "이(가) 삭제되어 " + aList + " 가 남았습니다.");
		
		// 주어진 객체로 찾아서 삭제(주의: 정수 데이터는 인덱스로 보기 떄문에 Integer로 랩핑해야 함)
		resBool = aList.remove(new Integer(22));
		System.out.println("객체 삭제가 되었습니까? -> " + resBool);
	}
	
	public static void ex2() {
		/*
		 * 사용자 입력으로 정수 데이터를 받아 ArrayList 에 저장 후
		 * ArrayList에 저장된 모든 정수의 합을 구하여 출력한다.
		 * (단, 사용자 입력은 한 번만 사용한다.)
		 */
		List<Integer> aList = new ArrayList<Integer>();
		while(true) {
			System.out.print("저장시킬 정수를 입력(띄어쓰기로 구분) : ");
			String sNum = sc.nextLine();
			String[] splitNum = sNum.split(" ");
		
			try {
				for(String s: splitNum) {
					aList.add(Integer.valueOf(s));
				}
			}catch(Exception e) {
				System.out.println("정수만 입력하세요(띄어쓰기 구분)");
				aList.clear();	continue;
			}
			System.out.println(aList);
			break;
		}
		
	}
	
	public static void ex3() {
		/*
		 * 사용자 입력으로 실수 데이터를 받아 ArrayList 에 저장 후
		 * ArrayList에 저장된 모든 실수의 합과 평균을 구하여 출력한다.
		 * (단, 사용자 입력은 한 번만 사용한다.)
		 */
		List<Double> dList = new ArrayList<Double>();
		while(true) {
			System.out.print("저장시킬 실수를 입력(띄어쓰기로 구분) : ");
			String sNum = sc.nextLine();
			String[] splitNum = sNum.split(" ");
			double sum = 0;
			
			try {
				for(String s: splitNum) {
					dList.add(Double.valueOf(s));
					sum += Double.valueOf(s);
				}
			}catch(Exception e) {
				System.out.println("정수만 입력하세요(띄어쓰기 구분)");
				dList.clear();	continue;
			}
			
			System.out.println(dList);
			System.out.println("저장된 실수들의 합은 : " + sum +", 평균은 " + sum/dList.size());
			break;
		}
	}
	
	public static void ex4() {
		/*
		 * 다음의 요구사항을 잘 보고 요구사항에 맞도록 구현한다.
		 * 	- 사용자 입력으로 정수 데이터를 받아 ArrayList 에 저장을 해야 한다.
		 * 	- 사용자 입력으로 하나의 정수 데이터를 입력 할 수 있지만 2개 이상의 정수를 입력 하기도 한다.
		 * 	- 동일한 정수 데이터는 ArrayList에 저장되지 않도록 한다.
		 */
		List<Integer> aList = new ArrayList<Integer>();
		while(true) {
			System.out.print("저장시킬 정수를 입력(띄어쓰기로 구분) : ");
			String sNum = sc.nextLine();
			String[] splitNum = sNum.split(" ");
		
		
			try {
				for(String s: splitNum) {
					aList.add(Integer.valueOf(s));
				}
			}catch(Exception e) {
				System.out.println("정수만 입력하세요(띄어쓰기 구분)");
				aList.clear();	continue;
			}
			
			for(int i=0; i<aList.size()-1; i++) {
				for(int j=i+1; j<aList.size(); j++) {
					
					if(aList.get(i) == aList.get(j)) {
						aList.remove(j);
					}
				}
			}
			System.out.println(aList);
			break;
		}
	}
	
	public static void ex5() {
		/*
		 * 사용자 입력으로 최소값, 최대값, 갯수 를 입력받아 다음 요구사항에 맞도록 구현한다.
		 * 	- 최소값, 최대값은 랜덤을 통해 생성할 값의 범위이다.
		 * 	- 갯수는 랜덤을 통해 생성할 값의 수량 이다.
		 * 	- 생성된 랜덤값은 ArrayList 에 저장한다.
		 * 	- ArrayList에 저장한 정수는 중복이 없어야 한다.
		 */
		List<Integer> aList = new ArrayList<Integer>();
		
		System.out.print("최소값 입력 : ");
		int min = sc.nextInt();		sc.nextLine();
		System.out.print("최댓값 입력 : ");
		int max = sc.nextInt();		sc.nextLine();
		System.out.print("갯수 입력 : ");
		int count = sc.nextInt();	sc.nextLine();
		
		
		for(int i=0; i<count; i++) {
			int rangeNum = (int)((Math.random()*(max-min+1))+min);
			aList.add(rangeNum);
			
			if(i != 0) {
				for(int k=0; k<aList.size()-1; k++) {
					for(int j=k+1; j<aList.size(); j++) {
						
						if(aList.get(k) == aList.get(j)) {
							aList.remove(k);
						}
					}
				}
			}
		}
		
		System.out.println(aList);

	}
	
	public static void ex6() {
		/*
		 * 현재 날짜를 구한 후 ArrayList에 년, 월, 일, 시간, 분, 초 데이터가
		 * 저장되도록 한다.
		 */
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dFormat.format(cal.getTime());
		
		System.out.println(date);
		
		List<Integer> dateList = new ArrayList<Integer>();
		dateList.add(cal.get(Calendar.YEAR));		dateList.add(cal.get(Calendar.MONTH));
		dateList.add(cal.get(Calendar.DATE));		dateList.add(cal.get(Calendar.HOUR));
		dateList.add(cal.get(Calendar.MINUTE));;	dateList.add(cal.get(Calendar.SECOND));
		
		System.out.println(dateList);

		
		
	}
	
	public static void ex7() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 하도록 한다
		 * ArrayList 에 저장하는 데이터는 10개로 제한한다.
		 */
		List<Integer> aList = new ArrayList<Integer>();
		int count = 0;
		
		while(count < 10) {
			int random = (int)(Math.random()*99+1);
			Calendar cal = Calendar.getInstance();
			int firstTime = cal.get(Calendar.SECOND);
			
			while(true) {
				Calendar cal2 = Calendar.getInstance();
				int laterTime = cal2.get(Calendar.SECOND);
				
				if(laterTime - firstTime == 3 | laterTime - firstTime == -57) {
					aList.add(random);
					System.out.println(aList);
					count++;
					break;
				}else {
					continue;
				}
			}
		}
	}
	
	public static void ex8() {
		/*
		 * 3초에 한번씩 정기적으로 1 ~ 99 사이의 랜덤값을 ArrayList 에 저장을 할 때 저장 시간도
		 * 같이 ArrayList에 저장하도록 하며 저장하는 데이터는 10개로 제한한다.
		 * (단, 중복 데이터는 저장이 안되도록 하며, ArrayList를 2개 이용하도록 한다. 시간은 년월일
		 * 시분초까지만 저장하도록 한다.)
		 */
		List<Integer> aList = new ArrayList<Integer>();
		List<String> dateList = new ArrayList<String>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int count=0 ,overlap = 0;
		
		while(count < 10) {
			int random = (int)(Math.random()*99+1);
			Calendar cal = Calendar.getInstance();
			int firstTime = cal.get(Calendar.SECOND);
			for(int i=0; i<aList.size();i++) {
				if(random == aList.get(i)) {
					overlap++;
				}
			}
			if(overlap >= 1) {
				overlap = 0;
				continue;
			}
			
			while(true) {
				Calendar cal2 = Calendar.getInstance();
				int laterTime = cal2.get(Calendar.SECOND);
				
				if(laterTime - firstTime == 3 | laterTime - firstTime == -57) {
					String date = dFormat.format(cal.getTime());
					aList.add(random);		dateList.add(count, date);
					System.out.println("배열: " + aList + "\n생성된 시간 : " + dateList);	
					count++;
					break;
				}else {
					continue;
				}
			}
			
		}
	}
	public static void main(String[] args) {
//		ex1();
//		ex2();
//		ex3();
//		ex4();
//		ex5();
//		ex6();
//		ex7();
		ex8();



		
	}

	

}
