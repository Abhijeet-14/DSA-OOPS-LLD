package _dsa._0_JOB_Change.T4_Greedy_Algo;

import java.util.*;

public class C1_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {
    // Question: https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

    public static void main(String[] args) {
        int num = 2932;
        int ans = minimumSum(num);
        System.out.println(ans);
    }
    public static int minimumSum(int num) {
        return solve_Greedy(num); // O(N*LogN)
    }
    public static int solve_Brute_Force(int num) {
        return -1;
    }
    public static int solve_Greedy(int num) {
            // Logic:
            // sort the array
            // take 2 smallest value at 10's place
            // take 2 largest value at 0's place
            // sum them -- get the solution
            int nums[] = new int[4];
            for(int i=0;i<4;i++){
                nums[i] = num%10;
                num = num/10;
            }

            Arrays.sort(nums);
            int n1 = nums[0]*10;
            int n2 = nums[1]*10;
            int min = Integer.MAX_VALUE;
            return n1+nums[2] + n2 + nums[3];

    }
}
