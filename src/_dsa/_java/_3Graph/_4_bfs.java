package _dsa._java._3Graph;

import java.util.*;

// Breadth First Search:
public class _4_bfs {

	// Graph:
	// 2->1->0
	// 1->3->0
	// 1->4
	// 4->1

	// Inputs:
	// 5 6
	// 0 1
	// 1 2
	// 1 3
	// 1 4
	// 3 2
	// 4 0
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int x, y;

		// VISITED?
		int visited[] = new int[n];

		// Adjacency List:
		ArrayList<ArrayList<Integer>> V = new ArrayList<>(n);

		// store Nodes:
		for (int i = 0; i < n; i++) {
			V.add(new ArrayList<>());
		}

		// STORE Edges:
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			V.get(x).add(y);

			// Undirected
			// V,get(y).add(x);
		}

		// for valid source(source have child)
		// Loose BFS
		// System.out.println("\nLoose BFS:");
		// BFS(3, visited, V);

		/*
		 * if source has NO CHILD then it'll print that only ... iteration will over. to
		 * prevent that we will check if all nodes are visited? if not will send the
		 * UNVISITED node as source.
		 */
		// Tight BFS
		System.out.println("\nTight BFS:");
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0)
				BFS(i, visited, V);
		}

		sc.close();
	}

	static void BFS(int source, int visited[], ArrayList<ArrayList<Integer>> V) {

		Queue<Integer> q = new LinkedList<>();

		q.add(source);

		visited[source] = 1;

		while (!q.isEmpty()) {

			int current = q.peek();
			q.poll();

			System.out.print(current + "->");

			for (int i = 0; i < V.get(current).size(); i++) {

				int child = V.get(current).get(i);

				if (visited[child] == 0) {
					q.add(child);
					visited[child] = 1;
				}
			}

		}

	}

}
