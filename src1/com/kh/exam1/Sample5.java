package com.kh.exam1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Sample5 {
	
	public static void main(String[] args) {
		/*
		 *  키와 값을 문자열만 사용할 수 있도록 제한한 객체
		 *  프로퍼티 파일을 쉽게 익고 쓸 수 있는 기능 제공.
		 */
		Properties p = new Properties();
		p.setProperty("속성키1", "속성값1");
		p.setProperty("속성키2", "속성값2");
		p.setProperty("속성키3", "속성값3");

		System.out.println(p);
		System.out.println(p.getProperty("속성키1"));
		
		try {
			p.store(new FileWriter("prop"), "My Properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties p2 = new Properties();
		
		try {
			p2.load(new FileReader("prop"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p2);
	}
}
