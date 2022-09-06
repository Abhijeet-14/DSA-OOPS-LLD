package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C6_Remove_Duplicate_Sorted_Array_Non_Decrease {
    // Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2};
        int ans_brute_force[] = solve_brute_force(nums);
        printArr(ans_brute_force);

        int ans_optimize[] = solve_2_pointer(nums);
        printArr(ans_optimize);
    }

    private static int[] solve_brute_force(int[] nums) {
        int first = 0;
        for(int i=0; i< nums.length; ){
            nums[first++] = nums[i];
            boolean isTrue = false;
            int j = i+1;
            for(j=j; j< nums.length; j++){
                if(nums[j]!=nums[i]) {
                    i = j;
                    isTrue = true;
                    break;
                }
            }
            if(!isTrue)
                i++;
        }

        return nums;
    }



    public static int[] solve_2_pointer(int[] nums) {
        int first = 0;
        int second = 0;
        int len = nums.length;

        int count = 0;
        for (int i = 0; i < len; ) {

            nums[first] = nums[i];
            second++;
            while (second < len && first < len && nums[second] == nums[first]) {
                second++;
            }

            i = second;
            first++;
            count++;
        }

//        return count;
        return nums;
    }

//         SortedSet<Integer> ss = new TreeSet<>();

//         int len = nums.length;
//         int count = 0;
//         for(int i=0;i<len;i++){
//             int curr = nums[i];
//             if(!ss.contains(curr)){
//                 ss.add(curr);
//                 count++;
//             }
//         }

//         Object ans[] = ss.toArray();
//         for(int i=0;i<ans.length; i++){
//             nums[i] = (int) ans[i];
//         }

//         return count;

    private static void printArr(int[] arr) {
        for(int i=0;i<arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
    }
}
