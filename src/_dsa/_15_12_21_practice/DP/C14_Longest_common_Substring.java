package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C14_Longest_common_Substring {
    public static void main(String[] args) {
        String X = "ab";
        String Y = "abfdec";

        int n = X.length();
        int m = Y.length();

        int res_recur = recur(X, Y, n, m, 0);
        System.out.println("Recursion: " + res_recur);

        int dp[][] = new int[n + 1][m + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        int res_DP = DP( X, Y, n, m);
        System.out.println("DP-Solution: " + res_DP);
    }

    public static int DP(String X, String Y, int n, int m){
        int dp[][] =new int[n+1][m+1];

        int result = 0;

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0||j==0)
                    dp[i][j] = 0;
                else if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    result = Math.max(dp[i][j], result);
                }
                else
                    dp[i][j]=0;
            }
        }
        return result;
    }

    private static int recur(String x, String y, int n, int m, int ans) {
        if(n == 0 || m == 0)
            return ans;

        if(x.charAt(n - 1) == y.charAt(m - 1))
            return recur(x, y, n - 1, m - 1, ans + 1);

        return Math.max(
                ans, Math.max(recur(x, y, n - 1, m, 0),
                        recur(x, y, n, m - 1, 0))
        );

    }
}
