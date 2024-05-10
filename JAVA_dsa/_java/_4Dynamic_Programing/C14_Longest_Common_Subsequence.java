package _dsa._java._4Dynamic_Programing;

public class C14_Longest_Common_Subsequence {

	static int t[][];

	public static void main(String[] args) {
		// In Subsequence letter combination can be DISCONTINOUS
		String a = "abcdefh";
		String b = "abedfcgf";

		t = new int[a.length() + 1][b.length() + 1];

		for (int[] row : t)
			java.util.Arrays.fill(row, -1);

		// Recursion
		int ans = LCS_Rec(a, b, a.length(), b.length());
		System.out.println("Recursive: \n" + ans);

		// Memoization
		int ans1 = LCS_Memo(a, b, a.length(), b.length());
		System.out.println("Memoization: \n" + ans1);

		// Tabulation
		int ans2 = LCS_Tabu(a, b, a.length(), b.length());
		System.out.println("Tabulation: \n" + ans2);
	}

	// RECURSION
	private static int LCS_Rec(String a, String b, int n, int m) {
		// BASE CONDITION
		if (n == 0 || m == 0)
			return 0;
		// CHOICE DIAGRAM
		if (a.charAt(n - 1) == b.charAt(m - 1)) // MATCH
			return 1 + LCS_Rec(a, b, n - 1, m - 1);
		else // NO MATCH
			return Math.max(LCS_Rec(a, b, n - 1, m), LCS_Rec(a, b, n, m - 1));
	}

	// MEMOIZATION
	private static int LCS_Memo(String a, String b, int n, int m) {
		// BASE CONDITION
		if (n == 0 || m == 0)
			return 0;

		if (t[n][m] != -1)
			return t[n][m];

		// CHOICE DIAGRAM
		if (a.charAt(n - 1) == b.charAt(m - 1)) // MATCH
			return t[n][m] = 1 + LCS_Memo(a, b, n - 1, m - 1);
		else // NO MATCH
			return t[n][m] = Math.max(LCS_Memo(a, b, n - 1, m), LCS_Memo(a, b, n, m - 1));
	}

	// TABULATION
	private static int LCS_Tabu(String a, String b, int n, int m) {
		int dp[][] = new int[n + 1][m + 1];

		// INITIALIZATION
		for (int i = 0; i < n + 1; i++)
			dp[i][0] = 0;

		// CODE
		for (int j = 0; j < m + 1; j++)
			dp[0][j] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		return dp[n][m];
	}
}
