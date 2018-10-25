package chapter1__arrays_and_strings;

import java.util.Arrays;

public class ZeroMatrix {

	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
	 * row and column are set to 0.
	 */
	
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}

		// Nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 4 }, { 3, 1, 5 } };

		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}

		setZeros(matrix);
		System.out.println("---------------");
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}

}
