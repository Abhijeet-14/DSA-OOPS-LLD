package _dsa._0_JOB_Change.T1_Array.C2_HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C1_Two_Sum {
    public static void main(String[] args) {
//        int nums[] = {2,7,11,15};
//        int target = 9;

        // 2-pointer fail in this case
        int nums[] = {3,2,4};
        int target= 6;

        System.out.println(
                new ArrayList<>(Arrays.asList(11,22))
        );

        int ans_brute_force[] = two_sum_brute_force(nums, target);
        printArr(ans_brute_force); // O(n^2)

        int ans_2_pointer[] = two_sum_2_pointer(nums, target); // Doesn't work, as array is not in sorted order
        printArr(ans_2_pointer); // O(n)

        int ans_hash_func[] = two_sum_hash_func(nums, target);  // Hash-Func/Hash-Table
        printArr(ans_hash_func); // O(n)

    }

    public static int[] two_sum_hash_func(int nums[], int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff))
                return new int[]{i, map.get(diff)};
            else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }

    public static int[] two_sum_2_pointer(int nums[], int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int curr_sum = nums[left] + nums[right];

            if(curr_sum<target)
                left++;
            else if(curr_sum > target)
                right--;
            else
                return new int[]{left,right};
        }

        return new int[]{-1,-1};

    }

    public static int[] two_sum_brute_force(int nums[], int target){
        int n = nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }

    public static void printArr(int arr[]){
        System.out.print("[");
        for(int val: arr){
            System.out.print(val + ", ");
        }
        System.out.println("]");
    }
}
