package _dsa._java._4Dynamic_Programing;

public class C15_Longest_Common_SUBSTRING {

	public static void main(String[] args) {
		// In Sub-String letter combination must be CONTINOUS
		String a = "abcdxyz";
		String b = "xyzabcd";

		// Recursion
		System.out.println("Recursion: " + "DOESN'T WORK, BCOZ when character NOT equal... "
				+ "whole code break at that point \n");

		// Memoization
		System.out.println("Memoization: " + "DOESN'T WORK, BCOZ when character NOT equal... "
				+ "whole code break at that point \n");

		// Tabulation
		int ans2 = LC_SUBSTRING_Tabu(a, b, a.length(), b.length());
		System.out.println("Tabulation: \n" + ans2);
	}

	// TABULATION
	private static int LC_SUBSTRING_Tabu(String a, String b, int n, int m) {
		int dp[][] = new int[n + 1][m + 1];

		int res = 0;
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;

				else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					if (dp[i][j] > res)
						res = dp[i][j];
				} else
					dp[i][j] = 0;
			}
		}
		return res;
	}

}
