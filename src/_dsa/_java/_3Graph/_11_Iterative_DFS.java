package _dsa._java._3Graph;

import java.util.*;
import java.util.Scanner;

public class _11_Iterative_DFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int x, y;

		// VISITED?
		boolean visited[] = new boolean[n];

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

		for (int i = 0; i < n; i++) {
			if (!visited[i])
				dfsIterative(V, visited, i);
		}

		sc.close();
	}

	public static void dfsIterative(List<List<Integer>> adj, boolean[] visited, int source) {
		Stack<Integer> s = new Stack<>();

		s.push(source);

		while (!s.isEmpty()) {

			visited[s.peek()] = true;
			List<Integer> curr = adj.get(s.peek());

			System.out.print(s.peek() + " ");
			s.pop();

			for (int i = 0; i < curr.size(); i++) {
				int child = curr.get(i);
				if (!visited[child])
					s.push(child);
			}
		}
	}

}
