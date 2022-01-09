package _dsa._java._1Strings;

public class C2_PalindromeCheck {

	public static void main(String[] args) {

		String S = "ABCBA";

		// Time: O(n), Aux Space: O(n);
		boolean ans1 = naive(S);

		// Time: O(n), Aux Space: O(1);
		boolean ans2 = efficient(S);

		System.out.println(ans1);
		System.out.println(ans2);
	}

	static boolean naive(String S) {
		StringBuilder rev = new StringBuilder(S);

		rev.reverse();

		return S.equals(rev.toString());
	}

	static boolean efficient(String S) {
		int start = 0;
		int end = S.length() - 1;

		while (start < end) {
			if (S.charAt(start) != S.charAt(end))
				return false;

			start++;
			end--;
		}

		return true;
	}

}
