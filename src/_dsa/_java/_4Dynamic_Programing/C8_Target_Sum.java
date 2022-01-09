package _dsa._java._4Dynamic_Programing;

import java.util.*;

public class C8_Target_Sum {

	static int t[][];

	public static void main(String[] args) {
//		int arr[] = { 1, 1, 2, 3 };
		int arr[] = { 1, 1, 1, 1, 1 };
		int target = 3;

		int n = arr.length;

		int sum_of_array = 0;

		for (int val : arr)
			sum_of_array += val;

		int sum = ((Math.abs(target) + sum_of_array) % (1000000000 + 7)) / 2;

		t = new int[n + 1][sum + 1];

		for (int row[] : t)
			Arrays.fill(row, -1);

		int ans = memo(arr, n, sum);
		System.out.println("Memo: \n" + ans);

		int ans1 = tabu(arr, n, sum);
		System.out.println("Tabu: \n" + ans1);
	}

	// MEMOIZATOIN
	public static int memo(int nums[], int n, int sum) {
		if (n == 0 && sum != 0)
			return t[n][sum] = 0;

		if (sum == 0)
			return t[n][sum] = 1;

		if (t[n][sum] != -1)
			return t[n][sum];

		if (nums[n - 1] <= sum)
			return t[n][sum] = memo(nums, n - 1, sum - nums[n - 1]) + memo(nums, n - 1, sum);
		else
			return t[n][sum] = memo(nums, n - 1, sum);
	}

	
	// TABULATION
	public static int tabu(int arr[], int n, int sum) {
		// TABULATION
		int dp[][] = new int[n + 1][sum + 1];

		for (int i = 0; i < sum + 1; i++)
			dp[0][i] = 0;

		for (int j = 0; j < n + 1; j++)
			dp[j][0] = 1;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][sum] % (1000000000 + 7);
	}

	public static void print(int t[][]) {
		for (int row[] : t) {
			for (int val : row)
				System.out.print(val + " ");
			System.out.println();
		}
	}
}
