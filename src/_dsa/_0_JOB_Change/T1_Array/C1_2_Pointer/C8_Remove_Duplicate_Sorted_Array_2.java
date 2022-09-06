package _dsa._0_JOB_Change.T1_Array.C1_2_Pointer;

public class C8_Remove_Duplicate_Sorted_Array_2 {
    // Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,1,2,3,3};

        int ans = removeDuplicates_2_pointer(nums);

        for(int i=0;i<ans;i++)
            System.out.print(nums[i] + ", ");
    }
    public static int removeDuplicates_2_pointer(int[] nums) {
        int first= 0;
        int second = 0;

        int len = nums.length;

        int count = 0;
        for(int i=0; i<len && first<len;){
            nums[first++] =  nums[i];
            second = i+1; // important point

            int isDuplicate = 0;
            while(second<len){
                if(nums[second] == nums[i]){ //corner case
                    second++;
                    isDuplicate++;
                }
                else
                    break;
            }
            if(isDuplicate>0){ // corner case
                nums[first++] = nums[i];
                count++;
            }

            count++;
            i = second;
        }

        return count;
    }
}
