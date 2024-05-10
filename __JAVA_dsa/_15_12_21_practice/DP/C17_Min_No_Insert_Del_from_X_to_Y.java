package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C17_Min_No_Insert_Del_from_X_to_Y {
    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";

        int n = x.length();
        int m = y.length();

        int dp[][] = new int[n + 1][m + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        int lcs_length = lcs(dp, x.toCharArray(), y.toCharArray(), n, m);
        // deletion
        int _delete = n - lcs_length;
        // insertion
        int _insert = m - lcs_length;

        System.out.println("Result: " + (_delete + _insert));
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
