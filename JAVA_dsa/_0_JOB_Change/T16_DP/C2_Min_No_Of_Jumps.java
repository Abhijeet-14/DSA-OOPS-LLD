package _dsa._0_JOB_Change.T16_DP;

import java.util.Arrays;

public class C2_Min_No_Of_Jumps {
    public static void main(String[] args) {
//        int arr[] = {2,3,1,1,4};
        int arr[] = {5,9,3,2,1,0,2,3,3,1,0,0};

        int ans = jump(arr);
        System.out.println(ans);
    }

    static int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,-1);

        solve(nums,dp, n, 0);

         for(int v: dp)
             System.out.print(v + ", ");

        System.out.println();

        return dp[0];
    }

    static int max_value = 99999;
    static int solve(int arr[], int dp[], int n, int i){
        if(i == n-1){
            dp[i] = 0;
            return dp[i];
        }

        if(i>=n || i<0 || arr[i] == 0)
            return max_value;

        if(dp[i]!=-1)
            return dp[i];

        int mn = max_value;

        for(int x=1; x<=arr[i]; x++)
            mn =Math.min(mn,solve(arr, dp, n, i+x));

        // if(mn == max_value)
        //     mn = 9999;

        dp[i] = 1+mn;
        return dp[i];
    }
}
