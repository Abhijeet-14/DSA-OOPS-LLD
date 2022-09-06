package _dsa._0_JOB_Change.T1_Array.C3_Prefix_Sum;

public class C1_Minimum_Size_SubArray_Sum {
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        int ans = minSubArrayLen(target, nums);
        System.out.println(ans);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        return solve_brute_force(target, nums); // O(N^2)
        // return solve_2_pointer(target, nums); // O(N)
    }

    public static int solve_brute_force(int target, int[] nums) {
        int len = nums.length;

        int min  = Integer.MAX_VALUE;

        for(int i=0; i<len;i++){
            int curr_sum = 0;
            for(int j=i; j<len; j++){
                curr_sum += nums[j];
                if(curr_sum >= target){
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int solve_2_pointer(int target, int[] nums) {
        int left = 0, right =0;
        int len = nums.length;

        int curr_sum = 0;
        int min = Integer.MAX_VALUE;
        while(right<len){
            curr_sum += nums[right];
            if(curr_sum >= target){
                min = Math.min(min, right-left+1);

                curr_sum -= nums[left] + nums[right];
                left++;
            }else{
                right++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
