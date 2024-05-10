package _dsa._java._LEETCODE.Strings;

import java.util.*;

public class M5_Letter_Combinations_Of_A_Phone_Number {

	static String a[] = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {

		List<String> words = letterCombinations("79");

		System.out.print("[ ");

		for (String word : words)
			System.out.print(word + ", ");

		System.out.print("] \n\n");

		List<String> words1 = anotherSolution("79");

		System.out.print("Another Solution: \n[");
		for (String word : words1)
			System.out.print(word + ", ");
		System.out.print("] \n\n");
	}

	private static List<String> anotherSolution(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();

		List<String> res = new ArrayList<>();

		Queue<String> q = new LinkedList<>();

		q.add("");

		while (!q.isEmpty()) {
			String str = q.poll();

			if (str.length() == digits.length())
				res.add(str);

			else {
				int n = str.length();

				int idx = Character.getNumericValue(digits.charAt(n)) - 2;

				for (char ch : a[idx].toCharArray())
					q.add(str + ch);
			}
		}

		return res;
	}

	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();

		List<String> combi = new ArrayList<>();

		String word = "";

		int next = 0;
		int in = Character.getNumericValue(digits.charAt(next)) - 2;

		for (int i = 0; i < a[in].length(); i++)
			dfs(combi, digits, word, i, next, in);

		return combi;
	}

	public static void dfs(List<String> combi, String digits, String word, int count, int next, int in) {

		char val = a[in].charAt(count);
		word += val;

		if (word.length() == digits.length()) {
			combi.add(word);
			return;
		}

		next++;
		in = Character.getNumericValue(digits.charAt(next)) - 2;

		for (int i = 0; i < a[in].length(); i++)
			dfs(combi, digits, word, i, next, in);

	}

}
