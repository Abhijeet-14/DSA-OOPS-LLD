package _dsa._java._4Dynamic_Programing;

public class C2__R_0_1_Knapsack {

	static int knapsack_R( int wt[], int val[], int W, int n) {
		if(n==0 || W == 0)
			return 0;
		
		if(wt[n-1] <= W) 
			return Math.max(val[n-1] + knapsack_R(wt, val, W-wt[n-1], n-1), knapsack_R(wt, val, W, n-1));
		
		else
			return knapsack_R(wt, val, W, n-1);
		
	}
	
	public static void main(String[] args) {
		int wt[] = {1,3,4,5};
		int val[] = {1,4,5,2};
		
		int W = 7;
		
		int n = wt.length;
		
		System.out.println(knapsack_R(wt, val, W, n));
		
	}

}
