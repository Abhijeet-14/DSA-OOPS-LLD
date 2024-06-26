package _dsa._0_JOB_Change.T1_Array.C2_HashTable;

import java.util.*;

public class C5_General_K_Sum {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;

        int sum_no = 4;
        List<List<Integer>> ans = K_Sum(nums, target, sum_no);
        System.out.println(ans);

    }
    static int len = 0;
    public static List<List<Integer>> K_Sum(int[] nums, int target, int sum_no) {
        int k = sum_no;

        len = nums.length;

        Arrays.sort(nums);

        return kSum(nums, target, 4, 0);
    }
    private static ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
            int i = index, j = len - 1;
            while(i < j) {
                //find a pair
                if(target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
}

