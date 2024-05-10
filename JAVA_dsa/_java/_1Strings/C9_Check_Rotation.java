package _dsa._java._1Strings;

public class C9_Check_Rotation {

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "CDAB";

		System.out.println("TIME: O(n^2)");
		naive(s1, s2);

//		System.out.println("TIME: O(n)");
//		efficient(s1, s2);

		System.out.println((s1+s1).contains(s2));
	}

	private static void naive(String s1, String s2) {
		if (s1.length() != s2.length()) {
			System.out.println("No!!");
			return;
			
		}

		for (int i = 0; i < 2 * s1.length(); i++) {
			int j;
			for (j = 0; j < s2.length(); j++) {
				int s1_index = (i + j) % s1.length();
				if (s1.charAt(s1_index) != s2.charAt(j)) {
					break;
				}
			}
			if (j == s2.length()) {
				System.out.println("Yes!!: " + s1.substring(i, s1.length()) + s1.substring(0, i));
				return;
			}
		}
		System.out.println("No!!");
	}

	private static void efficient_2 (String s1, String s2) {

		String str = s1+s1;

		System.out.println("Result: " + str.contains(s2));
	}
	private static void efficient(String s1, String s2) {
		if (s1.length() != s2.length()) {
			System.out.println("No!!");
			return;
		}

		String newStr = "";
		for (int i = 0; i < s1.length(); i++) {
			String curr = s1.substring(i, s1.length()) + newStr;

			if (curr.equals(s2)) {
				System.out.println("Yes!!");
				return;
			}
			newStr += s1.charAt(i);
		}

		System.out.println("No!!");
	}
}
