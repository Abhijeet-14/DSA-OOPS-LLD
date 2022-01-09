package _dsa._java._4Dynamic_Programing;

public class C12_Coin_Change_Min_Ways {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 7};
		
		int m = 12;
		
		int n = arr.length;
		
		int min_no_of_coins = solve(arr, m, n);
		System.out.println("Memoization: \n" + min_no_of_coins);
	}
	
	private static int solve(int[] arr, int m, int n) {
		int[][] t = new int[n+1][m+1];
	
		// INITIALIZATION
		for(int i=0; i<n+1; i++)
			t[i][0] = 0;
		
		for(int i=0; i<m+1; i++)
			t[0][i] = Integer.MAX_VALUE - 1;
		
		// 1st ROW - INITIALIZE
			// sum = 4 coin = [3] => no subset except {}.. which is INFINITE time
		for(int i=1; i<m+1; i++) {
			if(i%arr[0] == 0)	// sum = 6 coin = [3] => 3 times 3 coin
				t[1][i] = i/arr[0];
			else
				t[1][i] = Integer.MAX_VALUE - 1;
		}
		
		for(int i=2; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				
				if(arr[i-1] <= j)
					t[i][j] = Math.min(1 + t[i][j-arr[i-1]], t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][m];
	}
}
