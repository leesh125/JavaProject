package com.kh.exam4;

class Other {
	static int share = 100;
	int noShare = 200;
	
	public Other() {};
}
public class SampleClass {

	public static void main(String[] args) {
		Other oth1 = new Other();
		Other oth2 = new Other();
		
		System.out.println(oth1.noShare + " | " + oth2.noShare);
		System.out.println(oth1.share + " | " + oth2.share);
		
		oth1.noShare = 250;
		Other.share = 150;
		
		System.out.println(oth1.noShare + " | " + oth2.noShare);
		System.out.println(oth1.share + " | " + oth2.share);
	}

}
