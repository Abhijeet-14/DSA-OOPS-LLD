package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C2_VI_Rain_water_trapping {
    // Question: https://leetcode.com/problems/trapping-rain-water

    // Important concept: Array Pre-Processing
    // logic: run loop 2 time,
    //      1 from left->right => find left max to index
    //      2 from right->left => find right max to  index

    // Now, at index i, take min(left_max[i], right_max[i]) - height[i]
    // take sum of all at index
    public static void main(String[] args) {
        int height[] = {3,1,2,4,0,1,2,3};

        int ans_bf = solve_brute_force(height);
        System.out.println("Brute Force: " + ans_bf); // TC - O(?), AS - O(?)

        // array pre-processing
        int ans = solve_opti_array_pre_processing(height);
        System.out.println("Opti_Array_Pre_Processing: " + ans); // TC - O(N), AS - O(N)
    }

    private static int solve_brute_force(int[] height) {
        // brute force;
        return -1;
    }

    private static int solve_opti_array_pre_processing(int[] height) {
        int len = height.length;

        int left_max[] = new int[len];
        left_max[0] = height[0];
        for(int i=1;i<len;i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }

        int right_max[] = new int[len];
        right_max[len-1] = height[len-1];
        for(int i=len-2;i>0;i--){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }

        int ans = 0;

        for(int i=0; i<len; i++){
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return ans;
    }
}
