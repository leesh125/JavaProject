package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Triangle;

public class TriangleController {
	private Triangle t = new Triangle();
	
	public String calcArea(int x, int y, int n1, int n2, int n3) {
		t.setX(x);  t.setY(y);  t.setN1(n1);  t.setN2(n2);  t.setN3(n3);
		if(n1 + n2 <= n3 | n1 + n3 <= n2 | n2 + n3 <= n1) {
			return null;
		}else {
			double s = (t.getN1() + t.getN2() + t.getN3()) / 2.0;
			return "면적 : " + t.toString() + " / " + 
					Math.sqrt(s*(s-(double)t.getN1())*(s-(double)t.getN2())*(s-(double)t.getN3()));
		}
	}
	
	public String calcPerimeter(int x, int y, int n1, int n2, int n3) {
		t.setX(x);  t.setY(y);  t.setN1(n1);  t.setN2(n2);  t.setN3(n3);
		if(n1 + n2 <= n3 | n1 + n3 <= n2 | n2 + n3 <= n1) {
			return null;
		}else {
			return "둘레 : " + t.toString() + " / " +
					(t.getN1() + t.getN2() + t.getN3());
		}
	}
}
