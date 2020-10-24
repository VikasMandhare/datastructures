package trees;

import java.util.List;
import java.util.ArrayList;

public class BreadthFirstSearchObstacles {

	static int steps = 0;

	static List<Integer> keys = new ArrayList<>();

	private static void bfs(int[][] arena, int x, int y) {
		if (x < 0 || y < 0 || x >= arena.length || y >= arena[0].length || arena[x][y] == 0) {
			return;
		}

		if (arena[x][y] == 2) {
			System.out.println("key added +++++++++++");
			keys.add(arena[x][y]);
		}
		if (arena[x][y] == 3) {
			// skip
			if (keys.contains(2)) {
				System.out.println("Lock opened");

			} else {
				System.out.println("key not found --------------");
				return;
			}

		}

		arena[x][y] = 0;

		if (x - 1 >= 0 && arena[x - 1][y] != 9) {
			steps++;
			bfs(arena, x - 1, y);
		}

		if (x + 1 < arena.length && arena[x + 1][y] != 9) {
			steps++;
			bfs(arena, x + 1, y);
		}

		if (y - 1 >= 0 && arena[x][y - 1] != 9) {
			steps++;
			bfs(arena, x, y - 1);
		}

		if (y + 1 < arena[0].length && arena[x][y + 1] != 9) {
			steps++;
			bfs(arena, x, y + 1);
		}
	}

	private static int countClusters(int[][] arena) {
		int row = arena.length;
		int column = arena[0].length;

		int count = 0;

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				if (arena[x][y] == 1) {
					System.out.println("for loop step");
					steps++;
					count++;
					bfs(arena, x, y);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] arena = { { 1, 1, 2, 1, 1 }, { 9, 9, 9, 3, 9 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		System.out.println("Count of clusters : " + countClusters(arena));
		System.out.println("Total steps taken : " + steps);
		System.out.println("============================================");

		int[][] arena1 = { { 1, 1, 1, 1, 1 }, { 9, 9, 9, 3, 9 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		keys.clear();
		steps = 0;
		System.out.println("Count of clusters : " + countClusters(arena1));
		System.out.println("Total steps taken : " + steps);
		System.out.println("============================================");

	}

}
