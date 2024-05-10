package _dsa._java._4Dynamic_Programing;

public class C20_Min_No_Of_INSERTION_and_DELETION_From_X_to_Y {
	public static void main(String[] args) {
		String X = "heap";
		String Y = "pea";

		int n = X.length();
		int m = Y.length();

		// We see that.. LCS is 'ea' 
		// and we need to remove 'h' and 'p' from X
		// and insert 'p' in X
		// then X = Y
		
		// so => from X -> LCS -> Y
		// No Deletion = n - LCS
		// No Insertion = m - LCS
		int lcs = LCS(X, Y, n, m);
		int ans = (n - lcs) + (m - lcs);
		
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
