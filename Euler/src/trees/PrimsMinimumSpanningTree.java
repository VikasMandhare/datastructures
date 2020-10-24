package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMinimumSpanningTree {

	Integer mstCost = 0;

	public static class Edge {
		Integer cost;
		Integer from;
		Integer to;

		Edge(Integer cost, Integer from, Integer to) {
			this.cost = cost;
			this.from = from;
			this.to = to;
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

	private Integer primsMST(List<List<Edge>> graph, PriorityQueue<Edge> pq, boolean visited[], List<Edge> mst, int m) {

		System.out.println("=======================================");
		for (Edge e : pq) {
			System.out.print("[" + e.from + "," + e.to + "]");
		}
		System.out.println("\n--------------------------------------");
		if (pq.isEmpty() || m <= 0)
			return mstCost;

		Edge e = pq.poll();
		visited[e.from] = true;

		mstCost = mstCost + e.cost;
		System.out.println("mstCost=" + mstCost);
		mst.add(e);

		if (visited[e.to] != true) {
			addEdges(graph, pq, visited, e.to);
			primsMST(graph, pq, visited, mst, m--);
		}

		return mstCost;
	}

	private void addEdges(List<List<Edge>> graph, PriorityQueue<Edge> pq, boolean visited[], int graphIndex) {
		for (Edge e : graph.get(graphIndex)) {
			if (!visited[e.from]) {
				pq.add(e);
			}
		}
	}

	public static void main(String[] args) {
		PrimsMinimumSpanningTree ob = new PrimsMinimumSpanningTree();
		List<List<Edge>> graph = new ArrayList<>();
		ob.buildgraph(graph);

		int n = graph.size();
		int m = n - 1;

		PriorityQueue<Edge> pq = new PriorityQueue<>(2 * n, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.cost - e2.cost;
			}
		});

		boolean visited[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			visited[i] = false;
		}

		List<Edge> mst = new ArrayList<>();

		int start = 0;
		ob.addEdges(graph, pq, visited, start);
		ob.mstCost = ob.primsMST(graph, pq, visited, mst, m);

		System.out.println("Minimum cost:" + ob.mstCost);

		System.out.println("Minimum Spanning Tree:");
		for (Edge e : mst) {
			System.out.print("[" + e.from + "," + e.to + "]");
		}

	}

}
