package com;

public class Pythagoras {

	public static void main(String[] args) {
		int a ;
		int b ;
		int c ;
		int count = 0;
		for (a = 1; a < 100; a++) { // 1,2,3
			for (b = a + 1; b < 100; b++) {
				for (c = b + 1; c < 100; c++) {
					if (c == Math.sqrt(a * a + b * b)) {
						System.out.println(a + " " + b + " " + c);
						count++;
					}
				}
			}
		}
		
		System.out.println("Count "+count);
	}

}
