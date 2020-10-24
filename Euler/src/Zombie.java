public class Zombie {

	public static int humanDays(int[][] matrix) {
		int replacedTimes = 0;

		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean replaced = true;
		boolean affected = false;
		boolean nozombie = true;

		while (replaced) {
			replaced = false;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (matrix[i][j] == 0) {
						if ((i > 0 && matrix[i - 1][j] == 1) || (i < rows - 1 && matrix[i + 1][j] == 1)
								|| (j > 0 && matrix[i][j - 1] == 1) || (j < columns - 1 && matrix[i][j + 1] == 1)) {
							matrix[i][j] = 2;
							replaced = true;
						}
					} else {
						nozombie = false;
					}
				}
			}

			if (replaced) {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < columns; j++) {
						if (matrix[i][j] == 2) {
							matrix[i][j] = 1;
							affected = true;
						}
					}
				}
				replacedTimes++;
			}
		}

		if (!affected && nozombie)
			return -1;
		return replacedTimes;
	}

	public static void main(String[] args) {
		int[][] zombie = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println("No of days = " + humanDays(zombie));

		int[][] zombie1 = { { 1, 0 } };
		System.out.println("No of days = " + humanDays(zombie1));

		int[][] zombie2 = { { 1 }, { 1 }, { 1 }, { 1 } };
		System.out.println("No of days = " + humanDays(zombie2));
	}

}
