package _dsa._0_JOB_Change.T1_Array.C3_Prefix_Sum;

public class C2_Contigious_SubArray_Sum {
    public static void main(String[] args) {
        int nums[] = {23,2,4,6,7};
        int k = 6;

        boolean ans = checkSubarraySum(nums, k);
        System.out.println(ans);
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        return solve_brute_force(nums, k); // O(N^2)
//        return solve_optimize(nums, k); // yet to solve

    }
    public static boolean solve_brute_force(int[] nums, int k) {

        int count =0;
        int sum = 0;

        int left = 0, right = 0;

        int len = nums.length;

        for(int i=0;i<len;i++){
            sum = 0;
            count = 0;
            for(int j=i;j<len;j++){
                count++;
                sum += nums[j];
                if(count >= 2 && sum%k == 0)
                    return true;
            }
        }

        return false;
    }
}
