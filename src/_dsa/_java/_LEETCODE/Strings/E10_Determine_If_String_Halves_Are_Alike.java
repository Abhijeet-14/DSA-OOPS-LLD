package _dsa._java._LEETCODE.Strings;

public class E10_Determine_If_String_Halves_Are_Alike {

	public static void main(String[] args) {
		System.out.println("MyApproach O(N): 99.54%");
		
		System.out.println( myApproach("textbook") );
	}

	public static boolean myApproach(String s) {
		if (s.length() % 2 != 0)
			return false;

		String a = s.substring(0, s.length() / 2);
		String b = s.substring(s.length() / 2, s.length());

		char vowels[] = { 'a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I' };

		int char_count[] = new int[256];

		for (char ch : vowels) {
			char_count[ch] = 1;
		}

		int count_a = 0;
		for (char ch : a.toCharArray()) {
			if (char_count[ch] == 1)
				count_a++;
		}

		int count_b = 0;
		for (char ch : b.toCharArray()) {
			if (char_count[ch] == 1)
				count_b++;
		}

		return count_a == count_b;
	}
}
