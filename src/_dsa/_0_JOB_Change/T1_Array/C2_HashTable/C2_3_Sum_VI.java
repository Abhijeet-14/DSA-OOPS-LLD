package _dsa._0_JOB_Change.T1_Array.C2_HashTable;

import java.util.*;

public class C2_3_Sum_VI {
    public static void main(String[] args) {
        int nums[] = {-2,0,1,1,2};
        // [-1,0,1,2,-1,-4]

        List<List<Integer>> ans_brute_force = three_sum_brute_force(nums);
        System.out.println(ans_brute_force); // O(N^3)

//        List<List<Integer>> ans_2_pointer_with_1_fix = three_sum_2_pointer_with_1_fix(nums);
//        System.out.println(ans_2_pointer_with_1_fix); // O(N^2)
    }

    public static List<List<Integer>> three_sum_2_pointer_with_1_fix(int nums[]){
        int n = nums.length;

        Arrays.sort(nums); // after sorting, we can use 2-pointer // prevent duplicate

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> sub_ans = Arrays.asList(nums[i], nums[j++], nums[k--]);

//                    Collections.sort(sub_ans); // to remove duplicate // O(3*log3)
                    set.add(sub_ans);

                }
                else if ( sum >0)
                    k--;

                else if (sum<0)
                    j++;
            }
        }


        return new ArrayList<>(set);
    }

    public static List<List<Integer>> three_sum_brute_force(int nums[]){
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n;j++){
                for(int k = j+1; k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum==0 && i!=j && i!=k && j!=k ){
                        List<Integer> sub_ans = Arrays.asList(nums[i], nums[j], nums[k]);

                        Collections.sort(sub_ans); // to remove duplicate // O(3*log3)
                        set.add(sub_ans);

                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}
