package _dsa._java._3Graph;

import java.util.Scanner;

public class _1_AdjancyMatirx {
	static int a[][] = new int[5][5];
	// 5 5
	// 0 2
	// 2 1
	// 2 4
	// 4 1
	// 1 3

	public static void main(String[] args) {
		int n, m, x, y;
		Scanner sc = new Scanner(System.in);

		// n: nodes // m: edges
		n = sc.nextInt();
		m = sc.nextInt();

		// Store the Edges:
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			a[x][y] = 1;

			// Undirected:
			// a[y][x] = 1;
		}

		// traverse:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}

}
