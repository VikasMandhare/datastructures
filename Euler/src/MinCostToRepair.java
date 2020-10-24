import java.util.Arrays;

public class MinCostToRepair {

	private int find(int[] mainGate, int city) {
		// gate is open
		if (mainGate[city] == city) {
			return city;
		} else {
			// find gate recursively
			mainGate[city] = find(mainGate, mainGate[city]);
			return mainGate[city];
		}
	}

	private void union(int[] mainGate, int city1, int city2) {
		int mGX = find(mainGate, city1);
		int mGY = find(mainGate, city2);

		if (mGX != mGY) {
			mainGate[mGX] = mGY;
		}
	}

	public int minCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair) {
		int minCost = 0;
		int mainGate[] = new int[n + 1];
		int numberOfMainGates = n;
		// sort by repair cost
		Arrays.sort(edgesToRepair, (c1, c2) -> {
			return c1[2] - c2[2];
		});

		// Initialize mainGate
		for (int i = 0; i < mainGate.length; i++) {
			mainGate[i] = i;
		}

		// build mainGate
		outer: for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edgesToRepair.length; j++) {
				if (edges[i][0] == edgesToRepair[j][0] && edges[i][1] == edgesToRepair[j][1]) {
					continue outer;
				}
			}
			int city1 = edges[i][0];
			int city2 = edges[i][1];

			if (find(mainGate, city1) != find(mainGate, city2)) {
				System.out.println("updating union " + city1 + " " + city2);
				union(mainGate, city1, city2);
				numberOfMainGates--;
			} else {
				System.out.println("cycle skipped");
			}

		}

		for (int[] rep : edgesToRepair) {
			int city1 = rep[0];
			int city2 = rep[1];

			if (find(mainGate, city1) != find(mainGate, city2)) {
				System.out.println("making union entry " + city1 + " " + city2);
				minCost += rep[2];
				union(mainGate, city1, city2);
				numberOfMainGates--;
			}

			boolean completeFlag = true;
			for (int k = 1; k < n; k++) {
				if (mainGate[k] != 1) {
					completeFlag = false;
					break;
				}
			}

			if (completeFlag) {
				numberOfMainGates = 1;
				break;
			}

		}

		if (numberOfMainGates == 1) {
			return minCost;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {

		MinCostToRepair ob = new MinCostToRepair();
		int[][] edgesToRepair = { { 1, 5, 110 }, { 2, 4, 84 }, { 3, 4, 79 } };
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 1, 5 }, { 2, 4 }, { 3, 4 } };

		System.out.println("\nMinimum Repair cost = " + ob.minCostToRepairEdges(6, edges, edgesToRepair));

		int[][] edgesToRepair1 = { { 3, 8, 1 }, { 4, 7, 9 } };
		int[][] edges1 = { { 1, 2 }, { 2, 3 }, { 4, 3 }, { 4, 5 }, { 5, 7 }, { 6, 7 }, { 7, 8 } };

		// System.out.println("\nMinimum Repair cost = " + ob.minCostToRepairEdges(8,
		// edges1, edgesToRepair1));

	}

}
