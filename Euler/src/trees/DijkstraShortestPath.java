package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraShortestPath {

	public static class Edge {
		Integer cost;
		int from, to;

		Edge(Integer cost, int from, int to) {
			this.cost = cost;
			this.from = from;
			this.to = to;
		}
	}

	public static class Node {
		int id;
		Integer value;

		public Node(int id, Integer value) {
			this.id = id;
			this.value = value;
		}
	}

	private void buildgraph(List<List<Edge>> graph) {

		graph.add(Arrays.asList(new Edge(5, 0, 1)));

		graph.add(Arrays.asList(new Edge(5, 1, 2), new Edge(6, 1, 3), new Edge(25, 1, 8)));

		graph.add(Arrays.asList(new Edge(10, 2, 6), new Edge(2, 2, 5)));

		graph.add(Arrays.asList(new Edge(2, 3, 4)));

		graph.add(Arrays.asList(new Edge(1, 4, 8), new Edge(10, 4, 9)));

		graph.add(Arrays.asList(new Edge(4, 5, 6), new Edge(7, 5, 8)));

		graph.add(Arrays.asList(new Edge(3, 6, 7)));

		graph.add(Arrays.asList(new Edge(8, 7, 10)));

		graph.add(Arrays.asList(new Edge(1, 8, 4), new Edge(3, 8, 9), new Edge(2, 8, 10)));

		graph.add(Arrays.asList(new Edge(5, 9, 2), new Edge(6, 9, 3)));

		graph.add(Arrays.asList(new Edge(8, 10, 7), new Edge(5, 10, 9)));
	}

	private void runDijkstraAlgo(List<List<Edge>> graph, Queue<Node> queue, boolean visited[], Integer distance[],
			Integer prev[]) {
		System.out.println("=======================================");
		for (Node e : queue) {
			System.out.print("[" + e.id + "," + e.value + "]");
		}
		System.out.println("\n--------------------------");
		if (queue.isEmpty())
			return;

		Node node = queue.poll();
		System.out.println("Processing : " + node.id);
		int fromIndex = node.id;

		visited[fromIndex] = true;

		if (distance[node.id] < node.value) {
			System.out.println("Skipped as part of optimization: " + node.id + "," + node.value);
			return;
		}
		for (Edge neighbourEdge : graph.get(fromIndex)) {
			if (visited[neighbourEdge.to] == true)
				continue;

			Integer newDistance = distance[fromIndex] + neighbourEdge.cost;
			System.out.println("to:" + neighbourEdge.to + " new distance : " + newDistance);

			if (distance[neighbourEdge.to] > newDistance) {
				prev[neighbourEdge.to] = neighbourEdge.from;
				distance[neighbourEdge.to] = newDistance;
				queue.offer(new Node(neighbourEdge.to, distance[neighbourEdge.to]));
			}
		}
		runDijkstraAlgo(graph, queue, visited, distance, prev);

	}

	private List<Integer> getShortestPath(Integer distance[], Integer prev[], int start, int end) {
		List<Integer> path = new ArrayList<>();
		if (distance[end] == Integer.MAX_VALUE)
			return path;

		for (Integer i = end; i != null; i = prev[i])
			path.add(i);

		return path;
	}

	public static void main(String[] args) {
		DijkstraShortestPath ob = new DijkstraShortestPath();

		int n = 11;
		List<List<Edge>> graph = new ArrayList<>();
		ob.buildgraph(graph);

		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}

		Integer prev[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			prev[i] = null;
		}

		Integer distance[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> queue = new PriorityQueue<>(2 * n, new Comparator<Node>() {
			@Override
			public int compare(Node e1, Node e2) {
				return (e1.value - e2.value) > 0 ? +1 : -1;
			}
		});

		int start = 0;
		int end = 8;
		queue.offer(new Node(start, 0));
		distance[start] = 0;

		ob.runDijkstraAlgo(graph, queue, visited, distance, prev);

		System.out.println(ob.getShortestPath(distance, prev, start, end));
	}

}
