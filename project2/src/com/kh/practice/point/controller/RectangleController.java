package com.kh.practice.point.controller;

import java.util.Scanner;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	static Scanner sc = new Scanner(System.in);
	
	
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);  r.setY(y);  r.setHeight(height);  r.setWidth(width);
		return "면적 : " + r.toString() + " / " +
				(r.getHeight() * r.getWidth());
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);  r.setY(y);  r.setHeight(height);  r.setWidth(width);
		return "둘레 : " + r.toString() + " / " +
				2 * (r.getHeight() + r.getWidth());
	}
	
	public String calcSplit(int x, int y, int height, int width, int split) {
		r.setX(x);  r.setY(y);  r.setHeight(height);  r.setWidth(width);
		String ret = "";
		Rectangle[] rArr = new Rectangle[split];
		
		if(split < 0) {
			return "split은 양수로 입력하셔야 합니다.";
		}else{
			System.out.print("가로로만 나누려면 1, 세로로만 나누려면 2,"
					+ "가로 와 세로 둘 다 나누려면 3 : ");
			int num = sc.nextInt();  sc.nextLine();
			if(num==1) {
				int splitHeight = r.getHeight() / split;
				
				for(int i=0; i<rArr.length; i++) {
					rArr[i] = new Rectangle(x, y, width, height);
				}
				for (Rectangle r: rArr) {
					r.setHeight(splitHeight);
					ret += r.toString() + " / ";
				}
				return ret;
			}else if(num==2) {
				int splitWidth = r.getWidth() / split;
				
				for(int i=0; i<rArr.length; i++) {
					rArr[i] = new Rectangle(x, y, width, height);
				}
				for (Rectangle r: rArr) {
					r.setHeight(splitWidth);
					ret += r.toString() + " / ";
				}
				return ret;
			}else if(num==3) {
				int sqr=0;
				int i=1;
				while(true) {
					sqr = i*i;
					if(sqr == split) {
						int splitWidth = r.getWidth() / split;
						int splitHeight = r.getHeight() / split;

						for(int j=0; j<rArr.length; j++) {
							rArr[j] = new Rectangle(x, y, width, height);
						}
						
						for (Rectangle r: rArr) {
							r.setWidth(splitWidth);
							r.setHeight(splitHeight);
							ret += r.toString() + " / ";
						}
						return ret;
						
						
					}else if(sqr > split) {
						return "해당 split으로는 사각형을 나눌 수 없습니다.";
					}
					i++;
				}
				
			}
		}
		return ret;
		
	}
}
