package _dsa._java._4Dynamic_Programing;

import java.util.Stack;

public class C22_Min_No_Of_Insertion_to_Make_Palindrome {
	
	public static void main(String[] args) {
		String a = "agbcbag";

		// Reverse of a
		String b = "";

		Stack<Character> s = new Stack<>();

		for (char ch : a.toCharArray())
			s.push(ch);

		while (!s.isEmpty())
			b += s.pop();

		int n = a.length();
		int m = b.length();

		// No Insertion -> which is NoT Common 
		int ans = n - LCS(a, b, n, m);

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


