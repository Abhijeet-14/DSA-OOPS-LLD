package _dsa._java._LEETCODE.Strings;

/*
 * Question: https://leetcode.com/problems/bulb-switcher-iv/submissions/
 * 
 * Response: TIME-LIMIT-EXCEEDED
 * 
 * Optimized: VERY VERY IMPORTANT
 * 
 */
public class M3_Bulb_Switcher_IV {

	public static void main(String[] args) {
		int val = myApproach("10111");
		System.out.println(val);
		
		int ans = optimized("10111");
		System.out.println(ans);
	}
	
	public static int optimized(String target) {
		System.out.println("Optimized: O(n) \n\t"
				+ "IDEA: prev_status != target_status => we need to CHANGE the status \n\t\t"
					  + "As changing 'i'.. leads to change all (i - N) to status of 'i' \n\t\t"
					  + "So, we don't need to change all index from (i-N).. \n\t\t"
					  + "we just compare the prev_status & target_status.. \n\t\t"
					  + "as CURRENT status is same as prev_status");
		
		System.out.println("Example: \n"
				+ "target = 10111, prev=0 \n"
				+ "1 & 0 => change, prev = 1 \n"
				+ "0 & 1 => change, prev = 0 \n"
				+ "1 & 0 => change, prev = 1 \n"
				+ "1 & 1 => NO change \n"
				+ "1 & 1 => NO change \n"
				+ "CHANGE = 3.. ans = 3");
        char prev = '0';
        int res = 0;
        for (char c : target.toCharArray()) {
            if (c != prev) {
                prev = c;
                res++;
            }
        }
        return res;
    }

	public static int myApproach(String target) {
		System.out.println("MyApproach: TIME-LIMIT-EXCEEDED");
		char initial[] = new char[target.length()];

		for (int i = 0; i < target.length(); i++) {
			initial[i] = '0';
		}

		int count = 0;

		for (int i = 0; i < target.length(); i++) {
			// String curr = new String();
			if (target.equals(String.valueOf(initial)))
				break;

			else if (target.charAt(i) == initial[i]) {
				continue;
			}

			else {
				count++;
				for (int j = i; j < target.length(); j++) {
					if (initial[j] == '0')
						initial[j] = '1';
					else
						initial[j] = '0';
				}
			}
		}

		return count;
	}

}
