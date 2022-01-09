package _dsa._java._3Graph;

import java.util.*;

public class _10_Dijkstra_BFS {

	static int count = 0;

	public static void main(String[] args) {

		// int edges[][] = {{0,1},{3,4},{1, 3},{2,3},{2,4}};
		int edges[][] = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 2 }, { 3, 4 }, { 3, 0 }, { 2, 4 }, };

		List<List<Integer>> adj = new ArrayList<>();

		int v = 5;

		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);

			// undirected
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		boolean visited[] = new boolean[v];

		// for(int i=0; i<v;i++) {
		// if(visited[i]==false)
		// bfs(adj, visited, i, dest);
		// }
		int source = 0;
		int dest = 3;

		count = 0;
		List<Integer> res = bfs(adj, visited, source, dest);

		System.out.println(res);
		System.out.println(count);
	}

	public static List<Integer> bfs(List<List<Integer>> adj, boolean visited[], int source, int destination) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();

		q.add(source);

		visited[source] = true;
		// res.add(source);

		while (!q.isEmpty()) {
			// System.out.print(q.peek() + "->");

			res.add(q.peek());

			List<Integer> curr = adj.get(q.poll());

			count++;

			for (int i = 0; i < curr.size(); i++) {
				int child = curr.get(i);
				if (!visited[child]) {
					q.add(child);
					// res.add(child);
					visited[child] = true;
				}
				if (child == destination) {
					res.add(child);
					return res;
				}
			}
		}

		return res;
	}
}
