package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C7_countNoSubsetGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3};
        int n = arr.length;

        int diff = 1;

        // Question
        // so s1-s2 = diff & s1+s2 =RANGE -> s1 = diff+RANGE/2

        int s1 = (diff + Arrays.stream(arr).sum()) / 2;

        int dp[][] = new int[n + 1][s1 + 1];
        memoization(dp, arr, n, s1);

        System.out.println(dp[n][s1]);
    }

    private static int memoization(int[][] dp, int[] arr, int n, int s1) {
        if(s1 == 0)
            return dp[n][s1] = 1;
        if(n == 0 && s1 != 0)
            return dp[n][s1] = 0;
        if(arr[n - 1] <= s1)
            return dp[n][s1] = memoization(dp, arr, n - 1, s1 - arr[n - 1]) + memoization(dp, arr, n - 1, s1);
        else
            return dp[n][s1] = memoization(dp, arr, n - 1, s1);
    }

    public static void printTable(int[][] tab) {
        System.out.println("Print Table:");
        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[0].length; j++)
                System.out.print(tab[i][j] + " ");
            System.out.println();
        }

        System.out.println(tab[tab.length - 1][tab[0].length - 1]);
    }
}
