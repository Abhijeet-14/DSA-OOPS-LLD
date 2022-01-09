package _dsa._java._1Strings;

public class C5_LeftMostNonRepeatingCharacter {

	public static void main(String[] args) {

		String str = "abcdbcad";

		naive(str);

		efficient_2loop(str);

		efficient_1loop(str);
	}

	private static void efficient_1loop(String str) {
		int arr[] = new int[256];
		int val = -1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (arr[str.charAt(i)] == 0) {
				val = i;
			}
			arr[str.charAt(i)]++;
		}

		if (arr[str.charAt(val)] == 1)
			System.out.println(val);
		else
			System.out.println(-1);
	}

	private static void efficient_2loop(String str) {
		int arr[] = new int[256];

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)]++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i)] == 1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

	private static void naive(String str) {

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count == 0) {
				System.out.println(i);
				return;
			}
			count = 0;
		}
	}

}
