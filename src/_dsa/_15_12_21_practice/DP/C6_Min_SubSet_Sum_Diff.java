package _dsa._15_12_21_practice.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C6_Min_SubSet_Sum_Diff {
    public static void main(String[] args) {
        // arr = []
        // sum = X
        // s1 - s2 = 0 -> equal sum partition
        // s1 + S2 = Total sum of array

        // Need to find? -> abs(s1-s2) = Min
        // so 0<s1<MAX(sumOfArr)
        // s1-s2 = min
        // s1 - (Total_sum - s1) = min
        // abs(Total_sum - 2s1) = min

        int arr[] = {1, 6, 11, 5};
        int n = arr.length;

        int RANGE = Arrays.stream(arr).sum();
        boolean dp[][] = new boolean[n + 1][RANGE + 1];
        tabulation(RANGE, arr, n, dp);
//        printTable(dp);

        // only select values,whose subset sum can be possible
        List<Integer> _list = new ArrayList<>();

        // go through last row and check.. if 2*s1<=Range or not?
        for(int i = 1; i < RANGE + 1; i++) {

            if(dp[n][i] && 2 * i <= RANGE)
                _list.add(i);
        }

        int mini = Integer.MAX_VALUE;
        for(int val : _list.toArray(new Integer[0])) {
            mini = Math.min(mini, RANGE - (2 * val));
        }

        System.out.println(_list);
        System.out.println("RESULT " + mini);
    }

    private static void tabulation(int range, int[] arr, int n, boolean[][] dp) {
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < range + 1; j++) {
                if(i == 0 && j != 0)
                    dp[i][j] = false;
                else if(j == 0)
                    dp[i][j] = true;
                else if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
    }

    public static void printTable(boolean[][] tab) {
        System.out.println("Print Table:");
        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[0].length; j++)
                System.out.print(tab[i][j] + " ");
            System.out.println();
        }

        System.out.println(tab[tab.length - 1][tab[0].length - 1]);
    }

}
