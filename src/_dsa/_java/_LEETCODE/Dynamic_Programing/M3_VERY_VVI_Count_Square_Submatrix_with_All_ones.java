package _dsa._java._LEETCODE.Dynamic_Programing;

/*
 * Question: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 * RESPONSE: VERY VERY VERY VERY IMPORTANT
 * 
 * IDEA: we store the no. of SQUARE SUB-MATRIX of a sub-matrix at it's BOTTOM-RIGHT-CORNER.
 */
public class M3_VERY_VVI_Count_Square_Submatrix_with_All_ones {

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		
		int ans = optimized(mat);
		
		System.out.println("Optimized (VVI): O(N*M): \n" + ans);
				
	}

	public static int optimized(int[][] matrix) {

		int m = matrix.length;

		int n = matrix[0].length;

		int dp[][] = new int[m][n];

		// Fill first row... as it won't > 1 sq. submatirx
		for (int i = 0; i < m; i++)
			dp[i][0] = matrix[i][0];

		// Fill first column... as it won't > 1 sq. submatirx
		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		// Fill other cells
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// bottom-right-corner = 1 + minimum( diagonal, top, left)
				if (matrix[i][j] == 1) {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				} else {
					dp[i][j] = 0;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ans += dp[i][j];
			}
		}
		return ans;
	}
}
