package google.practice;

import java.io.IOException;

/*
 * https://www.geeksforgeeks.org/maximize-total-set-bits-of-elements-in-n-sized-array-with-sum-m/
 * 
 * Problem Statement : Maximize total set bits of elements in N sized Array with sum M
 * 
 * Input: N = 1, M = 15
 * Output: 4
 * Explanation: Since N =1, 15 is the only possible solution. 
 * The binary representation of 15 is (1111)2 which has 4 set bits.
 * 
 * Input: N = 2, M = 11
 * Output: 4
 * Explanation: There can be various options for the vector of size 2 and sum 11.
For example: [1, 10] this will give the set bits as 1 + 2 = 3 
as their binary representations are 1 and 1010 respectively.
Similarly [2, 9] and [3, 8] will also give 3 set bits 
as their binary representations are [10, 1001] and [11, 1000] respectively.
For [4, 7] the set bits will be maximum as 
4 is represented by 100 and 7 is represented by 111.
So the total count of set bits = 1 + 3 =4.
Similarly [5, 6] is also a possible solution which gives sum of set bits 4.
For any other options the sum of set bits is always less than 4. 
Hence the maximum number of set bits achieved is 4.
 */
public class MaxSetBits {

	public static void main(String[] args) throws IOException {
		int size, N = 1;
		int sum, M = 15;
		int actualOutput = findMaxSetBits(N, M);
		System.out.println("\tTested "+(actualOutput==4)+"; Output is "+actualOutput);
		actualOutput = findMaxSetBits(2, 11);
		System.out.println("\tTested "+(actualOutput==4)+"; Output is "+actualOutput);
	}

	private static int findMaxSetBits(int sizeOfArray, int M) {
		System.out.println("Size - "+sizeOfArray+" ; Sum - "+M);
		int resultSetBits=0;
		if (sizeOfArray == 1) {
			resultSetBits = countSetBits(M);
			return resultSetBits;
		}
		int arr[] = new int[sizeOfArray];
//		if (sizeOfArray == 2) {
//			arr[0] = 1;
//			arr[1] = M - arr[0];
//		}
//		if (sizeOfArray == 3) {
//			arr[0] = 1;
//			arr[1] = 2;
//			arr[2] = M - arr[0] - arr[1];
//		}

		int totalSetBits = 0;
		for (int st = 1; st < M/2; st++) {
			totalSetBits = 0;
			for (int j = 0; j < sizeOfArray; j++) {
				if (j == sizeOfArray - 1) {
					arr[j] = M - st;
				} else {
					arr[j] = st;
				}
				totalSetBits+=countSetBits(arr[j]);
			}
			if(resultSetBits==0) {
				resultSetBits=totalSetBits;
			}
			if(totalSetBits>resultSetBits)
				resultSetBits=totalSetBits;
		}
		return resultSetBits;
	}

	private static int countSetBits(int M) {
		int setbits = 0;
		while (M > 0) {
			if (M % 2 != 0)
				setbits++;
			M = M / 2;
		}
//		System.out.println(setbits);
		return setbits;
	}

}
