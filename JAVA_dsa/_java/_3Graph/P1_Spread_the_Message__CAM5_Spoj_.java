package _dsa._java._3Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1_Spread_the_Message__CAM5_Spoj_ {

	// Input:
	// 4 2
	// 0 1
	// 1 3

	static void BFS(int source, int visited[], ArrayList<ArrayList<Integer>> V) {

		Queue<Integer> q = new LinkedList<>();

		q.add(source);

		visited[source] = 1;

		while (!q.isEmpty()) {

			int current = q.peek();
			q.poll();

			for (int i = 0; i < V.get(current).size(); i++) {

				int child = V.get(current).get(i);

				if (visited[child] == 0) {
					q.add(child);
					visited[child] = 1;
				}
			}

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
		ArrayList<ArrayList<Integer>> V = new ArrayList<ArrayList<Integer>>(n);

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

		int count = 0;

		// Tight BFS
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				BFS(i, visited, V);
				count++;
			}
		}

		System.out.println(count);

		sc.close();
	}

}
