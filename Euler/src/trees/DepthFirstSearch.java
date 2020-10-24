package trees;

public class DepthFirstSearch {

	static int steps = 0;

	private static void dfs(int[][] arena, int x, int y, boolean[][] visited) {
		//System.out.println("steps :" + steps);
		if (x < 0 || y < 0 || x >= arena.length || y >= arena[0].length || arena[x][y] == 0 || visited[x][y] == true) {
			return;
		}

		visited[x][y] = true;

		steps++;
		dfs(arena, x - 1, y, visited);
		steps++;
		dfs(arena, x + 1, y, visited);
		steps++;
		dfs(arena, x, y - 1, visited);
		steps++;
		dfs(arena, x, y + 1, visited);
		System.out.println("replacing :" + x + "," + y);
		arena[x][y] = 0;
	}

	private static int countClusters(int[][] arena) {
		int row = arena.length;
		int column = arena[0].length;

		boolean visited[][] = new boolean[row][column];

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				visited[x][y] = false;
			}
		}
		int count = 0;

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				if (arena[x][y] == 1) {
					System.out.println("for loop step");
					steps++;
					count++;
					dfs(arena, x, y, visited);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] arena = { { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		System.out.println("Count of clusters : " + countClusters(arena));
		System.out.println("Total steps taken : " + steps);
		System.out.println("============================================");

		int[][] arena1 = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
		steps = 0;
		System.out.println("Count of clusters : " + countClusters(arena1));
		System.out.println("Total steps taken : " + steps);
		System.out.println("============================================");

		int[][] arena2 = { { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		steps = 0;
		System.out.println("Count of clusters : " + countClusters(arena2));
		System.out.println("Total steps taken : " + steps);

	}

}
