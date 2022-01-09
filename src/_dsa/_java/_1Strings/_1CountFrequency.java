package _dsa._java._1Strings;

public class _1CountFrequency {

	static final int CHAR = 26;

	public static void main(String[] args) {
		String S = "geeksforgeeks";

		int count[] = new int[CHAR];

		for (int i = 0; i < S.length(); i++)
			count[S.charAt(i) - 'a']++;

		for (int i = 0; i < CHAR; i++) {
			if (count[i] > 0) {
				System.out.println((char) (i + 'a') + " " + count[i]);
			}
		}
	}

}
