package _dsa._java._1Strings;

public class C6_Pattern_Searching_Naive {

	public static void main(String[] args) {

		String text = "ABCABCD";
		String patt = "ABCD";

		System.out.println("Time: O((n-m+1)*m)");
		naive(text, patt);
	}

	private static void naive(String text, String patt) {
		int n = text.length();
		int m = patt.length();

		for (int i = 0; i < n - m + 1; i++) {
			// boolean flag = true;
			int j;
			for (j = 0; j < m; j++) {
				if (text.charAt(i + j) != patt.charAt(j)) {
					// flag = false;
					break;
				}
			}
			// if(flag == true)
			// System.out.print( i + " ");
			if (j == m)
				System.out.print(i + " ");
		}
	}

}
