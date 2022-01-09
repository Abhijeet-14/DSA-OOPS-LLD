/**
 * 
 */
package _dsa._java._4Dynamic_Programing;

public class C9_Unbounded_Knapsack {
	
	public static void main(String[] args) {
		int wt[] = {5, 10, 15};
		int val[] = {10, 30, 20};
		int W = 30;
		
		int n = wt.length;
		
		int t[][] = new int[n+1][W+1];
		
		for(int row[]: t)
			java.util.Arrays.fill(row, -1);
		
		int maxProfit = solve(wt, val, W, n, t);
		System.out.println("Memoization: \n" + maxProfit);
	}

	private static int solve(int[] wt, int[] val, int W, int n, int t[][]) {
		if(n==0 || W==0)
			return 0;
		
		if(t[n][W] != -1)
			return t[n][W];
		
		if(wt[n-1]<=W)
			return t[n][W] = Math.max(val[n-1] + solve(wt, val, W-wt[n-1], n, t), solve(wt, val, W, n-1, t));
			
		return t[n][W] = solve(wt, val, W, n-1, t); 
	}

}
