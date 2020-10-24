package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PackageDependencies {

	private List<Integer> topologyOrder(List<List<Integer>> packageDependencies) {
		List<Integer> result = new ArrayList<>();
		List graph[] = new ArrayList[packageDependencies.size()];
		Integer visited[] = new Integer[packageDependencies.size()];
		Set<Integer> visiting = new HashSet<>();

		for (int i = 0; i < graph.length; i++)
			visited[i] = 0;

		buildGraph(packageDependencies, graph);

		for (int i = 0; i < graph.length; i++)
			dfs(graph, visited, result, i, visiting);

		return result;

	}

	private void dfs(List graph[], Integer visited[], List<Integer> result, Integer current, Set<Integer> visiting) {
		if (visited[current] == 1) {
			return;
		}

		visiting.add(current);
		for (int neighbour = 0; neighbour < graph[current].size(); neighbour++) {
			if (visiting.contains((int) graph[current].get(neighbour))) {
				System.out.println("Cycle detected...aborting...");
				throw new RuntimeException();
			}
			if (visited[(int) graph[current].get(neighbour)] != 1) {
				dfs(graph, visited, result, (int) graph[current].get(neighbour), visiting);
			}
		}
		visited[current] = 1;
		visiting.remove(current);
		result.add(current);
	}

	private void buildGraph(List<List<Integer>> packageDependencies, List graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int k = 0; k < packageDependencies.size(); k++) {
			for (int j = 1; j < packageDependencies.get(k).size(); j++) {
				graph[k].add(packageDependencies.get(k).get(j));
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> packageDependencies = new ArrayList<>();
		Integer[] e1 = { 0, 5 };
		List<Integer> entry1 = Arrays.asList(e1);
		packageDependencies.add(entry1);
		Integer[] e2 = { 1, 0, 5 };
		List<Integer> entry2 = Arrays.asList(e2);
		packageDependencies.add(entry2);
		Integer[] e3 = { 2, 0 };
		List<Integer> entry3 = Arrays.asList(e3);
		packageDependencies.add(entry3);
		Integer[] e4 = { 3, 1, 2, 5 };
		List<Integer> entry4 = Arrays.asList(e4);
		packageDependencies.add(entry4);
		Integer[] e5 = { 4, 3 };
		List<Integer> entry5 = Arrays.asList(e5);
		packageDependencies.add(entry5);
		// Enable following to test cycle
		// Integer[] e6 = { 5, 3 };
		Integer[] e6 = { 5 };
		List<Integer> entry6 = Arrays.asList(e6);
		packageDependencies.add(entry6);

		PackageDependencies ob = new PackageDependencies();
		System.out.println(ob.topologyOrder(packageDependencies).toString());

	}

}
