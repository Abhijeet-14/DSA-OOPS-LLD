package _dsa._java._4Dynamic_Programing;

public class C19_Shortest_Common_SuperSequence {

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";

		int n = a.length();
		int m = b.length();

		// We took only 1 if char present in both 'a' & 'b'
		// G T A B
		// We know that from LCS we take the common out
		// LCS of 'a' & 'b' - GTAB
		// a+b = AGGTABGXTAYB
		// super_sequence = AGGXTXAYB
		// by taking 1-G at a-1 b-0 && by taking 1-T at a-3 & b-2
		// by taking 1-A at a-4 b-4 && by taking 1-B at a-5 & b-6
		// we see that => a + b - super_sequence

		int ans = n + m - LCS(a, b, n, m);

		System.out.println("Tabulation: \n" + ans);
	}

	private static int LCS(String a, String b, int n, int m) {

		int dp[][] = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n][m];
	}

}
