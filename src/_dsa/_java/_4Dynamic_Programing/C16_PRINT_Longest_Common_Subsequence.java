package _dsa._java._4Dynamic_Programing;

import java.util.*;

public class C16_PRINT_Longest_Common_Subsequence {

	public static void main(String[] args) {
		// In Subsequence letter combination can be DISCONTINOUS
		String a = "abcdxyz";
		String b = "xyzabcd";

		String ans = printLCS(a, b, a.length(), b.length());

		System.out.println("Tabulation: \n" + ans);
	}

	private static String printLCS(String a, String b, int n, int m) {
		int dp[][] = LCS(a, b, n, m);
		
		Stack<Character> s = new Stack<>();
		
		int i= n;
		int j =m;
		
		while(i>0 && j>0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				s.add(a.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(dp[i][j-1] > dp[i-1][j])
					j--;
				else
					i--;
			}
		}
		
		String ans = "";
		
		while(!s.isEmpty()) {
			ans += s.pop();
		}
		
		return ans;
	}

	private static int[][] LCS(String a, String b, int n, int m) {
		// First we built LCS - max no of ways
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp;
	}

}
