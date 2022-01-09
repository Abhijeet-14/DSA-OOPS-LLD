package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C18_Longest_palindromic_SubSequence {
    public static void main(String[] args) {
        String x = "agbcba";
        int n = x.length();

        // just check with its reverse value
        String rev = "";
        for(int i = n - 1; i >= 0; i--)
            rev += x.charAt(i);

        int dp[][] = new int[n + 1][n + 1];

        for(int row[] : dp)
            Arrays.fill(row, -1);
        int res = lcs(dp, x.toCharArray(), rev.toCharArray(), n, n);
        System.out.println("Result: " + res);
    }

    private static int lcs(int[][] dp, char[] x, char[] y, int n, int m) {
        if(n == 0 || m == 0)
            return dp[n][m] = 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(x[n - 1] == y[m - 1])
            return dp[n][m] = 1 + lcs(dp, x, y, n - 1, m - 1);

        return dp[n][m] = Math.max(lcs(dp, x, y, n - 1, m), lcs(dp, x, y, n, m - 1));
    }
}
