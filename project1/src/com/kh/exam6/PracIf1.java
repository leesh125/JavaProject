package com.kh.exam6;

import java.util.Scanner;

public class PracIf1 {

	static Scanner sc = new Scanner(System.in);
	public static void ex1() {
		System.out.println("문제 1번.");
		/* 영문자 알파벳 범위의 ASCII 코드 번호를 입력받은 경우에만 해당하는 문자를
		 * 출력하고 범위를 벗어난 경우에는 "ASCII 코드 영문자 범위를 벗어났습니다."
		 * 라는 메시지를 출력한다.
		 */
		int asc;
		System.out.printf("ASCII 코드 입력 : ");
		
		asc = sc.nextInt();  sc.nextLine();
		
		if(asc >= 'A' && asc <= 'Z') {
			System.out.printf("입력한 ASCII 코드 %d를 변환하면 :%c \n",asc,asc);
		}else if(asc >= 'a' && asc <= 'z'){
			System.out.printf("입력한 ASCII 코드 %d를 변환하면 :%c \n",asc,asc);
		}else {
			System.out.println("한도초과");			
		}
		
		
	}
	
	public static void ex2() {
		System.out.println("===========");
		System.out.println("문제 2번.");
		/*
		 * 국어, 영어, 수학 세 과목의 시험 점수를 입력 받아 총점과 평균을 구하고
		 * 평균이 60점 이상인 경우에 "합격입니다." 메시지를 출력하고 60점 이상이
		 * 아닌 경우에 "불합격입니다." 메시지를 출력한다.
		 */
		int kor, eng, math;
		int sum=0;
		double avg=0;
		String msg = "불합격";
		
		System.out.print("국어 점수를 입력하세요 : ");
		kor = sc.nextInt();
		
		System.out.print("영어 점수를 입력하세요 : ");
		eng = sc.nextInt();
		
		System.out.print("수학 점수를 입력하세요 : ");
		math = sc.nextInt();
		
		sum = kor + eng + math;
		avg = sum / 3.0;
		
		System.out.print("총점은 " + sum );
		System.out.printf(", 평균은 %.2f\n",avg);
		
		if(avg >= 60) {
			msg = "합격";
		} 
		
		System.out.println(msg + "입니다");
	}
	
	public static void ex3() {
		System.out.println("===========");
		System.out.println("문제 3번.");
		/*
		 * 2021년 7월에 한하여 1 ~ 31 일 범위의 일자값을 입력받고 해당 일자의
		 * 요일을 출력하게 한다. 입력값의 범위를 벗어난 경우 "1 ~ 31 사이의 값을 
		 * 입력하세요." 라는 메시지를 출력한다.
		 */
		int day;
		System.out.print("2021년 7월에 날짜를 입력하세요 : ");
		day = sc.nextInt();    sc.nextLine();
		
		if(day >= 1 && day <= 31) {
			switch(day % 7) {
				case 0:
					System.out.println("수요일 입니다.");	break;
				case 1:
					System.out.println("목요일 입니다.");	break;
				case 2:
					System.out.println("금요일 입니다.");	break;
				case 3:
					System.out.println("토요일 입니다.");	break;
				case 4:
					System.out.println("일요일 입니다.");	break;
				case 5:
					System.out.println("월요일 입니다.");	break;
				case 6:
					System.out.println("화요일 입니다.");
			}
			
			switch(day % 7) {
				// 여러 케이스를 작성.
				case 3: case 4:
					System.out.println("주말입니다.");	break;
				default:
					System.out.println("주중입니다.");
			}
		} else {
			System.out.println("1 ~ 31 사이의 값을 입력하세요.");
		}
		
//		if(day < 1 && day >= 32){
//			System.out.println("1 ~ 31 사이의 값을 입력하세요");
//		}else if(day % 7 == 0) {
//			System.out.println("2021년 7월 "+day+"일은 수요일입니다");
//		}else if(day % 7 == 1) {
//			System.out.println("2021년 7월 "+day+"일은 목요일입니다");
//		}else if(day % 7 == 2) {
//			System.out.println("2021년 7월 "+day+"일은 금요일입니다");
//		}else if(day % 7 == 3) {
//			System.out.println("2021년 7월 "+day+"일은 토요일입니다");
//		}else if(day % 7 == 4) {
//			System.out.println("2021년 7월 "+day+"일은 일요일입니다");
//		}else if(day % 7 == 5) {
//			System.out.println("2021년 7월 "+day+"일은 월요일입니다");
//		}else if(day % 7 == 6) {
//			System.out.println("2021년 7월 "+day+"일은 화요일입니다");
//		}
		
	}
	
	public static void ex4() {
		System.out.println("===========");
		System.out.println("문제 4번.");
		/*
		 * 나이를 입력하면 해당 나이대를 출력하도록 한다.
		 * 
		 * 예 1.)
		 * 		나이 입력 : 21
		 * 		20대 입니다.
		 * 
		 * 예 2.)
		 * 		나이 입력 : 12
		 * 		청소년 입니다.
		 * 
		 * 1 ~ 4 세까지는 영유아, 5 ~ 9 세까지는 어린이, 10 ~ 19 세까지는 청소년
		 * 20 ~ 100 까지는 20대, 30대, 40대, 50대 형식으로 변환하여 출력한다.
		 */
		int age;
		System.out.print("나이 입력 : ");
		age = sc.nextInt();
		String ages= "100세 이상";
		
		if(age >= 1 && age <=4) {
			ages = "영유아";
		}else if(age >= 5 && age <=9) {
			ages = "어린이";
		}else if(age >= 10 && age <=19) {
			ages = "청소년";
		}else if(age >= 20 && age <30) {
			ages = "20대";
		}else if(age >= 30 && age <40) {
			ages = "30대";
		}else if(age >= 40 && age <50) {
			ages = "40대";
		}else if(age >= 50 && age <60) {
			ages = "50대";
		}else if(age >= 60 && age <70) {
			ages = "60대";
		}else if(age >= 70 && age <80) {
			ages = "70대";
		}else if(age >= 80 && age <90) {
			ages = "80대";
		}else if(age >= 90 && age <100) {
			ages = "90대";
		}
		
		System.out.println(ages + " 입니다.");
		
	}
	
	public static void ex5() {
		System.out.println("===========");
		System.out.println("문제 5번.");
		/*
		 * 키(cm)와, 체중(kg)을 입력하여 BMI 지수를 구하고 BMI 지수에 해당하는 정상, 과체중,
		 * 비만, 고도비만 등의 정보를 출력하도록 한다.
		 * 
		 * BMI 지수의 계산식 -> BMI = 체중(kg) / (키(m) * 키(m))
		 * 
		 * BMI 지수에 따른 정보
		 * 		18.5 미만 : 저체중
		 * 		18.5 이상 ~ 23 미만 : 정상
		 * 		23 이상 ~ 25 미만 : 과체중
		 * 		25 이상 ~ 30 미만 : 비만
		 * 		30 이상 : 고도비만
		 */
		double height,weight,bmi;
		String bmistr="";
		
		System.out.print("키를 입력하세요(소수): ");
		height = sc.nextDouble();
		height = height / 100.0; // cm -> m 로 변환.
		
		System.out.print("체중를 입력하세요(소수): ");
		weight = sc.nextDouble();
		
		bmi = height / (height*height);
		
		if(bmi <18.5) {
			bmistr="저체중";
		}else if(bmi >= 18.5 && bmi <23) {
			bmistr="정상";
		}else if(bmi >= 23 && bmi <25) {
			bmistr="과체중";
		}else if(bmi >= 25 && bmi <30) {
			bmistr="비만";
		}else {
			bmistr="고도비만";
		}
		
		System.out.println("당신의 키는 " +height + ", 몸무게는" + weight +
							", BMI 지수는 " + bmistr + " 입니다.");
		
	}
	
	public static void ex6() {
		System.out.println("===========");
		System.out.println("문제 6번.");
		/*
		 * 시간과 분을 따로 입력받고 추가로 분을 더 입력받아 입력받은 시간에서 추가로 입력한 분의
		 * 더한 시간을 출력하도록 한다. 입력 시간은 24시간 형식을 입력 받고 출력 시간은 오전/오후
		 * 를 구분하는 12시간 형식을 출력하도록 한다.
		 * 		- 24시간 형식의 12시 30분은 12시간 형식의 오후 12시 30분 이다.
		 * 		- 24시간 형식의 00시 30분은 12시간 형식의 오전 12시 30분 이다.
		 * 		- 24시간 형식의 23시 30분은 12시간 형식의 오후 11시 30분 이다.
		 * 		- 24시간 형식의 11시 30분은 12시간 형식의 오전 11시 30분 이다.
		 * 
		 * 예 1.)
		 * 		시간 입력 : 23
		 * 		분 입력 : 50
		 * 		추가 분 입력 : 20
		 * 		입력 시간에서 20분을 추가한 시간은 오전 12시 10분 입니다.
		 * 
		 * 0 ~ 23 시간의 입력 범위를 넘기면 지정한 범위의 값을 입력하도록하는 메시지 출력
		 */
		int hour, min, addmin, time;
		String day= "오전";
		
		System.out.print("시간 입력 : ");
		hour = sc.nextInt();
		if(hour >= 24) {
			System.out.println("24 이하로 시간을 입력하세요"); 
			System.exit(0);
		}
		
		System.out.print("분 입력 : ");
		min = sc.nextInt();
		if(min >= 60) {
			System.out.println("60 이하로 시간을 입력하세요"); 
			System.exit(0);
		}
		
		System.out.print("추가 분 입력 : ");
		addmin = sc.nextInt();
		
		time = min + addmin;
		
		if(time >= 60) {
			int addhour = time / 60;
			time = time % 60;
			hour = hour + addhour;
			
		//	hour++;
		}
		if(hour == 12) {
			day = "오후";
		}else if(hour >=13 && hour < 24){
			hour = hour % 12;
			day = "오후";
		}else if(hour>=0 && hour < 12) {
			day = "오전";
		}else if(hour==24){
			hour = 12;
			day = "오전";
		}else if(hour >= 25) {
			hour = hour % 24;
		}		
		
		System.out.println("현재시간은 "+ day+ " " + hour + "시 " + time+ "분 입니다.");
		
//		int hour, minute, addMinute;
//
//		System.out.print("시간 입력 : ");
//		hour = sc.nextInt();	sc.nextLine();
//
//		System.out.print("분 입력 : ");
//		minute = sc.nextInt();	sc.nextLine();
//
//		System.out.print("추가 분 입력 : ");
//		addMinute = sc.nextInt();	sc.nextLine();
//
//		if(hour >= 0 && hour <= 23) {
//			if(minute >= 0 && minute < 60) {
//				
//				// 입력 분에 추가분 더함.
//				minute = minute + addMinute;
//				
//				// 추가분을 더한 결과가 60을 넘으면 시간으로 환원시키기 위해 작성된 코드
//				if(minute >= 60) {
//					hour = hour + (minute / 60);
//					minute = minute % 60;
//				}
//				
//				// 24 시간이 넘어가면 24로 나머지 계산하여 나머지 값만 취함.
//				if(hour >= 24) {
//					hour = hour % 24;
//				}
//
//				if(hour == 0) {
//					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오전 12시 %d분 입니다.",
//							addMinute, minute);
//				} else if(hour == 12) {
//					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오후 12시 %d분 입니다.",
//							addMinute, minute);
//				} else if(hour >= 1 && hour <= 11) {
//					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오전 %d시 %d분 입니다.",
//							addMinute, hour, minute);
//				} else if(hour >= 13 && hour <= 23) {
//					System.out.printf("입력 시간에서 %d 분을 추가한 시간은 오후 %d시 %d분 입니다.",
//							addMinute, hour - 12, minute);
//				}
//
//			} else {
//				System.out.println("0 ~ 59 사이의 분을 입력하세요.");
//			}
//		} else {
//			System.out.println("0 ~ 23 사이의 시간을 입력하세요.");
//		}
		
	}
	
	public static void ex7() {
		char op;
		
		System.out.print("사칙연산 기호를 입력하세요 : ");
		// 문자 입력 받기
		op = sc.nextLine().charAt(0);
		
		switch(op) {
			case '+':
				System.out.println("더하기 기호를 입력했습니다.");
				break;
			case '-':
				System.out.println("빼기 기호를 입력했습니다.");
				break;
			case '*':
				System.out.println("곱하기 기호를 입력했습니다.");
				break;
			case '/':
				System.out.println("나누기 기호를 입력했습니다.");
				break;
			default:
				System.out.println("사칙연산 기호가 아닙니다.");
				break;
		
		}
	}
	
	public static void ex8() {
		String op;
		
		System.out.println("더하기, 빼기, 곱하기, 나누기 중 하나를 선택하여 입력하세요.");
		System.out.print(": ");
		
		op = sc.nextLine();
		
		switch(op) {
			case "더하기":
				System.out.println("더하기는 + 기호를 사용합니다."); 
				break;
			case "빼기":
				System.out.println("빼기는 - 기호를 사용합니다."); 
				break;
			case "곱하기":
				System.out.println("곱하기는 * 기호를 사용합니다."); 
				break;
			case "나누기":
				System.out.println("나누기는 / 기호를 사용합니다."); 
				break;
			default:
				System.out.println("더하기, 빼기, 곱하기, 나누기 중 하나를 입력하세요.");
		}
	}
	
	public static void ex9() {
		/*
		 * 단위 변환 프로그램 만들기
		 * 
		 * 1. cm -> m 로 변환 또는 m -> cm 로 변환 하는 기능을 만든다.
		 * 2. g -> kg 으로 kg -> g 으로 변환하는 기능을 만든다.
		 * 3. Byte -> MByte로 MByte 를 Byte로 변환하는 기능을 만든다.
		 * 
		 * 각각의 기능은 처음 입력하는 단위가 무엇인가에 따라 바뀌게 된다.
		 * 예 1.)
		 * 		단위변환 입력 : cm
		 * 		cm 값을 입력하면 m 값으로 변환 합니다.
		 * 		cm 입력 : 100
		 * 		결과 : 1. 0m 입니다.
		 * 
		 * 예 2.)
		 *		단위변환 입력 : KByte
		 * 		KByte 값을 입력하면 Byte 값으로 변환 합니다.
		 * 		KByte 입력 : 1
		 * 		결과 : 1024.0 Byte 입니다.
		 */
		int add=0;
		while(true) {
			double cen, met, gram, kgram, by, kby;
			String change="";
	
			System.out.print("단위변환 입력 : ");
			change = sc.nextLine();
			
			switch(change) {
				case "cm":
					System.out.println(change + "값을 입력하면 m 값으로 변환 합니다.");
					System.out.print(change + " 입력 :");
					cen = sc.nextDouble();
					sc.nextLine();
					met = cen / 100.0;
					System.out.println("결과 : " + met + "m 입니다.");
					break;
				case "m":
					System.out.println(change + "값을 입력하면 cm 값으로 변환 합니다.");
					System.out.print(change + " 입력 :");
					met = sc.nextDouble();
					sc.nextLine();
					cen = met * 100.0;
					System.out.println("결과 : " + cen + "cm 입니다.");
					break;
				case "g":
					System.out.println(change + "값을 입력하면 kg 값으로 변환 합니다.");
					System.out.print(change + " 입력 :");
					gram = sc.nextDouble();
					sc.nextLine();
					kgram = gram / 1000.0;
					System.out.println("결과 : " + kgram + "kg 입니다.");
					break;
				case "kg":
					System.out.println(change + "값을 입력하면 g 값으로 변환 합니다.");
					System.out.print(change + " 입력 :");
					kgram = sc.nextDouble();
					sc.nextLine();
					gram = kgram * 1000.0;
					System.out.println("결과 : " + gram+ "g 입니다.");
					break;
				case "Byte":
					System.out.println(change + "값을 입력하면 KByte 값으로 변환 합니다.");
					System.out.print(change + " 입력 :");
					by = sc.nextDouble();
					sc.nextLine();
					kby = by / 1024.0;
					System.out.println("결과 : " + kby + "KByte 입니다.");
					break;
				case "KByte":
					System.out.println(change + "값을 입력하면 Byte 값으로 변환 합니다.");
					System.out.print(change + " 입력 :");
					kby = sc.nextDouble();
					sc.nextLine();
					by = kby * 1024.0;
					System.out.println("결과 : " + by + "Byte 입니다.");
					break;
			}
			add++;
			System.out.println("단위변환 " + add +"번 종료");
			System.out.println("===================\n");
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
//		ex8();
		ex9();
		
	}

}
