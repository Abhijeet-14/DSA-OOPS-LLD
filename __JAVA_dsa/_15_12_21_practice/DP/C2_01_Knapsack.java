package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C2_01_Knapsack {
    public static void main(String[] args) {
        int wt[] = {1, 3, 4, 5};
        int val[] = {1, 4, 5, 2};
        int W = 7;
        int n = wt.length;

        int ans_rec = knap_rec(wt, val, W, n);
        System.out.println("Recursion: " + ans_rec);

        int dp[][] = new int[n + 1][W + 1];

        // Initialize X
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);

        int ans_memo = knap_memo(wt, val, W, n, dp);
        System.out.println("Memo: " + ans_memo);

        int ans_tabu = knap_tabu(wt, val, W, n);
        System.out.println("Tabu: " + ans_tabu);

    }

    static int knap_tabu(int wt[], int val[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];

        Arrays.fill(dp[0], 0);
        for(int i = 0; i < n + 1; i++)
            dp[i][0] = 0;


        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < W + 1; j++) {
                if(wt[i - 1] <= j)
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
    }


    static int knap_memo(int wt[], int val[], int W, int n, int dp[][]) {
        if(n == 0 || W == 0)
            return 0;

        if(dp[n][W] != -1)
            return dp[n][W];

        if(wt[n - 1] <= W) {
            dp[n][W] = Math.max(
                    val[n - 1]
                            + knap_memo(wt, val, W - wt[n - 1], n - 1, dp),
                    knap_memo(wt, val, W, n - 1, dp)
            );
        } else
            dp[n][W] = knap_memo(wt, val, W, n - 1, dp);

        return dp[n][W];
    }

    static int knap_rec(int wt[], int val[], int W, int n) {
        if(n == 0 || W == 0)
            return 0;

        if(wt[n - 1] <= W)
            return Integer.max(
                    val[n - 1] + knap_rec(wt, val, W - wt[n - 1], n - 1),
                    knap_rec(wt, val, W, n - 1)
            );


        return knap_rec(wt, val, W, n - 1);
    }

}
