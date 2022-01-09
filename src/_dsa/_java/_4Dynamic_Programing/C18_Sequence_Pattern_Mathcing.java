package _dsa._java._4Dynamic_Programing;

public class C18_Sequence_Pattern_Mathcing {

	public static void main(String[] args) {
		// Here b/w a & b
		// Common subsequence == a
		// we will only check a.length == common subsequence
		// It is sufficient... but not right
		// There is chance that ... common subsequence (abc) == a(axy) 
		// .. But this condition is rare
		
		String A ="AXY";
		String B ="ADXCPY";
		
		int val = LCS(A, B, A.length(), B.length());
		
		boolean ans = val == A.length() ? true : false;
		
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
