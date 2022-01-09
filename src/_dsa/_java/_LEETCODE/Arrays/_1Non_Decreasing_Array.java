package _dsa._java._LEETCODE.Arrays;


// Question: https://leetcode.com/problems/non-decreasing-array/

// Response: I Quit.

public class _1Non_Decreasing_Array {

	public static void main(String[] args) {
		int nums[] = {3,2,1};
		System.out.println(checkPossibility(nums));
	}

	public static boolean checkPossibility(int[] nums) {

		boolean oneChangeMade = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (oneChangeMade)
					return false;

				oneChangeMade = true;

				
				if (i == nums.length - 2 || i == 0)
					continue;

			// In this case we need to see 
			//		1. if modifying the previous index can fix the issue.
			// 		2. or if modifying the current index can fix the issue
				else if (!(nums[i + 1] >= nums[i - 1] || nums[i + 2] >= nums[i])) {
					// We define an array is non-decreasing if nums[i] <= nums[i + 1] 
					// holds for every i (0-based) such that (0 <= i <= n - 2).
					return false;
				}
			}
		}
		return true;
	}

}
