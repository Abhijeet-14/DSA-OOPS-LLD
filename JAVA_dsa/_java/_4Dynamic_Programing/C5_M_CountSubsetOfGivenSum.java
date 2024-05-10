package _dsa._java._4Dynamic_Programing;

import java.util.Arrays;

public class C5_M_CountSubsetOfGivenSum {

	static int countSubsetSum(int t[][], int arr[], int sum, int n) {
		// CODE
		if (n == 0 && sum != 0)
			return t[n][sum] = 0;

		if (sum == 0)
			return t[n][sum] = 1;

		if(t[n][sum] != -1)
			return t[n][sum];
		else {
			if (arr[n - 1] <= sum)
				return t[n][sum] = countSubsetSum(t, arr, sum - arr[n - 1], n - 1) + countSubsetSum(t, arr, sum, n - 1);

			return t[n][sum] = countSubsetSum(t, arr, sum, n - 1);
		}

	}

	public static void main(String[] args) {
		int arr[] = { 2, 3,7,8,10 };
		int sum = 11;

		int n = arr.length;

		int t[][] = new int[n + 1][sum + 1];

		// INITIALIZE
		for (int row[] : t)
			Arrays.fill(row, -1);

		int ans = countSubsetSum(t, arr, sum, n);

		printTable(t);
		System.out.println("Answer: " + ans);
	}

	public static void printTable(int[][] t) {
		System.out.println("Print Table");
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

}
