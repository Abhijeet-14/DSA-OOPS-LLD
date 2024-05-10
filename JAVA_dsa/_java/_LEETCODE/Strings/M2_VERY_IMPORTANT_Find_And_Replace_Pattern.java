package _dsa._java._LEETCODE.Strings;
import java.util.*;

/*
 * Question: https://leetcode.com/problems/find-and-replace-pattern/
 * 
 * RESPONSE: Concept is V.V.I.
 * 
 */
public class M2_VERY_IMPORTANT_Find_And_Replace_Pattern {

	// In this we assign the character id.. 
	// If at 0th position -> 1 and if at 2nd position -> 3.
	// If character repeats => then give it previous id of same character..
	// pattern_ID == word_ID .. then word is permutation of Pattern
	public static void main(String[] args) {
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		
		List<String> ans = findAndReplacePattern(words, pattern);
		
		for(String word: ans) {
			System.out.println(word);
		}
	}

	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		String patternId = getId(pattern);

		List<String> result = new LinkedList<>();
		for (String word : words) {
			String word_ID = getId(word);
			if (word_ID.equals(patternId)) {
				result.add(word);
			}
		}

		return result;
	}

	private static String getId(String str) {
		StringBuilder builder = new StringBuilder();
		int id = 1;

		int[] map = new int[26];
		for (char ch : str.toCharArray()) {
			int digit = ch - 'a';
			if (map[digit] == 0) {
				map[digit] = id++;
			}

			builder.append(map[digit]);
		}

		return builder.toString();
	}
}
