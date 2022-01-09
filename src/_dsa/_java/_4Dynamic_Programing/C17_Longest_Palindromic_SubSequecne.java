package _dsa._java._4Dynamic_Programing;

public class C17_Longest_Palindromic_SubSequecne {

	public static void main(String[] args) {
		String a = "agbcba";
		// We don't have 'b' here..
		// we will reverse 'a' and use it as b

		// REVERSE a;
		String b = "";

		char[] temp = a.toCharArray();

		for (int i = temp.length - 1; i >= 0; i--)
			b += temp[i];

		int ans = longest_palindromic_subsequence(a, b, a.length(), b.length());

		System.out.println("Tabulation: \n" + ans);
	}

	private static int longest_palindromic_subsequence(String a, String b, int n, int m) {

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
