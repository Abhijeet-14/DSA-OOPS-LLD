
package _dsa._java._3Graph;

import java.util.*;

/* CONCEPT:
 * 		if node is visited && node NOT parent
 * 		then, CYCLE
 */

public class _6_Undirected_Cycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int e = sc.nextInt();

		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		// printGraph(adj, V);

		boolean isCycle = detectCycle(adj, V);

		System.out.println(isCycle);

		sc.close();
	}

	public static boolean detectCycle(List<List<Integer>> adj, int V) {

		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				if (dfsRec(adj, visited, i, -1) == true)
					System.out.println(true + " at " + i);
//				return true;
			}
		}

		return false;
	}

	public static boolean dfsRec(List<List<Integer>> adj, boolean visited[], int source, int parent) {
		List<Integer> current = adj.get(source);

		visited[source] = true;

		for (int i = 0; i < current.size(); i++) {
			int child = current.get(i);

			if (visited[child] == false) {
				if (dfsRec(adj, visited, child, source) == true)
				{
					System.out.println("Cyc -> " + child + " => " + source);
					return true;}
			} else if (child != parent)
				return true;
		}

		return false;
	}

	// Print Graph
	public static void printGraph(List<List<Integer>> adj, int V) {
		for (int i = 0; i < V; i++) {
			System.out.print(i + "->");
			for (int j = 0; j < adj.get(i).size(); j++)
				System.out.print(adj.get(i).get(j) + " ");

			System.out.println();
		}
	}

}

//
// 6 6
// 0 1
// 0 2
// 0 3
// 2 5
// 2 4
// 2 1
