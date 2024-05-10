package _dsa._java._3Graph;

import java.util.*;
import java.util.Scanner;

public class _4_dfs {

	// Graph:
	// 0->1->4
	// 0->2->3
	// 1->5
	// so here, backtrack will occur in order of
	// 4 =>1 5 => 1 1 => 0 3 => 2 2 => 0

	// Inputs:
	// 6 5
	// 0 1
	// 1 4
	// 1 5
	// 0 2
	// 2 3

	static void DFS(int current, int visited[], List<List<Integer>> V) {

		List<Integer> curr = V.get(current);

		System.out.print(current + "->");

		visited[current] = 1;

		for (int i = 0; i < curr.size(); i++) {
			int child = curr.get(i);

			if (visited[child] == 0)
				DFS(child, visited, V);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int x, y;

		// VISITED?
		int visited[] = new int[n];

		// Adjacency List:
		List<List<Integer>> V = new ArrayList<>();

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

		// Depth First Search
		DFS(0, visited, V);

		sc.close();
	}

}
