package _dsa._java._1Strings;

public class Q1_VIMP_Permutation_Of_Sub_String_Match_Other_String {
	public static void main(String[] args) {
		String big = "cbabcacabca";
		String small = "abc";

		int char_count[] = new int[256];

		for (char ch : small.toCharArray()) {
			char_count[ch] = 1;
		}

		int n = big.length();
		int m = small.length();
		int count = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (i < m) {
				char_count[big.charAt(i)]++;
				if (char_count[big.charAt(i)] == 2)
					count++;
			} else {
				// cbabcacabca
				char_count[big.charAt(i - m)]--;
				if (char_count[big.charAt(i-m)] == 2 || char_count[big.charAt(i-m)] == 0)	// bcoz if 0 .. it neither increase the counter nor decrease
					count += 0;
				else
					count = count == 0 ? 0 : count-1;
				

				char_count[big.charAt(i)]++;
				
				if (char_count[big.charAt(i)] == 2) {
					count++;
				}
			}

			if (count == m) {
				res++;
			}
		}

		System.out.println("Ans: " + res);
	}
}

//					System.out.print(count + "-" + char_count[big.charAt(i)] + ", ");
//				System.out.print(count + " " + big.charAt(i - m) + "=" + char_count[big.charAt(i)] + "/ ");