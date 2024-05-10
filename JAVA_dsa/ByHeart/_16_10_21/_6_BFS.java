package _dsa.ByHeart._16_10_21;

import java.util.*;

public class _6_BFS {

	static boolean VISITED[];

	static List<List<Integer>> VERTICES = new ArrayList<>();
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		VISITED = new boolean[n];

		// adding linked List to each vertices
		for (int i = 0; i < n; i++) {
			VERTICES.add(new ArrayList<>());
		}

		// Store Edges
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// uni-direction
			VERTICES.get(x).add(y);
		}

		// works only for COMPLETE GRAPH
		// bfs(0);

		// works on LOSSE GRAPH
		for (int i = 0; i < n; i++) {
			if (VISITED[i] == false) {
				System.out.println("\nTRIP");
				bfs(i);
			}
		}

		sc.close();

	}

	public static void bfs(int source) {

		Queue<Integer> q = new LinkedList<>();

		q.add(source);
		VISITED[source] = true;

		while (!q.isEmpty()) {
			int parent_value = q.peek();
			q.poll();
			List<Integer> parent = VERTICES.get(parent_value);

			for (int child: parent) {

				if (VISITED[child] == false) {
					q.add(child);
					VISITED[child] = true;
				}

				System.out.print("(" + parent_value + " -> " + child + ")" + "->");
			}
		}

	}

}

// Inputs:
// 5 4
// 0 1
// 1 3
// 3 2
// 4 0
