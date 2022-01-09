package _dsa._java._LEETCODE.Strings;

// Question: https://leetcode.com/problems/split-a-string-in-balanced-strings/

// Response: Solved

public class E1_Split_a_String_in_Balanced_String {

	public static void main(String[] args) {
		String s ="RLRRLLRLRL";
		System.out.println(balancedStringSplit(s));
	}

	public static int balancedStringSplit(String s) {
		int count = 0;
		int balanced = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R')
				count++;
			else
				count--;

			if (count == 0)
				balanced++;
		}
		return balanced;
	}
}
