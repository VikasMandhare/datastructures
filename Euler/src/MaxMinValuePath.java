import java.util.*;

public class MaxMinValuePath {

	private static int maxPathScore(int[][] matrix) {
		return findMaxMin(matrix, 0, 0);
	}

	private static int findMaxMin(int[][] matrix, int right, int down) {
		System.out.println("Processing : "+matrix[right][down]);
		if (matrix.length == 0) {
			return 0;
		}
		int min1 = matrix[right][down];
		if (right < matrix.length-1) {
			System.out.println("going down------");
			min1 = Math.min(matrix[right][down], findMaxMin(matrix, right + 1, down));
		}
		int min2 = matrix[right][down];
		if (down < matrix[0].length-1) {
			System.out.println("going right>>>>>");
			min2 = Math.min(matrix[right][down], findMaxMin(matrix, right, down + 1));
		}

		System.out.println("=======================backtracking min1="+min1+" min2="+min2);
		return Math.max(min1, min2);
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
