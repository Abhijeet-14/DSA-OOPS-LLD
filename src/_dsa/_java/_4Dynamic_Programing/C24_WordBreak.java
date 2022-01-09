package _dsa._java._4Dynamic_Programing;

import java.util.*;

public class C24_WordBreak {

	static Map<String, Boolean> map = new HashMap<>();

	public static void main(String[] args) {
		String s = "catsandog";

		String a[] = { "cats", "dog", "sand", "and", "cat", "og" };

		List<String> wordDict = new ArrayList<>();

		for (String word : a)
			wordDict.add(word);

		boolean ans = wordBreak_rec(s, wordDict);
		System.out.println(ans);

		boolean ans1 = wordBreak_memo(s, wordDict);
		System.out.println(ans1);
	}

	public static boolean wordBreak_memo(String s, List<String> wordDict) {
		if (wordDict.contains(s))
			return true;

		if (map.containsKey(s))
			return map.get(s);
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left) && wordBreak_memo(s.substring(i), wordDict)) {
				map.put(s, true);
				return true;
			}
		}

		map.put(s, false);
		return false;
	}

	public static boolean wordBreak_rec(String s, List<String> wordDict) {
		if (wordDict.contains(s))
			return true;
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left) && wordBreak_rec(s.substring(i), wordDict)) {
				return true;
			}
		}
		return false;
	}

}
