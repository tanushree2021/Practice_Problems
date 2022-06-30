package com;

/*
 * Sum of Left and Right Diagonal Elements of a Matrix
 * 
 * With time complexity O(n2) and O(n)
 * 
 * [ 1 2 5
 *	 4 5 6
 *	 7 8 9]
 *
 *	Sum L = 15
 *	Sum R = 17
 */
public class SumOfDiagonalElementsInMatrix {

	public static void main(String[] args) {
//		int[][] matrix = { { 1, 2, 5 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix= new int[4][4];
//		matrix[0][0]=1;
//		matrix[0][1]=2;
//		matrix[0][2]=5;
//		matrix[1][0]=4;
//		matrix[1][1]=5;
//		matrix[1][2]=6;
//		matrix[2][0]=7;
//		matrix[2][1]=8;
//		matrix[2][2]=9;

//		displayMatrix(matrix);

		populateMatrix(matrix);
		calcSumOfDiagonalsN_Sq(matrix);
		System.out.println();

		calcSumOfDiagonalsN(matrix);
		System.out.println();
	}

	private static void calcSumOfDiagonalsN(int[][] matrix) {
		long startTime = System.nanoTime();
		calDiagonalsNtimecomplexity(matrix);
		long endTime = System.nanoTime();
		System.out.println("Time Taken - " + (endTime - startTime) / 1000 + " mseconds");
	}

	private static void calcSumOfDiagonalsN_Sq(int[][] matrix) {
		long startTime = System.nanoTime();
		calDiagonalsNN(matrix);
		long endTime = System.nanoTime();
		System.out.println("Time Taken - " + (endTime - startTime) / 1000 + " mseconds");
	}

	private static void calDiagonalsNtimecomplexity(int[][] matrix) {

		System.out.println("Calculating with N time complexity");
		int row = 0;
		int leftSum = 0;
		int rightSum = 0;
		for (int column = 0; column < matrix.length; column++) {
			if (row == column) {
				leftSum += matrix[row][column];
			}
			if (row == column && column == matrix.length - 1) {
				break;
			}
			if ((row + column) == matrix.length - 1) {
				rightSum += matrix[row][column];
			}
			if (column == matrix.length - 1) {
				row++;
				column = -1;
			}
		}
		System.out.println("right sum " + rightSum);
		System.out.println("left sum " + leftSum);
	}

	private static void calDiagonalsNN(int[][] matrix) {
		int leftSum = 0;
		int rightSum = 0;
		System.out.println("Calculating with N sq time complexity");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					leftSum += matrix[i][j];
				}
				if (i + j == (matrix[i].length - 1)) {
					rightSum += matrix[i][j];
				}
			}
		}

		System.out.println("right sum " + rightSum);
		System.out.println("left sum " + leftSum);
	}

	private static void displayMatrix(int[][] matrix) {
		int temp = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
				if (temp % 3 == 0) {
					System.out.println();
				}
				temp++;
			}
		}
	}

	private static void populateMatrix(int[][] matrix) {
		int temp = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
				System.out.print(matrix[i][j] + " ");
				if (temp % matrix.length == 0) {
					System.out.println();
				}
				temp++;
			}
		}
	}

}
