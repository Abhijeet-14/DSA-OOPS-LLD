package _dsa._15_12_21_practice.DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class C15_Print_LCSubSequence {
    public static void main(String[] args) {
        String x = "abcdaf";
        String y = "acbcf";
        char X[] = x.toCharArray();
        char Y[] = y.toCharArray();

        int n = X.length;
        int m = Y.length;

        int dp[][] = new int[n + 1][m + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        LCS(dp, X, Y, n, m);
        PrintLCS(X, Y, dp, n, m);
    }

    private static void PrintLCS(char[] x, char[] y, int[][] dp, int n, int m) {

        Stack<Character> s = new Stack<>();
        while(n > 0 && m > 0) {
            // if matches.. we move up diagonally in table
            if(x[n - 1] == y[m - 1]) {
                s.push(x[n - 1]);   // push to stack
                n--;
                m--;
            }
            // if doesn't match -> move toward higher value bw n-1 & m-1
            else if(dp[n][m - 1] > dp[n - 1][m])
                m--;

            else
                n--;
        }

        System.out.print("RESULT: ");
        while(s.size() > 0)
            System.out.print(s.pop());

    }

    static int LCS(int dp[][], char x[], char y[], int n, int m) {
        if(n == 0 || m == 0)
            return dp[n][m] = 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(x[n - 1] == y[m - 1])
            return dp[n][m] = 1 + LCS(dp, x, y, n - 1, m - 1);

        return dp[n][m] = Math.max(LCS(dp, x, y, n, m - 1), LCS(dp, x, y, n - 1, m));
    }
}
