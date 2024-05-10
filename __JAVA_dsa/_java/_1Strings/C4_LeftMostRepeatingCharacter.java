package _dsa._java._1Strings;

import java.util.Arrays;

public class C4_LeftMostRepeatingCharacter {

	
	static final int CHAR = 256;
	
	public static void main(String[] args) {

		String s = "abccbd";
		System.out.println(s);
		
		// Time - O(n^2) & A.S = O(1)
		int ans1 = naive(s);
		
		// Time - O(n + CHAR) => O(n)   &  A.S =  O(CHAR) => O(1)
				// 2 loop
		int ans2 = better(s);

		// Time - O(n) & A.S = O(1)
				// 1 loop
		int ans3 = efficient_1(s);

		// Time - O(n) & A.S = O(1)
			// 1 loop, traverse from right
		int ans4 = efficient_2(s);
		
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		System.out.println(ans4);
	}
	
	static int naive(String s) {
		for(int i=0; i<s.length(); i++) {
			for(int j = i+1 ; j<s.length(); j++) {
				if(s.charAt(i) == s.charAt(j))
					return i;
			}
		}
		
		return -1;
	}

	
	static int better(String s) {
		
		int count[] = new int[CHAR];
		
		for(int i=0; i<s.length();i++)
			count[s.charAt(i)]++;
		
		for(int i=0; i<s.length();i++) {
			if(count[s.charAt(i)] > 1)
				return i;
		}
		
		return -1;
	}
	
	static int efficient_1(String s) {
		int res = Integer.MAX_VALUE;
		
		int fIndex[] = new int[CHAR];
		
		Arrays.fill(fIndex, -1);
		
		for(int i=0; i<s.length(); i++) {
			int fi = fIndex[s.charAt(i)];
			if(fi == -1) {
				fIndex[s.charAt(i)] = i;
			}
			else {
				res = Math.min(res, fi);
			}
		}
		
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}
	
	
	static int efficient_2(String s) {
		int res = -1;
		boolean visited[] = new boolean[CHAR];
		
		for(int i=s.length()-1; i>=0; i--) {
			
			if(visited[s.charAt(i)] == true)
				res = i;
			else
				visited[s.charAt(i)] = true;
		}
		
		return res;
	}
}
