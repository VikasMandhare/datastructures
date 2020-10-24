import java.util.*;

public class CriticalConnection {

	public List<List<Integer>> findCriticalConn(int serversNum, int connectionsNum, int[][] connections) {
		List<List<Integer>> list = new ArrayList<>();

		int r = connections.length;
		int c = connections[0].length;
		int d = 1;

		boolean[] visited = new boolean[serversNum];
		int[] distance = new int[serversNum];
		int[] first = new int[serversNum - 1];

		for (int x = 0; x < r-1; x++) {
			if (visited[connections[x][1]] == true) {
				d++;
			}
			visited[connections[x][1]] = true;
			distance[connections[x][0]] = d;
			distance[connections[x][1]] = d;
		}

		for (int i = 0; i < serversNum - 2; i++) {
			if (distance[i] != distance[i + 1]) {
				List<Integer> l = new ArrayList<>();
				System.out.println("[" + i + "," + (i + 1) + "]");
				l.add(i);
				l.add(i + 1);
				list.add(l);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		CriticalConnection ob = new CriticalConnection();
		int[][] conn = { { 1, 2 }, { 1, 3 }, { 3, 2 }, { 3, 4 } };

		ob.findCriticalConn(4, 4, conn);

	}

}
