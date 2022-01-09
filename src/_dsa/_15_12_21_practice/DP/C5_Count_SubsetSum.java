package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C5_Count_SubsetSum {

    static int arr[] = {1, 2, 3,3};

    public static void main(String[] args) {
        int n = arr.length;
        int sum = 6;

        int rec_result = countSubSetSum_rec(sum, n);
        System.out.println("Recursion: " + rec_result);

        int dp[][] = new int[n + 1][sum + 1];
        // initialize
        for(int row[]: dp)
            Arrays.fill(row, -1);
        int memo_result = countSubSetSum_memo(sum, n, dp);
        System.out.println("Memo: " + memo_result);
        printTable(dp);
    }

    private static int countSubSetSum_memo(int sum, int n, int[][] dp) {
        if(sum == 0)
            return dp[n][sum] = 1;

        if(n == 0 && sum != 0)
            return dp[n][sum] = 0;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        if(arr[n - 1] <= sum)
            return dp[n][sum] = countSubSetSum_memo(sum - arr[n - 1], n - 1, dp) + countSubSetSum_memo(sum, n - 1, dp);

        return dp[n][sum] = countSubSetSum_memo(sum, n - 1, dp);
    }

    private static int countSubSetSum_rec(int sum, int n) {
        if(sum == 0)
            return 1;

        if(n == 0 && sum != 0)
            return 0;

        if(arr[n - 1] <= sum)
            return countSubSetSum_rec(sum - arr[n - 1], n - 1) + countSubSetSum_rec(sum, n - 1);

        return countSubSetSum_rec(sum, n - 1);
    }


    public static void printTable(int[][] t) {
        System.out.println("Print Table");
        for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }

}
