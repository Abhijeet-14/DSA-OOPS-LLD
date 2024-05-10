package _dsa._java._4Dynamic_Programing;

public class C2_M_0_1_Knapsack {
	static void initialize(int t[][], int n, int W) {
		for(int i=0; i<n+1 ; i++) {
			for(int j=0; j<W+1 ; j++) {
				t[i][j] = -1;
			}
		}
	}
	
	static int knapsack_M( int t[][], int wt[], int val[], int W, int n) {
		if(n==0 || W == 0)
			return 0;
	
		// check the value in Matrix
		if(t[n][W] != -1)
			return t[n][W];
		
		if(wt[n-1] <= W) { 
				t[n][W] = Math.max(
								val[n-1] + knapsack_M(t, wt, val, W-wt[n-1], n-1), 
								knapsack_M( t, wt, val, W, n-1)
							);
				return t[n][W];
		}
		
		else {
			t[n][W] = knapsack_M( t, wt, val, W, n-1);
			return t[n][W];
		}
		
	}
	
	public static void main(String[] args) {
		int wt[] = {1,3,4,5};
		int val[] = {1,4,5,7};
		
		int W = 9;
		
		int n = wt.length;
		
		// Matrix to Store the Value:
		int t[][] = new int[n+1][W+1];
		
		// Initialize t[][]
		initialize(t, n, W);
		
		System.out.println(knapsack_M( t, wt, val, W, n));
		
	}
}
