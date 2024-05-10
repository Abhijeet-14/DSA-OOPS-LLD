package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C13_Longest_common_subsequence {
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        int n = X.length();
        int m = Y.length();

        int result_rec = recur(X, Y, n, m);
        System.out.println("Recursion: " + result_rec);

        int dp[][] = new int[n + 1][m + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        int result_memo = memo(X, Y, n, m, dp);
        System.out.println("Memoization: " + result_memo);

        int result_tabu = tabu(X, Y, n, m);
        System.out.println("Tabulation: " + result_tabu);
    }

    private static int tabu(String x, String y, int n, int m) {
        int t[][] = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                else if(x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];

                else
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
            }
        }

        return t[n][m];
    }

    private static int memo(String x, String y, int n, int m, int[][] dp) {
        if(n == 0 || m == 0)
            return dp[n][m] = 0;
        if(dp[n][m] != -1)
            return dp[n][m];

        if(x.charAt(n - 1) == y.charAt(m - 1))
            return dp[n][m] = 1 + memo(x, y, n - 1, m - 1, dp);

        return dp[n][m] = Math.max(memo(x, y, n, m - 1, dp), memo(x, y, n - 1, m, dp));
    }

    private static int recur(String x, String y, int n, int m) {
        if(n == 0 || m == 0)
            return 0;

        if(x.charAt(n - 1) == y.charAt(m - 1))
            return 1 + recur(x, y, n - 1, m - 1);
        else
            return Math.max(recur(x, y, n, m - 1), recur(x, y, n - 1, m));
    }
}
