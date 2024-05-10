package _dsa._java._LEETCODE.Dynamic_Programing;

import java.util.*;

/*
 * Question: https://leetcode.com/problems/matrix-block-sum/
 * 
 * Response: SOlved, but 15% 100ms
 * 
 * Optimization: DP approach 1ms O(n*m)
 */

public class M2_Matrix_Block_Sum {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int K = 1;

		R = mat.length;
		C = mat[0].length;

		int ans[][] = myApproach(mat, K);
		System.out.println("MyApproach: 15% 100ms");
		printMat(ans);

		int newAns[][] = optimize(mat, K);
		System.out.println("\nOptimize: 90% 0ms: CANNOT UNDERSTAND! ");
		printMat(newAns);

	}

	///////////////////////////////
	// OPTIMIZATION
	///////////////////////////////

	// Block-sum of rectangle ABCD = block-sum of D - block-sum of B - block-sum of
	// C + block-sum of A

	// PRE-SUM: in matrix
	/*
	 * [1, 2, 3] [4, 5, 6] [7, 8, 9]
	 * 
	 * [1, 3, 6] [5, 12, 21] [12, 27, 45]
	 * 
	 * sum D = mat D + sum B + sum C - sum A;
	 * sum[i][j] = mat[i][j] + sum [i-1][j] + sum[i][j-1] - sum[i-1][j-1]
	 */

	public static int[][] optimize(int mat[][], int K) {

		int[][] sum = new int[R + 1][C + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top,
												// right, bottom corresponding
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
			}
		}
		int[][] newAns = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int r1 = Math.max(0, r - K);
				int c1 = Math.max(0, c - K);
				int r2 = Math.min(C - 1, C + K);
				int c2 = Math.min(C - 1, c + K);
				// Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
				r1++;
				c1++;
				r2++;
				c2++;
				newAns[r][c] = sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
			}
		}
		return newAns;
	}

	///////////////////////////////
	// MY APPROACH
	///////////////////////////////
	static int R, C;
	static int ans[][];

	public static int[][] myApproach(int[][] mat, int K) {

		ans = new int[R][C];

		for (int[] r : ans)
			Arrays.fill(r, -1);

		solve(mat, K, 0, 0);

		return ans;
	}

	public static void solve(int[][] mat, int k, int i, int j) {
		if (i == R || j == C)
			return;

		if (ans[i][j] != -1)
			return;

		int rs = i - k < 0 ? 0 : i - k;
		int re = i + k >= R ? R - 1 : i + k;

		int cs = j - k < 0 ? 0 : j - k;
		int ce = j + k >= C ? C - 1 : j + k;

		// Sum of SUB-MATRIX
		int sum = 0;
		for (int p = rs; p <= re; p++) {
			for (int q = cs; q <= ce; q++) {
				sum += mat[p][q];
			}
		}

		ans[i][j] = sum;

		// Call for next column
		solve(mat, k, i, j + 1);
		// Call for next row
		solve(mat, k, i + 1, j);
	}

	// Print matrix:
	public static void printMat(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
}
