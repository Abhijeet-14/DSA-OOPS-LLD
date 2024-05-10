package _dsa._java._4Dynamic_Programing;

public class C11_Coin_Change_Max_No_of_Ways {
	
	static int t[][];

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 6};
		
		int sum = 12;
		
		int n = arr.length;
		
		t = new int[n+1][sum+1];
		
		for(int row[]: t)
			java.util.Arrays.fill(row, -1);
		
		int noOfWays = solve(arr, sum, n);
		System.out.println("Memoization: \n" + noOfWays);

	}

	private static int solve(int[] arr, int sum, int n) {
		if(n==0 && sum != 0)
			return 0;
		
		if(sum == 0)
			return 1;	// 0-coin
		
		if(arr[n-1]<=sum)
			return t[n][sum] = solve(arr, sum - arr[n-1], n) + solve(arr, sum, n-1);
		
		return solve(arr, sum, n-1);
	}

}
