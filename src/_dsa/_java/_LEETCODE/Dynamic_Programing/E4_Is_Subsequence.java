package _dsa._java._LEETCODE.Dynamic_Programing;

import java.util.*;

/*
 * Question: https://leetcode.com/problems/is-subsequence/
 * 
 * Response: UNSOLVED
 */
public class E4_Is_Subsequence {

	static int[][] dp;

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";

		boolean ans = isSubsequence(s, t);
		System.out.println("UNSOLVED: dp-memo \n" + ans + "\n");

		boolean ans2 = optimize(s, t);
		System.out.println("Optimize: 80% O(n) \n" + ans2 + "\n");
	}

	private static boolean optimize(String s, String t) {
		if (s.length() == 0)
			return true;
		int indexS = 0, indexT = 0;
		while (indexT < t.length()) {
			if (t.charAt(indexT) == s.charAt(indexS)) {
				indexS++;
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		return false;
	}

	public static boolean isSubsequence(String s, String t) {
		if (t.length() < s.length())
			return false;

		dp = new int[s.length() + 1][t.length() + 1];

		// Initialize
		for (int[] row : dp)
			Arrays.fill(row, -1);

		int len = solve(s, t, s.length(), t.length(), t.length() - 1);

		return len == s.length() ? true : false;
	}

	public static int solve(String s, String t, int n, int m, int last) {
		if (n == 0 || m == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (s.charAt(n - 1) == t.charAt(m - 1))
			return dp[n][m] = 1 + solve(s, t, n - 1, m - 1, n - 1);

		return dp[n][m] = Math.max(solve(s, t, n, m - 1, m - 1), solve(s, t, n - 1, m, m));
	}

}
