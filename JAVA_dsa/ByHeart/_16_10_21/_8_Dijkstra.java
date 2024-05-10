package _dsa.ByHeart._16_10_21;

import java.util.*;

public class _8_Dijkstra {
	static List<List<Integer>> vertices = new ArrayList<>();
	static int n, m;
	static boolean visited[];
	static int DESTINATION;

	public static void main(String[] args) {
		int edges[][] = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 2 }, { 3, 4 }, { 3, 0 }, { 2, 4 }, };

		n = 5;
		m = edges.length;

		DESTINATION = 2;

		visited = new boolean[n];

		for (int i = 0; i < n; i++)
			vertices.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			vertices.get(x).add(y);
			vertices.get(y).add(x);
		}

		int source = 0;

		List<Integer> distance = dijkstra(source);

		System.out.println("Path: " + distance);

	}

	public static List<Integer> dijkstra(int source) {

		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();

		q.add(source);

		visited[source] = true;

		int count = 0;
		while (!q.isEmpty()) {

			int parent_value = q.peek();

			result.add(parent_value);

			q.poll();

			count++;

			List<Integer> parent = vertices.get(parent_value);

			for (int child : parent) {
				if (visited[child] == false) {
					q.add(child);
					visited[child] = true;
				}
				if (child == DESTINATION) {
					result.add(child);
					System.out.println("Shortest Distance: " + count);
					return result;
				}
			}
		}

		return result;
	}

}
