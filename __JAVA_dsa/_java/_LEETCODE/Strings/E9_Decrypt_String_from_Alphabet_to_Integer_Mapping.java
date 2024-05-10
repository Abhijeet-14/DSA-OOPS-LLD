package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * 
 * Response: Solved,
 * 
 * OPTIMIZATION required.
 * */
public class E9_Decrypt_String_from_Alphabet_to_Integer_Mapping {

	public static void main(String[] args) {
		String  s = "10#11#12";
		
		myApproach_1(s);
	}

	public static  void myApproach_1(String s) {
		String ans = "";
		for (int i = 0; i < s.length();) {
			if (i + 2 > s.length() - 1 || s.charAt(i + 2) != '#') {
				int val = Integer.parseInt(s.substring(i, i + 1)) - 1;
				ans += (char) (val + 'a');
				i++;
			} else {
				int val = Integer.parseInt(s.substring(i, i + 2)) - 1;
				ans += (char) (val + 'a');
				i += 3;
			}
		}
		System.out.println("MyApproach_1 O(N): 30%");
		System.out.println(ans);
	}
}
