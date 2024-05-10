package _dsa._java._3Graph;

import java.util.*;

public class _8_Graph_using_HASHMAP {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int x, y;

		// Adjacency List:
		Map<Integer, List<Integer>> adj = new HashMap<>();

		// store Nodes:
		for (int i = 0; i < n; i++) {
			adj.put(i, new ArrayList<>());
		}

		// STORE Edges:
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			adj.get(x).add(y);

			// Undirected
			// adj.getKey(y).add(x);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(i + "->");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}
