package google.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.geeksforgeeks.org/check-if-given-number-has-7-divisors/
 * 
 * Check if given number has 7 divisors
 * 
 * Input: 64
Output: 1 
Explanation: 1, 2, 4, 8, 16, 32, 64 -> 7 divisors so output is 1

Input: 100
Output: 0
Explanation: 1, 2, 4, 5, 10, 20, 25, 50, 100 -> 8 divisors so output is 0

Input: 729
Output: 1
Explanation: 1, 2, 4, 8, 16, 32, 64 -> 7 divisors so output is 1
 */
public class SevenDivisors {

	public static void main(String[] args) throws IOException {
		boolean isLoopRunning = true;
		int input; // 64, 100, 729
		while (isLoopRunning) {
			BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Integer : ");
			String str = bfn.readLine();
			if (str.equals("stop")) {
				isLoopRunning = false;
				System.out.println("\nLoop Stopped..");
			} else {
				try {
					input = Integer.parseInt(str);
					checkDivisors(input);
				} catch (Exception e) {
					System.out.println("\nNot an integer.. Try Again.. To stop, type \"stop\"\n");
				}
			}
		}
//		checkDivisors(100);
//		checkDivisors(729);
	}

	private static void checkDivisors(int input) {

		detect7divisors(input);
//		int count=0;
//		for(int i=1; i<=input; i++) {
//			if(input%i==0) {
//				count++;
//			}
//		}
//		if(count==7) {
//			System.out.println("Yes. Input "+input+" has "+count+" divisors");
//		} else {
//			System.out.println("No. Input "+input+" has "+count+" divisors");
//		}
	}

	private static void detect7divisors(int input) {
		double prime = Math.pow(input, (1 / 6.));
//		System.out.println("prime or not "+prime);
		int temp = 0;
//		for(int j = 2; j<prime;j++) {
//			if(prime!=j && prime%j==0) {
//				temp++;
//			}
//		}
		double res = Math.pow(prime, 6);
//		System.out.println("Res "+res);
		if (res != input)
			temp++;
		if (temp == 0) {
			System.out.println(input + " has 7 divisors");
		} else {
			System.out.println(input + " does not have 7 divisors");
		}
	}

}
