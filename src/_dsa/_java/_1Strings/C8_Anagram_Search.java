package _dsa._java._1Strings;

public class C8_Anagram_Search {

	static final int CHAR = 256;

	public static void main(String[] args) {
		String text = "geeksforgeeks";
		String patt = "frog";

		// frog and forg matches... just need to be continuous, arrangement can of any
		// order.

		System.out.println("Naive: Time: O((n-m+1)*m)");
		anagramSearch(text, patt);

		System.out.println("\nEfficient: Time: O(m + (n-m)*char) => O(n*CHAR)");
		boolean val = efficient(text, patt);
		System.out.println(val);
	}

	private static boolean efficient(String text, String patt) {

		int n = text.length();
		int m = patt.length();

		int chrT[] = new int[CHAR];
		int chrP[] = new int[CHAR];

		// TIME: O(m)
		for (int i = 0; i < patt.length(); i++) {
			chrT[text.charAt(i)]++;
			chrP[patt.charAt(i)]++;
		}

		// TIME: O(n-m)
		for (int i = m; i < n; i++) {
			
			// Time: O(CHAR)
			// CHECK if TWO character list are same.. means.. both words are equal
			if (areSame(chrT, chrP) == true)
				return true;

			// SLIDE WINDOW
			// add the next character in text-substring
			chrT[text.charAt(i)]++;
			// remove the first character of text-substring
			chrT[text.charAt(i - m)]--;
		}

		return false;
	}

	private static boolean areSame(int[] chrT, int[] chrP) {
		for (int i = 0; i < CHAR; i++) {
			if (chrT[i] != chrP[i]) {
				return false;
			}
		}
		return true;
	}

	public static void anagramSearch(String text, String patt) {
		int n = text.length();
		int m = patt.length();
		for (int i = 0; i < n - m + 1; i++) {
			if (areAnagram(text.substring(i, i + m), patt) == true) {
				System.out.println(text.substring(i, i + m) + " YES! " + patt);
				return;
			}
		}

		System.out.println("No!!");
	}

	public static boolean areAnagram(String word1, String word2) {
		int arr[] = new int[256];

		if (word1.length() != word2.length())
			return false;

		for (int i = 0; i < word1.length(); i++) {
			arr[word1.charAt(i)]++;
			arr[word2.charAt(i)]--;
		}

		for (int i = 0; i < 256; i++) {
			if (arr[i] > 0)
				return false;
		}

		return true;
	}

}
