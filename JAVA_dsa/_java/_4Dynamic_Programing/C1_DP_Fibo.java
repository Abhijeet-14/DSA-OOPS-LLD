package _dsa._java._4Dynamic_Programing;

public class C1_DP_Fibo {

	public static void main(String[] args) {
		int n = 5;
		
		int ans_rec = fibo_rec(n);
		System.out.println("Recursive: " + ans_rec);

		int t[] = new int[n+1];
		int ans_memo = fibo_memo(n, t);
		System.out.println("Memoization: " + ans_memo);
		
		int ans_tabulation = fibo_tabulation(n);
		System.out.println("Tabulation: " + ans_tabulation);
	}


	private static int fibo_rec(int n) {
		if(n == 0 || n==1)
			return n;
		
		return fibo_rec(n-1) + fibo_rec(n-2);
	}

	
	private static int fibo_memo(int n, int t[]) {
		if(n<=1)
			return n;
		
		if(t[n] != 0)
			return t[n];
		
		return t[n] = fibo_memo(n-1, t) + fibo_memo(n-2, t);
	}
	
	
	private static int fibo_tabulation(int n) {
		int dp[] = new int[n+1];
		
		for(int i=0; i<n+1; i++) {
			if(i<=1)
				dp[i] = i;
			else
				dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
