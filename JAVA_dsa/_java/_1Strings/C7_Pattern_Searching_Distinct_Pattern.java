package _dsa._java._1Strings;

public class C7_Pattern_Searching_Distinct_Pattern {

	public static void main(String[] args) {
		String text = "ABCABCD";
		String patt = "ABCD";

		// Time - O(n)
		System.out.println("Time: O(n)");
		distinct_naive(text, patt);
	}

	private static void distinct_naive(String text, String patt) {
		int n = text.length();
		int m = patt.length();

		for (int i = 0; i < n - m + 1;) {
			int j;
			for (j = 0; j < m; j++) {
				if (text.charAt(i + j) != patt.charAt(j))
					break;
			}

			if (j == m)
				System.out.print(i + " ");
			if (j == 0) {
				i++;
			} else
				i += j;
			

		}
	}

}
