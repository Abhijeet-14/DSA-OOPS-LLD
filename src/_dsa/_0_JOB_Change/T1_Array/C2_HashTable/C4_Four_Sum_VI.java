package _dsa._0_JOB_Change.T1_Array.C2_HashTable;

import java.util.*;

public class C4_Four_Sum_VI {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        // int[] nums = {2,2,2,2,2};
        int target = 0;

        List<List<Integer>> ans_brute_force = four_sum_brute_force(nums, target);
        System.out.println(ans_brute_force); // O(N^4)

        // Optimize solution - O(N^3)
    }

    public static List<List<Integer>> four_sum_brute_force(int[] nums, int target){
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    for(int l=0;l<n;l++){
                        if(i!=j && i!=k && i!=l && j!=k && j!=l && k!=l){ // unique
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if(sum == target){
                                List<Integer> sub_ans = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                                Collections.sort(sub_ans);

                                set.add(sub_ans);
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
