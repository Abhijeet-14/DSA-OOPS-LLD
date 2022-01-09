package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C16_Shortest_Common_SuperSequence {
    public static void main(String[] args) {
        // Super Sequence -> Merge both X, Y but it should be SHORTEST.
        // "geek" "eke" -> "geeke"
        // geeke + eke -> LCS(ek)
        // removing LCS -> geeke

        String x = "AGGTAB";
        String y = "GXTXAYB";

        int n = x.length();
        int m = y.length();

        int dp[][] = new int[n + 1][m + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        int lcs_length = lcs(dp, x.toCharArray(), y.toCharArray(), n, m);

        System.out.println("Shortest SuperSequence Length: " + (n + m - lcs_length));
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
