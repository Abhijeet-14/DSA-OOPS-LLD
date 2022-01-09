package _dsa._java._1Strings;

import java.util.Arrays;

public class C3_AnagramCheck {

	static final int CHAR = 256;

	public static void main(String[] args) {

		String S1 = "silent";
		String S2 = "listen";

		// Time: O(nlgn) Aux Space: O(n)
		boolean ans1 = naive(S1, S2);

		// Time: O(n + CHAR) -> O(n) Aux Space: O(CHAR) -> O(1)
		boolean ans2 = efficient(S1, S2);

		System.out.println(ans1);
		System.out.println(ans2);
	}

	static boolean naive(String S1, String S2) {
		if (S1.length() != S2.length())
			return false;

		// Sort S1
		char a1[] = S1.toCharArray();
		Arrays.sort(a1);
		S1 = new String(a1);

		// Sort S2
		char a2[] = S2.toCharArray();
		Arrays.sort(a2);
		S2 = new String(a2);

		return S1.equals(S2);
	}

	static boolean efficient(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int count[] = new int[CHAR];

		// increment s1
		// decrement s2
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}

		// check for all 0's
		for (int i = 0; i < CHAR; i++)
			if (count[i] != 0)
				return false;

		return true;
	}

}
