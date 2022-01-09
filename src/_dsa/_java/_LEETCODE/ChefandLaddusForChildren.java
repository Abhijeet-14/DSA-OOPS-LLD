package _dsa._java._LEETCODE;

import java.util.*;

public class ChefandLaddusForChildren {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];

			int mxx = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				if (mxx < arr[i]) {
					mxx = arr[i];
				}
			}

			int mx = maxSubset(n, k, arr, mxx);
			int mn = minSubset(n, k, arr, mxx);
			System.out.println("mx: " + mx);
			System.out.println("mn: " + mn);
			System.out.println("diff: " + (mx - mn));
		}
	}

	static int diff(int n, int k, int arr[], int sum) {
		return Math.min(maxSubset(n, k, arr, sum), minSubset(n, k, arr, sum));

	}

	static int maxSubset(int n, int k, int arr[], int sum) {
		if (k <= 1 || n <= 1)
			return 0;

		if (arr[n - 1] <= sum)
			return sum + Math.max(maxSubset(n - 1, k - 1, arr, sum - arr[n - 1]), maxSubset(n - 1, k - 1, arr, sum));
		else
			return maxSubset(n - 1, k - 1, arr, sum);
	}

	static int minSubset(int n, int k, int arr[], int sum) {
		if (k <= 1 || n <= 1)
			return 0;

		if (arr[n - 1] <= sum)
			return sum + Math.min(minSubset(n - 1, k - 1, arr, sum - arr[n - 1]), minSubset(n - 1, k - 1, arr, sum));
		else
			return minSubset(n - 1, k - 1, arr, sum);
	}
}
