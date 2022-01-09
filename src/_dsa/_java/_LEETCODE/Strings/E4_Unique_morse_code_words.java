package _dsa._java._LEETCODE.Strings;

// Question: https://leetcode.com/problems/unique-morse-code-words/

// Resolved: QUIT!


import java.util.HashSet;
import java.util.Set;

public class E4_Unique_morse_code_words {

	public static void main(String[] args) {
		String words[] = {"gin", "zen", "gig"};
		System.out.println(uniqueMorseRepresentations(words));

	}

	public static int uniqueMorseRepresentations(String[] words) {

		if (words.length <= 1)
			return words.length;

		String morse[] = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };

		Set<String> seen = new HashSet<>();

		for (String word : words) {
			StringBuilder newCode = new StringBuilder();

			for (char c : word.toCharArray())
				newCode.append(morse[c - 'a']);

			seen.add(newCode.toString());
		}

		return seen.size();

	}
}
