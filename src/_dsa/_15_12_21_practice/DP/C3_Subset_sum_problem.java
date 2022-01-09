package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C3_Subset_sum_problem {
    public static void main(String[] args) {
        int sum = 11;
        int arr[] = {2, 3, 7, 8, 10};
        int n = arr.length;
        // return true is subset of sum is present in arr.

        boolean rec_result = subsetSum_Rec(sum, arr, n);
        System.out.println("Recursion: " + rec_result);


        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Memo initialize
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], false);
        boolean memo_result = subsetSum_Memo(sum, arr, n, dp);
        System.out.println("Memoization: " + memo_result);
        print_table(n, sum, dp);

        // Tabulation initialize
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], false);
        // when sum = 0
        for(int i=0; i<n+1; i++)
            dp[i][0] = true;
        boolean tabu_result = subsetSum_tabu(sum, arr, n, dp);
        System.out.println("Tabulation: " + tabu_result);
        print_table(n, sum, dp);
    }

    private static boolean subsetSum_tabu(int sum, int[] arr, int n, boolean[][] dp) {

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];

                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];

    }

    private static boolean subsetSum_Memo(int sum, int[] arr, int n, boolean[][] dp) {

        if(sum == 0)
            dp[n][sum] = true;

        if(n == 0 && sum != 0)
            return dp[n][sum] = false;

        if(dp[n][sum])
            return dp[n][sum] = true;

        if(arr[n - 1] <= sum)
            return dp[n][sum] = subsetSum_Memo(sum - arr[n - 1], arr, n - 1, dp) || subsetSum_Memo(sum, arr, n - 1, dp);

        return dp[n][sum] = subsetSum_Memo(sum, arr, n - 1, dp);

    }

    private static boolean subsetSum_Rec(int sum, int[] arr, int n) {

        if(sum == 0)
            return true;

        if(n == 0 && sum != 0)
            return false;

        if(arr[n - 1] <= sum) {
            boolean right = subsetSum_Rec(sum - arr[n - 1], arr, n - 1);
            boolean left = subsetSum_Rec(sum, arr, n - 1);

            return left || right;
        }

        boolean left = subsetSum_Rec(sum, arr, n - 1);
        return left;

    }

    static void print_table(int x, int y, boolean arr[][]) {
        for(int i = 0; i < x + 1; i++) {
            for(int j = 0; j < y + 1; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

