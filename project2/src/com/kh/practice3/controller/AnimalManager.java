package com.kh.practice3.controller;

import com.kh.practice3.model.vo.Animal;
import com.kh.practice3.model.vo.Cat;
import com.kh.practice3.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] a = new Animal[5];
		a[0] = new Dog("우유", "포메라니안", 5);
		a[1] = new Cat("냥이", "프렌치", "길", "검은색");
		a[2] = new Cat("미야오", "레오파드", "부잣집", "하얀색");
		a[3] = new Dog("초코", "말티즈", 2);
		a[4] = new Dog("푸두리", "푸들", 3);

		for(Animal a1: a) {
			if(a1 instanceof Cat) {
				a1.speak();
			}else {
				a1.speak();
			}
		}
		
	}

}
