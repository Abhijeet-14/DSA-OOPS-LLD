package _dsa._java._LEETCODE.Graph;

import java.util.*;
// Question: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
// Response: Needs to optimize	- TLE

// Optimize: Use DP & dfs

public class H_Topo_Longest_inreasing_path_in_matrix {

    public static void main(String[] args) {

        int matrix[][] = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };

        // MY APPROACH
        System.out.println("My Approach: WRONG");
        int val = longestIncreasingPath(matrix);
        System.out.println(val);

        // Optimized APPROACH
        System.out.println("\nOptimized APPROACH(dp+dfs): CORRECT & faster than 85.96%");
        int vl = optimizeApproach(matrix);
        System.out.println(vl);
    }

    // OPTIMIZE APPROACH: Correct, DP + DFS
    private static int optimizeApproach(int[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;

        int dp[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }

        int mx = 0;

        int k = 0;
        for (int j = 0; j < row * col; j++) {
            int J = j % col;
            mx = Math.max(mx, dfs(matrix, k, J, dp, Integer.MIN_VALUE));

            if (J + 1 == col)
                k++;
        }

        int temp = mx == Integer.MIN_VALUE ? 0 : mx;
        return temp;
    }

    private static int dfs(int[][] matrix, int n, int m, int[][] dp, int prev) {

        if (n == -1 || m == -1 || m >= matrix[0].length || n >= matrix.length)
            return 0;

        int curr = matrix[n][m];

        // Increasing Sequence:
        if (prev >= curr)
            return 0;

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        return dp[n][m] = 1 + Math.max(Math.max(dfs(matrix, n, m - 1, dp, curr), dfs(matrix, n - 1, m, dp, curr)),
                Math.max(dfs(matrix, n + 1, m, dp, curr), dfs(matrix, n, m + 1, dp, curr)));
    }

    // MY APPROACH(BRUTE FORCE): WRONG, gives TLE
    static int mx = Integer.MIN_VALUE;

    public static int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                backTrack(matrix, i, j, -1, count);
            }
        }

        int temp = mx == Integer.MIN_VALUE ? 0 : mx;
        return temp;

    }

    public static void backTrack(int[][] matrix, int n, int m, int prev, int count) {

        if (n == -1 || m == -1 || m >= matrix[0].length || n >= matrix.length)
            return;

        int curr = matrix[n][m];

        if (prev == -1)
            count = 0;

        else if (prev <= curr)
            return;

        count++;

        if (count > mx)
            mx = count;

        int a[] = { 0, -1, 0, 1, -1, 0, 1, 0 };

        for (int i = 0; i < 4; i++) {
            backTrack(matrix, n + a[i * 2], m + a[i * 2 + 1], curr, count); // 0 -1
        }
    }
}