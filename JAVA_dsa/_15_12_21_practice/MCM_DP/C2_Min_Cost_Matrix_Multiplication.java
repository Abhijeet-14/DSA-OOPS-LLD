package _dsa._15_12_21_practice.MCM_DP;

import java.util.Arrays;

public class C2_Min_Cost_Matrix_Multiplication {
    public static void main(String[] args) {

        // dimension given in element.
        int arr[] = {40, 20, 30, 10, 30};
        int n = arr.length;

        // n-1 matrix can be created, Ai = arr[i-1]*arr[i]
        // A1 -> arr[0]*arr[1] -> 40*20
        // A2 -> 20*30
        // A3 -> 30*10
        // A4 -> 10*30

        // find Min Cost of Matrix Multiplication

        int res = mcm_R(arr, 1, n - 1);
        System.out.println("Result Rec: " + res);

        // Initialize MEMO
        dp = new int[n + 1][n + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        res = mcm_Memo(arr, 1, n - 1);
        System.out.println("Result Memo: " + res);
    }

    private static int mcm_R(int[] arr, int i, int j) {
        // if 1 matrix -> 2-matrix req for Multiplication
        if(i >= j)
            return 0;

        int mn = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int currMulti = arr[i - 1] * arr[k] * arr[j];
            int temp = mcm_R(arr, i, k) + mcm_R(arr, k + 1, j) + currMulti;

            mn = Math.min(mn, temp);
        }

        return mn;
    }

    static int dp[][];

    private static int mcm_Memo(int[] arr, int i, int j) {
        // i & j is changing -> so applies on i & j
        // i -> 0 - n
        // j -> 0 - n
        // So, dp -> [n+1][n+1]

        if(i >= j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int mn = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int currMulti = arr[i - 1] * arr[k] * arr[j];
            int temp = mcm_R(arr, i, k) + mcm_R(arr, k + 1, j) + currMulti;

            mn = Math.min(mn, temp);
        }

        return dp[i][j] = mn;
    }

}
