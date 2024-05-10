package _dsa._15_12_21_practice.MCM_DP;

import java.util.Arrays;

public class C3_Min_No_Palindrome_Partition {
    public static void main(String[] args) {
        String s = "abcdc";
        int n = s.length();

        int res = solve_Rec(s, 0, n - 1);
        System.out.println("Result Rec: " + res);

        // i & j varies from 0-n & 0-n resp.
        dp = new int[n + 1][n + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        int result = solve_Memo(s, 0, n - 1);
        System.out.println("Result Memo: " + result);
//        printMatrix(dp);


        for(int row[] : dp)
            Arrays.fill(row, -1);
        int optimize = solve_Memo_Optimze(s, 0, n - 1);
        System.out.println("Result Memo Optimize: " + optimize);
//        printMatrix(dp);
    }

    private static int solve_Memo_Optimze(String s, int i, int j) {
        if(i >= j)
            return dp[i][j] = 0;

        if(isPalindrome(s, i, j) == true)
            return dp[i][j] = 0; // No Partition is necessary

        if(dp[i][j] != -1)
            return dp[i][j];

        int mn = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            // here we can optimize for
            // [i][k] && [k+1][j]
            // so, if dp[i][k] & dp[k+1][j] != -1
            // don't call further
            int left = 0;
            if(dp[i][k] != -1)
                left = dp[i][k];
            else
                left = solve_Memo(s, i, k);

            int right = 0;
            if(dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else
                right = solve_Memo(s, k + 1, j);

            int temp = 1 + left + right;
            mn = Math.min(mn, temp);
        }

        return dp[i][j] = mn;
    }

    static int dp[][];

    private static int solve_Memo(String s, int i, int j) {
        if(i >= j)
            return dp[i][j] = 0;

        if(isPalindrome(s, i, j) == true)
            return dp[i][j] = 0; // No Partition is necessary

        if(dp[i][j] != -1)
            return dp[i][j];

        int mn = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int temp = 1 + solve_Memo(s, i, k) + solve_Memo(s, k + 1, j);
            mn = Math.min(mn, temp);
        }

        return dp[i][j] = mn;
    }

    private static int solve_Rec(String s, int i, int j) {
        // BASE CONDITION
        // we can't divide further when 1 char is present (i=j)
        // i>j -> INVALID
        // i==j -> No Partition
        if(i >= j)
            return 0;

        // i-j, is string PALINDROME???
        if(isPalindrome(s, i, j) == true) {
            System.out.println(s.substring(i, j + 1));
            return 0; // No Partition is necessary
        }
        int mn = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            // +1 bcoz of parent partition
            int temp = 1 + solve_Rec(s, i, k) + solve_Rec(s, k + 1, j);
            mn = Math.min(mn, temp);
        }

        return mn;
    }

    private static boolean isPalindrome(String s, int i, int j) {

        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }

    private static void printMatrix(int dp[][]) {

        for(int row[] : dp) {
            for(int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
