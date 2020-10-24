import java.util.Arrays;

public class MinCostToConnect {
	static int mainGate[] = new int[4];

	private static int find(int city) {
		//gate is open
		if (mainGate[city] == city) {
			return city;
		} else {
			//find gate recursively
			mainGate[city] = find(mainGate[city]);
			return mainGate[city];
		}
	}

	private static void union(int city1, int city2) {
		int mGX = find(city1);
		int mGY = find(city2);

		if (mGX != mGY) {
			mainGate[mGX] = mGY;
		}
	}

	public static int minCostConnectNodes(int n, int[][] connects) {
		int minCost = 0;
		int numberOfMainGates = n;

		Arrays.sort(connects, (c1, c2) -> {
			return c1[2] - c2[2];
		});

		for (int i = 0; i < mainGate.length; i++) {
			mainGate[i] = i;
		}

		for (int[] conn : connects) {
			int city1 = conn[0];
			int city2 = conn[1];

			if (find(city1) != find(city2)) {
				System.out.println("making union entry " + city1 + " " + city2);
				minCost += conn[2];
				union(city1, city2);
				numberOfMainGates--;
			} else {
				System.out.println("cycle skipped");
			}
		}

		if (numberOfMainGates == 1) {
			return minCost;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		int[][] connections = { { 1, 2, 5 }, { 1, 3, 12 }, { 2, 3, 1 } };

		System.out.println(minCostConnectNodes(3, connections));

	}

}
