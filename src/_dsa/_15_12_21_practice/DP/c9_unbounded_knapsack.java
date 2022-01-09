package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class c9_unbounded_knapsack {
    public static void main(String[] args) {
        int arr[] = {5, 10, 15};
        int wt[] = {10, 30, 20};
        int W = 30;

        int n = arr.length;

        int dp[][] = new int[n + 1][W + 1];

        for(int row[] : dp)
            Arrays.fill(row, -1);

        memoization(dp, arr, wt, W, n);
        System.out.println("Result = " + dp[n][W]);
    }

    private static int memoization(int[][] dp, int[] arr, int[] wt, int w, int n) {
        if(w == 0 || n == 0)
            return dp[n][w] = 0;
        if(dp[n][w] != -1)
            return dp[n][w];

        if(arr[n - 1] <= w) // UNBOUND MULTIPLE OCCURENCE
            return dp[n][w] = Math.max(wt[n - 1] + memoization(dp, arr, wt, w - arr[n - 1], n), memoization(dp, arr, wt, w, n - 1));

        return dp[n][w] = memoization(dp, arr, wt, w, n - 1);

    }
}
