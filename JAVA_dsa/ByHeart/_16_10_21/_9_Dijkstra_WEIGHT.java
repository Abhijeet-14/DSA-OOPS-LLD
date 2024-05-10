package _dsa.ByHeart._16_10_21;

import java.util.*;

public class _9_Dijkstra_WEIGHT {

	static List<List<Pair>> vertices = new ArrayList<>();
	static int n, m;
	static boolean visited[];
	static int weight[];
	static int DESTINATION;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		m = sc.nextInt();

		DESTINATION = 2;

		weight = new int[n];

		visited = new boolean[n];

		for (int i = 0; i < n; i++)
			vertices.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int wt = sc.nextInt();

			vertices.get(x).add(new Pair(y, wt));
			vertices.get(y).add(new Pair(y, wt));
		}

		int source = 0;

		Arrays.fill(weight, Integer.MAX_VALUE);

		weight[source] = 0;

		dijkstra_W(source);

		for (int i = 0; i < n; i++) {
			System.out.println(i + " -> " + weight[i]);
		}

		sc.close();
	}

	public static void dijkstra_W(int source) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(n, (a, b) -> a.weight - b.weight);

		// List<Integer> result = new ArrayList<>();

		pq.add(new Pair(source, 0));

		while (!pq.isEmpty()) {
			Pair parent_pair = pq.poll();

			List<Pair> parent = vertices.get(parent_pair.to);

			for (Pair child : parent) {
				if (weight[child.to] > child.weight + weight[parent_pair.to]) {
					pq.remove(child);
					weight[child.to] = weight[parent_pair.to] + child.weight;

					pq.add(new Pair(child.to, weight[child.to]));
				}
			}

		}

		// return result;
	}

	static class Pair {
		int to;
		int weight;

		public Pair(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

	}
}
