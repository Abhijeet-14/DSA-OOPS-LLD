package _dsa._15_12_21_practice.DP;

public class C11_coin_change_MAX_No_Ways {
    public static void main(String[] args) {
        int arr[] = {1, 2};

        int sum = 5;

        int n = arr.length;

        int dp[][] = new int[n + 1][sum + 1];

        for(int row[] : dp)
            java.util.Arrays.fill(row, -1);

        memoization(sum, n, dp, arr);

        System.out.println(dp[n][sum]);
    }

    private static int memoization(int sum, int n, int[][] dp, int[] arr) {
        if(sum == 0)
            return dp[n][sum] = 1;
        if(n == 0 && sum != 0)
            return dp[n][sum] = 0;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        if(arr[n - 1] <=sum)
            return dp[n][sum] = memoization(sum - arr[n - 1], n, dp, arr) + memoization(sum, n - 1, dp, arr);

        return dp[n][sum] = memoization(sum, n - 1, dp, arr);
    }
}
