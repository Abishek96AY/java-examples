package com.examples.logical;

public class AddMatrices {
	public static void main(String[] args) { // Main method

		// Step 2: Define two 2D arrays matrix1 and matrix2 representing the matrices to be added
		int[][] matrix1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};

		int[][] matrix2 = {
				{9, 8, 7},
				{6, 5, 4},
				{3, 2, 1}
		};

		// Step 3: Verify that the matrices have the same dimensions
		int rows = matrix1.length;
		int columns = matrix1[0].length;

		if (rows != matrix2.length || columns != matrix2[0].length) {
			System.out.println("Matrices of different dimensions cannot be added!");
			return;
		}

		// Step 4: Define a 2D array sumMatrix to store the sum of the matrices
		int[][] sumMatrix = new int[rows][columns];

		// Step 5: Use nested for loops to perform the addition of matrix1 and matrix2
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}

		// Step 6: Print the original matrices and the resultant sumMatrix
		System.out.println("Matrix 1:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Matrix 2:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Sum of Matrices:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(sumMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
