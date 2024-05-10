package _dsa._0_JOB_Change.T1_Array.C3_Prefix_Sum;

import java.util.*;

public class C3_SubArray_Sum_Equals_k {
    public static void main(String[] args) {

    }
    public static int subarraySum(int[] nums, int k) {
        return solve_brute_force(nums, k); // O(N^2);
    }

    public static int solve_brute_force(int[] nums, int k) {
        int len =nums.length;

        int sum = 0;
        int count = 0;
        for(int i=0;i<len;i++){
            sum = 0;
            for(int j=i;j<len;j++){
                sum += nums[j];

                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}
