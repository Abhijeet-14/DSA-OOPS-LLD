package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/count-the-number-of-consistent-strings/submissions/
 * 
 * Response: SOlved, But OPTIMIZE solution is BEST.
 * */
public class E7_Count_The_Number_Of_Consistent_Strings {

	public static void main(String[] args) {
		System.out.println("Optimized solution is BEST, do check it out.\n");
		
		String allowed = "ab", words[] = { "ad", "bd", "aaab", "baa", "badab" };

		System.out.print("Only 18% faster!=> ");
		int ans1 = myApproach_1(allowed, words);
		System.out.println(ans1);

		System.out.print("Only 22% faster!=> ");
		int ans2 = myApproach_1(allowed, words);
		System.out.println(ans2);

		System.out.print("Optimized: 98% faster!, Wonderful!!");
		int ans3 = optimized_sol(allowed, words);
		System.out.println(ans3);

	}

	public static int optimized_sol(String allowed, String[] words) {
		int[] allowedArr = new int[26];
		for (char ch : allowed.toCharArray()) {
			allowedArr[ch - 'a'] = 1;
		}

		int count = 0;
		for (String word : words) {
			boolean c = true;
			for (char ch : word.toCharArray()) {
				if (allowedArr[ch - 'a'] == 0) {
					c = false;
					break;
				}
			}

			if (c)
				count++;
		}

		return count;
	}

	public static int myApproach_1(String allowed, String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			String curr = words[i];

			boolean flag = false;
			for (int j = 0; j < curr.length(); j++) {
				for (int k = 0; k < allowed.length(); k++) {
					if (curr.charAt(j) != allowed.charAt(k))
						flag = true;
					else {
						flag = false;
						break;
					}
				}
				if (flag == true)
					break;

			}
			if (!flag)
				count++;
		}

		return count;
	}

	public static int myApproach_2(String allowed, String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			String curr = words[i];

			boolean flag = true;
			int arr[] = new int[26];

			for (int j = 0; j < curr.length(); j++) {
				arr[curr.charAt(j) - 'a']++;
			}

			for (int j = 0; j < allowed.length(); j++) {
				int index = allowed.charAt(j) - 'a';
				arr[index] -= arr[index];
			}

			for (int k = 0; k < 26; k++) {
				if (arr[k] > 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				count++;
		}

		return count;
	}

}
