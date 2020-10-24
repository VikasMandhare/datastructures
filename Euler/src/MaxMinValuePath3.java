import java.util.*;

public class MaxMinValuePath3 {

	private static int maxPathScore(int[][] matrix) {

		int right = matrix[0].length, down = matrix.length;
		int min1 = 100, min2 = 100, max = 0;

		int result[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < right; i++) {
			for (int j = 0; j < down; j++) {
				System.out.println(matrix[i][j]);
				result[i][j] = matrix[i][j];
				System.out.println(result[i][j]+"-----------------");
				if (i > 0 && j > 0) {
					result[i][j] += Math.min(result[i - 1][j], result[i][j - 1]);
				} else if (i > 0) {
					result[i][j] += result[i - 1][j];
				} else if (j > 0) {
					result[i][j] += result[i][j - 1];
				}
			}
		}

		return result[result.length - 1][result[0].length-1];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 7, 5, 3 }, { 2, 0, 9 }, { 4, 5, 9 } };
		System.out.println(maxPathScore(matrix));

		/*
		 * int[][]matrix1={{0, 1},{0, 2},{1, 3},{2, 3},{2, 5},{5, 6},{3, 4}};
		 * System.out.println("rows="+matrix1.length+" rows="+matrix1[0].length);
		 * System.out.println(maxPathScore(matrix1));
		 */
	}

}
