package com.kh.test;

import java.util.ArrayList;

import com.kh.test.model.vo.Fruit;

public class MyCollection {

	public static void main(String[] args) {
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));		
		list.add(new Fruit("포도", "보라"));
//		list.add("맛있는 과일");
		Fruit f = new Fruit("복숭아","분홍");
		list.add(f);
		for(int i=0; i<=list.size(); i++) {
			System.out.println(list.get(i).getColor());
		}


	}

}
