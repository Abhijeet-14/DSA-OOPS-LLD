package _dsa.ByHeart._16_10_21;

import java.util.*;

public class _7_DFS {

	static List<List<Integer>> VERTICES = new ArrayList<>();

	static boolean visited[];
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		visited = new boolean[n];

		// add LINKED LIST on each VERTICES
		for (int i = 0; i < n; i++) {
			VERTICES.add(new ArrayList<>());
		}

		// storing values
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			VERTICES.get(x).add(y);
		}

		dfs(0);

		sc.close();
	}

	public static void dfs(int source) {

		visited[source] = true;

		List<Integer> parent = VERTICES.get(source);

		for (int child : parent) {

			System.out.print("(" + source + " -> " + child + ")" + "->");
			if (visited[child] == false) {
				dfs(child);
			}
		}
	}

}
