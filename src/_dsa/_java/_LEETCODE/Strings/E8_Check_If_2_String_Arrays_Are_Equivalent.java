package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/submissions/
 * 
 * Response: SOLVED (73% fater)
 * 
 * */

public class E8_Check_If_2_String_Arrays_Are_Equivalent {

	public static void main(String[] args) {
		 String word1[] = {"a", "cb"}, word2 []= {"ab", "c"};
		 
		 System.out.println("MyApproach O(N): 97%");
		 boolean ans = myApproach_1(word1, word2);
		 System.out.println(ans);
	}

	public static boolean myApproach_1(String[] word1, String[] word2) {
		String first = "";
		for (String word : word1) {
			first += word;
		}

		String second = "";
		for (String word : word2) {
			second += word;
		}

		return first.equals(second);

	}

}
