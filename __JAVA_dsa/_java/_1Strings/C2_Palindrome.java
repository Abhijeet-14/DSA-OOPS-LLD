package _dsa._java._1Strings;

public class C2_Palindrome {

	public static void main(String[] args) {

		String str = "ABCBE";

		System.out.println("Check for Palindrome: ");

		boolean res1 = naive(str);

		boolean res2 = efficient(str);

		System.out.println("O(n) & O(n): " + res1);
		System.out.println("O(n) & O(1): " + res2);
	}

	public static boolean naive(String str) {
		StringBuilder rev = new StringBuilder(str);

		rev.reverse();

		return str.equals(rev.toString());
	}

	public static boolean efficient(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}

}
