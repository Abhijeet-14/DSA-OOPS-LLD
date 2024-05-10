package _dsa._15_12_21_practice.DP;

public class C10_rod_cutting {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8}; // rod length
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

        int N = 8;

        int n = arr.length;

        int dp[][] = new int[n + 1][N + 1];

        for(int row[] : dp)
            java.util.Arrays.fill(row, -1);
        memoization(N, n, dp, arr, price);
        System.out.println("Max Profit: " + dp[n][N]);
    }

    private static int memoization(int N, int n, int[][] dp, int[] arr, int[] price) {
        if(N == 0 || n == 0)
            return dp[n][N] = 0;
        if(dp[n][N] != -1)
            return dp[n][N];

        if(arr[n - 1] <= N) {
            dp[n][N] = Math.max(price[n - 1] + memoization(N - arr[n - 1], n, dp, arr, price), memoization(N, n - 1, dp, arr, price));
        }
        else
            dp[n][N] = memoization(N, n - 1, dp, arr, price);
        return dp[n][N];
    }
}
