package _dsa._java._LEETCODE.Dynamic_Programing;

public class E6_VVI_Maximum_Subarray {

	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, -2, 1, 5, -4 };

		int ans = myApproach(nums);
		System.out.println("MyApproach: O(N^2): \n" + ans);

		int ans1 = optimize(nums);
		System.out.println("Optimize: O(N): \n" + ans1);
	}

	private static int optimize(int[] A) {
		int n = A.length;

		// dp[i] means the maximum sub-array ending with A[i];
		int[] dp = new int[n];

		dp[0] = A[0];

		int max = dp[0];

		/*
		 * maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 +
		 * A[i];
		 */

		for (int i = 1; i < n; i++) {
			// The catch here is that we have to take care of negative value.
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);

			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static int myApproach(int[] nums) {
		int sum = 0;

		for (int val : nums)
			sum += val;

		for (int i = 0; i < nums.length; i++) {
			int newSum = 0;
			for (int j = i; j < nums.length; j++) {
				newSum += nums[j];

				if (sum < newSum)
					sum = newSum;
			}

			if (newSum > sum)
				sum = newSum;
		}

		return sum;
	}

}
