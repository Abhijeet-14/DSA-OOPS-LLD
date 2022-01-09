package _dsa._java._3Graph;

import java.util.*;

/*
 *  CONCEPT: dfsRec(source)
 *  	we have 2 boolean array visited[], recSt[]
 *  
 *  	mark visited[source] = true & recSt[source] = true
 *  	
 *  	if child exist..{
 *  		if visited[child] is false
 *  			if dfsRec(child, source)
 *  				return true;
 *	 		else if recSt[child] is false
 *				return true;
 * 		}
 * 
 *  	if NO Child.. while popping source from recursion stack,.. 
 *  	recSt[source] = false
 *  	return false
 */

public class _7_Directed_Cycle {

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

			// Undirected
			// adj.get(v).add(u);
		}

		printGraph(adj, V);

		boolean isCycle = detectCycle(adj, V);

		System.out.println(isCycle);

		sc.close();
	}

	public static boolean detectCycle(List<List<Integer>> adj, int V) {

		boolean visited[] = new boolean[V];
		boolean recSt[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				if (dfsRec(adj, visited, recSt, i) == true)
					return true;
			}
		}

		return false;
	}

	public static boolean dfsRec(List<List<Integer>> adj, boolean visited[], boolean recSt[], int source) {
		List<Integer> current = adj.get(source);

		visited[source] = true;
		recSt[source] = true;

		for (int i = 0; i < current.size(); i++) {
			int child = current.get(i);
			if (visited[child] == false) {
				if (dfsRec(adj, visited, recSt, child) == true) {
					return true;
				}
			}
			// Does child exist in recursion Stack
			else if (recSt[child] == false)
				return true;

		}
		recSt[source] = false;

		return false;
	}

	// Print Graph
	public static void printGraph(List<List<Integer>> adj, int V) {
		for (int i = 0; i < V; i++) {
			System.out.print(i + "->");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
