package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C12_coin_change_Min_No_Ways {
    public static void main(String[] args) {
        int coins[] = {1, 2, 3,4};
        int amount = 6;

        int n = coins.length;

        int dp[][] = new int[n + 1][amount + 1];

        // initalize
        for(int row[] : dp) {
            Arrays.fill(row, -1);
            row[0] = 0;
        }
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);

        System.out.println(memo(amount, coins, dp, n));
    }

    static int memo(int amount, int coins[], int dp[][], int n) {
        if(amount == 0 && coins[n - 1] <= amount)
            return dp[n][amount] = 1;

        if(n == 0 && amount != 0)
            return dp[n][amount] = 0;

        if(n == 1 && amount % coins[n - 1] == 0) {
            return dp[n][amount] = amount / coins[n - 1];
        }

        if(n == 1 && amount % coins[n - 1] != 0)
            return dp[n][amount] = -1;

        if(dp[n][amount] != -1)
            return dp[n][amount];

        if(coins[n - 1] <= amount)
            return dp[n][amount] = Math.min(memo(amount, coins, dp, n - 1), 1 + memo(amount - coins[n - 1], coins, dp, n));

        return dp[n][amount] = memo(amount, coins, dp, n - 1);
    }

}
