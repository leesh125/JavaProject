package com.kh.exam10;

import java.util.Random;
import java.util.Scanner;

class CRPGame {
	private Random rd = new Random();
	public String player;
	public String computer;
	public int score[] = new int[3];
	public String CRP[] = {"가위", "바위", "보"};
	public boolean exitFlag = false;
	
	public void setPlayer(String crp) {
		this.player = crp;
	}
	
	public void setComputer() {
		this.computer = this.CRP[rd.nextInt(3)];
	}
}

public class Sample3 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// GRPGame 클래스로 가위바위보 게임 흐름에 맞는 동작(로직)을 작성
		CRPGame game = new CRPGame();
		
		
		while(true) {
			System.out.println("가위, 바위, 보 중 하나 입력(게임 종료를 원하면 종료 입력");
			String player = sc.nextLine();
			game.setPlayer(player);
			
			if(player.equals("종료"))
				break;
			
			if(player.equals("가위")) {
				if(game.computer.equals("가위")){
					System.out.println("컴퓨터 : " + game.computer + ", 나 : 가위");
					System.out.println("비김");
				}
			}
		}
	}

}
