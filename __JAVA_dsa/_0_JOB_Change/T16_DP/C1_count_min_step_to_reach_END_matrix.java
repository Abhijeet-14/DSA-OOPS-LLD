package _dsa._0_JOB_Change.T16_DP;

import java.util.Arrays;

public class C1_count_min_step_to_reach_END_matrix {
    static int N;
    static int M;
    public static void main(String[] args) {
//        int mat[][] = {
//                {2,1,2},
//                {1,1,1},
//                {1,1,1}
//        };
        int mat[][] = {
                {6,1,1,2},
                {2,1,2,1},
                {1,1,1,1},
                {3,1,1,1}
        };

        N= mat.length;
        M = mat[0].length;

        int dp[][] = new int[N][M];

        for(int val[]: dp)
            Arrays.fill(val, -1);

        int val = solve(mat, dp, 0, 0);
        System.out.println(val);

        int ans = dp[0][0];
        if(dp[0][0] == 2147483647 || dp[0][0] == -2147483648 || dp[0][0] == -1)
            ans = -1;

        System.out.println("Min Step: " + ans);
    }

    private static int solve(int[][] mat, int dp[][], int x, int y) {
        if(x>=N || y >= M || x < 0 || y < 0 || mat[x][y] <1)
            return Integer.MAX_VALUE;

        if(x == N-1 && y == M-1){
            dp[N-1][M-1] = 0;
            return dp[N-1][M-1];
        }

        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 1 + Math.min(
                solve(mat, dp, x + mat[x][y], y),
                solve(mat, dp, x, y + mat[x][y])
        );

        return  dp[x][y];
    }


}
