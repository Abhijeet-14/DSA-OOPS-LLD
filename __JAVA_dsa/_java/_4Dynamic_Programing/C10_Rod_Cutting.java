package _dsa._java._4Dynamic_Programing;

public class C10_Rod_Cutting {

	static int t[][];
	public static void main(String[] args) {
		int length[] = {1,2,3,4,5,6,7,8};
		int price[] = {1,5,8,9,10,17,17,20};
		
		int N = 8;
		
		int n = length.length;
		t = new int[n+1][N+1];
		
		for(int row[]: t)
			java.util.Arrays.fill(row, -1);
		
		int maxProfit = solve(length, price, N, n);
		System.out.println("Memoization: \n" + maxProfit);
	}
	private static int solve(int[] length, int[] price, int N, int n) {
		if(N == 0 || n == 0)
			return 0;
		
		if(t[n][N] != -1)
			return t[n][N];
		
		if(length[n-1]<=N)
			return t[n][N] = Math.max(price[n-1] + solve(length, price, N-length[n-1], n), solve(length, price, N, n-1));
		
		return t[n][N] = solve(length, price, N, n-1);
	}

}
