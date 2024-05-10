package _dsa._java._4Dynamic_Programing;

public class C7_Count_No_Of_Subset_With_Given_Difference {

	public static void main(String[] args) {
//		int arr[] = { 1, 1, 2, 3 };
//		int diff = 1;
		
		int arr[] = { 5,2,9,6};
		int diff = 4;
		
		int n = arr.length;

		int sum_of_array = 0;
		for (int val : arr)
			sum_of_array += val;

		// S1-S2= Difference
		// S1+S2= Sum of Array

		// S1 = (Difference + Sum Of Array)/2

		int newSum = (diff + sum_of_array) / 2;

		int t[][] = new int[n + 1][newSum + 1];
		int ans = memoization(arr, n, newSum, t);
		System.out.println("Memoization: \n" + ans);
		
		int ansT = tabulation(arr, n, newSum);
		System.out.println("Tabulation: \n" + ansT);
	}

	private static int tabulation(int[] arr, int n, int sum) {
		int dp[][] = new int[n+1][sum+1];
		
		// Initialization
		for(int j=0; j<sum+1; j++)
			dp[0][j] = 0; // n = 0;
		
		for(int i=0; i<n+1; i++)
			dp[i][0] = 1;	// sum = 0
		
		
		// Code
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				
				if(arr[i-1]<=j)
					dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
				else 
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}

	private static int memoization(int[] arr, int n, int sum, int t[][]) {
		if (n == 0 && sum != 0)
			return 0;

		if (sum == 0)
			return 1;

		if (arr[n - 1] <= sum)
			return t[n][sum] = memoization(arr, n - 1, sum - arr[n - 1], t) + memoization(arr, n - 1, sum, t);

		return t[n][sum] = memoization(arr, n - 1, sum, t);
	}

}
