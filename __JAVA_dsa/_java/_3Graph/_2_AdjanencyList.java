package _dsa._java._3Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class _2_AdjanencyList {

	public static void main(String[] args) {
		// 5 5
		// 0 2
		// 2 1
		// 2 4
		// 4 1
		// 1 3

		int n, m, x, y;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		// ADJANENCY LIST:
		ArrayList<ArrayList<Integer>> V = new ArrayList<ArrayList<Integer>>(n);

		// Vertices:
		for (int i = 0; i < n; i++) {
			V.add(new ArrayList<Integer>());
		}

		// Store:
		for (int i = 0; i < m; i++) {

			x = sc.nextInt();
			y = sc.nextInt();

			V.get(x).add(y);

			// Undirected
			// V.get(y).add(x);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(i + "->");
			for (int j = 0; j < V.get(i).size(); j++) {
				System.out.print(V.get(i).get(j) + " ");
			}
			System.out.println();
		}

		sc.close();
	}

}
