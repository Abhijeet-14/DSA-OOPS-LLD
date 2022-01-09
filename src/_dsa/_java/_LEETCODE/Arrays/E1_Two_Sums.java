package _dsa._java._LEETCODE.Arrays;
import java.util.HashMap;

/*
 * Question: https://leetcode.com/problems/two-sum/
 * 
 * Response: Solved.. OPTIMIZATION with HashMap.. as searching is O(1)
 */
public class E1_Two_Sums {

	public static void main(String[] args) {
		int nums[] = new int[] {2, 7, 11, 15};
		int target = 9;
		
		int ans[] = myApproach(nums, target);
		
		for(int val: ans)
			System.out.print(val + " ");
	}
	
	public static int[] myApproach(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]) , i};
            map.put(target-nums[i], i);
        }
        
        return new int[]{};
    }

}
