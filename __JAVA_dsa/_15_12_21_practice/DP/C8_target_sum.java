package _dsa._15_12_21_practice.DP;

import java.util.Arrays;

public class C8_target_sum {
    public static void main(String[] args) {
        // Question
        // say s1(Negative Group) = -1,-2 & s2(positive group) = 1,3
        // so -> s2-s1 = (1+3) - (1+2) = 4-3 = 1 == diff
        // s1 = (RANGE + diff)/2

        int arr[] = {1, 1, 2, 3};
        int n = arr.length;

        int diff = 1;

        int s1 = (diff + Arrays.stream(arr).sum()) / 2;

        boolean dp[][] = new boolean[n + 1][s1 + 1];
        memoization(dp, arr, n, s1);

        System.out.println(dp[n][s1]);

    }

    private static boolean memoization(boolean[][] dp, int[] arr, int n, int s1) {
        if(s1 == 0)
            return dp[n][s1] = true;

        if(n == 0 && s1 != 0)
            return dp[n][s1] = false;

        if(arr[n - 1] <= s1)
            return dp[n][s1] = memoization(dp, arr, n - 1, s1 - arr[n - 1]) || memoization(dp, arr, n - 1, s1);
        return dp[n][s1] = memoization(dp, arr, n - 1, s1);
    }
}
