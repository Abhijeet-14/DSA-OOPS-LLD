package _dsa._java._5BACKTRACKING;

public class C1_Recursion {

	public static void main(String[] args) {

		String str = "ABC";
		int n = str.length();

		permute(str, 0, n - 1);
	}

	private static void permute(String str, int l, int r) {
		// check if current permutation is valid
		if (l == r) {
			// if current contain "AB" or NOT
			if (!str.contains("AB"))
				System.out.println(str);
			return;
		}

		// Recursively generate all permutation
		for (int i = l; i <= r; i++) {
			// swap & re-store to str
			str = swap(str, i, l);

			permute(str, l + 1, r);

			str = swap(str, i, l);
		}
	}

	private static String swap(String str, int i, int l) {
		char temp;
		// we can't change string directly
		// so
		// converting String to CHARACTER ARRAY
		char[] charArray = str.toCharArray();

		// swap the i & l character
		temp = charArray[i];
		charArray[i] = charArray[l];
		charArray[l] = temp;

		// valueOf returns STRING representation of CHAR array
		return String.valueOf(charArray);
	}

}
