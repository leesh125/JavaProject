package com.kh.example.menu.model.vo;


public class Breakfast extends Meal{
	private int n;
	private int getChoice1, getChoice2;
	private Food[][] fArr = new Food[3][];

	public int getGetChoice1() {
		return getChoice1;
	}

	public void setGetChoice1(int getChoice1) {
		this.getChoice1 = getChoice1;
	}

	public int getGetChoice2() {
		return getChoice2;
	}

	public void setGetChoice2(int getChoice2) {
		this.getChoice2 = getChoice2;
	}
	
	//{{("육개장",8000),("순대국", 7000)}, {("만두",7000)},{("짜장면",6000)}}
	public Breakfast() {
		
	}
	
	public Breakfast(Food[][] fArr) {
		this.fArr = fArr;
	}

	
	public Food[][] getfArr() {
		return fArr;
	}

	public void setfArr(Food[][] fArr) {
		this.fArr = fArr;
	}

	public Food[][] listFood() {
		this.n = 3;
		this.fArr = new Food[3][this.n];
		fArr[0][0] = new Food("육개장", 8000);
		fArr[0][1] = new Food("순대국", 7000);
		fArr[0][2] = new Food("백반", 7500);

		fArr[1][0] = new Food("만두", 5000);
		fArr[1][1] = new Food("볶음밥", 7000);
		fArr[1][2] = new Food("유타오", 5500);
		
		fArr[2][0] = new Food("샐러드", 8500);
		fArr[2][1] = new Food("토스트", 5000);
		fArr[2][2] = new Food("샌드위치", 5500);
		
		return fArr;
	}
	
	public void addFood(int x, String addFood, int price) {
//		Food[x-1]
		
		Food addFoodObj = new Food(addFood, price);
		Food copyFoodList[] = new Food[this.fArr[x-1].length + 1];
		
		System.arraycopy(fArr[x-1], 0, copyFoodList, 0, fArr[x-1].length);			

		copyFoodList[copyFoodList.length - 1] = addFoodObj;
		
		
		this.fArr[x-1] = copyFoodList; 
		
	}
	
	public void randomBreakfast() {
		System.out.println("6시 ~ 12시는 아침 시간");
		int random = this.getRd().nextInt(fArr.length);
		int random2 = this.getRd().nextInt(fArr[random].length);
		System.out.println("아침 추천 메뉴는 " + 
							fArr[random][random2].getName() + " (" +
							fArr[random][random2].getPrice() + ")" +
							" 입니다.\n");		
		getChoice1 = random;  getChoice2 = random2;
	
	}

	@Override
	public String toString() {
		return  "아침 메뉴로 " + 
				fArr[this.getChoice1()][this.getChoice2()].getName() + " ("+
				fArr[this.getChoice1()][this.getChoice2()].getPrice() +  
				"원) 이(가) 선택 되었습니다!";
	}
	

}
