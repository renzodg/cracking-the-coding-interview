package chapter1__arrays_and_strings;

import java.util.Arrays;

public class RotateMatrix {

	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is
	 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	 * place?
	 */

	public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false; // Not a square
		int n = matrix.length;

		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - layer - 1;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
				
				// top = [first][i]
				// [first][i] = [last - offset][first]
				// [last - offset][first] = [last][last - offset]
				// [last][last - offset] = [i][last]
				// [i][last] = top
				
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}

		rotate(matrix);

		System.out.println("---------------------");
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}
}
