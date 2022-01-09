package _dsa._java._LEETCODE.Dynamic_Programing;

/*
 * Question: https://leetcode.com/problems/climbing-stairs/submissions/
 * 
 * Response: SOlved by BRUTE-FORCE... needs optimization
 * 
 * Optimization: Recursion + Memoization
 */
public class E5_Climbing_Stairs {

	public static void main(String[] args) {
		int ans = myApproach(10);
		System.out.println("MyApproach: TLE O(2^n): \n" + ans);
		
		int ans1 = myApproach(10);
		System.out.println("\nOptmize: O(n) 100% \n" + ans1);
	}

	static int count = 0;
	static int t[];

	public static int myApproach(int n) {
		if (n == 0)
			return 0;

		t = new int[n + 1];

		return my_solve(0, n);
	}
	
	public static int my_solve(int i, int n) {
		if (i > n)
			return 0;
		
		if (i == n)
			return 1;
		
		return my_solve(i + 1, n) + my_solve(i + 2, n);
	}
	
	
	public static int optmize(int n) {
		if (n == 0)
			return 0;
		
		t = new int[n + 1];
		
		return op_solve(0, n);
	}

	public static int op_solve(int i, int n) {
		if (i > n)
			return 0;
		
		if (i == n)
			return 1;
		
		if (t[i] > 0)
			return t[i];
		
		t[i] = op_solve(i + 1, n) + op_solve(i + 2, n);
		return t[i];
	}

}
