package _dsa._java._LEETCODE.Dynamic_Programing;

import java.util.*;

/*
 * Question: https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Response: Solved, Pre-computing sum & Optimized
 *  
 */

public class E7_Range_Sum_Query {

	public static void main(String[] args) {
		int nums[][] = { { -2, 0, 3, -5, 2, -1 }, { 0, 2 }, { 2, 5 }, { 0, 5 } };

		List<Integer> ans = myApproach(nums);
		System.out.println("MyApproach (Pre-Computing sum O(N)): O(1) - Optimized \n" + ans);
	}

	private static List<Integer> myApproach(int[][] nums) {
		List<Integer> ans = new ArrayList<>();
		
		int preSum[] = new int[nums[0].length + 1];

		for (int i = 0; i < nums[0].length; i++)
			preSum[i + 1] = preSum[i] + nums[0][i];

		for (int i = 1; i < nums.length; i++) {
			int left = preSum[nums[i][0]];

			int right = preSum[nums[i][1] + 1];

			ans.add(right - left);
		}
		return ans;
	}

}
